import java.security.*;
import java.util.ArrayList;


public class Transaction {


    public String transactionId; // this is also the hash of the transaction.
    public PublicKey sender; // senders address/public key.
    public PublicKey recipient; // Recipients address/public key.
    public float value;
    public byte[] signature; // this is to prevent anybody else from spending funds in our wallet.

    public ArrayList<TransactionInputs> inputs = new ArrayList<TransactionInputs>();
    public ArrayList<TransactionOutputs> outputs = new ArrayList<TransactionOutputs>();

//    public ArrayList<TransactionInputs> inputs = new ArrayList<TransactionInputs>();
//    public ArrayList<TransactionOutputs> outputs = new ArrayList<TransactionOutputs>();

    private static int sequence = 0; // a rough count of how many transactions have been generated.

    // Constructor:
    public Transaction(PublicKey from, PublicKey to, float value, ArrayList<TransactionInputs> inputs) {
        this.sender = from;
        this.recipient = to;
        this.value = value;

        if (inputs == null) {
            this.inputs = new ArrayList<>();
        } else {
            this.inputs = inputs;
        }
    }

    // This Calculates the transaction hash (which will be used as its Id)
    private String calculateHash() {
        sequence++; //increase the sequence to avoid 2 identical transactions having the same hash
        return StringUtil.applySha256(
                StringUtil.getStringFromKey(sender) +
                        StringUtil.getStringFromKey(recipient) +
                        Float.toString(value) + sequence
        );
    }

    //Signs all the data we dont wish to be tampered with.
    public void generateSignature(PrivateKey privateKey) {
        String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(recipient) + Float.toString(value);
        signature = StringUtil.applyECDSASig(privateKey, data);
    }

    //Verifies the data we signed hasnt been tampered with
    public boolean verifySignature() {
        String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(recipient) + Float.toString(value);
        return StringUtil.verifyECDSASig(sender, data, signature);

    }
    //Returns true if new transaction could be created.
    public boolean processTransaction() {

        if(verifySignature() == false) {
            System.out.println("#Transaction Signature failed to verify");
            return false;
        }

        //gather transaction inputs (Make sure they are unspent):
        for(TransactionInputs i : inputs) {
            i.UTXO = CoreChain.UTXOs.get(i.transactionOutputId);
        }

        //check if transaction is valid:
        if(getInputsValue() < CoreChain.minimumTransaction) {
            System.out.println("#Transaction Inputs to small: " + getInputsValue());
            return false;
        }

        //generate transaction outputs:
        float leftOver = getInputsValue() - value; //get value of inputs then the left over change:
        transactionId =  calculateHash();
        outputs.add(new TransactionOutputs( this.recipient, value,transactionId)); //send value to recipient
        outputs.add(new TransactionOutputs( this.sender, leftOver,transactionId)); //send the left over 'change' back to sender

        //add outputs to Unspent list
        for(TransactionOutputs o : outputs) {
            CoreChain.UTXOs.put(o.id , o);
        }

        //remove transaction inputs from UTXO lists as spent:
        for(TransactionInputs i : inputs) {
            if(i.UTXO == null) continue; //if Transaction can't be found skip it
            CoreChain.UTXOs.remove(i.UTXO.id);
        }

        return true;
    }

    //returns sum of inputs(UTXOs) values
    public float getInputsValue() {
        float total = 0;
//        if (inputs == null) return 0; //
        for(TransactionInputs i : inputs) {
            if(i.UTXO == null) continue; //if Transaction can't be found skip it
            total += i.UTXO.value;
        }
        return total;
    }

    //returns sum of outputs:
    public float getOutputsValue() {
        float total = 0;
        for(TransactionOutputs o : outputs) {
            total += o.value;
        }
        return total;
    }

}
