package Ventanas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Clases.Control;

public class Habitaciones extends javax.swing.JFrame {

    /* ESTADO POSIBLES DE LAS HABITACIONES */
    public static String Disponible = "Disponible";
    public static String Ocupado = "Ocupado";
    public static String Reservado = "Reservado";
    public static String Mantenimiento = "Mantenimiento";

    //Solo para pruebas, se cambiara con DB -- Demuestra el estado de cada habitacion
    public static String[] EstadoHab = {Ocupado, Disponible, Ocupado, Mantenimiento, Reservado, Mantenimiento, Ocupado, Reservado,
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
        AddPaneles(); //añadimos los paneles a los pnPiso1 y pnPiso2, segun corresponda
        AddColorPaneles(); //Asignamos el color segun el estado de la habitacion
        AddLabelInPanel(); //Añadimos label con numeor de habitacion a paneles
        AddIcon();  //Añadimos icono de tipo y icono de baño propio
        //ClickLbhabitacion();  
        lbUserActual.setText(Control.usuario);
    }

    public void AddPaneles() {
        for (int i = 0; i < 16; i++) {
            panel_Hab[i] = new JPanel();  //Inicializamos los paneles
            panel_Hab[i].setLayout(null);
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
            
            panel_Hab[i].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            
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
    public void AddLabelInPanel(){ //Añade el numero de habitacion
        for (int i=0; i<16; i++){
            label_Hab[i] = new JLabel();
            if(i<8){
                label_Hab[i].setText("20"+(i+1));
            }else{
                label_Hab[i].setText("30"+(i-8+1));
            }
            label_Hab[i].setBounds(10,10,78,70);
            label_Hab[i].setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
            label_Hab[i].setForeground(new java.awt.Color(23, 23, 23));
            label_Hab[i].setCursor(new Cursor(HAND_CURSOR));
            label_Hab[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            //label_Hab[i].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
            panel_Hab[i].add(label_Hab[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(10,10,78,70));
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
    public void AddIcon(){
        for (int i = 0; i<16; i++){
            JLabel lbt = new  JLabel();
            JLabel lbb = new  JLabel();
            //Tipo de habitacion
            lbt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lbt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/individual.png")));
            lbt.setBounds(108, 10, 42, 30);
            //Bath
            //lbb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/icons8_bath_40px.png")));
            lbb.setBounds(108, 50, 42, 30);
            panel_Hab[i].add(lbt);
            panel_Hab[i].add(lbb);
        }
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
        jLabel3 = new javax.swing.JLabel();
        pnPiso2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnInfo = new javax.swing.JPanel();
        pnDatosHab = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbNumHab = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbTipoHab = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txPrecio = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
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
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

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
        pnTitulo.add(lbUserActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 0, 120, 46));

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

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lunandina/nivel2.png"))); // NOI18N

        javax.swing.GroupLayout pnPiso1Layout = new javax.swing.GroupLayout(pnPiso1);
        pnPiso1.setLayout(pnPiso1Layout);
        pnPiso1Layout.setHorizontalGroup(
            pnPiso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPiso1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1263, Short.MAX_VALUE))
        );
        pnPiso1Layout.setVerticalGroup(
            pnPiso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPiso1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        jTabbedPane1.addTab("<html><center>N<br>I<br>V<br>E<br>L<br><br><b>2<b><br></center></html>", pnPiso1);

        pnPiso2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lunandina/nivel3.png"))); // NOI18N

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

        jTabbedPane1.addTab("<html><center>N<br>I<br>V<br>E<br>L<br><br><b>3<b><br></center></html>", pnPiso2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 46, 1366, 300));
        jTabbedPane1.getAccessibleContext().setAccessibleName("<html><center>I<br>N<br>I<br>C<br>I<br>O</center></html>");

        pnInfo.setBackground(new java.awt.Color(255, 255, 255));
        pnInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnDatosHab.setBackground(new java.awt.Color(255, 255, 255));
        pnDatosHab.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "DATOS DE LA HABITACIÓN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        pnDatosHab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Precio");
        pnDatosHab.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 110, 30));

        lbNumHab.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbNumHab.setForeground(new java.awt.Color(255, 255, 255));
        lbNumHab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        pnDatosHab.add(lbNumHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 200, 30));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("N° de Habitacion");
        pnDatosHab.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 110, 30));

        lbTipoHab.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbTipoHab.setForeground(new java.awt.Color(255, 255, 255));
        lbTipoHab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        pnDatosHab.add(lbTipoHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 95, 200, 30));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Tipo Habitacion");
        pnDatosHab.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 95, 110, 30));

        jButton1.setBackground(new java.awt.Color(111, 168, 183));
        jButton1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/pdf.png"))); // NOI18N
        jButton1.setText("Generar Comprobante");
        pnDatosHab.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 205, 320, 35));

        txPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txPrecio.setSelectionColor(new java.awt.Color(0, 122, 255));
        pnDatosHab.add(txPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 200, 30));

        jButton2.setBackground(new java.awt.Color(234, 82, 62));
        jButton2.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/exit.png"))); // NOI18N
        jButton2.setText("Check - Out");
        pnDatosHab.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 320, 35));

        pnInfo.add(pnDatosHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 380, 330));

        pnCliente.setBackground(new java.awt.Color(255, 255, 255));
        pnCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "DATOS DEL CLIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        pnCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Nombres");
        pnCliente.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 100, 30));

        lbEMail.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbEMail.setForeground(new java.awt.Color(255, 255, 255));
        lbEMail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        pnCliente.add(lbEMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 250, 30));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("DNI");
        pnCliente.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 100, 30));

        lbDNI.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbDNI.setForeground(new java.awt.Color(255, 255, 255));
        lbDNI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        pnCliente.add(lbDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 250, 30));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Apellidos");
        pnCliente.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 95, 100, 30));

        lbApellidos.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbApellidos.setForeground(new java.awt.Color(255, 255, 255));
        lbApellidos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        pnCliente.add(lbApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 95, 250, 30));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("E-mail");
        pnCliente.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 100, 30));

        lbNombres.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbNombres.setForeground(new java.awt.Color(255, 255, 255));
        lbNombres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        pnCliente.add(lbNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 250, 30));

        lbProcedencia.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbProcedencia.setForeground(new java.awt.Color(255, 255, 255));
        lbProcedencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        pnCliente.add(lbProcedencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 205, 250, 30));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("Procedencia");
        pnCliente.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 205, 100, 30));

        pnInfo.add(pnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 430, 330));

        pnServicios.setBackground(new java.awt.Color(255, 255, 255));
        pnServicios.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "SERVICIOS RECIBIDOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
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
                "Servicio", "Precio", "Fecha", "Usuario"
            }
        ));
        tablaServicios.setSelectionBackground(new java.awt.Color(0, 122, 255));
        jScrollPane1.setViewportView(tablaServicios);

        pnServicios.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 326, 205));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("Total  S/.");
        pnServicios.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 108, 30));

        jLabel14.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnServicios.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 260, 218, 30));

        pnInfo.add(pnServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, 386, 330));

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JLabel lbCerrar;
    private javax.swing.JLabel lbDNI;
    private javax.swing.JLabel lbEMail;
    private javax.swing.JLabel lbMinimizar;
    private javax.swing.JLabel lbNombres;
    private javax.swing.JLabel lbNumHab;
    private javax.swing.JLabel lbProcedencia;
    private javax.swing.JLabel lbTipoHab;
    private javax.swing.JLabel lbUserActual;
    private javax.swing.JPanel pnCliente;
    private javax.swing.JPanel pnDatosHab;
    private javax.swing.JPanel pnInfo;
    private javax.swing.JPanel pnPiso1;
    private javax.swing.JPanel pnPiso2;
    private javax.swing.JPanel pnServicios;
    private javax.swing.JPanel pnTitulo;
    private javax.swing.JTable tablaServicios;
    private javax.swing.JTextField txPrecio;
    // End of variables declaration//GEN-END:variables

}
