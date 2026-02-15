package main;

import java.util.Arrays;

public class Student {
	
	private String name;
	private int id;
	private int YearOfStudy;
	private int[] grades;
	
	// без оценок
	public Student(String name, int id, int years) {
		this.name = name;
		this.id = id;
		this.YearOfStudy = years;
		this.grades = new int[0];
	}
	
	// с оценками
	public Student(String name, int id, int years, int[] grades) {
		this.name = name;
		this.id = id;
		this.YearOfStudy = years;
		this.grades = grades != null ? Arrays.copyOf(grades, grades.length) : new int[0];
	}
	
	public void displayDetails() {
		System.out.println("Name - " + name);
		System.out.println("ID - " + id);
		System.out.println("Year of Study - " + YearOfStudy);
	}
	
	public void incrementID() {
		id += 1;
	}
	
	public double getAverage() {
		if (grades.length == 0) return 0.0;
		double sum = 0;
		for (int g : grades) sum += g;
		return sum / grades.length;
	}
	
	public char getLetterGrade() {
		double avg = getAverage();
		if (avg >= 90) return 'A';
		if (avg >= 80) return 'B';
		if (avg >= 70) return 'C';
		if (avg >= 60) return 'D';
		return 'F';
	}
	
	public int getId() { return id; }
	public String getName() { return name; }
	public int[] getGrades() { return Arrays.copyOf(grades, grades.length); }

	@Override
	public String toString() {
		return "Student " + name + " (id: " + id + "), avg: " + String.format("%.2f", getAverage());
	}
}