package Ventanas;

import Clases.*;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANGEL
 */
public class Alojamiento extends javax.swing.JFrame {
    
    
    Controlador control = new Controlador();
    ControlDate controlDT = new ControlDate();
    DefaultTableModel modelo = new DefaultTableModel();
    public int cambio = 1;

    public Alojamiento() {
        initComponents();
        this.setLocationRelativeTo(null);
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
    }

    public void inicializarJTable_persona() {
        modelo.setColumnIdentifiers(new String[]{"ID", "Fecha Entrada", "Fecha Salida", "N° Habitacion", "Tipo de Habitacion", "DNI", "Cliente", "Procedencia"});
        tabla.setModel(modelo);

        tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(115);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(110);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(110);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(150);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(240);
        tabla.getColumnModel().getColumn(7).setPreferredWidth(180);

        tabla.getColumnModel().removeColumn(tabla.getColumnModel().getColumn(0));
    }

    public void inicializarJTable_empresa() {
        modelo.setColumnIdentifiers(new String[]{"ID", "Fecha Entrada", "Fecha Salida", "N° Habitacion", "Tipo de Habitacion", "RUC", "Empresa", "Procedencia"});
        tabla.setModel(modelo);

        tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(115);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(110);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(110);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(150);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(150);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(220);
        tabla.getColumnModel().getColumn(7).setPreferredWidth(200);

        tabla.getColumnModel().removeColumn(tabla.getColumnModel().getColumn(0));
    }

    public void llenarCombo() {
        control.LlenarComboHB(cbotipohabitacion, "SELECT * FROM tipohabitacion;", 2);
        control.LlenarCombo(cbonumhabitacion, "SELECT * FROM habitaciones;", 2);
    }

    private void MostrarPersona() {
        control.LlenarJtable(modelo, "SELECT * FROM vis_alojamiento_persona where "
                + "DNI like'%" + txDNI.getText() + "%';", 8);
    }

    private void MostrarEmpresa() {
        control.LlenarJtable(modelo, "SELECT * FROM vis_alojamiento_empresa where "
                + "RUC like'%" + txRUC.getText() + "%';", 8);
    }

