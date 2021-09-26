package task3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BlackListFile {
    public void blackList() {
        String blackList = "холод/белгидромет";
        try {
            FileWriter writer = new FileWriter("blacklist.txt", false);
            writer.write(blackList);
            writer.close();
            //writer.flush();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public StringBuilder blackListReader() {
        StringBuilder line = new StringBuilder();
        try {
            FileReader reader = new FileReader("blacklist.txt");
            int a;
            while ((a = reader.read()) != -1) {
                line.append((char) a);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}
