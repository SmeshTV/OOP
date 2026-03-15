package main3;
import java.util.Objects;

public class Cat {

    static class Animal {
        private String name;
        private int age;

        public Animal(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String makeSound() {
            return "Some generic animal sound";
        }

        public String makeSound(int times) {
            return makeSound() + " ".repeat(Math.max(0, times - 1));
        }

        public String getInfo() {
            return "Animal: " + name + ", age: " + age;
        }

        @Override
        public String toString() {
            return "Animal{name='" + name + "', age=" + age + "}";
        }
    }

    static class CatDerived extends Animal {
        private String color;

        public CatDerived(String name, int age, String color) {
            super(name, age);
            this.color = color;
        }

        @Override
        public String makeSound() {
            return "Meow";
        }

        @Override
        public String makeSound(int times) {
            return "Meow!".repeat(times);
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String getInfo() {
            return super.getInfo() + ", color: " + color;
        }

        public String getDetailedInfo() {
            return super.getInfo() + ", color: " + color + ", sound: " + makeSound();
        }

        public String getParentInfo() {
            return super.toString();
        }

        public String callSuperGetInfo() {
            return super.getInfo();
        }

        @Override
        public String toString() {
            return "Cat{name='" + super.name + "', age=" + super.age + ", color='" + color + "'}";
        }
    }

    public static void main(String[] args) {
        Animal generic = new Animal("Rex", 4);
        CatDerived kitty = new CatDerived("Luna", 2, "grey");

        System.out.println("=== Base class ===");
        System.out.println(generic.makeSound());
        System.out.println(generic.makeSound(3));
        System.out.println(generic.getInfo());
        System.out.println(generic);

        System.out.println("\n=== Derived class (Cat) ===");
        System.out.println(kitty.makeSound());
        System.out.println(kitty.makeSound(5));
        System.out.println(kitty.getInfo());
        System.out.println(kitty.getDetailedInfo());
        System.out.println("Super toString: " + kitty.getParentInfo());
        System.out.println("Super getInfo:  " + kitty.callSuperGetInfo());
        System.out.println(kitty);
    }
}