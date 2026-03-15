package lab2task4;

public class CircuitTest {

    public static void main(String[] args) {

        Circuit a = new Resistor(3.0);
        Circuit b = new Resistor(3.0);
        Circuit c = new Resistor(6.0);
        Circuit d = new Resistor(3.0);
        Circuit e = new Resistor(2.0);

        Circuit f = new Series(a, b);          // 3 + 3 = 6 Ω
        Circuit g = new Parallel(c, d);        // 6 || 3 = 2 Ω
        Circuit h = new Series(g, e);          // 2 + 2 = 4 Ω
        Circuit circuit = new Parallel(h, f);  // 4 || 6 ≈ 2.4 Ω

        // Применяем напряжение ко всей цепи
        circuit.applyPotentialDiff(12.0);

        System.out.println("Эквивалентное сопротивление всей цепи: "
                + String.format("%.2f", circuit.getResistance()) + " Ω");

        System.out.println("Ток через всю цепь: "
                + String.format("%.3f", circuit.getCurrent()) + " A");

        System.out.println("Мощность всей цепи: "
                + String.format("%.3f", circuit.getPower()) + " W");

        System.out.println("\nДетализация компонентов:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("f (series a+b) = " + f);
        System.out.println("g (parallel c||d) = " + g);
        System.out.println("h (series g+e) = " + h);
        System.out.println("circuit (parallel h||f) = " + circuit);
    }
}