
package Clases;

import Ventanas.Habitacion;
import static Ventanas.Habitaciones.Disp;
import static Ventanas.Habitaciones.Mant;
import static Ventanas.Habitaciones.Ocup;
import static Ventanas.Habitaciones.Resev;
import static Ventanas.Habitaciones.label_Hab;
import static Ventanas.Habitaciones.panel_Hab;
import java.awt.Color;
import java.awt.Cursor;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;

public class Control {
    
    static Controlador control=new Controlador();
    
    public static String usuario = ""; //Se almacenará el nombre y apellido del empleado
    public static String empleado = ""; //Se almacenará el nombre de usuario del empleado
    public static String cargo = "";
    /*CONTROL DE COLOR DE INTERFAZ*/
    //Default
    public static Color color_Head_D = new Color (13,39,70);
    public static Color color_Body_D = new Color (248,177,57);
    //Blanco
    public static Color color_Body = new Color (255,255,255);
    
    
    public static  ArrayList<Habitacion> RecuperarDatos(){
        ArrayList<Habitacion> datosHab = new ArrayList<>();
        for(int i=1; i<17; i++){
            int _numero = Integer.parseInt(control.DevolverRegistroDto("SELECT numero FROM vw_habitacion WHERE id = "+i+" order by id;", 1));
            String _estado = control.DevolverRegistroDto("SELECT estado FROM vw_habitacion WHERE id = "+i+" order by id;", 1);
            String _tipo = control.DevolverRegistroDto("SELECT tipo FROM vw_habitacion WHERE id = "+i+" order by id;", 1);
            double _precio = Double.parseDouble(control.DevolverRegistroDto("SELECT precio FROM vw_habitacion WHERE id = "+i+" order by id;", 1));
            datosHab.add(new Habitacion(_numero, _estado, _tipo, _precio));
        }
        return datosHab;
    }
    public void AddColorPaneles(ArrayList<Habitacion> datosHab){ //REC: Primero, desde la DB recoger el estado y almacenarlo en EstadoHab[]
        for (int i = 0; i < 16; i++) {
            switch (datosHab.get(i).estado){
                case "Disponible":
                    panel_Hab[i].setBackground(Disp);
                    break;
                case "Ocupado":
                    panel_Hab[i].setBackground(Ocup);
                    break;
                case "Reservado":
                    panel_Hab[i].setBackground(Resev);
                    break;
                case "Mantenimiento":
                    panel_Hab[i].setBackground(Mant);
                    break;
                default:
                    panel_Hab[i].setBackground(Color.gray);
                    break;
            }
        }
    }
    public void AddLabelInPanel(ArrayList<Habitacion> datosHab, MouseListener listener){ //Añade el numero de habitacion        
        for (int i=0; i<16; i++){
            label_Hab[i] = new JLabel();
            label_Hab[i].setText(""+datosHab.get(i).numero);
            label_Hab[i].setBounds(10,10,78,70);
            label_Hab[i].setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
            label_Hab[i].setForeground(new java.awt.Color(23, 23, 23));
            label_Hab[i].setCursor(new Cursor(HAND_CURSOR));
            label_Hab[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            
            label_Hab[i].addMouseListener(listener);
            
            //label_Hab[i].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
            panel_Hab[i].add(label_Hab[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(10,10,78,70));
        }
    }
    
    public static  ArrayList<Habitacion> datHab;
}
