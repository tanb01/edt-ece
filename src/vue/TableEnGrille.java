package vue;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

public class TableEnGrille extends JFrame {

    static PopupMenu java;

    private JTable table = null;

    public TableEnGrille() {
        super("Ejemplo 1");
        //array bidimencional de objetos con los datos de la tabla
        Object[][] data = {
            {"8h30-10h00", "fdsfsdfsdffdfsfsf", "", "", "", "", "", "", new Integer(5), new Boolean(false)},
            {"10h15-11h45", "", "", "", "", "", "", "", new Integer(5), new Boolean(false)},
            {"12h00-13h30", "", "", "", "", "", "", "", new Integer(5), new Boolean(false)},
            {"13h45-15h00", "", "", "", "", "", "", "", new Integer(5), new Boolean(false)},
            {"15h15-16h45", "", "", "", "", "", "", "", new Integer(5), new Boolean(false)},
            {"17h00-18h45", "", "", "", "", "", "", "", new Integer(5), new Boolean(false)},
            {"19h00-20h30", "", "", "", "", "", "", "", new Integer(5), new Boolean(false)},};
        //array de String's con los títulos de las columnas
        String[] columnNames = {"", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
        //se crea la Tabla
        table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 1300));
        table.setRowHeight(90);
        //Creamos un JscrollPane y le agregamos la JTable
        JScrollPane scrollPane = new JScrollPane(table);
        //Agregamos el JScrollPane al contenedor
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        //manejamos la salida
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        TableEnGrille frame = new TableEnGrille();
        frame.pack();
        frame.setVisible(true);
    }
}
