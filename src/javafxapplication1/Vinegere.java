package javafxapplication1;

import java.text.Normalizer;
import javafx.scene.control.TextField;

/**
 *
 * @author marcin.kirsz
 */
public class Vinegere {
      public static void vinegereEncrypt(TextField vinegereText, TextField vinegereKey){
        String text = vinegereText.getText();
        text = Normalizer.normalize(text, Normalizer.Form.NFKD);
        text = Remove.removeSpecial(text).toUpperCase();
        String key = vinegereKey.getText();
        key = Normalizer.normalize(key, Normalizer.Form.NFKD);
        key = Remove.removeSpecial(key).toUpperCase();
        char[] textArray = text.toCharArray();
        char[] keyArray = new char[text.length()];

        //Adding characters to keyArray until there is the same amount of chars as in textArray
        fillArray(keyArray, text.length(), key.length(), key);

        int[] asciiTextArray = new int[text.length()];
        int[] asciiKeyArray = new int[text.length()];
        int[] asciiNewText = new int[text.length()];
        char[] asciiFinalText = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            asciiTextArray[i] = (int) textArray[i];
            asciiKeyArray[i] = (int) keyArray[i];
            asciiNewText[i] = asciiTextArray[i] + asciiKeyArray[i];
            if (asciiNewText[i] > 155) {
                asciiFinalText[i] = (char) (asciiNewText[i] - 91);
            } else {
                asciiFinalText[i] = (char) (asciiNewText[i] - 65);
            }
        }

        String result = String.valueOf(asciiFinalText);
        AlertBox.display("Password", result);
    }
    
    public static void vinegereDecrypt(TextField vinegereText, TextField vinegereKey){
        
        String text = vinegereText.getText();
        text = Normalizer.normalize(text, Normalizer.Form.NFKD);
        text = Remove.removeSpecial(text).toUpperCase();
        String key = vinegereKey.getText();
        key = Normalizer.normalize(key, Normalizer.Form.NFKD);
        key = Remove.removeSpecial(key).toUpperCase();
        char[] textArray = text.toCharArray();
        char[] keyArray = new char[text.length()];

        //Adding characters to keyArray until there is the same amount of chars as in textArray
        fillArray(keyArray, text.length(), key.length(), key);
        int[] asciiTextArray = new int[text.length()];
        int[] asciiKeyArray = new int[text.length()];
        int[] asciiNewText = new int[text.length()];
        char[] asciiFinalText = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            asciiTextArray[i] = (int) textArray[i];
            asciiKeyArray[i] = (int) keyArray[i];
            asciiNewText[i] = asciiTextArray[i] - asciiKeyArray[i];
            if (asciiNewText[i] >= 0) {
                asciiFinalText[i] = (char) (asciiNewText[i] + 65);
            } else {
                asciiFinalText[i] = (char) (asciiNewText[i] + 91);
            }
        }
        String result = String.valueOf(asciiFinalText);
        AlertBox.display("Password", result);
    }
    
    public static void fillArray(char[] keyArray, int textLen, int keyLen, String key) {
        int temp = 0;
        for (int i = 0; i < textLen; i++) {
            if (i >= keyLen) {
                keyArray[i] = key.charAt(temp);
                temp++;
                if (temp >= key.length()) {
                    temp = 0;
                }
            } else {
                keyArray[i] = key.charAt(i);
            }
        }
    }
}
