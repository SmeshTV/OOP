package lab2task5;

public class PetSystemTest {
    public static void main(String[] args) {
        PersonRegistry registry = new PersonRegistry();

        // людей
        Person john = new Employee("John", 30, "Software Engineer");
        Person alice = new PhDStudent("Alice", 26, "Machine Learning");
        Person bob = new Student("Bob", 21, "Computer Science");

        registry.addPerson(john);
        registry.addPerson(alice);
        registry.addPerson(bob);

        // животных
        Animal murka = new Cat("Murka", 4);
        Animal rex = new Dog("Rex", 3);
        Animal tweety = new Bird("Tweety", 2);
        Animal nemo = new Fish("Nemo", 1);

        // питомцев
        System.out.println("\nAssigning pets:");
        john.assignPet(rex);          // собаку
        alice.assignPet(murka);       // кота
        bob.assignPet(tweety);        // птицу

        System.out.println("\nTrying invalid assignment:");
        alice.assignPet(rex);         // PhD не может собаку

        registry.printAll();

        System.out.println("\nVacation logic:");

        System.out.println("John leaves Rex with Alice");
        if (john.hasPet()) {
            Animal tempPet = john.getPet();
            john.removePet();
            alice.assignPet(tempPet);
        }

        registry.printAll();

        System.out.println("John returns and retrieves Rex from Alice");
        if (alice.hasPet() && alice.getPet().getName().equals("Rex")) {
            Animal returnedPet = alice.getPet();
            alice.removePet();
            john.assignPet(returnedPet);
        }

        registry.printAll();

        System.out.println("\nTrying invalid vacation leave:");
        bob.removePet();              // забираем птицу у Боба
        bob.assignPet(rex);           // даём собаку Бобу
        System.out.println("Bob tries to leave Rex with Alice (PhD)");
        if (bob.hasPet()) {
            Animal temp = bob.getPet();
            bob.removePet();
            alice.assignPet(temp);
        }

        registry.printAll();
    }
}