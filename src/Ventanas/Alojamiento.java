package Ventanas;

import Clases.*;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Alojamiento extends javax.swing.JFrame {
    
    Controlador control = new Controlador();
    ControlDate controlDT = new ControlDate();
    Design ds=new Design();
    DefaultTableModel modelo = new DefaultTableModel();
    public int cambio = 1;
    public String rpt = "";
    
    public Alojamiento() {
        initComponents();
        lbUserActual.setText(Control.usuario);
        tabla.getTableHeader().setOpaque(true);
        tabla.getTableHeader().setBackground(new Color(248, 177, 57));
        //Inicializamos los metodos principales
        inicializarJTable_persona();
        llenarCombo();
        MostrarPersona();
        //Ocultamos algunas funciones        
        lbReiniciar.setVisible(false);
        pnClienteEmpresa.setVisible(false);
        pnClientePersona.setVisible(false);
        pnFecha.setVisible(false);
        pnHabitacion.setVisible(false);
        btRegistrar.setVisible(false);
        btModificar.setVisible(false);
        btCancelar.setVisible(false);

        dcEntrada.setDate(controlDT.Parse_Fecha(control.DevolverRegistroDto("select curdate()", 1)));
        dcEntrada.setEnabled(false);
    }

    public void FormatoTabla(){
        tabla.setModel(modelo);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(115);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(110);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(110);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(150);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(240);
        tabla.getColumnModel().getColumn(7).setPreferredWidth(180);
        ds.OcultarColumna(tabla, 0);
    }
    public void inicializarJTable_persona() {
        modelo.setColumnIdentifiers(new String[]{"ID", "Fecha Entrada", "Fecha Salida", "N° Habitacion", "Tipo de Habitacion", "DNI", "Cliente", "Procedencia"});
        FormatoTabla();
    }
    public void inicializarJTable_empresa() {
        modelo.setColumnIdentifiers(new String[]{"ID", "Fecha Entrada", "Fecha Salida", "N° Habitacion", "Tipo de Habitacion", "RUC", "Empresa", "Procedencia"});
        FormatoTabla();
    }
    public void llenarCombo() {
        control.LlenarComboHB(cbTipoHab, "SELECT * FROM tipohabitacion;", 2);
        cbTipoHab.setSelectedIndex(0);
        control.LlenarCombo(cbNumHab, "SELECT * FROM habitaciones;", 2);
    }
    public void LlenarComboHabitaciones(){
        if(dcEntrada.getDate() != null && dcSalida.getDate() != null && cbTipoHab.getSelectedIndex() > -1){
            control.LlenarCombo(cbNumHab,
                    "CALL proc_show_NumHab('" + cbTipoHab.getSelectedItem() + "', \""
                    + controlDT.fecha_AMD(dcEntrada.getDate()) + "\",\""
                    + controlDT.fecha_AMD(dcSalida.getDate()) + "\")", 1);
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

    private void MostrarPersona() {
        control.LlenarJtable(modelo, "SELECT * FROM vis_alojamiento_persona where DNI like'%" + txDNI.getText() + "%';", 8);
    }
    private void MostrarEmpresa() {
        control.LlenarJtable(modelo, "SELECT * FROM vis_alojamiento_empresa where RUC like'%" + txRUC.getText() + "%';", 8);
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

    String id, DOR;
    int contDOR;

    public void Seleccionar() {
        DOR = "";
        contDOR = 0;
        int fila = tabla.getSelectedRow();
        id = modelo.getValueAt(fila, 0).toString();
        if (fila >= 0) {
            DOR = modelo.getValueAt(fila, 5).toString();

            if (cambio == 1) {
                contDOR = Integer.parseInt(control.DevolverRegistroDto("select count(*) from personas where DNI='" + DOR + "';", 1));
                txDNI.setText(DOR);
                if (contDOR != 0) {
                    txPaterno.setText(control.DevolverRegistroDto("select  apPat from personas where DNI='" + DOR + "';", 1));
                    txMaterno.setText(control.DevolverRegistroDto("select  apMat from personas where DNI='" + DOR + "';", 1));
                    txNombres.setText(control.DevolverRegistroDto("select  nomb from personas where DNI='" + DOR + "';", 1));
                    txProc.setText(modelo.getValueAt(fila, 7).toString());
                    txMail.setText(control.DevolverRegistroDto("select  email from personas where DNI='" + DOR + "';", 1));
                    cbTipoHab.setSelectedItem(modelo.getValueAt(fila, 4).toString());
                    cbNumHab.setSelectedItem(modelo.getValueAt(fila, 3).toString());
                    dcEntrada.setDate(controlDT.Parse_Fecha(modelo.getValueAt(fila, 1).toString()));
                    dcSalida.setDate(controlDT.Parse_Fecha(modelo.getValueAt(fila, 2).toString()));
                }
            } else if (cambio == 2) {
                contDOR = Integer.parseInt(control.DevolverRegistroDto("select count(*) from clienteempresa where RUC='" + DOR + "';", 1));
                txRUC.setText(DOR);
                if (contDOR != 0) {
                    txNombreEmp.setText(control.DevolverRegistroDto("select  nombreEmpresa from clienteempresa where RUC='" + DOR + "';", 1));
                    txProcEmp.setText(modelo.getValueAt(fila, 7).toString());
                    txMailEmp.setText(control.DevolverRegistroDto("select  email from clienteempresa where RUC='" + DOR + "';", 1));
                    cbTipoHab.setSelectedItem(modelo.getValueAt(fila, 4).toString());
                    cbNumHab.setSelectedItem(modelo.getValueAt(fila, 3).toString());
                    dcEntrada.setDate(controlDT.Parse_Fecha(modelo.getValueAt(fila, 1).toString()));
                    dcSalida.setDate(controlDT.Parse_Fecha(modelo.getValueAt(fila, 2).toString()));
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "No hay una fila seleccionada");
        }

    }

    public void reconocer() {
        if (cambio == 1) {
            String dni = txDNI.getText();
            int contD = Integer.parseInt(control.DevolverRegistroDto("select count(*) from personas where DNI='" + dni + "';", 1));
            if (contD != 0) {
                txPaterno.setText(control.DevolverRegistroDto("select  apPat from personas where DNI='" + dni + "';", 1));
                txMaterno.setText(control.DevolverRegistroDto("select  apMat from personas where DNI='" + dni + "';", 1));
                txNombres.setText(control.DevolverRegistroDto("select  nomb from personas where DNI='" + dni + "';", 1));
                txProc.setText(control.DevolverRegistroDto("select  lugar from vis_alojamiento_persona where DNI='" + dni + "' limit 1;", 1));
                txMail.setText(control.DevolverRegistroDto("select  email from personas where DNI='" + dni + "';", 1));
            }

        } else if (cambio == 2) {
            String ruc = txRUC.getText();
            int contD = Integer.parseInt(control.DevolverRegistroDto("select count(*) from clienteempresa where RUC='" + ruc + "';", 1));
            if (contD != 0) {
                txNombreEmp.setText(control.DevolverRegistroDto("select  nombreEmpresa from clienteempresa where RUC='" + ruc + "';", 1));
                txProcEmp.setText(control.DevolverRegistroDto("select  lugar from vis_alojamiento_empresa where RUC='" + ruc + "' limit 1;", 1));
                txMailEmp.setText(control.DevolverRegistroDto("select  email from clienteempresa where RUC='" + ruc + "';", 1));
            }
        }
    }

    public void limpiar() {
        btModificar.setText("Modificar");
        txDNI.setText(null);
        txNombres.setText(null);
        txPaterno.setText(null);
        txMaterno.setText(null);
        txMaterno.setText(null);
        txProc.setText(null);
        txMail.setText(null);
        dcSalida.setDate(null);
        txRUC.setText(null);
        txNombreEmp.setText(null);
        txProcEmp.setText(null);
        txMailEmp.setText(null);
        cbTipoHab.setSelectedIndex(-1);
        cbNumHab.setSelectedIndex(-1);
        if (cambio == 1) {
            MostrarPersona();
        } else if (cambio == 2) {
            MostrarEmpresa();
        }
    }

    public void RegistarPesona() {
        rpt = (control.DevolverRegistroDto("call proc_alojamiento_persona('" + txDNI.getText()
                + "','" + Textos.capitalizeText(txPaterno.getText()) + "','" + Textos.capitalizeText(txMaterno.getText()) + "','" + Textos.capitalizeText(txNombres.getText())
                + "','" + Textos.capitalizeText(txProc.getText()) + "','" + txMail.getText() + "','"
                + controlDT.fecha_AMD(dcEntrada.getDate()) + "','" + controlDT.fecha_AMD(dcSalida.getDate())
                + "','" + cbTipoHab.getSelectedItem() + "','" + cbNumHab.getSelectedItem()
                + "','" + Control.empleado + "');", 1));
        JOptionPane.showMessageDialog(null, rpt);
        MostrarPersona();
    }

    public void ValidRegistroPersona() {        
        if(FormLlenoPersonas()){
            RegistarPesona();
        }else{
            rpt="Faltan datos por llenar";
            JOptionPane.showMessageDialog(null, rpt);
        }        
    }

    public void RegistrarEmpresa() {
        rpt = (control.DevolverRegistroDto("call proc_alojamiento_empresa('" + txRUC.getText()
                + "','" + txNombreEmp.getText() + "','" + txProcEmp.getText() + "','" + txMailEmp.getText()
                + "','" + controlDT.fecha_AMD(dcEntrada.getDate()) + "','" + controlDT.fecha_AMD(dcSalida.getDate())
                + "','" + cbTipoHab.getSelectedItem() + "'," + cbNumHab.getSelectedItem()
                + ",'" + Control.empleado + "');", 1));
        JOptionPane.showMessageDialog(null, rpt);
        MostrarEmpresa();
    }

    public void ValidRegistroEmpresa() {
        if(FormLlenoPersonas()){
            RegistrarEmpresa();
        }else{
            rpt="Faltan datos por llenar";
            JOptionPane.showMessageDialog(null, rpt);
        }        
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
        btRegistrar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
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
        txBuscar = new javax.swing.JTextField();

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

        jPanel2.add(pnTipoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3000, 25, 460, 120));

        pnClientePersona.setBackground(new java.awt.Color(255, 255, 255));
        pnClientePersona.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "DATOS DEL CLIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Leelawadee UI Semilight", 1, 12))); // NOI18N
        pnClientePersona.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDNI2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDNI2.setText("DNI");
        pnClientePersona.add(jLabelDNI2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 120, 30));

        txDNI.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txDNI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txDNI.setSelectionColor(new java.awt.Color(0, 122, 255));
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txPaternoKeyReleased(evt);
            }
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

        jPanel2.add(pnClientePersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3000, 25, 460, 340));

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
        jPanel2.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 575, 110, 55));

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

        cbNumHab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "205", "207", "305", "306" }));
        pnHabitacion.add(cbNumHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 75, 156, 30));

        cbTipoHab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indivudual", "Doble", "Triple", "Matrimonial", "Matrimonial Lunandina" }));
        cbTipoHab.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTipoHabItemStateChanged(evt);
            }
        });
        pnHabitacion.add(cbTipoHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 25, 156, 30));

        jPanel2.add(pnHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 535, 336, 120));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 46, 500, 700));

        jPanel4.setBackground(new java.awt.Color(13, 39, 70));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lunandina/logoAlojamientos.png"))); // NOI18N
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

        tabla.setAutoCreateRowSorter(true);
        tabla.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 13)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Fecha Entrada", "Fecha Salida", "N° Habitacion", "Tipo Habitacion", "DNI/RUC", "Cliente", "Procedencia"
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

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 90, 800, 490));

        jLabelDNI16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDNI16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDNI16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/buscar.png"))); // NOI18N
        jLabelDNI16.setText("Buscar");
        jPanel6.add(jLabelDNI16, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 40, 90, 30));

        txBuscar.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txBuscar.setSelectionColor(new java.awt.Color(0, 122, 255));
        txBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txBuscarKeyTyped(evt);
            }
        });
        jPanel6.add(txBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 40, 350, 30));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 25, 850, 620));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 46, 870, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDNIKeyTyped
        Textos.Numeros(evt);
        Textos.LimitarCaracter(evt, txDNI, 8);
    }//GEN-LAST:event_txDNIKeyTyped

    private void txPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPaternoKeyTyped
        Textos.LimitarCaracter(evt, txPaterno, 50);
        Textos.SinEspacio(evt);
    }//GEN-LAST:event_txPaternoKeyTyped

    private void txMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txMaternoKeyTyped
        Textos.LimitarCaracter(evt, txMaterno, 50);
        Textos.SinEspacio(evt);
    }//GEN-LAST:event_txMaternoKeyTyped

    private void txNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNombresKeyTyped
        Textos.LimitarCaracter(evt, txNombres, 50);
    }//GEN-LAST:event_txNombresKeyTyped

    private void jtxtdni8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdni8KeyTyped
    }//GEN-LAST:event_jtxtdni8KeyTyped

    private void btRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarActionPerformed
        if (cambio == 1) {
            ValidRegistroPersona();
        } else if (cambio == 2) {
            ValidRegistroEmpresa();
        }
    }//GEN-LAST:event_btRegistrarActionPerformed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed

        if (btModificar.getText().equals("Modificar")) {
            btRegistrar.setEnabled(false);
            btModificar.setText("Actualizar");
            txDNI.setEditable(false);
            txRUC.setEditable(false);
            Seleccionar();
            rpt="";
        } else if (btModificar.getText().equals("Actualizar")) {
            if (cambio == 1) {
                rpt = (control.DevolverRegistroDto("call proc_alojamiento_persona_editar(" + id + ",'" + txDNI.getText() + "','"
                        + Textos.capitalizeText(txPaterno.getText()) + "','" + Textos.capitalizeText(txMaterno.getText()) + "','" + Textos.capitalizeText(txNombres.getText()) + "','" + Textos.capitalizeText(txProc.getText()) + "','"
                        + txMail.getText() + "','" + controlDT.fecha_AMD(dcSalida.getDate()) + "');", 1));

                MostrarPersona();
            } else if (cambio == 2) {
                rpt = (control.DevolverRegistroDto("call proc_alojamiento_empresa_editar(" + id + ",'" + txRUC.getText() + "','"
                        + Textos.capitalizeText(txProcEmp.getText()) + "','" + Textos.capitalizeText(txNombreEmp.getText()) + "','" + Textos.capitalizeText(txMailEmp.getText()) + "','"
                        + controlDT.fecha_AMD(dcSalida.getDate()) + "');", 1));
                MostrarEmpresa();
            }
            JOptionPane.showMessageDialog(null, rpt);
        }
    }//GEN-LAST:event_btModificarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        limpiar();
        btModificar.setText("Modificar");
        btRegistrar.setEnabled(true);
        txDNI.setEnabled(true);
        txRUC.setEnabled(true);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void txBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txBuscarKeyTyped
    }//GEN-LAST:event_txBuscarKeyTyped

    private void txMailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txMailKeyTyped
        Textos.LimitarCaracter(evt, txMail, 100);
    }//GEN-LAST:event_txMailKeyTyped

    private void txProcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txProcKeyTyped
        Textos.LimitarCaracter(evt, txProc, 100);
    }//GEN-LAST:event_txProcKeyTyped

    private void lbReiniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbReiniciarMouseClicked
        pnTipoCliente.setVisible(true);

        pnClienteEmpresa.setVisible(false);
        pnClientePersona.setVisible(false);
        pnFecha.setVisible(false);
        pnHabitacion.setVisible(false);

        btRegistrar.setVisible(false);
        btModificar.setVisible(false);
        btCancelar.setVisible(false);

        lbReiniciar.setVisible(false);
        //Habilitar 
        btRegistrar.setEnabled(true);
        txDNI.setEditable(true);
        txRUC.setEditable(true);

        MostrarPersona();
        limpiar();
    }//GEN-LAST:event_lbReiniciarMouseClicked

    private void btClientePersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClientePersonaActionPerformed
        cambio = 1;
        pnTipoCliente.setVisible(false);

        pnClientePersona.setVisible(true);
        pnFecha.setVisible(true);
        pnHabitacion.setVisible(true);

        txDNI.grabFocus();

        //Inicializamos,mostramos la tabla persona y limpiamos
        inicializarJTable_persona();
        MostrarPersona();
        limpiar();

        lbReiniciar.setVisible(true);
        btRegistrar.setVisible(true);
        btModificar.setVisible(true);
        btCancelar.setVisible(true);

        dcEntrada.setDate(controlDT.Parse_Fecha(control.DevolverRegistroDto("select curdate()", 1)));
    }//GEN-LAST:event_btClientePersonaActionPerformed

    private void btClienteEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClienteEmpresaActionPerformed
        cambio = 2;
        pnTipoCliente.setVisible(false);

        pnClienteEmpresa.setVisible(true);
        pnFecha.setVisible(true);
        pnHabitacion.setVisible(true);

        txRUC.grabFocus();

        //Inicializamos,mostramos la tabla persona y limpiamos
        inicializarJTable_empresa();
        MostrarEmpresa();
        limpiar();

        lbReiniciar.setVisible(true);
        btRegistrar.setVisible(true);
        btModificar.setVisible(true);
        btCancelar.setVisible(true);

        dcEntrada.setDate(controlDT.Parse_Fecha(control.DevolverRegistroDto("select curdate()", 1)));
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

    private void txDNIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDNIKeyReleased
        if(txDNI.getText().length() == 8){
            MostrarPersona();
            reconocer();
        }else{
            txPaterno.setText("");
            txMaterno.setText("");
            txNombres.setText("");
            txProc.setText("");
            txMail.setText("");
        }
    }//GEN-LAST:event_txDNIKeyReleased

    private void txPaternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPaternoKeyReleased
    }//GEN-LAST:event_txPaternoKeyReleased

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
    }//GEN-LAST:event_tablaMouseClicked

    private void lbLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLimpiarMouseClicked
        limpiar();
        btRegistrar.setEnabled(true);
        txDNI.setEditable(true);
        txRUC.setEditable(true);
        dcEntrada.setDate(controlDT.Parse_Fecha(control.DevolverRegistroDto("select curdate()", 1)));
    }//GEN-LAST:event_lbLimpiarMouseClicked

    private void cbTipoHabItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTipoHabItemStateChanged
        LlenarComboHabitaciones();
    }//GEN-LAST:event_cbTipoHabItemStateChanged

    private void txBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txBuscarKeyReleased
        if (cambio == 1) {
            control.LlenarJtable(modelo, "SELECT * FROM vis_alojamiento_persona where DNI like'%" + txBuscar.getText() + "%';", 8);
        } else if (cambio == 2) {
            control.LlenarJtable(modelo, "SELECT * FROM vis_alojamiento_empresa where RUC like'%" + txBuscar.getText() + "%';", 8);
        }
    }//GEN-LAST:event_txBuscarKeyReleased

    private void txRUCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRUCKeyTyped
        Textos.Numeros(evt);
        Textos.LimitarCaracter(evt, txRUC, 11);
    }//GEN-LAST:event_txRUCKeyTyped

    private void txRUCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRUCKeyReleased
        if(txRUC.getText().length() == 11){
            MostrarEmpresa();
            reconocer();
        }else{
            txNombreEmp.setText("");
            txProcEmp.setText("");
            txMailEmp.setText("");
        }
    }//GEN-LAST:event_txRUCKeyReleased

    private void txNombreEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNombreEmpKeyTyped
        Textos.LimitarCaracter(evt, txNombreEmp, 100);
    }//GEN-LAST:event_txNombreEmpKeyTyped
    private void txProcEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txProcEmpKeyTyped
        Textos.LimitarCaracter(evt, txProcEmp, 100);
    }//GEN-LAST:event_txProcEmpKeyTyped
    private void txMailEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txMailEmpKeyTyped
        Textos.LimitarCaracter(evt, txMailEmp, 100);
    }//GEN-LAST:event_txMailEmpKeyTyped

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
            java.util.logging.Logger.getLogger(Alojamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alojamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alojamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alojamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alojamiento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btClienteEmpresa;
    private javax.swing.JButton btClientePersona;
    private javax.swing.JButton btModificar;
    private javax.swing.JButton btRegistrar;
    private javax.swing.JComboBox<String> cbNumHab;
    private javax.swing.JComboBox<String> cbTipoHab;
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
    private javax.swing.JTextField txBuscar;
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
    // End of variables declaration//GEN-END:variables
}
