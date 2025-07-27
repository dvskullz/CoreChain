# 🔗 Basic Blockchain in Java

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
## 🚀 What’s Next?

Here’s how I plan to scale Deez-Chain into a more complete blockchain system:

| Feature        | Description                                                           |
|----------------|-----------------------------------------------------------------------|
| ✅ Transactions | Add sender, receiver, amount, and digital signature              |
| ✅ Wallets      | Use public/private key pairs to send and receive funds               |
| ✅ Merkle Tree  | Efficiently verify transaction integrity inside a block              |
| 🌐 Networking   | Build a peer-to-peer network using sockets or REST APIs              |
| 🧾 Consensus    | Implement simple consensus algorithms like longest chain or proof-of-stake |
| 🧱 Persistence  | Store blockchain to a file or database for reloading after shutdown  |
| 📉 Web UI       | Use JavaFX or a lightweight web server (like SparkJava) for frontend |
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
