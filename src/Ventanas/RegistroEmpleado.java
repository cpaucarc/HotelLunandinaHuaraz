package Ventanas;

import Clases.*;
import alertas.*;
import javax.swing.table.DefaultTableModel;

public class RegistroEmpleado extends javax.swing.JFrame {

    public String rpt = "";
    Controlador control = new Controlador();
    Design ds = new Design();
    DefaultTableModel modelo = new DefaultTableModel();

    public RegistroEmpleado() {
        initComponents();
        lbUserActual.setText(Control.usuario);
        control.LlenarCombo(cbEstado, "SELECT * FROM estadoempleado", 2);
        control.LlenarCombo(cbCargo, "SELECT * FROM cargos", 2);
        cbCargo.setSelectedIndex(0);

        InicializarTabla();
        MostrarResultados();

        cbEstado.setEnabled(false);
        cbEstado.setSelectedIndex(0);
        btModificar.setEnabled(false);
    }

    public void InicializarTabla() {
        modelo.setColumnIdentifiers(new String[]{"DNI", "APELLIDOS", "NOMBRES", "E-MAIL", "CARGO", "ESTADO", "USUARIO"});
        tabla.setModel(modelo);
        ds.Centrar_Tabla(tabla);

        tabla.getColumnModel().getColumn(1).setPreferredWidth(100); // Apellidos
        tabla.getColumnModel().getColumn(2).setPreferredWidth(100); // Nombres
        tabla.getColumnModel().getColumn(3).setPreferredWidth(110); // Email
    }

