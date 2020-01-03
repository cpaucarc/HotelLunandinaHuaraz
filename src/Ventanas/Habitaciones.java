package Ventanas;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Clases.Control;
import Clases.Controlador;
import Clases.Design;
import Clases.Imprimir;
import Clases.Textos;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Habitaciones extends javax.swing.JFrame{

    /**/
    Design ds=new Design();
    Imprimir imp = new Imprimir();
    Controlador control=new Controlador();
    public static ArrayList<Habitacion> datosHab = new ArrayList<>(); 
    /**/
    /* ARRAY PARA ALMACENAR LOS PANELES QUE REPRESENTA A CADA HABITACION */
    public static JPanel[] panel_Hab = new JPanel[16];
    /* ARRAY PARA ALMACENAR LOS LABELS QUE REPRESENTA A CADA HABITACION */
    public static JLabel[] label_Hab = new JLabel[16];
    
    /* COLORES PARA FONDO DE PANEL DE HABITACION, NORMAL*/
    public static Color Disp = new Color(40, 167, 69);
    public static Color Ocup = new Color(220, 53, 69);
    public static Color Resev = new Color(255, 193, 7);
    public static Color Mant = new Color(23, 162, 184);
    
    /*Tabla Servicios*/
    DefaultTableModel modelo=new DefaultTableModel();
    /**/
    int tipoCliente = 0; // 0: NN, 1: Persona, 2: Empresa
    boolean habOcupado = false; // Sera 'true' solo si la habitacion seleccionada esta Ocupada, se usa para emitir factura/boleta
        
    public Habitaciones() {
        initComponents();
        AddPaneles(); //añadimos los paneles a los pnPiso1 y pnPiso2, segun corresponda

        modelo.setColumnIdentifiers(new String[]{"ID", "SERVICIO", "PRECIO", "CANTIDAD", "TOTAL", "FECHA"});
        tabla.setModel(modelo);
        
        actualizar();
        
        lbUserActual.setText(Control.usuario);
        
        lbMensajeHab.setVisible(false);//Mensaje cuando una habitacion tenga estado DISPONIBLE O MANTENIMIENTO
        pnDatosCliente.setVisible(false); //Cuando la habitacion tenga estado OCUPADO O RESERVADO
        pnServ.setVisible(false); //Cuando la habitacion tenga estado OCUPADO O RESERVADO
        
        
        ds.OcultarColumna(tabla, 0); //OCultamos la columna ID de la tabla Servicios
    }

    public void actualizar(){
        datosHab = Control.RecuperarDatos();
        
        AddColorPaneles(datosHab); //Asignamos el color segun el estado de la habitacion
        AddLabelInPanel(datosHab); //Añadimos label con numeor de habitacion a paneles
        AddIcon(datosHab);  //Añadimos icono de tipo y icono de baño propio
    }
    
    public void AddPaneles() {
        for (int i = 0; i < 16; i++) {
            panel_Hab[i] = new JPanel();  //Inicializamos los paneles
            panel_Hab[i].setLayout(null);
            int k = i; //solo es auxiliar para realizar operaciones

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
            
            panel_Hab[i].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            
            if (i < 8){
                pnPiso1.add(panel_Hab[i]);
            } else {
                pnPiso2.add(panel_Hab[i]);
            }
        }
    }
    
   
    public void AddColorPaneles(ArrayList<Habitacion> datosHab){ //REC: Primero, desde la DB recoger el estado y almacenarlo en EstadoHab[]
        for (int i = 0; i < 16; i++) {
            switch (datosHab.get(i).estado) {
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
                    panel_Hab[i].setBackground(Color.gray);
                    break;
            }
        }
    }
    
    public void AddLabelInPanel(ArrayList<Habitacion> datosHab){ //Añade el numero de habitacion        
        for (int i=0; i<16; i++){
            label_Hab[i] = new JLabel();
            label_Hab[i].setText(""+datosHab.get(i).numero);
            label_Hab[i].setBounds(10,10,78,70);
            label_Hab[i].setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
            label_Hab[i].setForeground(new java.awt.Color(23, 23, 23));
            label_Hab[i].setCursor(new Cursor(HAND_CURSOR));
            label_Hab[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            
            label_Hab[i].addMouseListener(listener);
            
            //label_Hab[i].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
            panel_Hab[i].add(label_Hab[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(10,10,78,70));
        }
    }
    
    public void AddIcon(ArrayList<Habitacion> datosHab){ //
        for (int i = 0; i<16; i++){
            JLabel lbt = new  JLabel();  //label tipo(lbt)
            //Tipo de habitacion
            lbt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lbt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/"+datosHab.get(i).tipo+".png")));
            lbt.setBounds(108, 10, 42, 30);
            
            panel_Hab[i].add(lbt);
        }
    }
    
    public void GetCliente(String numHab){ // Obtiene los datos del clinete que ocua la habitacion hoy dia (CURDATE)
        String _doc = control.DevolverRegistroDto("select doc from vw_alojamientoyreserva where (curdate() between fecha_ent and fecha_sal) and numHab = "+numHab, 1);
        lbDoc.setText(_doc);
        lbCliente.setText(control.DevolverRegistroDto("select cliente from vw_alojamientoyreserva where (curdate() between fecha_ent and fecha_sal) and numHab = "+numHab, 1));
        lbProc.setText(control.DevolverRegistroDto("select lugar from vw_alojamientoyreserva where (curdate() between fecha_ent and fecha_sal) and numHab = "+numHab, 1));
        if(_doc.length() == 8){
            tipoCliente = 1; // Persona
        }else if (_doc.length() == 11){
            tipoCliente = 2; // Empresa
        }
    }
    public void GetServicios(String numHab, String doc){
        String _sql = "select idServ, nombreServ, precioServ, cantidad, (precioServ*cantidad),fechaServicio from vw_sevicios where estadoServ = 'Sin Pagar' and numHab = "+numHab+" and doc = "+doc;
        control.LlenarJtable(modelo, _sql, 6);
    }
    public void GetFechas(String numHab){
        String _fechaEntrada = control.DevolverRegistroDto("select fecha_ent from vw_alojamientoyreserva where (curdate() between fecha_ent and fecha_sal) and numHab = "+numHab, 1);
        String _fechaSalida = control.DevolverRegistroDto("select fecha_sal from vw_alojamientoyreserva where (curdate() between fecha_ent and fecha_sal) and numHab = "+numHab, 1);
        String _NumDias = control.DevolverRegistroDto("select datediff(fecha_sal,fecha_ent) from vw_alojamientoyreserva where (curdate() between fecha_ent and fecha_sal) and numHab = "+numHab, 1);
        String _transcDias = control.DevolverRegistroDto("select datediff(curdate(),'"+_fechaEntrada+"')", 1);
        
        lbNumDias.setText(_NumDias);
        lbFechaEntrada.setText(_fechaEntrada);
        lbFechaSalida.setText(_fechaSalida);
        
        slider.setMinimum(0);
        slider.setMaximum(Integer.parseInt(_NumDias));
        slider.setValue(Integer.parseInt(_transcDias));
        
        txPrecioTotal.setText(""+Integer.parseInt(_NumDias)*Double.parseDouble(txPrecioUnit.getText()));
    }
    public String SumarColumna(JTable tb, int column){
        double suma = 0;
        for(int i=0; i<tb.getRowCount();i++){
            suma += Double.parseDouble(tb.getValueAt(i, column).toString());
        }
        return ""+suma;
    }
    public void Limpiar(){
        lbNumHab.setText("");
        lbTipoHab.setText("");
        txPrecioUnit.setText("");
        txPrecioTotal.setText("");
        lbMensajeHab.setVisible(true);
        pnDatosCliente.setVisible(false);
        pnServ.setVisible(false);
        habOcupado = false;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbUserActual = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbMinimizar = new javax.swing.JLabel();
        lbCerrar = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnPiso1 = new javax.swing.JPanel();
        Nivel2 = new javax.swing.JLabel();
        lbActualizar1 = new javax.swing.JLabel();
        pnPiso2 = new javax.swing.JPanel();
        Nivel3 = new javax.swing.JLabel();
        lbActualizar2 = new javax.swing.JLabel();
        pnInfo = new javax.swing.JPanel();
        pnDatosHab = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lbNumHab = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbTipoHab = new javax.swing.JLabel();
        lbprecio = new javax.swing.JLabel();
        txPrecioTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txPrecioUnit = new javax.swing.JTextField();
        lbTotal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btComprobante = new javax.swing.JButton();
        pnDatosCliente = new javax.swing.JPanel();
        pnClienteEmpresa = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        lbDoc = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbCliente = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbProc = new javax.swing.JLabel();
        lbNumDias = new javax.swing.JLabel();
        lbFechaEntrada = new javax.swing.JLabel();
        lbFechaSalida = new javax.swing.JLabel();
        btCheckOut = new javax.swing.JButton();
        slider = new javax.swing.JSlider();
        pnServ = new javax.swing.JPanel();
        pnServicios = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        lbTotServicio = new javax.swing.JLabel();
        lbMensajeHab = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnTitulo.setBackground(new java.awt.Color(13, 39, 70));
        pnTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lunandina/logoHabitaciones.png"))); // NOI18N
        pnTitulo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 7, -1, 40));

        lbUserActual.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 16)); // NOI18N
        lbUserActual.setForeground(new java.awt.Color(255, 255, 255));
        lbUserActual.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbUserActual.setText("jLabel13");
        pnTitulo.add(lbUserActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, 250, 46));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/userActual.png"))); // NOI18N
        pnTitulo.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 0, 30, 46));

        lbMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/minimizar1.png"))); // NOI18N
        lbMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMinimizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbMinimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbMinimizarMouseExited(evt);
            }
        });
        pnTitulo.add(lbMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 8, 30, 30));

        lbCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/cerrar1.png"))); // NOI18N
        lbCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbCerrarMouseExited(evt);
            }
        });
        pnTitulo.add(lbCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 8, 30, 30));

        getContentPane().add(pnTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, -1));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(23, 23, 23)));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        pnPiso1.setBackground(new java.awt.Color(255, 255, 255));

        Nivel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Nivel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lunandina/nivel2.png"))); // NOI18N

        lbActualizar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/actualizar.png"))); // NOI18N
        lbActualizar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbActualizar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbActualizar1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnPiso1Layout = new javax.swing.GroupLayout(pnPiso1);
        pnPiso1.setLayout(pnPiso1Layout);
        pnPiso1Layout.setHorizontalGroup(
            pnPiso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPiso1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnPiso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbActualizar1)
                    .addComponent(Nivel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1263, Short.MAX_VALUE))
        );
        pnPiso1Layout.setVerticalGroup(
            pnPiso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPiso1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbActualizar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Nivel2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        jTabbedPane1.addTab("<html><center>N<br>I<br>V<br>E<br>L<br><br><b>2<b><br></center></html>", pnPiso1);

        pnPiso2.setBackground(new java.awt.Color(255, 255, 255));

        Nivel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Nivel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lunandina/nivel3.png"))); // NOI18N

        lbActualizar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/actualizar.png"))); // NOI18N
        lbActualizar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbActualizar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbActualizar2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnPiso2Layout = new javax.swing.GroupLayout(pnPiso2);
        pnPiso2.setLayout(pnPiso2Layout);
        pnPiso2Layout.setHorizontalGroup(
            pnPiso2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPiso2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnPiso2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbActualizar2)
                    .addComponent(Nivel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );
        pnPiso2Layout.setVerticalGroup(
            pnPiso2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPiso2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(lbActualizar2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Nivel3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("<html><center>N<br>I<br>V<br>E<br>L<br><br><b>3<b><br></center></html>", pnPiso2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 46, 1366, 300));
        jTabbedPane1.getAccessibleContext().setAccessibleName("<html><center>I<br>N<br>I<br>C<br>I<br>O</center></html>");

        pnInfo.setBackground(new java.awt.Color(255, 255, 255));
        pnInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnDatosHab.setBackground(new java.awt.Color(255, 255, 255));
        pnDatosHab.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "DATOS DE LA HABITACIÓN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        pnDatosHab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("N° de Habitacion");
        pnDatosHab.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 110, 30));

        lbNumHab.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbNumHab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNumHab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        pnDatosHab.add(lbNumHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 200, 30));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Tipo Habitacion");
        pnDatosHab.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 95, 110, 30));

        lbTipoHab.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbTipoHab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTipoHab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        pnDatosHab.add(lbTipoHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 95, 200, 30));

        lbprecio.setBackground(new java.awt.Color(255, 255, 255));
        lbprecio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbprecio.setText("Precio x Dia");
        pnDatosHab.add(lbprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 110, 30));

        txPrecioTotal.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        txPrecioTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txPrecioTotal.setSelectionColor(new java.awt.Color(0, 122, 255));
        pnDatosHab.add(txPrecioTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 205, 200, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Precio Total");
        pnDatosHab.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 110, 30));

        txPrecioUnit.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txPrecioUnit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txPrecioUnitKeyReleased(evt);
            }
        });
        pnDatosHab.add(txPrecioUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 200, 30));

        lbTotal.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 16)); // NOI18N
        lbTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnDatosHab.add(lbTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 264, 190, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Precio Total");
        pnDatosHab.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 205, 110, 30));

        pnInfo.add(pnDatosHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 380, 320));

        btComprobante.setBackground(new java.awt.Color(111, 168, 183));
        btComprobante.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btComprobante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/pdf.png"))); // NOI18N
        btComprobante.setText("Generar Comprobante");
        btComprobante.setBorder(null);
        btComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComprobanteActionPerformed(evt);
            }
        });
        pnInfo.add(btComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 320, 35));

        pnDatosCliente.setBackground(new java.awt.Color(255, 255, 255));
        pnDatosCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnClienteEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        pnClienteEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "DATOS DEL CLIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        pnClienteEmpresa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel17.setText("DNI / RUC");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnClienteEmpresa.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 45, 85, 30));

        lbDoc.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbDoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDoc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        pnClienteEmpresa.add(lbDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 45, 280, 30));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setText("Cliente");
        pnClienteEmpresa.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 105, 85, 30));

        lbCliente.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        pnClienteEmpresa.add(lbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 105, 280, 30));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText("Procedencia");
        pnClienteEmpresa.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 165, 85, 30));

        lbProc.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbProc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbProc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        pnClienteEmpresa.add(lbProc, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 165, 280, 30));

        pnDatosCliente.add(pnClienteEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 430, 240));

        lbNumDias.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        lbNumDias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNumDias.setText("jLabel3");
        lbNumDias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnDatosCliente.add(lbNumDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 100, 25));

        lbFechaEntrada.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        lbFechaEntrada.setText("jLabel3");
        pnDatosCliente.add(lbFechaEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 110, 25));

        lbFechaSalida.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        lbFechaSalida.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbFechaSalida.setText("jLabel3");
        pnDatosCliente.add(lbFechaSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 110, 25));

        btCheckOut.setBackground(new java.awt.Color(234, 82, 62));
        btCheckOut.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btCheckOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/exit.png"))); // NOI18N
        btCheckOut.setText("Check - Out");
        btCheckOut.setBorder(null);
        pnDatosCliente.add(btCheckOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 320, 20));

        slider.setBackground(new java.awt.Color(255, 255, 255));
        slider.setMajorTickSpacing(1);
        slider.setMaximum(5);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setToolTipText("Dias transcuridos del total");
        slider.setValue(3);
        pnDatosCliente.add(slider, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 315, 430, 40));

        pnInfo.add(pnDatosCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 490, 400));

        pnServ.setBackground(new java.awt.Color(255, 255, 255));
        pnServ.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnServicios.setBackground(new java.awt.Color(255, 255, 255));
        pnServicios.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "SERVICIOS RECIBIDOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        pnServicios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Servicio", "Precio", "Cantidad", "Total", "Fecha"
            }
        ));
        tabla.setSelectionBackground(new java.awt.Color(0, 122, 255));
        jScrollPane1.setViewportView(tabla);

        pnServicios.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 45, 356, 200));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("Total  S/.");
        pnServicios.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 108, 30));

        lbTotServicio.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbTotServicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTotServicio.setText("0");
        lbTotServicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnServicios.add(lbTotServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 280, 218, 30));

        pnServ.add(pnServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 20, 386, 330));

        pnInfo.add(pnServ, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, 436, 400));

        lbMensajeHab.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbMensajeHab.setForeground(new java.awt.Color(23, 23, 23));
        lbMensajeHab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMensajeHab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lunandina/mensajeHab.png"))); // NOI18N
        lbMensajeHab.setText("\n");
        lbMensajeHab.setToolTipText("");
        pnInfo.add(lbMensajeHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 871, 330));

        getContentPane().add(pnInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 346, 1366, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMinimizarMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_lbMinimizarMouseClicked
    private void lbMinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMinimizarMouseEntered
        lbMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/minimizar2.png")));
    }//GEN-LAST:event_lbMinimizarMouseEntered
    private void lbMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMinimizarMouseExited
        lbMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/minimizar1.png")));
    }//GEN-LAST:event_lbMinimizarMouseExited

    private void lbCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_lbCerrarMouseClicked
    private void lbCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarMouseEntered
        lbCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/cerrar2.png")));
    }//GEN-LAST:event_lbCerrarMouseEntered
    private void lbCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarMouseExited
        lbCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/cerrar1.png")));
    }//GEN-LAST:event_lbCerrarMouseExited

    private void lbActualizar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbActualizar2MouseClicked
        actualizar();
    }//GEN-LAST:event_lbActualizar2MouseClicked
    private void lbActualizar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbActualizar1MouseClicked
        actualizar();
    }//GEN-LAST:event_lbActualizar1MouseClicked

    private void btComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComprobanteActionPerformed
                
        if(lbNumHab.getText().length()>0 && habOcupado && tipoCliente!=0){ // Si hay un numero en lbNumHab y la habitacion esta Ocupado
            // Proceso para obtener el idAloj
            String __numHab = lbNumHab.getText();
            String __sql = "select id from vw_alojamientoyreserva where (curdate() between fecha_ent and fecha_sal) and numHab = "+__numHab;
            String _idAloj = control.DevolverRegistroDto(__sql, 1);
            // insertar en detComp la habitacion
            // tipoCliente es --> {1: persona} y {2: empresa}
            control.CrearRegistro("call proc_InsBolFac("+tipoCliente+",0,"+Double.parseDouble(txPrecioTotal.getText())+","+_idAloj+",2,'"+lbDoc.getText()+"')");
           
            // Proceso para obtener el numero de boleta o factura
            String __numComprobante = control.DevolverRegistroDto("select numBoleta, numFactura from detallecomprobante order by idcomprobante desc limit 1", tipoCliente); // Si es persona sera 1 (Boleta) y si esempresa sera 2 (factura)
                       
            // insertar los servicios en detComp y cambia su estado a Cancelado{2}
            if(tabla.getRowCount()>0){ // Si hay algun Servicio a cuneta de la habitacion
                for(int i=0; i<tabla.getRowCount();i++){
                    //tipoComp int,numC int, tot  decimal(9,2), idmotivo int, motivo int, doc varchar(11)
                    //modelo.setColumnIdentifiers(new String[]{"ID", "SERVICIO", "PRECIO", "CANTIDAD", "TOTAL", "FECHA"});
                    control.CrearRegistro("call proc_InsBolFac("
                            +tipoCliente+","+__numComprobante+","
                            +Double.parseDouble(tabla.getValueAt(i, 4).toString())
                            +","+tabla.getValueAt(i, 0).toString()+",1,"+lbDoc.getText()+")");
                    control.CrearRegistro("update detalleservicio set idEstServ = 2 where idDetServ = "+tabla.getValueAt(i, 0).toString());
                }
            }
            
            String _aux_lpadNumC = "";
            if(tipoCliente == 1){ //Persona
                _aux_lpadNumC = control.DevolverRegistroDto("select CONCAT('B', LPAD(" + __numComprobante+ ", 7, '0'))", 1);
            }else if(tipoCliente == 2 ){// Empresa
                _aux_lpadNumC = control.DevolverRegistroDto("select CONCAT('F', LPAD(" + __numComprobante+ ", 7, '0'))", 1);
            }
            // mostrar boleta/factura
            if(tipoCliente == 1){// Boleta
                imp.ImprCon1Parametro("boleta", "Boleta N° " + _aux_lpadNumC, "numeroBoleta", _aux_lpadNumC);
            }else if(tipoCliente == 2){ // Factura
                //imp.ImprCon1Parametro("factura", "Factura N° " + _aux_lpadNumC, "numeroFactura", _aux_lpadNumC);
                imp.Imp2P("factura", "Factura N° "+_aux_lpadNumC, "numeroFactura", "montoLiteral", _aux_lpadNumC,Textos.montoLiteral(lbTotal.getText()));
            }
            // Cambiar estado alojamiento a 'Concluido'
            control.CrearRegistro("update detallealojamiento set idestadoAloj = 3 where idDetAloj = "+_idAloj);
            // Cambiar el estado de la habitacion a 'Mantenimiento'
            control.CrearRegistro("update habitaciones set idestadoHab = 4 where numHab = "+lbNumHab.getText());
            //Actualizamos el panel de las habitaciones
            actualizar();
            Limpiar();
        }
        
    }//GEN-LAST:event_btComprobanteActionPerformed

    private void txPrecioUnitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPrecioUnitKeyReleased
        if(lbNumDias.getText().length()>0 && txPrecioUnit.getText().length()>0){
            txPrecioTotal.setText(""+Integer.parseInt(lbNumDias.getText())*Double.parseDouble(txPrecioUnit.getText()));
        }
    }//GEN-LAST:event_txPrecioUnitKeyReleased

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
    private javax.swing.JLabel Nivel2;
    private javax.swing.JLabel Nivel3;
    private javax.swing.JButton btCheckOut;
    private javax.swing.JButton btComprobante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbActualizar1;
    private javax.swing.JLabel lbActualizar2;
    private javax.swing.JLabel lbCerrar;
    private javax.swing.JLabel lbCliente;
    private javax.swing.JLabel lbDoc;
    private javax.swing.JLabel lbFechaEntrada;
    private javax.swing.JLabel lbFechaSalida;
    private javax.swing.JLabel lbMensajeHab;
    private javax.swing.JLabel lbMinimizar;
    private javax.swing.JLabel lbNumDias;
    private javax.swing.JLabel lbNumHab;
    private javax.swing.JLabel lbProc;
    private javax.swing.JLabel lbTipoHab;
    private javax.swing.JLabel lbTotServicio;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbUserActual;
    private javax.swing.JLabel lbprecio;
    private javax.swing.JPanel pnClienteEmpresa;
    private javax.swing.JPanel pnDatosCliente;
    private javax.swing.JPanel pnDatosHab;
    private javax.swing.JPanel pnInfo;
    private javax.swing.JPanel pnPiso1;
    private javax.swing.JPanel pnPiso2;
    private javax.swing.JPanel pnServ;
    private javax.swing.JPanel pnServicios;
    private javax.swing.JPanel pnTitulo;
    private javax.swing.JSlider slider;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txPrecioTotal;
    private javax.swing.JTextField txPrecioUnit;
    // End of variables declaration//GEN-END:variables
    
    MouseListener listener=new MouseListener() {
        @Override public void mouseClicked(MouseEvent e) {
            if (e.getSource() instanceof JLabel) {
                String text = ((JLabel) e.getSource()).getText();
                lbNumHab.setText(text);
                lbTipoHab.setText(control.DevolverRegistroDto("SELECT tipo FROM vw_habitacion WHERE numero = '"+text+"';", 1));
                txPrecioUnit.setText(control.DevolverRegistroDto("SELECT precio FROM vw_habitacion WHERE numero = '"+text+"';", 1));
                String __estado = control.DevolverRegistroDto("SELECT estado FROM vw_habitacion WHERE numero = '"+text+"';", 1);
                if(__estado.equals("Ocupado") || __estado.equals("Reservado")){
                    pnDatosCliente.setVisible(true);
                    pnServ.setVisible(true);
                    lbMensajeHab.setVisible(false);
                    pnDatosCliente.setVisible(true);
                    btComprobante.setEnabled(false);
                    
                    GetCliente(text);
                    GetServicios(text, lbDoc.getText());
                    GetFechas(text);
                    lbTotServicio.setText(SumarColumna(tabla, 4));
                    habOcupado = false;
                    if(__estado.equals("Ocupado")){
                        btComprobante.setEnabled(true);
                        habOcupado = true;
                        lbTotal.setText(""+(Double.parseDouble(txPrecioTotal.getText())+Double.parseDouble(lbTotServicio.getText())));
                    }
                }else{
                    btComprobante.setEnabled(false);
                    lbMensajeHab.setVisible(true);
                    pnDatosCliente.setVisible(false);
                    pnServ.setVisible(false);
                    habOcupado = false;
                    
                    txPrecioTotal.setText("");
                }
            }
        }
        @Override public void mousePressed(MouseEvent e) {}
        @Override public void mouseReleased(MouseEvent e) {}
        @Override public void mouseEntered(MouseEvent e) {}
        @Override public void mouseExited(MouseEvent e) {}
    };
}
