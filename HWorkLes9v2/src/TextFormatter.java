public class TextFormatter {

    public static void main(String[] args) {
        String[] text = new String[]{"Мама мыла раму.", "Мама мыла раму двадцать раз подряд.", "werew erv."};
        var textRewrite = new StringBuilder();
        for (int i = 0; i < text.length; i++) {
            if (palyndrom(text[i])) {
                textRewrite.append(text[i]);
            } else {
                if (countWords(text[i]) >= 3 && countWords(text[i]) <= 5) {
                    textRewrite.append(text[i]);
                }
            }
        }
        System.out.println(textRewrite);
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

    public static boolean palyndrom(String lineOfArray) {
        StringBuilder lineBuilder = new StringBuilder(lineOfArray);
        StringBuilder textPhrase = new StringBuilder();
        boolean palyndromBool = true;
        for (int i = 0; i < lineBuilder.length(); i++) {
            if (lineBuilder.charAt(i) != ' ' && lineBuilder.charAt(i) != '.') {
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

