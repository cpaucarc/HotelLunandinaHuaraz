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

    public void Decimal(KeyEvent e, JTextField tx) {
        char caracter = e.getKeyChar();
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != KeyEvent.VK_BACK_SPACE)
                && (caracter != '.' || tx.getText().contains("."))) {
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
}
