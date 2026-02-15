package lab1;

import java.util.Vector;

enum Gender {
    BOY, GIRL
}

class Person {
    private Gender gender;

    public Person(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return gender == Gender.BOY ? "B" : "G";
    }
}

public class DragonLaunch {
    private Vector<Person> people = new Vector<>();

    public void kidnap(Person p) {
        people.add(p);
    }

    public boolean willDragonEatOrNot() {
        int unpairedBoys = 0;

        for (Person p : people) {
            if (p.getGender() == Gender.BOY) {
                unpairedBoys++;
            } else if (p.getGender() == Gender.GIRL && unpairedBoys > 0) {
                unpairedBoys--;
            }
        }

        return unpairedBoys > 0;
    }

    public static void main(String[] args) {
        DragonLaunch dl = new DragonLaunch();

        dl.kidnap(new Person(Gender.BOY));
        dl.kidnap(new Person(Gender.BOY));
        dl.kidnap(new Person(Gender.GIRL));
        dl.kidnap(new Person(Gender.GIRL));
        System.out.println(dl.willDragonEatOrNot());

        dl = new DragonLaunch();
        dl.kidnap(new Person(Gender.GIRL));
        dl.kidnap(new Person(Gender.BOY));
        dl.kidnap(new Person(Gender.GIRL));
        dl.kidnap(new Person(Gender.BOY));
        System.out.println(dl.willDragonEatOrNot());

        dl = new DragonLaunch();
        dl.kidnap(new Person(Gender.BOY));
        dl.kidnap(new Person(Gender.GIRL));
        dl.kidnap(new Person(Gender.BOY));
        dl.kidnap(new Person(Gender.GIRL));
        System.out.println(dl.willDragonEatOrNot());
    }
}