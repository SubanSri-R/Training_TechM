public class Methods {
public static void main(String[] args)
{
    print_Ex();
    println_Ex();
    Methods obj=new Methods();
    obj.err_Ex();
}
    static void print_Ex()
    {
        System.out.print("Hello! "  );
        System.out.print("welcome to my info");
    }
    static void println_Ex()
    {
        System.out.println("\nif you drink more caffeine ?");
        System.out.println("if you are feeling dizzy ?");
    }
    void err_Ex()
    {
        System.err.println("You cant sleep. ");
        System.err.println("Drink more water. ");
    }
}
