package lab3.task1;

abstract class Vehicle {
	String type;
	int distance = 0;
	
	Vehicle(String type){
		this.type = type;
	}
	
	void add_distance(int km) {
		distance += km;
		System.out.println(type + " проехал " + distance + " километров а так");
	}
	
	abstract void startEngine();
}

interface Movable {
	void move();
}
interface Stoppable {
	void stop();
}

class Car extends Vehicle implements Movable, Stoppable {
	
	Car() {
		super("Car");
	}
	
	public void move() {
		System.out.println("Vroom Vroom, kchau");
	}
	public void stop() {
		System.out.println("Kiiiik, stop");
	}
	@Override
	void startEngine() {
		System.out.println("Drn drn drn drn");
	}
}

class Ship extends Vehicle implements Movable, Stoppable {
	
	Ship() {
		super("Ship");
	}
	
	@Override
    void add_distance(int km) {
        distance += km;
        System.out.println(type + " проплыл " + distance + " км.");
    }
	
	public void move() {
		System.out.println("Bul Bul Bul");
	}
	public void stop() {
		System.out.println("Bulbulbul stop");
	}
	@Override
	void startEngine() {
		System.out.println("Some sound of ship starting its engine");
	}
}
// They are different types of vehicles, but they have something in common, that is why we can use interface here