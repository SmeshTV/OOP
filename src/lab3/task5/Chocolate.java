package lab3.task5;

public class Chocolate implements Comparable<Chocolate> {

    private String name;
    private double weight;

    public Chocolate(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Chocolate other) {
        return Double.compare(this.weight, other.weight); // sort by weight
    }

    @Override
    public String toString() {
        return name + " (" + weight + "g)";
    }
}