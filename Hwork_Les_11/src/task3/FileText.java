package task3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileText {

    public void fileText() {
        String filetext = "холодно стало очень. тепло. белгидрометцентр сказал, что похолодало. ";
       /* String filetext = "Есть такой циклон Роланд, он, как слон в посудной лавке, " +
                "таскает по Европе свои принадлежности. Теперь вот дорвался до нас, " +
                "надо как-то к нему приноровиться. холод белгидромет уже объявил оранжевый уровень — " +
                "теперь еще и из-за ветра (был из-за дождей). Похолодает. Кое-где уже включают отопление. То, что сейчас" +
                " вам холодно, — так это еще не холодно, говорят синоптики и показывают страшные версии будущего.";*/
        try {
            FileWriter writer = new FileWriter("textWeather.txt", false);
            writer.write(filetext);
            writer.close();
            //writer.flush();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public StringBuilder fileTextReader() {
        StringBuilder line = new StringBuilder();
        try {
            FileReader reader = new FileReader("textWeather.txt");
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


