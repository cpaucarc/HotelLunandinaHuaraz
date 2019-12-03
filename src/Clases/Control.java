
package Clases;

import Ventanas.Habitacion;
import java.awt.Color;
import java.util.ArrayList;

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
    
    public static  ArrayList<Habitacion> datHab;
}
