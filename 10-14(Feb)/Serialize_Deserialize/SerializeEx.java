package Serialize_Deserialize;

import java.beans.Transient;
import java.io.*;

class Employee implements Serializable{
    Employee(int enu, String name, String email){
        this.enu=enu;
        this.name=name;
        this.email=email;
    }
    int enu;
    String name;
   transient String email;
}


public class SerializeEx {
    public void Serialization() throws IOException {
       try {
           Employee e1 = new Employee(1, "aaa", "aaa@gmail.com");

           FileOutputStream out = new FileOutputStream("f1.txt");
           ObjectOutputStream objout = new ObjectOutputStream(out);
           objout.writeObject(e1);
           objout.flush();
           objout.close();
           System.out.println("success");
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }
    public void Deserialization()throws IOException{
        try {
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("f1.txt"));
            Employee e1=(Employee)in.readObject();
            System.out.println(e1.enu+" "+e1.name);
            in.close();
        }
        catch(Exception e){System.out.println(e);}
    }

    public static void main(String[] args)throws IOException{
        SerializeEx s1=new SerializeEx();
        s1.Serialization();
        s1.Deserialization();

    }
}
