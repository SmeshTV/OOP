package main;

import java.util.Scanner;

public class StarTriangle {
	
	private int width;
	
	public StarTriangle(int cnt) {
		this.width = cnt;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= width; i++) {
			for(int j = 1; j <= i; j++) {
			    sb.append("[*]");
			}
			if(i < width) sb.append("\n");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Введите высоту треугольника: ");
		int height = sc.nextInt();
		
		StarTriangle t = new StarTriangle(height);
		System.out.println(t.toString());
		
	}
}