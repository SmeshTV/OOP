package main;

public class Student {
	
	private String name;
	private int id;
	private int YearOfStudy;
	
	public Student(String name, int id, int years) {
		this.name = name;
		this.id = id;
		this.YearOfStudy = years;
	}
	
	public void displayDetails() {
		System.out.println("Name - " + name);
		System.out.println("ID - " + id);
		System.out.println("Year of Study - " + YearOfStudy);
	}
	public void incrementID() {
		id+=1;
	}
	
	public static void main(String[] args) {
		Student stud = new Student("Arman", 31, 2024);
		
		stud.displayDetails();
		stud.incrementID();
		stud.displayDetails();		
	}

}