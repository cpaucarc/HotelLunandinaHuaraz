package Ventanas;

import Clases.Control;
import javax.swing.JOptionPane;

public class LoginAcceso extends javax.swing.JFrame {

    public boolean psw = false;
    /* usuario y password para pruebas temporales, se cambiara con DB*/
    String[] userArray = {"consuelo", "victor"};
    String[] passArray = {"root", "1234"};

    public LoginAcceso() {
        initComponents();
        this.setLocationRelativeTo(null);
        pwVisible.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbVerContra = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        btIngresar = new javax.swing.JButton();
        pwOculto = new javax.swing.JPasswordField();
        pwVisible = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        jPanel2.add(lbVerContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Contraseña");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 200, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nombre de Usuario");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 80, 200, 20));

        username.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        username.setForeground(new java.awt.Color(23, 23, 23));
        username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        username.setSelectionColor(new java.awt.Color(0, 122, 255));
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 170, 200, 30));

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
        jPanel2.add(pwOculto, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 240, 200, 30));

        pwVisible.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        pwVisible.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(pwVisible, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 240, 200, 30));

        jComboBox1.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Recepcionista" }));
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 100, 200, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Nombre de Usuario");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 200, 20));

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
            this.dispose();
            MenuPrincipal mp = new MenuPrincipal();
            mp.setVisible(true);
        } else {
            if (user.equals(userArray[1]) && password.equals(passArray[1])) { //User: victor, Password: 1234, Cargo: Recepcionista
                Control.usuario = user;
                Control.cargo = "Recepcionista";
                this.dispose();
                MenuPrincipal mp = new MenuPrincipal();
                mp.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
                pwOculto.grabFocus();
            }
        }
    }//GEN-LAST:event_btIngresarActionPerformed

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
                new LoginAcceso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIngresar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbVerContra;
    private javax.swing.JPasswordField pwOculto;
    private javax.swing.JTextField pwVisible;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
