package Ventanas;

import Clases.*;
import Clases.Design;
import Clases.LoginLunandina;
import javax.swing.JOptionPane;

public class LoginAcceso extends javax.swing.JFrame {

    public String rpt = "";
    Controlador control = new Controlador();
    static Design design = new Design();
    public boolean psw = false;
    String user, password;// Para hacer la comparacion para el ingreso al sistema  

    public LoginAcceso() {
        long init = System.currentTimeMillis();
        initComponents();
        design.MoverFrame(jPanel1, this);
        username.grabFocus();
        System.out.println("Time: "+(System.currentTimeMillis()-init)+" millis");
    }

    public boolean FormularioLleno(){
        return (username.getText() != null && pwOculto.getText() != null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnLogin = new javax.swing.JPanel();
        lbVerContra = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        btIngresar = new javax.swing.JButton();
        pwOculto = new javax.swing.JPasswordField();
        pwVisible = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lbCerrar = new javax.swing.JLabel();
        lbMinimizar = new javax.swing.JLabel();

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

        pnLogin.setBackground(new java.awt.Color(255, 255, 255));
        pnLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbVerContra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/visible.png"))); // NOI18N
        lbVerContra.setToolTipText("Mostrar contraseña");
        lbVerContra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbVerContraMouseClicked(evt);
            }
        });
        pnLogin.add(lbVerContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 205, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Contraseña");
        pnLogin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 185, 200, 20));

        username.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        username.setForeground(new java.awt.Color(23, 23, 23));
        username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        username.setSelectionColor(new java.awt.Color(0, 122, 255));
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        pnLogin.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 110, 200, 30));

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
        pnLogin.add(btIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 300, 200, 40));

        pwOculto.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        pwOculto.setForeground(new java.awt.Color(23, 23, 23));
        pwOculto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pwOculto.setSelectionColor(new java.awt.Color(0, 122, 255));
        pwOculto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pwOcultoKeyReleased(evt);
            }
        });
        pnLogin.add(pwOculto, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 205, 200, 30));

        pwVisible.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        pwVisible.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pwVisible.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pwVisibleKeyReleased(evt);
            }
        });
        pnLogin.add(pwVisible, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 205, 200, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Nombre de Usuario");
        pnLogin.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 90, 200, 20));

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
        pnLogin.add(lbCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 8, 30, 30));

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
        pnLogin.add(lbMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 8, 30, 30));

        getContentPane().add(pnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 310, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
    }//GEN-LAST:event_usernameActionPerformed

    private void lbVerContraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVerContraMouseClicked
        if (!psw) { //Mostrar la contraseña
            lbVerContra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/invisible.png")));
            lbVerContra.setToolTipText("Ocultar contraseña");
            pwOculto.setVisible(false);
            psw = true;
        } else { //Ocultar la contraseña
            lbVerContra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/visible.png")));
            lbVerContra.setToolTipText("Mostrar contraseña");
            pwOculto.setVisible(true);
            psw = false;
        }
    }//GEN-LAST:event_lbVerContraMouseClicked

    private void btIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngresarActionPerformed
        long init = System.currentTimeMillis();
        if(FormularioLleno()){
            user = username.getText(); //Recuperamos texto del campo username(TXT)
            password = pwOculto.getText(); //Recuperamos la contraseña del campo pwOculto (PASS)
            String _estado = control.DevolverRegistroDto("SELECT count(*) FROM vw_empleados where estado = 'Activo' and username = '"+user+"'", 1);
            LoginLunandina lgl = new LoginLunandina(user, password);

            if(!_estado.equals("0")){ // Usuario Activo
                if (lgl.VerifUsuario()) { //Vemos si existe usuario
                    if (lgl.VerifCredenciales()) { //Vemos si el usuario y la contraseña coinciden
                        Control.usuario = lgl.getnomEmp(); //Apellidos y nombres del empleado
                        Control.empleado = lgl.getUsuario(); //Nombre de usuario del empleado                        
                        Control.cargo = lgl.getCargo();
                        
                        control.CrearRegistro("call proc_UpdateStateDay();"); //Actualizamos el estado de las habitaciones
                        MenuPrincipal mp = new MenuPrincipal();
                        mp.setVisible(true);
                        this.dispose();
                    } else {
                        rpt = "Credenciales incorrectas";
                        JOptionPane.showMessageDialog(null, rpt);
                        username.grabFocus();
                    }
                } else {
                    rpt = "Este usuario no existe";
                    JOptionPane.showMessageDialog(null, rpt);                    
                    username.grabFocus();
                }
            }else{ // El usuario esta Despedido o no esta bien definido el usuario
                rpt = "Usuario no autorizado";
                JOptionPane.showMessageDialog(null, rpt);
            }        
        }else{
            rpt="Faltan campos por llenar";
        }
        System.out.println("Time: "+(System.currentTimeMillis()-init)+"  millis");
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

    /* EVENT KEY-RELEASED para sincronizar las contraseñas */
    private void pwOcultoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwOcultoKeyReleased
        pwVisible.setText(pwOculto.getText());
    }//GEN-LAST:event_pwOcultoKeyReleased
    private void pwVisibleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwVisibleKeyReleased
        pwOculto.setText(pwVisible.getText());
    }//GEN-LAST:event_pwVisibleKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //design.Nimbus();
                new LoginAcceso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbCerrar;
    private javax.swing.JLabel lbMinimizar;
    private javax.swing.JLabel lbVerContra;
    private javax.swing.JPanel pnLogin;
    private javax.swing.JPasswordField pwOculto;
    private javax.swing.JTextField pwVisible;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
