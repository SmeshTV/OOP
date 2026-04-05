package lab3.task1;

public class test {
    public static void main(String[] args) {
        System.out.println("=== Testing Car ===");
        Car myCar = new Car();
        myCar.type = "Tesla Model S"; // Setting the field from Abstract Class
        
        myCar.startEngine(); // Abstract method implementation
        myCar.move();        // Interface Movable implementation
        myCar.add_distance(50); // Concrete method from Abstract Class
        myCar.stop();        // Interface Stoppable implementation

        System.out.println("\n=== Testing Ship ===");
        Ship myShip = new Ship();
        myShip.type = "Titanic";
        
        myShip.startEngine();
        myShip.move();
        myShip.add_distance(200);
        myShip.stop();

        System.out.println("\n=== Demonstration of Polymorphism ===");
        // We can treat different objects as the same Interface type!
        Movable[] vehicles = { myCar, myShip };
        
        for (Movable m : vehicles) {
            m.move(); // Both know how to move, even though they are different classes
        }
    }
}
