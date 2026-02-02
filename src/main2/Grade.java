package main2;

import java.util.Scanner;

public class Grade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите балл (0–100): ");
        int score = sc.nextInt();
        
        String grade;
        
        if      (score >= 95) grade = "A";
        else if (score >= 90) grade = "A-";
        else if (score >= 85) grade = "B+";
        else if (score >= 80) grade = "B";
        else if (score >= 75) grade = "B-";
        else if (score >= 70) grade = "C+";
        else if (score >= 65) grade = "C";
        else if (score >= 60) grade = "C-";
        else if (score >= 55) grade = "D+";
        else if (score >= 50) grade = "D";
        else                  grade = "F";
        
        System.out.println("GPA: " + grade);
    }
}
