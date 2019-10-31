package Ventanas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Habitaciones extends javax.swing.JFrame {

    /* ESTADO POSIBLES DE LAS HABITACIONES */
    public static String Disponible = "Disponible";
    public static String Ocupado = "Ocupado";
    public static String Reservado = "Reservado";
    public static String Mantenimiento = "Mantenimiento";

    //Solo para pruebas, se cambiara con DB -- Demuestra el estado de cada habitacion
    public static String[] EstadoHab = {Disponible, Disponible, Ocupado, Mantenimiento, Reservado, Mantenimiento, Ocupado, Reservado,
        Ocupado, Mantenimiento, Reservado, Disponible, Disponible, Ocupado, Mantenimiento, Reservado};

    /* COLORES PARA FONDO DE PANEL DE HABITACION, NORMAL*/
    public static Color Disp = new Color(40, 167, 69);
    public static Color Ocup = new Color(220, 53, 69);
    public static Color Resev = new Color(255, 193, 7);
    public static Color Mant = new Color(23, 162, 184);

    /* COLORES PARA FONDO DE PANEL DE HABITACION, HOVER*/
    public static Color hover_Disp = new Color(136, 206, 82);
    public static Color hover_Ocup = new Color(234, 82, 62);
    public static Color hover_Resev = new Color(255, 185, 83);
    public static Color hover_Mant = new Color(111, 168, 183);

    /* ARRAY PARA ALMACENAR LOS PANELES QUE REPRESENTA A CADA HABITACION */
    public static JPanel[] panel_Hab = new JPanel[16];
    /* ARRAY PARA ALMACENAR LOS LABELS QUE REPRESENTA A CADA HABITACION */
    public static JLabel[] label_Hab = new JLabel[16];

    public Habitaciones() {
        initComponents();
        this.setExtendedState(6);
        AddPaneles(); //añadimos los paneles a los pnPiso1 y pnPiso2, segun corresponda
        AddColorPaneles(); //Asignamos el color segun el estado de la habitacion
        AddLabelInPanel(); //Añadimos label con numeor de habitacion a paneles
        //ClickLbhabitacion();        
    }

    public void AddPaneles() {
        for (int i = 0; i < 16; i++) {
            panel_Hab[i] = new JPanel();  //Inicializamos los paneles

            int k = i;

            if (i >= 4 && i < 8){ //Piso 1 y fila 2            
                k = i - 4;
            }else if (i >= 8 && i < 12){//Piso 2 y fila 1            
                k = i - 8;
            }else if (i >= 12 && i < 16){//Piso 2 y fila 2            
                k = i - 12;
            }

            if(i<4 || (i<12 && i>=8)){
                panel_Hab[i].setBounds((292 * k + 132), 40, 160, 90);
            }else if(i>=12 || (i<8 && i>=4)){
                panel_Hab[i].setBounds((292 * k + 132), 170, 160, 90);
            }
            
            if (i < 8){
                pnPiso1.add(panel_Hab[i]);
            } else {
                pnPiso2.add(panel_Hab[i]);
            }
        }
    }
    public void AddColorPaneles(){
        for (int i = 0; i < 16; i++) {
            switch (EstadoHab[i]) {
                case "Disponible":
                    panel_Hab[i].setBackground(Disp);
                    break;
                case "Ocupado":
                    panel_Hab[i].setBackground(Ocup);
                    break;
                case "Reservado":
                    panel_Hab[i].setBackground(Resev);
                    break;
                case "Mantenimiento":
                    panel_Hab[i].setBackground(Mant);
                    break;
                default:
                    panel_Hab[i].setBackground(Color.white);
                    break;
            }
        }
    }
    public void AddLabelInPanel(){
        for (int i=0; i<16; i++){
            label_Hab[i] = new JLabel();
            if(i<8){
                label_Hab[i].setText("10"+i);
            }else{
                label_Hab[i].setText("20"+(i-8));
            }
            label_Hab[i].setBounds(0,0,160,90);
            label_Hab[i].setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 18));
            label_Hab[i].setCursor(new Cursor(HAND_CURSOR));
            label_Hab[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            label_Hab[i].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
            panel_Hab[i].add(label_Hab[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 90));
        }        
    }
    public void ClickInHab(){
        for (int i = 0; i<16; i++){
            label_Hab[i].addMouseListener(new MouseListener() {
                @Override public void mouseClicked(MouseEvent e) {
                    
                    //lbNumHab.setText(label_Hab[i].getText());
                }
                @Override public void mousePressed(MouseEvent e) {}
                @Override public void mouseReleased(MouseEvent e) {}
                @Override public void mouseEntered(MouseEvent e) {
                    
                }
                @Override public void mouseExited(MouseEvent e) {
                    
                }
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnPiso1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pnPiso2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnInfo = new javax.swing.JPanel();
        pnDatosHab = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbPrecioHab = new javax.swing.JLabel();
        lbNumHab = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbTipoHab = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pnCliente = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lbEMail = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbDNI = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbApellidos = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbNombres = new javax.swing.JLabel();
        lbProcedencia = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pnServicios = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaServicios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnTitulo.setBackground(new java.awt.Color(13, 39, 70));
        pnTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lunandina/logoHabitaciones.png"))); // NOI18N
        pnTitulo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 7, -1, 40));

        getContentPane().add(pnTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, -1));

        jTabbedPane1.setBackground(new java.awt.Color(13, 39, 70));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N

        pnPiso1.setBackground(new java.awt.Color(23, 23, 23));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lunandina/nivel1.png"))); // NOI18N

        javax.swing.GroupLayout pnPiso1Layout = new javax.swing.GroupLayout(pnPiso1);
        pnPiso1.setLayout(pnPiso1Layout);
        pnPiso1Layout.setHorizontalGroup(
            pnPiso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPiso1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnPiso1Layout.setVerticalGroup(
            pnPiso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPiso1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("<html><center>N<br>I<br>V<br>E<br>L<br><b>1<b><br></center></html>", pnPiso1);

        pnPiso2.setBackground(new java.awt.Color(23, 23, 23));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lunandina/nivel2.png"))); // NOI18N

        javax.swing.GroupLayout pnPiso2Layout = new javax.swing.GroupLayout(pnPiso2);
        pnPiso2.setLayout(pnPiso2Layout);
        pnPiso2Layout.setHorizontalGroup(
            pnPiso2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPiso2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnPiso2Layout.setVerticalGroup(
            pnPiso2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPiso2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("<html><center>N<br>I<br>V<br>E<br>L<br><br><b>2<b><br></center></html>", pnPiso2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 46, 1366, 300));
        jTabbedPane1.getAccessibleContext().setAccessibleName("<html><center>I<br>N<br>I<br>C<br>I<br>O</center></html>");

        pnInfo.setBackground(new java.awt.Color(23, 23, 23));
        pnInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnDatosHab.setBackground(new java.awt.Color(23, 23, 23));
        pnDatosHab.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 177, 57)), "DATOS DE LA HABITACIÓN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Leelawadee UI Semilight", 1, 12), new java.awt.Color(248, 177, 57))); // NOI18N
        pnDatosHab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PRECIO");
        pnDatosHab.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 110, 30));

        lbPrecioHab.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbPrecioHab.setForeground(new java.awt.Color(255, 255, 255));
        lbPrecioHab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnDatosHab.add(lbPrecioHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 200, 30));

        lbNumHab.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbNumHab.setForeground(new java.awt.Color(255, 255, 255));
        lbNumHab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnDatosHab.add(lbNumHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 200, 30));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("N° HABITACION ");
        pnDatosHab.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 110, 30));

        lbTipoHab.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbTipoHab.setForeground(new java.awt.Color(255, 255, 255));
        lbTipoHab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnDatosHab.add(lbTipoHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 200, 30));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TIPO");
        pnDatosHab.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 110, 30));

        pnInfo.add(pnDatosHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 380, 330));

        pnCliente.setBackground(new java.awt.Color(23, 23, 23));
        pnCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 177, 57)), "DATOS DEL CLIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Leelawadee UI Semilight", 1, 12), new java.awt.Color(248, 177, 57))); // NOI18N
        pnCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("NOMBRES");
        pnCliente.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 100, 30));

        lbEMail.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbEMail.setForeground(new java.awt.Color(255, 255, 255));
        lbEMail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnCliente.add(lbEMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 250, 30));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("DNI");
        pnCliente.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 100, 30));

        lbDNI.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbDNI.setForeground(new java.awt.Color(255, 255, 255));
        lbDNI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnCliente.add(lbDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 250, 30));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("APELLIDOS");
        pnCliente.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 95, 100, 30));

        lbApellidos.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbApellidos.setForeground(new java.awt.Color(255, 255, 255));
        lbApellidos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnCliente.add(lbApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 95, 250, 30));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("E-MAIL");
        pnCliente.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 100, 30));

        lbNombres.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbNombres.setForeground(new java.awt.Color(255, 255, 255));
        lbNombres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnCliente.add(lbNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 250, 30));

        lbProcedencia.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbProcedencia.setForeground(new java.awt.Color(255, 255, 255));
        lbProcedencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnCliente.add(lbProcedencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 205, 250, 30));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("PROCEDENCIA");
        pnCliente.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 205, 100, 30));

        pnInfo.add(pnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 430, 330));

        pnServicios.setBackground(new java.awt.Color(23, 23, 23));
        pnServicios.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 177, 57)), "SERVICIOS RECIBIDOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Leelawadee UI Semilight", 1, 12), new java.awt.Color(248, 177, 57))); // NOI18N
        pnServicios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaServicios.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        tablaServicios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaServicios);

        pnServicios.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 326, 270));

        pnInfo.add(pnServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, 386, 330));

        getContentPane().add(pnInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 346, 1366, 380));

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
            java.util.logging.Logger.getLogger(Habitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Habitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Habitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Habitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Habitaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbApellidos;
    private javax.swing.JLabel lbDNI;
    private javax.swing.JLabel lbEMail;
    private javax.swing.JLabel lbNombres;
    private javax.swing.JLabel lbNumHab;
    private javax.swing.JLabel lbPrecioHab;
    private javax.swing.JLabel lbProcedencia;
    private javax.swing.JLabel lbTipoHab;
    private javax.swing.JPanel pnCliente;
    private javax.swing.JPanel pnDatosHab;
    private javax.swing.JPanel pnInfo;
    private javax.swing.JPanel pnPiso1;
    private javax.swing.JPanel pnPiso2;
    private javax.swing.JPanel pnServicios;
    private javax.swing.JPanel pnTitulo;
    private javax.swing.JTable tablaServicios;
    // End of variables declaration//GEN-END:variables

}
