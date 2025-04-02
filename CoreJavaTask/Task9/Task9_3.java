package Task9;
import java.util.*;

public class Task9_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the list: ");
        int size = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();
        System.out.println("Enter the elements in the list:");

        for (int i = 0; i < size; i++) {
            numbers.add(scanner.nextInt());
        }

        int evenSum = numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
        int oddSum = numbers.stream().filter(n -> n % 2 != 0).mapToInt(Integer::intValue).sum();
        System.out.println("Sum of even numbers: " + evenSum);
        System.out.println("Sum of odd numbers: " + oddSum);
        scanner.close();
    }
}
