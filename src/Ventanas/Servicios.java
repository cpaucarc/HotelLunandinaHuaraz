package Ventanas;

import Clases.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Servicios extends javax.swing.JFrame {

    public String rpt = "";
    Imprimir imp = new Imprimir();
    Design ds=new Design();
    Controlador control = new Controlador();
    DefaultTableModel modelo = new DefaultTableModel();
    int _cliente = 0;

    public Servicios() {
        initComponents();

        lbUserActual.setText(Control.usuario);

        control.LlenarCombo(cboservicio, "select * from tiposervicio", 2);
        cboservicio.setSelectedIndex(0);

        btFisicoP.setVisible(false);
        btFisicoE.setVisible(false);
        lbReiniciar.setVisible(false);
        pnEmpresa.setVisible(false);
        pnClientePersona.setVisible(false);
        pnServicio.setVisible(false);
        btGuardar.setVisible(false);
        btGuardar1.setVisible(false);
        btEditar1.setVisible(false);
        btEditar1.setEnabled(false);
        btEditar.setVisible(false);
        btEditar.setEnabled(false);
        btEliminar1.setVisible(false);
        btEliminar1.setEnabled(false);
        btEliminar.setVisible(false);
        btEliminar.setEnabled(false);
        txtpreciounit1.setText(null);
        inicializarJTable1();
    }

    public void modcli() {
        int id = Integer.parseInt(control.DevolverRegistroDto("select idDetServ from detalleservicio where idtipoServ=(select idtipoServ from tiposervicio where nombreServ= '" + cboservicio.getSelectedItem() + "')\n"
                + "and idDetAloj=(select idDetAloj from detallealojamiento where idclientePersona=(select idclientePersona from clientepersona\n"
                + "where DNI='" + lbDNI.getText() + "')and idhabitacion=(select idhabitacion from habitaciones where numHab='" + txNumHabP.getText() + "'));", 1));

        int iddet = Integer.parseInt(control.DevolverRegistroDto("select idDetAloj from detallealojamiento where idclientePersona=(select idclientePersona from clientepersona where DNI='" + lbDNI.getText() + "') and idhabitacion=(select idhabitacion from habitaciones where numHab=" + txNumHabP.getText() + ");", 1));
        int tip = Integer.parseInt(control.DevolverRegistroDto("select idtipoServ from tiposervicio where nombreServ='" + cboservicio.getSelectedItem() + "';", 1));

        rpt = (control.DevolverRegistroDto("call p_modserv('" + id + "'," + txtcant.getText() + "," + tip + "," + iddet + ");", 1));

        JOptionPane.showMessageDialog(null, rpt);

        control.LlenarJtable(modelo, "SELECT * FROM vista_ds", 9);
        limpiar();
    }

    public void modemp() {
        int id = Integer.parseInt(control.DevolverRegistroDto("select idDetServ from detalleservicio where idtipoServ=(select idtipoServ from tiposervicio where nombreServ= '" + cboservicio.getSelectedItem() + "')\n"
                + "and idDetAloj=(select idDetAloj from detallealojamiento where (RUC = '" + lbRUC.getText() + "') and idhabitacion=(select idhabitacion from habitaciones where numHab='" + txNumHabE.getText() + "'));", 1));
        int iddet = Integer.parseInt(control.DevolverRegistroDto("select idDetAloj from detallealojamiento where RUC=('" + lbRUC.getText() + "') and idhabitacion=(select idhabitacion from habitaciones where numHab=" + txNumHabE.getText() + ");", 1));
        int tip = Integer.parseInt(control.DevolverRegistroDto("select idtipoServ from tiposervicio where nombreServ='" + cboservicio.getSelectedItem() + "';", 1));

        rpt = (control.DevolverRegistroDto("call p_modserv('" + id + "'," + txtcant.getText() + "," + tip + "," + iddet + ");", 1));

        JOptionPane.showMessageDialog(null, rpt);

        control.LlenarJtable(modelo, "SELECT * FROM vista_dse", 9);
        limpiar();

    }

    public void eliminarCli() {
        int id = Integer.parseInt(control.DevolverRegistroDto("select idDetServ from detalleservicio where idtipoServ=(select idtipoServ from tiposervicio where nombreServ= '" + cboservicio.getSelectedItem() + "')\n"
                + "and idDetAloj=(select idDetAloj from detallealojamiento where idclientePersona=(select idclientePersona from clientepersona\n"
                + "where DNI='" + lbDNI.getText() + "')and idhabitacion=(select idhabitacion from habitaciones where numHab='" + txNumHabP.getText() + "'));", 1));
        rpt = (control.DevolverRegistroDto("call p_eliminar(" + id + ");", 1));
        JOptionPane.showMessageDialog(null, rpt); 
        control.LlenarJtable(modelo, "SELECT * FROM vista_ds", 9);
        limpiar();
    }

    public void eliminarEmp() {
        int id = Integer.parseInt(control.DevolverRegistroDto("select idDetServ from detalleservicio where idtipoServ=(select idtipoServ from tiposervicio where nombreServ= '" + cboservicio.getSelectedItem() + "')\n"
                + "and idDetAloj=(select idDetAloj from detallealojamiento where (RUC = '" + lbRUC.getText() + "') and idhabitacion=(select idhabitacion from habitaciones where numHab='" + txNumHabE.getText() + "'));", 1));

        rpt = (control.DevolverRegistroDto("call p_eliminar(" + id + ");", 1));

        JOptionPane.showMessageDialog(null, rpt); 
        control.LlenarJtable(modelo, "SELECT * FROM vista_dse", 9);
        limpiar();
    }

    public boolean ValidarCamposLlenosP() { // Para persona
        return lbDNI.getText().length() > 0 && txtpreciounit1.getText().length() > 0 && txtcant.getText().length() > 0;
    }
    public boolean ValidarCamposLlenosE() { // Para empresa
        return lbRUC.getText().length() > 0 && txtpreciounit1.getText().length() > 0 && txtcant.getText().length() > 0;
    }

    public void crear() {
        if (ValidarCamposLlenosP()) {
            int iddet = Integer.parseInt(control.DevolverRegistroDto("select idDetAloj from detallealojamiento where idclientePersona=(select idclientePersona from clientepersona where DNI='" + lbDNI.getText() + "') and idhabitacion=(select idhabitacion from habitaciones where numHab=" + txNumHabP.getText() + ");", 1));
            int tip = Integer.parseInt(control.DevolverRegistroDto("select idtipoServ from tiposervicio where nombreServ='" + cboservicio.getSelectedItem() + "';", 1));
            rpt = (control.DevolverRegistroDto("call p_servicios('" + txtcant.getText() + "'," + tip + "," + iddet + ",1);", 1));
            control.LlenarJtable(modelo, "SELECT * FROM vista_ds", 9);
            limpiar();
        } else {
            rpt = ("Faltan campos por llenar");
        }
        JOptionPane.showMessageDialog(null, rpt);
    }

    public void crearemp() {
        if (ValidarCamposLlenosE()) {
            int iddet = Integer.parseInt(control.DevolverRegistroDto("select idDetAloj from detallealojamiento where RUC=('" + lbRUC.getText() + "') and idhabitacion=(select idhabitacion from habitaciones where numHab=" + txNumHabE.getText() + ");", 1));
            int tip = Integer.parseInt(control.DevolverRegistroDto("select idtipoServ from tiposervicio where nombreServ='" + cboservicio.getSelectedItem() + "';", 1));
            rpt = (control.DevolverRegistroDto("call p_servicios('" + txtcant.getText() + "'," + tip + "," + iddet + ",1);", 1));

            control.LlenarJtable(modelo, "SELECT * FROM vista_dse", 9);
            limpiar();
        } else {
            rpt = ("Faltan campos por llenar");
        }
        JOptionPane.showMessageDialog(null, rpt);
    }

    public void FormatoTabla(){
        tbServicio.setModel(modelo);
        tbServicio.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbServicio.getColumnModel().getColumn(1).setPreferredWidth(200);
        tbServicio.getColumnModel().getColumn(2).setPreferredWidth(150);
        tbServicio.getColumnModel().getColumn(3).setPreferredWidth(150);
        tbServicio.getColumnModel().getColumn(4).setPreferredWidth(150);
        tbServicio.getColumnModel().getColumn(5).setPreferredWidth(150);
        tbServicio.getColumnModel().getColumn(6).setPreferredWidth(350);
        tbServicio.getColumnModel().getColumn(7).setPreferredWidth(150);
        tbServicio.getColumnModel().getColumn(8).setPreferredWidth(200);
        ds.OcultarColumna(tbServicio, 0);
    }
    public void inicializarJTable1() {
        modelo.setColumnIdentifiers(new String[]{"ID", "Servicio", "Cantidad", "Precio", "Habitación", "DNI","Cliente", "Fecha", "Usuario"});
        FormatoTabla();
        control.LlenarJtable(modelo, "SELECT * FROM vista_ds", 9);
    }
    public void inicializarJTable_empresa() {
        modelo.setColumnIdentifiers(new String[]{"ID", "Servicio", "Cantidad", "Precio", "Habitación", "RUC", "Empresa", "Fecha", "Usuario"});
        FormatoTabla();
        control.LlenarJtable(modelo, "SELECT * FROM vista_dse", 9);
    }

    public void limpiar() {
        txNumHabP.setText(null);
        txNumHabE.setText(null);
        txbuscar.setText(null);
        txtpreciounit1.setText(null);
        txtcant.setText(null);
        Jmat.setText(null);
        Jnom.setText(null);
        Jpat.setText(null);
        lbDNI.setText(null);
        jLabel23.setText(null);
        cboservicio.setSelectedIndex(-1);
        jLabel22.setText(null);
        lbRUC.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        pnCabecera = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        lbUserActual = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbMinimizar = new javax.swing.JLabel();
        lbCerrar = new javax.swing.JLabel();
        pnA = new javax.swing.JPanel();
        pnTipo = new javax.swing.JPanel();
        btPersona = new javax.swing.JButton();
        btEmpresa = new javax.swing.JButton();
        pnClientePersona = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txNumHabP = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbDNI = new javax.swing.JLabel();
        Jpat = new javax.swing.JLabel();
        Jmat = new javax.swing.JLabel();
        Jnom = new javax.swing.JLabel();
        pnEmpresa = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txNumHabE = new javax.swing.JTextField();
        lbRUC = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        pnServicio = new javax.swing.JPanel();
        cboservicio = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtpreciounit1 = new javax.swing.JTextField();
        txtcant = new javax.swing.JTextField();
        btEliminar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btGuardar = new javax.swing.JButton();
        lbReiniciar = new javax.swing.JLabel();
        lbLimpiar = new javax.swing.JLabel();
        btGuardar1 = new javax.swing.JButton();
        btEditar1 = new javax.swing.JButton();
        btEliminar1 = new javax.swing.JButton();
        btFisicoP = new javax.swing.JButton();
        btFisicoE = new javax.swing.JButton();
        pnB = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbServicio = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txbuscar = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnCabecera.setBackground(new java.awt.Color(13, 39, 70));
        pnCabecera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lunandina/logoServicios.png"))); // NOI18N
        pnCabecera.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 7, -1, 40));

        lbUserActual.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 16)); // NOI18N
        lbUserActual.setForeground(new java.awt.Color(255, 255, 255));
        lbUserActual.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbUserActual.setText("jLabel13");
        pnCabecera.add(lbUserActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, 250, 46));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/userActual.png"))); // NOI18N
        pnCabecera.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 0, 30, 46));

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
        pnCabecera.add(lbMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 8, 30, 30));

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
        pnCabecera.add(lbCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 8, 30, 30));

        getContentPane().add(pnCabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 46));

        pnA.setBackground(new java.awt.Color(255, 255, 255));
        pnA.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnTipo.setBackground(new java.awt.Color(255, 255, 255));
        pnTipo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "TIPO DE CLIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        pnTipo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btPersona.setBackground(new java.awt.Color(111, 168, 183));
        btPersona.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/persona.png"))); // NOI18N
        btPersona.setText("PERSONA");
        btPersona.setBorder(null);
        btPersona.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btPersona.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPersonaActionPerformed(evt);
            }
        });
        pnTipo.add(btPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 35, 140, 60));

        btEmpresa.setBackground(new java.awt.Color(144, 101, 168));
        btEmpresa.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/empresa.png"))); // NOI18N
        btEmpresa.setText("EMPRESA");
        btEmpresa.setBorder(null);
        btEmpresa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btEmpresa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmpresaActionPerformed(evt);
            }
        });
        pnTipo.add(btEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 35, 140, 60));

        pnA.add(pnTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 390, 130));

        pnClientePersona.setBackground(new java.awt.Color(255, 255, 255));
        pnClientePersona.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "DATOS DEL USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        pnClientePersona.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("N° de Habitacion");
        pnClientePersona.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 120, 30));

        txNumHabP.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txNumHabP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txNumHabP.setSelectionColor(new java.awt.Color(0, 122, 255));
        txNumHabP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNumHabPActionPerformed(evt);
            }
        });
        txNumHabP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txNumHabPKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txNumHabPKeyTyped(evt);
            }
        });
        pnClientePersona.add(txNumHabP, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 200, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("A. Materno");
        pnClientePersona.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 120, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("DNI");
        pnClientePersona.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 120, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("A. Paterno");
        pnClientePersona.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 85, 120, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Nombres");
        pnClientePersona.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 195, 120, 30));

        lbDNI.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbDNI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDNI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnClientePersona.add(lbDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 200, 30));

        Jpat.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        Jpat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Jpat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnClientePersona.add(Jpat, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 85, 200, 30));

        Jmat.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        Jmat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Jmat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnClientePersona.add(Jmat, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 200, 30));

        Jnom.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        Jnom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Jnom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnClientePersona.add(Jnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 195, 200, 30));

        pnA.add(pnClientePersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 390, 310));

        pnEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        pnEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "DATOS DEL USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        pnEmpresa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText("N° de Habitacion");
        pnEmpresa.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 45, 120, 30));

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setText("RUC");
        pnEmpresa.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 225, 120, 30));

        txNumHabE.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txNumHabE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txNumHabE.setSelectionColor(new java.awt.Color(0, 122, 255));
        txNumHabE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txNumHabEKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txNumHabEKeyTyped(evt);
            }
        });
        pnEmpresa.add(txNumHabE, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 45, 200, 30));

        lbRUC.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        lbRUC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRUC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnEmpresa.add(lbRUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 225, 200, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel21.setText("Empresa");
        pnEmpresa.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 105, 120, 30));

        jLabel22.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnEmpresa.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 105, 200, 30));

        jLabel23.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnEmpresa.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 165, 200, 30));

        jLabel24.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel24.setText("Procedencia");
        pnEmpresa.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 165, 120, 30));

        pnA.add(pnEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 390, 310));

        pnServicio.setBackground(new java.awt.Color(255, 255, 255));
        pnServicio.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "DATOS DEL USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        pnServicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cboservicio.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        cboservicio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboservicioItemStateChanged(evt);
            }
        });
        cboservicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboservicioActionPerformed(evt);
            }
        });
        pnServicio.add(cboservicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 200, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Servicio");
        pnServicio.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 120, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Cantidad");
        pnServicio.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 120, 30));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel17.setText("Precio               S/.");
        pnServicio.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 120, 30));

        txtpreciounit1.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtpreciounit1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpreciounit1.setSelectionColor(new java.awt.Color(0, 122, 255));
        txtpreciounit1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpreciounit1KeyTyped(evt);
            }
        });
        pnServicio.add(txtpreciounit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 200, 30));

        txtcant.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtcant.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcant.setSelectionColor(new java.awt.Color(0, 122, 255));
        txtcant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantKeyTyped(evt);
            }
        });
        pnServicio.add(txtcant, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 200, 30));

        pnA.add(pnServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 390, 170));

        btEliminar.setBackground(new java.awt.Color(234, 82, 62));
        btEliminar.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/eliminar.png"))); // NOI18N
        btEliminar.setText("Eliminar");
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });
        pnA.add(btEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 580, 120, 30));

        btEditar.setBackground(new java.awt.Color(255, 185, 83));
        btEditar.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/modificar.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });
        pnA.add(btEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 535, 120, 30));

        btGuardar.setBackground(new java.awt.Color(136, 206, 82));
        btGuardar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/agregar.png"))); // NOI18N
        btGuardar.setText("Guardar");
        btGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });
        pnA.add(btGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 535, 110, 75));

        lbReiniciar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbReiniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/reiniciar.png"))); // NOI18N
        lbReiniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbReiniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbReiniciarMouseClicked(evt);
            }
        });
        pnA.add(lbReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 30, 30));

        lbLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/limpiar.png"))); // NOI18N
        lbLimpiar.setToolTipText("Limpiar formularios");
        lbLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLimpiarMouseClicked(evt);
            }
        });
        pnA.add(lbLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, -1, -1));

        btGuardar1.setBackground(new java.awt.Color(136, 206, 82));
        btGuardar1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btGuardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/agregar.png"))); // NOI18N
        btGuardar1.setText("Guardar");
        btGuardar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btGuardar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardar1ActionPerformed(evt);
            }
        });
        pnA.add(btGuardar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 535, 110, 75));

        btEditar1.setBackground(new java.awt.Color(255, 185, 83));
        btEditar1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btEditar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/modificar.png"))); // NOI18N
        btEditar1.setText("Editar");
        btEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditar1ActionPerformed(evt);
            }
        });
        pnA.add(btEditar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 535, 120, 30));

        btEliminar1.setBackground(new java.awt.Color(234, 82, 62));
        btEliminar1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btEliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/eliminar.png"))); // NOI18N
        btEliminar1.setText("Eliminar");
        btEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminar1ActionPerformed(evt);
            }
        });
        pnA.add(btEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 580, 120, 30));

        btFisicoP.setBackground(new java.awt.Color(111, 168, 183));
        btFisicoP.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btFisicoP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/doc.png"))); // NOI18N
        btFisicoP.setText("En Físico");
        btFisicoP.setBorder(null);
        btFisicoP.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btFisicoP.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btFisicoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFisicoPActionPerformed(evt);
            }
        });
        pnA.add(btFisicoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 535, 110, 75));

        btFisicoE.setBackground(new java.awt.Color(144, 101, 168));
        btFisicoE.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btFisicoE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/doc.png"))); // NOI18N
        btFisicoE.setText("En Físico");
        btFisicoE.setBorder(null);
        btFisicoE.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btFisicoE.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btFisicoE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFisicoEActionPerformed(evt);
            }
        });
        pnA.add(btFisicoE, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 535, 110, 75));

        getContentPane().add(pnA, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 46, 450, 720));

        pnB.setBackground(new java.awt.Color(255, 255, 255));
        pnB.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "SERVICIOS CARGADOS A HABITACION", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbServicio.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        tbServicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Servicio", "Precio", "Habitacion", "DNI", "Cliente", "Fecha", "Usuario"
            }
        ));
        tbServicio.setGridColor(new java.awt.Color(51, 51, 51));
        tbServicio.setRowHeight(30);
        tbServicio.setSelectionBackground(new java.awt.Color(0, 122, 255));
        tbServicio.setShowVerticalLines(false);
        tbServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbServicioMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbServicio);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 816, 460));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/buscar.png"))); // NOI18N
        jLabel4.setText("Buscar");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 40, 100, 30));

        txbuscar.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txbuscar.setSelectionColor(new java.awt.Color(0, 122, 255));
        txbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txbuscarActionPerformed(evt);
            }
        });
        txbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txbuscarKeyReleased(evt);
            }
        });
        jPanel2.add(txbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 40, 300, 30));

        pnB.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 856, 580));

        getContentPane().add(pnB, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 46, 916, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void tbServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbServicioMouseClicked
        int fila = tbServicio.getSelectedRow();
        if (fila >= 0) {
            if (_cliente == 1) {
                btGuardar.setEnabled(false);
                btEditar.setEnabled(true);
                btEliminar.setEnabled(true);
                //persona cliente
                txNumHabP.setText(modelo.getValueAt(fila, 4).toString());
                lbDNI.setText(modelo.getValueAt(fila, 5).toString());
                Jpat.setText(control.DevolverRegistroDto("select apPat from vista_pc where DNI='" + lbDNI.getText() + "'", 1));
                Jmat.setText(control.DevolverRegistroDto("select apMat from vista_pc where DNI='" + lbDNI.getText() + "'", 1));
                Jnom.setText(control.DevolverRegistroDto("select nomb from vista_pc where DNI='" + lbDNI.getText() + "'", 1));
            } else if (_cliente == 2) {
                btGuardar1.setEnabled(false);
                btEditar1.setEnabled(true);
                btEliminar1.setEnabled(true);
                //Empresa
                txNumHabE.setText(modelo.getValueAt(fila, 4).toString());
                lbRUC.setText(modelo.getValueAt(fila, 5).toString());
                jLabel22.setText(control.DevolverRegistroDto("SELECT nombreEmpresa FROM vista_ce where RUC = '" + lbRUC.getText() + "'", 1));
                jLabel23.setText(control.DevolverRegistroDto("SELECT lugar FROM vista_ce where RUC = '" + lbRUC.getText() + "'", 1));
            }
            cboservicio.setSelectedItem(modelo.getValueAt(fila, 1).toString());
            txtcant.setText(modelo.getValueAt(fila, 2).toString());
            txtpreciounit1.setText(modelo.getValueAt(fila, 3).toString());
        }
    }//GEN-LAST:event_tbServicioMouseClicked
    private void txbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txbuscarKeyReleased
        if (_cliente == 1 || _cliente == 0) {
            control.LlenarJtable(modelo, "SELECT * FROM vista_ds where concat(numHab, nombreServ,fechaEntrada) like '%" + txbuscar.getText() + "%'", 9);
        } else if (_cliente == 2) {
            control.LlenarJtable(modelo, "SELECT * FROM vista_dse where concat(numHab, nombreServ,nombreEmpresa,fechaEntrada,RUC) like '%" + txbuscar.getText() + "%'", 9);
        }
    }//GEN-LAST:event_txbuscarKeyReleased
    private void txtcantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantKeyTyped
        Textos.Numeros(evt);
    }//GEN-LAST:event_txtcantKeyTyped
    private void btFisicoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFisicoPActionPerformed
        
        if (ValidarCamposLlenosP()) {
            int iddet = Integer.parseInt(control.DevolverRegistroDto("select idDetAloj from detallealojamiento where idclientePersona=(select idclientePersona from clientepersona where DNI='" + lbDNI.getText() + "') and idhabitacion=(select idhabitacion from habitaciones where numHab=" + txNumHabP.getText() + ");", 1));
            int tip = Integer.parseInt(control.DevolverRegistroDto("select idtipoServ from tiposervicio where nombreServ='" + cboservicio.getSelectedItem() + "';", 1));
            rpt = (control.DevolverRegistroDto("call p_servicios('" + txtcant.getText() + "'," + tip + "," + iddet + ",2);", 1));

            control.LlenarJtable(modelo, "SELECT * FROM vista_ds", 9);
            int _id = Integer.parseInt(control.DevolverRegistroDto("select idDetServ from detalleservicio order by idDetServ desc limit 1", 1));
            double total = Double.parseDouble(txtpreciounit1.getText()) * Integer.parseInt(txtcant.getText());

            control.CrearRegistro("call proc_InsBolFac(1,0," + total + "," + _id + ",1," + lbDNI.getText() + ")");

            String _numBol = control.DevolverRegistroDto("select CONCAT('B', LPAD(numBoleta, 7, '0')) from boletas order by numBoleta desc limit 1", 1);

            imp.Imp2P("boleta", "Boleta N° "+_numBol, "numeroBoleta", "montoLiteral", _numBol, Textos.montoLiteral(""+total));
            
            limpiar();
        } else {
            rpt = ("Falta campos por llenar");
        }
        JOptionPane.showMessageDialog(null, rpt);
    }//GEN-LAST:event_btFisicoPActionPerformed
    private void txNumHabPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNumHabPKeyTyped
        Textos.LimiteCaracter(evt, txNumHabP, 3);
        Textos.Numeros(evt);
    }//GEN-LAST:event_txNumHabPKeyTyped
    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        eliminarCli();
        btGuardar.setEnabled(true);
        btEditar.setEnabled(false);
        btEliminar.setEnabled(false);
    }//GEN-LAST:event_btEliminarActionPerformed
    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        modcli();
        btGuardar.setEnabled(true);
        btEditar.setEnabled(false);
        btEliminar.setEnabled(false);
    }//GEN-LAST:event_btEditarActionPerformed
    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        crear();
    }//GEN-LAST:event_btGuardarActionPerformed
    private void btPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPersonaActionPerformed
        pnTipo.setVisible(false);

        inicializarJTable1();

        lbReiniciar.setVisible(true);

        pnEmpresa.setVisible(false);
        pnClientePersona.setVisible(true);
        pnServicio.setVisible(true);

        btGuardar.setVisible(true);
        btEditar.setVisible(true);
        btEliminar.setVisible(true);
        btFisicoP.setVisible(true);

        btGuardar1.setVisible(false);
        btEditar1.setVisible(false);
        btEliminar1.setVisible(false);
        btFisicoE.setVisible(false);
        txNumHabP.grabFocus();
        _cliente = 1;
    }//GEN-LAST:event_btPersonaActionPerformed
    private void btEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmpresaActionPerformed
        pnTipo.setVisible(false);

        inicializarJTable_empresa();

        lbReiniciar.setVisible(true);

        pnEmpresa.setVisible(true);
        pnClientePersona.setVisible(false);
        pnServicio.setVisible(true);

        btGuardar.setVisible(false);
        btEditar.setVisible(false);
        btEliminar.setVisible(false);
        btFisicoP.setVisible(false);

        btGuardar1.setVisible(true);
        btEditar1.setVisible(true);
        btEliminar1.setVisible(true);
        btFisicoE.setVisible(true);
        txNumHabE.grabFocus();
        _cliente = 2;
    }//GEN-LAST:event_btEmpresaActionPerformed
    private void lbReiniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbReiniciarMouseClicked
        pnTipo.setVisible(true);
        lbReiniciar.setVisible(false);
        pnEmpresa.setVisible(false);
        pnClientePersona.setVisible(false);
        pnServicio.setVisible(false);
        btGuardar.setVisible(false);
        btGuardar1.setVisible(false);
        btEditar.setVisible(false);
        btEditar1.setVisible(false);
        btEliminar1.setVisible(false);
        btEliminar.setVisible(false);
        btFisicoP.setVisible(false);
        btFisicoE.setVisible(false);
        _cliente = 0;
    }//GEN-LAST:event_lbReiniciarMouseClicked
    private void txNumHabEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNumHabEKeyTyped
        Textos.LimiteCaracter(evt, txNumHabE, 3);
    }//GEN-LAST:event_txNumHabEKeyTyped

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
        MenuPrincipal mp=new MenuPrincipal();
        mp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbCerrarMouseClicked
    private void lbCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarMouseEntered
        lbCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/cerrar2.png")));
    }//GEN-LAST:event_lbCerrarMouseEntered
    private void lbCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarMouseExited
        lbCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/cerrar1.png")));
    }//GEN-LAST:event_lbCerrarMouseExited
    private void cboservicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboservicioActionPerformed
    }//GEN-LAST:event_cboservicioActionPerformed
    private void lbLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLimpiarMouseClicked
        limpiar();
    }//GEN-LAST:event_lbLimpiarMouseClicked
    private void txNumHabPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNumHabPKeyReleased
        if (txNumHabP.getText().length() == 3) {
            Jpat.setText(control.DevolverRegistroDto("select apPat from vista_pc where (curdate() between fecha_ent and fecha_sal) and estadoAloj = 'Alojado' and numHab = " + txNumHabP.getText(), 1));
            Jmat.setText(control.DevolverRegistroDto("select apMat from vista_pc where (curdate() between fecha_ent and fecha_sal) and estadoAloj = 'Alojado' and numHab = " + txNumHabP.getText(), 1));
            Jnom.setText(control.DevolverRegistroDto("select nomb from vista_pc where (curdate() between fecha_ent and fecha_sal) and estadoAloj = 'Alojado' and numHab = " + txNumHabP.getText(), 1));
            lbDNI.setText(control.DevolverRegistroDto("select DNI from vista_pc where (curdate() between fecha_ent and fecha_sal) and estadoAloj = 'Alojado' and numHab = " + txNumHabP.getText(), 1));
        } else {
            Jpat.setText("");
            Jmat.setText("");
            Jnom.setText("");
            lbDNI.setText("");
        }
    }//GEN-LAST:event_txNumHabPKeyReleased
    private void txNumHabPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNumHabPActionPerformed
    }//GEN-LAST:event_txNumHabPActionPerformed

    private void btGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardar1ActionPerformed
        crearemp();
    }//GEN-LAST:event_btGuardar1ActionPerformed

    private void txbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txbuscarActionPerformed
    }//GEN-LAST:event_txbuscarActionPerformed

    private void btEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditar1ActionPerformed
        modemp();
        btGuardar1.setEnabled(true);
        btEditar1.setEnabled(false);
        btEliminar1.setEnabled(false);
    }//GEN-LAST:event_btEditar1ActionPerformed

    private void btEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminar1ActionPerformed
        eliminarEmp();
        btGuardar1.setEnabled(true);
        btEditar1.setEnabled(false);
        btEliminar1.setEnabled(false);
    }//GEN-LAST:event_btEliminar1ActionPerformed

    private void txtpreciounit1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpreciounit1KeyTyped
    }//GEN-LAST:event_txtpreciounit1KeyTyped

    private void cboservicioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboservicioItemStateChanged
        if (cboservicio.getSelectedIndex() > 0) {
            txtpreciounit1.setText(
                    control.DevolverRegistroDto("select precioServ from tiposervicio where nombreServ = '" + cboservicio.getSelectedItem().toString() + "';", 1));
        } else if (cboservicio.getSelectedIndex() == 0) {
            txtpreciounit1.setText("");
        }
    }//GEN-LAST:event_cboservicioItemStateChanged

    private void txNumHabEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNumHabEKeyReleased
        if (txNumHabE.getText().length() == 3) {
            jLabel22.setText(control.DevolverRegistroDto("select nombreEmpresa from vista_ce where (curdate() between fecha_ent and fecha_sal) and estadoAloj = 'Alojado' and numHab=" + txNumHabE.getText() + ";", 1));
            jLabel23.setText(control.DevolverRegistroDto("select lugar from vista_ce where (curdate() between fecha_ent and fecha_sal) and estadoAloj = 'Alojado' and numHab=" + txNumHabE.getText() + ";", 1));
            lbRUC.setText(control.DevolverRegistroDto("select RUC from vista_ce where (curdate() between fecha_ent and fecha_sal) and estadoAloj = 'Alojado' and numHab=" + txNumHabE.getText() + ";", 1));
        } else {
            jLabel22.setText("");
            jLabel23.setText("");
            lbRUC.setText("");
        }
    }//GEN-LAST:event_txNumHabEKeyReleased

    private void btFisicoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFisicoEActionPerformed
        
        if (ValidarCamposLlenosE()) {
            int iddet = Integer.parseInt(control.DevolverRegistroDto("select idDetAloj from detallealojamiento where RUC=('" + lbRUC.getText() + "') and idhabitacion=(select idhabitacion from habitaciones where numHab=" + txNumHabE.getText() + ");", 1));
            int tip = Integer.parseInt(control.DevolverRegistroDto("select idtipoServ from tiposervicio where nombreServ='" + cboservicio.getSelectedItem() + "';", 1));
            rpt=(control.DevolverRegistroDto("call p_servicios('" + txtcant.getText() + "'," + tip + "," + iddet + ",2);", 1));
            control.LlenarJtable(modelo, "SELECT * FROM vista_dse", 9);

            int _id = Integer.parseInt(control.DevolverRegistroDto("select idDetServ from detalleservicio order by idDetServ desc limit 1", 1));
            double total = Double.parseDouble(txtpreciounit1.getText()) * Integer.parseInt(txtcant.getText());

            control.CrearRegistro("call proc_InsBolFac(2,0," + total + "," + _id + ",1," + lbRUC.getText() + ")");

            String _numFac = control.DevolverRegistroDto("select CONCAT('F', LPAD(numFactura, 7, '0')) from facturas order by numFactura desc limit 1;", 1);

            imp.Imp2P("factura", "Factura N° "+_numFac, "numeroFactura", "montoLiteral", _numFac, Textos.montoLiteral(""+total));
            limpiar();
        } else {
            rpt=( "Falta campos por llenar");
        }
        JOptionPane.showMessageDialog(null, rpt);
    }//GEN-LAST:event_btFisicoEActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Servicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Servicios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jmat;
    private javax.swing.JLabel Jnom;
    private javax.swing.JLabel Jpat;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btEditar1;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btEliminar1;
    private javax.swing.JButton btEmpresa;
    private javax.swing.JButton btFisicoE;
    private javax.swing.JButton btFisicoP;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btGuardar1;
    private javax.swing.JButton btPersona;
    private javax.swing.JComboBox<String> cboservicio;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lbCerrar;
    private javax.swing.JLabel lbDNI;
    private javax.swing.JLabel lbLimpiar;
    private javax.swing.JLabel lbMinimizar;
    private javax.swing.JLabel lbRUC;
    private javax.swing.JLabel lbReiniciar;
    private javax.swing.JLabel lbUserActual;
    private javax.swing.JPanel pnA;
    private javax.swing.JPanel pnB;
    private javax.swing.JPanel pnCabecera;
    private javax.swing.JPanel pnClientePersona;
    private javax.swing.JPanel pnEmpresa;
    private javax.swing.JPanel pnServicio;
    private javax.swing.JPanel pnTipo;
    private javax.swing.JTable tbServicio;
    private javax.swing.JTextField txNumHabE;
    private javax.swing.JTextField txNumHabP;
    private javax.swing.JTextField txbuscar;
    private javax.swing.JTextField txtcant;
    private javax.swing.JTextField txtpreciounit1;
    // End of variables declaration//GEN-END:variables
}
