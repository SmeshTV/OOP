package main2;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Введите слово: ");
        String s = sc.nextLine().trim().toLowerCase();

        if (isPalindrome(s)) {
            System.out.println("Это палиндром!");
        } else {
            System.out.println("Это НЕ палиндром");
        }
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}