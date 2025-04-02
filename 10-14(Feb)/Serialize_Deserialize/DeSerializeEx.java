package Serialize_Deserialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializeEx {
public static void main(String[] args){
    try {
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("f1.txt"));
        Employee e1=(Employee)in.readObject();
        System.out.println(e1.enu+" "+e1.name);
        in.close();
    }
    catch(Exception e){System.out.println(e);}
}

}
