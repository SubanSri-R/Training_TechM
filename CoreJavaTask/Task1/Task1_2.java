package Task1;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class Student {
    String name;
    int[] marks;
    int total;
    double average;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
        this.total = calculateTotal(marks);
        this.average = calculateAverage(marks);
    }

    private int calculateTotal(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    private double calculateAverage(int[] marks) {
        return (double)total / marks.length;
    }

    public String toString() {
        return "Name: " + name + ", Total Marks: " + total + ", Average Marks: " + average;
    }
}
public class Task1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = sc.nextInt();
        sc.nextLine();
        Student[] students = new Student[numStudents];

        for (int i =0; i <numStudents; i++) {
            System.out.print("Enter name of student " +(1+i) + ": ");
            String name = sc.nextLine();

            System.out.print("Enter no. of subjects: ");
            int numSubjects = sc.nextInt();
            int[] marks = new int[numSubjects];

            System.out.println("Enter marks for " + numSubjects + " subjects:");
            for (int j = 0; j < numSubjects; j++) {
                marks[j] = sc.nextInt();
            }
            sc.nextLine();
            students[i] = new Student(name, marks);
        }

        Arrays.sort(students, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return Integer.compare(s2.total, s1.total);
            }
        });

        System.out.println("\nSorted List based on Total Marks:");
        for (Student student : students) {
            System.out.println(student);
        }

        sc.close();
    }
}
