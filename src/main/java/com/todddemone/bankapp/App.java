package com.todddemone.bankapp;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            Account account = new Account(500);
            // Account account2 = new Account(-500);
            System.out.printf("Account balance: $%.2f\n", account.getBalance());
            // account.deposit(-1);
            account.deposit(356);
            System.out.printf("Account balance: $%.2f\n", account.getBalance());
            account.withdraw(760);
            System.out.printf("Account balance: $%.2f\n", account.getBalance());
            // account.withdraw(-1);
            // account.withdraw(0);
            account.withdraw(50);
            System.out.printf("Account balance: $%.2f\n", account.getBalance());
            account.deposit(2);
            System.out.printf("Account balance: $%.2f\n", account.getBalance());
            account.printTransactions();
            account.withdraw(999);
            System.out.printf("Account balance: $%.2f\n", account.getBalance());
    
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
