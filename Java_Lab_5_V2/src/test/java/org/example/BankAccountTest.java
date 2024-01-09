package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void testGetAccountNumber() {
        BankAccount account = new BankAccount(123, "John Doe", 1000);
        assertEquals(123, account.getAccountNumber());
    }

    @Test
    void testDeposit() {
        try {
            BankAccount account = new BankAccount(456, "Jane Doe", 500);
            account.deposit(200);
            assertEquals(700, account.getBalance(), 0.01);
        } catch (NegativeAmountException e) {
            fail("Unexpected NegativeAmountException");
        }
    }

    @Test
    void testWithdraw() {
        try {
            BankAccount account = new BankAccount(789, "Test User", 1000);
            account.withdraw(300);
            assertEquals(700, account.getBalance(), 0.01);
        } catch (NegativeAmountException | InsufficientFundsException e) {
            fail("Unexpected exception");
        }
    }

    @Test
    void testGetBalance() {
        BankAccount account = new BankAccount(111, "John Smith", 1500);
        assertEquals(1500, account.getBalance(), 0.01);
    }

    @Test
    void testGetAccountSummary() {
        BankAccount account = new BankAccount(222, "Alice Johnson", 800);
        String expectedSummary = "Account Number: 222\nAccount Name: Alice Johnson\nBalance: 800.0";
        assertEquals(expectedSummary, account.getAccountSummary());
    }

    @Test
    void testNegativeDeposit() {
        BankAccount account = new BankAccount(333, "Negative Test", 100);
        assertThrows(NegativeAmountException.class, () -> account.deposit(-50));
    }

    @Test
    void testNegativeWithdrawal() {
        BankAccount account = new BankAccount(444, "Negative Test", 200);
        assertThrows(NegativeAmountException.class, () -> account.withdraw(-50));
    }

    @Test
    void testInsufficientFundsWithdrawal() {
        BankAccount account = new BankAccount(555, "Insufficient Funds Test", 50);
        assertThrows(InsufficientFundsException.class, () -> account.withdraw(100));
    }
}
