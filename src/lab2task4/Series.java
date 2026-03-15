package lab2task4;
public class Series extends Circuit {

    private Circuit c1;
    private Circuit c2;

    public Series(Circuit c1, Circuit c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public double getResistance() {
        return c1.getResistance() + c2.getResistance();
    }

    @Override
    public double getPotentialDiff() {
        return c1.getPotentialDiff() + c2.getPotentialDiff();
    }

    @Override
    public void applyPotentialDiff(double V) {
        double rTotal = getResistance();
        if (rTotal == 0) return;

        double i = V / rTotal;
        c1.applyPotentialDiff(i * c1.getResistance());
        c2.applyPotentialDiff(i * c2.getResistance());
    }

    @Override
    public String toString() {
        return "Series[" + c1 + " + " + c2 + "] → R=" + String.format("%.2f", getResistance()) + " Ω";
    }
}