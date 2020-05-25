package vue;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class GestionEDT extends JPanel {

    private String titrePage = null;
    private JButton retour = null;
    private JButton ajouterSeance = null;
    private JButton supprimerSeance = null;
    private JButton modifierSeance = null;

    public GestionEDT() {
        titrePage = "Gestion de l'emploi du temps";
        retour = new JButton("Retour");
        ajouterSeance = new JButton("Ajouter");
        supprimerSeance = new JButton("Supprimer");
        modifierSeance = new JButton("Modifier");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setVisible(true);

        this.setBorder(new LineBorder(Color.BLACK, 3));
        this.setBackground(Color.white);
        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setLayout(new GridLayout(2, 1));

        JPanel topPanel = new JPanel();
        topPanel.setBorder(new LineBorder(Color.BLACK, 3));
        //topPanel.setSize(new Dimension(100, 100));
        topPanel.setBackground(Color.red);
        //topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        topPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel leftPanel = new JPanel();
        leftPanel.setBorder(new LineBorder(Color.BLACK, 3));
        leftPanel.setBackground(Color.green);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel rightPanel = new JPanel();
        rightPanel.setBorder(new LineBorder(Color.BLACK, 3));
        rightPanel.setBackground(Color.blue);
        rightPanel.setLayout(new GridLayout(3, 1));
        rightPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JSplitPane doublePanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);

        JLabel titre = new JLabel(titrePage);

        topPanel.add(retour);
        topPanel.add(titre);

        this.add(topPanel);

        this.add(doublePanel);

        leftPanel.add(ajouterSeance);
        leftPanel.add(supprimerSeance);
        leftPanel.add(modifierSeance);
    }

    public static void main(String[] args) {

        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                JFrame fr = new JFrame();

                GestionEDT vue = new GestionEDT();
                fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fr.add(vue);
                fr.setVisible(true);
            }

        });
    }

}
