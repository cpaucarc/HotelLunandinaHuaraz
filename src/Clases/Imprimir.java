package Clases;

import java.util.*;
import javax.swing.*;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.*;

public class Imprimir {

    Conexion cconn = new Conexion();
    //Connection con=new cconn.getConexion();

    public void ImprGeneral(String Nomrep, String Titulo) {
        try {
            Map parame = new HashMap();
            String rta = System.getProperties().getProperty("user.dir") + "/src/Reportes/"
                    + Nomrep + ".jasper";
            parame.put("", "");
            JasperPrint prt = JasperFillManager.fillReport(rta, parame, cconn.conec);

            int n = prt.getPages().size();

            if (n > 0) {
                JasperViewer JsperView = new JasperViewer(prt, false);
                JsperView.setTitle(Titulo);
                JsperView.setExtendedState(6);
                JsperView.show();
            } else {
                JOptionPane.showMessageDialog(null, "No hay datos");
            }
        } catch (Exception E) {
        }
    }
    
    //Impresion para 1 Parametro
    public void ImprCon1Parametro(String Nomrep, String Titulo, String nmbp, String vlrprm) {
        try {
            Map parame = new HashMap();
            String rta = System.getProperties().getProperty("user.dir") + "/src/Reportes/" + Nomrep + ".jasper";
            parame.put(nmbp, vlrprm);
            JasperPrint prt = JasperFillManager.fillReport(rta, parame, cconn.conec);
            int n = prt.getPages().size();
            if (n > 0) {
                JasperViewer JsperView = new JasperViewer(prt, false);
                JsperView.setTitle(Titulo);
                JsperView.setExtendedState(6);
                JsperView.show();
            } else {
                JOptionPane.showMessageDialog(null, "No hay datos");
            }
        } catch (Exception E) {}
    }
    //Impresion para 2 Parametro
    public void Imp2P(String Nomrep, String Titulo, String prm1, String prm2, String vlrprm1, String vlrprm2) {
        try {
            Map parame = new HashMap();
            String rta = System.getProperties().getProperty("user.dir") + "/src/Reportes/" + Nomrep + ".jasper";
            parame.put(prm1, vlrprm1);
            parame.put(prm2, vlrprm2);
            JasperPrint prt = JasperFillManager.fillReport(rta, parame, cconn.conec);
            int n = prt.getPages().size();
            if (n > 0) {
                JasperViewer JsperView = new JasperViewer(prt, false);
                JsperView.setTitle(Titulo);
                JsperView.setExtendedState(6);
                JsperView.show();
            } else {
                JOptionPane.showMessageDialog(null, "No hay datos");
            }
        } catch (Exception E) {
        }
    }
    //Impresion para 3 Parametro
    public void Imp3P(String Titu, String NRpt, String prm1, String vlrprm1,
            String prm2, String vlrprm2, String prm3, String vlrprm3) {
        try {
            Map parame = new HashMap();
            String rta = System.getProperties().getProperty("user.dir") + "/src/Reportes/" + NRpt + ".jasper";
            parame.put(prm1, vlrprm1);
            parame.put(prm2, vlrprm2);
            parame.put(prm3, vlrprm3);
            JasperPrint prt = JasperFillManager.fillReport(rta, parame, cconn.conec);
            int n = prt.getPages().size();
            if (n > 0) {
                if (JOptionPane.showConfirmDialog(null, "Deseas Previsualizar primero", "Confirmar", 0) == 0) {
                    JasperViewer JsperView = new JasperViewer(prt, false);
                    JsperView.setTitle(Titu);
                    JsperView.setExtendedState(6);
                    JsperView.show();
                } else {
                    net.sf.jasperreports.engine.JasperPrintManager.printReport(prt, false);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay datos");
            }
        } catch (Exception E) {
        }
    }
    //Impresion para 4 Parametro
    public void Imp4P(String Titu, String NRpt, String prm1, String prm2, String prm3, String prm4,
            String vlr1, String vlr2, String vlr3, String vlr4) {
        try {
            Map parame = new HashMap();
            String rta = System.getProperties().getProperty("user.dir") + "/src/Reportes/" + NRpt
                    + ".jasper";
            parame.put(prm1, vlr1);
            parame.put(prm2, vlr2);
            parame.put(prm3, vlr3);
            parame.put(prm4, vlr4);

            JasperPrint prt = JasperFillManager.fillReport(rta, parame, cconn.conec);
            int n = prt.getPages().size();
            if (n > 0) {
                if (JOptionPane.showConfirmDialog(null, "Deseas Previsualizar primero", "Confirmar",
                         0) == 0) {
                    JasperViewer JsperView = new JasperViewer(prt, false);
                    JsperView.setTitle(Titu);
                    JsperView.setExtendedState(6);
                    JsperView.show();
                } else {
                    net.sf.jasperreports.engine.JasperPrintManager.printReport(prt, false);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay datos");
            }
        } catch (Exception E) {
        }
    }
    //Impresion para 5 Parametro
    public void Imp5P(String Titu, String NRpt, String prm1, String prm2, String prm3, String prm4, String prm5,
            String vlr1, String vlr2, String vlr3, String vlr4,String vlr5) {
        try {
            Map parame = new HashMap();
            String rta = System.getProperties().getProperty("user.dir") + "/src/Reportes/" + NRpt
                    + ".jasper";
            parame.put(prm1, vlr1);
            parame.put(prm2, vlr2);
            parame.put(prm3, vlr3);
            parame.put(prm4, vlr4);
            parame.put(prm5, vlr5);
            JasperPrint prt = JasperFillManager.fillReport(rta, parame, cconn.conec);
            int n = prt.getPages().size();
            if (n > 0) {
                if (JOptionPane.showConfirmDialog(null, "Deseas Previsualizar primero", "Confirmar",
                         0) == 0) {
                    JasperViewer JsperView = new JasperViewer(prt, false);
                    JsperView.setTitle(Titu);
                    JsperView.setExtendedState(6);
                    JsperView.show();
                } else {
                    net.sf.jasperreports.engine.JasperPrintManager.printReport(prt, false);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay datos");
            }
        } catch (Exception E) {
        }
    }

}