    public void Seleccionar() {
        txdni.setText(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
        txappat.setText(tabla.getValueAt(tabla.getSelectedRow(), 1).toString().split(" ")[0]);
        txapmat.setText(tabla.getValueAt(tabla.getSelectedRow(), 1).toString().split(" ")[1]);
        txnomb.setText(tabla.getValueAt(tabla.getSelectedRow(), 2).toString());
        txmail.setText(tabla.getValueAt(tabla.getSelectedRow(), 3).toString());
        cbCargo.setSelectedItem(tabla.getValueAt(tabla.getSelectedRow(), 4).toString());
        cbEstado.setSelectedItem(tabla.getValueAt(tabla.getSelectedRow(), 5).toString());
    }

    public void Limpiar() {
        txdni.setText("");
        txappat.setText("");
        txapmat.setText("");
        txnomb.setText("");
        txmail.setText("");
        cbCargo.setSelectedIndex(-1);
        cbEstado.setSelectedIndex(0);
    }

    public void MostrarResultados() {
        String consulta = "select * from vw_empleados where estado = 'Activo' and ("
                + "dni like '%" + txbuscar.getText() + "%' or "
                + "apellidos like '%" + txbuscar.getText() + "%' or "
                + "nombres like '%" + txbuscar.getText() + "%' or "
                + "mail like '%" + txbuscar.getText() + "%' or "
                + "cargo like '%" + txbuscar.getText() + "%' or "
                + "estado like '%" + txbuscar.getText() + "%' or "
                + "username like '%" + txbuscar.getText() + "%')";
        control.LlenarJtable(modelo, consulta, 7);
    }
    public void GetEmploye(String dni){
        txappat.setText(control.DevolverRegistroDto("SELECT apPat FROM personas  WHERE DNI = '"+dni+"'", 1));
        txapmat.setText(control.DevolverRegistroDto("SELECT apMat FROM personas  WHERE DNI = '"+dni+"'", 1));
        txnomb.setText(control.DevolverRegistroDto("SELECT nomb FROM personas  WHERE DNI = '"+dni+"'", 1));
        txmail.setText(control.DevolverRegistroDto("SELECT email FROM personas  WHERE DNI = '"+dni+"'", 1));
        
        cbCargo.setSelectedItem(control.DevolverRegistroDto("SELECT cargo FROM vw_empleados WHERE dni = '"+dni+"'", 1));
        cbEstado.setSelectedItem(control.DevolverRegistroDto("SELECT estado FROM vw_empleados WHERE dni = '"+dni+"'", 1));
    }
    public void Controls(boolean b){
        cbEstado.setEnabled(b);
        btModificar.setEnabled(b);
        btRegistrar.setEnabled(!b);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        lbUserActual = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbMinimizar = new javax.swing.JLabel();
        lbCerrar = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txappat = new javax.swing.JTextField();
        txapmat = new javax.swing.JTextField();
        txnomb = new javax.swing.JTextField();
        txmail = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txdni = new javax.swing.JTextField();
        btRegistrar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lbEstado = new javax.swing.JLabel();
        cbCargo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txbuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1366, 750));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(13, 39, 70));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lunandina/logoEmpleado.png"))); // NOI18N
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 7, -1, 40));

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))), "DATOS PERSONALES DEL EMPLEADO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(23, 23, 23))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("DNI");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 35, 120, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("A. Paterno");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 120, 31));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("A. Materno");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 145, 120, 31));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Nombres");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 120, 31));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Email");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 255, 120, 31));

        txappat.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txappat.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txappat.setSelectionColor(new java.awt.Color(0, 122, 255));
        jPanel1.add(txappat, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 90, 280, 30));

        txapmat.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txapmat.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txapmat.setSelectionColor(new java.awt.Color(0, 122, 255));
        jPanel1.add(txapmat, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 145, 280, 30));

        txnomb.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txnomb.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txnomb.setSelectionColor(new java.awt.Color(0, 122, 255));
        jPanel1.add(txnomb, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 200, 280, 30));

        txmail.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txmail.setSelectionColor(new java.awt.Color(0, 122, 255));
        jPanel1.add(txmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 255, 280, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, -1, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        txdni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txdni.setSelectionColor(new java.awt.Color(0, 122, 255));
        txdni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txdniKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txdniKeyTyped(evt);
            }
        });
        jPanel1.add(txdni, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 35, 280, 30));

        jPanel5.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 461, 344));

        btRegistrar.setBackground(new java.awt.Color(136, 206, 82));
        btRegistrar.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/agregar.png"))); // NOI18N
        btRegistrar.setText("Registrar Empleado");
        btRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarActionPerformed(evt);
            }
        });
        jPanel5.add(btRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 605, -1, 40));

        btModificar.setBackground(new java.awt.Color(255, 185, 83));
        btModificar.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/modificar.png"))); // NOI18N
        btModificar.setText("Modificar Datos");
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });
        jPanel5.add(btModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 605, 170, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))), "DATOS DEL EMPLEO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(23, 23, 23))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbEstado.setText("Estado");
        jPanel3.add(lbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 84, 120, 30));

        cbCargo.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        cbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Recepcionista" }));
        jPanel3.add(cbCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 27, 280, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Cargo");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 27, 120, 30));

        cbEstado.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo" }));
        jPanel3.add(cbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 84, 280, -1));

        jPanel5.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 409, 461, 141));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/limpiar.png"))); // NOI18N
        jLabel11.setToolTipText("Limpiar formularios");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 5, -1, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 46, 521, 700));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))), "EMPLEADOS REGISTRADOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(23, 23, 23))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 13)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "DNI", "Apellidos", "Nombres", "Email", "Cargo", "Nombre Usuario"
            }
        ));
        tabla.setRowHeight(30);
        tabla.setSelectionBackground(new java.awt.Color(0, 122, 255));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 724, 500));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/buscar.png"))); // NOI18N
        jLabel10.setText("Buscar");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 40, 90, 30));

        txbuscar.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txbuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txbuscar.setSelectionColor(new java.awt.Color(0, 122, 255));
        txbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txbuscarKeyTyped(evt);
            }
        });
        jPanel2.add(txbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 40, 400, 30));

        jPanel6.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 784, 610));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(521, 46, 845, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
        AlertaError alerror = new AlertaError(this, true);
        AlertaSuccess alsuccess = new AlertaSuccess(this, true);
        if (txdni.getText().length() == 8 && txappat.getText() != null && txapmat.getText() != null && txnomb.getText() != null 
                && txmail.getText() != null && cbCargo.getSelectedIndex() > -1 && cbEstado.getSelectedIndex() > -1) {
            rpt = (control.DevolverRegistroDto("call proc_empleado(2,'"
                    + txdni.getText() + "','"
                    + Textos.capitalizeText(txappat.getText()) + "','"
                    + Textos.capitalizeText(txapmat.getText()) + "','"
                    + Textos.capitalizeText(txnomb.getText()) + "','"
                    + txmail.getText() + "','"
                    + cbCargo.getSelectedItem().toString() + "','"
                    + cbEstado.getSelectedItem().toString() + "')", 1));
            Limpiar();
            MostrarResultados();

            txdni.setEditable(true);
            Controls(false);

            alsuccess.titulo.setText("<html><center>" + rpt + "</center></html>");
            alsuccess.setVisible(true);
        } else {
            rpt = "Faltan datos por rellenar";
            alerror.titulo.setText("<html><center>" + rpt + "</center></html>");
            alerror.setVisible(true);
        }
    }//GEN-LAST:event_btModificarActionPerformed

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

    private void btRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarActionPerformed
        AlertaError alerror = new AlertaError(this, true);
        AlertaSuccess alsuccess = new AlertaSuccess(this, true);
        if (txdni.getText().length() == 8 && txappat.getText() != null && txapmat.getText() != null
                && txnomb.getText() != null && txmail.getText() != null && cbCargo.getSelectedIndex() > -1) {
            rpt = (control.DevolverRegistroDto("call proc_empleado(1,'"
                    + txdni.getText() + "','"
                    + Textos.capitalizeText(txappat.getText()) + "','"
                    + Textos.capitalizeText(txapmat.getText()) + "','"
                    + Textos.capitalizeText(txnomb.getText()) + "','"
                    + txmail.getText() + "','"
                    + cbCargo.getSelectedItem().toString() + "','"
                    + cbEstado.getItemAt(1) + "')", 1));
            MostrarResultados();
            alsuccess.titulo.setText("<html><center>" + rpt + "</center></html>");
            alsuccess.setVisible(true);
            Limpiar();
        } else {
            rpt = "Faltan datos por rellenar";
            alerror.titulo.setText("<html><center>" + rpt + "</center></html>");
            alerror.setVisible(true);
        }
    }//GEN-LAST:event_btRegistrarActionPerformed

    private void txbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txbuscarKeyTyped
        MostrarResultados();
    }//GEN-LAST:event_txbuscarKeyTyped

    private void txdniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txdniKeyTyped
        Textos.Numeros(evt);
        Textos.LimiteCaracter(evt, txdni, 8);
    }//GEN-LAST:event_txdniKeyTyped

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        Limpiar();
        txdni.setEditable(true);
        Controls(false);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        txdni.setEditable(false);
        Controls(true);
        Seleccionar();
    }//GEN-LAST:event_tablaMouseClicked

    private void txdniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txdniKeyReleased
        String dni = txdni.getText();
        if(dni.length() == 8){
            GetEmploye(dni);
            Controls(true);
        }
    }//GEN-LAST:event_txdniKeyReleased

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
            java.util.logging.Logger.getLogger(RegistroEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btModificar;
    private javax.swing.JButton btRegistrar;
    private javax.swing.JComboBox<String> cbCargo;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbCerrar;
    private javax.swing.JLabel lbEstado;
    private javax.swing.JLabel lbMinimizar;
    private javax.swing.JLabel lbUserActual;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txapmat;
    private javax.swing.JTextField txappat;
    private javax.swing.JTextField txbuscar;
    private javax.swing.JTextField txdni;
    private javax.swing.JTextField txmail;
    private javax.swing.JTextField txnomb;
    // End of variables declaration//GEN-END:variables
}
