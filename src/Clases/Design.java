package Clases;

//import com.sun.awt.AWTUtilities;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
//import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
//import java.awt.geom.RoundRectangle2D;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
//import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
//import org.jvnet.substance.SubstanceLookAndFeel;

public class Design {

    public static int x, y;

    public void MoverFrame(JPanel panel, JFrame frame) {

        panel.addMouseListener(new MouseListener() {
            @Override public void mouseClicked(MouseEvent e) {}
            @Override public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });
        panel.addMouseMotionListener(new MouseMotionListener() {
            @Override public void mouseDragged(MouseEvent me) {
                Point p = MouseInfo.getPointerInfo().getLocation();
                frame.setLocation(p.x - x, p.y - y);
            }
            @Override public void mouseMoved(MouseEvent me) {}
        });
    }

    public void Centrar_Tabla(JTable tabla) { //Centra elementos de la tabla --> solo 'Body'
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        int columnas = tabla.getColumnCount(), i = 0;
        while (i < columnas) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(modelocentrar);
            i++;
        }
    }
    public void OcultarColumna(JTable tb, int column){
        tb.getColumnModel().getColumn(column).setMaxWidth(0);
        tb.getColumnModel().getColumn(column).setMinWidth(0);
        tb.getTableHeader().getColumnModel().getColumn(column).setMaxWidth(0);
        tb.getTableHeader().getColumnModel().getColumn(column).setMinWidth(0);
    }
    public String SumarColumna(JTable tb, int column){
        double suma = 0;
        for(int i=0; i<tb.getRowCount();i++){
            suma += Double.parseDouble(tb.getValueAt(i, column).toString());
        }
        return ""+suma;
    }

    public void Centrar_Lista(JList lista) {
        DefaultListCellRenderer modelocentar = new DefaultListCellRenderer();
        modelocentar.setHorizontalAlignment(SwingConstants.CENTER);
        lista.setCellRenderer(modelocentar);
    }

    /*
    public static void Transparencia(JFrame frame, JSlider slider) {
        String opacidad;
        if (slider.getValue() > 10) {
            opacidad = "0." + slider.getValue() + "f";
        } else {
            opacidad = "0.0" + slider.getValue() + "f";
        }
        com.sun.awt.AWTUtilities.setWindowOpacity(frame, Float.parseFloat(opacidad));
    }
    */
    
    public static void FormaRedonda(JFrame jf) {
        //Shape forma = new RoundRectangle2D.Double(0, 0, jf.getBounds().width, jf.getBounds().height, 35, 35);
        //AWTUtilities.setWindowShape(jf, forma);

        /*NOTA: Al poner BorderLine, 
            se muestra con cortes en las esquinas,
            el borde no se adapta a la forma redondeada
            [FALTA SOLUCION]
         */
    }
    
    public void Escalar_Imagen(String ruta, JLabel lb, JFrame frame) {

        ImageIcon foto = new ImageIcon(ruta);
        Icon icono = new ImageIcon(foto.getImage().getScaledInstance(lb.getWidth(), lb.getHeight(), Image.SCALE_DEFAULT));
        lb.setIcon(icono);
        frame.repaint();
    }

    public void Escalar(JLabel lb, String ruta, int x, int y, JFrame frame) {
        Image img = new ImageIcon(ruta).getImage();
        ImageIcon img2 = new ImageIcon(img.getScaledInstance(x, y, Image.SCALE_SMOOTH));
        lb.setIcon(img2);
        frame.repaint();
    }

    public void Skin() {
        /*
        3.	SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlackSteelSkin");
        8.	SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.CremeSkin ");
        13.	SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.MagmaSkin");
        15.	SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.MistAquaSkin");
        21.	SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.OfficeSilver2007Skin");
         */
        //JFrame.setDefaultLookAndFeelDecorated(true);
        //SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.MagmaSkin");
    }

    public void Nimbus() {
        for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(laf.getName())) {
                try {
                    UIManager.setLookAndFeel(laf.getClassName());
                } catch (Exception ex) {
                }
            }
        }
    }

}
