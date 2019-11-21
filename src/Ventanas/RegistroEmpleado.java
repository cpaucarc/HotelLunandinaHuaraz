package Ventanas;

import Clases.Control;
import Clases.Controlador;
import javax.swing.JOptionPane;

public class RegistroEmpleado extends javax.swing.JFrame {
    
    Controlador control=new Controlador();
    
    public RegistroEmpleado() {
        initComponents();
        lbUserActual.setText(Control.usuario);
        control.LlenarCombo(cbEstado, "SELECT * FROM estadoempleado", 2);
        control.LlenarCombo(cbCargo, "SELECT * FROM cargos", 2);
    }

    public void Limpiar(){
        
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
        txdni = new javax.swing.JTextField();
        txappat = new javax.swing.JTextField();
        txapmat = new javax.swing.JTextField();
        txnomb = new javax.swing.JTextField();
        txmail = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cbCargo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
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

        txdni.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txdni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txdni.setSelectionColor(new java.awt.Color(0, 122, 255));
        txdni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txdniActionPerformed(evt);
            }
        });
        jPanel1.add(txdni, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 35, 280, 30));

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

        jPanel5.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 461, 344));

        jButton1.setBackground(new java.awt.Color(136, 206, 82));
        jButton1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/agregar.png"))); // NOI18N
        jButton1.setText("Registrar Empleado");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 605, -1, 40));

        jButton2.setBackground(new java.awt.Color(255, 185, 83));
        jButton2.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/modificar.png"))); // NOI18N
        jButton2.setText("Modificar Datos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 605, 170, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))), "DATOS DEL EMPLEO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(23, 23, 23))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Estado");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 84, 120, 30));

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
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 5, -1, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 46, 521, 700));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))), "EMPLEADOS REGISTRADOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(23, 23, 23))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "DNI", "Apellidos", "Nombres", "Email", "Cargo", "Nombre Usuario"
            }
        ));
        jTable1.setSelectionBackground(new java.awt.Color(0, 122, 255));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 724, 500));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/buscar.png"))); // NOI18N
        jLabel10.setText("Buscar");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 40, 90, 30));

        txbuscar.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txbuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txbuscar.setSelectionColor(new java.awt.Color(0, 122, 255));
        jPanel2.add(txbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 40, 400, 30));

        jPanel6.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 784, 610));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(521, 46, 845, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txdniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txdniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txdniActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //sp_empleado`(in evt int, dni varchar(8), appat varchar(50), apmat varchar(50), nombres varchar(50), 
						//mail varchar(50), carg varchar(50), estad varchar(50))
        JOptionPane.showMessageDialog(null, 
                control.DevolverRegistroDto("call sp_empleado(1,'"+
                        txdni.getText()+"','"+
                        txappat.getText()+"','"+
                        txapmat.getText()+"','"+
                        txnomb.getText()+"','"+
                        txmail.getText()+"','"+
                        cbCargo.getSelectedItem().toString() + "','"+
                        cbEstado.getSelectedItem().toString() + "')", 1));
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JComboBox<String> cbCargo;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbCerrar;
    private javax.swing.JLabel lbMinimizar;
    private javax.swing.JLabel lbUserActual;
    private javax.swing.JTextField txapmat;
    private javax.swing.JTextField txappat;
    private javax.swing.JTextField txbuscar;
    private javax.swing.JTextField txdni;
    private javax.swing.JTextField txmail;
    private javax.swing.JTextField txnomb;
    // End of variables declaration//GEN-END:variables
}
