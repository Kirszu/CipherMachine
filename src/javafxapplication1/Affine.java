package javafxapplication1;

import java.text.Normalizer;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 *
 * @author marcin.kirsz
 */
public class Affine {

    public static void affineEncrypt(TextField affineText, ChoiceBox<Integer> affineKeyA, ChoiceBox<Integer> affineKeyB) {
        int keyA = affineKeyA.getValue();
        int keyB = affineKeyB.getValue();
        String text = affineText.getText();
        text = Normalizer.normalize(text, Normalizer.Form.NFKD);
        text = Remove.removeSpecial(text).toUpperCase();
        char[] charArray = text.toCharArray();
        int[] asciiArray = new int[text.length()];
        int[] newAsciiArray = new int[text.length()];
        int[] asciiCharsAdded = new int[text.length()];

        // Using the affine cipher formula
        for (int i = 0; i < text.length(); i++) {
            asciiArray[i] = (int) charArray[i];
            newAsciiArray[i] = ((keyA * asciiArray[i] + keyB) % 26) + 65;
            if (newAsciiArray[i] >= 78) {
                asciiCharsAdded[i] = newAsciiArray[i] - 13;
            } else {
                asciiCharsAdded[i] = newAsciiArray[i] + 13;
            }
            charArray[i] = (char) asciiCharsAdded[i];
        }

        String result = String.valueOf(charArray);
        AlertBox.display("Password", result);
    }

    public static void affineDecrypt(TextField affineText, ChoiceBox<Integer> affineKeyA, ChoiceBox<Integer> affineKeyB) {
        int keyA = affineKeyA.getValue();
        int keyB = affineKeyB.getValue();
        String text = affineText.getText();
        text = Normalizer.normalize(text, Normalizer.Form.NFKD);
        text = Remove.removeSpecial(text).toUpperCase();
        char[] charArray = text.toCharArray();
        int[] asciiArray = new int[text.length()];
        int[] newAsciiArray = new int[text.length()];
        int[] asciiCharsAdded = new int[text.length()];

        // Invertion of keyA
        int inv = 0;
        int temp;
        for (int i = 0; i <= 26; i++) {
            temp = (keyA * i) % 26;
            if (temp == 1) {
                inv = i;
                break;
            }
        }

        // Using the affine decipher formula
        for (int i = 0; i < text.length(); i++) {
            asciiArray[i] = (int) charArray[i];
            newAsciiArray[i] = (inv * (asciiArray[i] - keyB) % 26) + 65;
            if (newAsciiArray[i] >= 78) {
                asciiCharsAdded[i] = newAsciiArray[i] - 13;
            } else {
                asciiCharsAdded[i] = newAsciiArray[i] + 13;
            }
            charArray[i] = (char) asciiCharsAdded[i];
        }
        String result = String.valueOf(charArray);
        AlertBox.display("Password", result);
    }
}
