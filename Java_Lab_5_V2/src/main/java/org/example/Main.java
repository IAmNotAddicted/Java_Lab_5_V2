package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) {
        try {
            Bank bank = new Bank();

            BankAccount account1 = bank.createAccount("John Doe", 1000);
            BankAccount account2 = bank.createAccount("Jane Doe", 500);

            System.out.println("Before transfer:");
            System.out.println(account1.getAccountSummary());
            System.out.println(account2.getAccountSummary());

            bank.transferMoney(account1.getAccountNumber(), account2.getAccountNumber(), 200);

            System.out.println("\nAfter transfer:");
            System.out.println(account1.getAccountSummary());
            System.out.println(account2.getAccountSummary());

        } catch (NegativeAmountException | InsufficientFundsException | AccountNotFoundException e) {
            e.printStackTrace();
        }
    }
}