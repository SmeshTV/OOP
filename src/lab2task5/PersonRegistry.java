package lab2task5;

import java.util.ArrayList;
import java.util.List;

public class PersonRegistry {
    private List<Person> people = new ArrayList<>();

    public void addPerson(Person p) {
        people.add(p);
        System.out.println("Added to registry: " + p);
    }

    public void removePerson(Person p) {
        if (people.remove(p)) {
            System.out.println("Removed from registry: " + p.getName());
        } else {
            System.out.println(p.getName() + " not found in registry.");
        }
    }

    public void printAll() {
        System.out.println("\n=== Registry ===");
        if (people.isEmpty()) {
            System.out.println("(empty)");
        } else {
            for (Person p : people) {
                System.out.println(p);
            }
        }
        System.out.println("===============\n");
    }

    public void printPeopleWithPets() {
        System.out.println("\nPeople with pets:");
        for (Person p : people) {
            if (p.hasPet()) {
                System.out.println("  • " + p);
            }
        }
    }
}