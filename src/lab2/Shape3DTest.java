package lab2;

public class Shape3DTest {

    abstract static class Shape3D {
        public abstract double volume();
        public abstract double surfaceArea();
    }

    static class Cylinder extends Shape3D {
        private double radius;
        private double height;

        public Cylinder(double radius, double height) {
            this.radius = radius;
            this.height = height;
        }

        @Override
        public double volume() {
            return Math.PI * radius * radius * height;
        }

        @Override
        public double surfaceArea() {
            return 2 * Math.PI * radius * (radius + height);
        }

        @Override
        public String toString() {
            return String.format("Cylinder[r=%.2f, h=%.2f, V=%.2f, S=%.2f]",
                    radius, height, volume(), surfaceArea());
        }
    }

    static class Sphere extends Shape3D {
        private double radius;

        public Sphere(double radius) {
            this.radius = radius;
        }

        @Override
        public double volume() {
            return (4.0 / 3) * Math.PI * radius * radius * radius;
        }

        @Override
        public double surfaceArea() {
            return 4 * Math.PI * radius * radius;
        }

        @Override
        public String toString() {
            return String.format("Sphere[r=%.2f, V=%.2f, S=%.2f]",
                    radius, volume(), surfaceArea());
        }
    }

    static class Cube extends Shape3D {
        private double side;

        public Cube(double side) {
            this.side = side;
        }

        @Override
        public double volume() {
            return side * side * side;
        }

        @Override
        public double surfaceArea() {
            return 6 * side * side;
        }

        @Override
        public String toString() {
            return String.format("Cube[side=%.2f, V=%.2f, S=%.2f]",
                    side, volume(), surfaceArea());
        }
    }

    public static void main(String[] args) {
        Shape3D[] shapes = {
                new Cylinder(3.0, 5.0),
                new Sphere(4.0),
                new Cube(6.0)
        };

        for (Shape3D s : shapes) {
            System.out.println(s);
        }
    }
}