    String id;
    String DOR;
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
                    txapPaterno.setText(control.DevolverRegistroDto("select  apPat from personas where DNI='" + DOR + "';", 1));
                    txapMaterno.setText(control.DevolverRegistroDto("select  apMat from personas where DNI='" + DOR + "';", 1));
                    txNombre.setText(control.DevolverRegistroDto("select  nomb from personas where DNI='" + DOR + "';", 1));
                    txProcedencia.setText(modelo.getValueAt(fila, 7).toString());
                    txemail.setText(control.DevolverRegistroDto("select  email from personas where DNI='" + DOR + "';", 1));
                    cbotipohabitacion.setSelectedItem(modelo.getValueAt(fila, 4).toString());
                    cbonumhabitacion.setSelectedItem(modelo.getValueAt(fila, 3).toString());
                    txfentrada.setDate(controlDT.Parse_Fecha(modelo.getValueAt(fila, 1).toString()));
                    txfsalida.setDate(controlDT.Parse_Fecha(modelo.getValueAt(fila, 2).toString()));
                }
            } else if (cambio == 2) {
                contDOR = Integer.parseInt(control.DevolverRegistroDto("select count(*) from clienteempresa where RUC='" + DOR + "';", 1));
                txRUC.setText(DOR);
                if (contDOR != 0) {
                    txNomEmp.setText(control.DevolverRegistroDto("select  nombreEmpresa from clienteempresa where RUC='" + DOR + "';", 1));
                    txProcEmp.setText(modelo.getValueAt(fila, 7).toString());
                    txEmailEmp.setText(control.DevolverRegistroDto("select  email from clienteempresa where RUC='" + DOR + "';", 1));
                    cbotipohabitacion.setSelectedItem(modelo.getValueAt(fila, 4).toString());
                    cbonumhabitacion.setSelectedItem(modelo.getValueAt(fila, 3).toString());
                    txfentrada.setDate(controlDT.Parse_Fecha(modelo.getValueAt(fila, 1).toString()));
                    txfsalida.setDate(controlDT.Parse_Fecha(modelo.getValueAt(fila, 2).toString()));
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Fila no seleccionada");
        }

    }

    public void limpiar() {
        btModificar.setText("Modificar");
        txDNI.setText(null);
        txNombre.setText(null);
        txapPaterno.setText(null);
        txapMaterno.setText(null);
        txapMaterno.setText(null);
        txProcedencia.setText(null);
        txemail.setText(null);
        txfentrada.setDate(null);
        txfsalida.setDate(null);
        txRUC.setText(null);
        txNomEmp.setText(null);
        txProcEmp.setText(null);
        txEmailEmp.setText(null);
        cbotipohabitacion.setSelectedIndex(-1);
        cbonumhabitacion.setSelectedIndex(-1);
        if (cambio == 1) {
            MostrarPersona();
        } else if (cambio == 2) {
            MostrarEmpresa();
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
        txapPaterno = new javax.swing.JTextField();
        txapMaterno = new javax.swing.JTextField();
        jLabelDNI4 = new javax.swing.JLabel();
        jLabelDNI5 = new javax.swing.JLabel();
        txNombre = new javax.swing.JTextField();
        txProcedencia = new javax.swing.JTextField();
        jLabelDNI6 = new javax.swing.JLabel();
        jLabelDNI12 = new javax.swing.JLabel();
        txemail = new javax.swing.JTextField();
        pnClienteEmpresa = new javax.swing.JPanel();
        jLabelDNI18 = new javax.swing.JLabel();
        jLabelDNI19 = new javax.swing.JLabel();
        jLabelDNI20 = new javax.swing.JLabel();
        jLabelDNI21 = new javax.swing.JLabel();
        txRUC = new javax.swing.JTextField();
        txNomEmp = new javax.swing.JTextField();
        txProcEmp = new javax.swing.JTextField();
        txEmailEmp = new javax.swing.JTextField();
        btRegistrar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        pnFecha = new javax.swing.JPanel();
        jLabelDNI13 = new javax.swing.JLabel();
        jLabelDNI17 = new javax.swing.JLabel();
        txfsalida = new com.toedter.calendar.JDateChooser();
        txfentrada = new com.toedter.calendar.JDateChooser();
        pnHabitacion = new javax.swing.JPanel();
        jLabelDNI9 = new javax.swing.JLabel();
        jLabelDNI10 = new javax.swing.JLabel();
        jLabelDNI14 = new javax.swing.JLabel();
        jtxtdni8 = new javax.swing.JTextField();
        jLabelDNI15 = new javax.swing.JLabel();
        cbonumhabitacion = new javax.swing.JComboBox<>();
        cbotipohabitacion = new javax.swing.JComboBox<>();
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

        jPanel2.add(pnTipoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 25, 460, 120));

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

        txapPaterno.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txapPaterno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txapPaterno.setSelectionColor(new java.awt.Color(0, 122, 255));
        txapPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txapPaternoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txapPaternoKeyTyped(evt);
            }
        });
        pnClientePersona.add(txapPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 280, 30));

        txapMaterno.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txapMaterno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txapMaterno.setSelectionColor(new java.awt.Color(0, 122, 255));
        txapMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txapMaternoKeyTyped(evt);
            }
        });
        pnClientePersona.add(txapMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 280, 30));

        jLabelDNI4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDNI4.setText("Nombres");
        pnClientePersona.add(jLabelDNI4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 120, 30));

        jLabelDNI5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDNI5.setText("Procedencia");
        pnClientePersona.add(jLabelDNI5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 120, 30));

        txNombre.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txNombre.setSelectionColor(new java.awt.Color(0, 122, 255));
        txNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txNombreKeyTyped(evt);
            }
        });
        pnClientePersona.add(txNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 280, 30));

        txProcedencia.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txProcedencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txProcedencia.setSelectionColor(new java.awt.Color(0, 122, 255));
        txProcedencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txProcedenciaKeyTyped(evt);
            }
        });
        pnClientePersona.add(txProcedencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 280, 30));

        jLabelDNI6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDNI6.setText("E-mail");
        pnClientePersona.add(jLabelDNI6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 120, 30));

        jLabelDNI12.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDNI12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDNI12.setText("A. Materno");
        jLabelDNI12.setToolTipText("");
        pnClientePersona.add(jLabelDNI12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 120, 30));

        txemail.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txemail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txemail.setSelectionColor(new java.awt.Color(0, 122, 255));
        txemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txemailKeyTyped(evt);
            }
        });
        pnClientePersona.add(txemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 280, 30));

        jPanel2.add(pnClientePersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 25, 460, 340));

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

        txNomEmp.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txNomEmp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txNomEmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txNomEmpKeyTyped(evt);
            }
        });
        pnClienteEmpresa.add(txNomEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 105, 280, 30));

        txProcEmp.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txProcEmp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txProcEmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txProcEmpKeyTyped(evt);
            }
        });
        pnClienteEmpresa.add(txProcEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 280, 30));

        txEmailEmp.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txEmailEmp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txEmailEmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txEmailEmpKeyTyped(evt);
            }
        });
        pnClienteEmpresa.add(txEmailEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 235, 280, 30));

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

        txfsalida.setBackground(new java.awt.Color(255, 255, 255));
        txfsalida.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        pnFecha.add(txfsalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 75, 156, 30));

        txfentrada.setBackground(new java.awt.Color(255, 255, 255));
        txfentrada.setAutoscrolls(true);
        txfentrada.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        pnFecha.add(txfentrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 25, 156, 30));

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

        cbonumhabitacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "205", "207", "305", "306" }));
        pnHabitacion.add(cbonumhabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 75, 156, 30));

        cbotipohabitacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indivudual", "Doble", "Triple", "Matrimonial", "Matrimonial Lunandina" }));
        cbotipohabitacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbotipohabitacionItemStateChanged(evt);
            }
        });
        pnHabitacion.add(cbotipohabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 25, 156, 30));

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
        jPanel4.add(lbUserActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 0, 120, 46));

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

        tabla.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
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
        tabla.setSelectionBackground(new java.awt.Color(0, 122, 255));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 830, 490));

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

    private void txapPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txapPaternoKeyTyped
        Textos.Mayusculas(evt);
        Textos.LimitarCaracter(evt, txapPaterno, 50);
    }//GEN-LAST:event_txapPaternoKeyTyped

    private void txapMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txapMaternoKeyTyped
        Textos.Mayusculas(evt);
        Textos.LimitarCaracter(evt, txapMaterno, 50);
    }//GEN-LAST:event_txapMaternoKeyTyped

    private void txNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNombreKeyTyped
        Textos.Mayusculas(evt);
        Textos.LimitarCaracter(evt, txNombre, 50);
    }//GEN-LAST:event_txNombreKeyTyped

    private void jtxtdni8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdni8KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtdni8KeyTyped

    private void btRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarActionPerformed
        if (cambio == 1) {
            JOptionPane.showMessageDialog(null, control.DevolverRegistroDto("call proc_alojamiento_persona('" + txDNI.getText()
                    + "','" + Textos.capitalizeText(txapPaterno.getText()) + "','" + Textos.capitalizeText(txapMaterno.getText()) + "','" + Textos.capitalizeText(txNombre.getText())
                    + "','" + txProcedencia.getText() + "','" + txemail.getText() + "','"
                    + controlDT.fecha_AMD(txfentrada.getDate()) + "','" + controlDT.fecha_AMD(txfsalida.getDate())
                    + "','" + cbotipohabitacion.getSelectedItem() + "','" + cbonumhabitacion.getSelectedItem()
                    + "','" + Control.empleado + "');", 1));
            MostrarPersona();
        } else if (cambio == 2) {
            JOptionPane.showMessageDialog(null, control.DevolverRegistroDto("call proc_alojamiento_empresa('" + txRUC.getText()
                    + "','" + txNomEmp.getText() + "','" + txProcEmp.getText() + "','" + txEmailEmp.getText()
                    + "','" + controlDT.fecha_AMD(txfentrada.getDate()) + "','" + controlDT.fecha_AMD(txfsalida.getDate())
                    + "','" + cbotipohabitacion.getSelectedItem() + "'," + cbonumhabitacion.getSelectedItem()
                    + ",'" + Control.empleado + "');", 1));
            MostrarEmpresa();
            
        }
    }//GEN-LAST:event_btRegistrarActionPerformed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed

        if (btModificar.getText().equals("Modificar")) {
            btRegistrar.setEnabled(false);
            btModificar.setText("Actualizar");
            txDNI.setEditable(false);
            txRUC.setEditable(false);
            Seleccionar();
        } else {
            if (cambio == 1) {
                JOptionPane.showMessageDialog(null, control.DevolverRegistroDto("call proc_alojamiento_persona_editar(" + id + ",'" + txDNI.getText() + "','"
                        + txapPaterno.getText() + "','" + txapMaterno.getText() + "','" + txNombre.getText() + "','" + txProcedencia.getText() + "','"
                        + txemail.getText() + "','" + controlDT.fecha_AMD(txfsalida.getDate()) + "');", 1));
                MostrarPersona();
            } else if (cambio == 2) {
                JOptionPane.showMessageDialog(null, control.DevolverRegistroDto("call proc_alojamiento_empresa_editar(" + id + ",'" + txRUC.getText() + "','"
                        + txProcEmp.getText() + "','" + txNomEmp.getText() + "','" + txEmailEmp.getText() + "','" + controlDT.fecha_AMD(txfsalida.getDate()) + "');", 1));
                MostrarEmpresa();
            }
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
        // TODO add your handling code here:
    }//GEN-LAST:event_txBuscarKeyTyped

    private void txemailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txemailKeyTyped
        Textos.LimitarCaracter(evt, txemail, 100);
    }//GEN-LAST:event_txemailKeyTyped

    private void txProcedenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txProcedenciaKeyTyped
        Textos.LimitarCaracter(evt, txProcedencia, 100);
    }//GEN-LAST:event_txProcedenciaKeyTyped

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

    private void txDNIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDNIKeyReleased
        MostrarPersona();
    }//GEN-LAST:event_txDNIKeyReleased

    private void txapPaternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txapPaternoKeyReleased

    }//GEN-LAST:event_txapPaternoKeyReleased

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        
    }//GEN-LAST:event_tablaMouseClicked

    private void lbLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLimpiarMouseClicked
        limpiar();
        btRegistrar.setEnabled(true);
        txDNI.setEditable(true);
        txRUC.setEditable(true);
    }//GEN-LAST:event_lbLimpiarMouseClicked

    private void cbotipohabitacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbotipohabitacionItemStateChanged
        if (cbotipohabitacion.getSelectedIndex() > 0) {
            control.LlenarCombo(cbonumhabitacion, "select numero from vw_habitacion where tipo = '"
                    + cbotipohabitacion.getSelectedItem() + "' and estado='Disponible';", 1);
        }
        if (cbotipohabitacion.getSelectedItem() == ("--Seleccione--")) {
            cbonumhabitacion.removeAllItems();
        }
    }//GEN-LAST:event_cbotipohabitacionItemStateChanged

    private void txBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txBuscarKeyReleased
        if (cambio == 1) {
            control.LlenarJtable(modelo, "SELECT * FROM vis_alojamiento_persona where "
                    + "DNI like'%" + txBuscar.getText() + "%';", 8);
        } else if (cambio == 2) {
            control.LlenarJtable(modelo, "SELECT * FROM vis_alojamiento_empresa where "
                    + "RUC like'%" + txBuscar.getText() + "%';", 8);
        }
    }//GEN-LAST:event_txBuscarKeyReleased

    private void txRUCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRUCKeyTyped
        Textos.Numeros(evt);
        Textos.LimitarCaracter(evt, txRUC, 11);
    }//GEN-LAST:event_txRUCKeyTyped

    private void txRUCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRUCKeyReleased
        MostrarEmpresa();
    }//GEN-LAST:event_txRUCKeyReleased

    private void txNomEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNomEmpKeyTyped
        Textos.LimitarCaracter(evt, txNomEmp, 100);
    }//GEN-LAST:event_txNomEmpKeyTyped

    private void txProcEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txProcEmpKeyTyped
        Textos.LimitarCaracter(evt, txProcEmp, 100);
    }//GEN-LAST:event_txProcEmpKeyTyped

    private void txEmailEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txEmailEmpKeyTyped
        Textos.LimitarCaracter(evt, txEmailEmp, 100);
    }//GEN-LAST:event_txEmailEmpKeyTyped

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
    private javax.swing.JComboBox<String> cbonumhabitacion;
    private javax.swing.JComboBox<String> cbotipohabitacion;
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
    private javax.swing.JTextField txEmailEmp;
    private javax.swing.JTextField txNomEmp;
    private javax.swing.JTextField txNombre;
    private javax.swing.JTextField txProcEmp;
    private javax.swing.JTextField txProcedencia;
    private javax.swing.JTextField txRUC;
    private javax.swing.JTextField txapMaterno;
    private javax.swing.JTextField txapPaterno;
    private javax.swing.JTextField txemail;
    private com.toedter.calendar.JDateChooser txfentrada;
    private com.toedter.calendar.JDateChooser txfsalida;
    // End of variables declaration//GEN-END:variables
}
