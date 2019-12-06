package Ventanas;

import Clases.Control;
import Clases.ControlDate;
import Clases.Controlador;
import Clases.Textos;
import alertas.Alerta;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author CLINTON
 */
public class Reservas extends javax.swing.JFrame {
DefaultTableModel modelo = new DefaultTableModel(){
    public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
};
DefaultTableModel modelo1 = new DefaultTableModel(){
    public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
};
Controlador control=new Controlador();
    ControlDate cd=new ControlDate();
    public String rpt = "";
    int _idusuario;
    public Reservas() {
        initComponents();
        
        _idusuario= Integer.parseInt(control.DevolverRegistroDto("SELECT idusuario FROM usuarios WHERE login = '"+Control.empleado+"'", 1));
        ((JTextField)this.dcBuscar.getDateEditor()).setEditable(false);
        txtBuscar.setVisible(false);
        txtBuscar1.setVisible(true);
                
        this.getContentPane().setBackground(Color.white);
        btValidar.setEnabled(false);
        this.setLocationRelativeTo(null);
        lbUserActual.setText(Control.usuario);
        tabla.getTableHeader().setOpaque(true);
        tabla.getTableHeader().setBackground(new Color(248,177,57));
        btValidar.setVisible(false);
//        control.LlenarCombo(jComboBox1, "select * from habitaciones", 2);
        control.LlenarCombo(jComboBox2, "select * from tipohabitacion", 2);
        jComboBox2.removeItemAt(0);
        jComboBox1.removeAllItems();
        
        //Ocultamos algunas funciones        
        lbReiniciar.setVisible(false);
//        pnTipoCliente.setVisible(true);
        pnClienteEmpresa.setVisible(false);
        pnClientePersona.setVisible(false);
        pnFecha.setVisible(false);
        pnHabitacion.setVisible(false);
        btRegistrar.setVisible(false);
        btRegistrar1.setVisible(false);
        btModificar.setVisible(false);
        btModificar1.setVisible(false);
        btEliminar.setVisible(false);
//        jPanel5.setVisible(false);
        //Listener de tabla
        tabla.addMouseListener(new MouseListener() {
            @Override public void mouseClicked(MouseEvent e) {
                if(tabla.getSelectedRow()>-1){
                    btValidar.setEnabled(true);
                }else{
                    btValidar.setEnabled(false);                    
                }
            }
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });
        inicializarJTable_cliente();
          MostrarList_Cliente();
        
    }
    String idres = "";
    int numval;
    int numval1;
    public void reconocer_empresa(){
        String Rc =txRUC.getText().toString();
        int contDn = Integer.parseInt(control.DevolverRegistroDto("select count(*) from clienteempresa where RUC='" + Rc + "';", 1));
      if (contDn != 0 && txRUC.getText().length()==11){
                jTextField1.setText(control.DevolverRegistroDto("select  empresa from v_reservaEmp where RUC='" + Rc + "' limit 1;", 1));
                jTextField2.setText(control.DevolverRegistroDto("select  Procedencia from v_reservaEmp where RUC='" + Rc + "' limit 1;", 1));
                jTextField3.setText(control.DevolverRegistroDto("select  email from clienteempresa where RUC='" + Rc + "';", 1));
      }
      if(txRUC.getText().length()!=11){
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
      }
        }
    public void reconocer_cliente(){
        String dni =txDNI.getText().toString();
        int contDn = Integer.parseInt(control.DevolverRegistroDto("select count(*) from personas where DNI='" + dni + "';", 1));
      if (contDn != 0 && txDNI.getText().length()==8){
         jtxtdni1.setText(control.DevolverRegistroDto("select  apPat from personas where DNI='" + dni + "';", 1));
         jtxtdni2.setText(control.DevolverRegistroDto("select  apMat from personas where DNI='" + dni + "';", 1));
         jtxtdni3.setText(control.DevolverRegistroDto("select  nomb from personas where DNI='" + dni + "';", 1));
         jtxtdni4.setText(control.DevolverRegistroDto("select  lugar from vw_clientepersona where DNI='" + dni + "' limit 1;", 1));
         jtxtdni10.setText(control.DevolverRegistroDto("select  email from personas where DNI='" + dni + "';", 1)); 
      }
      if(txDNI.getText().length()!=8){
        jtxtdni1.setText("");
        jtxtdni2.setText("");
        jtxtdni3.setText("");
        jtxtdni4.setText("");
        jtxtdni10.setText("");
      }
        }
    public void Seleccionar_Cliente(){
        Alerta alr = new Alerta(this, true);

        if (btModificar.getText().equals("Modificar")) {
            btRegistrar1.setEnabled(false);
            btModificar.setText("Actualizar");
            int fila = tabla.getSelectedRow();
            if (fila > -1) {
                idres = modelo1.getValueAt(fila, 0).toString();
                String dni = modelo1.getValueAt(fila, 6).toString();
                int contDn = Integer.parseInt(control.DevolverRegistroDto("select count(*) from personas where DNI='" + dni + "';", 1));
                txDNI.setText(modelo1.getValueAt(fila, 6).toString());
                if (contDn != 0) {

                    jtxtdni1.setText(control.DevolverRegistroDto("select  apPat from personas where DNI='" + dni + "';", 1));
                    jtxtdni2.setText(control.DevolverRegistroDto("select  apMat from personas where DNI='" + dni + "';", 1));
                    jtxtdni3.setText(control.DevolverRegistroDto("select  nomb from personas where DNI='" + dni + "';", 1));
                    jtxtdni4.setText(modelo1.getValueAt(fila, 8).toString());
                    jtxtdni10.setText(control.DevolverRegistroDto("select  email from personas where DNI='" + dni + "';", 1));
                    jDateChooser5.setDate(cd.Parse_Fecha(modelo1.getValueAt(fila, 2).toString()));
                    jDateChooser4.setDate(cd.Parse_Fecha(modelo1.getValueAt(fila, 3).toString()));
                    jComboBox2.setSelectedItem(modelo1.getValueAt(fila, 5).toString());
                    jComboBox1.removeAllItems();
                    jComboBox1.addItem(modelo1.getValueAt(fila, 4).toString());
//            jComboBox1.setSelectedItem(modelo1.getValueAt(fila, 4).toString());
                    numval = Integer.parseInt(modelo1.getValueAt(fila, 4).toString());
//           valHab_Client();
                    tabla.setEnabled(false);
                }
            } else {
                //alertas
                rpt = "Fila no <br>seleccionada";
                alr.titulo.setText("<html><center>" + rpt + "</center></html>");
                alr.setVisible(true);
                //alertas

                btModificar.setText("Modificar");
                btRegistrar1.setEnabled(true);
                tabla.setEnabled(true);
            }
        } else {
            Editar_Persona(numval);
//            btModificar.setText("Modificar");
//            btRegistrar1.setEnabled(true);
        }
    }
    public void Seleccionar_Empresa(){
        Alerta alr = new Alerta(this, true);

        if (btModificar1.getText().equals("Modificar")) {
            btRegistrar.setEnabled(false);
            btModificar1.setText("Actualizar");
            int fila = tabla.getSelectedRow();
            if (fila > -1) {
                idres = modelo.getValueAt(fila, 0).toString();
                String Rc = modelo.getValueAt(fila, 6).toString();
                int contDn = Integer.parseInt(control.DevolverRegistroDto("select count(*) from clienteempresa where RUC='" + Rc + "';", 1));
                txRUC.setText(modelo.getValueAt(fila, 6).toString());
                if (contDn != 0) {

                    jTextField1.setText(modelo.getValueAt(fila, 7).toString());
                    jTextField2.setText(modelo.getValueAt(fila, 8).toString());
                    jTextField3.setText(control.DevolverRegistroDto("select email from clienteempresa where RUC='" + Rc + "';", 1));
                    jDateChooser5.setDate(cd.Parse_Fecha(modelo.getValueAt(fila, 2).toString()));
                    jDateChooser4.setDate(cd.Parse_Fecha(modelo.getValueAt(fila, 3).toString()));
                    jComboBox2.setSelectedItem(modelo.getValueAt(fila, 5).toString());
                    jComboBox1.removeAllItems();
                    jComboBox1.addItem(modelo1.getValueAt(fila, 4).toString());
                    numval1 = Integer.parseInt(modelo.getValueAt(fila, 4).toString());
//            valHab_Client();
                }
            } else {
                //alertas
                rpt = "Fila no <br>seleccionada";
                alr.titulo.setText("<html><center>" + rpt + "</center></html>");
                alr.setVisible(true);
                //alertas
                btModificar1.setText("Modificar");
                btRegistrar.setEnabled(true);
            }
        } else {
            Editar_Empresa(numval1);
//            btModificar1.setText("Modificar");
//            btRegistrar.setEnabled(true);
        }
    }
    public void crear_Empresa() {
        Alerta alr = new Alerta(this, true);

        int count = tabla.getRowCount();
//        JOptionPane.showMessageDialog(null, count);
        int idest = Integer.parseInt(control.DevolverRegistroDto("select idhabitacion from habitaciones where numHab='" + jComboBox1.getSelectedItem() + "';", 1));
        rpt = (control.DevolverRegistroDto("call Proc_ReservaEmp("
                + "'1',"
                + "'" + 0 + "',"
                + "'" + jTextField2.getText() + "',"
                + "'" + txRUC.getText() + "',"
                + "'" + jTextField1.getText() + "',"
                + "'" + jTextField3.getText() + "',"
                + "'" + cd.fecha_AMD(jDateChooser5.getDate()) + "',"
                + "'" + cd.fecha_AMD(jDateChooser4.getDate()) + "',"
                + "'" + idest + "',"
                + "'" + 0 + "',"
                + _idusuario + ")", 1));
        //alertas
        alr.titulo.setText("<html><center>" + rpt + "</center></html>");
        alr.setVisible(true);
        //alertas

        MostrarList_Empresa();
        int count1 = tabla.getRowCount();
        if (count != count1) {
            Limpiar();
        }
    }
    public void Editar_Empresa(int numHab) { 
        Alerta alr = new Alerta(this, true);

        int val1 = Integer.parseInt(control.DevolverRegistroDto("select DATEDIFF('" + cd.fecha_AMD(jDateChooser4.getDate()) + "','" + cd.fecha_AMD(jDateChooser5.getDate()) + "');", 1));
        int val2 = Integer.parseInt(control.DevolverRegistroDto("select DATEDIFF('" + cd.fecha_AMD(jDateChooser5.getDate()) + "',(CURDATE()-1));", 1));
        int idest = Integer.parseInt(control.DevolverRegistroDto("select idhabitacion from habitaciones where numHab='" + jComboBox1.getSelectedItem() + "';", 1));
        rpt = (control.DevolverRegistroDto("call Proc_ReservaEmp("
                + "'2',"
                + "'" + idres + "',"
                + "'" + jTextField2.getText() + "',"
                + "'" + txRUC.getText() + "',"
                + "'" + jTextField1.getText() + "',"
                + "'" + jTextField3.getText() + "',"
                + "'" + cd.fecha_AMD(jDateChooser5.getDate()) + "',"
                + "'" + cd.fecha_AMD(jDateChooser4.getDate()) + "',"
                + "'" + idest + "',"
                + "'" + numHab + "',"
                + _idusuario + ")", 1));
        //alertas
        alr.titulo.setText("<html><center>" + rpt + "</center></html>");
        alr.setVisible(true);
        //alertas
        MostrarList_Empresa();
        if (val1 > 0 && val2 > 0) {
            Limpiar();
            btModificar1.setText("Modificar");
            btRegistrar.setEnabled(true);
        }
    }
    public void Limpiar(){
        tabla.setEnabled(true);
        jTextField2.setText("");
        txRUC.setText("");
        jTextField1.setText("");
        jTextField3.setText("");
        jDateChooser5.setDate(null);
        jDateChooser4.setDate(null);
        jComboBox1.setSelectedIndex(-1);
        jComboBox2.setSelectedIndex(-1);
        jtxtdni4.setText("");
        txDNI.setText("");
        jtxtdni1.setText("");
        jtxtdni2.setText("");
        jtxtdni3.setText("");
        jtxtdni10.setText("");
        btModificar.setText("Modificar");
        btModificar1.setText("Modificar");
        tabla.clearSelection();
        btRegistrar.setEnabled(true);
        btRegistrar1.setEnabled(true);
    }
    public void crear_Persona() {
        Alerta alr = new Alerta(this, true);

        int count = tabla.getRowCount();
        int idest = Integer.parseInt(control.DevolverRegistroDto("select idhabitacion from habitaciones where numHab='" + jComboBox1.getSelectedItem() + "';", 1));
        rpt = (control.DevolverRegistroDto("call Proc_ReservaClient("
                + "'1',"
                + "'" + 0 + "',"
                + "'" + jtxtdni4.getText() + "',"
                + "'" + txDNI.getText() + "',"
                + "'" + jtxtdni1.getText() + "',"
                + "'" + jtxtdni2.getText() + "',"
                + "'" + jtxtdni3.getText() + "',"
                + "'" + jtxtdni10.getText() + "',"
                + "'" + cd.fecha_AMD(jDateChooser5.getDate()) + "',"
                + "'" + cd.fecha_AMD(jDateChooser4.getDate()) + "',"
                + "'" + idest + "',"
                + "'" + 0 + "',"
                + _idusuario + ")", 1));
        //alertas
        alr.titulo.setText("<html><center>" + rpt + "</center></html>");
        alr.setVisible(true);
        //alertas
        MostrarList_Cliente();
        int count1 = tabla.getRowCount();
        if (count != count1) {
            Limpiar();
        }
    }
    public void Editar_Persona(int numHab) {
        Alerta alr = new Alerta(this, true);

        int val1 = Integer.parseInt(control.DevolverRegistroDto("select DATEDIFF('" + cd.fecha_AMD(jDateChooser4.getDate()) + "','" + cd.fecha_AMD(jDateChooser5.getDate()) + "');", 1));
        int val2 = Integer.parseInt(control.DevolverRegistroDto("select DATEDIFF('" + cd.fecha_AMD(jDateChooser5.getDate()) + "',(CURDATE()-1));", 1));
        int idest = Integer.parseInt(control.DevolverRegistroDto("select idhabitacion from habitaciones where numHab='" + jComboBox1.getSelectedItem() + "';", 1));
        rpt = (control.DevolverRegistroDto("call Proc_ReservaClient("
                + "'2',"
                + "'" + idres + "',"
                + "'" + jtxtdni4.getText() + "',"
                + "'" + txDNI.getText() + "',"
                + "'" + jtxtdni1.getText() + "',"
                + "'" + jtxtdni2.getText() + "',"
                + "'" + jtxtdni3.getText() + "',"
                + "'" + jtxtdni10.getText() + "',"
                + "'" + cd.fecha_AMD(jDateChooser5.getDate()) + "',"
                + "'" + cd.fecha_AMD(jDateChooser4.getDate()) + "',"
                + "'" + idest + "',"
                + "'" + numHab + "',"
                + _idusuario + ")", 1));
        //alertas
        alr.titulo.setText("<html><center>" + rpt + "</center></html>");
        alr.setVisible(true);
        //alertas
        MostrarList_Cliente();
        if (val1 > 0 && val2 > 0) {
            Limpiar();
            btModificar.setText("Modificar");
            btRegistrar1.setEnabled(true);
        }
    }
    private void MostrarList_Empresa() {
        if(dcBuscar.getDate() != null){
            control.LlenarJtable(modelo, "select * from v_reservaemp  where "
                + "(RUC like '%" + txtBuscar.getText() + "%' or Empresa like '%" + txtBuscar.getText() + "%' ) and Fecha_Resv = '"+cd.fecha_AMD(dcBuscar1.getDate())+"';", 9);
        }else{
            control.LlenarJtable(modelo, "select * from v_reservaemp  where "
                + "RUC like'%" + txtBuscar.getText() +"%' or Empresa like '%" + txtBuscar.getText() + "%';", 9);
        }
    }
    
    
    private void MostrarList_Cliente() {
        if(dcBuscar.getDate() != null){
        control.LlenarJtable(modelo1, "select * from v_reservaclient  where "
              + "(DNI like'%" + txtBuscar1.getText() + "%' or Cliente like '%" + txtBuscar1.getText() + "%' ) and Fecha_Resv = '"+cd.fecha_AMD(dcBuscar.getDate())+"';", 9);
        }else{
            control.LlenarJtable(modelo1, "select * from v_reservaclient  where "
              + "DNI like'%" + txtBuscar1.getText() + "%' or Cliente like '%" + txtBuscar1.getText() + "%';", 9);
        }
        
        
//        control.LlenarJtable(modelo1, "select * from v_reservaclient  where "
//                + "DNI like'%" + txtBuscar1.getText() + "%' or (Fecha_Ent like '%"
//                +cd.CrearFecha(dcBuscar)+"%' or Fecha_Resv like '%"+cd.CrearFecha(dcBuscar)+"%');", 9);
//        Seleccionar();   
    }
    public void inicializarJTable_cliente() {
        modelo1.setColumnIdentifiers(new String[]{"ID","Fecha Reserva", "Fecha Entrada","Fecha Salida","N° Habitacion", "Tipo de Habitacion", "DNI", "Cliente", "Procedencia"});
        tabla.setModel(modelo1);

        tabla.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(95); //Fecha Reserva
        tabla.getColumnModel().getColumn(2).setPreferredWidth(90); //Fecha Entrada
        tabla.getColumnModel().getColumn(3).setPreferredWidth(87); //Fecha Salida
        tabla.getColumnModel().getColumn(4).setPreferredWidth(45); // N° Habitacion
        tabla.getColumnModel().getColumn(5).setPreferredWidth(110); // Tipo Habitacion
        tabla.getColumnModel().getColumn(6).setPreferredWidth(75); // DNI
        tabla.getColumnModel().getColumn(7).setPreferredWidth(200); // Cliente
        tabla.getColumnModel().getColumn(8).setPreferredWidth(75); //Procedencia
        
        tabla.getColumnModel().removeColumn(tabla.getColumnModel().getColumn(0)); 
    }
    public void inicializarJTable_empresa() {
        modelo.setColumnIdentifiers(new String[]{"ID","Fecha Reserva", "Fecha Entrada","Fecha Salida","N° Habitacion", "Tipo de Habitacion", "RUC", "Empresa", "Procedencia"});
        tabla.setModel(modelo);

        tabla.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(95);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(90);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(87);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(45);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(110);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(75);
        tabla.getColumnModel().getColumn(7).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(8).setPreferredWidth(75);
        tabla.getColumnModel().removeColumn(tabla.getColumnModel().getColumn(0));
    }
    public void validarcampos_client(){
       Alerta alr = new Alerta(this, true);

        if (txDNI.getText().length() != 0 && txDNI.getText().length() > 7) {
            if (jtxtdni1.getText().length() != 0) {
                if (jtxtdni2.getText().length() != 0) {
                    if (jtxtdni3.getText().length() != 0) {
                        if (jtxtdni4.getText().length() != 0) {
                            if (jtxtdni10.getText().length() != 0) {
                                if (jDateChooser5.getDate() != null) {
                                    if (jDateChooser4.getDate() != null) {
                                        if (jComboBox2.getSelectedIndex() != -1) {
                                            if (jComboBox1.getSelectedIndex() != -1) {
                                                crear_Persona();
                                                rpt = "";
                                            } else {
                                                rpt = ("Seleccione <br>N° HABITACIÓN");
                                            }
                                        } else {
                                            rpt = ("Seleccione <br>TIPO HABITACIÓN");
                                        }
                                    } else {
                                        rpt = ("Ingrese <br>FECHA DE SALIDA");
                                    }
                                } else {
                                    rpt = ("Ingrese <br>FECHA DE ENTRADA");
                                }
                            } else {
                                rpt = ("Ingrese CORREO");
                            }
                        } else {
                            rpt = ("Ingrese PROCEDENCIA");
                            jtxtdni4.grabFocus();
                        }
                    } else {
                        rpt = ("Ingrese NOMBRE");
                        jtxtdni3.grabFocus();
                    }
                } else {
                    rpt = ("Ingrese <br>apellido MATERNO");
                    jtxtdni2.grabFocus();
                }
            } else {
                rpt = ("Ingrese <br>apellido PATERNO");
                jtxtdni1.grabFocus();
            }
        } else {
            rpt = ("Ingrese DNI(8 dígitos)");
            txDNI.grabFocus();
        }
        //alertas
//        
        if(!rpt.equals("")){
            alr.titulo.setText("<html><center>" + rpt + "</center></html>");
            alr.setVisible(true);
        }
        //alertas
    }
    public void validarcampos_emp(){
       Alerta alr = new Alerta(this, true);

        if (txRUC.getText().length() != 0 && txRUC.getText().length() > 10) {
            if (jTextField1.getText().length() != 0) {
                if (jTextField2.getText().length() != 0) {
                    if (jTextField3.getText().length() != 0) {
                        if (jDateChooser5.getDate() != null) {
                            if (jDateChooser4.getDate() != null) {
                                if (jComboBox2.getSelectedIndex() != -1) {
                                    if (jComboBox1.getSelectedIndex() != -1) {
                                        crear_Empresa();
                                        rpt = "";
                                    } else {
                                        rpt = ("Seleccione <br>N° HABITACIÓN");
                                    }
                                } else {
                                    rpt = ("Seleccione <br>TIPO HABITACIÓN");
                                }
                            } else {
                                rpt = ("Ingrese <br>FECHA DE SALIDA");
                            }
                        } else {
                            rpt = ("Ingrese <br>FECHA DE ENTRADA");
                        }
                    } else {
                        rpt = ("Ingrese CORREO");
                        jTextField3.grabFocus();
                    }
                } else {
                    rpt = ("Ingrese PROCEDENCIA");
                    jTextField2.grabFocus();
                }
            } else {
                rpt = ("Ingrese EMPRESA");
                jTextField1.grabFocus();
            }
        } else {
            rpt = ("Ingrese RUC(11 dígitos)");
            txRUC.grabFocus();
        }
        //alertas
        if(!rpt.equals("")){
            alr.titulo.setText("<html><center>" + rpt + "</center></html>");
            alr.setVisible(true);
        }
        //alertas
    }
    public void valHab_Client(){
//        control.LlenarCombo(jComboBox1, "select idhabitacion,numHab from habitaciones where (idtipoHab=1 and idestadoHab=1);", 2);      
//        jComboBox2.removeItemAt(0);
        if(jComboBox2.getSelectedIndex()==0){ //Individual
           control.LlenarCombo(jComboBox1, "select idhabitacion,numHab from habitaciones where (idtipoHab=1 and idestadoHab=1);", 2);
           jComboBox1.removeItemAt(0);
           if(jComboBox1.getItemCount()==0){
           jComboBox1.removeAllItems();
           jComboBox1.addItem("No hay cuartos");
        }
        }
        if(jComboBox2.getSelectedIndex()==1){ //Doble
           control.LlenarCombo(jComboBox1, "select idhabitacion,numHab from habitaciones where (idtipoHab=2 and idestadoHab=1);", 2);
           jComboBox1.removeItemAt(0);
           if(jComboBox1.getItemCount()==0){
           jComboBox1.removeAllItems();
           jComboBox1.addItem("No hay cuartos");
        }
        }
        if(jComboBox2.getSelectedIndex()==2){ //Triple
           control.LlenarCombo(jComboBox1, "select idhabitacion,numHab from habitaciones where (idtipoHab=3 and idestadoHab=1);", 2);
           jComboBox1.removeItemAt(0);
           if(jComboBox1.getItemCount()==0){
           jComboBox1.removeAllItems();
           jComboBox1.addItem("No hay cuartos");
        }
        }
        if(jComboBox2.getSelectedIndex()==3){ //Matrimonial
           control.LlenarCombo(jComboBox1, "select idhabitacion,numHab from habitaciones where (idtipoHab=4 and idestadoHab=1);", 2);
           jComboBox1.removeItemAt(0);
           if(jComboBox1.getItemCount()==0){
           jComboBox1.removeAllItems();
           jComboBox1.addItem("No hay cuartos");
        }
        }
        if(jComboBox2.getSelectedIndex()==4){ //Matrimonial Lunandina
           control.LlenarCombo(jComboBox1, "select idhabitacion,numHab from habitaciones where (idtipoHab=5 and idestadoHab=1);", 2);
           jComboBox1.removeItemAt(0);
           if(jComboBox1.getItemCount()==0){
           jComboBox1.removeAllItems();
           jComboBox1.addItem("No hay cuartos");
        }
        }
        if(jComboBox2.getSelectedIndex()==5){ //Familiar
           control.LlenarCombo(jComboBox1, "select idhabitacion,numHab from habitaciones where (idtipoHab=6 and idestadoHab=1);", 2);
           jComboBox1.removeItemAt(0);
           if(jComboBox1.getItemCount()==0){
           jComboBox1.removeAllItems();
           jComboBox1.addItem("No hay cuartos");
        }
        }
        
//        if(jComboBox1.getItemCount()==0){
//           jComboBox1.removeAllItems();
//           jComboBox1.addItem("No hay cuartos");
//        }
//        JOptionPane.showMessageDialog(null, jComboBox1.getItemCount());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lbReiniciar = new javax.swing.JLabel();
        lbLimpiar = new javax.swing.JLabel();
        pnTipoCliente = new javax.swing.JPanel();
        btClientePersona = new javax.swing.JButton();
        btClienteEmpresa = new javax.swing.JButton();
        pnClientePersona = new javax.swing.JPanel();
        jLabelDNI2 = new javax.swing.JLabel();
        txDNI = new javax.swing.JTextField();
        jLabelDNI3 = new javax.swing.JLabel();
        jtxtdni1 = new javax.swing.JTextField();
        jtxtdni2 = new javax.swing.JTextField();
        jLabelDNI4 = new javax.swing.JLabel();
        jLabelDNI5 = new javax.swing.JLabel();
        jtxtdni3 = new javax.swing.JTextField();
        jtxtdni4 = new javax.swing.JTextField();
        jLabelDNI6 = new javax.swing.JLabel();
        jLabelDNI12 = new javax.swing.JLabel();
        jtxtdni10 = new javax.swing.JTextField();
        pnClienteEmpresa = new javax.swing.JPanel();
        jLabelDNI18 = new javax.swing.JLabel();
        jLabelDNI19 = new javax.swing.JLabel();
        jLabelDNI20 = new javax.swing.JLabel();
        jLabelDNI21 = new javax.swing.JLabel();
        txRUC = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        btRegistrar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        pnFecha = new javax.swing.JPanel();
        jLabelDNI13 = new javax.swing.JLabel();
        jLabelDNI17 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        pnHabitacion = new javax.swing.JPanel();
        jLabelDNI9 = new javax.swing.JLabel();
        jLabelDNI10 = new javax.swing.JLabel();
        jLabelDNI14 = new javax.swing.JLabel();
        jtxtdni8 = new javax.swing.JTextField();
        jLabelDNI15 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        btRegistrar1 = new javax.swing.JButton();
        btModificar1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbUserActual = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbMinimizar = new javax.swing.JLabel();
        lbCerrar = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabelDNI16 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        dcBuscar = new com.toedter.calendar.JDateChooser();
        btValidar = new javax.swing.JButton();
        txtBuscar1 = new javax.swing.JTextField();
        dcBuscar1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbReiniciar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbReiniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/reiniciar.png"))); // NOI18N
        lbReiniciar.setToolTipText("Reiniciar");
        lbReiniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbReiniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbReiniciarMouseClicked(evt);
            }
        });
        jPanel2.add(lbReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 30, 30));

        lbLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/limpiar.png"))); // NOI18N
        lbLimpiar.setToolTipText("Limpiar formularios");
        lbLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLimpiarMouseClicked(evt);
            }
        });
        jPanel2.add(lbLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 0, -1, -1));

        pnTipoCliente.setBackground(new java.awt.Color(255, 255, 255));
        pnTipoCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "TIPO DE CLIENTE ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        pnTipoCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btClientePersona.setBackground(new java.awt.Color(111, 168, 183));
        btClientePersona.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btClientePersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/persona.png"))); // NOI18N
        btClientePersona.setText("PERSONA");
        btClientePersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClientePersonaActionPerformed(evt);
            }
        });
        pnTipoCliente.add(btClientePersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 35, 150, 50));

        btClienteEmpresa.setBackground(new java.awt.Color(144, 101, 168));
        btClienteEmpresa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btClienteEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/empresa.png"))); // NOI18N
        btClienteEmpresa.setText("EMPRESA");
        btClienteEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClienteEmpresaActionPerformed(evt);
            }
        });
        pnTipoCliente.add(btClienteEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 35, 150, 50));

        jPanel2.add(pnTipoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 25, 461, 120));

        pnClientePersona.setBackground(new java.awt.Color(255, 255, 255));
        pnClientePersona.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "DATOS DEL CLIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Leelawadee UI Semilight", 1, 12))); // NOI18N
        pnClientePersona.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDNI2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDNI2.setText("DNI");
        pnClientePersona.add(jLabelDNI2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 120, 30));

        txDNI.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txDNI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txDNI.setSelectionColor(new java.awt.Color(0, 122, 255));
        txDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txDNIActionPerformed(evt);
            }
        });
        txDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txDNIKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txDNIKeyTyped(evt);
            }
        });
        pnClientePersona.add(txDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 280, 30));

        jLabelDNI3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDNI3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDNI3.setText("A. Paterno");
        jLabelDNI3.setToolTipText("");
        pnClientePersona.add(jLabelDNI3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 120, 30));

        jtxtdni1.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jtxtdni1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtdni1.setSelectionColor(new java.awt.Color(0, 122, 255));
        jtxtdni1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtdni1KeyTyped(evt);
            }
        });
        pnClientePersona.add(jtxtdni1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 280, 30));

        jtxtdni2.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jtxtdni2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtdni2.setSelectionColor(new java.awt.Color(0, 122, 255));
        jtxtdni2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtdni2KeyTyped(evt);
            }
        });
        pnClientePersona.add(jtxtdni2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 280, 30));

        jLabelDNI4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDNI4.setText("Nombres");
        pnClientePersona.add(jLabelDNI4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 120, 30));

        jLabelDNI5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDNI5.setText("Procedencia");
        pnClientePersona.add(jLabelDNI5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 120, 30));

        jtxtdni3.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jtxtdni3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtdni3.setSelectionColor(new java.awt.Color(0, 122, 255));
        jtxtdni3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtdni3KeyTyped(evt);
            }
        });
        pnClientePersona.add(jtxtdni3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 280, 30));

        jtxtdni4.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jtxtdni4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtdni4.setSelectionColor(new java.awt.Color(0, 122, 255));
        jtxtdni4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtdni4KeyTyped(evt);
            }
        });
        pnClientePersona.add(jtxtdni4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 280, 30));

        jLabelDNI6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDNI6.setText("E-mail");
        pnClientePersona.add(jLabelDNI6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 120, 30));

        jLabelDNI12.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDNI12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDNI12.setText("A. Materno");
        jLabelDNI12.setToolTipText("");
        pnClientePersona.add(jLabelDNI12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 120, 30));

        jtxtdni10.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jtxtdni10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtdni10.setSelectionColor(new java.awt.Color(0, 122, 255));
        jtxtdni10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtdni10KeyTyped(evt);
            }
        });
        pnClientePersona.add(jtxtdni10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 280, 30));

        jPanel2.add(pnClientePersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 25, 461, 340));

        pnClienteEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        pnClienteEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "DATOS DE LA EMPRESA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        pnClienteEmpresa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDNI18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDNI18.setText("RUC");
        pnClienteEmpresa.add(jLabelDNI18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 45, 120, 30));

        jLabelDNI19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDNI19.setText("E-mail");
        pnClienteEmpresa.add(jLabelDNI19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 235, 120, 30));

        jLabelDNI20.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDNI20.setText("Nombre");
        pnClienteEmpresa.add(jLabelDNI20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 105, 120, 30));

        jLabelDNI21.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDNI21.setText("Procedencia");
        pnClienteEmpresa.add(jLabelDNI21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 120, 30));

        txRUC.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txRUC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txRUC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txRUCKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txRUCKeyTyped(evt);
            }
        });
        pnClienteEmpresa.add(txRUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 45, 280, 30));

        jTextField1.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        pnClienteEmpresa.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 105, 280, 30));

        jTextField2.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        pnClienteEmpresa.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 280, 30));

        jTextField3.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });
        pnClienteEmpresa.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 235, 280, 30));

        jPanel2.add(pnClienteEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 25, 461, 340));

        btRegistrar.setBackground(new java.awt.Color(136, 206, 82));
        btRegistrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/agregar.png"))); // NOI18N
        btRegistrar.setText("Registrar");
        btRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btRegistrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarActionPerformed(evt);
            }
        });
        jPanel2.add(btRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 430, 110, 55));

        btModificar.setBackground(new java.awt.Color(255, 185, 83));
        btModificar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/modificar.png"))); // NOI18N
        btModificar.setText("Modificar");
        btModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 495, 110, 55));

        btEliminar.setBackground(new java.awt.Color(234, 82, 62));
        btEliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/cancelar.png"))); // NOI18N
        btEliminar.setText("Cancelar");
        btEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 575, 110, 55));

        pnFecha.setBackground(new java.awt.Color(255, 255, 255));
        pnFecha.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Leelawadee UI Semilight", 1, 12))); // NOI18N
        pnFecha.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDNI13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDNI13.setText("F. Entrada");
        pnFecha.add(jLabelDNI13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 25, 120, 30));

        jLabelDNI17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDNI17.setText("F. Salida");
        pnFecha.add(jLabelDNI17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 75, 120, 30));

        jDateChooser4.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser4.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        pnFecha.add(jDateChooser4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 75, 156, 30));

        jDateChooser5.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser5.setAutoscrolls(true);
        jDateChooser5.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        pnFecha.add(jDateChooser5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 25, 156, 30));

        jPanel2.add(pnFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 336, 120));

        pnHabitacion.setBackground(new java.awt.Color(255, 255, 255));
        pnHabitacion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "DATOS DE A HABITACION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Leelawadee UI Semilight", 1, 12))); // NOI18N
        pnHabitacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDNI9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDNI9.setText("N° de Habitacion");
        pnHabitacion.add(jLabelDNI9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 75, 120, 30));

        jLabelDNI10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDNI10.setText("Tipo Habitacion");
        pnHabitacion.add(jLabelDNI10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 25, 120, 30));

        jLabelDNI14.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabelDNI14.setText("COSTO:");
        pnHabitacion.add(jLabelDNI14, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 184, -1, -1));

        jtxtdni8.setBackground(new java.awt.Color(255, 255, 204));
        jtxtdni8.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jtxtdni8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtdni8KeyTyped(evt);
            }
        });
        pnHabitacion.add(jtxtdni8, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 183, 105, 22));

        jLabelDNI15.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabelDNI15.setForeground(new java.awt.Color(51, 51, 51));
        jLabelDNI15.setText("S/.");
        pnHabitacion.add(jLabelDNI15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 181, -1, -1));

        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        pnHabitacion.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 75, 156, 30));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Individual", "Doble", "Triple", "Matrimonial", "Matrimonial Lunandina" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox2MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jComboBox2MousePressed(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        pnHabitacion.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 25, 156, 30));

        jPanel2.add(pnHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 535, 336, 120));

        btRegistrar1.setBackground(new java.awt.Color(136, 206, 82));
        btRegistrar1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btRegistrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/agregar.png"))); // NOI18N
        btRegistrar1.setText("Registrar");
        btRegistrar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btRegistrar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btRegistrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btRegistrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 430, 110, 55));

        btModificar1.setBackground(new java.awt.Color(255, 185, 83));
        btModificar1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btModificar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/modificar.png"))); // NOI18N
        btModificar1.setText("Modificar");
        btModificar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btModificar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btModificar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 495, 110, 55));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 46, 521, 700));

        jPanel4.setBackground(new java.awt.Color(13, 39, 70));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lunandina/logoReserva.png"))); // NOI18N
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 7, -1, 40));

        lbUserActual.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 16)); // NOI18N
        lbUserActual.setForeground(new java.awt.Color(255, 255, 255));
        lbUserActual.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbUserActual.setText("jLabel13");
        jPanel4.add(lbUserActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, 250, 46));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/userActual.png"))); // NOI18N
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 0, 30, 46));

        lbMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/minimizar1.png"))); // NOI18N
        lbMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMinimizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbMinimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbMinimizarMouseExited(evt);
            }
        });
        lbMinimizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lbMinimizarKeyTyped(evt);
            }
        });
        jPanel4.add(lbMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 8, 30, 30));

        lbCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/cerrar1.png"))); // NOI18N
        lbCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbCerrarMouseExited(evt);
            }
        });
        jPanel4.add(lbCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 8, 30, 30));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 46));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "RESERVAS REGISTRADAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Leelawadee UI Semilight", 1, 12))); // NOI18N
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 13)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Fecha Reserva", "Fecha Entrada", "Fecha Salida", "N° Habitacion", "Tipo Habitacion", "DNI/RUC", "Cliente", "Procedencia"
            }
        ));
        tabla.setGridColor(new java.awt.Color(0, 0, 0));
        tabla.setRowHeight(30);
        tabla.setSelectionBackground(new java.awt.Color(0, 122, 255));
        jScrollPane1.setViewportView(tabla);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 790, 440));

        jLabelDNI16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDNI16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDNI16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/buscar.png"))); // NOI18N
        jLabelDNI16.setText("Buscar");
        jPanel6.add(jLabelDNI16, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 40, 90, 30));

        txtBuscar.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscar.setSelectionColor(new java.awt.Color(0, 122, 255));
        txtBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtBuscarMouseReleased(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });
        jPanel6.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 40, 350, 30));

        dcBuscar.setBackground(new java.awt.Color(255, 255, 255));
        dcBuscar.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        dcBuscar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcBuscarPropertyChange(evt);
            }
        });
        dcBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dcBuscarKeyReleased(evt);
            }
        });
        jPanel6.add(dcBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(527, 40, 200, 30));

        btValidar.setBackground(new java.awt.Color(255, 185, 83));
        btValidar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btValidar.setText("Validar alojamiento");
        btValidar.setBorder(null);
        btValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btValidarActionPerformed(evt);
            }
        });
        jPanel6.add(btValidar, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 560, 160, 30));

        txtBuscar1.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtBuscar1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscar1.setSelectionColor(new java.awt.Color(0, 122, 255));
        txtBuscar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtBuscar1MouseReleased(evt);
            }
        });
        txtBuscar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscar1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscar1KeyTyped(evt);
            }
        });
        jPanel6.add(txtBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 40, 350, 30));

        dcBuscar1.setBackground(new java.awt.Color(255, 255, 255));
        dcBuscar1.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        dcBuscar1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcBuscar1PropertyChange(evt);
            }
        });
        dcBuscar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dcBuscar1KeyReleased(evt);
            }
        });
        jPanel6.add(dcBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(527, 40, 200, 30));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 25, 790, 630));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(521, 46, 845, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDNIKeyTyped
        Textos.Condicion(evt,txDNI,7); 
        Textos.Numeros(evt);
    }//GEN-LAST:event_txDNIKeyTyped

    private void jtxtdni1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdni1KeyTyped
        // TODO add your handling code here:
        Textos.soloPurasLetras(evt);
        //Textos.Mayusculas(evt);
        Textos.solo_1_esp(evt, jtxtdni3);
        
    }//GEN-LAST:event_jtxtdni1KeyTyped

    private void jtxtdni2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdni2KeyTyped
        // TODO add your handling code here:
        Textos.soloPurasLetras(evt);
        //Textos.Mayusculas(evt);
        Textos.solo_1_esp(evt, jtxtdni3);
    }//GEN-LAST:event_jtxtdni2KeyTyped

    private void jtxtdni3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdni3KeyTyped
        // TODO add your handling code here:
        Textos.soloPurasLetras(evt);
        //Textos.Mayusculas(evt);
        Textos.solo_1_esp(evt, jtxtdni3);
    }//GEN-LAST:event_jtxtdni3KeyTyped

    private void jtxtdni8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdni8KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtdni8KeyTyped

    private void btRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarActionPerformed
