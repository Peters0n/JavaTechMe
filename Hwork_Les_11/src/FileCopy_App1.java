import java.io.*;

public class FileCopy_App1 {
    public static void main(String[] args) {
        String filetext = "qererr\nerqwer\nwerew\nretrre\ntrert";
        try {

            FileWriter writer = new FileWriter("text.txt", false);

            writer.write(filetext);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileReader reader = new FileReader("text.txt");
            int a;
            StringBuilder line = new StringBuilder();
            while ((a = reader.read()) != -1) {
                line.append((char) a);
            }
            reader.close();
            String[] arrayToFile = line.toString().split("\n");
            StringBuilder write = new StringBuilder();

            for (int i = 0; i < arrayToFile.length; i++) {
                String sell = arrayToFile[i];
                boolean bool;
                bool = polidrom(sell);
                if (bool) {
                    write.append(arrayToFile[i]);
                    write.append("\n");
                }
            }
            String wr = write.toString();
            FileWriter writerPolindrom = new FileWriter("textPolindrom.txt", false);
            writerPolindrom.write(wr);
            writerPolindrom.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean polidrom(String arraytoFile) {
        var text = new StringBuilder(arraytoFile);

        boolean polidromBool = false;

        var textReverse = new StringBuilder(text);
        textReverse.reverse();
        if (textReverse.toString().equalsIgnoreCase(text.toString())) {
            polidromBool = true;
            text.delete(0, text.length());
            textReverse.delete(0, text.length());
        } else {
            text.delete(0, text.length());
            textReverse.delete(0, text.length());
        }
        return polidromBool;
    }
}
