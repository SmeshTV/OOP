package main;

import java.util.Scanner;

public class Quadratic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("a = ");   double a = sc.nextDouble();
        System.out.print("b = ");   double b = sc.nextDouble();
        System.out.print("c = ");   double c = sc.nextDouble();

        double discriminant = b * b - 4 * a * c;

        if (a == 0) {
            System.out.println("Это не квадратное уравнение!");
            return;
        }

        if (discriminant < 0) {
            System.out.println("Дискриминант отрицательный, корней нет");
        } 
        else if (discriminant == 0) {
            double x = -b / (2 * a);
            System.out.printf("Один корень: x = %.4f\n", x);
        } 
        else {
            double sqrtD = Math.sqrt(discriminant);
            
            double x1 = (-b + sqrtD) / (2 * a);
            double x2 = (-b - sqrtD) / (2 * a);

            System.out.printf("x1 = %.4f\n", x1);
            System.out.printf("x2 = %.4f\n", x2);
        }
    }
}