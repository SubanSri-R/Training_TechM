package Task7;
import java.util.ArrayList;
import java.util.Scanner;

public class Task7_5{
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

        System.out.println("enter index you want to update");
        int index= scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the new element to update: ");
        String element = scanner.nextLine();

        if(index>=0 && index<colors.size()){
            colors.set(index,element);
        } else {
            System.out.println("Invalid index!");
        }
        System.out.println("Colors in the list: " + colors);
        scanner.close();
    }
}
