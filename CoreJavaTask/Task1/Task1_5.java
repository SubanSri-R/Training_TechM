package Task1;
import java.util.Scanner;

public class Task1_5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter a String");
        String ip= sc.nextLine();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < ip.length(); i++) {
            if (i % 2 == 0) {
                result.append(Character.toUpperCase(ip.charAt(i)));
            } else {
                result.append(Character.toLowerCase(ip.charAt(i)));
            }
        }
        System.out.println("Modified String: " + result.toString());
    }
}

