package Task3;
import java.util.Scanner;

public class Task3_7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String name = sc.nextLine();

        System.out.print("Enter your last name: ");
        String lname = sc.nextLine();

        System.out.println("Hello, " + name + " "+lname+" !");


        // Close the Scanner object
        sc.close();
    }
}
