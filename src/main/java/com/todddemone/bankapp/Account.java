package com.todddemone.bankapp;

import java.util.ArrayList;
import java.util.List;


public class Account {
    private double balance;
    private List<Transaction> transactions;

    public Account() {
        this.balance = 0;
        this.transactions = new ArrayList<Transaction>();
    }

    public Account(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
            this.transactions = new ArrayList<Transaction>();
        } else {
            this.balance = 0;
            this.transactions = new ArrayList<Transaction>();
            throw new IllegalArgumentException("Initial balance cannot be negative. Setting balance to 0.");
        }
    }

    /**
     * Get the current bank account balance
     * @return the current balance
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Print a list of previous transactions for this account
     */
    public void printTransactions() {
        System.out.println("Transaction History:");
        for (Transaction transaction: this.transactions) {
            System.out.println(transaction);
        }
    }

    /**
     * Deposit the specified amount into the account
     * @param amount the amount to be deposited
     * @throws IllegalArgumentException if deposit amount is not a positive number
     */
    public void deposit(double amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        } else {
            this.transactions.add(new Transaction(Transaction.TransactionType.DEPOSIT, amount));
            this.balance += amount;
        }
    }

    /**
     * Withdraw the specified amount from the account
     * @param amount the amount to be withdrawn
     * @throws InsufficientFundsException if the withdrawn amount is greater than the current balance.
     * @throws IllegalArgumentException if the withdrawn amount is not a positive number
     */
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > this.balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }
        this.transactions.add(new Transaction(Transaction.TransactionType.WITHDRAWAL, amount));
        this.balance -= amount;
    }
}