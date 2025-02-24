package Task9;
import java.util.*;
import java.util.stream.*;

public class Task9_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of integers: ");
        int size = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();
        System.out.println("Enter the integers:");
        for (int i = 0; i < size; i++) {
            numbers.add(scanner.nextInt());
        }
        OptionalInt min = numbers.stream().mapToInt(Integer::intValue).min();

        OptionalInt max = numbers.stream().mapToInt(Integer::intValue).max();
        
        if (max.isPresent()) {
            System.out.println("Maximum value: " + max.getAsInt());
        } else {
            System.out.println("No maximum value found");
        }
        if (min.isPresent()) {
            System.out.println("Minimum value: " + min.getAsInt());
        } else {
            System.out.println("No minimum value found");
        }
        scanner.close();
    }
}
