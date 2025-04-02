package Task7;
import java.util.LinkedList;
import java.util.Scanner;

public class Task7_20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> colors = new LinkedList<>();

        System.out.print("How many colors do you want to enter? ");
        int size = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < size; i++) {
            System.out.print("Enter color " + (i + 1) + ": ");
            String color = scanner.nextLine();
            colors.add(color);
        }

        System.out.println("Colors in the list: " + colors);

        System.out.println("enter element you want to retrive");
        String ele= scanner.nextLine();
        int firstocc=colors.indexOf(ele);
        int lastocc=colors.lastIndexOf(ele);

        if (firstocc != -1) {
            System.out.println("First occurrence of '" + ele + "' is at index: " + firstocc);
            System.out.println("Last occurrence of '" + ele + "' is at index: " + lastocc);
        } else {
            System.out.println("Element '" + ele + "' not found in the list.");
        }

    }
}
