package Task9;
import java.util.*;

public class Task9_5 {
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

        System.out.print("Enter the letter to check strings starting with: ");
        char letter = scanner.next().charAt(0);
        long count = strings.stream().filter(str -> str.toLowerCase().startsWith(String.valueOf(letter).toLowerCase())).count();
        System.out.println("Number of strings starting with '" + letter + "': " + count);
        scanner.close();
    }
}
