/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius.view.other;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Dinuka
 */
public class Encription {

    /*Method for encript data © Dinuka Kasun Medis*/
    public static String encriptTxt(String txt) {
        String encripted=null;
        try {
            byte[] key=txt.getBytes("UTF-8");
            encripted= DatatypeConverter.printHexBinary(key);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Encription.class.getName()).log(Level.SEVERE, null, ex);
        }
        return encripted;
    }
    
    /*Method for decript data © Dinuka Kasun Medis*/
    public static String decriptTxt(String txt) {
        int len = txt.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(txt.charAt(i), 16) << 4)+Character.digit(txt.charAt(i+1), 16));
        }
        return new String(data);
    }
}
