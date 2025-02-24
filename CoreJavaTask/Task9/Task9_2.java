package Task9;
import java.util.*;
import java.util.stream.Collectors;

public class Task9_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String> wordlist = new ArrayList<>();
        System.out.println("Enter " + n + " strings:");
        for (int i = 0; i < n; i++) {
            wordlist.add(scanner.nextLine());
        }
        List<String> upperCaseWords = wordlist.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("Uppercase: " + upperCaseWords);

        List<String> lowerCaseWords = wordlist.stream().map(String::toLowerCase).collect(Collectors.toList());
        System.out.println("Lowercase: " + lowerCaseWords);

        scanner.close();
    }
}
