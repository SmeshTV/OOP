package lab2;

import java.util.HashSet;
import java.util.Objects;

public class PersonTest {

    static class Vehicle {
        private String brand;
        private int year;

        public Vehicle(String brand, int year) {
            this.brand = brand;
            this.year = year;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vehicle vehicle = (Vehicle) o;
            return year == vehicle.year && Objects.equals(brand, vehicle.brand);
        }

        @Override
        public int hashCode() {
            return Objects.hash(brand, year);
        }

        @Override
        public String toString() {
            return "Vehicle{brand='" + brand + "', year=" + year + "}";
        }
    }

    static class ElectricCar extends Vehicle {
        private int batteryCapacity;

        public ElectricCar(String brand, int year, int batteryCapacity) {
            super(brand, year);
            this.batteryCapacity = batteryCapacity;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            ElectricCar that = (ElectricCar) o;
            return batteryCapacity == that.batteryCapacity;
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), batteryCapacity);
        }

        @Override
        public String toString() {
            return "ElectricCar" + super.toString().substring(7) + ", battery=" + batteryCapacity + "kWh}";
        }
    }

    public static void main(String[] args) {
        HashSet<Vehicle> set = new HashSet<>();

        set.add(new Vehicle("Toyota", 2020));
        set.add(new Vehicle("Toyota", 2020));               // дубликат
        set.add(new ElectricCar("Tesla", 2023, 75));
        set.add(new ElectricCar("Tesla", 2023, 75));        // дубликат

        System.out.println("Unique vehicles: " + set.size());
        for (Vehicle v : set) {
            System.out.println(v);
        }
    }
}