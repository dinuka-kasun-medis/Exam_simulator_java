/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius.view.other;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author Dinuka
 */
public class Validation {
    
    /*Method for validate phone number © Dinuka Kasun Medis*/
    public static int phoneNumber(JTextField textFild) {
        String txt = textFild.getText();
        int caretPosition = textFild.getCaretPosition();
        if (!txt.matches("^[0-9]{0,10}$")) {
            txt = txt.substring(0, caretPosition - 1) + txt.substring(caretPosition);
            textFild.setText(txt);
            textFild.setCaretPosition(caretPosition - 1);
        }
        if (txt.matches("^[0][1-9]{2}[0-9]{7}$")) {
            return 1;
        } else {
            return 0;
        }
    }
    
    /*Method for validate user name © Dinuka Kasun Medis*/
    public static boolean validateUserName(String text) {
        String regex = "^{\\s}[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }
    
    /*Method for validate NIC © Dinuka Kasun Medis*/
    public static boolean validateNic(String text) {
        String regex = "^[0-9]{0,9}[xXvV]{0,1}+$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }
    
    /*Method for validate text © Dinuka Kasun Medis*/
    public static boolean validateTxt(String text){
        String regex = "^[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }
}
