package Serialize_Deserialize;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class DeSerialize {
    public static void main(String[] args) {
        try{
            //Creating stream to read the object
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("f.txt"));
            Student s=(Student)in.readObject();
            //printing the data of the serialized object
            System.out.println(s.rno+" "+s.name);
            //closing the stream
            in.close();
        }catch(Exception e){System.out.println(e);}
    }
}
