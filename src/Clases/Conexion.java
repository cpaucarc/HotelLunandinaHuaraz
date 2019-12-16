
package Clases;
import static Clases.Controlador.Base;
import java.awt.HeadlessException;
import java.io.*;
import java.sql.*;
import javax.swing.*;
public class Conexion {
    
 //**********************ATRIBUTOS*****************************************
    
 public PreparedStatement prest=null;
 public  CallableStatement cllst=null;
 public static Connection conec=null; 
 //public  Connection conec1=null;
 public Statement st=null, st1=null; 
 public  ResultSet rt=null,rt1=null;
 
 public static String usu,contraseña,host,db; 
 
 //**********************ATRIBUTOS******************************************
 
  public Conexion() {
    try{ 
       usu="root";
       contraseña="";
       host="localhost";
       db="hotel_lunandina";    
        String url="jdbc:mysql://"+host+"/"+db;       
        Class.forName("com.mysql.jdbc.Driver").newInstance();   //com.mysql.cj.jdbc.Driver
        conec=DriverManager.getConnection(url, usu, contraseña);
        
        System.out.println("Conexion exitosa con DB - "+db);
        //JOptionPane.showMessageDialog(null, "Base de Datos: " + db + "\nconectado con EXITO ");
    }
    catch(Exception e){e.printStackTrace();
    JOptionPane.showMessageDialog(null, "ERROR en Conexion");
    }
  }
  
}
