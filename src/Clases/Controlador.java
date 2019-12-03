/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class Controlador {

    public static Conexion Base = new Conexion();

    public void LlenarCombo(JComboBox cbo, String Consulta, int pos) {
        cbo.removeAllItems();
        cbo.addItem("--Seleccione--");
        try {
            Base.rt = DevolverRegistro(Consulta);
            while (Base.rt.next()) {
                cbo.addItem(Base.rt.getString(pos));
            }
            cbo.setSelectedIndex(-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet DevolverRegistro(String sq) {
        try {
            Base.st = Base.conec.createStatement();
            Base.rt = Base.st.executeQuery(sq);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Base.rt;
    }

    public void LlenarLista(DefaultListModel mdlt, String Consulta, int pos) {
        mdlt.removeAllElements();
        try {
            Base.rt = DevolverRegistro(Consulta);
            while (Base.rt.next()) {
                mdlt.addElement(Base.rt.getString(pos));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void LimpJtable(DefaultTableModel mdtb) {
        while (mdtb.getRowCount() > 0) {
            mdtb.removeRow(0);
        }
    }

    public void CrearRegistro(String sq) {
        try {
            Base.st = Base.conec.createStatement();
            Base.st.executeUpdate(sq);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String CrearRegistro1(String sq, String dto) {

        try {
            Base.st = Base.conec.createStatement();
            Base.st.executeUpdate(sq);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /*PARA EL USO DE PROC ALMACENADOS*/
    public String DevolverRegistroDto(String sq, int pos) {
        String rs = "";
        try {
            Base.st = Base.conec.createStatement();
            Base.rt = Base.st.executeQuery(sq);
            if (Base.rt.next()) {
                rs = Base.rt.getString(pos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void SeleccionarTx(JTextField tx) {
        tx.setSelectionStart(0);
        tx.setSelectionEnd(tx.getText().length());
        tx.grabFocus();
    }

    public boolean Verficnst(String sq) {
        boolean b = false;
        try {
            Base.st = Base.conec.createStatement();
            Base.rt = Base.st.executeQuery(sq);
            b = Base.rt.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    public void LlenarJtable(DefaultTableModel mdtb, String cnst, int lgt) {
        try {
            LimpJtable(mdtb);
            String[] dt = new String[lgt];
            Base.rt = DevolverRegistro(cnst);
            while (Base.rt.next()) {
                for (int n = 0; n < lgt; n++) {
                    dt[n] = Base.rt.getString(n + 1);
                }
                mdtb.addRow(dt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void VolverAtx(JTextField tx) {
        if (tx.getText().trim().length() == 0) {
            tx.grabFocus();
        }
    }

    public void LlenarComboHB(JComboBox cbo, String Consulta, int pos) {
        cbo.removeAllItems();
        cbo.addItem("--Seleccione--");
        try {
            Base.rt = DevolverRegistro(Consulta);
            while (Base.rt.next()) {
                cbo.addItem(Base.rt.getString(pos));
            }
            cbo.setSelectedIndex(-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
