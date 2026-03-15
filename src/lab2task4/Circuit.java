package lab2task4;
public abstract class Circuit {

    public abstract double getResistance();

    public abstract double getPotentialDiff();

    public abstract void applyPotentialDiff(double V);

    public double getPower() {
        double v = getPotentialDiff();
        return v * v / getResistance();
    }

    public double getCurrent() {
        double v = getPotentialDiff();
        return v / getResistance();
    }
}