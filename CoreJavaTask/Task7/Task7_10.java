package Task7;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Task7_10 {
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
        System.out.println("Colors in the list1: " + colors);
        ArrayList<String> colors1 = new ArrayList<>();

        Collections.shuffle(colors);

        System.out.println("Colors in the shuffled list: " + colors);
        scanner.close();
    }
}
