package Ventanas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DatosUsuario extends javax.swing.JFrame {
    
    public boolean pw1 = false; //controlador para visiblidad de campo de password 1
    public boolean pw2 = false; //controlador para visiblidad de campo de password 1
    
    public DatosUsuario() {
        initComponents();
        btModificar.setEnabled(false);
        this.setLocationRelativeTo(null);
        
    }

    
    public void Limpiar(){
        username.setText("");
        pw1Oculto.setText("");
        pw2Oculto.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        pnDatosPersonales = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbAPaterno = new javax.swing.JLabel();
        lbAMaterno = new javax.swing.JLabel();
        lbNombres = new javax.swing.JLabel();
        lbDNI = new javax.swing.JLabel();
        pnCredenciales = new javax.swing.JPanel();
        label8 = new javax.swing.JLabel();
        label9 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        pw1Oculto = new javax.swing.JPasswordField();
        label10 = new javax.swing.JLabel();
        pw2Oculto = new javax.swing.JPasswordField();
        btModificar = new javax.swing.JButton();
        lbVisible2 = new javax.swing.JLabel();
        lbVisible1 = new javax.swing.JLabel();
        pw2Visible = new javax.swing.JTextField();
        pw1Visible = new javax.swing.JTextField();
        pnDatosUsuario = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbCargo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(13, 39, 70));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lunandina/logoSession.png"))); // NOI18N
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 46));

        jButton1.setBackground(new java.awt.Color(187, 62, 52));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/iconCerrarSesion.png"))); // NOI18N
        jButton1.setText("Cerrar Sesión");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 3, 160, 40));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 46));

        jPanel1.setBackground(new java.awt.Color(23, 23, 23));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnDatosPersonales.setBackground(new java.awt.Color(23, 23, 23));
        pnDatosPersonales.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(248, 177, 57), 1, true), "Datos personales del usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(248, 177, 57))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(248, 177, 57));
        jLabel1.setText("DNI");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(248, 177, 57));
        jLabel2.setText("Apellido Paterno");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(248, 177, 57));
        jLabel3.setText("Apellido Materno");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(248, 177, 57));
        jLabel4.setText("Nombres");

        lbAPaterno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbAPaterno.setForeground(new java.awt.Color(255, 255, 255));
        lbAPaterno.setText("APELLIDO PATERNO");

        lbAMaterno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbAMaterno.setForeground(new java.awt.Color(255, 255, 255));
        lbAMaterno.setText("APELLIDO MATERNO");

        lbNombres.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbNombres.setForeground(new java.awt.Color(255, 255, 255));
        lbNombres.setText("NOMBRES");

        lbDNI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbDNI.setForeground(new java.awt.Color(255, 255, 255));
        lbDNI.setText("DNI");

        javax.swing.GroupLayout pnDatosPersonalesLayout = new javax.swing.GroupLayout(pnDatosPersonales);
        pnDatosPersonales.setLayout(pnDatosPersonalesLayout);
        pnDatosPersonalesLayout.setHorizontalGroup(
            pnDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDatosPersonalesLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDatosPersonalesLayout.createSequentialGroup()
                        .addGroup(pnDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
                .addGroup(pnDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        pnDatosPersonalesLayout.setVerticalGroup(
            pnDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDatosPersonalesLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(pnDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbAPaterno))
                .addGap(34, 34, 34)
                .addGroup(pnDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbAMaterno))
                .addGap(29, 29, 29)
                .addGroup(pnDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbNombres))
                .addGap(32, 32, 32)
                .addGroup(pnDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbDNI))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel1.add(pnDatosPersonales, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 510, 260));

        pnCredenciales.setBackground(new java.awt.Color(23, 23, 23));
        pnCredenciales.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 59, 48), 1, true), "Modificar Credenciales de Acceso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 59, 48))); // NOI18N
        pnCredenciales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label8.setForeground(new java.awt.Color(255, 59, 48));
        label8.setText("Nuevo Nombre de Usuario");
        pnCredenciales.add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 60, 170, 30));

        label9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label9.setForeground(new java.awt.Color(255, 59, 48));
        label9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label9.setText("Nueva Contraseña");
        pnCredenciales.add(label9, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 140, 170, 30));

        username.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usernameKeyTyped(evt);
            }
        });
        pnCredenciales.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 240, 30));

        pw1Oculto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pw1Oculto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pw1Oculto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pw1OcultoKeyTyped(evt);
            }
        });
        pnCredenciales.add(pw1Oculto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 240, 30));

        label10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label10.setForeground(new java.awt.Color(255, 59, 48));
        label10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label10.setText("Repita Nueva Contraseña");
        pnCredenciales.add(label10, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 220, 170, 30));

        pw2Oculto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pw2Oculto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pw2Oculto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pw2OcultoKeyTyped(evt);
            }
        });
        pnCredenciales.add(pw2Oculto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 240, 30));

        btModificar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/edit.png"))); // NOI18N
        btModificar.setText("Modificar Credenciales");
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });
        pnCredenciales.add(btModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 300, 240, -1));

        lbVisible2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/visible.png"))); // NOI18N
        lbVisible2.setToolTipText("Mostrar contraseña");
        lbVisible2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbVisible2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbVisible2MouseClicked(evt);
            }
        });
        pnCredenciales.add(lbVisible2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, -1, 30));

        lbVisible1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/visible.png"))); // NOI18N
        lbVisible1.setToolTipText("Mostrar contraseña");
        lbVisible1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbVisible1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbVisible1MouseClicked(evt);
            }
        });
        pnCredenciales.add(lbVisible1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, -1, 30));

        pw2Visible.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pnCredenciales.add(pw2Visible, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 240, 30));

        pw1Visible.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pnCredenciales.add(pw1Visible, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 240, 30));

        jPanel1.add(pnCredenciales, new org.netbeans.lib.awtextra.AbsoluteConstraints(541, 20, 510, 390));

        pnDatosUsuario.setBackground(new java.awt.Color(23, 23, 23));
        pnDatosUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(248, 177, 57), 1, true), "Usuario actual", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(248, 177, 57)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(248, 177, 57))); // NOI18N
        pnDatosUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(248, 177, 57));
        jLabel7.setText("Usuario");
        pnDatosUsuario.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        lbUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbUser.setForeground(new java.awt.Color(255, 255, 255));
        lbUser.setText("NOMBRE DE USUARIO");
        pnDatosUsuario.add(lbUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(248, 177, 57));
        jLabel5.setText("Cargo");
        pnDatosUsuario.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 100, -1));

        lbCargo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbCargo.setForeground(new java.awt.Color(255, 255, 255));
        lbCargo.setText("CARGO");
        pnDatosUsuario.add(lbCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 250, -1));

        jPanel1.add(pnDatosUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 510, 120));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 38, 1060, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
        String pw1, pw2, pwAnterior="anterior";
        pw1 = pw1Oculto.getText();
        pw2 = pw2Oculto.getText();

        if (pw1.equals(pw2)) {
            pwAnterior = JOptionPane.showInputDialog("Ingrese su contraseña actual para validar la operacion");
            //igualar la contraseña ingresada con la que esta en la base de datos. Usar if :v
            Limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
            pw2Oculto.grabFocus();
        }

        System.out.println(pw1 + "\n" + pw2 + "\n" + pwAnterior);
    }//GEN-LAST:event_btModificarActionPerformed

    private void usernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyTyped
        if (username.getText().length() > 0 && pw1Oculto.getText().length() > 0 && pw2Oculto.getText().length() > 0) {
            btModificar.setEnabled(true);
        } else {
            btModificar.setEnabled(false);
        }
    }//GEN-LAST:event_usernameKeyTyped

    private void pw1OcultoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pw1OcultoKeyTyped
        if (username.getText().length() > 0 && pw1Oculto.getText().length() > 0 && pw2Oculto.getText().length() > 0) {
            btModificar.setEnabled(true);
        } else {
            btModificar.setEnabled(false);
        }
    }//GEN-LAST:event_pw1OcultoKeyTyped

    private void pw2OcultoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pw2OcultoKeyTyped
        if (username.getText().length() > 0 && pw1Oculto.getText().length() > 0 && pw2Oculto.getText().length() > 0) {
            btModificar.setEnabled(true);
        } else {
            btModificar.setEnabled(false);
        }
    }//GEN-LAST:event_pw2OcultoKeyTyped

    private void lbVisible1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVisible1MouseClicked
        if(!pw1){
            pw1Visible.setVisible(true);
            pw1Visible.setText(pw1Oculto.getText());
            pw1Oculto.setVisible(false);
            lbVisible1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/invisible.png")));
            lbVisible1.setToolTipText("Ocultar contraseña");
            pw1 = true;
        }else{
            pw1Oculto.setVisible(true);
            pw1Oculto.setText(pw1Visible.getText());
            pw1Visible.setVisible(false);            
            lbVisible1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/visible.png")));
            lbVisible1.setToolTipText("Mostrar contraseña");
            pw1 = false;
        }
    }//GEN-LAST:event_lbVisible1MouseClicked

    private void lbVisible2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVisible2MouseClicked
        if(!pw2){
            pw2Visible.setVisible(true);
            pw2Visible.setText(pw2Oculto.getText());
            pw2Oculto.setVisible(false);
            lbVisible2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/invisible.png")));
            lbVisible2.setToolTipText("Ocultar contraseña");
            pw2 = true;
        }else{     
            pw2Oculto.setVisible(true);
            pw2Oculto.setText(pw2Visible.getText()); 
            pw2Visible.setVisible(false);      
            lbVisible2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/visible.png")));
            lbVisible2.setToolTipText("Mostrar contraseña");
            pw2 = false;
        }
    }//GEN-LAST:event_lbVisible2MouseClicked

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
            java.util.logging.Logger.getLogger(DatosUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatosUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatosUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatosUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatosUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btModificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel label10;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel label9;
    private javax.swing.JLabel lbAMaterno;
    private javax.swing.JLabel lbAPaterno;
    private javax.swing.JLabel lbCargo;
    private javax.swing.JLabel lbDNI;
    private javax.swing.JLabel lbNombres;
    private javax.swing.JLabel lbUser;
    private javax.swing.JLabel lbVisible1;
    private javax.swing.JLabel lbVisible2;
    private javax.swing.JPanel pnCredenciales;
    private javax.swing.JPanel pnDatosPersonales;
    private javax.swing.JPanel pnDatosUsuario;
    private javax.swing.JPasswordField pw1Oculto;
    private javax.swing.JTextField pw1Visible;
    private javax.swing.JPasswordField pw2Oculto;
    private javax.swing.JTextField pw2Visible;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
