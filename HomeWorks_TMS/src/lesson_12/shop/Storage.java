package lesson_12.shop;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    public void saveDataBase(Map<Integer, Product> list) {
        try {
            File file = new File("shop.txt");
            FileOutputStream writer = new FileOutputStream(file);
            ObjectOutputStream write = new ObjectOutputStream(writer);
            write.writeObject(list);
            write.flush();
            write.close();


        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public Map<Integer, Product> readerDataBase() {
        Map<Integer, Product> list = new HashMap<>();
        try {
            File file = new File("shop.txt");
            FileInputStream reader = new FileInputStream(file);
            ObjectInputStream read = new ObjectInputStream(reader);
            list = (Map<Integer, Product>) read.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
