
package Ventanas;

import Clases.Control;
/**
 *
 * @author CLINTON
 */
public class FrmReserva extends javax.swing.JFrame {

    public FrmReserva() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(6);
        lbUserActual.setText(Control.usuario);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabelDNI2 = new javax.swing.JLabel();
        jtxtdni = new javax.swing.JTextField();
        jLabelDNI3 = new javax.swing.JLabel();
        jtxtdni1 = new javax.swing.JTextField();
        jtxtdni2 = new javax.swing.JTextField();
        jLabelDNI4 = new javax.swing.JLabel();
        jLabelDNI5 = new javax.swing.JLabel();
        jtxtdni3 = new javax.swing.JTextField();
        jtxtdni4 = new javax.swing.JTextField();
        jLabelDNI6 = new javax.swing.JLabel();
        jLabelDNI7 = new javax.swing.JLabel();
        jtxtdni5 = new javax.swing.JTextField();
        jLabelDNI12 = new javax.swing.JLabel();
        jtxtdni10 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabelDNI9 = new javax.swing.JLabel();
        jLabelDNI10 = new javax.swing.JLabel();
        jLabelDNI14 = new javax.swing.JLabel();
        jtxtdni8 = new javax.swing.JTextField();
        jLabelDNI15 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jbuttoncrear = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabelDNI8 = new javax.swing.JLabel();
        jLabelDNI11 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbUserActual = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelDNI16 = new javax.swing.JLabel();
        jtxtdni9 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(248, 177, 57));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(248, 177, 57));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "DATOS DEL CLIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Leelawadee UI Semilight", 1, 12))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDNI2.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabelDNI2.setText("DNI");
        jPanel1.add(jLabelDNI2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 25, 120, 30));

        jtxtdni.setBackground(new java.awt.Color(255, 255, 204));
        jtxtdni.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jtxtdni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtdniKeyTyped(evt);
            }
        });
        jPanel1.add(jtxtdni, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 25, 280, 30));

        jLabelDNI3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDNI3.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabelDNI3.setText("A. PATERNO");
        jLabelDNI3.setToolTipText("");
        jPanel1.add(jLabelDNI3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 75, 120, 30));

        jtxtdni1.setBackground(new java.awt.Color(255, 255, 204));
        jtxtdni1.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jtxtdni1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtdni1KeyTyped(evt);
            }
        });
        jPanel1.add(jtxtdni1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 75, 280, 30));

        jtxtdni2.setBackground(new java.awt.Color(255, 255, 204));
        jtxtdni2.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jtxtdni2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtdni2KeyTyped(evt);
            }
        });
        jPanel1.add(jtxtdni2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 125, 280, 30));

        jLabelDNI4.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabelDNI4.setText("NOMBRES");
        jPanel1.add(jLabelDNI4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 175, 120, 30));

        jLabelDNI5.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabelDNI5.setText("TELEFONO");
        jPanel1.add(jLabelDNI5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 225, 120, 30));

        jtxtdni3.setBackground(new java.awt.Color(255, 255, 204));
        jtxtdni3.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jtxtdni3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtdni3KeyTyped(evt);
            }
        });
        jPanel1.add(jtxtdni3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 175, 280, 30));

        jtxtdni4.setBackground(new java.awt.Color(255, 255, 204));
        jtxtdni4.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jtxtdni4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtdni4KeyTyped(evt);
            }
        });
        jPanel1.add(jtxtdni4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 225, 280, 30));

        jLabelDNI6.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabelDNI6.setText("PROCEDENCIA");
        jPanel1.add(jLabelDNI6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 275, 120, 30));

        jLabelDNI7.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabelDNI7.setText("E-MAIL");
        jPanel1.add(jLabelDNI7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 325, 120, 30));

        jtxtdni5.setBackground(new java.awt.Color(255, 255, 204));
        jtxtdni5.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jtxtdni5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtdni5KeyTyped(evt);
            }
        });
        jPanel1.add(jtxtdni5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 325, 280, 30));

        jLabelDNI12.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDNI12.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabelDNI12.setText("A. MATERNO");
        jLabelDNI12.setToolTipText("");
        jPanel1.add(jLabelDNI12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 125, 120, 30));

        jtxtdni10.setBackground(new java.awt.Color(255, 255, 204));
        jtxtdni10.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jtxtdni10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtdni10KeyTyped(evt);
            }
        });
        jPanel1.add(jtxtdni10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 275, 280, 30));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 461, 375));

        jPanel3.setBackground(new java.awt.Color(248, 177, 57));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "DATOS DE A HABITACION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Leelawadee UI Semilight", 1, 12))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDNI9.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabelDNI9.setText("N° HABITACIÓN");
        jPanel3.add(jLabelDNI9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 25, 120, 30));

        jLabelDNI10.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabelDNI10.setText("TIPO HABITACIÓN");
        jPanel3.add(jLabelDNI10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 75, 120, 30));

        jLabelDNI14.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabelDNI14.setText("COSTO:");
        jPanel3.add(jLabelDNI14, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 184, -1, -1));

        jtxtdni8.setBackground(new java.awt.Color(255, 255, 204));
        jtxtdni8.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jtxtdni8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtdni8KeyTyped(evt);
            }
        });
        jPanel3.add(jtxtdni8, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 183, 105, 22));

        jLabelDNI15.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabelDNI15.setForeground(new java.awt.Color(51, 51, 51));
        jLabelDNI15.setText("S/.");
        jPanel3.add(jLabelDNI15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 181, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 75, 156, 30));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 25, 156, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 535, 336, 120));

        jbuttoncrear.setBackground(new java.awt.Color(0, 153, 153));
        jbuttoncrear.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 12)); // NOI18N
        jbuttoncrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/agregar.png"))); // NOI18N
        jbuttoncrear.setText("Registrar");
        jbuttoncrear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbuttoncrear.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbuttoncrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttoncrearActionPerformed(evt);
            }
        });
        jPanel2.add(jbuttoncrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 430, 110, 55));

        jButton2.setBackground(new java.awt.Color(0, 153, 153));
        jButton2.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/modificar.png"))); // NOI18N
        jButton2.setText("Modificar");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 495, 110, 55));

        jButton3.setBackground(new java.awt.Color(0, 153, 153));
        jButton3.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/eliminar.png"))); // NOI18N
        jButton3.setText("Eliminar");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 575, 110, 55));

        jPanel7.setBackground(new java.awt.Color(248, 177, 57));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "FECHA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Leelawadee UI Semilight", 1, 12))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDNI8.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabelDNI8.setText("F. ENTRADA ");
        jPanel7.add(jLabelDNI8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 25, 120, 30));

        jLabelDNI11.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabelDNI11.setText("F. SALIDA");
        jPanel7.add(jLabelDNI11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 75, 120, 30));

        jDateChooser1.setBackground(new java.awt.Color(248, 177, 57));
        jDateChooser1.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jPanel7.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 75, 156, 30));

        jDateChooser2.setBackground(new java.awt.Color(248, 177, 57));
        jDateChooser2.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jPanel7.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 25, 156, 30));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 405, 336, 120));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 46, 521, 680));

        jPanel4.setBackground(new java.awt.Color(13, 39, 70));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lunandina/logoReserva.png"))); // NOI18N
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 7, -1, 40));

        lbUserActual.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 16)); // NOI18N
        lbUserActual.setForeground(new java.awt.Color(255, 255, 255));
        lbUserActual.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbUserActual.setText("jLabel13");
        jPanel4.add(lbUserActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(1145, 0, 150, 46));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/userActual.png"))); // NOI18N
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1306, 0, 30, 46));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 46));

        jPanel5.setBackground(new java.awt.Color(248, 177, 57));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(248, 177, 57));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "RESERVAS REGISTRADAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Leelawadee UI Semilight", 1, 12))); // NOI18N
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBackground(new java.awt.Color(255, 255, 204));
        jTable1.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTable1);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 724, 490));

        jLabelDNI16.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabelDNI16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDNI16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/buscar.png"))); // NOI18N
        jLabelDNI16.setText("Buscar");
        jPanel6.add(jLabelDNI16, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 40, 100, 30));

        jtxtdni9.setBackground(new java.awt.Color(255, 255, 204));
        jtxtdni9.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jtxtdni9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtdni9KeyTyped(evt);
            }
        });
        jPanel6.add(jtxtdni9, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 40, 350, 30));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 784, 620));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(521, 46, 845, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtdniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdniKeyTyped
        
    }//GEN-LAST:event_jtxtdniKeyTyped

    private void jtxtdni1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdni1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtdni1KeyTyped

    private void jtxtdni2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdni2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtdni2KeyTyped

    private void jtxtdni3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdni3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtdni3KeyTyped

    private void jtxtdni4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdni4KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtdni4KeyTyped

    private void jtxtdni5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdni5KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtdni5KeyTyped

    private void jtxtdni8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdni8KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtdni8KeyTyped

    private void jbuttoncrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttoncrearActionPerformed
     
    }//GEN-LAST:event_jbuttoncrearActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jtxtdni9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdni9KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtdni9KeyTyped

    private void jtxtdni10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdni10KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtdni10KeyTyped

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
            java.util.logging.Logger.getLogger(FrmReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmReserva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelDNI10;
    private javax.swing.JLabel jLabelDNI11;
    private javax.swing.JLabel jLabelDNI12;
    private javax.swing.JLabel jLabelDNI14;
    private javax.swing.JLabel jLabelDNI15;
    private javax.swing.JLabel jLabelDNI16;
    private javax.swing.JLabel jLabelDNI2;
    private javax.swing.JLabel jLabelDNI3;
    private javax.swing.JLabel jLabelDNI4;
    private javax.swing.JLabel jLabelDNI5;
    private javax.swing.JLabel jLabelDNI6;
    private javax.swing.JLabel jLabelDNI7;
    private javax.swing.JLabel jLabelDNI8;
    private javax.swing.JLabel jLabelDNI9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbuttoncrear;
    private javax.swing.JTextField jtxtdni;
    private javax.swing.JTextField jtxtdni1;
    private javax.swing.JTextField jtxtdni10;
    private javax.swing.JTextField jtxtdni2;
    private javax.swing.JTextField jtxtdni3;
    private javax.swing.JTextField jtxtdni4;
    private javax.swing.JTextField jtxtdni5;
    private javax.swing.JTextField jtxtdni8;
    private javax.swing.JTextField jtxtdni9;
    private javax.swing.JLabel lbUserActual;
    // End of variables declaration//GEN-END:variables
}
