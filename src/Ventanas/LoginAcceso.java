package Ventanas;

import Clases.Control;
import Clases.Controlador;
import Clases.Design;
import javax.swing.JOptionPane;

public class LoginAcceso extends javax.swing.JFrame {
    
    Controlador control=new Controlador();
    static Design design=new Design();
    public boolean psw = false;
    /* usuario y password para pruebas temporales, se cambiara con DB*/
    String[] userArray = {"consuelo", "victor"};
    String[] passArray = {"root", "1234"};
    

    public LoginAcceso() {
        initComponents();
        design.MoverFrame(jPanel1, this);
        this.setLocationRelativeTo(null);
        pwVisible.setVisible(false);
        username.grabFocus();
        control.LlenarCombo(cbo, "select * from cargos", 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbVerContra = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        btIngresar = new javax.swing.JButton();
        pwOculto = new javax.swing.JPasswordField();
        pwVisible = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lbCerrar = new javax.swing.JLabel();
        lbMinimizar = new javax.swing.JLabel();
        cbo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(13, 39, 70));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lunandina/foto.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 460));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 494, 450));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbVerContra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/visible.png"))); // NOI18N
        lbVerContra.setToolTipText("Mostrar contraseña");
        lbVerContra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbVerContraMouseClicked(evt);
            }
        });
        jPanel2.add(lbVerContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 205, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Contraseña");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 185, 200, 20));

        username.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        username.setForeground(new java.awt.Color(23, 23, 23));
        username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        username.setSelectionColor(new java.awt.Color(0, 122, 255));
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 110, 200, 30));

        btIngresar.setBackground(new java.awt.Color(248, 177, 57));
        btIngresar.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btIngresar.setForeground(new java.awt.Color(23, 23, 23));
        btIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/login.png"))); // NOI18N
        btIngresar.setText("Ingresar");
        btIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIngresarActionPerformed(evt);
            }
        });
        jPanel2.add(btIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 310, 200, 40));

        pwOculto.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        pwOculto.setForeground(new java.awt.Color(23, 23, 23));
        pwOculto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pwOculto.setSelectionColor(new java.awt.Color(0, 122, 255));
        jPanel2.add(pwOculto, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 205, 200, 30));

        pwVisible.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        pwVisible.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(pwVisible, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 205, 200, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Nombre de Usuario");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 90, 200, 20));

        lbCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/cerrar3.png"))); // NOI18N
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
        jPanel2.add(lbCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 8, 30, 30));

        lbMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/minimizar3.png"))); // NOI18N
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
        jPanel2.add(lbMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 8, 30, 30));

        cbo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbo, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 396, 180, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 310, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void lbVerContraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVerContraMouseClicked
        if (!psw) { //Mostrar la contraseña
            lbVerContra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/invisible.png")));
            lbVerContra.setToolTipText("Ocultar contraseña");
            pwOculto.setVisible(false);
            pwVisible.setText(pwOculto.getText());
            pwVisible.setVisible(true);
            psw = true;
        } else { //Ocultar la contraseña
            lbVerContra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/visible.png")));
            lbVerContra.setToolTipText("Mostrar contraseña");
            pwVisible.setVisible(false);
            pwOculto.setText(pwVisible.getText());
            pwOculto.setVisible(true);
            psw = false;
        }
    }//GEN-LAST:event_lbVerContraMouseClicked

    private void btIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngresarActionPerformed
        String user, password;
        user = username.getText();
        password = pwOculto.getText();

        if (user.equals(userArray[0]) && password.equals(passArray[0])) { //User: consuelo, Password: root, Cargo: Administrador
            Control.usuario = user;
            Control.cargo = "Administrador";
            MenuPrincipal mp = new MenuPrincipal();
            mp.setVisible(true);
            this.dispose();
        } else if (user.equals(userArray[1]) && password.equals(passArray[1])) { //User: victor, Password: 1234, Cargo: Recepcionista
            Control.usuario = user;
            Control.cargo = "Recepcionista";
            MenuPrincipal mp = new MenuPrincipal();
            mp.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
            pwOculto.grabFocus();
        }
    }//GEN-LAST:event_btIngresarActionPerformed

    private void lbCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lbCerrarMouseClicked
    private void lbCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarMouseEntered
        lbCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/cerrar2.png")));
    }//GEN-LAST:event_lbCerrarMouseEntered
    private void lbCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarMouseExited
        lbCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/cerrar3.png")));
    }//GEN-LAST:event_lbCerrarMouseExited

    private void lbMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMinimizarMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_lbMinimizarMouseClicked
    private void lbMinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMinimizarMouseEntered
        lbMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/minimizar2.png")));
    }//GEN-LAST:event_lbMinimizarMouseEntered
    private void lbMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMinimizarMouseExited
        lbMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/minimizar3.png")));
    }//GEN-LAST:event_lbMinimizarMouseExited

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
            java.util.logging.Logger.getLogger(LoginAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {                
                design.Nimbus();
                new LoginAcceso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIngresar;
    private javax.swing.JComboBox<String> cbo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbCerrar;
    private javax.swing.JLabel lbMinimizar;
    private javax.swing.JLabel lbVerContra;
    private javax.swing.JPasswordField pwOculto;
    private javax.swing.JTextField pwVisible;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
