package Task4;
public class Task4_1 {
    public static void main(String[] args) {
        try {
            int res = divide(3, 0);
            System.out.println(res);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("program executed succesfully");
    }
    public static int divide(int x,int y)
    {
        return x/y;
    }
}