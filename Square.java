package main;

import java.util.Scanner;

public class Square {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Сторона квадрата a: ");
        double a = scanner.nextDouble();
        
        if (a <= 0) {
            System.out.println("Сторона должна быть > 0");
            return;
        }
        
        double area = a * a;
        double perimeter = 4 * a;
        double diagonal = a * Math.sqrt(2);
        
        System.out.printf("Площадь    : %.2f%n", area);
        System.out.printf("Периметр   : %.2f%n", perimeter);
        System.out.printf("Диагональ  : %.2f%n", diagonal);
    }
}