package Ventanas;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import Clases.Control;

public class Reportes extends javax.swing.JFrame {

//    Facturas factura=new Facturas();
//    Boletas boleta=new Boletas();
//    IngresosMensuales inMensual=new IngresosMensuales();
//    IngresosAnuales inAnual =new IngresosAnuales();
//    LugarProcedencia lugar=new LugarProcedencia();
//    ReporteServicios servicio=new ReporteServicios();
//    ReporteClientes cliente=new ReporteClientes();
//    ReporteAloj alojamiento=new ReporteAloj();
    
    int ancho = 844;
    int alto = 750;
    
    public Reportes() {
        initComponents();
        lbUserActual.setText(Control.usuario);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbUserActual = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbMinimizar = new javax.swing.JLabel();
        lbCerrar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pnComprobante = new javax.swing.JPanel();
        pnBoleta = new javax.swing.JPanel();
        lbBoleta = new javax.swing.JLabel();
        pnFactura = new javax.swing.JPanel();
        lbFactura = new javax.swing.JLabel();
        pnIngresos = new javax.swing.JPanel();
        pnMensual = new javax.swing.JPanel();
        lbMensual = new javax.swing.JLabel();
        pnAnual = new javax.swing.JPanel();
        lbAnual = new javax.swing.JLabel();
        pnOtros = new javax.swing.JPanel();
        pnLugar = new javax.swing.JPanel();
        lbLugar = new javax.swing.JLabel();
        pnServicio = new javax.swing.JPanel();
        lbServicio = new javax.swing.JLabel();
        pnCliente = new javax.swing.JPanel();
        lbCliente = new javax.swing.JLabel();
        pnAlojamiento = new javax.swing.JPanel();
        lbAlojamiento = new javax.swing.JLabel();
        desktop = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(13, 39, 70));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lunandina/logoReportes.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 7, -1, 40));

        lbUserActual.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 16)); // NOI18N
        lbUserActual.setForeground(new java.awt.Color(255, 255, 255));
        lbUserActual.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbUserActual.setText("jLabel13");
        jPanel1.add(lbUserActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, 250, 46));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/userActual.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 0, 30, 46));

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
        jPanel1.add(lbMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 8, 30, 30));

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
        jPanel1.add(lbCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 8, 30, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 46));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnComprobante.setBackground(new java.awt.Color(255, 255, 255));
        pnComprobante.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(23, 23, 23)), "COMPROBANTES DE VENTA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        pnComprobante.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnBoleta.setBackground(new java.awt.Color(204, 204, 204));
        pnBoleta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(23, 23, 23)));
        pnBoleta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbBoleta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbBoleta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBoleta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/boleta.png"))); // NOI18N
        lbBoleta.setText("BOLETA DE VENTA");
        lbBoleta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbBoleta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbBoleta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbBoleta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBoletaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbBoletaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbBoletaMouseExited(evt);
            }
        });
        pnBoleta.add(lbBoleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 80));

        pnComprobante.add(pnBoleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 35, 150, 80));

        pnFactura.setBackground(new java.awt.Color(204, 204, 204));
        pnFactura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(23, 23, 23)));
        pnFactura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbFactura.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbFactura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/factura.png"))); // NOI18N
        lbFactura.setText("FACTURA");
        lbFactura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbFactura.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbFactura.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbFacturaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbFacturaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbFacturaMouseExited(evt);
            }
        });
        pnFactura.add(lbFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 80));

        pnComprobante.add(pnFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 35, 150, 80));

        jPanel2.add(pnComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 25, 460, 150));

        pnIngresos.setBackground(new java.awt.Color(255, 255, 255));
        pnIngresos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(23, 23, 23)), "INGRESOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        pnIngresos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnMensual.setBackground(new java.awt.Color(204, 204, 204));
        pnMensual.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(23, 23, 23)));
        pnMensual.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbMensual.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbMensual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMensual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/dineroMensual.png"))); // NOI18N
        lbMensual.setText("INGRESOS MENSUALES");
        lbMensual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbMensual.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbMensual.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbMensual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMensualMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbMensualMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbMensualMouseExited(evt);
            }
        });
        pnMensual.add(lbMensual, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 80));

        pnIngresos.add(pnMensual, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 35, 150, 80));

        pnAnual.setBackground(new java.awt.Color(204, 204, 204));
        pnAnual.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(23, 23, 23)));
        pnAnual.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbAnual.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbAnual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAnual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/dineroAnual.png"))); // NOI18N
        lbAnual.setText("INGRESOS ANUALES");
        lbAnual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbAnual.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbAnual.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbAnual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAnualMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbAnualMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbAnualMouseExited(evt);
            }
        });
        pnAnual.add(lbAnual, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 80));

        pnIngresos.add(pnAnual, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 35, 150, 80));

        jPanel2.add(pnIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 205, 460, 150));

        pnOtros.setBackground(new java.awt.Color(255, 255, 255));
        pnOtros.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(23, 23, 23)), "OTROS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        pnOtros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnLugar.setBackground(new java.awt.Color(204, 204, 204));
        pnLugar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(23, 23, 23)));
        pnLugar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbLugar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbLugar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/procedencia50.png"))); // NOI18N
        lbLugar.setText("LUGAR DE PROCEDENCIA");
        lbLugar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLugar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbLugar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbLugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLugarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbLugarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbLugarMouseExited(evt);
            }
        });
        pnLugar.add(lbLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 80));

        pnOtros.add(pnLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 35, 150, 80));

        pnServicio.setBackground(new java.awt.Color(204, 204, 204));
        pnServicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(23, 23, 23)));
        pnServicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbServicio.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbServicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/servicio.png"))); // NOI18N
        lbServicio.setText("SERVICIOS");
        lbServicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbServicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbServicio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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
        pnServicio.add(lbServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 80));

        pnOtros.add(pnServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 35, 150, 80));

        pnCliente.setBackground(new java.awt.Color(204, 204, 204));
        pnCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(23, 23, 23)));
        pnCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbCliente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/userLog_B.png"))); // NOI18N
        lbCliente.setText("CLIENTE");
        lbCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbClienteMouseExited(evt);
            }
        });
        pnCliente.add(lbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 80));

        pnOtros.add(pnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 150, 80));

        pnAlojamiento.setBackground(new java.awt.Color(204, 204, 204));
        pnAlojamiento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(23, 23, 23)));
        pnAlojamiento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbAlojamiento.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbAlojamiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAlojamiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/hotel.png"))); // NOI18N
        lbAlojamiento.setText("ALOJAMIENTO");
        lbAlojamiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbAlojamiento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbAlojamiento.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lbAlojamiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAlojamientoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbAlojamientoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbAlojamientoMouseExited(evt);
            }
        });
        pnAlojamiento.add(lbAlojamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 80));

        pnOtros.add(pnAlojamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 150, 150, 80));

        jPanel2.add(pnOtros, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 385, 460, 265));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(844, 46, 522, 700));
        getContentPane().add(desktop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 46, 844, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* FACTURA */
    private void lbFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFacturaMouseClicked
        Facturas factura=new Facturas();
        
        desktop.removeAll();
        desktop.repaint();
        desktop.add(factura);
        factura.setSize(ancho,alto);
        factura.show();
        
        //BasicInternalFrameUI bi = (BasicInternalFrameUI)facturas.getUI();
        //bi.setNorthPane(null);
        
        //BasicInternalFrameTitlePane titlePane = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) facturas.getUI()).getNorthPane();
        //facturas.remove(titlePane);
    }//GEN-LAST:event_lbFacturaMouseClicked
    private void lbFacturaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFacturaMouseEntered
        pnFactura.setBackground(new java.awt.Color(248, 177, 57));
    }//GEN-LAST:event_lbFacturaMouseEntered
    private void lbFacturaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFacturaMouseExited
        pnFactura.setBackground(new java.awt.Color(204,204,204));
    }//GEN-LAST:event_lbFacturaMouseExited

    /* BOLETA DE VENTA */
    private void lbBoletaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBoletaMouseClicked
        
        Boletas boleta=new Boletas();
        
        desktop.removeAll();
        desktop.repaint();
        desktop.add(boleta);
        boleta.setSize(ancho,alto);
        boleta.show();
    }//GEN-LAST:event_lbBoletaMouseClicked
    private void lbBoletaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBoletaMouseEntered
        pnBoleta.setBackground(new java.awt.Color(248, 177, 57));
    }//GEN-LAST:event_lbBoletaMouseEntered
    private void lbBoletaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBoletaMouseExited
        pnBoleta.setBackground(new java.awt.Color(204,204,204));
    }//GEN-LAST:event_lbBoletaMouseExited

    /* INGRESOS MENSUALES */
    private void lbMensualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMensualMouseClicked
        
        IngresosMensuales inMensual=new IngresosMensuales();
        
        desktop.removeAll();
        desktop.repaint();
        desktop.add(inMensual);
        inMensual.setSize(ancho,alto);
        inMensual.show();
    }//GEN-LAST:event_lbMensualMouseClicked
    private void lbMensualMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMensualMouseEntered
        pnMensual.setBackground(new java.awt.Color(248, 177, 57));
    }//GEN-LAST:event_lbMensualMouseEntered
    private void lbMensualMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMensualMouseExited
        pnMensual.setBackground(new java.awt.Color(204,204,204));
    }//GEN-LAST:event_lbMensualMouseExited

    /* INGRESOS ANUALES */
    private void lbAnualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAnualMouseClicked
        
        IngresosAnuales inAnual =new IngresosAnuales();
        
        desktop.removeAll();
        desktop.repaint();
        desktop.add(inAnual);
        inAnual.setSize(ancho,alto);
        inAnual.show();
    }//GEN-LAST:event_lbAnualMouseClicked
    private void lbAnualMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAnualMouseEntered
        pnAnual.setBackground(new java.awt.Color(248, 177, 57));
    }//GEN-LAST:event_lbAnualMouseEntered
    private void lbAnualMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAnualMouseExited
        pnAnual.setBackground(new java.awt.Color(204,204,204));
    }//GEN-LAST:event_lbAnualMouseExited

    /* SERVICIOS */
    private void lbServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbServicioMouseClicked
        
        ReporteServicios servicio=new ReporteServicios();
        
        desktop.removeAll();
        desktop.repaint();
        desktop.add(servicio);
        servicio.setSize(ancho,alto);
        servicio.show();
    }//GEN-LAST:event_lbServicioMouseClicked
    private void lbServicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbServicioMouseEntered
        pnServicio.setBackground(new java.awt.Color(248, 177, 57));
    }//GEN-LAST:event_lbServicioMouseEntered
    private void lbServicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbServicioMouseExited
        pnServicio.setBackground(new java.awt.Color(204,204,204));
    }//GEN-LAST:event_lbServicioMouseExited

    /* LUGAR DE PROCEDENCIA */
    private void lbLugarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLugarMouseClicked
        
        LugarProcedencia lugar=new LugarProcedencia();
        
        desktop.removeAll();
        desktop.repaint();
        desktop.add(lugar);
        lugar.setSize(ancho,alto);
        lugar.show();
    }//GEN-LAST:event_lbLugarMouseClicked
    private void lbLugarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLugarMouseEntered
        pnLugar.setBackground(new java.awt.Color(248, 177, 57));
    }//GEN-LAST:event_lbLugarMouseEntered
    private void lbLugarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLugarMouseExited
        pnLugar.setBackground(new java.awt.Color(204,204,204));
    }//GEN-LAST:event_lbLugarMouseExited

    /* CLIENTES */
    private void lbClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbClienteMouseClicked
        
        ReporteClientes cliente=new ReporteClientes();
        
        desktop.removeAll();
        desktop.repaint();
        desktop.add(cliente);
        cliente.setSize(ancho,alto);
        cliente.show();
    }//GEN-LAST:event_lbClienteMouseClicked
    private void lbClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbClienteMouseEntered
        pnCliente.setBackground(new java.awt.Color(248, 177, 57));
    }//GEN-LAST:event_lbClienteMouseEntered
    private void lbClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbClienteMouseExited
        pnCliente.setBackground(new java.awt.Color(204,204,204));
    }//GEN-LAST:event_lbClienteMouseExited

    /* ALOJAMIENTOS */
    private void lbAlojamientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlojamientoMouseClicked
        
        ReporteAloj alojamiento=new ReporteAloj();
        
        desktop.removeAll();
        desktop.repaint();
        desktop.add(alojamiento);
        alojamiento.setSize(ancho,alto);
        alojamiento.show();
    }//GEN-LAST:event_lbAlojamientoMouseClicked
    private void lbAlojamientoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlojamientoMouseEntered
        pnAlojamiento.setBackground(new java.awt.Color(248, 177, 57));
    }//GEN-LAST:event_lbAlojamientoMouseEntered
    private void lbAlojamientoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlojamientoMouseExited
        pnAlojamiento.setBackground(new java.awt.Color(204,204,204));
    }//GEN-LAST:event_lbAlojamientoMouseExited

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
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbAlojamiento;
    private javax.swing.JLabel lbAnual;
    private javax.swing.JLabel lbBoleta;
    private javax.swing.JLabel lbCerrar;
    private javax.swing.JLabel lbCliente;
    private javax.swing.JLabel lbFactura;
    private javax.swing.JLabel lbLugar;
    private javax.swing.JLabel lbMensual;
    private javax.swing.JLabel lbMinimizar;
    private javax.swing.JLabel lbServicio;
    private javax.swing.JLabel lbUserActual;
    private javax.swing.JPanel pnAlojamiento;
    private javax.swing.JPanel pnAnual;
    private javax.swing.JPanel pnBoleta;
    private javax.swing.JPanel pnCliente;
    private javax.swing.JPanel pnComprobante;
    private javax.swing.JPanel pnFactura;
    private javax.swing.JPanel pnIngresos;
    private javax.swing.JPanel pnLugar;
    private javax.swing.JPanel pnMensual;
    private javax.swing.JPanel pnOtros;
    private javax.swing.JPanel pnServicio;
    // End of variables declaration//GEN-END:variables
}
