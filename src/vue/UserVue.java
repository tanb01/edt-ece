package vue;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class UserVue {

    private JFrame fenetre = null;

    public UserVue() {

        fenetre = new JFrame("EmploiDuTempsECE");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        fenetre.setSize(screenSize.width, screenSize.height);
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fenetre.getContentPane().setLayout(new GridLayout(1, 1));
        //fenetre.getContentPane().setLayout();

        JFrame innerContainer = new JFrame();

        Container container = innerContainer.getContentPane();
        //container.setLayout(new BorderLayout(8, 6));
        container.setLayout(new BorderLayout(1, 1));
        container.setBackground(Color.white);

        JPanel topPanel = new JPanel();
        topPanel.setBorder(new LineBorder(Color.BLACK, 3));
        topPanel.setBackground(Color.yellow);
        topPanel.setLayout(new FlowLayout(3));

        JLabel labelVue = new JLabel("Vue ");
        String[] selectionVue = {"en grille", "en liste"};
        JComboBox listeSelectionVue = new JComboBox(selectionVue);

        topPanel.add(labelVue);
        topPanel.add(listeSelectionVue);

        JLabel labelFiltre = new JLabel(" - Filtrer par ");
        String[] selectionFiltre = {"nom enseignant(e)", "matiere", "groupe"};
        JComboBox listeSelectionFiltre = new JComboBox(selectionFiltre);

        topPanel.add(labelFiltre);
        topPanel.add(listeSelectionFiltre);

        String[] selectionChamp = {"Segado", "Daachi"};
        JComboBox listeSelectionChamp = new JComboBox(selectionChamp);

        topPanel.add(listeSelectionChamp);

        JPanel semaineEDT = new JPanel();
        semaineEDT.setBorder(new LineBorder(Color.BLACK, 3));
        semaineEDT.setBackground(Color.green);
        semaineEDT.setLayout(new FlowLayout(3));

        JPanel cadreEDT = new JPanel();
        cadreEDT.setBorder(new LineBorder(Color.BLACK, 3));
        cadreEDT.setBackground(Color.red);
        cadreEDT.setLayout(new FlowLayout(3));

        GridsCanvas grilleEDT = new GridsCanvas(200, 200, 6, 7);
        cadreEDT.setLayout(new FlowLayout(1));  

        //frame.add(xyz);
        //frame.pack();
        //frame.setVisible(true);
        //topPanel.add(semaineEDT);
        //cadreEDT.add(grilleEDT);
//        topPanel.setLayout(new GridLayout(3, 4, 5, 10));
        //JComboBox selectVue();
        //topPanel.add(new JListe(20));
        //int[] selection= {1, 2, 4};
        //topPanel.add(new JComboBox(selection));
        //topPanel.add(new JTextField(20));
        //topPanel.add(new JButton("cool"));
        innerContainer.add(topPanel, BorderLayout.NORTH);
        //innerContainer.add(semaineEDT, BorderLayout.WEST);
        innerContainer.add(grilleEDT, BorderLayout.CENTER);
        //innerContainer.add(cadreEDT);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

        tabbedPane.addTab("Emploi du temps", container);
        tabbedPane.addTab("Recapitulatif des cours", new JLabel("hola"));

        fenetre.getContentPane().add(tabbedPane);
    }

    private void makeFrameFullSize(JFrame aFrame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        aFrame.setSize(screenSize.width, screenSize.height);
    }

    public static void main(String[] args) {

        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                UserVue vue = new UserVue();
            }

        });
    }

}
