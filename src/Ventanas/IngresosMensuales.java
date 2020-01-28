
package Ventanas;

import Clases.Controlador;
import Clases.Design;
import Clases.Imprimir;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class IngresosMensuales extends javax.swing.JInternalFrame {

    Imprimir imp=new Imprimir();
    Controlador control=new Controlador();
    Design ds=new Design();
    DefaultTableModel modelo=new DefaultTableModel();
    
    public IngresosMensuales() {
        initComponents();
        cbMonth.setSelectedIndex(Integer.parseInt(control.DevolverRegistroDto("select (month(curdate())-1)", 1)));
        cbYear.setValue(Integer.parseInt(control.DevolverRegistroDto("select year(curdate())", 1)));
        LlenarTabla();
        ds.Centrar_Tabla(tabla);
    }
    
    public void LlenarTabla(){       
        
        modelo.setColumnIdentifiers(new String[]{"Fecha", "Monto Total", "Cliente", "Procedencia"});
        tabla.setModel(modelo);
        
        String _sql1 = "select fechaEmision,sum(totalServ),cliente,lugar from ";
        String _sql2 = "where month(fechaEmision) = "+(cbMonth.getSelectedIndex()+1)+" and year(fechaEmision) = "+cbYear.getValue();
        String sql = _sql1 +"vw_boleta "+_sql2+"  group by numBoleta union "+_sql1+"vw_factura "+_sql2+" group by numFactura  order by fechaEmision";
        control.LlenarJtable(modelo, sql, 4);
        
        //Tamaño de tabla: Ancho(724)
        tabla.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(374);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(150);
        
        lbTotal.setText(ds.SumarColumna(tabla, 1));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gDinero = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cbMonth = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbYear = new com.toedter.calendar.JYearChooser();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        lbDate = new javax.swing.JLabel();

        setBorder(null);
        setClosable(true);
        setTitle("Ingresos Mensuales");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "PANEL DE BUSQUEDA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbMonth.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 15)); // NOI18N
        cbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        cbMonth.setSelectedIndex(9);
        cbMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMonthItemStateChanged(evt);
            }
        });
        jPanel2.add(cbMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 45, 120, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/calendario.png"))); // NOI18N
        jLabel5.setText("Mes -  Año");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 45, 110, 30));

        cbYear.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 15)); // NOI18N
        cbYear.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbYearPropertyChange(evt);
            }
        });
        jPanel2.add(cbYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 45, 80, 30));

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
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 45, 150, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 784, 130));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "INGRESOS REGISTRADOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"22-10-2018", "200.00", "[Nombre de cliente aqui]", "Huaraz", "victor"},
                {"23-10-2018", "225.50", "[Nombre de cliente aqui]", "Casma", "victor"},
                {"23-10-2018", "185.00", "[Nombre de cliente aqui]", "Lima", "victor"},
                {"23-10-2018", "100.00", "[Nombre de cliente aqui]", "Huaraz", "victor"},
                {"24-10-2018", "130.00", "[Nombre de cliente aqui]", "Lima", "victor"}
            },
            new String [] {
                "Fecha", "Monto Total", "Cliente", "Procedencia", "Usuario"
            }
        ));
        tabla.setEnabled(false);
        tabla.setRowHeight(25);
        tabla.setSelectionBackground(new java.awt.Color(0, 122, 255));
        jScrollPane1.setViewportView(tabla);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 724, 340));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Total  S/.");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 395, 90, 30));

        lbTotal.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lbTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 395, 100, 30));

        lbDate.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDate.setText("Octubre - 2019");
        jPanel3.add(lbDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 10, 150, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 784, 435));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 844, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMonthItemStateChanged
        lbDate.setText(cbMonth.getSelectedItem().toString() + " - " + cbYear.getValue());
        LlenarTabla();
    }//GEN-LAST:event_cbMonthItemStateChanged
    private void cbYearPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbYearPropertyChange
        lbDate.setText(cbMonth.getSelectedItem().toString() + " - " + cbYear.getValue());
        LlenarTabla();
    }//GEN-LAST:event_cbYearPropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String _nameMonth = cbMonth.getSelectedItem().toString().toUpperCase();
        String _month = ""+(cbMonth.getSelectedIndex()+1);
        String _year = ""+cbYear.getValue();
        if(tabla.getRowCount() > 0){
            imp.Imp3P("Reporte de "+_nameMonth, "ingresosMensuales", "_mes", _month, "_year", _year, "_mesNombre", _nameMonth);
        }else{
            JOptionPane.showMessageDialog(null, "No existen datos que mostrar en este periodo");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbMonth;
    private com.toedter.calendar.JYearChooser cbYear;
    private javax.swing.ButtonGroup gDinero;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
