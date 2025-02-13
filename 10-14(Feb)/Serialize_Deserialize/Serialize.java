package Serialize_Deserialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialize {
    public static void main(String[] args) throws IOException {
        try{
            //Creating the object
            Student s1 =new Student(211,"ravi");
            //Creating stream and writing the object
            FileOutputStream fout=new FileOutputStream("f.txt");
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(s1);
            out.flush();
            //closing the stream
            out.close();
            System.out.println("success");
        }
        catch(Exception e){System.out.println(e);}
}}
    class Student implements Serializable {
        Student(int rno, String name) {
            this.rno = rno;
            this.name = name;
        }

        int rno;
        String name;
    }