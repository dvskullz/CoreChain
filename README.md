# ⛓️ Deez-Chain – Java Blockchain 🔐

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
Deez-Chain/
├── src/
│ ├── Block.java              # Defines the structure of each block
│ ├── deezChain.java          # Main class to run and test the blockchain
│ ├── StringUtil.java         # Helper methods (e.g., SHA-256 hashing, difficulty prefix)
├── .gitignore
├── Deez-Chain.iml
└── Readme.md
</pre>
---
## 📚 Concepts Demonstrated

| Concept               | Description                                                                 |
|-----------------------|-----------------------------------------------------------------------------|
| 🧱 Block Structure     | Blocks contain index, timestamp, data, previous hash, hash, and nonce       |
| ⛏️ Proof of Work        | Requires correct hash with a given number of leading zeroes (difficulty)   |
| 🔐 Hashing (SHA-256)   | Uses Java’s built-in MessageDigest to generate cryptographic hashes         |
| 🛡️ Tamper Detection    | Any change in block data breaks the hash chain, making tampering detectable |

---
## ⚙️ Want to Scale It

May refactor or expand this down the line

| Feature        | Description                                                           |
|----------------|-----------------------------------------------------------------------|
| ✅ Transactions | Add sender, receiver, amount, and digital signature              |
| ✅ Wallets      | Use public/private key pairs to provides wallets using Elliptic-Curve cryptography.             |
| ✅ Security     | Secures the transfer of funds, by using a digital signature algorithm to prove ownership.|
---

## ▶️ How to Run
 <pre>
1. **Clone the repository:**
   
    https://github.com/dvskullz/Dee-Chain.git

    cd Deez-Chain

2. **Compile all files:**

    javac *.java

3. **Run the main:**

    java deezChain

4. The console will display the creation of blocks, their hashes, and validation status.
</pre>

## Output
<pre>
 Trying to Mine block 1... 
Block Mined!!! : 0000031d57dac136fe4fc0e11506f999d618fb2ba044f31c8018e8b51b21b49f
Trying to Mine block 2... 
Block Mined!!! : 00000125ae9c86ccd8e5dd3ac859e6364695b5f6cf4aa404cd8b60697b266ea8
Trying to Mine block 3... 
Block Mined!!! : 00000cd2785bcba9b3130c18bd14454ed427ed97427b924667701a5ed962a557

Blockchain is Valid: true

The block chain: 
[
  {
    "hash": "0000031d57dac136fe4fc0e11506f999d618fb2ba044f31c8018e8b51b21b49f",
    "previousHash": "0",
    "data": "Hi im the first block",
    "timeStamp": 1753642607389,
    "nonce": 724771
  },
  {
    "hash": "00000125ae9c86ccd8e5dd3ac859e6364695b5f6cf4aa404cd8b60697b266ea8",
    "previousHash": "0000031d57dac136fe4fc0e11506f999d618fb2ba044f31c8018e8b51b21b49f",
    "data": "Yo im the second block",
    "timeStamp": 1753642608151,
    "nonce": 67486
  },
  {
    "hash": "00000cd2785bcba9b3130c18bd14454ed427ed97427b924667701a5ed962a557",
    "previousHash": "00000125ae9c86ccd8e5dd3ac859e6364695b5f6cf4aa404cd8b60697b266ea8",
    "data": "Hey im the third block",
    "timeStamp": 1753642608227,
    "nonce": 776357
  }
]
</pre>
