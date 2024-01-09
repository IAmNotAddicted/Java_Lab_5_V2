Bank System Simulation
This Java program simulates a simplified banking system, focusing on robust error handling and exception management. The system includes the creation of bank accounts, financial operations, and account summaries.

Classes
1. BankAccount
This class represents a bank account and includes the following members:

accountNumber: Unique identifier for the account.
accountName: Name associated with the account.
balance: Current balance of the account.
Implemented methods:

deposit(double amount): Deposit a specified amount into the account.
withdraw(double amount): Withdraw a specified amount from the account.
getBalance(): Retrieve the current balance.
getAccountSummary(): Retrieve a summary of the account details.
2. InsufficientFundsException
Custom exception class for handling cases where a financial operation cannot be completed due to insufficient funds.

3. NegativeAmountException
Custom exception class for handling cases where a financial operation involves a negative amount.

4. AccountNotFoundException
Custom exception class for handling cases where a requested account cannot be found.

5. Bank
This class manages a collection of BankAccount objects and includes methods for:

createAccount(String accountName, double initialDeposit): Create a new bank account with an initial deposit.
findAccount(int accountNumber): Find and retrieve a bank account by its account number.
transferMoney(int fromAccountNumber, int toAccountNumber, double amount): Transfer a specified amount of money between two accounts.
Exception Handling
The specialized exception classes are utilized to handle specific error scenarios gracefully. Each method in the Bank class is designed to propagate and catch these exceptions, ensuring a reliable and fault-tolerant banking system.

Testing
The project includes a set of test classes where various scenarios are modeled to thoroughly test the exception handling mechanisms. These tests cover deposit, withdrawal, account creation, and fund transfers, ensuring the program's robustness in handling diverse situations.

Feel free to explore the code and run the provided test cases to observe the effective management of exceptions in the banking system simulation.
