package lab1;

import java.util.Scanner;

class Data {
    private int count;
    private double sum;
    private double max;

    Data() {
        sum = 0.0;
        count = 0;
        max = Double.NEGATIVE_INFINITY;
    }

    void add(double value) {
        sum += value;
        count++;
        if (value > max) {
            max = value;
        }
    }

    double getAverage() {
        if (count == 0) return 0.0;
        return sum / count;
    }

    double getMaximum() {
        if (count == 0) return Double.NEGATIVE_INFINITY;
        return max;
    }

    boolean isEmpty() {
        return count == 0;
    }
}

public class Analyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Data data = new Data();

        while (true) {
            System.out.print("Enter number (Q to quit): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("Q")) {
                break;
            }

            try {
                double number = Double.parseDouble(input);
                data.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Error: please enter a number or Q");
            }
        }

        scanner.close();

        if (data.isEmpty()) {
            System.out.println("No numbers were entered.");
        } else {
            System.out.printf("Average = %.1f%n", data.getAverage());
            System.out.printf("Maximum = %.1f%n", data.getMaximum());
        }
    }
}