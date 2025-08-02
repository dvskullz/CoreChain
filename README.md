# ⛓️ CoreChain – Java Blockchain 🔐

This is a **basic blockchain implementation in Java**, created to demonstrate the core concepts of blockchain technology such as block structure, proof of work, hashing, and chain validation.

---
## ✨ Features

- 📦 **Block Structure**: Each block stores data, a timestamp, a unique hash, and the hash of the previous block.
- 🔐 **Hash Linking**: Blocks are cryptographically linked using SHA-256 hashes, forming a secure chain.
- ⛏️ **Proof of Work**: Includes a mining mechanism that requires computational effort (difficulty level) to validate new blocks.
- 🧪 **Validation**: Chain can be verified for tampering by checking the hashes and digital signatures.
---
## 📁 Project Structure
<pre>
CoreChain/
├── src/
│   ├── Block.java              # Represents a block with transactions and PoW mining
│   ├── CoreChain.java          # Main class to initialize blockchain, wallets, and validate chain
│   ├── StringUtil.java         # Utility functions: SHA-256 hashing, ECDSA signature, Merkle root
│   ├── Transaction.java        # Handles transactions: inputs/outputs, signatures, and processing
│   ├── TransactionInputs.java  # Refers to unspent outputs used in a transaction
│   ├── TransactionOutputs.java # Represents unspent outputs (UTXOs) owned by a public key
│   ├── Wallet.java             # Generates key pairs, manages UTXOs, and creates signed transactions
├── .gitignore
├── CoreChain.iml
└── Readme.md
</pre>

## 📚 Concepts Demonstrated

| Concept               | Description                                                                 |
|-----------------------|-----------------------------------------------------------------------------|
| 🧱 Block Structure     | Blocks contain index, timestamp, data, previous hash, hash, and nonce       |
| ⛏️ Proof of Work        | Requires correct hash with a given number of leading zeroes (difficulty)   |
| 🔐 Hashing (SHA-256)   | Uses Java’s built-in MessageDigest to generate cryptographic hashes         |
| 🛡️ Tamper Detection    | Any change in block data breaks the hash chain, making tampering detectable |

---
## ✅ Supported Features

| Feature                  | Description                                                                |
|--------------------------|-----------------------------------------------------------------------------|
| ✅ **Transactions**       | With sender, receiver, amount, and **input/output** logic                  |
| ✅ **Wallets**            | Use **Elliptic Curve Cryptography (ECC)** for key generation               |
| ✅ **Digital Signatures** | All transactions are signed and verified with public/private keys          |
| ✅ **Proof of Work**      | Mining blocks using a difficulty-based hashing challenge                   |
| ✅ **UTXO model**         | Like Bitcoin, using unspent outputs for balance and transaction validation |
| ✅ **Chain Validation**   | Full blockchain integrity check with hash + signature + UTXO replay        |

---

## ▶️ How to Run
 <pre>
1. **Clone the repository:**
   
    https://github.com/dvskullz/CoreChain.git

    cd CoreChain

2. **Compile all files:**

    javac *.java

3. **Run the main:**

    java CoreChain

4. The console will display the creation of blocks, their hashes, and validation status.
</pre>


