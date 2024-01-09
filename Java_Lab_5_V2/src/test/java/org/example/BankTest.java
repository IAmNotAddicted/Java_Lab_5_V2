package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    void testCreateAccount() {
        Bank bank = new Bank();
        BankAccount account = bank.createAccount("John Doe", 1000);
        assertNotNull(account);
        assertEquals("John Doe", account.getAccountNumber());
        assertEquals(1000, account.getBalance(), 0.01);
    }

    @Test
    void testFindAccount() {
        Bank bank = new Bank();
        BankAccount account = bank.createAccount("Jane Doe", 500);
        try {
            BankAccount foundAccount = bank.findAccount(account.getAccountNumber());
            assertNotNull(foundAccount);
            assertEquals(account, foundAccount);
        } catch (AccountNotFoundException e) {
            fail("Unexpected AccountNotFoundException");
        }
    }

    @Test
    void testTransferMoney() {
        Bank bank = new Bank();
        BankAccount account1 = bank.createAccount("Test User 1", 1000);
        BankAccount account2 = bank.createAccount("Test User 2", 500);

        try {
            bank.transferMoney(account1.getAccountNumber(), account2.getAccountNumber(), 200);
            assertEquals(800, account1.getBalance(), 0.01);
            assertEquals(700, account2.getBalance(), 0.01);
        } catch (NegativeAmountException | InsufficientFundsException | AccountNotFoundException e) {
            fail("Unexpected exception");
        }
    }

    @Test
    void testTransferMoneyNegativeAmount() {
        Bank bank = new Bank();
        BankAccount account1 = bank.createAccount("Test User 1", 1000);
        BankAccount account2 = bank.createAccount("Test User 2", 500);

        assertThrows(NegativeAmountException.class,
                () -> bank.transferMoney(account1.getAccountNumber(), account2.getAccountNumber(), -200));
    }

    @Test
    void testTransferMoneyInsufficientFunds() {
        Bank bank = new Bank();
        BankAccount account1 = bank.createAccount("Test User 1", 1000);
        BankAccount account2 = bank.createAccount("Test User 2", 500);

        assertThrows(InsufficientFundsException.class,
                () -> bank.transferMoney(account1.getAccountNumber(), account2.getAccountNumber(), 1200));
    }

    @Test
    void testTransferMoneyAccountNotFound() {
        Bank bank = new Bank();
        BankAccount account1 = bank.createAccount("Test User 1", 1000);

        assertThrows(AccountNotFoundException.class,
                () -> bank.transferMoney(account1.getAccountNumber(), 999, 200));
    }
}
