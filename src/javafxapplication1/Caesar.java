package javafxapplication1;

import java.text.Normalizer;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 *
 * @author marcin.kirsz
 */
public class Caesar {

    public static void caesarEncrypt(TextField caesarText, ChoiceBox<Integer> caesarKey) {
        String text = caesarText.getText();
        text = Normalizer.normalize(text, Normalizer.Form.NFKD);
        text = Remove.removeSpecialExceptSpace(text);
        int key = caesarKey.getValue();
        char[] charArray = text.toCharArray();
        int[] asciiArray = new int[text.length()];

        for (int i = 0; i < text.length(); i++) {
            asciiArray[i] = (int) charArray[i];
            // Keep char if it is a space
            if (asciiArray[i] == 32) {
                charArray[i] = 32;
                // If statement for small letters
            } else if (asciiArray[i] >= 97) {
                if (asciiArray[i] + key > 122) {
                    asciiArray[i] = asciiArray[i] - 26 + key;
                } else {
                    asciiArray[i] += key;
                }
                // If statement for capital letters
            } else if (asciiArray[i] < 97) {
                if (asciiArray[i] + key > 90) {
                    asciiArray[i] = asciiArray[i] - 26 + key;
                } else {
                    asciiArray[i] += key;
                }
            }
            charArray[i] = (char) asciiArray[i];
        }
        String result = String.valueOf(charArray);
        AlertBox.display("Password", result);
    }

    public static void caesarDecrypt(TextField caesarText, ChoiceBox<Integer> caesarKey) {

        String text = caesarText.getText();
        text = Normalizer.normalize(text, Normalizer.Form.NFKD);
        text = Remove.removeSpecialExceptSpace(text);
        int key = caesarKey.getValue();
        char[] charArray = text.toCharArray();
        int[] asciiArray = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            asciiArray[i] = (int) charArray[i];
            // Keep char if it is a space
            if (asciiArray[i] == 32) {
                charArray[i] = 32;
                // If statement for small letters
            } else if (asciiArray[i] >= 97) {
                if (asciiArray[i] - key < 97) {
                    asciiArray[i] += 26 - key;
                } else {
                    asciiArray[i] -= key;
                }
                // If statement for capital letters
            } else if (asciiArray[i] < 97) {
                if (asciiArray[i] - key < 65) {
                    asciiArray[i] += 26 - key;
                } else {
                    asciiArray[i] -= key;
                }
            }
            charArray[i] = (char) asciiArray[i];
        }
        String result = String.valueOf(charArray);
        AlertBox.display("Password", result);
    }
}
