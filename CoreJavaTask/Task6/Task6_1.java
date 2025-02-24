package Task6;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task6_1 {

    public static <T extends Number> String sum(List<T> numbers) {
        double evenSum = 0;
        double oddSum = 0;

        for (T num : numbers) {
            if (num.doubleValue() % 2 == 0) {
                evenSum += num.doubleValue();
            } else {
                oddSum += num.doubleValue();
            }
        }
        return "Even Sum: " + evenSum + ", Odd Sum: " + oddSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int size = scanner.nextInt();
        List<Number> numbers = new ArrayList<>();
        System.out.println("Enter the numbers:");
        for (int i = 0; i < size; i++) {
            numbers.add(scanner.nextInt());
        }
        System.out.println(sum(numbers));
    }
}
