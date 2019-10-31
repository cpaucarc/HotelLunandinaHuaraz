package Ventanas;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import Clases.Control;

public class Reportes extends javax.swing.JFrame {

    Facturas factura=new Facturas();
    Boletas boleta=new Boletas();
    
    
    public Reportes() {
        initComponents();
        this.setExtendedState(6);
        lbUserActual.setText(Control.usuario);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbUserActual = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pnComprobante = new javax.swing.JPanel();
        pnBoleta = new javax.swing.JPanel();
        lbBoleta = new javax.swing.JLabel();
        pnFactura = new javax.swing.JPanel();
        lbFactura = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        pnAnual = new javax.swing.JPanel();
        lbAnual = new javax.swing.JLabel();
        pnMensual = new javax.swing.JPanel();
        lbMensual = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        desktop = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(13, 39, 70));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lunandina/logoReportes.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 7, -1, 40));

        lbUserActual.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 16)); // NOI18N
        lbUserActual.setForeground(new java.awt.Color(255, 255, 255));
        lbUserActual.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbUserActual.setText("jLabel13");
        jPanel1.add(lbUserActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(1145, 0, 150, 46));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/userActual.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1306, 0, 30, 46));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 46));

        jPanel2.setBackground(new java.awt.Color(248, 177, 57));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnComprobante.setBackground(new java.awt.Color(248, 177, 57));
        pnComprobante.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(23, 23, 23)), "COMPROBANTES DE VENTA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Leelawadee UI Semilight", 1, 12))); // NOI18N
        pnComprobante.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnBoleta.setBackground(new java.awt.Color(248, 177, 57));
        pnBoleta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(23, 23, 23)));
        pnBoleta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbBoleta.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbBoleta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBoleta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/boleta.png"))); // NOI18N
        lbBoleta.setText("BOLETA DE VENTA");
        lbBoleta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbBoleta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbBoleta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbBoleta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBoletaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbBoletaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbBoletaMouseExited(evt);
            }
        });
        pnBoleta.add(lbBoleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 100));

        pnComprobante.add(pnBoleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 50, 150, 100));

        pnFactura.setBackground(new java.awt.Color(248, 177, 57));
        pnFactura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(23, 23, 23)));
        pnFactura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbFactura.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbFactura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/factura.png"))); // NOI18N
        lbFactura.setText("FACTURA");
        lbFactura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbFactura.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbFactura.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbFacturaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbFacturaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbFacturaMouseExited(evt);
            }
        });
        pnFactura.add(lbFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 100));

        pnComprobante.add(pnFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 150, 100));

        jPanel2.add(pnComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 75, 460, 200));

        jPanel4.setBackground(new java.awt.Color(248, 177, 57));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(23, 23, 23)), "INGRESOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Leelawadee UI Semilight", 1, 12))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnAnual.setBackground(new java.awt.Color(248, 177, 57));
        pnAnual.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(23, 23, 23)));
        pnAnual.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbAnual.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 12)); // NOI18N
        lbAnual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAnual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/dineroAnual.png"))); // NOI18N
        lbAnual.setText("INGRESOS ANUALES");
        lbAnual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbAnual.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbAnual.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbAnual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAnualMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbAnualMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbAnualMouseExited(evt);
            }
        });
        pnAnual.add(lbAnual, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 100));

        jPanel4.add(pnAnual, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 50, 150, 100));

        pnMensual.setBackground(new java.awt.Color(248, 177, 57));
        pnMensual.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(23, 23, 23)));
        pnMensual.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbMensual.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 12)); // NOI18N
        lbMensual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMensual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/dineroMensual.png"))); // NOI18N
        lbMensual.setText("INGRESOS MENSUALES");
        lbMensual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbMensual.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbMensual.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbMensual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMensualMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbMensualMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbMensualMouseExited(evt);
            }
        });
        pnMensual.add(lbMensual, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 100));

        jPanel4.add(pnMensual, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 150, 100));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 460, 200));

        jLabel1.setText("Referencia");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(844, 46, 522, 674));
        getContentPane().add(desktop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 46, 844, 674));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* FACTURA */
    private void lbFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFacturaMouseClicked
        desktop.removeAll();
        desktop.repaint();
        desktop.add(factura);
        factura.setSize(844,674);
        factura.show();
        
        //BasicInternalFrameUI bi = (BasicInternalFrameUI)facturas.getUI();
        //bi.setNorthPane(null);
        
        //BasicInternalFrameTitlePane titlePane = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) facturas.getUI()).getNorthPane();
        //facturas.remove(titlePane);
    }//GEN-LAST:event_lbFacturaMouseClicked
    private void lbFacturaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFacturaMouseEntered
        pnFactura.setBackground(new java.awt.Color(255,193,7));
    }//GEN-LAST:event_lbFacturaMouseEntered
    private void lbFacturaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFacturaMouseExited
        pnFactura.setBackground(new java.awt.Color(248, 177, 57));
    }//GEN-LAST:event_lbFacturaMouseExited

    /* BOLETA DE VENTA */
    private void lbBoletaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBoletaMouseClicked
        desktop.removeAll();
        desktop.repaint();
        desktop.add(boleta);
        boleta.setSize(844,674);
        boleta.show();
    }//GEN-LAST:event_lbBoletaMouseClicked
    private void lbBoletaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBoletaMouseEntered
        pnBoleta.setBackground(new java.awt.Color(255,193,7));
    }//GEN-LAST:event_lbBoletaMouseEntered
    private void lbBoletaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBoletaMouseExited
        pnBoleta.setBackground(new java.awt.Color(248, 177, 57));
    }//GEN-LAST:event_lbBoletaMouseExited

    /* INGRESOS MENSUALES */
    private void lbMensualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMensualMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbMensualMouseClicked
    private void lbMensualMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMensualMouseEntered
        pnMensual.setBackground(new java.awt.Color(255,193,7));
    }//GEN-LAST:event_lbMensualMouseEntered
    private void lbMensualMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMensualMouseExited
        pnMensual.setBackground(new java.awt.Color(248, 177, 57));
    }//GEN-LAST:event_lbMensualMouseExited

    /* INGRESOS ANUALES */
    private void lbAnualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAnualMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbAnualMouseClicked
    private void lbAnualMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAnualMouseEntered
        pnAnual.setBackground(new java.awt.Color(255,193,7));
    }//GEN-LAST:event_lbAnualMouseEntered
    private void lbAnualMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAnualMouseExited
        pnAnual.setBackground(new java.awt.Color(248, 177, 57));
    }//GEN-LAST:event_lbAnualMouseExited

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
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbAnual;
    private javax.swing.JLabel lbBoleta;
    private javax.swing.JLabel lbFactura;
    private javax.swing.JLabel lbMensual;
    private javax.swing.JLabel lbUserActual;
    private javax.swing.JPanel pnAnual;
    private javax.swing.JPanel pnBoleta;
    private javax.swing.JPanel pnComprobante;
    private javax.swing.JPanel pnFactura;
    private javax.swing.JPanel pnMensual;
    // End of variables declaration//GEN-END:variables
}
