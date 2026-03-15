package lab2task4;
public class Parallel extends Circuit {

    private Circuit c1;
    private Circuit c2;

    public Parallel(Circuit c1, Circuit c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public double getResistance() {
        double r1 = c1.getResistance();
        double r2 = c2.getResistance();
        if (r1 == 0 || r2 == 0) return 0;
        return (r1 * r2) / (r1 + r2);
    }

    @Override
    public double getPotentialDiff() {
        return c1.getPotentialDiff();  // в параллели одинаковое напряжение
    }

    @Override
    public void applyPotentialDiff(double V) {
        c1.applyPotentialDiff(V);
        c2.applyPotentialDiff(V);
    }

    @Override
    public String toString() {
        return "Parallel[" + c1 + " || " + c2 + "] → R=" + String.format("%.2f", getResistance()) + " Ω";
    }
}