package lab3.task6;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        Dog d1 = new Dog("Rex", 5);
        Dog d2 = new Dog("Buddy", 2);

        Student s1 = new Student("Alice", 20);
        Student s2 = new Student("Bob", 18);

        s1.assignPet(d1);
        s2.assignPet(d2);

        System.out.println(s1);
        System.out.println(s2);

        // Train animals
        d1.train();
        d2.train();

        // Sort animals
        Animal[] animals = {d1, d2};
        Arrays.sort(animals);

        System.out.println("\nSorted Animals:");
        for (Animal a : animals) {
            System.out.println(a);
        }

        // Sort people
        Person[] people = {s1, s2};
        Arrays.sort(people);

        System.out.println("\nSorted People:");
        for (Person p : people) {
            System.out.println(p);
        }

        // Clone test
        Student clone = (Student) s1.clone();
        System.out.println("\nCloned: " + clone);
    }
}