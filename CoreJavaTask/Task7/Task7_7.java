package Task7;
import java.util.ArrayList;
import java.util.Scanner;

public class Task7_7{
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
        System.out.println("Colors in the list: " + colors);
        System.out.println("enter element you want to find");
        String element= scanner.nextLine();
        if(colors.contains(element)){
            System.out.println(element+" found at index "+colors.indexOf(element));
        }
        else {
            System.out.println(element+" not found");
        }

    }
}
