package Ventanas;

import java.awt.Color;
import javax.swing.JOptionPane;
import Ventanas.*;
import Clases.Control;
import java.awt.Menu;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/* importaciones para animar label */
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.util.Timer;
import java.util.TimerTask;
/* fin importaciones para animar label */
public class MenuPrincipal extends javax.swing.JFrame {

    /* Ventanas externas */
    RegistroEmpleado empleado = new RegistroEmpleado();
    Reportes reporte = new Reportes();
    Habitaciones habitacion=new Habitaciones();
    Reservas reserva=new Reservas();
    Alojamiento alojamiento=new Alojamiento();
    Servicios servicio=new Servicios();
    DatosUsuario datosUsuario = new DatosUsuario();
    /* Fin Ventanas externas */

    /*Control de fuente y tamaño del menu */
    String fuente = "Arial";
    int tamP = 12;
    int tamG = 13;
    /*Fin control de fuente y tamaño del menu */
    /* Variables para controlar animacion de label */
    public int contador = 0;
    int velocidad = 5; //seconds
    Timer timer;
    TimerTask tarea;
    int velmil = velocidad * 1000;
    Icon iconoxLabel;

    /* Fin variables para controlar animacion de label */

    public MenuPrincipal() {
        initComponents();
        if (Control.cargo.equals("Recepcionista")) {
            lbadministracion.setVisible(false);
            lbReporte.setVisible(false);
        }

        /* Controlador de animaciones*/
        tarea = new TimerTask() {
            @Override
            public void run() {
                switch (contador) {
                    case 0:
                        contador = 1;
                        iconoxLabel = new ImageIcon(getClass().getResource("/Imagenes/Transicion/Hotel.jpg"));
                        lbAnimacion.setIcon(iconoxLabel);
                        break;
                    case 1:
                        contador = 2;
                        iconoxLabel = new ImageIcon(getClass().getResource("/Imagenes/Transicion/Servicios.jpg"));
                        lbAnimacion.setIcon(iconoxLabel);
                        break;
                    case 2:
                        contador = 0;
                        iconoxLabel = new ImageIcon(getClass().getResource("/Imagenes/Transicion/Cuartos.jpg"));
                        lbAnimacion.setIcon(iconoxLabel);
                        break;
                }
            }
        };
        timer = new Timer();
        timer.scheduleAtFixedRate(tarea, velmil, velmil);
        /* Fin controlador de animaciones*/        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnAdministracion = new javax.swing.JPanel();
        lbadministracion = new javax.swing.JLabel();
        pnReportes = new javax.swing.JPanel();
        lbReporte = new javax.swing.JLabel();
        pnHab = new javax.swing.JPanel();
        lbHab = new javax.swing.JLabel();
        pnReserva = new javax.swing.JPanel();
        lbReserva = new javax.swing.JLabel();
        pnAloj = new javax.swing.JPanel();
        lbAloj = new javax.swing.JLabel();
        pnServicios = new javax.swing.JPanel();
        lbServicio = new javax.swing.JLabel();
        pnLogOut = new javax.swing.JPanel();
        lbLogOut = new javax.swing.JLabel();
        panelMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbMinimizar = new javax.swing.JLabel();
        lbCerrar = new javax.swing.JLabel();
        pnPrincipal = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btValidar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btValidar1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        panelImagenes = new javax.swing.JPanel();
        lbAnimacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnAdministracion.setBackground(new java.awt.Color(13, 39, 70));
        pnAdministracion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbadministracion.setBackground(new java.awt.Color(19, 59, 107));
        lbadministracion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbadministracion.setForeground(new java.awt.Color(255, 255, 255));
        lbadministracion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbadministracion.setText("ADMINISTRACION");
        lbadministracion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbadministracion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbadministracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbadministracionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbadministracionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbadministracionMouseExited(evt);
            }
        });
        pnAdministracion.add(lbadministracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 46));

        getContentPane().add(pnAdministracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 110, 46));

        pnReportes.setBackground(new java.awt.Color(13, 39, 70));
        pnReportes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbReporte.setBackground(new java.awt.Color(19, 59, 107));
        lbReporte.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbReporte.setForeground(new java.awt.Color(255, 255, 255));
        lbReporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbReporte.setText("REPORTES");
        lbReporte.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbReporteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbReporteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbReporteMouseExited(evt);
            }
        });
        pnReportes.add(lbReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 46));

        getContentPane().add(pnReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 100, 46));

        pnHab.setBackground(new java.awt.Color(13, 39, 70));
        pnHab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbHab.setBackground(new java.awt.Color(19, 59, 107));
        lbHab.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbHab.setForeground(new java.awt.Color(255, 255, 255));
        lbHab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHab.setText("HABITACIONES");
        lbHab.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbHab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbHab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbHabMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbHabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbHabMouseExited(evt);
            }
        });
        pnHab.add(lbHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 46));

        getContentPane().add(pnHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 100, 46));

        pnReserva.setBackground(new java.awt.Color(13, 39, 70));
        pnReserva.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbReserva.setBackground(new java.awt.Color(19, 59, 107));
        lbReserva.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbReserva.setForeground(new java.awt.Color(255, 255, 255));
        lbReserva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbReserva.setText("RESERVAS");
        lbReserva.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbReserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbReservaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbReservaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbReservaMouseExited(evt);
            }
        });
        pnReserva.add(lbReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 46));

        getContentPane().add(pnReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 100, 46));

        pnAloj.setBackground(new java.awt.Color(13, 39, 70));
        pnAloj.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbAloj.setBackground(new java.awt.Color(19, 59, 107));
        lbAloj.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbAloj.setForeground(new java.awt.Color(255, 255, 255));
        lbAloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAloj.setText("ALOJAMIENTO");
        lbAloj.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbAloj.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbAloj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAlojMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbAlojMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbAlojMouseExited(evt);
            }
        });
        pnAloj.add(lbAloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 46));

        getContentPane().add(pnAloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 100, 46));

        pnServicios.setBackground(new java.awt.Color(13, 39, 70));
        pnServicios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbServicio.setBackground(new java.awt.Color(19, 59, 107));
        lbServicio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbServicio.setForeground(new java.awt.Color(255, 255, 255));
        lbServicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbServicio.setText("SERVICIOS");
        lbServicio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbServicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbServicioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbServicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbServicioMouseExited(evt);
            }
        });
        pnServicios.add(lbServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 46));

        getContentPane().add(pnServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 0, 100, 46));

        pnLogOut.setBackground(new java.awt.Color(13, 39, 70));
        pnLogOut.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbLogOut.setBackground(new java.awt.Color(19, 59, 107));
        lbLogOut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/userLog_Y.png"))); // NOI18N
        lbLogOut.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLogOutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbLogOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbLogOutMouseExited(evt);
            }
        });
        pnLogOut.add(lbLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 46));

        getContentPane().add(pnLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 0, 50, 46));

        panelMenu.setBackground(new java.awt.Color(13, 39, 70));
        panelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lunandina/Recurso 3.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelMenu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 320, 46));

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
        panelMenu.add(lbMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 8, 30, 30));

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
        panelMenu.add(lbCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 8, 30, 30));

        getContentPane().add(panelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 46));

        pnPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "RESERVACIONES  PARA  HOY", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(23, 23, 23))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha Reserva", "Nombre Cliente", "N° Habitacion"
            }
        ));
        tabla.setSelectionBackground(new java.awt.Color(0, 122, 255));
        jScrollPane1.setViewportView(tabla);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 460, 360));

        btValidar.setBackground(new java.awt.Color(255, 185, 83));
        btValidar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btValidar.setForeground(new java.awt.Color(23, 23, 23));
        btValidar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/lista.png"))); // NOI18N
        btValidar.setText("Administrar Reservas");
        btValidar.setBorder(null);
        btValidar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btValidarActionPerformed(evt);
            }
        });
        jPanel4.add(btValidar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 480, 190, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/buscar.png"))); // NOI18N
        jLabel3.setText("Buscar");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 40, 100, 30));

        jTextField1.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setSelectionColor(new java.awt.Color(0, 122, 255));
        jPanel4.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 40, 250, 30));

        btValidar1.setBackground(new java.awt.Color(248, 177, 57));
        btValidar1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btValidar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/check.png"))); // NOI18N
        btValidar1.setText("Validar Alojamiento");
        btValidar1.setBorder(null);
        btValidar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btValidar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btValidar1ActionPerformed(evt);
            }
        });
        jPanel4.add(btValidar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 250, 40));
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 72, -1, -1));

        pnPrincipal.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 520, 550));

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(23, 23, 23));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MENÚ PRINCIPAL");
        pnPrincipal.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 30, 250, 40));

        getContentPane().add(pnPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 46, 580, 700));

        panelImagenes.setBackground(new java.awt.Color(23, 23, 23));
        panelImagenes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbAnimacion.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lbAnimacion.setForeground(new java.awt.Color(248, 177, 57));
        lbAnimacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAnimacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Transicion/Cuartos.jpg"))); // NOI18N
        panelImagenes.add(lbAnimacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 700));

        getContentPane().add(panelImagenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 46, 790, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*LABEL DE ADMINISTRACION*/
    private void lbadministracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbadministracionMouseClicked
        //this.setVisible(false);
        empleado.setVisible(true);
    }//GEN-LAST:event_lbadministracionMouseClicked
    private void lbadministracionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbadministracionMouseEntered
        pnAdministracion.setBackground(Control.color_Body);
        lbadministracion.setForeground(new Color(23, 23, 23));
        lbadministracion.setFont(new java.awt.Font(fuente, 1, tamP));
    }//GEN-LAST:event_lbadministracionMouseEntered
    private void lbadministracionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbadministracionMouseExited
        pnAdministracion.setBackground(new Color(13, 39, 70));
        lbadministracion.setForeground(new Color(255, 255, 255));
        lbadministracion.setFont(new java.awt.Font(fuente, 0, tamP));
    }//GEN-LAST:event_lbadministracionMouseExited

    /*LABEL DE HABITACIONES */
    private void lbHabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHabMouseClicked
        habitacion.setVisible(true);
    }//GEN-LAST:event_lbHabMouseClicked
    private void lbHabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHabMouseEntered
        pnHab.setBackground(Control.color_Body);
        lbHab.setForeground(new Color(23, 23, 23));
        lbHab.setFont(new java.awt.Font(fuente, 1, tamP));
    }//GEN-LAST:event_lbHabMouseEntered
    private void lbHabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHabMouseExited
        pnHab.setBackground(new Color(13, 39, 70));
        lbHab.setForeground(new Color(255, 255, 255));
        lbHab.setFont(new java.awt.Font(fuente, 0, tamP));
    }//GEN-LAST:event_lbHabMouseExited

    /*LABEL DE RESERVA*/
    private void lbReservaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbReservaMouseClicked
        reserva.setVisible(true);
    }//GEN-LAST:event_lbReservaMouseClicked
    private void lbReservaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbReservaMouseEntered
        pnReserva.setBackground(Control.color_Body);
        lbReserva.setForeground(new Color(23, 23, 23));
        lbReserva.setFont(new java.awt.Font(fuente, 1, tamG));
    }//GEN-LAST:event_lbReservaMouseEntered
    private void lbReservaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbReservaMouseExited
        pnReserva.setBackground(new Color(13, 39, 70));
        lbReserva.setForeground(new Color(255, 255, 255));
        lbReserva.setFont(new java.awt.Font(fuente, 0, tamP));
    }//GEN-LAST:event_lbReservaMouseExited

    /*LABEL DE REPORTES*/
    private void lbReporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbReporteMouseClicked
        reporte.setVisible(true);
    }//GEN-LAST:event_lbReporteMouseClicked
    private void lbReporteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbReporteMouseEntered
        pnReportes.setBackground(Control.color_Body);
        lbReporte.setForeground(new Color(23, 23, 23));
        lbReporte.setFont(new java.awt.Font(fuente, 1, tamG));
    }//GEN-LAST:event_lbReporteMouseEntered
    private void lbReporteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbReporteMouseExited
        pnReportes.setBackground(new Color(13, 39, 70));
        lbReporte.setForeground(new Color(255, 255, 255));
        lbReporte.setFont(new java.awt.Font(fuente, 0, tamP));
    }//GEN-LAST:event_lbReporteMouseExited

    /*LABEL DE LOGOUT*/
    private void lbLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogOutMouseClicked
        datosUsuario.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbLogOutMouseClicked
    private void lbLogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogOutMouseEntered
        pnLogOut.setBackground(Control.color_Body);
        lbLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/userLog_B.png")));
    }//GEN-LAST:event_lbLogOutMouseEntered
    private void lbLogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogOutMouseExited
        pnLogOut.setBackground(new Color(13, 39, 70));
        lbLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/userLog_Y.png")));
    }//GEN-LAST:event_lbLogOutMouseExited

    /*LABEL DE SERVICIOS*/
    private void lbServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbServicioMouseClicked
        servicio.setVisible(true);
    }//GEN-LAST:event_lbServicioMouseClicked
    private void lbServicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbServicioMouseEntered
        pnServicios.setBackground(Control.color_Body);
        lbServicio.setForeground(new Color(23, 23, 23));
        lbServicio.setFont(new java.awt.Font(fuente, 1, tamG));
    }//GEN-LAST:event_lbServicioMouseEntered
    private void lbServicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbServicioMouseExited
        pnServicios.setBackground(new Color(13, 39, 70));
        lbServicio.setForeground(new Color(255, 255, 255));
        lbServicio.setFont(new java.awt.Font(fuente, 0, tamP));
    }//GEN-LAST:event_lbServicioMouseExited

    private void btValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btValidarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btValidarActionPerformed

    private void btValidar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btValidar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btValidar1ActionPerformed

    /* ALOJAMIENTO */
    private void lbAlojMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlojMouseClicked
        alojamiento.setVisible(true);
    }//GEN-LAST:event_lbAlojMouseClicked
    private void lbAlojMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlojMouseEntered
        pnAloj.setBackground(Control.color_Body);
        lbAloj.setForeground(new Color(23, 23, 23));
        lbAloj.setFont(new java.awt.Font(fuente, 1, tamP));
    }//GEN-LAST:event_lbAlojMouseEntered
    private void lbAlojMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlojMouseExited
        pnAloj.setBackground(new Color(13, 39, 70));
        lbAloj.setForeground(new Color(255, 255, 255));
        lbAloj.setFont(new java.awt.Font(fuente, 0, tamP));
    }//GEN-LAST:event_lbAlojMouseExited

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
        System.exit(0);
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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btValidar;
    private javax.swing.JButton btValidar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbAloj;
    private javax.swing.JLabel lbAnimacion;
    private javax.swing.JLabel lbCerrar;
    private javax.swing.JLabel lbHab;
    private javax.swing.JLabel lbLogOut;
    private javax.swing.JLabel lbMinimizar;
    private javax.swing.JLabel lbReporte;
    private javax.swing.JLabel lbReserva;
    private javax.swing.JLabel lbServicio;
    private javax.swing.JLabel lbadministracion;
    private javax.swing.JPanel panelImagenes;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel pnAdministracion;
    private javax.swing.JPanel pnAloj;
    private javax.swing.JPanel pnHab;
    private javax.swing.JPanel pnLogOut;
    private javax.swing.JPanel pnPrincipal;
    private javax.swing.JPanel pnReportes;
    private javax.swing.JPanel pnReserva;
    private javax.swing.JPanel pnServicios;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
