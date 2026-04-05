package lab3.task6;

public class Dog extends Animal implements Trainable {

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public String getSound() {
        return "Woof";
    }

    @Override
    public void train() {
        System.out.println(name + " is being trained.");
    }
}
