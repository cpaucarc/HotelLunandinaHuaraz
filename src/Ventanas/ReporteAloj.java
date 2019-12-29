
package Ventanas;

import Clases.Controlador;
import Clases.Design;
import javax.swing.table.DefaultTableModel;

public class ReporteAloj extends javax.swing.JInternalFrame {

    Controlador control=new Controlador();
    Design ds=new Design();
    DefaultTableModel modelo=new DefaultTableModel();
    
    public ReporteAloj() {
        initComponents();
        cbMonth.setSelectedIndex(Integer.parseInt(control.DevolverRegistroDto("select (month(curdate())-1)", 1)));
        cbYear.setValue(Integer.parseInt(control.DevolverRegistroDto("select year(curdate())", 1)));
        LlenarTabla();
        ds.Centrar_Tabla(tabla);
    }

    public void LlenarTabla(){       
        
        modelo.setColumnIdentifiers(new String[]{"Fecha", "Monto Total", "Cliente", "Procedencia"});
        tabla.setModel(modelo);
        
        String _sql1 = "SELECT fechaEmision,sum(totalServ),cliente,lugar FROM ";
        String _sql2 = "WHERE month(fechaEmision) = "+(cbMonth.getSelectedIndex()+1)+" AND year(fechaEmision) = "+cbYear.getValue()+" AND lugar like '%"+txLugar.getText()+"%'";
        String sql = _sql1 +"vw_boleta "+_sql2+" GROUP BY numBoleta UNION "+_sql1+"vw_factura "+_sql2+" GROUP BY numFactura  ORDER BY fechaEmision";
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txMonto = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        cbMonth = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbYear = new com.toedter.calendar.JYearChooser();
        jButton1 = new javax.swing.JButton();
        txCliente = new javax.swing.JTextField();
        txLugar = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();

        setBorder(null);
        setClosable(true);
        setTitle("Alojamiento");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "PANEL DE BUSQUEDA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/nombre.png"))); // NOI18N
        jLabel1.setText("Cliente");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 120, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/dinero.png"))); // NOI18N
        jLabel2.setText("Ingresos   S/.");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 120, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/procedencia.png"))); // NOI18N
        jLabel4.setText("Procedencia");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 75, 120, 30));

        txMonto.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txMonto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txMonto.setSelectionColor(new java.awt.Color(0, 122, 255));
        jPanel2.add(txMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 45, 100, 30));

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        gDinero.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jRadioButton1.setText("Menor que ...");
        jPanel2.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 120, 30));

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        gDinero.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jRadioButton2.setText("Mayor que ...");
        jPanel2.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 110, 30));

        cbMonth.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        cbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        cbMonth.setSelectedIndex(9);
        jPanel2.add(cbMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 110, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/calendario.png"))); // NOI18N
        jLabel5.setText("Mes");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 70, 30));
        jPanel2.add(cbYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 80, 30));

        jButton1.setBackground(new java.awt.Color(111, 168, 183));
        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/pdf.png"))); // NOI18N
        jButton1.setText("Imprimir");
        jButton1.setBorder(null);
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 110, 150, 40));

        txCliente.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 200, 30));

        txLugar.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txLugar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 75, 200, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 784, 180));

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

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 724, 234));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel6.setText("Total  S/.");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 70, 40));

        lbTotal.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lbTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 150, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 784, 375));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 844, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbMonth;
    private com.toedter.calendar.JYearChooser cbYear;
    private javax.swing.ButtonGroup gDinero;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txCliente;
    private javax.swing.JTextField txLugar;
    private javax.swing.JTextField txMonto;
    // End of variables declaration//GEN-END:variables
}
