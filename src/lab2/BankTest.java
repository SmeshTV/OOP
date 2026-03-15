package lab2;

import java.util.Vector;

public class BankTest {

    static class Account {
        private double balance;
        private int accNumber;

        public Account(int accNumber) {
            this.accNumber = accNumber;
            this.balance = 0.0;
        }

        public void deposit(double amount) {
            if (amount > 0) balance += amount;
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) balance -= amount;
        }

        public double getBalance() {
            return balance;
        }

        public int getAccountNumber() {
            return accNumber;
        }

        public void transfer(double amount, Account other) {
            if (amount > 0 && amount <= balance) {
                withdraw(amount);
                other.deposit(amount);
            }
        }

        @Override
        public String toString() {
            return String.format("Account #%d : $%.2f", accNumber, balance);
        }
    }

    static class SavingsAccount extends Account {
        private double interestRate;

        public SavingsAccount(int accNumber, double interestRate) {
            super(accNumber);
            this.interestRate = interestRate;
        }

        public void addInterest() {
            deposit(getBalance() * interestRate / 100);
        }

        @Override
        public String toString() {
            return "Savings" + super.toString().substring(7) + " (rate " + interestRate + "%)";
        }
    }

    static class CheckingAccount extends Account {
        private int transactions;
        private static final int FREE_TRANSACTIONS = 3;
        private static final double FEE = 0.02;

        public CheckingAccount(int accNumber) {
            super(accNumber);
            transactions = 0;
        }

        @Override
        public void deposit(double amount) {
            super.deposit(amount);
            transactions++;
            deductFeeIfNeeded();
        }

        @Override
        public void withdraw(double amount) {
            super.withdraw(amount);
            transactions++;
            deductFeeIfNeeded();
        }

        private void deductFeeIfNeeded() {
            if (transactions > FREE_TRANSACTIONS) {
                super.withdraw(FEE);
            }
        }

        @Override
        public String toString() {
            return "Checking" + super.toString().substring(7) + " (trans=" + transactions + ")";
        }
    }

    static class Bank {
        private Vector<Account> accounts = new Vector<>();

        public void addAccount(Account a) {
            accounts.add(a);
        }

        public void update() {
            for (Account acc : accounts) {
                if (acc instanceof SavingsAccount) {
                    ((SavingsAccount) acc).addInterest();
                }
            }
        }

        public void printAll() {
            for (Account a : accounts) {
                System.out.println(a);
            }
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();

        Account a1 = new Account(101);
        SavingsAccount s1 = new SavingsAccount(102, 2.5);
        CheckingAccount c1 = new CheckingAccount(103);

        a1.deposit(1000);
        s1.deposit(2000);
        c1.deposit(500);

        bank.addAccount(a1);
        bank.addAccount(s1);
        bank.addAccount(c1);

        System.out.println("Before update:");
        bank.printAll();

        bank.update();

        System.out.println("\nAfter update (interest added):");
        bank.printAll();
    }
}