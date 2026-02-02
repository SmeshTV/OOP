package main;
public class PrintMyName {
    public static void main(String[] args) {
        String name = "Арман Нурмаханбетов";

        int len = name.length();
        String line = "+";
        for (int i = 0; i < len + 2; i++) line += "-";
        line += "+";

        System.out.println(line);
        System.out.println("| " + name + " |");
        System.out.println(line);
    }
}