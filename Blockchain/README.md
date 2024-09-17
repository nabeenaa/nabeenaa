# Blockchain Trust Fund Smart Contract

## Project Overview
This project is a smart contract for managing a trust fund on the Ethereum blockchain. The smart contract is written in Solidity and implements secure mechanisms to handle deposits, withdrawals, and owner management, ensuring that only authorised users can interact with specific functions. The contract enforces withdrawal limits, time constraints between transactions, and incorporates protection against reentrancy attacks.

Additionally, there is a "Toychain" assignment that demonstrates the creation of blocks on a blockchain, where the miner must adhere to increasing difficulty constraints and avoid forks. Each block contains a miner pseudonym, a nonce, and the SHA-256 hash of the previous block in the chain.

## Project Components

### 1. **Trust Fund Contract (Solidity)**
   The core smart contract defines the following elements:

   - **Owner**: The contract has an owner who controls administrative functions such as changing ownership.
   - **Balances**: The contract maintains a balance sheet that tracks the deposits of each address.
   - **Withdrawal Time**: A mapping tracks the last withdrawal time for each address to ensure that withdrawals can only occur after a specified interval.
   
   **Features:**
   - **Deposits**: Users can deposit Ether into the contract. These deposits are automatically recorded, and events are emitted to track deposit history.
   - **Withdrawals**: Authorised users can withdraw Ether with specific limits:
     - Withdrawals are limited to 1 Ether per transaction.
     - Users can only withdraw after a 30-minute waiting period between withdrawals.
     - Time constraints and balances are enforced to ensure security.
   - **Reentrancy Protection**: The contract uses state updates before external calls to prevent reentrancy attacks.
   - **Owner Functions**: The contract owner can change ownership and has access to additional administrative capabilities.

### 2. **Toychain Block Submission (Blockchain Mining)**
   The second part of the project revolves around a Toychain blockchain mining task where blocks are mined with the following constraints:

   - **Block Properties**:
     - `Previous Hash`: Each new block references the SHA-256 hash of the previous block to maintain the chain's integrity.
     - `Miner Pseudonym`: All blocks are attributed to the same miner pseudonym, ensuring that they belong to a single user.
     - `Nonce`: A randomly generated number used to find a valid hash with the required number of leading zeros.

   - **Blockchain Requirements**:
     - **Single Miner**: Only blocks mined with the user's pseudonym can be added to the chain.
     - **Difficulty Progression**: Each subsequent block must be mined with a higher difficulty than the previous one.
     - **No Forking**: The chain must be continuous with no forks.

### 3. **Smart Contract Methods**

#### `constructor()`
- Initialises the contract by setting the caller as the owner.

#### `onlyOwner` (Modifier)
- Restricts certain functions to be accessible only by the contract owner.

#### `onlyAuthorized` (Modifier)
- Allows only the owner or a specific authorised address to perform certain actions (withdrawals).

#### `timeLimit` (Modifier)
- Enforces a 30-minute waiting period between withdrawals for each user.

#### `receive() external payable`
- The fallback function allows the contract to receive Ether and automatically trigger a deposit.

#### `deposit()`
- Internal function to add deposited Ether to the user's balance.

#### `withdraw(uint256 _amount)`
- Allows an authorised user to withdraw a specified amount of Ether, following balance checks and time restrictions.

#### `changeOwner(address _newOwner)`
- The owner can transfer ownership of the contract to a new address.

### 4. **Events**
- **`Deposit(address indexed _from, uint256 _value)`**: Triggered when a user deposits Ether into the contract.
- **`Withdrawal(address indexed _to, uint256 _value)`**: Triggered when a withdrawal is successfully completed.

### 5. **Attributes**

#### `owner`
- Stores the current owner of the contract. Only the owner can perform administrative tasks like changing ownership.

#### `balances`
- A mapping of user addresses to their respective balances in the contract.

#### `lastWithdrawTime`
- A mapping that records the last withdrawal timestamp for each user to enforce the time limit between withdrawals.

### 6. **Security Considerations**
The smart contract has been designed with several security features:
- **Reentrancy Protection**: Ensures that the contract is not vulnerable to reentrancy attacks by updating the state before making external calls.
- **Access Control**: Utilises modifiers to restrict access to critical functions, limiting them to either the owner or authorised addresses.
- **Withdrawal Limits**: Enforces a maximum withdrawal limit of 1 Ether and a time delay between consecutive withdrawals.

### 7. **Testing**
Testing the contract includes the following steps:
- **Deployment**: Deploy the contract on a test blockchain and ensure that the owner is set correctly.
- **Deposits**: Send Ether to the contract and check that the deposit is reflected in the balance of the sender.
- **Withdrawals**: Test withdrawals with varying amounts, ensuring that only authorised users can withdraw and that limits are enforced.
- **Reentrancy Protection**: Attempt reentrancy attacks to confirm that the contract's protection mechanisms are functioning correctly.
- **Change Ownership**: Verify that the owner can transfer ownership and that the new owner gains administrative privileges.

### 8. **Blockchain Mining Task**

The mining task involves manually submitting blocks to a toychain interface. Each block contains the following attributes:
- **Previous Hash**: Links the block to the existing chain.
- **Miner Pseudonym**: A pseudonym used to track the blocks mined by the user.
- **Nonce**: A random value used to meet the required difficulty for mining the block.

The goal is to mine blocks that follow these constraints and submit them through the webpage interface.

## Conclusion
This project demonstrates a combination of blockchain concepts through a smart contract trust fund and a blockchain mining task. The smart contract is designed to be secure, modular, and extensible, making it a strong foundational component for managing decentralised funds. The mining task reinforces the fundamental concepts of blockchain, including proof-of-work, chain integrity, and non-forking chains.
