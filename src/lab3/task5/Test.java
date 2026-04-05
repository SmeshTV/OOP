package lab3.task5;

import task4.Employee;
import java.time.LocalDateTime;

public class Test {
    public static void main(String[] args) {

        // Chocolates
        Chocolate[] chocolates = {
                new Chocolate("Twix", 50),
                new Chocolate("Snickers", 70),
                new Chocolate("Mars", 60)
        };

        Sort.bubbleSort(chocolates);

        System.out.println("Sorted Chocolates:");
        for (Chocolate c : chocolates) {
            System.out.println(c);
        }

        // Time
        Time[] times = {
                new Time(12, 30),
                new Time(9, 15),
                new Time(18, 45)
        };

        Sort.mergeSort(times);

        System.out.println("\nSorted Times:");
        for (Time t : times) {
            System.out.println(t);
        }

        // Employees (reuse from task4)
        Employee[] employees = {
                new Employee("Alice", 5000, LocalDateTime.now(), "INS1"),
                new Employee("Bob", 7000, LocalDateTime.now(), "INS2"),
                new Employee("Charlie", 6000, LocalDateTime.now(), "INS3")
        };

        Sort.bubbleSort(employees);

        System.out.println("\nSorted Employees:");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}