//     crear_Empresa();
       validarcampos_emp();
    }//GEN-LAST:event_btRegistrarActionPerformed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
//     MostrarList_Cliente();
       Seleccionar_Cliente();
    }//GEN-LAST:event_btModificarActionPerformed

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
      Limpiar();
    }//GEN-LAST:event_btEliminarActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void jtxtdni10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdni10KeyTyped
        // TODO add your handling code here:
        Textos.sinesp(evt);
    }//GEN-LAST:event_jtxtdni10KeyTyped

    private void jtxtdni4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdni4KeyTyped
        // TODO add your handling code here:
        Textos.soloPurasLetras(evt);
        //Textos.Mayusculas(evt);
        Textos.solo_1_esp(evt, jTextField2);
    }//GEN-LAST:event_jtxtdni4KeyTyped

    private void lbReiniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbReiniciarMouseClicked
        Limpiar();
        inicializarJTable_cliente();
          MostrarList_Cliente();
        pnTipoCliente.setVisible(true);
//        jPanel5.setVisible(false);
        pnClienteEmpresa.setVisible(false);
        pnClientePersona.setVisible(false);
        pnFecha.setVisible(false);
        pnHabitacion.setVisible(false);
        btValidar.setVisible(false);
        
        btRegistrar.setVisible(false);
        btRegistrar1.setVisible(false);
        btModificar.setVisible(false);
        btModificar1.setVisible(false);
        btEliminar.setVisible(false);
        
        lbReiniciar.setVisible(false);
        
        txtBuscar.setVisible(false);
        txtBuscar1.setVisible(true);
    }//GEN-LAST:event_lbReiniciarMouseClicked

    private void btClientePersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClientePersonaActionPerformed
        pnTipoCliente.setVisible(false);
        btValidar.setVisible(true);
        pnClientePersona.setVisible(true);
        pnFecha.setVisible(true);
        pnHabitacion.setVisible(true);
        jPanel5.setVisible(true);
        inicializarJTable_cliente();
        MostrarList_Cliente();
        txtBuscar.setVisible(false);
        txtBuscar1.setVisible(true);
        txDNI.grabFocus();
        
        lbReiniciar.setVisible(true);
        btRegistrar1.setVisible(true);
        btRegistrar.setVisible(false);
        btModificar.setVisible(true);
        btModificar1.setVisible(false);
        btEliminar.setVisible(true);
        
        dcBuscar.setVisible(true);
        dcBuscar1.setVisible(false);
    }//GEN-LAST:event_btClientePersonaActionPerformed

    private void btClienteEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClienteEmpresaActionPerformed
        pnTipoCliente.setVisible(false);
        btValidar.setVisible(true);
        pnClienteEmpresa.setVisible(true);
        pnFecha.setVisible(true);
        pnHabitacion.setVisible(true);
        jPanel5.setVisible(true);
        inicializarJTable_empresa();
        MostrarList_Empresa();
        txRUC.grabFocus();
        txtBuscar1.setVisible(false);
        txtBuscar.setVisible(true);
        lbReiniciar.setVisible(true);
        btRegistrar.setVisible(true);
        btRegistrar1.setVisible(false);
        btModificar1.setVisible(true);
        btModificar.setVisible(false);
        btEliminar.setVisible(true);
        dcBuscar.setVisible(false);
        dcBuscar1.setVisible(true);
        
    }//GEN-LAST:event_btClienteEmpresaActionPerformed

    private void lbMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMinimizarMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_lbMinimizarMouseClicked

    private void lbMinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMinimizarMouseEntered
        lbMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/minimizar2.png")));
    }//GEN-LAST:event_lbMinimizarMouseEntered

    private void lbMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMinimizarMouseExited
        lbMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/minimizar1.png")));
    }//GEN-LAST:event_lbMinimizarMouseExited

    private void lbCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_lbCerrarMouseClicked

    private void lbCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarMouseEntered
        lbCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/cerrar2.png")));
    }//GEN-LAST:event_lbCerrarMouseEntered

    private void lbCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarMouseExited
        lbCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/cerrar1.png")));
    }//GEN-LAST:event_lbCerrarMouseExited

    private void txtBuscarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarMouseReleased
        // TODO add your handling code here:
