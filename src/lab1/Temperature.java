package lab1;

public class Temperature {
    private double value;
    private char scale;

    // 1. Конструктор по умолчанию: 0 C
    public Temperature() {
        this.value = 0.0;
        this.scale = 'C';
    }

    // 2. Только значение, шкала по умолчанию 'C'
    public Temperature(double value) {
        this.value = value;
        this.scale = 'C';
    }

    // 3. Только шкала, значение 0
    public Temperature(char scale) {
        this.value = 0.0;
        this.scale = scale;
    }

    // 4. Значение + шкала
    public Temperature(double value, char scale) {
        this.value = value;
        this.scale = scale;
    }

    // Получить в Цельсиях
    public double getCelsius() {
        if (scale == 'C') {
            return value;
        } else {
            // F → C: C = 5*(F - 32)/9
            return 5 * (value - 32) / 9;
        }
    }

    // Получить в Фаренгейтах
    public double getFahrenheit() {
        if (scale == 'F') {
            return value;
        } else {
            return (9 * value / 5) + 32;
        }
    }

    // Установить только значение
    public void setValue(double value) {
        this.value = value;
    }

    // Установить только шкалу
    public void setScale(char scale) {
        this.scale = scale;
    }

    // Установить и значение, и шкалу
    public void setTemperature(double value, char scale) {
        this.value = value;
        this.scale = scale;
    }

    // Получить текущую шкалу
    public char getScale() {
        return scale;
    }
}

//public static void main(String[] args) {
//    Temperature t1 = new Temperature();
//    Temperature t2 = new Temperature(100.0);
//    Temperature t3 = new Temperature('F');
//    Temperature t4 = new Temperature(32.0, 'F');
//
//    System.out.println("t1 C: " + t1.getCelsius() + ", F: " + t1.getFahrenheit());
//    System.out.println("t2 C: " + t2.getCelsius() + ", F: " + t2.getFahrenheit());
//    System.out.println("t3 C: " + t3.getCelsius() + ", F: " + t3.getFahrenheit());
//    System.out.println("t4 C: " + t4.getCelsius() + ", F: " + t4.getFahrenheit());
//
//    t2.setScale('F');
//    System.out.println("После смены шкалы t2 F: " + t2.getFahrenheit());
//}