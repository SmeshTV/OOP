package main3;

import java.util.*;

class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person[name=" + name + ", address=" + address + "]";
    }
}

class Student extends Person {
    private String program;
    private int year;
    private double fee;

    public Student(String name, String address, String program, int year, double fee) {
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Student" + super.toString().replace("Person", "") +
               "[program=" + program + ", year=" + year + ", fee=" + fee + "]";
    }
}

class Staff extends Person {
    private String school;
    private double pay;

    public Staff(String name, String address, String school, double pay) {
        super(name, address);
        this.school = school;
        this.pay = pay;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Staff" + super.toString().replace("Person", "") +
               "[school=" + school + ", pay=" + pay + "]";
    }
}

public class University {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Person> people = new HashSet<>();

        people.add(new Student("Aliya", "Abay 12", "Computer Science", 2, 450000));
        people.add(new Student("Daniyar", "Satpaev 5", "Business", 3, 520000));
        people.add(new Staff("Aigerim", "Panfilov 8", "KBTU", 320000));
        people.add(new Staff("Marat", "Tole bi 77", "KazNU", 280000));

        while (true) {
            System.out.println("\n1. Show all persons");
            System.out.println("2. Add new person");
            System.out.println("0. Exit");
            System.out.print("→ ");

            int choice = -1;
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                sc.nextLine();
            }

            if (choice == 0) break;

            if (choice == 1) {
                System.out.println("\nAll persons:");
                for (Person p : people) {
                    System.out.println(p);
                }
            }
            else if (choice == 2) {
                System.out.print("Type (student / staff): ");
                String type = sc.nextLine().trim().toLowerCase();

                System.out.print("Name: ");
                String name = sc.nextLine().trim();

                System.out.print("Address: ");
                String addr = sc.nextLine().trim();

                if (type.equals("student")) {
                    System.out.print("Program: ");
                    String prog = sc.nextLine().trim();

                    System.out.print("Year: ");
                    int year = sc.nextInt();

                    System.out.print("Fee: ");
                    double fee = sc.nextDouble();
                    sc.nextLine();

                    people.add(new Student(name, addr, prog, year, fee));
                    System.out.println("Student added.");
                }
                else if (type.equals("staff")) {
                    System.out.print("School: ");
                    String school = sc.nextLine().trim();

                    System.out.print("Pay: ");
                    double pay = sc.nextDouble();
                    sc.nextLine();

                    people.add(new Staff(name, addr, school, pay));
                    System.out.println("Staff added.");
                }
                else {
                    System.out.println("Unknown type.");
                }
            }
            else {
                System.out.println("Wrong choice.");
            }
        }

        sc.close();
    }
}