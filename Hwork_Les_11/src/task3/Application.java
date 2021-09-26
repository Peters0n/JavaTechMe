package task3;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        var bl = new BlackListFile();
        bl.blackList();
        var tf = new FileText();
        tf.fileText();
        var blStrReader = bl.blackListReader().toString().split("/");
        var txtCompare = tf.fileTextReader().toString().split("\\. ");
        List <String> textTrue = new ArrayList<>();
        for (int i = 0; i < txtCompare.length; i++) {
            for (int j = 0; j < blStrReader.length; j++) {
                if (txtCompare[i] != null && txtCompare[i].contains(blStrReader[j])) {
                    textTrue.add(txtCompare[i] + ".");
                }
                txtCompare[i] = null;
            }
        }
        if (textTrue.size() == 0) {
            System.out.println("Текст прошел проверку.");
        } else {
            System.out.println("Количество предложений, не прошедших проверку: " + textTrue.size());
            for (String s : textTrue){
                System.out.println(s);
            }
        }
    }
}
