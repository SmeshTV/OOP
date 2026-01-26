package main;

public class Interest {
    public static void main(String[] args) {
        double balance = 150000;
        double rate = 0.085; 

        double interest = balance * rate;
        double newBalance = balance + interest;

        System.out.printf("Начальный баланс  : %,.0f ₸\n", balance);
        System.out.printf("Начисленные %%     : %,.0f ₸\n", interest);
        System.out.printf("Новый баланс       : %,.0f ₸\n", newBalance);
    }
}