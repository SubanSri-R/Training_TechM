import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class StringEx {
    public static void main(String[] args){
        try{
            getIpWithBufferReader();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StringEx refvar=new StringEx();
        try {
            refvar.getIpWithScannerClass();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    static void getIpWithBufferReader() throws IOException
    {
        // Enter data using BufferReader
        BufferedReader buff = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Enter the input:");
        // Reading data using readLine
        String ip = buff.readLine();

        // Printing the read line
        System.out.println("The given input:"+ip);
    }
    void getIpWithScannerClass()
    {
        // Using Scanner for Getting Input from User
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the input string :");
        String string = s.nextLine();
        System.out.println("You entered string " + string);

        System.out.println("Enter the input integer :");
        int num = s.nextInt();
        System.out.println("You entered integer " + num);

        System.out.println("Enter the input float :");
        float decival = s.nextFloat();
        System.out.println("You entered float " + decival);
    }
}
