package Task6;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task6_3 {

    public static <T> List<T> reverselist(List<T> list) {
        List<T> reversedList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversedList.add(list.get(i));
        }
        return reversedList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the type of elements\n1 for Integer\n2 for String ");
        int typeChoice = scanner.nextInt();
        scanner.nextLine();

        List<Object> list = new ArrayList<>();
        System.out.print("Enter the number of elements: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the elements:");
        if (typeChoice == 1) {
            for (int i = 0; i < size; i++) {
                list.add(scanner.nextInt());
            }
        } else if (typeChoice == 2) {
            for (int i = 0; i < size; i++) {
                list.add(scanner.nextLine());
            }
        }
        List<Object> reversedList = reverselist(list);
        System.out.println("Reversed list: " + reversedList);
        scanner.close();
    }
}
