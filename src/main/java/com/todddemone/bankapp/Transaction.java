package com.todddemone.bankapp;

public class Transaction {

    public enum TransactionType {
        DEPOSIT,
        WITHDRAWAL
    }

    private double amount;
    private TransactionType transactionType;

    public Transaction (TransactionType type, double amount) {
        this.amount = amount;
        this.transactionType = type;
    }

    public double getAmount() {
        return this.amount;
    }

    public TransactionType getTransactionType() {
        return this.transactionType;
    }

    @Override
    public String toString() {
        String result = String.format("%s:\t$%8.2f", this.getTransactionType(), this.getAmount());
        return result;
    }
}