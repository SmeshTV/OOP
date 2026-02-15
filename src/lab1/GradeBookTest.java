package lab1;

import main.Student;
import java.util.Scanner;

class Course {
    private String name;
    private String description;
    private int credits;

    public Course(String name, String description, int credits) {
        this.name = name;
        this.description = description;
        this.credits = credits;
    }

    public String getName() { return name; }
    public int getCredits() { return credits; }

    @Override
    public String toString() {
        return name + " (" + credits + " credits)";
    }
}

class GradeBook {
    private Course course;
    private java.util.List<Student> students = new java.util.ArrayList<>();

    public GradeBook(Course course) {
        this.course = course;
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void displayMessage() {
        System.out.println("Welcome to the grade book for " + course.getName() + " and Design!");
    }

    private double getClassAverage() {
        if (students.isEmpty()) return 0;
        double sum = 0;
        for (Student s : students) sum += s.getAverage();
        return sum / students.size();
    }

    private Student getBestStudent() {
        if (students.isEmpty()) return null;
        Student best = students.get(0);
        for (Student s : students) {
            if (s.getAverage() > best.getAverage()) best = s;
        }
        return best;
    }

    private Student getWorstStudent() {
        if (students.isEmpty()) return null;
        Student worst = students.get(0);
        for (Student s : students) {
            if (s.getAverage() < worst.getAverage()) worst = s;
        }
        return worst;
    }

    private void outputLetterFrequency() {
        int[] freq = new int[5]; // A B C D F
        for (Student s : students) {
            char lg = s.getLetterGrade();
            if (lg == 'A') freq[0]++;
            else if (lg == 'B') freq[1]++;
            else if (lg == 'C') freq[2]++;
            else if (lg == 'D') freq[3]++;
            else freq[4]++;
        }

        System.out.println("Letter grades frequency:");
        System.out.println("A: " + freq[0]);
        System.out.println("B: " + freq[1]);
        System.out.println("C: " + freq[2]);
        System.out.println("D: " + freq[3]);
        System.out.println("F: " + freq[4]);
    }

    private void outputBarChart() {
        int[] freq = new int[11];
        for (Student s : students) {
            int bucket = (int) (s.getAverage() / 10);
            if (bucket > 10) bucket = 10;
            freq[bucket]++;
        }

        String[] labels = {"00-09:","10-19:","20-29:","30-39:","40-49:",
                           "50-59:","60-69:","70-79:","80-89:","90-99:","100:"};

        System.out.println("Grades distribution:");
        for (int i = 0; i < labels.length; i++) {
            System.out.print(labels[i] + " ");
            for (int j = 0; j < freq[i]; j++) System.out.print("*");
            System.out.println();
        }
    }

    public void displayGradeReport() {
        if (students.isEmpty()) {
            System.out.println("No students.");
            return;
        }

        for (Student s : students) {
            System.out.println("Student " + s.getName() + ": " + s.getLetterGrade());
        }

        double avg = getClassAverage();
        Student best = getBestStudent();
        Student worst = getWorstStudent();

        System.out.printf("Class average is %.2f. Lowest grade is %.2f (Student %s, id: %d). Highest grade is %.2f (Student %s, id: %d).%n",
                          avg, worst.getAverage(), worst.getName(), worst.getId(), best.getAverage(), best.getName(), best.getId());

        outputLetterFrequency();
        outputBarChart();
    }

    @Override
    public String toString() {
        return "GradeBook for " + course + ", students: " + students.size();
    }
}

public class GradeBookTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter course name: ");
        String name = sc.nextLine();
        System.out.print("Enter description: ");
        String desc = sc.nextLine();
        System.out.print("Enter credits: ");
        int credits = sc.nextInt();
        sc.nextLine();

        Course course = new Course(name, desc, credits);
        GradeBook gb = new GradeBook(course);

        gb.displayMessage();

        System.out.println("\nPlease, input grades for students:");

        int id = 1;
        while (true) {
            System.out.print("Student name (or 'done'): ");
            String studentName = sc.nextLine().trim();
            if (studentName.equalsIgnoreCase("done")) break;

            System.out.print("Grade (0-100): ");
            int grade = sc.nextInt();
            sc.nextLine();

            Student s = new Student(studentName, id++, 2025, new int[]{grade});
            gb.addStudent(s);
        }

        System.out.println();
        gb.displayGradeReport();

        sc.close();
    }
}