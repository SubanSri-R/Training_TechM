
package Task7;
import java.util.ArrayList;
import java.util.Scanner;

public class Task7_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> colors = new ArrayList<>();

        System.out.print("How many colors do you want to enter? ");
        int size = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < size; i++) {
            System.out.print("Enter color " + (i + 1) + ": ");
            String color = scanner.nextLine();
            colors.add(color);
        }
        ArrayList<String> colors1 = new ArrayList<>();
        colors1.addAll(colors);
        System.out.println("Colors in the list1: " + colors);
        System.out.println("Colors in the list2: " + colors1);
        scanner.close();
    }
}
