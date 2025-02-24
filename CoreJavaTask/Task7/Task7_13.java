package Task7;
import java.util.LinkedList;
import java.util.Scanner;

public class Task7_13{
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

        System.out.println("enter index you want to iterate from: ");
        int index= scanner.nextInt();
        if(index>=0 && index<colors.size()){
            for (int i=index;i<colors.size();i++)
            {
                System.out.println(colors.get(i));
            }
        } else {
            System.out.println("Invalid index!");
        }

    }
}
