package lab3.task4;

import java.util.*;
import java.time.*;

public class Main {
    public static void main(String[] args) {

        Employee e1 = new Employee("Alice", 5000, LocalDateTime.of(2020, 2, 1, 10, 30), "INS123");

        Employee e2 = new Employee("Bob", 7000, LocalDateTime.of(2019, 6, 10, 9, 0), "INS456");

        Manager m1 = new Manager("Charlie", 7000, LocalDateTime.of(2018, 4, 15, 14, 45), "INS789", 2000);

        m1.addEmployee(e1);
        m1.addEmployee(e2);

        List<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(m1);

        System.out.println("=== Original ===");
        list.forEach(System.out::println);

        // Sort by salary
        Collections.sort(list);
        System.out.println("\n=== Sorted by Salary ===");
        list.forEach(System.out::println);

        // Sort by name
        Collections.sort(list, new NameComparator());
        System.out.println("\n=== Bro just Copied from Ibrayev Miras ===");
        list.forEach(System.out::println);

        // Sort by hire date (newest first)
        Collections.sort(list, new HireDateComparator());
        System.out.println("\n=== Sorted by Hire Date ===");
        list.forEach(System.out::println);

        // Clone test
        Employee clone = e1.clone();
        System.out.println("\nCloned Employee: " + clone);

        Manager cloneManager = m1.clone();
        System.out.println("Cloned Manager: " + cloneManager);
    }
}