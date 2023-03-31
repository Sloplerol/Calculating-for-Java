package SparArr;

import java.io.*;

public class IO_Operation {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Spar spar = new Spar();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/Users/satrol_/Java数据结构与算法/src/src/SparArr/Spar"));
        oos.writeObject(spar);
        oos.flush();
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/satrol_/Java数据结构与算法/src/src/SparArr/Spar"));
        Object obj = ois.readObject();
        System.out.println(obj.toString());


    }
}
