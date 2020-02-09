package Ventanas;

import Clases.Control;
import Clases.ControlDate;
import Clases.Controlador;
import Clases.Design;
import Clases.Textos;
import alertas.AlertaError;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Reservas extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modelo1 = new DefaultTableModel();
    Controlador control = new Controlador();
    ControlDate cd = new ControlDate();
    Design ds = new Design();
    public String rpt = "";
    int _idusuario;

    public Reservas() {
        initComponents();

        _idusuario = Integer.parseInt(control.DevolverRegistroDto("SELECT idusuario FROM usuarios WHERE login = '" + Control.empleado + "'", 1));
        ((JTextField) this.dcBuscar.getDateEditor()).setEditable(false);
        txtBuscar.setVisible(false);
        txtBuscar1.setVisible(true);

        btValidar.setEnabled(false);
        btValidar.setVisible(false);
        lbUserActual.setText(Control.usuario);
        control.LlenarCombo(cbTipoHab, "select * from tipohabitacion", 2);
        cbTipoHab.removeItemAt(0);
        cbNumHab.removeAllItems();

        //Ocultamos algunas funciones        
        lbReiniciar.setVisible(false);
        pnClienteEmpresa.setVisible(false);
        pnClientePersona.setVisible(false);
        pnFecha.setVisible(false);
        pnHabitacion.setVisible(false);
        btRegistrarPersona.setVisible(false);
        btRegistrarEmpresa.setVisible(false);
        btModificarPersona.setVisible(false);
        btModificarEmpresa.setVisible(false);
        btEliminarPersona.setVisible(false);

        btEliminarEmpresa.setVisible(false);
        btCancelar.setVisible(false);

        btEliminarPersona.setVisible(false);
      
        inicializarJTable_cliente();
        MostrarList_Cliente();

    }
    String idres = "";
    int numval;
    int numval1;
    
    public void LlenarComboHabitaciones(){
        if(dcEntrada.getDate() != null && dcSalida.getDate() != null && cbTipoHab.getSelectedIndex() > -1){
            control.LlenarCombo(cbNumHab,
                    "CALL proc_show_NumHab('" + cbTipoHab.getSelectedItem() + "', \""
                    + cd.fecha_AMD(dcEntrada.getDate()) + "\",\""
                    + cd.fecha_AMD(dcSalida.getDate()) + "\")", 1);
        }else{
            cbNumHab.removeAllItems();
        } 
        if (cbNumHab.getItemCount() > 0) {
            cbNumHab.setSelectedIndex(0);
        }
        if (cbNumHab.getItemCount() == 1) { //Para cuando solo aparesca la opcion de '--Seleccione--'
            cbNumHab.removeAllItems();
            cbNumHab.addItem("--No hay cuartos--");
        }
    }

    public void reconocer_empresa() {
        String Rc = txRUC.getText();
        int contDn = Integer.parseInt(control.DevolverRegistroDto("select count(*) from clienteempresa where RUC='" + Rc + "';", 1));
        if (contDn != 0 && txRUC.getText().length() == 11) {
            txNombreEmp.setText(control.DevolverRegistroDto("select empresa from vw_empresas where ruc = '"+Rc+"'", 1));
            txProcEmp.setText(control.DevolverRegistroDto("select lugar from vw_empresas where ruc = '"+Rc+"'", 1));
            txMailEmp.setText(control.DevolverRegistroDto("select email from vw_empresas where ruc = '"+Rc+"'", 1));
        }
        if (txRUC.getText().length() != 11) {
            txNombreEmp.setText("");
            txProcEmp.setText("");
            txMailEmp.setText("");
        }
    }

    public void reconocer_cliente() {
        String dni = txDNI.getText();
        int contDn = Integer.parseInt(control.DevolverRegistroDto("select count(*) from personas where DNI='" + dni + "';", 1));
        if (contDn != 0 && txDNI.getText().length() == 8) {
            txPaterno.setText(control.DevolverRegistroDto("select  apPat from personas where DNI='" + dni + "';", 1));
            txMaterno.setText(control.DevolverRegistroDto("select  apMat from personas where DNI='" + dni + "';", 1));
            txNombres.setText(control.DevolverRegistroDto("select  nomb from personas where DNI='" + dni + "';", 1));
            txProc.setText(control.DevolverRegistroDto("select  lugar from vw_clientepersona where DNI='" + dni + "' limit 1;", 1));
            txMail.setText(control.DevolverRegistroDto("select  email from personas where DNI='" + dni + "';", 1));
        }
        if (txDNI.getText().length() != 8) {
            txPaterno.setText("");
            txMaterno.setText("");
            txNombres.setText("");
            txProc.setText("");
            txMail.setText("");
        }
    }

    public void Seleccionar_Cliente() {
        int fila = tabla.getSelectedRow();
        if (fila > -1) {
            idres = modelo1.getValueAt(fila, 0).toString();
            String dni = modelo1.getValueAt(fila, 6).toString();
            int contDn = Integer.parseInt(control.DevolverRegistroDto("select count(*) from personas where DNI='" + dni + "';", 1));
            txDNI.setText(modelo1.getValueAt(fila, 6).toString());
            if (contDn != 0) {

                txPaterno.setText(control.DevolverRegistroDto("select  apPat from personas where DNI='" + dni + "';", 1));
                txMaterno.setText(control.DevolverRegistroDto("select  apMat from personas where DNI='" + dni + "';", 1));
                txNombres.setText(control.DevolverRegistroDto("select  nomb from personas where DNI='" + dni + "';", 1));
                txProc.setText(modelo1.getValueAt(fila, 8).toString());
                txMail.setText(control.DevolverRegistroDto("select  email from personas where DNI='" + dni + "';", 1));
                dcEntrada.setDate(cd.Parse_Fecha(modelo1.getValueAt(fila, 2).toString()));
                dcSalida.setDate(cd.Parse_Fecha(modelo1.getValueAt(fila, 3).toString()));
                cbTipoHab.setSelectedItem(modelo1.getValueAt(fila, 5).toString());
                cbNumHab.removeAllItems();
                cbNumHab.addItem(modelo1.getValueAt(fila, 4).toString());
                numval = Integer.parseInt(modelo1.getValueAt(fila, 4).toString());
                tabla.setEnabled(false);
            }
        } else {
            rpt = "Seleccione una fila";
            JOptionPane.showMessageDialog(null, rpt);
            btModificarPersona.setText("Modificar");
            btEliminarPersona.setText("Eliminar");
            btRegistrarEmpresa.setEnabled(true);
            tabla.setEnabled(true);
        }
    }

    public void Seleccionar_Empresa() {
        int fila = tabla.getSelectedRow();
        if (fila > -1) {
            idres = modelo.getValueAt(fila, 0).toString();
            String Rc = modelo.getValueAt(fila, 6).toString();
            int contDn = Integer.parseInt(control.DevolverRegistroDto("select count(*) from clienteempresa where RUC='" + Rc + "';", 1));
            txRUC.setText(modelo.getValueAt(fila, 6).toString());
            if (contDn != 0) {
                txNombreEmp.setText(modelo.getValueAt(fila, 7).toString());
                txProcEmp.setText(modelo.getValueAt(fila, 8).toString());
                txMailEmp.setText(control.DevolverRegistroDto("select email from clienteempresa where RUC='" + Rc + "';", 1));
                dcEntrada.setDate(cd.Parse_Fecha(modelo.getValueAt(fila, 2).toString()));
                dcSalida.setDate(cd.Parse_Fecha(modelo.getValueAt(fila, 3).toString()));
                cbTipoHab.setSelectedItem(modelo.getValueAt(fila, 5).toString());
                cbNumHab.removeAllItems();
                cbNumHab.addItem(modelo1.getValueAt(fila, 4).toString());
                numval1 = Integer.parseInt(modelo.getValueAt(fila, 4).toString());
            } else {
            }
        } else {
            rpt = "Seleccione una fila";
            btModificarEmpresa.setText("Modificar");
            btEliminarEmpresa.setText("Eliminar");
            btRegistrarPersona.setEnabled(true);
            JOptionPane.showMessageDialog(null, rpt);
        }
    }

    public void crear_Empresa() {
        int count = tabla.getRowCount();
        int idest = Integer.parseInt(control.DevolverRegistroDto("select idhabitacion from habitaciones where numHab='" + cbNumHab.getSelectedItem() + "';", 1));
        rpt = (control.DevolverRegistroDto("call Proc_ReservaEmp("
                + "'1',"
                + "'" + 0 + "',"
                + "'" + txProcEmp.getText() + "',"
                + "'" + txRUC.getText() + "',"
                + "'" + txNombreEmp.getText() + "',"
                + "'" + txMailEmp.getText() + "',"
                + "'" + cd.fecha_AMD(dcEntrada.getDate()) + "',"
                + "'" + cd.fecha_AMD(dcSalida.getDate()) + "',"
                + "'" + idest + "',"
                + "'" + 0 + "',"
                + _idusuario + ")", 1));
        
        JOptionPane.showMessageDialog(null, rpt);

        MostrarList_Empresa();
        int count1 = tabla.getRowCount();
        if (count != count1) {
            Limpiar();
        }
    }

    public void Editar_Empresa(int numHab) {

        int val1 = Integer.parseInt(control.DevolverRegistroDto("select DATEDIFF('" + cd.fecha_AMD(dcSalida.getDate()) + "','" + cd.fecha_AMD(dcEntrada.getDate()) + "');", 1));
        int val2 = Integer.parseInt(control.DevolverRegistroDto("select DATEDIFF('" + cd.fecha_AMD(dcEntrada.getDate()) + "',(CURDATE()-1));", 1));
        int idest = Integer.parseInt(control.DevolverRegistroDto("select idhabitacion from habitaciones where numHab='" + cbNumHab.getSelectedItem() + "';", 1));
        rpt = (control.DevolverRegistroDto("call Proc_ReservaEmp("
                + "'2',"
                + "'" + idres + "',"
                + "'" + txProcEmp.getText() + "',"
                + "'" + txRUC.getText() + "',"
                + "'" + txNombreEmp.getText() + "',"
                + "'" + txMailEmp.getText() + "',"
                + "'" + cd.fecha_AMD(dcEntrada.getDate()) + "',"
                + "'" + cd.fecha_AMD(dcSalida.getDate()) + "',"
                + "'" + idest + "',"
                + "'" + numHab + "',"
                + _idusuario + ")", 1));
        
        JOptionPane.showMessageDialog(null, rpt);
        
        MostrarList_Empresa();
        if (val1 > 0 && val2 > 0) {
            Limpiar();
            btModificarEmpresa.setText("Modificar");
            btRegistrarPersona.setEnabled(true);
        }
    }

    public void Limpiar() {
        tabla.setEnabled(true);
        txProcEmp.setText("");
        txRUC.setText("");
        txNombreEmp.setText("");
        txMailEmp.setText("");
        dcEntrada.setDate(null);
        dcSalida.setDate(null);
        cbNumHab.setSelectedIndex(-1);
        cbTipoHab.setSelectedIndex(-1);
        txProc.setText("");
        txDNI.setText("");
        txPaterno.setText("");
        txMaterno.setText("");
        txNombres.setText("");
        txMail.setText("");
        btModificarPersona.setText("Modificar");
        btModificarEmpresa.setText("Modificar");
        btEliminarPersona.setText("Eliminar");
        btEliminarEmpresa.setText("Eliminar");
        tabla.clearSelection();
        btRegistrarPersona.setEnabled(true);
        btRegistrarEmpresa.setEnabled(true);
    }

    public void crear_Persona() {
        int count = tabla.getRowCount();
        int idest = Integer.parseInt(control.DevolverRegistroDto("select idhabitacion from habitaciones where numHab='" + cbNumHab.getSelectedItem() + "';", 1));
        rpt = (control.DevolverRegistroDto("call Proc_ReservaClient("
                + "'1',"
                + "'" + 0 + "',"
                + "'" + txProc.getText() + "',"
                + "'" + txDNI.getText() + "',"
                + "'" + txPaterno.getText() + "',"
                + "'" + txMaterno.getText() + "',"
                + "'" + txNombres.getText() + "',"
                + "'" + txMail.getText() + "',"
                + "'" + cd.fecha_AMD(dcEntrada.getDate()) + "',"
                + "'" + cd.fecha_AMD(dcSalida.getDate()) + "',"
                + "'" + idest + "',"
                + "'" + 0 + "',"
                + _idusuario + ")", 1));
        JOptionPane.showMessageDialog(null, rpt);
        //alertas
        MostrarList_Cliente();
        int count1 = tabla.getRowCount();
        if (count != count1) {
            Limpiar();
        }
    }

    public void Editar_Persona(int numHab) {
        int val1 = Integer.parseInt(control.DevolverRegistroDto("select DATEDIFF('" + cd.fecha_AMD(dcSalida.getDate()) + "','" + cd.fecha_AMD(dcEntrada.getDate()) + "');", 1));
        int val2 = Integer.parseInt(control.DevolverRegistroDto("select DATEDIFF('" + cd.fecha_AMD(dcEntrada.getDate()) + "',(CURDATE()-1));", 1));
        int idest = Integer.parseInt(control.DevolverRegistroDto("select idhabitacion from habitaciones where numHab='" + cbNumHab.getSelectedItem() + "';", 1));
        rpt = (control.DevolverRegistroDto("call Proc_ReservaClient("
                + "'2',"
                + "'" + idres + "',"
                + "'" + txProc.getText() + "',"
                + "'" + txDNI.getText() + "',"
                + "'" + txPaterno.getText() + "',"
                + "'" + txMaterno.getText() + "',"
                + "'" + txNombres.getText() + "',"
                + "'" + txMail.getText() + "',"
                + "'" + cd.fecha_AMD(dcEntrada.getDate()) + "',"
                + "'" + cd.fecha_AMD(dcSalida.getDate()) + "',"
                + "'" + idest + "',"
                + "'" + numHab + "',"
                + _idusuario + ")", 1));
        
        JOptionPane.showMessageDialog(null, rpt);
        
        MostrarList_Cliente();
        if (val1 > 0 && val2 > 0) {
            Limpiar();
            btModificarPersona.setText("Modificar");
            btRegistrarEmpresa.setEnabled(true);
        }
    }

    public void EliminarReserva(String id) {
        rpt = (control.DevolverRegistroDto("call p_eliminar(" + id + ")", 1));        
        JOptionPane.showMessageDialog(null, rpt);
        
        if (cambio == 1) {
            MostrarList_Cliente();
        } else if (cambio == 2) {
            MostrarList_Empresa();
        }
    }

    private void MostrarList_Empresa() {
        if (dcBuscar.getDate() != null) {
            control.LlenarJtable(modelo, "select * from v_reservaemp  where "
                    + "(RUC like '%" + txtBuscar.getText() + "%' or Empresa like '%" + txtBuscar.getText() + "%' ) and Fecha_Resv = '" + cd.fecha_AMD(dcBuscar1.getDate()) + "';", 9);
        } else {
            control.LlenarJtable(modelo, "select * from v_reservaemp  where "
                    + "RUC like'%" + txtBuscar.getText() + "%' or Empresa like '%" + txtBuscar.getText() + "%';", 9);
        }
    }

    private void MostrarList_Cliente() {
        if (dcBuscar.getDate() != null) {
            control.LlenarJtable(modelo1, "select * from v_reservaclient  where "
                    + "(DNI like'%" + txtBuscar1.getText() + "%' or Cliente like '%" + txtBuscar1.getText() + "%' ) and Fecha_Resv = '" + cd.fecha_AMD(dcBuscar.getDate()) + "';", 9);
        } else {
            control.LlenarJtable(modelo1, "select * from v_reservaclient  where "
                    + "DNI like'%" + txtBuscar1.getText() + "%' or Cliente like '%" + txtBuscar1.getText() + "%';", 9);
        }   
    }

    public void ConfiguracionTabla(){
        tabla.getColumnModel().getColumn(0).setPreferredWidth(100); //ID
        tabla.getColumnModel().getColumn(1).setPreferredWidth(95);  //Fecha Reserva
        tabla.getColumnModel().getColumn(2).setPreferredWidth(90);  //Fecha Entrada
        tabla.getColumnModel().getColumn(3).setPreferredWidth(87);  //Fecha Salida
        tabla.getColumnModel().getColumn(4).setPreferredWidth(45);  // N° Habitacion
        tabla.getColumnModel().getColumn(5).setPreferredWidth(110); // Tipo Habitacion
        tabla.getColumnModel().getColumn(6).setPreferredWidth(75);  // DNI
        tabla.getColumnModel().getColumn(7).setPreferredWidth(200); // Cliente
        tabla.getColumnModel().getColumn(8).setPreferredWidth(75);  //Procedencia
        ds.OcultarColumna(tabla, 0);
    }
    public void inicializarJTable_cliente() {
        modelo1.setColumnIdentifiers(new String[]{"ID", "Fecha Reserva", "Fecha Entrada", "Fecha Salida", "N° Habitacion", "Tipo de Habitacion", "DNI", "Cliente", "Procedencia"});
        tabla.setModel(modelo1);
        ConfiguracionTabla();        
    }
    public void inicializarJTable_empresa() {
        modelo.setColumnIdentifiers(new String[]{"ID", "Fecha Reserva", "Fecha Entrada", "Fecha Salida", "N° Habitacion", "Tipo de Habitacion", "RUC", "Empresa", "Procedencia"});
        tabla.setModel(modelo);
        ConfiguracionTabla();
    }
    public boolean FormLlenoPersonas(){ // Retorna TRUE si todos los campos estan llenos
        return (txDNI.getText()!=null && txPaterno.getText()!=null && txMaterno.getText()!=null  && 
                txNombres.getText()!=null && txProc.getText()!=null && txMail.getText()!=null && dcEntrada.getDate()!=null &&
                dcSalida.getDate()!=null && cbTipoHab.getSelectedIndex()>-1 && cbNumHab.getSelectedIndex()>-1);
    }
    public boolean FormLlenoEmpresas(){ // Retorna TRUE si todos los campos estan llenos
        return (txRUC.getText()!=null && txNombreEmp.getText()!=null && txProcEmp.getText()!=null && 
                txMailEmp.getText()!=null && dcEntrada.getDate()!=null &&
                dcSalida.getDate()!=null && cbTipoHab.getSelectedIndex()>-1 && cbNumHab.getSelectedIndex()>-1);
    }
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
        txPaterno = new javax.swing.JTextField();
        txMaterno = new javax.swing.JTextField();
        jLabelDNI4 = new javax.swing.JLabel();
        jLabelDNI5 = new javax.swing.JLabel();
        txNombres = new javax.swing.JTextField();
        txProc = new javax.swing.JTextField();
        jLabelDNI6 = new javax.swing.JLabel();
        jLabelDNI12 = new javax.swing.JLabel();
        txMail = new javax.swing.JTextField();
        pnClienteEmpresa = new javax.swing.JPanel();
        jLabelDNI18 = new javax.swing.JLabel();
        jLabelDNI19 = new javax.swing.JLabel();
        jLabelDNI20 = new javax.swing.JLabel();
        jLabelDNI21 = new javax.swing.JLabel();
        txRUC = new javax.swing.JTextField();
        txNombreEmp = new javax.swing.JTextField();
        txProcEmp = new javax.swing.JTextField();
        txMailEmp = new javax.swing.JTextField();
        btRegistrarPersona = new javax.swing.JButton();
        btModificarPersona = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        pnFecha = new javax.swing.JPanel();
        jLabelDNI13 = new javax.swing.JLabel();
        jLabelDNI17 = new javax.swing.JLabel();
        dcSalida = new com.toedter.calendar.JDateChooser();
        dcEntrada = new com.toedter.calendar.JDateChooser();
        pnHabitacion = new javax.swing.JPanel();
        jLabelDNI9 = new javax.swing.JLabel();
        jLabelDNI10 = new javax.swing.JLabel();
        jLabelDNI14 = new javax.swing.JLabel();
        jtxtdni8 = new javax.swing.JTextField();
        jLabelDNI15 = new javax.swing.JLabel();
        cbNumHab = new javax.swing.JComboBox<>();
        cbTipoHab = new javax.swing.JComboBox<>();
        btRegistrarEmpresa = new javax.swing.JButton();
        btModificarEmpresa = new javax.swing.JButton();
        btEliminarPersona = new javax.swing.JButton();
        btEliminarEmpresa = new javax.swing.JButton();
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

        txPaterno.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txPaterno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txPaterno.setSelectionColor(new java.awt.Color(0, 122, 255));
        txPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txPaternoKeyTyped(evt);
            }
        });
        pnClientePersona.add(txPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 280, 30));

        txMaterno.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txMaterno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txMaterno.setSelectionColor(new java.awt.Color(0, 122, 255));
        txMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txMaternoKeyTyped(evt);
            }
        });
        pnClientePersona.add(txMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 280, 30));

        jLabelDNI4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDNI4.setText("Nombres");
        pnClientePersona.add(jLabelDNI4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 120, 30));

        jLabelDNI5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDNI5.setText("Procedencia");
        pnClientePersona.add(jLabelDNI5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 120, 30));

        txNombres.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txNombres.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txNombres.setSelectionColor(new java.awt.Color(0, 122, 255));
        txNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txNombresKeyTyped(evt);
            }
        });
        pnClientePersona.add(txNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 280, 30));

        txProc.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txProc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txProc.setSelectionColor(new java.awt.Color(0, 122, 255));
        txProc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txProcKeyTyped(evt);
            }
        });
        pnClientePersona.add(txProc, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 280, 30));

        jLabelDNI6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDNI6.setText("E-mail");
        pnClientePersona.add(jLabelDNI6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 120, 30));

        jLabelDNI12.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDNI12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDNI12.setText("A. Materno");
        jLabelDNI12.setToolTipText("");
        pnClientePersona.add(jLabelDNI12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 120, 30));

        txMail.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txMail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txMail.setSelectionColor(new java.awt.Color(0, 122, 255));
        txMail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txMailKeyTyped(evt);
            }
        });
        pnClientePersona.add(txMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 280, 30));

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

        txNombreEmp.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txNombreEmp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txNombreEmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txNombreEmpKeyTyped(evt);
            }
        });
        pnClienteEmpresa.add(txNombreEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 105, 280, 30));

        txProcEmp.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txProcEmp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txProcEmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txProcEmpKeyTyped(evt);
            }
        });
        pnClienteEmpresa.add(txProcEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 280, 30));

        txMailEmp.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txMailEmp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txMailEmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txMailEmpKeyTyped(evt);
            }
        });
        pnClienteEmpresa.add(txMailEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 235, 280, 30));

        jPanel2.add(pnClienteEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 25, 461, 340));

        btRegistrarPersona.setBackground(new java.awt.Color(136, 206, 82));
        btRegistrarPersona.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btRegistrarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/agregar.png"))); // NOI18N
        btRegistrarPersona.setText("Registrar");
        btRegistrarPersona.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btRegistrarPersona.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btRegistrarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarPersonaActionPerformed(evt);
            }
        });
        jPanel2.add(btRegistrarPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, 110, 55));

        btModificarPersona.setBackground(new java.awt.Color(0, 204, 204));
        btModificarPersona.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btModificarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/modificar.png"))); // NOI18N
        btModificarPersona.setText("Modificar");
        btModificarPersona.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btModificarPersona.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btModificarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarPersonaActionPerformed(evt);
            }
        });
        jPanel2.add(btModificarPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, 110, 55));

        btCancelar.setBackground(new java.awt.Color(234, 82, 62));
        btCancelar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/cancelar.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 600, 110, 55));

        pnFecha.setBackground(new java.awt.Color(255, 255, 255));
        pnFecha.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Leelawadee UI Semilight", 1, 12))); // NOI18N
        pnFecha.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDNI13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDNI13.setText("F. Entrada");
        pnFecha.add(jLabelDNI13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 25, 120, 30));

        jLabelDNI17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDNI17.setText("F. Salida");
        pnFecha.add(jLabelDNI17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 75, 120, 30));

        dcSalida.setBackground(new java.awt.Color(255, 255, 255));
        dcSalida.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        dcSalida.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcSalidaPropertyChange(evt);
            }
        });
        pnFecha.add(dcSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 75, 156, 30));

        dcEntrada.setBackground(new java.awt.Color(255, 255, 255));
        dcEntrada.setAutoscrolls(true);
        dcEntrada.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        dcEntrada.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcEntradaPropertyChange(evt);
            }
        });
        pnFecha.add(dcEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 25, 156, 30));

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

        cbNumHab.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        cbNumHab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbNumHabMouseClicked(evt);
            }
        });
        pnHabitacion.add(cbNumHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 75, 156, 30));

        cbTipoHab.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        cbTipoHab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Individual", "Doble", "Triple", "Matrimonial", "Matrimonial Lunandina" }));
        cbTipoHab.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTipoHabItemStateChanged(evt);
            }
        });
        cbTipoHab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbTipoHabMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbTipoHabMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbTipoHabMousePressed(evt);
            }
        });
        cbTipoHab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoHabActionPerformed(evt);
            }
        });
        pnHabitacion.add(cbTipoHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 25, 156, 30));

        jPanel2.add(pnHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 535, 336, 120));

        btRegistrarEmpresa.setBackground(new java.awt.Color(136, 206, 82));
        btRegistrarEmpresa.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btRegistrarEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/agregar.png"))); // NOI18N
        btRegistrarEmpresa.setText("Registrar");
        btRegistrarEmpresa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btRegistrarEmpresa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btRegistrarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarEmpresaActionPerformed(evt);
            }
        });
        jPanel2.add(btRegistrarEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, 110, 55));

        btModificarEmpresa.setBackground(new java.awt.Color(0, 204, 204));
        btModificarEmpresa.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btModificarEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/modificar.png"))); // NOI18N
        btModificarEmpresa.setText("Modificar");
        btModificarEmpresa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btModificarEmpresa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btModificarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarEmpresaActionPerformed(evt);
            }
        });
        jPanel2.add(btModificarEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 470, 110, 55));

        btEliminarPersona.setBackground(new java.awt.Color(255, 204, 51));
        btEliminarPersona.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btEliminarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/eliminar.png"))); // NOI18N
        btEliminarPersona.setText("Eliminar");
        btEliminarPersona.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btEliminarPersona.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btEliminarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarPersonaActionPerformed(evt);
            }
        });
        jPanel2.add(btEliminarPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 530, 110, 55));

        btEliminarEmpresa.setBackground(new java.awt.Color(255, 204, 51));
        btEliminarEmpresa.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btEliminarEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/eliminar.png"))); // NOI18N
        btEliminarEmpresa.setText("Eliminar");
        btEliminarEmpresa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btEliminarEmpresa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btEliminarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarEmpresaActionPerformed(evt);
            }
        });
        jPanel2.add(btEliminarEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 530, 110, 55));

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
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
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
        Textos.Condicion(evt, txDNI, 7);
        Textos.Numeros(evt);
    }//GEN-LAST:event_txDNIKeyTyped

    private void txPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPaternoKeyTyped
        Textos.soloPurasLetras(evt);
        Textos.SinEspacio(evt);
    }//GEN-LAST:event_txPaternoKeyTyped

    private void txMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txMaternoKeyTyped
        Textos.soloPurasLetras(evt);
        Textos.SinEspacio(evt);
    }//GEN-LAST:event_txMaternoKeyTyped

    private void txNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNombresKeyTyped
        Textos.soloPurasLetras(evt);
    }//GEN-LAST:event_txNombresKeyTyped

    private void jtxtdni8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdni8KeyTyped
    }//GEN-LAST:event_jtxtdni8KeyTyped

    private void btRegistrarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarPersonaActionPerformed
        if (FormLlenoPersonas()) {
            crear_Empresa();         
        } else {
            rpt = ("Faltan campos por llenar");
            JOptionPane.showMessageDialog(null, rpt);
        }
    }//GEN-LAST:event_btRegistrarPersonaActionPerformed

    private void btModificarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarPersonaActionPerformed
        if (btModificarPersona.getText().equals("Modificar")) {
            btRegistrarEmpresa.setEnabled(false);
            btModificarPersona.setText("Actualizar");
            Seleccionar_Cliente();
        } else {
            Editar_Persona(numval);
        }
    }//GEN-LAST:event_btModificarPersonaActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txMailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txMailKeyTyped
        Textos.sinesp(evt);
    }//GEN-LAST:event_txMailKeyTyped

    private void txProcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txProcKeyTyped
        Textos.soloPurasLetras(evt);
        Textos.solo_1_esp(evt, txProcEmp);
    }//GEN-LAST:event_txProcKeyTyped

    private void lbReiniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbReiniciarMouseClicked
        Limpiar();
        inicializarJTable_cliente();
        MostrarList_Cliente();
        pnTipoCliente.setVisible(true);
        pnClienteEmpresa.setVisible(false);
        pnClientePersona.setVisible(false);
        pnFecha.setVisible(false);
        pnHabitacion.setVisible(false);
        btValidar.setVisible(false);

        btRegistrarPersona.setVisible(false);
        btRegistrarEmpresa.setVisible(false);
        btModificarPersona.setVisible(false);
        btModificarEmpresa.setVisible(false);
        btCancelar.setVisible(false);
        btEliminarPersona.setVisible(false);
        btEliminarEmpresa.setVisible(false);

        lbReiniciar.setVisible(false);

        txtBuscar.setVisible(false);
        txtBuscar1.setVisible(true);
    }//GEN-LAST:event_lbReiniciarMouseClicked
    
    public int cambio = 1;
    public void MostrarComponentes(boolean flag){
	//flag = TRUE // Se vera personas
	pnTipoCliente.setVisible(false);
        btValidar.setVisible(true);

        pnClientePersona.setVisible(flag);
	pnClienteEmpresa.setVisible(!flag);

        pnFecha.setVisible(true);
        pnHabitacion.setVisible(true);
        jPanel5.setVisible(true);

        txtBuscar.setVisible(!flag);
        txtBuscar1.setVisible(flag);
        if (flag == true){ txDNI.grabFocus();}
        else { txRUC.grabFocus(); }

        lbReiniciar.setVisible(true);

        btRegistrarPersona.setVisible(!flag);
        btRegistrarEmpresa.setVisible(flag);

        btModificarPersona.setVisible(!flag);
        btModificarEmpresa.setVisible(flag);

        btCancelar.setVisible(true);

        btEliminarPersona.setVisible(flag);
        btEliminarEmpresa.setVisible(!flag);

        dcBuscar.setVisible(flag);
        dcBuscar1.setVisible(!flag);
    }
    private void btClientePersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClientePersonaActionPerformed
        cambio = 1;        
        inicializarJTable_cliente();
        MostrarList_Cliente();
        MostrarComponentes(true); // 'true' mnuestra los componentes dedicados a Personas
    }//GEN-LAST:event_btClientePersonaActionPerformed

    private void btClienteEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClienteEmpresaActionPerformed
        cambio = 2;        
        inicializarJTable_empresa();
        MostrarList_Empresa();
        MostrarComponentes(false); // 'false' mnuestra los componentes dedicados a Empresas
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
        MenuPrincipal mp=new MenuPrincipal();
        mp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbCerrarMouseClicked
    private void lbCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarMouseEntered
        lbCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/cerrar2.png")));
    }//GEN-LAST:event_lbCerrarMouseEntered
    private void lbCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarMouseExited
        lbCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/cerrar1.png")));
    }//GEN-LAST:event_lbCerrarMouseExited
   
    private void txtBuscarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarMouseReleased
    }//GEN-LAST:event_txtBuscarMouseReleased
    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        MostrarList_Empresa();
    }//GEN-LAST:event_txtBuscarKeyReleased
    private void txtBuscar1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscar1MouseReleased
    }//GEN-LAST:event_txtBuscar1MouseReleased
    private void txtBuscar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar1KeyReleased
        MostrarList_Cliente();
    }//GEN-LAST:event_txtBuscar1KeyReleased
    private void txtBuscar1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar1KeyTyped
    }//GEN-LAST:event_txtBuscar1KeyTyped
    private void cbNumHabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbNumHabMouseClicked
    }//GEN-LAST:event_cbNumHabMouseClicked

    private void btRegistrarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarEmpresaActionPerformed
        if (FormLlenoEmpresas()) {
            crear_Empresa();            
        } else {
            rpt = ("Faltan campos por llenar");
            JOptionPane.showMessageDialog(null, rpt);
        }
    }//GEN-LAST:event_btRegistrarEmpresaActionPerformed

    private void lbLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLimpiarMouseClicked
        Limpiar();
    }//GEN-LAST:event_lbLimpiarMouseClicked

    private void btModificarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarEmpresaActionPerformed
        if (btModificarEmpresa.getText().equals("Modificar")) {
            btRegistrarPersona.setEnabled(false);
            btModificarEmpresa.setText("Actualizar");
            Seleccionar_Empresa();
        } else {
            Editar_Empresa(numval1);
        }
    }//GEN-LAST:event_btModificarEmpresaActionPerformed

    private void txRUCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRUCKeyTyped
        Textos.Condicion(evt, txRUC, 10);
        Textos.Numeros(evt);
    }//GEN-LAST:event_txRUCKeyTyped

    private void txNombreEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNombreEmpKeyTyped
        Textos.soloPurasLetras(evt);
    }//GEN-LAST:event_txNombreEmpKeyTyped

    private void txProcEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txProcEmpKeyTyped
        Textos.soloPurasLetras(evt);
    }//GEN-LAST:event_txProcEmpKeyTyped

    private void txMailEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txMailEmpKeyTyped
        Textos.sinesp(evt);
    }//GEN-LAST:event_txMailEmpKeyTyped

    private void lbMinimizarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbMinimizarKeyTyped
    }//GEN-LAST:event_lbMinimizarKeyTyped
    private void txDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txDNIActionPerformed
    }//GEN-LAST:event_txDNIActionPerformed

    private void txDNIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDNIKeyReleased
        reconocer_cliente(); 
    }//GEN-LAST:event_txDNIKeyReleased
    private void txRUCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRUCKeyReleased
        reconocer_empresa();
    }//GEN-LAST:event_txRUCKeyReleased

    private void cbTipoHabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbTipoHabMouseClicked
    }//GEN-LAST:event_cbTipoHabMouseClicked
    private void cbTipoHabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbTipoHabMouseEntered
    }//GEN-LAST:event_cbTipoHabMouseEntered
    private void btValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btValidarActionPerformed
    }//GEN-LAST:event_btValidarActionPerformed
    private void cbTipoHabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoHabActionPerformed
    }//GEN-LAST:event_cbTipoHabActionPerformed
    private void cbTipoHabMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbTipoHabMousePressed
    }//GEN-LAST:event_cbTipoHabMousePressed

    private void cbTipoHabItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTipoHabItemStateChanged
        LlenarComboHabitaciones();
    }//GEN-LAST:event_cbTipoHabItemStateChanged

    private void dcBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dcBuscarKeyReleased
    }//GEN-LAST:event_dcBuscarKeyReleased

    private void dcBuscarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcBuscarPropertyChange
        MostrarList_Cliente();
    }//GEN-LAST:event_dcBuscarPropertyChange
    private void dcBuscar1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcBuscar1PropertyChange
        MostrarList_Empresa();
    }//GEN-LAST:event_dcBuscar1PropertyChange

    private void dcBuscar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dcBuscar1KeyReleased
    }//GEN-LAST:event_dcBuscar1KeyReleased

    private void btEliminarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarPersonaActionPerformed
        if (btEliminarPersona.getText().equals("Eliminar")) {
            btRegistrarEmpresa.setEnabled(false);
            btEliminarPersona.setText("Actualizar");
            Seleccionar_Cliente();
        } else {
            EliminarReserva(idres);
        }
    }//GEN-LAST:event_btEliminarPersonaActionPerformed

    private void btEliminarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarEmpresaActionPerformed
        if (btEliminarEmpresa.getText().equals("Eliminar")) {
            btRegistrarPersona.setEnabled(false);
            btEliminarEmpresa.setText("Actualizar");
            Seleccionar_Empresa();
        } else {
            EliminarReserva(idres);
        }
    }//GEN-LAST:event_btEliminarEmpresaActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        if   (tabla.getSelectedRow() > -1) { btValidar.setEnabled(true);  } 
        else { btValidar.setEnabled(false); }
    }//GEN-LAST:event_tablaMouseClicked

    private void dcEntradaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcEntradaPropertyChange
        LlenarComboHabitaciones();
    }//GEN-LAST:event_dcEntradaPropertyChange
    private void dcSalidaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcSalidaPropertyChange
        LlenarComboHabitaciones();
    }//GEN-LAST:event_dcSalidaPropertyChange


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
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reservas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btClienteEmpresa;
    private javax.swing.JButton btClientePersona;
    private javax.swing.JButton btEliminarEmpresa;
    private javax.swing.JButton btEliminarPersona;
    private javax.swing.JButton btModificarEmpresa;
    private javax.swing.JButton btModificarPersona;
    private javax.swing.JButton btRegistrarEmpresa;
    private javax.swing.JButton btRegistrarPersona;
    private javax.swing.JButton btValidar;
    private javax.swing.JComboBox<String> cbNumHab;
    private javax.swing.JComboBox<String> cbTipoHab;
    private com.toedter.calendar.JDateChooser dcBuscar;
    private com.toedter.calendar.JDateChooser dcBuscar1;
    private com.toedter.calendar.JDateChooser dcEntrada;
    private com.toedter.calendar.JDateChooser dcSalida;
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
    private javax.swing.JTextField txMail;
    private javax.swing.JTextField txMailEmp;
    private javax.swing.JTextField txMaterno;
    private javax.swing.JTextField txNombreEmp;
    private javax.swing.JTextField txNombres;
    private javax.swing.JTextField txPaterno;
    private javax.swing.JTextField txProc;
    private javax.swing.JTextField txProcEmp;
    private javax.swing.JTextField txRUC;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtBuscar1;
    // End of variables declaration//GEN-END:variables
}
