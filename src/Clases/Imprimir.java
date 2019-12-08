package Clases;

import java.net.URL;
import java.sql.Connection;
import java.util.*;
import javax.print.DocFlavor;
import javax.swing.*;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;import net.sf.jasperreports.view.*;
import net.sf.jasperreports.*;
import net.sf.jasperreports.engine.*;

public class Imprimir {
  Conexion cconn= new Conexion(); 
  //Connection con=new cconn.getConexion();
  
  public void ImprGeneral(String Nomrep, String Titulo) {
   try {
    Map parame = new HashMap();
    String rta = System.getProperties().getProperty("user.dir") + "/src/Reportes/"
    + Nomrep+".jasper";parame.put("", "");
    JasperPrint prt = JasperFillManager.fillReport(rta, parame, cconn.conec);
    
    int n = prt.getPages().size();
    
    if (n > 0) {
     JasperViewer JsperView = new JasperViewer(prt, false);JsperView.setTitle(Titulo);
     JsperView.setExtendedState(6);JsperView.show();
    } else {JOptionPane.showMessageDialog(null, "No hay datos");}
    } catch (Exception E) {}
   }  
  
   public void ImprCon1Parametro(String Nomrep, String Titulo,String nmbp,String vlrprm) {
        try {
            Map parame = new HashMap();
            String rta = System.getProperties().getProperty("user.dir") + "/src/Reportes/" + Nomrep+".jasper";
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
        } catch (Exception E) {
        }
    }
      
}
