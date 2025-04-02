package Task7;
import java.util.LinkedList;
import java.util.Scanner;

public class Task7_17 {

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

        System.out.println("LinkedList before appending: " + colors);
        System.out.print("Enter the color to append first: ");
        String newColor = scanner.nextLine();
        colors.addFirst(newColor);
        System.out.println("LinkedList after appending: " + colors);

        scanner.close();
    }
}
