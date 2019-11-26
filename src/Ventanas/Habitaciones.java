package Ventanas;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Clases.Control;
import Clases.Controlador;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Habitaciones extends javax.swing.JFrame{

    /**/
    Controlador control=new Controlador();
    ArrayList<Habitacion> datosHab=new ArrayList<>(); 
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
    /* Listener para manejar el evento del mouse en el LABEL HABITACION 
    MouseListener listener=new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() instanceof JLabel) {
                String text = ((JLabel) e.getSource()).getText();
                JOptionPane.showMessageDialog(null, text);
                
            }
        }
        @Override public void mousePressed(MouseEvent e) {}
        @Override public void mouseReleased(MouseEvent e) {}
        @Override public void mouseEntered(MouseEvent e) {}
        @Override public void mouseExited(MouseEvent e) {}
    };            
    */

    public Habitaciones() {
        initComponents();
        AddPaneles(); //añadimos los paneles a los pnPiso1 y pnPiso2, segun corresponda
        
        RecuperarDatos();
        AddColorPaneles(); //Asignamos el color segun el estado de la habitacion
        AddLabelInPanel(); //Añadimos label con numeor de habitacion a paneles
        AddIcon();  //Añadimos icono de tipo y icono de baño propio
        ClickInHab();  
        
        lbUserActual.setText(Control.usuario);
        
        lbMensajeHab.setVisible(false);//Mensaje cuando una habitacion tenga estado DISPONIBLE O MANTENIMIENTO
        pnDatosCliente.setVisible(false); //Cuando la habitacion tenga estado OCUPADO O RESERVADO
        pnServ.setVisible(false); //Cuando la habitacion tenga estado OCUPADO O RESERVADO
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
    public void RecuperarDatos(){
        for(int i=1; i<17; i++){
            int _numero = Integer.parseInt(control.DevolverRegistroDto("SELECT numero FROM vw_habitacion WHERE id = "+i+" order by id;", 1));
            String _estado = control.DevolverRegistroDto("SELECT estado FROM vw_habitacion WHERE id = "+i+" order by id;", 1);
            String _tipo = control.DevolverRegistroDto("SELECT tipo FROM vw_habitacion WHERE id = "+i+" order by id;", 1);
            double _precio = Double.parseDouble(control.DevolverRegistroDto("SELECT precio FROM vw_habitacion WHERE id = "+i+" order by id;", 1));
            datosHab.add(new Habitacion(_numero, _estado, _tipo, _precio));
        }
    }
    public void AddColorPaneles(){ //REC: Primero, desde la DB recoger el estado y almacenarlo en EstadoHab[]
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
    public void AddLabelInPanel(){ //Añade el numero de habitacion        
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
    public void AddIcon(){
        for (int i = 0; i<16; i++){
            JLabel lbt = new  JLabel();  //label tipo(lbt)
            //Tipo de habitacion
            lbt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lbt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/"+datosHab.get(i).tipo+".png")));
            lbt.setBounds(108, 10, 42, 30);
            
            panel_Hab[i].add(lbt);
        }
    }
    public void ClickInHab(){
        for (int i = 0; i<16; i++){
            
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
        jLabel7 = new javax.swing.JLabel();
        lbNumHab = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbTipoHab = new javax.swing.JLabel();
        lbprecio = new javax.swing.JLabel();
        txPrecio = new javax.swing.JTextField();
        btCheckOut = new javax.swing.JButton();
        btComprobante = new javax.swing.JButton();
        lbMensajeHab = new javax.swing.JLabel();
        pnDatosCliente = new javax.swing.JPanel();
        pnClienteEmpresa = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        lbRUC = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbNomEmpresa = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbProcEmpresa = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbMailEmpresa = new javax.swing.JLabel();
        pnClientePersona = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lbDNI = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbApellidos = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbNombres = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbProcPersona = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbMailPersona = new javax.swing.JLabel();
        pnServ = new javax.swing.JPanel();
        pnServicios = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaServicios = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        lbTotServicio = new javax.swing.JLabel();

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
        lbprecio.setText("Precio");
        pnDatosHab.add(lbprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 110, 30));

        txPrecio.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        txPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txPrecio.setSelectionColor(new java.awt.Color(0, 122, 255));
        pnDatosHab.add(txPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 200, 30));

        pnInfo.add(pnDatosHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 380, 220));

        btCheckOut.setBackground(new java.awt.Color(234, 82, 62));
        btCheckOut.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btCheckOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/exit.png"))); // NOI18N
        btCheckOut.setText("Check - Out");
        btCheckOut.setBorder(null);
        pnInfo.add(btCheckOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 315, 320, 35));

        btComprobante.setBackground(new java.awt.Color(111, 168, 183));
        btComprobante.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btComprobante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/pdf.png"))); // NOI18N
        btComprobante.setText("Generar Comprobante");
        btComprobante.setBorder(null);
        pnInfo.add(btComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 320, 35));

        lbMensajeHab.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbMensajeHab.setForeground(new java.awt.Color(23, 23, 23));
        lbMensajeHab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMensajeHab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lunandina/mensajeHab.png"))); // NOI18N
        lbMensajeHab.setText("\n");
        lbMensajeHab.setToolTipText("");
        pnInfo.add(lbMensajeHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 871, 330));

        pnDatosCliente.setBackground(new java.awt.Color(255, 255, 255));
        pnDatosCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnClienteEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        pnClienteEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "DATOS DEL CLIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        pnClienteEmpresa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel17.setText("RUC");
        pnClienteEmpresa.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 100, 30));

        lbRUC.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbRUC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        pnClienteEmpresa.add(lbRUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 250, 30));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setText("Nombre Empresa");
        pnClienteEmpresa.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 95, 120, 30));

        lbNomEmpresa.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbNomEmpresa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        pnClienteEmpresa.add(lbNomEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 95, 250, 30));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText("Procedencia");
        pnClienteEmpresa.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 100, 30));

        lbProcEmpresa.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbProcEmpresa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        pnClienteEmpresa.add(lbProcEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 250, 30));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel20.setText("Email");
        pnClienteEmpresa.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 205, 100, 30));

        lbMailEmpresa.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbMailEmpresa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        pnClienteEmpresa.add(lbMailEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 205, 250, 30));

        pnDatosCliente.add(pnClienteEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 430, 280));

        pnClientePersona.setBackground(new java.awt.Color(255, 255, 255));
        pnClientePersona.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "DATOS DEL CLIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        pnClientePersona.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("DNI");
        pnClientePersona.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 100, 30));

        lbDNI.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbDNI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        pnClientePersona.add(lbDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 250, 30));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Apellidos");
        pnClientePersona.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 95, 100, 30));

        lbApellidos.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbApellidos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        pnClientePersona.add(lbApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 95, 250, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Nombres");
        pnClientePersona.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 100, 30));

        lbNombres.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbNombres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        pnClientePersona.add(lbNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 250, 30));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("Procedencia");
        pnClientePersona.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 205, 100, 30));

        lbProcPersona.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbProcPersona.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        pnClientePersona.add(lbProcPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 205, 250, 30));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("E-mail");
        pnClientePersona.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 100, 30));

        lbMailPersona.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbMailPersona.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        pnClientePersona.add(lbMailPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 250, 30));

        pnDatosCliente.add(pnClientePersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 430, 330));

        pnInfo.add(pnDatosCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 490, 400));

        pnServ.setBackground(new java.awt.Color(255, 255, 255));
        pnServ.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        lbTotServicio.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbTotServicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTotServicio.setText("0");
        lbTotServicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnServicios.add(lbTotServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 260, 218, 30));

        pnServ.add(pnServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 20, 386, 330));

        pnInfo.add(pnServ, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, 436, 400));

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
    private javax.swing.JButton btCheckOut;
    private javax.swing.JButton btComprobante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbApellidos;
    private javax.swing.JLabel lbCerrar;
    private javax.swing.JLabel lbDNI;
    private javax.swing.JLabel lbMailEmpresa;
    private javax.swing.JLabel lbMailPersona;
    private javax.swing.JLabel lbMensajeHab;
    private javax.swing.JLabel lbMinimizar;
    private javax.swing.JLabel lbNomEmpresa;
    private javax.swing.JLabel lbNombres;
    private javax.swing.JLabel lbNumHab;
    private javax.swing.JLabel lbProcEmpresa;
    private javax.swing.JLabel lbProcPersona;
    private javax.swing.JLabel lbRUC;
    private javax.swing.JLabel lbTipoHab;
    private javax.swing.JLabel lbTotServicio;
    private javax.swing.JLabel lbUserActual;
    private javax.swing.JLabel lbprecio;
    private javax.swing.JPanel pnClienteEmpresa;
    private javax.swing.JPanel pnClientePersona;
    private javax.swing.JPanel pnDatosCliente;
    private javax.swing.JPanel pnDatosHab;
    private javax.swing.JPanel pnInfo;
    private javax.swing.JPanel pnPiso1;
    private javax.swing.JPanel pnPiso2;
    private javax.swing.JPanel pnServ;
    private javax.swing.JPanel pnServicios;
    private javax.swing.JPanel pnTitulo;
    private javax.swing.JTable tablaServicios;
    private javax.swing.JTextField txPrecio;
    // End of variables declaration//GEN-END:variables
    
    MouseListener listener=new MouseListener() {
        @Override public void mouseClicked(MouseEvent e) {
            if (e.getSource() instanceof JLabel) {
                String text = ((JLabel) e.getSource()).getText();
                lbNumHab.setText(text);
                lbTipoHab.setText(control.DevolverRegistroDto("SELECT tipo FROM vw_habitacion WHERE numero = '"+text+"';", 1));
                txPrecio.setText(control.DevolverRegistroDto("SELECT precio FROM vw_habitacion WHERE numero = '"+text+"';", 1));
                String __estado = control.DevolverRegistroDto("SELECT estado FROM vw_habitacion WHERE numero = '"+text+"';", 1);
                if(__estado.equals("Ocupado") || __estado.equals("Reservado")){
                    pnDatosCliente.setVisible(true);
                    pnServ.setVisible(true);
                    lbMensajeHab.setVisible(false);
                    //falta definir que tipo de clinete es y mostrar el panel adecuado
                    pnClientePersona.setVisible(true);
                    pnClienteEmpresa.setVisible(false);
                }else{
                    lbMensajeHab.setVisible(true);
                    pnDatosCliente.setVisible(false);
                    pnServ.setVisible(false);
                }
            }
        }
        @Override public void mousePressed(MouseEvent e) {}
        @Override public void mouseReleased(MouseEvent e) {}
        @Override public void mouseEntered(MouseEvent e) {}
        @Override public void mouseExited(MouseEvent e) {}
    };
}