//        MostrarList();
    }//GEN-LAST:event_txtBuscarMouseReleased

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        MostrarList_Empresa();
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtBuscar1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscar1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar1MouseReleased

    private void txtBuscar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar1KeyReleased
        // TODO add your handling code here:
        MostrarList_Cliente();
    }//GEN-LAST:event_txtBuscar1KeyReleased

    private void txtBuscar1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar1KeyTyped

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        // TODO add your handling code here:
//        JOptionPane.showMessageDialog(null, jComboBox1.getSelectedIndex());
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void btRegistrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrar1ActionPerformed
        // TODO add your handling code here:
//        crear_Persona();
          validarcampos_client();
    }//GEN-LAST:event_btRegistrar1ActionPerformed

    private void lbLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLimpiarMouseClicked
        // TODO add your handling code here:
        Limpiar();
    }//GEN-LAST:event_lbLimpiarMouseClicked

    private void btModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificar1ActionPerformed
        // TODO add your handling code here:
        Seleccionar_Empresa();
    }//GEN-LAST:event_btModificar1ActionPerformed

    private void txRUCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRUCKeyTyped
        // TODO add your handling code here:
     Textos.Condicion(evt,txRUC,10); 
     Textos.Numeros(evt);
    }//GEN-LAST:event_txRUCKeyTyped

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        Textos.soloPurasLetras(evt);
        //Textos.Mayusculas(evt);
        Textos.solo_1_esp(evt, jTextField1);
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:Textos.soloPurasLetras(evt);
        Textos.soloPurasLetras(evt);
        //Textos.Mayusculas(evt);
        Textos.solo_1_esp(evt, jTextField2);
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        // TODO add your handling code here:
        Textos.sinesp(evt);
    }//GEN-LAST:event_jTextField3KeyTyped

    private void lbMinimizarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbMinimizarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_lbMinimizarKeyTyped

    private void txDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txDNIActionPerformed

    private void txDNIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDNIKeyReleased
        // TODO add your handling code here:
        reconocer_cliente();
    }//GEN-LAST:event_txDNIKeyReleased

    private void txRUCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRUCKeyReleased
        // TODO add your handling code here:
        reconocer_empresa();
    }//GEN-LAST:event_txRUCKeyReleased

    private void jComboBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2MouseClicked

    private void jComboBox2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseEntered
        // TODO add your handling code here:
