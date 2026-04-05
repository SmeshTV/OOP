package lab3.task6;

public abstract class Person implements Comparable<Person>, Cloneable, PetOwner {

    protected String name;
    protected int age;
    protected Animal pet;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void assignPet(Animal pet) {
        this.pet = pet;
    }

    @Override
    public void removePet() {
        pet = null;
    }

    @Override
    public boolean hasPet() {
        return pet != null;
    }

    public void leavePetWith(Person other) {
        if (!hasPet()) return;
        other.assignPet(pet);
        pet = null;
    }

    public void retrievePetFrom(Person other) {
        if (other.hasPet()) {
            this.pet = other.pet;
            other.removePet();
        }
    }

    public abstract String getOccupation();

    @Override
    public int compareTo(Person other) {
        return this.age - other.age;
    }

    @Override
    public Person clone() {
        try {
            Person copy = (Person) super.clone();
            if (pet != null) {
                copy.pet = pet.clone();
            }
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public String toString() {
        return name + " (" + getOccupation() + "), pet: " +
                (pet == null ? "none" : pet.getName());
    }
}