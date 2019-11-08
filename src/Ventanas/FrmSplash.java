package Ventanas;

import Clases.Design;
import javax.swing.ImageIcon;
import javax.swing.UIManager;  
import java.awt.*;

/**
 *
 * @author Grupo
 */
public class FrmSplash extends javax.swing.JFrame implements Runnable {

    int num = 0;
    Thread hilo;
    Design design = new Design();

    public FrmSplash() {
        initComponents();
        //design.MoverFrame(jPanel1, this);
        this.setLocationRelativeTo(null);
        JProBarCargar.setStringPainted(true);
        JProBarCargar.setForeground(Color.BLACK);//color de la letra 10%
//        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
//        this.setSize((int) d.getWidth(), (int) d.getHeight());
//        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/Hotel.jpg")).getImage());
        hilo = new Thread(this);
        hilo.start();
        //this.setUndecorated(true);//para quitar el borde de la ventana

    }

    private void Llena_Barra() {
        num += 7;
        //Le podemos dar un valor mas alto para que se llene mas rapido o un valor mas bajo
        //para que se llene mas lento
        JProBarCargar.setValue(num);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMain = new javax.swing.JPanel();
        JProBarCargar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnMain.setBackground(new java.awt.Color(13, 39, 70));
        pnMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(13, 39, 70), 2));
        pnMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JProBarCargar.setBackground(new java.awt.Color(255, 255, 255));
        JProBarCargar.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        pnMain.add(JProBarCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 430, 30));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lunandina/logoOriginal.png"))); // NOI18N
        pnMain.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 450, 130));

        getContentPane().add(pnMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FrmSplash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSplash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSplash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSplash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSplash().setVisible(true);                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar JProBarCargar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnMain;
    // End of variables declaration//GEN-END:variables

    
    @Override
    public void run() {
        try {
            while (num <= 100) {
                Thread.sleep(100);
                Llena_Barra();
            }
            this.dispose();
            new LoginAcceso().setVisible(true);
            hilo.stop();
        } catch (Exception ex) {
        }
    }
}
