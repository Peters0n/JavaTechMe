import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRewrite_App2 {
    public static void main(String[] args) {

        String filetext = "Мама мыла раму. Мама мыла раму двадцать раз подряд. Werew erv. ";
        try {

            FileWriter writer = new FileWriter("text2.txt", false);

            writer.write(filetext);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileReader reader = new FileReader("text2.txt");
            int a;
            StringBuilder line = new StringBuilder();
            while ((a = reader.read()) != -1) {
                line.append((char) a);
            }
            reader.close();
            String[] arrayToFile = line.toString().split("\\. ");
            StringBuilder write = new StringBuilder();

            for (int i = 0; i < arrayToFile.length; i++) {
                if (polindrom(arrayToFile[i])) {
                    write.append(arrayToFile[i]);
                    write.append(". ");
                } else {
                    int sellCount = countWords(arrayToFile[i]);
                    if (sellCount >= 3 && sellCount <= 5) {
                        write.append(arrayToFile[i]);
                        write.append(". ");
                    }
                }
            }
            String wr = write.toString();
            FileWriter writerPolindrom = new FileWriter("textSentences.txt", false);
            writerPolindrom.write(wr);
            writerPolindrom.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int countWords(String lineR) {
        int countWord = 1;
        for (int i = 0; i < lineR.length(); i++) {
            if (lineR.charAt(i) == ' ') {
                countWord++;
            }
        }
        return countWord;
    }

    public static boolean polindrom(String lineOfArray) {
        StringBuilder lineBuilder = new StringBuilder(lineOfArray);
        StringBuilder textPhrase = new StringBuilder();
        boolean palyndromBool = true;
        for (int i = 0; i < lineBuilder.length(); i++) {
            if (lineBuilder.charAt(i) != ' ') {
                textPhrase.append(lineBuilder.charAt(i));
            } else {
                var textPhrase2 = new StringBuilder(textPhrase);
                textPhrase2.reverse();
                if (textPhrase2.toString().equalsIgnoreCase(textPhrase.toString())) {
                    palyndromBool = true;
                    textPhrase.delete(0, textPhrase.length());
                    textPhrase2.delete(0, textPhrase2.length());
                    break;
                } else {
                    palyndromBool = false;
                    textPhrase.delete(0, textPhrase.length());
                    textPhrase2.delete(0, textPhrase2.length());
                }
            }
        }
        return palyndromBool;
    }
}
