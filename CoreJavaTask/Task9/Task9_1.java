package Task9;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Task9_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of integers: ");
        int size = scanner.nextInt();

        System.out.println("Enter the integers:");
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }
        double average = IntStream.of(numbers).average().orElse(0);
        System.out.println("The average is: " + average);
    }
}
