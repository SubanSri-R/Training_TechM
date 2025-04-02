package Task7;
import java.util.ArrayList;
import java.util.Scanner;

public class Task7_6{
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
        if(colors.size()>=3){
            String val=colors.remove(2);
            System.out.println("element from index 3 :"+val+" removed");
        }
        else {
            System.out.println("Array size is less than 3!");
        }

        System.out.println("Colors in the list: " + colors);
        scanner.close();
    }
}
