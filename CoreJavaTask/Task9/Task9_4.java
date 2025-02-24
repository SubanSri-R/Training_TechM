package Task9;
import java.util.*;
import java.util.stream.*;

public class Task9_4{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the list: ");
        int size = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();
        System.out.println("Enter the elements in the list:");

        for (int i = 0; i < size; i++) {
            numbers.add(scanner.nextInt());
        }
        List<Integer> uniqueNumbers = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println("List after removing duplicates: " + uniqueNumbers);
        scanner.close();
    }
}
