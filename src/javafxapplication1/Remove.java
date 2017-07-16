/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

/**
 *
 * @author marcin.kirsz
 */
public class Remove {
     public static String removeSpecialExceptSpace(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isLetter(text.charAt(i)) && text.charAt(i) != ' '){
                text = text.substring(0, i) + text.substring(i + 1);
                i--;
            }        
        }
        return text;
    }
     
     public static String removeSpecial(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isLetter(text.charAt(i))){
                text = text.substring(0, i) + text.substring(i + 1);
                i--;
            }        
        }
        return text;
    }
      
    
}
