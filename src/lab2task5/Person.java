package lab2task5;
public abstract class Person {
    private String name;
    private int age;
    private Animal pet;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.pet = null;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Animal getPet() {
        return pet;
    }

    public boolean hasPet() {
        return pet != null;
    }

    public void assignPet(Animal pet) {
        if (this.pet != null) {
            System.out.println(name + " already has a pet!");
            return;
        }
        this.pet = pet;
        System.out.println(name + " now owns " + pet);
    }

    public void removePet() {
        if (pet == null) {
            System.out.println(name + " has no pet to remove.");
            return;
        }
        System.out.println(name + " says goodbye to " + pet);
        this.pet = null;
    }

    public abstract String getOccupation();

    @Override
    public String toString() {
        String petInfo = hasPet() ? " with pet: " + pet : " (no pet)";
        return getClass().getSimpleName() + " " + name + ", " + age + " y.o., " +
               getOccupation() + petInfo;
    }
}