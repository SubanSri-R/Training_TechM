package Task7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Task7_8 {
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
        Collections.sort(colors);
        System.out.println("Colors in the Ascending order: "+colors);
        Collections.sort(colors,Collections.reverseOrder());
        System.out.println("Colors in the Descending order: "+colors);
        scanner.close();
    }
}
