// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract TrustFund {
    address public owner;
    mapping(address => uint256) public balances;
    mapping(address => uint256) public lastWithdrawTime;

    event Deposit(address indexed _from, uint256 _value);
    event Withdrawal(address indexed _to, uint256 _value);

    // Constructor to set the owner
    constructor() {
        owner = msg.sender;
    }

    // Modifier to only allow owner to call certain functions
    modifier onlyOwner() {
        require(msg.sender == owner, "Only the owner can call this function");
        _;
    }

    // Modifier to allow owner and specific address to call certain functions
    modifier onlyAuthorized() {
        require(
            msg.sender == owner || 
            msg.sender == 0x3cC92b7496571fC479EB4714784a6839CD3e57f2, 
            "Unauthorized"
        );
        _;
    }

    // Modifier to enforce time limit between withdrawals
    modifier timeLimit() {
        require(
            block.timestamp >= lastWithdrawTime[msg.sender] + 30 minutes, 
            "30 minutes has not passed yet"
        );
        _;
    }

    // Fallback function to receive Ether
    receive() external payable {
        deposit();
    }

    // Internal function to deposit SepETH
    function deposit() internal {
        require(msg.value > 0, "Amount must be greater than 0");
        balances[msg.sender] += msg.value;
        emit Deposit(msg.sender, msg.value);
    }

    // Function to withdraw SepETH
    function withdraw(uint256 _amount) external onlyAuthorized timeLimit {
        require(_amount > 0, "Invalid amount");
        require(_amount <= balances[msg.sender], "Insufficient balance");
        require(_amount <= 1 ether, "Exceeds withdrawal limit");

        balances[msg.sender] -= _amount;
        lastWithdrawTime[msg.sender] = block.timestamp;

        // Reentrancy protection by updating state before transfer
        uint256 balanceBeforeTransfer = address(this).balance;
        (bool success, ) = msg.sender.call{value: _amount}("");
        require(success, "Transfer failed");
        assert(address(this).balance == balanceBeforeTransfer - _amount);

        emit Withdrawal(msg.sender, _amount);
    }

    // Function to change the owner
    function changeOwner(address _newOwner) external onlyOwner {
        require(_newOwner != address(0), "Invalid address");
        owner = _newOwner;
    }
}
