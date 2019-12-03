/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.event.*;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * **** @author User ********
 */
public class Textos {

    static public void Mayusculas(KeyEvent e) {
        if (Character.isLowerCase(e.getKeyChar())) {
            e.setKeyChar(("" + e.getKeyChar()).toUpperCase().charAt(0));
        }
    }

    static public void Numeros(KeyEvent e) {
        if (!Character.isDigit(e.getKeyChar())) {
            e.consume();
        }
    }

    static public void LimiteCaracter(KeyEvent e, JTextField tx, int limite) { //Limita al JTextField a un numero dado, ejemplo txdni --> 8
        if (tx.getText().length() >= limite) {
            e.consume();
        }
    }

    public void Decimal(KeyEvent e, JTextField tx) {
        char caracter = e.getKeyChar();
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != KeyEvent.VK_BACK_SPACE)
                && (caracter != '.' || tx.getText().contains("."))) {
            e.consume();
        }
    }

    static public void letras(KeyEvent e, JTextField tx) {

        for (int i = 0; i < tx.getText().length(); i++) {
            if (tx.getText().charAt(i) == 'A') {
                e.consume();
            }
        }
    }

    static public void LimitarCaracter(KeyEvent e, JTextField tx, int limite) {
        if (tx.getText().length() == limite) {
            e.consume();
        }
    }

    public int SeleccionarId(JTable tabla) {
        String idfac = "-1";
        if (tabla.getSelectedRow() > -1) {
            idfac = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
        }
        return Integer.parseInt(idfac);
    }

    public double A_Double(JTextField tx) {
        return Double.parseDouble(tx.getText());
    }

    public double A_Int(JTextField tx) {
        return Integer.parseInt(tx.getText());
    }

    public String A_Stg(JComboBox cbo) {
        return cbo.getSelectedItem().toString();
    }

    //Devuelve la palabra ingresada con la primera letra Mayuscula y el resto en Minuscula
    public static String capitalizeWord(String txt) {
        char aux;
        aux = txt.toUpperCase().charAt(0);
        return (aux + txt.toLowerCase().substring(1));
    }

    //Devuelve el texto ingresado con la primera letra Mayuscula y el resto en Minuscula
    public static String capitalizeText(String txt) {
        String name = "";
        String[] words;
        words = txt.split(" ");
        for (String word : words) {
            name += capitalizeWord(word);
            name += " ";
        }
        return name.substring(0, (name.length() - 1));
    }
}
