
package Ventanas;

import Clases.Controlador;
import Clases.Design;
import Clases.Imprimir;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ReporteServicios extends javax.swing.JInternalFrame {

    Imprimir imp=new Imprimir();
    DefaultTableModel modelo=new DefaultTableModel();
    Design ds=new Design();
    Controlador control=new Controlador();
    
    String __servicio = "";
    
    public ReporteServicios() {
        initComponents();
        //control.LlenarCombo(cbServicio, "select nombreServ from tiposervicio", 1);
        cbMonth.setSelectedIndex(Integer.parseInt(control.DevolverRegistroDto("select (month(curdate())-1)", 1)));
        cbYear.setValue(Integer.parseInt(control.DevolverRegistroDto("select year(curdate())", 1)));        
        LlenarTabla();
        SetService();
    }
    public void LlenarTabla(){
        modelo.setColumnIdentifiers(new String[]{"Fecha","Servicio","Cantidad", "Monto Total", "Cliente"});
        tabla.setModel(modelo);
        
        if(cbServicio.getSelectedIndex()>0){
            __servicio = cbServicio.getSelectedItem().toString();
        }else{
            __servicio = "";
        }
        
        String _condicion = " and descripcion like '%"+__servicio+"%' and "
                + "cliente like '%"+txCliente.getText()+"%' and month(fechaEmision) =  "+(cbMonth.getSelectedIndex()+1)
                +" and year(fechaEmision) = "+cbYear.getValue();
        
        control.LlenarJtable(modelo, "select fechaEmision,descripcion,cantidad,total,cliente from vw_boleta_factura where descripcion not like '% ' "+_condicion+" order by descripcion desc", 5);
        //730
        tabla.getColumnModel().getColumn(0).setPreferredWidth(85); //Fecha
        tabla.getColumnModel().getColumn(1).setPreferredWidth(215);//Servicio
        tabla.getColumnModel().getColumn(2).setPreferredWidth(70); //Cant
        tabla.getColumnModel().getColumn(3).setPreferredWidth(90);//Total
        tabla.getColumnModel().getColumn(4).setPreferredWidth(270);//Cliente
        
        lbTotal.setText(ds.SumarColumna(tabla, 3));
    }
    public void SetService(){
        lbService.setText(cbServicio.getSelectedItem().toString() 
                + "  ["+cbMonth.getSelectedItem().toString()+" - "+cbYear.getValue()+"]");
    }
    //;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gDinero = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbMonth = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txCliente = new javax.swing.JTextField();
        cbYear = new com.toedter.calendar.JYearChooser();
        cbServicio = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        lbService = new javax.swing.JLabel();

        setBorder(null);
        setClosable(true);
        setTitle("Servicios prestados");
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
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/servicio_32.png"))); // NOI18N
        jLabel4.setText("Servicio");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 40, 100, 30));

        cbMonth.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 15)); // NOI18N
        cbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        cbMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMonthItemStateChanged(evt);
            }
        });
        jPanel2.add(cbMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 130, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/calendario.png"))); // NOI18N
        jLabel5.setText("Mes");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 80, 30));

        txCliente.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
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
        });
        jPanel2.add(txCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 200, 30));

        cbYear.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 15)); // NOI18N
        cbYear.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbYearPropertyChange(evt);
            }
        });
        jPanel2.add(cbYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 80, 30));

        cbServicio.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        cbServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos los Servicios", "Desayuno", "Lavanderia", "Boleto Turistico" }));
        cbServicio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbServicioItemStateChanged(evt);
            }
        });
        jPanel2.add(cbServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 40, 200, 30));

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

        tabla.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"22-10-2018", "Desayuno", "1", "[Nombre de cliente aqui]", "10.00", "victor"},
                {"23-10-2018", "Desayuno", "2", "[Nombre de cliente aqui]", "20.00", "victor"},
                {"23-10-2018", "Desayuno", "1", "[Nombre de cliente aqui]", "10.00", "victor"},
                {"23-10-2018", "Desayuno", "1", "[Nombre de cliente aqui]", "10.00", "victor"},
                {"24-10-2018", "Desayuno", "3", "[Nombre de cliente aqui]", "30.00", "victor"}
            },
            new String [] {
                "Fecha", "Servicio", "Cantidad", "Cliente", "Monto Total", "Usuario"
            }
        ));
        tabla.setEnabled(false);
        tabla.setRowHeight(25);
        tabla.setSelectionBackground(new java.awt.Color(0, 122, 255));
        jScrollPane1.setViewportView(tabla);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 40, 730, 310));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel6.setText("Total  S/.");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 70, 30));

        lbTotal.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTotal.setText("80");
        lbTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lbTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 150, 30));

        lbService.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbService.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbService.setText("Desayuno");
        jPanel3.add(lbService, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 384, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 784, 395));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 844, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txClienteActionPerformed
    }//GEN-LAST:event_txClienteActionPerformed
    private void txClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txClienteKeyReleased
        LlenarTabla();
    }//GEN-LAST:event_txClienteKeyReleased
    private void cbServicioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbServicioItemStateChanged
        LlenarTabla();
        SetService();
    }//GEN-LAST:event_cbServicioItemStateChanged
    private void cbMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMonthItemStateChanged
        LlenarTabla();
        SetService();
    }//GEN-LAST:event_cbMonthItemStateChanged
    private void cbYearPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbYearPropertyChange
        LlenarTabla();
        SetService();
    }//GEN-LAST:event_cbYearPropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(tabla.getRowCount()>0){
            String _month = ""+(cbMonth.getSelectedIndex()+1);
            String _monthName = cbMonth.getSelectedItem().toString().toUpperCase();
            String _year = ""+cbYear.getValue();
            if(__servicio.equals("")){//Todos los servicios
                imp.Imp3P("Reporte de servicios", "servicioT", "_month", _month, "_year", _year, "_monthName", _monthName);
            }else{ // Servicio en especifico
                imp.Imp4P("Reporte de servicio "+__servicio, "servicioE", "_month", "_year", "_service", "_monthName", _month, _year, __servicio.toUpperCase(), _monthName);
            }
        }else{
            JOptionPane.showMessageDialog(null, "No existen registros para este criterio de busqueda");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbMonth;
    private javax.swing.JComboBox<String> cbServicio;
    private com.toedter.calendar.JYearChooser cbYear;
    private javax.swing.ButtonGroup gDinero;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbService;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txCliente;
    // End of variables declaration//GEN-END:variables
}
