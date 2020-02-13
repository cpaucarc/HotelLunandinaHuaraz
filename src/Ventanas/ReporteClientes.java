
package Ventanas;

public class ReporteClientes extends javax.swing.JInternalFrame {

    public ReporteClientes() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gDinero = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txLugar = new javax.swing.JTextField();
        txCliente = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        lbNameCliente = new javax.swing.JLabel();

        setBorder(null);
        setClosable(true);
        setTitle("Clientes");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "PANEL DE BUSQUEDA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/nombre.png"))); // NOI18N
        jLabel1.setText("Cliente");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 120, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/procedencia.png"))); // NOI18N
        jLabel4.setText("Procedencia");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 120, 30));

        txLugar.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txLugar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txLugar.setSelectionColor(new java.awt.Color(0, 122, 255));
        txLugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txLugarActionPerformed(evt);
            }
        });
        jPanel2.add(txLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 200, 30));

        txCliente.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txCliente.setSelectionColor(new java.awt.Color(0, 122, 255));
        txCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txClienteActionPerformed(evt);
            }
        });
        jPanel2.add(txCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 200, 30));

        jButton1.setBackground(new java.awt.Color(111, 168, 183));
        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/pdf.png"))); // NOI18N
        jButton1.setText("Imprimir");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 90, 150, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 784, 170));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "INGRESOS REGISTRADOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setAutoCreateRowSorter(true);
        tabla.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"22-01-2018", "[Nombre de cliente aqui]", "Casma", "200.00", "victor"},
                {"23-05-2018", "[Nombre de cliente aqui]", "Casma", "225.50", "victor"},
                {"04-07-2018", "[Nombre de cliente aqui]", "Casma", "185.00", "victor"},
                {"27-07-2018", "[Nombre de cliente aqui]", "Casma", "100.00", "victor"},
                {"24-10-2018", "[Nombre de cliente aqui]", "Casma", "130.00", "victor"}
            },
            new String [] {
                "Fecha", "Cliente", "Procedencia", "Monto Total", "Usuario"
            }
        ));
        tabla.setEnabled(false);
        tabla.setRowHeight(25);
        tabla.setSelectionBackground(new java.awt.Color(0, 122, 255));
        jScrollPane1.setViewportView(tabla);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 724, 310));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel6.setText("Total  S/.");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 70, 30));

        lbTotal.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lbTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 150, 30));

        lbNameCliente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbNameCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNameCliente.setText("[Nombre de cliente aqui]");
        jPanel3.add(lbNameCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 10, 220, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 784, 395));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 844, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txLugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txLugarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txLugarActionPerformed

    private void txClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txClienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup gDinero;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbNameCliente;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txCliente;
    private javax.swing.JTextField txLugar;
    // End of variables declaration//GEN-END:variables
}