//        valHab_Client();
    }//GEN-LAST:event_jComboBox2MouseEntered

    private void btValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btValidarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btValidarActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
//        valHab_Client();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MousePressed
        // TODO add your handling code here:
//         valHab_Client();
    }//GEN-LAST:event_jComboBox2MousePressed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        // TODO add your handling code here:
//        jComboBox2.removeAllItems();
        
        //alHab_Client();
        if (jComboBox2.getSelectedIndex() > 0 && jDateChooser5 != null && jDateChooser4 != null) {
            control.LlenarCombo(jComboBox1, 
                    "call proc_show_NumHab('"+jComboBox2.getSelectedItem()+"', \""
                            +cd.fecha_AMD(jDateChooser5.getDate())+"\",\""
                            +cd.fecha_AMD(jDateChooser4.getDate())+"\")", 1);
            if(jComboBox1.getItemCount()>0){
                jComboBox1.setSelectedIndex(0);
            }
            if(jComboBox1.getItemCount() == 1){ //Para cuando solo aparesca la opcion de '--Seleccione--'
                jComboBox1.removeAllItems();
                jComboBox1.addItem("--No hay cuartos--");
            }
        }
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void dcBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dcBuscarKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_dcBuscarKeyReleased

    private void dcBuscarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcBuscarPropertyChange
        MostrarList_Cliente();
    }//GEN-LAST:event_dcBuscarPropertyChange

    private void dcBuscar1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcBuscar1PropertyChange
        MostrarList_Empresa();
    }//GEN-LAST:event_dcBuscar1PropertyChange

    private void dcBuscar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dcBuscar1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_dcBuscar1KeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reservas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClienteEmpresa;
    private javax.swing.JButton btClientePersona;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btModificar;
    private javax.swing.JButton btModificar1;
    private javax.swing.JButton btRegistrar;
    private javax.swing.JButton btRegistrar1;
    private javax.swing.JButton btValidar;
    private com.toedter.calendar.JDateChooser dcBuscar;
    private com.toedter.calendar.JDateChooser dcBuscar1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabelDNI10;
    private javax.swing.JLabel jLabelDNI12;
    private javax.swing.JLabel jLabelDNI13;
    private javax.swing.JLabel jLabelDNI14;
    private javax.swing.JLabel jLabelDNI15;
    private javax.swing.JLabel jLabelDNI16;
    private javax.swing.JLabel jLabelDNI17;
    private javax.swing.JLabel jLabelDNI18;
    private javax.swing.JLabel jLabelDNI19;
    private javax.swing.JLabel jLabelDNI2;
    private javax.swing.JLabel jLabelDNI20;
    private javax.swing.JLabel jLabelDNI21;
    private javax.swing.JLabel jLabelDNI3;
    private javax.swing.JLabel jLabelDNI4;
    private javax.swing.JLabel jLabelDNI5;
    private javax.swing.JLabel jLabelDNI6;
    private javax.swing.JLabel jLabelDNI9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jtxtdni1;
    private javax.swing.JTextField jtxtdni10;
    private javax.swing.JTextField jtxtdni2;
    private javax.swing.JTextField jtxtdni3;
    private javax.swing.JTextField jtxtdni4;
    private javax.swing.JTextField jtxtdni8;
    private javax.swing.JLabel lbCerrar;
    private javax.swing.JLabel lbLimpiar;
    private javax.swing.JLabel lbMinimizar;
    private javax.swing.JLabel lbReiniciar;
    private javax.swing.JLabel lbUserActual;
    private javax.swing.JPanel pnClienteEmpresa;
    private javax.swing.JPanel pnClientePersona;
    private javax.swing.JPanel pnFecha;
    private javax.swing.JPanel pnHabitacion;
    private javax.swing.JPanel pnTipoCliente;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txDNI;
    private javax.swing.JTextField txRUC;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtBuscar1;
    // End of variables declaration//GEN-END:variables
}
