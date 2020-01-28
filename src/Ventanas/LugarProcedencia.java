
package Ventanas;

import Clases.Controlador;
import Clases.Design;
import Clases.Imprimir;
import alertas.AlertaError;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class LugarProcedencia extends javax.swing.JInternalFrame {

    Imprimir imp=new Imprimir();
    Controlador control=new Controlador();
    Design ds=new Design();
    DefaultTableModel modelo=new DefaultTableModel();
    
    public LugarProcedencia() {
        initComponents();
        cbMonth.setSelectedIndex(Integer.parseInt(control.DevolverRegistroDto("select (month(curdate()))", 1)));
        cbYear.setValue(Integer.parseInt(control.DevolverRegistroDto("select year(curdate())", 1)));
        SetPlace();
        LlenarTabla();
        ds.Centrar_Tabla(tabla);
    }

    public void LlenarTabla(){       
        
        modelo.setColumnIdentifiers(new String[]{"Fecha", "Monto Total", "Cliente", "Procedencia"});
        tabla.setModel(modelo);
        
        String mes = "";
        if(cbMonth.getSelectedIndex() != 0){ // 0 significa que debe mostrarse TODOS los meses
            mes = "month(fechaEmision) = "+(cbMonth.getSelectedIndex())+" AND ";
        }
        
        String _sql1 = "SELECT fechaEmision,sum(totalServ),cliente,lugar FROM ";
        String _sql2 = "WHERE  "+mes+" year(fechaEmision) = "+cbYear.getValue()+" AND lugar like '%"+txLugar.getText()+"%'";
        String sql = _sql1 +"vw_boleta "+_sql2+" GROUP BY numBoleta UNION "+_sql1+"vw_factura "+_sql2+" GROUP BY numFactura  ORDER BY fechaEmision";
        control.LlenarJtable(modelo, sql, 4);
        
        //Tamaño de tabla: Ancho(724)
        tabla.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(374);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(150);
        
        lbTotal.setText(ds.SumarColumna(tabla, 1));
    }
    public void SetPlace(){
        lbPlace.setText(txLugar.getText()+" ("+cbMonth.getSelectedItem().toString()+" - "+cbYear.getValue()+")");
    }
    public int CasoConsulta(){
        if(txLugar.getText().trim().length() == 0){ // Todos los lugares
            if(cbMonth.getSelectedIndex() == 0){ //Todos los meses
                return 4;
            }else{//Mes especifico
                return 3;
            }
        }else{ // Lugar Especifico
            if(cbMonth.getSelectedIndex() == 0){ //Todos los meses
                return 2;
            }else{//Mes especifico
                return 1;
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cbMonth = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbYear = new com.toedter.calendar.JYearChooser();
        jButton1 = new javax.swing.JButton();
        txLugar = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        lbPlace = new javax.swing.JLabel();

        setBorder(null);
        setClosable(true);
        setTitle("Lugar de Procedencia de Clientes");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "PANEL DE BUSQUEDA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/procedencia.png"))); // NOI18N
        jLabel4.setText("Procedencia");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 120, 30));

        cbMonth.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 15)); // NOI18N
        cbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos los meses", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        cbMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMonthItemStateChanged(evt);
            }
        });
        jPanel2.add(cbMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 160, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/calendario.png"))); // NOI18N
        jLabel5.setText("Mes - Año");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 110, 30));

        cbYear.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 15)); // NOI18N
        cbYear.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbYearPropertyChange(evt);
            }
        });
        jPanel2.add(cbYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 70, 30));

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

        txLugar.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 13)); // NOI18N
        txLugar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txLugar.setSelectionColor(new java.awt.Color(0, 122, 255));
        txLugar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txLugarKeyReleased(evt);
            }
        });
        jPanel2.add(txLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 230, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 784, 170));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "INGRESOS REGISTRADOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"22-10-2018", "200.00", "[Nombre de cliente aqui]", "Huaraz", "victor"},
                {"23-10-2018", "225.50", "[Nombre de cliente aqui]", "Huaraz", "victor"},
                {"23-10-2018", "185.00", "[Nombre de cliente aqui]", "Huaraz", "victor"},
                {"23-10-2018", "100.00", "[Nombre de cliente aqui]", "Huaraz", "victor"},
                {"24-10-2018", "130.00", "[Nombre de cliente aqui]", "Huaraz", "victor"},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Monto Total", "Cliente", "Procedencia", "Usuario"
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

        lbPlace.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbPlace.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPlace.setText("Huaraz");
        jPanel3.add(lbPlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 10, 400, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 784, 395));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 844, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txLugarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txLugarKeyReleased
        SetPlace();
        LlenarTabla();
    }//GEN-LAST:event_txLugarKeyReleased

    private void cbMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMonthItemStateChanged
        SetPlace();
        LlenarTabla();
    }//GEN-LAST:event_cbMonthItemStateChanged

    private void cbYearPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbYearPropertyChange
        SetPlace();
        LlenarTabla();
    }//GEN-LAST:event_cbYearPropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String __month = cbMonth.getSelectedIndex()+"";
        String __year = cbYear.getValue()+"";
        String __nameMonth = cbMonth.getSelectedItem().toString();
        
        
        if(tabla.getRowCount()>0){ //Existen filas, si hay reporte
            String __namePlace = tabla.getValueAt(0, 3).toString();
            switch(CasoConsulta()){
                case 1:
                    imp.Imp4P("Reporte por Lugar", "LugaresEMA", "_month", "_year", "_place", "_monthName", __month, __year, __namePlace, __nameMonth);
                    break;
                case 2:
                    imp.Imp2P("LugaresEA", "Reporte por Lugar", "year", "place", __year, txLugar.getText());
                    break;
                case 3:
                    imp.Imp3P("Reporte por Lugar", "Lugares_Mes", "month", __month, "year", __year, "monthName", __nameMonth);
                    break;
                case 4:
                    imp.Imp2P("LugaresEA", "Reporte por Lugar", "year", "place", __year, txLugar.getText());
                    break;
                default: JOptionPane.showMessageDialog(null, "No hay registros");
            }
        }else{ // No existen filas, no hay reporte
            JOptionPane.showMessageDialog(null, "No existen registros con este criterio de busqueda");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbMonth;
    private com.toedter.calendar.JYearChooser cbYear;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbPlace;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txLugar;
    // End of variables declaration//GEN-END:variables
}
