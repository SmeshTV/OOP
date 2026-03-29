package main4.main;

import main4.interfaces.model.Student;
import main4.interfaces.services.App;
import main4.interfaces.services.Cat;
import main4.interfaces.services.LogicGame;
import main4.interfaces.services.MemoryGame;
import main4.interfaces.services.NameComparator;
import main4.interfaces.services.Restaurant;
import main4.interfaces.services.iPhone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        
        System.out.println("=== Practice Work 4 ===");

        // Problem 2
        System.out.println("\n=== Problem 2: Restaurant ===");
        Restaurant restaurant = new Restaurant();
        
        Cat cat = new Cat();
        main4.interfaces.services.Student student = new main4.interfaces.services.Student();  // Student из services

        System.out.println("Serving pizza to Cat:");
        restaurant.servePizza(cat);

        System.out.println("\nServing pizza to Student:");
        restaurant.servePizza(student);

        // Problem 3
        System.out.println("\n=== Problem 3: Interfaces & Polymorphism ===");
        App app = new App();
        
        LogicGame logicGame = new LogicGame();
        MemoryGame memoryGame = new MemoryGame();

        System.out.println("--- LogicGame ---");
        app.getStatistics(logicGame);

        System.out.println("\n--- MemoryGame ---");
        app.getStatistics(memoryGame);

        iPhone phone = new iPhone();
        phone.sell();
        phone.plug();

        // Problem 4
        System.out.println("\n=== Problem 4: Sorting Students ===");
        
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 3.8));
        students.add(new Student("Bob", 2.9));
        students.add(new Student("Charlie", 3.5));
        students.add(new Student("Diana", 4.0));

        System.out.println("Original: " + students);

        // Сортировка по GPA (используем Comparable)
        Collections.sort(students);
        System.out.println("Sorted by GPA: " + students);

        // Сортировка по имени (используем Comparator)
        Collections.sort(students, new NameComparator());
        System.out.println("Sorted by Name: " + students);

        // Bonus Task
        System.out.println("\n=== Bonus: Counting Sort ===");
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        
        countingSort(arr);
        
        System.out.print("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Bonus: Counting Sort for numbers 0-10
    private static void countingSort(int[] arr) {
        int[] count = new int[11]; // индексы 0 до 10

        for (int num : arr) {
            count[num]++;
        }

        int index = 0;
        for (int i = 0; i <= 10; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }
}