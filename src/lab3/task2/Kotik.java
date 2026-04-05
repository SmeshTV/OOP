package lab3.task2;
public class Kotik implements Flyable{
	@Override
	public void move() {
		System.out.println("This lil bro can move as hell daaamn");
	}
	
	@Override
	public void fly() {
		System.out.println("This lil bro cannot fly :(");
	}
}
