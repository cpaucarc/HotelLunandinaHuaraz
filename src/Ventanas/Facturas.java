
package Ventanas;

import Clases.Controlador;
import Clases.Imprimir;
import Clases.Textos;
import javax.swing.table.DefaultTableModel;

public final class Facturas extends javax.swing.JInternalFrame {
    
    DefaultTableModel modelo=new DefaultTableModel();
    Imprimir imp=new Imprimir();
    Controlador control=new Controlador();
    String _numFac;
    String _montoTotal;
    boolean rowSelect = false;
    
    public Facturas() {
        initComponents();
        LlenarTabla();
        ActivarBoton();
    }
    public void ActivarBoton(){
        btImprimirFactura.setEnabled(rowSelect);
    }
    public void LlenarTabla(){
        modelo.setColumnIdentifiers(new String[]{"N° Factura", "Fecha", "Monto Total", "Cliente", "Procedencia"});
        tabla.setModel(modelo);
        
        String _condicion = " where numFactura like '%"+txNumFactura.getText()
                +"%' and  cliente like '%"+txCliente.getText()+"%' and lugar like '%"+txProc.getText()+"%' ";
        
        control.LlenarJtable(modelo, "select numFactura,fechaEmision,sum(total),cliente,lugar from vw_factura "+_condicion+" group by numFactura", 5);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(85);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(85);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(329);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(125);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gDinero = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txCliente = new javax.swing.JTextField();
        txNumFactura = new javax.swing.JTextField();
        txFecha = new com.toedter.calendar.JDateChooser();
        txProc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btImprimirFactura = new javax.swing.JButton();

        setBorder(null);
        setClosable(true);
        setTitle("Facturas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "PANEL DE BUSQUEDA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/nombre.png"))); // NOI18N
        jLabel1.setText("Cliente");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 45, 120, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/numero.png"))); // NOI18N
        jLabel3.setText("N° Factura");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 45, 120, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/calendario.png"))); // NOI18N
        jLabel4.setText("Fecha");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 105, 120, 30));

        txCliente.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 15)); // NOI18N
        txCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txCliente.setSelectionColor(new java.awt.Color(0, 122, 255));
        txCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txClienteActionPerformed(evt);
            }
        });
        txCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txClienteKeyTyped(evt);
            }
        });
        jPanel2.add(txCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 45, 200, 30));

        txNumFactura.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 15)); // NOI18N
        txNumFactura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txNumFactura.setSelectionColor(new java.awt.Color(0, 122, 255));
        txNumFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txNumFacturaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txNumFacturaKeyTyped(evt);
            }
        });
        jPanel2.add(txNumFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 45, 200, 30));

        txFecha.setBackground(new java.awt.Color(255, 255, 255));
        txFecha.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 15)); // NOI18N
        jPanel2.add(txFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 105, 200, 30));

        txProc.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 15)); // NOI18N
        txProc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txProc.setSelectionColor(new java.awt.Color(0, 122, 255));
        txProc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txProcKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txProcKeyTyped(evt);
            }
        });
        jPanel2.add(txProc, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 105, 200, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/procedencia.png"))); // NOI18N
        jLabel5.setText("Procedencia");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 105, 120, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 784, 180));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "FACTURAS REGISTRADAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setAutoCreateRowSorter(true);
        tabla.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "N° Factura", "Fecha", "Monto Total", "Cliente", "Procedencia", "Usuario"
            }
        ));
        tabla.setRowHeight(25);
        tabla.setSelectionBackground(new java.awt.Color(0, 122, 255));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 724, 280));

        btImprimirFactura.setBackground(new java.awt.Color(111, 168, 183));
        btImprimirFactura.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btImprimirFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/pdf.png"))); // NOI18N
        btImprimirFactura.setText("Imprimir");
        btImprimirFactura.setBorder(null);
        btImprimirFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirFacturaActionPerformed(evt);
            }
        });
        jPanel3.add(btImprimirFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(604, 320, 150, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 784, 385));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 844, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txClienteActionPerformed

    private void btImprimirFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirFacturaActionPerformed
        if(_numFac != null){
            //imp.ImprCon1Parametro("factura", "Factura N° " + _numFac, "numeroFactura", _numFac);
            imp.Imp2P("factura", "Factura N° "+_numFac, "numeroFactura", "montoLiteral", _numFac, Textos.montoLiteral(_montoTotal));
        }
        rowSelect = false; ActivarBoton();
    }//GEN-LAST:event_btImprimirFacturaActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        _numFac = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
        _montoTotal = tabla.getValueAt(tabla.getSelectedRow(), 2).toString();        
        rowSelect = true; ActivarBoton();
    }//GEN-LAST:event_tablaMouseClicked

    private void txClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txClienteKeyTyped
    }//GEN-LAST:event_txClienteKeyTyped
    private void txNumFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNumFacturaKeyTyped
    }//GEN-LAST:event_txNumFacturaKeyTyped
    private void txProcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txProcKeyTyped
    }//GEN-LAST:event_txProcKeyTyped

    private void txClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txClienteKeyReleased
        LlenarTabla();
    }//GEN-LAST:event_txClienteKeyReleased
    private void txNumFacturaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNumFacturaKeyReleased
        LlenarTabla();
    }//GEN-LAST:event_txNumFacturaKeyReleased
    private void txProcKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txProcKeyReleased
        LlenarTabla();
    }//GEN-LAST:event_txProcKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btImprimirFactura;
    private javax.swing.ButtonGroup gDinero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txCliente;
    private com.toedter.calendar.JDateChooser txFecha;
    private javax.swing.JTextField txNumFactura;
    private javax.swing.JTextField txProc;
    // End of variables declaration//GEN-END:variables
}
