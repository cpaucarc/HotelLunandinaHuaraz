package Ventanas;

import java.awt.Color;
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

    public Habitaciones() {
        initComponents();
        this.setExtendedState(6);
        //ClickLbhabitacion();
        //System.out.println(pn100.getBackground().toString());
        for (int i = 0; i < 16; i++) {
            panel_Hab[i].setBackground(Color.white);
        }
        for (int i = 0; i < 16; i++) {
            switch (EstadoHab[i]) {
                case "Disponible":
                    System.out.println(panel_Hab[i].getBackground().toString());
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

    public void ClickLbhabitacion() {
        lb100.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lbAux.setText(lb100.getText());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        lb101.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lbAux.setText(lb101.getText());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        lb102.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lbAux.setText(lb102.getText());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        lb103.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lbAux.setText(lb103.getText());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        lb104.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lbAux.setText(lb104.getText());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        lb105.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lbAux.setText(lb105.getText());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        lb106.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lbAux.setText(lb106.getText());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        lb107.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lbAux.setText(lb107.getText());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        /* NIVEL 2 */
        lb200.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lbAux.setText(lb200.getText());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        lb201.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lbAux.setText(lb201.getText());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        lb202.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lbAux.setText(lb202.getText());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        lb203.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lbAux.setText(lb203.getText());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        lb204.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lbAux.setText(lb204.getText());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        lb205.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lbAux.setText(lb205.getText());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        lb206.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lbAux.setText(lb206.getText());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        lb207.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lbAux.setText(lb207.getText());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnInfo = new javax.swing.JPanel();
        pnDatosHab = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbAux = new javax.swing.JLabel();
        lbAux3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbAux4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pnCliente = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lbAux2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbAux5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbAux6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbAux7 = new javax.swing.JLabel();
        lbAux8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pnServicios = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaServicios = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnPiso1 = new javax.swing.JPanel();
        pn100 = new javax.swing.JPanel();
        lb100 = new javax.swing.JLabel();
        pn104 = new javax.swing.JPanel();
        lb104 = new javax.swing.JLabel();
        pn101 = new javax.swing.JPanel();
        lb101 = new javax.swing.JLabel();
        pn105 = new javax.swing.JPanel();
        lb105 = new javax.swing.JLabel();
        pn102 = new javax.swing.JPanel();
        lb102 = new javax.swing.JLabel();
        pn106 = new javax.swing.JPanel();
        lb106 = new javax.swing.JLabel();
        pn103 = new javax.swing.JPanel();
        lb103 = new javax.swing.JLabel();
        pn107 = new javax.swing.JPanel();
        lb107 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnPiso2 = new javax.swing.JPanel();
        pn200 = new javax.swing.JPanel();
        lb200 = new javax.swing.JLabel();
        pn204 = new javax.swing.JPanel();
        lb204 = new javax.swing.JLabel();
        pn201 = new javax.swing.JPanel();
        lb201 = new javax.swing.JLabel();
        pn205 = new javax.swing.JPanel();
        lb205 = new javax.swing.JLabel();
        pn202 = new javax.swing.JPanel();
        lb202 = new javax.swing.JLabel();
        pn206 = new javax.swing.JPanel();
        lb206 = new javax.swing.JLabel();
        pn203 = new javax.swing.JPanel();
        lb203 = new javax.swing.JLabel();
        pn207 = new javax.swing.JPanel();
        lb207 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnTitulo.setBackground(new java.awt.Color(13, 39, 70));
        pnTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lunandina/logoHabitaciones.png"))); // NOI18N
        pnTitulo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 7, -1, 40));

        getContentPane().add(pnTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, -1));

        pnInfo.setBackground(new java.awt.Color(23, 23, 23));
        pnInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnDatosHab.setBackground(new java.awt.Color(23, 23, 23));
        pnDatosHab.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 177, 57)), "DATOS DE LA HABITACIÓN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Leelawadee UI Semilight", 1, 12), new java.awt.Color(248, 177, 57))); // NOI18N
        pnDatosHab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PRECIO");
        pnDatosHab.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 110, 30));

        lbAux.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbAux.setForeground(new java.awt.Color(255, 255, 255));
        lbAux.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnDatosHab.add(lbAux, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 200, 30));

        lbAux3.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbAux3.setForeground(new java.awt.Color(255, 255, 255));
        lbAux3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnDatosHab.add(lbAux3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 200, 30));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("N° HABITACION ");
        pnDatosHab.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 45, 110, 30));

        lbAux4.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbAux4.setForeground(new java.awt.Color(255, 255, 255));
        lbAux4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnDatosHab.add(lbAux4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 200, 30));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TIPO");
        pnDatosHab.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 110, 30));

        pnInfo.add(pnDatosHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 380, 270));

        pnCliente.setBackground(new java.awt.Color(23, 23, 23));
        pnCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 177, 57)), "DATOS DEL CLIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Leelawadee UI Semilight", 1, 12), new java.awt.Color(248, 177, 57))); // NOI18N
        pnCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("NOMBRES");
        pnCliente.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 100, 30));

        lbAux2.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbAux2.setForeground(new java.awt.Color(255, 255, 255));
        lbAux2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnCliente.add(lbAux2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 250, 30));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("DNI");
        pnCliente.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 100, 30));

        lbAux5.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbAux5.setForeground(new java.awt.Color(255, 255, 255));
        lbAux5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnCliente.add(lbAux5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 250, 30));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("APELLIDOS");
        pnCliente.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 95, 100, 30));

        lbAux6.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbAux6.setForeground(new java.awt.Color(255, 255, 255));
        lbAux6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnCliente.add(lbAux6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 95, 250, 30));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("E-MAIL");
        pnCliente.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 100, 30));

        lbAux7.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbAux7.setForeground(new java.awt.Color(255, 255, 255));
        lbAux7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnCliente.add(lbAux7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 250, 30));

        lbAux8.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbAux8.setForeground(new java.awt.Color(255, 255, 255));
        lbAux8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnCliente.add(lbAux8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 205, 250, 30));

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

        getContentPane().add(pnInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 345, 1366, 380));

        jTabbedPane1.setBackground(new java.awt.Color(13, 39, 70));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        pnPiso1.setBackground(new java.awt.Color(23, 23, 23));
        pnPiso1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pn100.setBackground(new java.awt.Color(40, 167, 69));

        lb100.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb100.setText("N° 100");
        lb100.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pn100Layout = new javax.swing.GroupLayout(pn100);
        pn100.setLayout(pn100Layout);
        pn100Layout.setHorizontalGroup(
            pn100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb100, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        pn100Layout.setVerticalGroup(
            pn100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb100, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        pnPiso1.add(pn100, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 40, 160, 90));

        pn104.setBackground(new java.awt.Color(220, 53, 69));

        lb104.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb104.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb104.setText("N° 104");
        lb104.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pn104Layout = new javax.swing.GroupLayout(pn104);
        pn104.setLayout(pn104Layout);
        pn104Layout.setHorizontalGroup(
            pn104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb104, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        pn104Layout.setVerticalGroup(
            pn104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb104, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        pnPiso1.add(pn104, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 170, 160, 90));

        pn101.setBackground(new java.awt.Color(255, 193, 7));

        lb101.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb101.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb101.setText("N° 101");
        lb101.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pn101Layout = new javax.swing.GroupLayout(pn101);
        pn101.setLayout(pn101Layout);
        pn101Layout.setHorizontalGroup(
            pn101Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb101, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        pn101Layout.setVerticalGroup(
            pn101Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb101, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        pnPiso1.add(pn101, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 40, 160, 90));

        pn105.setBackground(new java.awt.Color(40, 167, 69));

        lb105.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb105.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb105.setText("N° 105");
        lb105.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pn105Layout = new javax.swing.GroupLayout(pn105);
        pn105.setLayout(pn105Layout);
        pn105Layout.setHorizontalGroup(
            pn105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb105, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        pn105Layout.setVerticalGroup(
            pn105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb105, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        pnPiso1.add(pn105, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 170, 160, 90));

        pn102.setBackground(new java.awt.Color(40, 167, 69));

        lb102.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb102.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb102.setText("N° 102");
        lb102.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pn102Layout = new javax.swing.GroupLayout(pn102);
        pn102.setLayout(pn102Layout);
        pn102Layout.setHorizontalGroup(
            pn102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb102, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        pn102Layout.setVerticalGroup(
            pn102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb102, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        pnPiso1.add(pn102, new org.netbeans.lib.awtextra.AbsoluteConstraints(716, 40, 160, 90));

        pn106.setBackground(new java.awt.Color(40, 167, 69));

        lb106.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb106.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb106.setText("N° 106");
        lb106.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pn106Layout = new javax.swing.GroupLayout(pn106);
        pn106.setLayout(pn106Layout);
        pn106Layout.setHorizontalGroup(
            pn106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb106, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        pn106Layout.setVerticalGroup(
            pn106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb106, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        pnPiso1.add(pn106, new org.netbeans.lib.awtextra.AbsoluteConstraints(716, 170, 160, 90));

        pn103.setBackground(new java.awt.Color(255, 193, 7));

        lb103.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb103.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb103.setText("N° 103");
        lb103.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pn103Layout = new javax.swing.GroupLayout(pn103);
        pn103.setLayout(pn103Layout);
        pn103Layout.setHorizontalGroup(
            pn103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb103, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        pn103Layout.setVerticalGroup(
            pn103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb103, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        pnPiso1.add(pn103, new org.netbeans.lib.awtextra.AbsoluteConstraints(1008, 40, 160, 90));

        pn107.setBackground(new java.awt.Color(220, 53, 69));

        lb107.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb107.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb107.setText("N° 107");
        lb107.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pn107Layout = new javax.swing.GroupLayout(pn107);
        pn107.setLayout(pn107Layout);
        pn107Layout.setHorizontalGroup(
            pn107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb107, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        pn107Layout.setVerticalGroup(
            pn107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb107, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        pnPiso1.add(pn107, new org.netbeans.lib.awtextra.AbsoluteConstraints(1008, 170, 160, 90));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lunandina/nivel1.png"))); // NOI18N
        pnPiso1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 40, 220));

        jTabbedPane1.addTab("<html><center> N<br>I<br>V<br>E<br>L<br> <br><b>1<b><br><br><br></center></html>", pnPiso1);

        pnPiso2.setBackground(new java.awt.Color(23, 23, 23));
        pnPiso2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pn200.setBackground(new java.awt.Color(40, 167, 69));

        lb200.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb200.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb200.setText("N° 200");
        lb200.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pn200Layout = new javax.swing.GroupLayout(pn200);
        pn200.setLayout(pn200Layout);
        pn200Layout.setHorizontalGroup(
            pn200Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb200, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        pn200Layout.setVerticalGroup(
            pn200Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb200, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        pnPiso2.add(pn200, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 40, 160, 90));

        pn204.setBackground(new java.awt.Color(40, 167, 69));

        lb204.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb204.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb204.setText("N° 204");
        lb204.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pn204Layout = new javax.swing.GroupLayout(pn204);
        pn204.setLayout(pn204Layout);
        pn204Layout.setHorizontalGroup(
            pn204Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb204, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        pn204Layout.setVerticalGroup(
            pn204Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb204, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        pnPiso2.add(pn204, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 170, 160, 90));

        pn201.setBackground(new java.awt.Color(40, 167, 69));

        lb201.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb201.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb201.setText("N° 201");
        lb201.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pn201Layout = new javax.swing.GroupLayout(pn201);
        pn201.setLayout(pn201Layout);
        pn201Layout.setHorizontalGroup(
            pn201Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb201, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        pn201Layout.setVerticalGroup(
            pn201Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb201, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        pnPiso2.add(pn201, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 40, 160, 90));

        pn205.setBackground(new java.awt.Color(23, 162, 184));

        lb205.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb205.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb205.setText("N° 205");
        lb205.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pn205Layout = new javax.swing.GroupLayout(pn205);
        pn205.setLayout(pn205Layout);
        pn205Layout.setHorizontalGroup(
            pn205Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb205, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        pn205Layout.setVerticalGroup(
            pn205Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb205, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        pnPiso2.add(pn205, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 170, 160, 90));

        pn202.setBackground(new java.awt.Color(40, 167, 69));

        lb202.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb202.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb202.setText("N° 202");
        lb202.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pn202Layout = new javax.swing.GroupLayout(pn202);
        pn202.setLayout(pn202Layout);
        pn202Layout.setHorizontalGroup(
            pn202Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb202, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        pn202Layout.setVerticalGroup(
            pn202Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb202, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        pnPiso2.add(pn202, new org.netbeans.lib.awtextra.AbsoluteConstraints(716, 40, 160, 90));

        pn206.setBackground(new java.awt.Color(23, 162, 184));

        lb206.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb206.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb206.setText("N° 206");
        lb206.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pn206Layout = new javax.swing.GroupLayout(pn206);
        pn206.setLayout(pn206Layout);
        pn206Layout.setHorizontalGroup(
            pn206Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb206, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        pn206Layout.setVerticalGroup(
            pn206Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb206, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        pnPiso2.add(pn206, new org.netbeans.lib.awtextra.AbsoluteConstraints(716, 170, 160, 90));

        pn203.setBackground(new java.awt.Color(40, 167, 69));

        lb203.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb203.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb203.setText("N° 203");
        lb203.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pn203Layout = new javax.swing.GroupLayout(pn203);
        pn203.setLayout(pn203Layout);
        pn203Layout.setHorizontalGroup(
            pn203Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb203, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        pn203Layout.setVerticalGroup(
            pn203Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb203, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        pnPiso2.add(pn203, new org.netbeans.lib.awtextra.AbsoluteConstraints(1008, 40, 160, 90));

        pn207.setBackground(new java.awt.Color(23, 162, 184));

        lb207.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb207.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb207.setText("N° 207");
        lb207.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pn207Layout = new javax.swing.GroupLayout(pn207);
        pn207.setLayout(pn207Layout);
        pn207Layout.setHorizontalGroup(
            pn207Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb207, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        pn207Layout.setVerticalGroup(
            pn207Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb207, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        pnPiso2.add(pn207, new org.netbeans.lib.awtextra.AbsoluteConstraints(1008, 170, 160, 90));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lunandina/nivel2.png"))); // NOI18N
        pnPiso2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 40, 220));

        jTabbedPane1.addTab("<html><center> N<br>I<br>V<br>E<br>L<br> <br><b>2<b><br></center></html>", pnPiso2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 46, 1366, 300));
        jTabbedPane1.getAccessibleContext().setAccessibleName("<html><center>I<br>N<br>I<br>C<br>I<br>O</center></html>");

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
    private javax.swing.JLabel lb100;
    private javax.swing.JLabel lb101;
    private javax.swing.JLabel lb102;
    private javax.swing.JLabel lb103;
    private javax.swing.JLabel lb104;
    private javax.swing.JLabel lb105;
    private javax.swing.JLabel lb106;
    private javax.swing.JLabel lb107;
    private javax.swing.JLabel lb200;
    private javax.swing.JLabel lb201;
    private javax.swing.JLabel lb202;
    private javax.swing.JLabel lb203;
    private javax.swing.JLabel lb204;
    private javax.swing.JLabel lb205;
    private javax.swing.JLabel lb206;
    private javax.swing.JLabel lb207;
    private javax.swing.JLabel lbAux;
    private javax.swing.JLabel lbAux2;
    private javax.swing.JLabel lbAux3;
    private javax.swing.JLabel lbAux4;
    private javax.swing.JLabel lbAux5;
    private javax.swing.JLabel lbAux6;
    private javax.swing.JLabel lbAux7;
    private javax.swing.JLabel lbAux8;
    public static javax.swing.JPanel pn100;
    public static javax.swing.JPanel pn101;
    public static javax.swing.JPanel pn102;
    public static javax.swing.JPanel pn103;
    public static javax.swing.JPanel pn104;
    public static javax.swing.JPanel pn105;
    public static javax.swing.JPanel pn106;
    public static javax.swing.JPanel pn107;
    public static javax.swing.JPanel pn200;
    public static javax.swing.JPanel pn201;
    public static javax.swing.JPanel pn202;
    public static javax.swing.JPanel pn203;
    public static javax.swing.JPanel pn204;
    public static javax.swing.JPanel pn205;
    public static javax.swing.JPanel pn206;
    public static javax.swing.JPanel pn207;
    private javax.swing.JPanel pnCliente;
    private javax.swing.JPanel pnDatosHab;
    private javax.swing.JPanel pnInfo;
    private javax.swing.JPanel pnPiso1;
    private javax.swing.JPanel pnPiso2;
    private javax.swing.JPanel pnServicios;
    private javax.swing.JPanel pnTitulo;
    private javax.swing.JTable tablaServicios;
    // End of variables declaration//GEN-END:variables

    /* ARRAY PARA ALMACENAR LOS PANELES QUE REPRESENTA A CADA HABITACION */
    public static JPanel[] panel_Hab = {pn100, pn101, pn102, pn103, pn104, pn105, pn106, pn107,
        pn200, pn201, pn202, pn203, pn204, pn205, pn206, pn207};
    /* ARRAY PARA ALMACENAR LOS LABELS QUE REPRESENTA A CADA HABITACION */
    public JLabel[] label_Hab = {lb100, lb101, lb102, lb103, lb104, lb105, lb106, lb107,
        lb200, lb201, lb202, lb203, lb204, lb205, lb206, lb207};

}
