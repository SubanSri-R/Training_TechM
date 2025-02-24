package Task1;
import java.util.Arrays;

public class Task1_3 {
    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};

        System.out.println("Using equals(): " + arr1.equals(arr2));
//        System.out.println("Using deepEquals(): " + Arrays.deepEquals(arr1, arr2));

        Student1 student1 = new Student1("Alice", 25);
        Student1 student2 = new Student1("Alice", 25);

        System.out.println("Using equals() for objects: " + student1.equals(student2));

        Student1[] students1 = {new Student1("Alice", 25), new Student1("Bob", 22)};
        Student1[] students2 = {new Student1("Alice", 25), new Student1("Bob", 22)};

        System.out.println("Using deepEquals() for arrays of objects: " + Arrays.deepEquals(students1, students2));
    }
}

class Student1 {
    String name;
    int age;

    public Student1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student1 student = (Student1) obj;
        return age == student.age && name.equals(student.name);
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
