package Task6;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task6_4{

    public static <T> List<T> mergeAlternately(List<T> list1, List<T> list2) {
        List<T> mergedList = new ArrayList<>();
        int maxSize = Math.max(list1.size(), list2.size());
        for (int i = 0; i < maxSize; i++) {

            if (i < list1.size()) {
                mergedList.add(list1.get(i));
            }
            if (i < list2.size()) {
                mergedList.add(list2.get(i));
            }
        }
        return mergedList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the type of elements for the first list\n1 for Integer\n2 for String: ");
        int typeChoice1 = scanner.nextInt();
        scanner.nextLine();

        List<Object> list1 = new ArrayList<>();
        System.out.print("Enter the number of elements for the first list: ");
        int size1 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the elements for the first list:");
        if (typeChoice1 == 1) {
            for (int i = 0; i < size1; i++) {
                list1.add(scanner.nextInt());
            }
        } else if (typeChoice1 == 2) {
            for (int i = 0; i < size1; i++) {
                list1.add(scanner.nextLine());
            }
        }
        List<Object> list2 = new ArrayList<>();
        System.out.print("Enter the number of elements for the second list: ");
        int size2 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the elements for the second list:");
        if (typeChoice1 == 1) {
            for (int i = 0; i < size2; i++) {
                list2.add(scanner.nextInt());
            }
        } else if (typeChoice1 == 2) {
            for (int i = 0; i < size2; i++) {
                list2.add(scanner.nextLine());
            }
        }
        List<Object> mergedList = mergeAlternately(list1, list2);
        System.out.println("Merged list: " + mergedList);

        scanner.close();
    }
}
