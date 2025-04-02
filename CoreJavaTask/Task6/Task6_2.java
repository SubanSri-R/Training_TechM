package Task6;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task6_2 {
    public static <T> int findelement(List<T> list, T target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target)) {
                return i;
            }
        }
        return -1;
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
        System.out.print("Enter the target element to find: ");
        Object target = null;
        if (typeChoice == 1) {
            target = scanner.nextInt();
        } else if (typeChoice == 2) {
            target = scanner.nextLine();
        }

        int index = findelement(list, target);
        if (index != -1) {
            System.out.println("The first occurrence of the target element is at index: " + index);
        } else {
            System.out.println("The target element was not found.");
        }
        scanner.close();
    }
}
