package Ventanas;

import javax.swing.JOptionPane;
import Clases.*;
import alertas.*;

public class DatosUsuario extends javax.swing.JFrame {

    public String rpt = "";
    Controlador control = new Controlador();
    public boolean pw1 = false; //controlador para visiblidad de campo de password 1
    public boolean pw2 = false; //controlador para visiblidad de campo de password 1
    Design design = new Design();

    String aux_usuario = Control.empleado;

    public DatosUsuario() {
        initComponents();
        design.MoverFrame(jPanel4, this);
        btModificar.setEnabled(false);

        lbCargo.setText(Control.cargo);
        lbUser.setText(Control.empleado);
        if (!Control.cargo.equals("")) {
            lbDNI.setText(control.DevolverRegistroDto("SELECT dni FROM vw_empleados WHERE username = '" + aux_usuario + "'", 1));
            lbAPaterno.setText(control.DevolverRegistroDto("SELECT apellidos FROM vw_empleados WHERE username = '" + aux_usuario + "'", 1).split(" ")[0]);
            lbAMaterno.setText(control.DevolverRegistroDto("SELECT apellidos FROM vw_empleados WHERE username = '" + aux_usuario + "'", 1).split(" ")[1]);
            lbNombres.setText(control.DevolverRegistroDto("SELECT nombres FROM vw_empleados WHERE username = '" + aux_usuario + "'", 1));
        }
    }

    public void Limpiar() {
        username.setText("");
        pw1Oculto.setText("");
        pw2Oculto.setText("");
        pw1Visible.setText("");
        pw2Visible.setText("");
        btModificar.setEnabled(false);
    }

