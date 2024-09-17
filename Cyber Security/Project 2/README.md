# Static Information Flow Control (IFC) Type-Checker

## Project Overview

This project implements a type-checker for Static Information Flow Control (IFC) as part of an assessment to reinforce understanding of IFC concepts. The type-checker is based on a previously implemented type-checker, with added support for information flow control. The primary goal is to verify that the flow of sensitive information in a system adheres to security policies, ensuring that confidential data is handled appropriately according to its security labels.

### Goals
1. **Implement an IFC Type-Checker**: Extend an existing type-checker to handle information flow cases.
2. **Support Specific Cases**: Implement IFC checks for lambda abstraction, application, conditional expressions (if-else), and addition operations.

## Code Implementation

The provided code includes the following components:

### Data Types and Functions
- **Secret Keys and Public Keys**
  - `type skey` - Type for secret keys.
  - `type pkey` - Type for public keys.
  - `fun pk(skey) : pkey` - Constructor that converts a secret key to a public key.

- **Asymmetric Encryption and Decryption**
  - `fun aenc(bitstring, pkey) : bitstring` - Encrypts a bitstring with a public key.
  - `reduc forall m : bitstring, k : skey; adec(aenc(m, pk(k)), k) = m` - Decryption rule for asymmetric encryption.

- **Shared Key Encryption**
  - `fun senc(bitstring, skey) : bitstring` - Encrypts a bitstring with a secret key.
  - `reduc forall m : bitstring, k : skey; sdec(senc(m, k), k) = m` - Decryption rule for shared key encryption.

- **Pack and Unpack**
  - `fun pack(bitstring, bitstring) : bitstring` - Combines two bitstrings and encrypts them.
  - `reduc forall x : bitstring, y : bitstring; unpack(pack(x,y)) = (x,y)` - Decrypts the packed bitstring.

### Processes
- **Process Definitions**
  - `procA(pkB : pkey)` - Represents the actions of Alice, including packing, encrypting, and sending messages.
  - `procB(pkA : pkey)` - Represents the actions of Bob, including receiving, decrypting, and responding with messages.

- **Main Process**
  - Initialises public keys for Alice and Bob.
  - Executes `procA` and `procB` in parallel, ensuring secure communication via the `c` channel.

### Security Labels
- **Variables**
  - `free Alice : bitstring` - Public information for Alice.
  - `free Bob : bitstring` - Public information for Bob.
  - `free AliceSecretKey : skey [private]` - Secret key for Alice.
  - `free BobSecretKey : skey [private]` - Secret key for Bob.

### Analysis
- **ProVerif Output**
  - A query was performed to check if `Na` (a nonce) could be obtained by an attacker.
  - The output confirmed that the attacker could indeed access `Na` due to its transmission in plaintext, highlighting the need for improved nonce protection.

## Methods

### IFC Type-Checking
The type-checker verifies that operations within the process adhere to IFC principles:
- **Lambda Case**: Ensures lambda abstractions handle information securely.
- **Application Case**: Checks that information flows correctly through function applications.
- **If-Else Case**: Validates that conditional expressions do not improperly leak sensitive information.
- **Plus Case**: Ensures that addition operations maintain secure information flow.

### ProVerif Analysis
ProVerif was used to analyse the security of the processes:
- **Query**: `not attacker(Na[])` - Checks if the nonce `Na` is protected from attackers.
- **Results**: Confirmed that the protocol's structure allows for exposure of `Na`, indicating a potential security weakness.

## Tests

### Unit Tests
- **Encryption and Decryption**: Ensure that encryption and decryption functions work as expected and preserve data integrity.
- **Pack and Unpack**: Verify that data packed and unpacked correctly maintains the original information.

### Security Testing
- **Information Flow Analysis**: Use ProVerif to check if sensitive information is exposed or leaked inappropriately.
- **Nonce Protection**: Validate that nonces are not leaked and are securely handled in communication processes.

## Components

### Security Labels
- **Public Information**: Data that can be shared openly.
- **Private Information**: Sensitive data that must be protected from unauthorised access.

### Channels
- **`c`**: Channel used for secure communication between processes.
- **`c2`**: Channel used for distributing public keys.

### Functions
- **`pk`, `aenc`, `adec`, `pack`, `unpack`, `senc`, `sdec`**: Cryptographic functions used for secure communication and data handling.

## Conclusion

This project demonstrates the application of static information flow control principles in a practical context, using a type-checker to ensure secure handling of sensitive information in a concurrent system. The implementation provides a foundation for understanding and enforcing security policies in information systems, with a focus on encryption, decryption, and secure communication processes.

For further details or contributions, please refer to the code and analysis provided in this repository.


