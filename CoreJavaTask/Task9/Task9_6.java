package Task9;
import java.util.*;
import java.util.stream.*;

public class Task9_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of strings: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        List<String> strings = new ArrayList<>();
        System.out.println("Enter the strings:");

        for (int i = 0; i < size; i++) {
            strings.add(scanner.nextLine());
        }
        List<String> sortedAscending = strings.stream().sorted().collect(Collectors.toList());

        List<String> sortedDescending = strings.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        System.out.println("Strings in ascending order: " + sortedAscending);
        System.out.println("Strings in descending order: " + sortedDescending);
        scanner.close();
    }
}
