package Task4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task4_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
//            System.out.println("enter file path");
//            String filename = sc.nextLine();
            String filename="example1.txt";
            fileread(filename);
        } catch (PositiveNumException e) {
            System.out.println("exception caught :" + e.getMessage());
        }
        catch (FileNotFoundException e){
            System.out.println("exception caught :" + e.getMessage());
        }
    }

    public static void fileread(String filename) throws PositiveNumException,FileNotFoundException
    {
        File file=new File(filename);
        if(!file.exists()){
            throw new FileNotFoundException(filename+" not Found");
        }
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                if(scanner.hasNextInt())
                {
                    int num = scanner.nextInt();
                    if(num>0){
                        throw new PositiveNumException("positive num found "+num);
                    }
                }
            }
        }

    }
}
class PositiveNumException extends Exception{
    public PositiveNumException(String error){
        super(error);
    }
}