    public void ActivarBotonModificar() {
        if (username.getText().length() > 0 && pw1Oculto.getText().length() > 0 && pw2Oculto.getText().length() > 0) {
            btModificar.setEnabled(true);
        } else {
            btModificar.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btCerrarSesion = new javax.swing.JButton();
        lbMinimizar = new javax.swing.JLabel();
        lbCerrar = new javax.swing.JLabel();
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
        pnDatosUsuario = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbCargo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
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
        lbStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(13, 39, 70));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lunandina/logoSession.png"))); // NOI18N
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 46));

        btCerrarSesion.setBackground(new java.awt.Color(255, 59, 48));
        btCerrarSesion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/iconCerrarSesion.png"))); // NOI18N
        btCerrarSesion.setText("Cerrar Sesión");
        btCerrarSesion.setBorder(null);
        btCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btCerrarSesion.setFocusPainted(false);
        btCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarSesionActionPerformed(evt);
            }
        });
        jPanel4.add(btCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 5, 150, 36));

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
        jPanel4.add(lbMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 8, 30, 30));

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
        jPanel4.add(lbCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 8, 30, 30));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 46));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnDatosPersonales.setBackground(new java.awt.Color(255, 255, 255));
        pnDatosPersonales.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(23, 23, 23), 1, true), "DATOS PERSONALES DEL USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(23, 23, 23))); // NOI18N
        pnDatosPersonales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(23, 23, 23));
        jLabel1.setText("DNI");
        pnDatosPersonales.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 100, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(23, 23, 23));
        jLabel2.setText("A. Paterno");
        pnDatosPersonales.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 100, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(23, 23, 23));
        jLabel3.setText("A. Materno");
        pnDatosPersonales.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 100, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(23, 23, 23));
        jLabel4.setText("Nombres");
        pnDatosPersonales.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 100, 30));

        lbAPaterno.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbAPaterno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAPaterno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnDatosPersonales.add(lbAPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 250, 30));

        lbAMaterno.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbAMaterno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAMaterno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnDatosPersonales.add(lbAMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 250, 30));

        lbNombres.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbNombres.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNombres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnDatosPersonales.add(lbNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 250, 30));

        lbDNI.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbDNI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDNI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnDatosPersonales.add(lbDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 250, 30));

        jPanel1.add(pnDatosPersonales, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 450, 240));

        pnDatosUsuario.setBackground(new java.awt.Color(255, 255, 255));
        pnDatosUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "DATOS DEL USUARIO ACTUAL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(23, 23, 23))); // NOI18N
        pnDatosUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(23, 23, 23));
        jLabel7.setText("Usuario");
        pnDatosUsuario.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 100, 30));

        lbUser.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnDatosUsuario.add(lbUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 250, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(23, 23, 23));
        jLabel5.setText("Cargo");
        pnDatosUsuario.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 100, 30));

        lbCargo.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbCargo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCargo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnDatosUsuario.add(lbCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 250, 30));

        jPanel1.add(pnDatosUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 450, 140));

        jLabel8.setText("v26");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 46, 510, 480));

        jPanel2.setBackground(new java.awt.Color(215, 215, 215));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnCredenciales.setBackground(new java.awt.Color(215, 215, 215));
        pnCredenciales.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "MODIFICAR CREDENCIALES DE ACCESO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        pnCredenciales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label8.setText("Nuevo nombre de  usuario");
        pnCredenciales.add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 50, 180, 30));

        label9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label9.setText("Nueva contraseña");
        pnCredenciales.add(label9, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 130, 120, 30));

        username.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usernameKeyTyped(evt);
            }
        });
        pnCredenciales.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 240, 30));

        pw1Oculto.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        pw1Oculto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pw1Oculto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pw1OcultoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pw1OcultoKeyTyped(evt);
            }
        });
        pnCredenciales.add(pw1Oculto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 240, 30));

        label10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label10.setText("Repita nueva contraseña");
        pnCredenciales.add(label10, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 210, 170, 30));

        pw2Oculto.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        pw2Oculto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pw2Oculto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pw2OcultoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pw2OcultoKeyTyped(evt);
            }
        });
        pnCredenciales.add(pw2Oculto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 240, 30));

        btModificar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/edit.png"))); // NOI18N
        btModificar.setText("Modificar Credenciales");
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });
        pnCredenciales.add(btModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 310, 240, 35));

        lbVisible2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/visible.png"))); // NOI18N
        lbVisible2.setToolTipText("Mostrar contraseña");
        lbVisible2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbVisible2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbVisible2MouseClicked(evt);
            }
        });
        pnCredenciales.add(lbVisible2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, -1, 30));

        lbVisible1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/visible.png"))); // NOI18N
        lbVisible1.setToolTipText("Mostrar contraseña");
        lbVisible1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbVisible1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbVisible1MouseClicked(evt);
            }
        });
        pnCredenciales.add(lbVisible1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, -1, 30));

        pw2Visible.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        pw2Visible.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pw2Visible.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pw2VisibleKeyReleased(evt);
            }
        });
        pnCredenciales.add(pw2Visible, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 240, 30));

        pw1Visible.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        pw1Visible.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pw1Visible.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pw1VisibleKeyReleased(evt);
            }
        });
        pnCredenciales.add(pw1Visible, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 240, 30));
        pnCredenciales.add(lbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 30, 30));

        jPanel2.add(pnCredenciales, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 530, 410));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 46, 590, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
        Alerta alr = new Alerta(this, true);
        AlertaError alError = new AlertaError(this, true);
        AlertaSuccess alSuccess = new AlertaSuccess(this, true);
        String usuario_viejo, usuario_nuevo, pw1, pw2, pwAnterior = "anterior";
        usuario_viejo = Control.empleado;
        usuario_nuevo = username.getText();
        pw1 = pw1Oculto.getText();
        pw2 = pw2Oculto.getText();

        if (pw1.equals(pw2)) {
            pwAnterior = JOptionPane.showInputDialog("Ingrese su contraseña actual para validar la operacion");
            if (!control.Verficnst("SELECT idusuario FROM usuarios WHERE login = '" + usuario_nuevo + "'")) {//No existe                
                if (control.Verficnst("SELECT idusuario FROM usuarios WHERE login = '" + usuario_viejo + "' AND psw = md5('" + pwAnterior + "')")) {
                    control.CrearRegistro("update usuarios set login = '" + usuario_nuevo + "', psw = md5('" + pw1 + "') WHERE login = '" + usuario_viejo + "'");
                    Control.empleado = usuario_nuevo;
                    lbUser.setText(Control.empleado);
                    rpt = ("Se cambió los datos del usuario correctamente");
                    alSuccess.titulo.setText("<html><center>" + rpt + "</center></html>");
                    alSuccess.setVisible(true);
                    Limpiar();
                } else {
                    rpt = ("La contraseña actual no coincide con la que ingreso");
                    alError.titulo.setText("<html><center>" + rpt + "</center></html>");
                    alError.setVisible(true);
                }
            } else {//Ya existe
                rpt = ("Este usuario ya existe, debe elegir otro");
                alError.titulo.setText("<html><center>" + rpt + "</center></html>");
                alError.setVisible(true);
                username.grabFocus();
            }
        } else {
            rpt = ("Las contraseñas no coinciden.");
            alError.titulo.setText("<html><center>" + rpt + "</center></html>");
            alError.setVisible(true);

            pw2Oculto.grabFocus();
        }
    }//GEN-LAST:event_btModificarActionPerformed

    private void usernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyTyped
    }//GEN-LAST:event_usernameKeyTyped
    private void pw1OcultoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pw1OcultoKeyTyped
    }//GEN-LAST:event_pw1OcultoKeyTyped
    private void pw2OcultoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pw2OcultoKeyTyped
    }//GEN-LAST:event_pw2OcultoKeyTyped

    private void lbVisible1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVisible1MouseClicked
        if (!pw1) {
            pw1Oculto.setVisible(false);
            lbVisible1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/invisible.png")));
            lbVisible1.setToolTipText("Ocultar contraseña");
            pw1 = true;
        } else {
            pw1Oculto.setVisible(true);;
            lbVisible1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/visible.png")));
            lbVisible1.setToolTipText("Mostrar contraseña");
            pw1 = false;
        }
    }//GEN-LAST:event_lbVisible1MouseClicked

    private void lbVisible2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVisible2MouseClicked
        if (!pw2) {
            pw2Oculto.setVisible(false);
            lbVisible2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/invisible.png")));
            lbVisible2.setToolTipText("Ocultar contraseña");
            pw2 = true;
        } else {
            pw2Oculto.setVisible(true);
            lbVisible2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/visible.png")));
            lbVisible2.setToolTipText("Mostrar contraseña");
            pw2 = false;
        }
    }//GEN-LAST:event_lbVisible2MouseClicked

    private void btCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarSesionActionPerformed
        int rsta = JOptionPane.showConfirmDialog(null, "¿Desea cerrar la sesión actual?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (rsta == 0) {
            Control.cargo = "";
            Control.empleado = "";
            Control.usuario = "";
            this.setVisible(false);
            LoginAcceso la = new LoginAcceso();
            la.setVisible(true);
        }
    }//GEN-LAST:event_btCerrarSesionActionPerformed

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
        new MenuPrincipal().setVisible(true);
    }//GEN-LAST:event_lbCerrarMouseClicked
    private void lbCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarMouseEntered
        lbCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/cerrar2.png")));
    }//GEN-LAST:event_lbCerrarMouseEntered
    private void lbCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarMouseExited
        lbCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/cerrar1.png")));
    }//GEN-LAST:event_lbCerrarMouseExited

    private void pw1OcultoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pw1OcultoKeyReleased
        pw1Visible.setText(pw1Oculto.getText());
        ActivarBotonModificar();
    }//GEN-LAST:event_pw1OcultoKeyReleased
    private void pw1VisibleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pw1VisibleKeyReleased
        pw1Oculto.setText(pw1Visible.getText());
        ActivarBotonModificar();
    }//GEN-LAST:event_pw1VisibleKeyReleased

    private void pw2OcultoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pw2OcultoKeyReleased
        pw2Visible.setText(pw2Oculto.getText());
        ActivarBotonModificar();
    }//GEN-LAST:event_pw2OcultoKeyReleased
    private void pw2VisibleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pw2VisibleKeyReleased
        pw2Oculto.setText(pw2Visible.getText());
        ActivarBotonModificar();
    }//GEN-LAST:event_pw2VisibleKeyReleased

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
    private javax.swing.JButton btCerrarSesion;
    private javax.swing.JButton btModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel label10;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel label9;
    private javax.swing.JLabel lbAMaterno;
    private javax.swing.JLabel lbAPaterno;
    private javax.swing.JLabel lbCargo;
    private javax.swing.JLabel lbCerrar;
    private javax.swing.JLabel lbDNI;
    private javax.swing.JLabel lbMinimizar;
    private javax.swing.JLabel lbNombres;
    private javax.swing.JLabel lbStatus;
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
