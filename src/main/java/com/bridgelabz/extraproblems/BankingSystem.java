package com.bridgelabz.extraproblems;

import java.util.*;

class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Account: %s, Balance: $%.2f", accountNumber, balance);
    }
}

class BankManager {

    private Map<String, Account> accounts = new HashMap<>();               // AccountNumber -> Account
    private TreeMap<Double, List<Account>> balanceSortedAccounts = new TreeMap<>(); // Sorted by balance
    private Queue<String> withdrawalQueue = new LinkedList<>();            // Queue for withdrawals

    // Create a new account
    public void createAccount(String accountNumber, double initialBalance) {
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account already exists.");
            return;
        }

        Account account = new Account(accountNumber, initialBalance);
        accounts.put(accountNumber, account);

        // Add to TreeMap for sorting by balance
        balanceSortedAccounts
                .computeIfAbsent(initialBalance, k -> new ArrayList<>())
                .add(account);
    }

    // Deposit into an account
    public void deposit(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            removeFromTreeMap(account);
            account.deposit(amount);
            addToTreeMap(account);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Queue a withdrawal request
    public void requestWithdrawal(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.offer(accountNumber);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Process withdrawal requests
    public void processWithdrawals(double amount) {
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            Account account = accounts.get(accountNumber);

            if (account != null) {
                if (account.withdraw(amount)) {
                    System.out.printf("Withdrawal successful: $%.2f from %s\n", amount, accountNumber);
                    removeFromTreeMap(account);
                    addToTreeMap(account);
                } else {
                    System.out.printf("Insufficient balance in %s\n", accountNumber);
                }
            }
        }
    }

    // Display all accounts
    public void displayAccounts() {
        System.out.println("\n--- All Accounts ---");
        for (Account account : accounts.values()) {
            System.out.println(account);
        }
    }

    // Display accounts sorted by balance
    public void displaySortedAccounts() {
        System.out.println("\n--- Accounts Sorted by Balance ---");
        for (Map.Entry<Double, List<Account>> entry : balanceSortedAccounts.entrySet()) {
            for (Account account : entry.getValue()) {
                System.out.println(account);
            }
        }
    }

    // Helper methods to maintain balance sorting
    private void addToTreeMap(Account account) {
        balanceSortedAccounts
                .computeIfAbsent(account.getBalance(), k -> new ArrayList<>())
                .add(account);
    }

    private void removeFromTreeMap(Account account) {
        List<Account> accountsWithBalance = balanceSortedAccounts.get(account.getBalance());
        if (accountsWithBalance != null) {
            accountsWithBalance.remove(account);
            if (accountsWithBalance.isEmpty()) {
                balanceSortedAccounts.remove(account.getBalance());
            }
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) {

        BankManager bank = new BankManager();

        // Creating accounts
        bank.createAccount("1001", 5000.0);
        bank.createAccount("2002", 3000.0);
        bank.createAccount("3003", 7000.0);
        bank.createAccount("4004", 4000.0);

        // Displaying all accounts
        bank.displayAccounts();
        bank.displaySortedAccounts();

        // Deposits
        System.out.println("\n--- Depositing $1000 to 2002 ---");
        bank.deposit("2002", 1000.0);

        // Display updated accounts
        bank.displayAccounts();
        bank.displaySortedAccounts();

        // Withdrawal Requests
        System.out.println("\n--- Queuing Withdrawals ---");
        bank.requestWithdrawal("1001");
        bank.requestWithdrawal("3003");
        bank.requestWithdrawal("2002");

        // Processing Withdrawals
        System.out.println("\n--- Processing $2000 Withdrawals ---");
        bank.processWithdrawals(2000.0);

        // Display final accounts
        bank.displayAccounts();
        bank.displaySortedAccounts();
    }
}