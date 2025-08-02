public class TransactionInputs {
        public String transactionOutputId; //Reference to TransactionOutputs -> transactionId
        public TransactionOutputs UTXO; //Contains the Unspent transaction output
    public String transactionOutputsId;

    public TransactionInputs(String transactionOutputId) {
            this.transactionOutputId = transactionOutputId;
        }
    }

