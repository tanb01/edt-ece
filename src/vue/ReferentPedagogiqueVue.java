package vue;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import static javafx.scene.paint.Color.color;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.event.*;
import javax.swing.table.TableColumn;

public class ReferentPedagogiqueVue extends JFrame {

    private String titrePage = null;
    private JTabbedPane onglet;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;

    private JScrollPane scroll;
    private DefaultTableModel model;

    public ReferentPedagogiqueVue(String title) {

        // Affiche le titre en haut de la fenêtre
        super(title);
        // Taille de la fenêtre
        this.setSize(2750, 1600);
        // Localisation de la fenêtre
        this.setLocation(100, 100);
        // Fermeture et arrêt du programme dès qu'on ferme la fenêtre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Déclaration de tous les boutons grâce à JButton
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton button10 = new JButton("10");
        JButton button11 = new JButton("11");
        JButton button12 = new JButton("12");
        JButton button13 = new JButton("13");
        JButton button14 = new JButton("14");
        JButton button15 = new JButton("15");
        JButton button16 = new JButton("16");
        JButton button17 = new JButton("17");
        JButton button18 = new JButton("18");
        JButton button19 = new JButton("19");
        JButton button20 = new JButton("20");
        JButton button21 = new JButton("21");
        JButton button22 = new JButton("22");
        JButton button23 = new JButton("23");
        JButton button24 = new JButton("24");
        JButton button25 = new JButton("25");
        JButton button26 = new JButton("26");
        JButton button27 = new JButton("27");
        JButton button28 = new JButton("28");
        JButton button29 = new JButton("29");
        JButton button30 = new JButton("30");
        JButton button31 = new JButton("31");
        JButton button32 = new JButton("32");
        JButton button33 = new JButton("33");
        JButton button34 = new JButton("34");
        JButton button35 = new JButton("35");
        JButton button36 = new JButton("36");
        JButton button37 = new JButton("37");
        JButton button38 = new JButton("38");
        JButton button39 = new JButton("39");
        JButton button40 = new JButton("40");
        JButton button41 = new JButton("41");
        JButton button42 = new JButton("42");
        JButton button43 = new JButton("43");
        JButton button44 = new JButton("44");
        JButton button45 = new JButton("45");
        JButton button46 = new JButton("46");
        JButton button47 = new JButton("47");
        JButton button48 = new JButton("48");
        JButton button49 = new JButton("49");
        JButton button50 = new JButton("50");
        JButton button51 = new JButton("51");
        JButton button52 = new JButton("52");
        JButton button53 = new JButton("Emploi du temps");
        button53.setPreferredSize(new Dimension(150, 120));

        JButton button54 = new JButton("Salles libres");
        JButton button59 = new JButton("Comment utiliser l'application ?");

        button54.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ensemble des actions
            }
        });

        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout(8, 6));
        mainContainer.setBackground(Color.yellow);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.GREEN));

        JPanel topPanel = new JPanel();
        topPanel.setBorder(new LineBorder(Color.BLACK, 5));
        topPanel.setBackground(new java.awt.Color(150, 233, 200));
        topPanel.setLayout(new FlowLayout(5));
        mainContainer.add(topPanel, BorderLayout.NORTH);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("COURS");
        JMenu menu1 = new JMenu("ETUDIANTS");
        JMenu menu2 = new JMenu("PROMOTIONS");
        JMenu menu3 = new JMenu("ENSEIGNANTS");
        JMenu menu4 = new JMenu("SALLES");

        JMenuItem m = new JMenuItem("Regarder par promo");
        JMenuItem m1 = new JMenuItem("Regarder par groupe");
        JMenuItem m2 = new JMenuItem("Regarder par enseignant");

        JMenuItem mi1 = new JMenuItem("Emploi du temps");
        JMenuItem mi2 = new JMenuItem("Récapitulatifs des cours");
        JMenuItem mi3 = new JMenuItem("Cours annulés");
        JMenuItem mi4 = new JMenuItem("Liste et trombinoscope");

        JMenuItem ms1 = new JMenuItem("Emploi du temps");
        JMenuItem ms2 = new JMenuItem("Récapitulatifs des cours");
        JMenuItem ms3 = new JMenuItem("Cours annulés");
        JMenuItem ms4 = new JMenuItem("Liste et trombinoscope");

        menu.add(m);
        menu.add(m1);
        menu.add(m2);

        menu1.add(mi1);
        menu1.add(mi2);
        menu1.add(mi3);
        menu1.add(mi4);

        menu3.add(ms1);
        menu3.add(ms2);
        menu3.add(ms3);
        menu3.add(ms4);

        menuBar.add(menu);
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);

        topPanel.add(menuBar);

        JPanel rightPanel = new JPanel();
        rightPanel.setBorder(new LineBorder(Color.BLACK, 5));
        rightPanel.setBackground(new java.awt.Color(200, 233, 200));
        rightPanel.setLayout(new FlowLayout(5));

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(5, 1, 5, 5));
        gridPanel.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel.setBackground(new java.awt.Color(200, 100, 200));

        gridPanel.add(button53);
        gridPanel.add(button54);

        rightPanel.add(gridPanel);
        mainContainer.add(rightPanel, BorderLayout.WEST);

        JPanel center = new JPanel();
        center.setOpaque(true);
        center.setBorder(new LineBorder(Color.BLACK, 3));
        center.setLayout(new FlowLayout(5));
        mainContainer.add(center, BorderLayout.CENTER);

        JPanel MyPanel1 = new JPanel();
        JLabel t = new JLabel();
        t.setText("              SEMAINE    ");
        t.setFont(new java.awt.Font("Perpetua Titling MT", 0, 28));
        MyPanel1.add(t);

        JPanel gridPanel2 = new JPanel();
        gridPanel2.setLayout(new GridLayout(1, 2, 5, 5));
        gridPanel2.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel2.setBackground(new java.awt.Color(145, 200, 100));

        gridPanel2.add(MyPanel1);
        center.add(gridPanel2, BorderLayout.NORTH);

        JPanel topIPanel = new JPanel();
        topIPanel.setBorder(new LineBorder(Color.BLACK, 3));
        topIPanel.setBackground(Color.yellow);
        topIPanel.setFont(new java.awt.Font("Perpetua Titling MT", 0, 48));
        topIPanel.setLayout(new FlowLayout(3));

        center.add(topIPanel, BorderLayout.NORTH);

        JLabel labelVue = new JLabel("-  Vue ");
        String[] selectionVue = {"en grille", "en liste"};

        JComboBox listeSelectionVue = new JComboBox(selectionVue);

        topIPanel.add(labelVue);
        topIPanel.add(listeSelectionVue);

        JLabel labelFiltre = new JLabel(" - Filtrer par ");
        String[] selectionFiltre = {"  Nom enseignant(e)", "Matière", "Groupe"};
        JComboBox listeSelectionFiltre = new JComboBox(selectionFiltre);

        topIPanel.add(labelFiltre);
        topIPanel.add(listeSelectionFiltre);

        String[] selectionChamp = {"Segado", "Daachi"};
        JComboBox listeSelectionChamp = new JComboBox(selectionChamp);

        topIPanel.add(listeSelectionChamp);

        MyPanel1.add(button1);
        MyPanel1.add(button2);
        MyPanel1.add(button3);
        MyPanel1.add(button4);
        MyPanel1.add(button5);
        MyPanel1.add(button6);
        MyPanel1.add(button7);
        MyPanel1.add(button8);
        MyPanel1.add(button9);
        MyPanel1.add(button10);
        MyPanel1.add(button11);
        MyPanel1.add(button12);
        MyPanel1.add(button13);
        MyPanel1.add(button14);
        MyPanel1.add(button15);
        MyPanel1.add(button16);
        MyPanel1.add(button17);
        MyPanel1.add(button18);
        MyPanel1.add(button19);
        MyPanel1.add(button20);
        MyPanel1.add(button21);
        MyPanel1.add(button22);
        MyPanel1.add(button23);
        MyPanel1.add(button24);
        MyPanel1.add(button25);
        MyPanel1.add(button26);
        MyPanel1.add(button27);
        MyPanel1.add(button28);
        MyPanel1.add(button29);
        MyPanel1.add(button30);
        MyPanel1.add(button31);
        MyPanel1.add(button32);
        MyPanel1.add(button33);
        MyPanel1.add(button34);
        MyPanel1.add(button35);
        MyPanel1.add(button36);
        MyPanel1.add(button37);
        MyPanel1.add(button38);
        MyPanel1.add(button39);
        MyPanel1.add(button40);
        MyPanel1.add(button41);
        MyPanel1.add(button42);
        MyPanel1.add(button43);
        MyPanel1.add(button44);
        MyPanel1.add(button45);
        MyPanel1.add(button46);
        MyPanel1.add(button47);
        MyPanel1.add(button48);
        MyPanel1.add(button49);
        MyPanel1.add(button50);
        MyPanel1.add(button51);
        MyPanel1.add(button52);

        center.add(topIPanel, BorderLayout.NORTH);
        //innerContainer.add(semaineEDT, BorderLayout.WEST);

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {"8h30-10h00", null, null, null, null, null, null, null},
                    {"10h15-11h45", null, null, null, null, null, null, null},
                    {"12h00-13h30", null, null, null, null, null, null, null},
                    {"13h45-15h00", null, null, null, null, null, null, null},
                    {"15h15-16h45", null, null, null, null, null, null, null},
                    {"17h00-18h45", null, null, null, null, null, null, null},
                    {"19h00-20h30", null, null, null, null, null, null, null}
                },
                new String[]{
                    " ", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"
                }
        ));
        jScrollPane1.setViewportView(jTable1);
        jTable1.setPreferredScrollableViewportSize(new Dimension(2500, 1460));
        jTable1.setRowHeight(210);
        TableColumn col = jTable1.getColumnModel().getColumn(0);
        col.setPreferredWidth(100);
        col = jTable1.getColumnModel().getColumn(1);
        col.setPreferredWidth(300);
        col = jTable1.getColumnModel().getColumn(2);
        col.setPreferredWidth(300);
        col = jTable1.getColumnModel().getColumn(3);
        col.setPreferredWidth(300);
        col = jTable1.getColumnModel().getColumn(4);
        col.setPreferredWidth(300);
        col = jTable1.getColumnModel().getColumn(5);
        col.setPreferredWidth(300);
        col = jTable1.getColumnModel().getColumn(6);
        col.setPreferredWidth(300);
        col = jTable1.getColumnModel().getColumn(7);
        col.setPreferredWidth(300);

        center.add(jScrollPane1, BorderLayout.SOUTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.setBackground(new java.awt.Color(200, 100, 200));
        bottomPanel.setBorder(new LineBorder(Color.BLACK, 3));
        mainContainer.add(bottomPanel, BorderLayout.SOUTH);

        this.setLayout(new BorderLayout());
        JPanel panNouveauPanel = new JPanel();
        panNouveauPanel.setOpaque(true);
        panNouveauPanel.setBorder(new LineBorder(Color.BLACK, 3));
        panNouveauPanel.setLayout(new FlowLayout(5));
        panNouveauPanel.setBackground(Color.blue);
        center.add(panNouveauPanel, BorderLayout.CENTER);

        JLabel label15 = new JLabel();
        mainContainer.add(label15, BorderLayout.CENTER);
        Component Component = panNouveauPanel.add(label15);
        label15.setFont(new java.awt.Font("Tahoma", 0, 36));
        label15.setText("Voici l'emploi du temps de cette semaine ");

        this.setLayout(new BorderLayout());
        JPanel panNouveaPanel = new JPanel();
        panNouveaPanel.setOpaque(true);
        panNouveaPanel.setBorder(new LineBorder(Color.BLACK, 3));
        panNouveaPanel.setLayout(new FlowLayout(5));
        panNouveaPanel.setBackground(Color.blue);
        center.add(panNouveaPanel, BorderLayout.CENTER);

        JLabel label16 = new JLabel();

        Component C = panNouveaPanel.add(label16);
        label16.setFont(new java.awt.Font("Tahoma", 0, 36));
        label16.setText("Voici l'emploi du temps cette semaine ");

        button54.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                center.removeAll();
                center.add(panNouveauPanel);
                center.revalidate();
                center.repaint();
                center.setVisible(true);
            }
        });
        button53.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                center.removeAll();
                center.add(panNouveaPanel);
                center.revalidate();
                center.repaint();
                center.setVisible(true);
            }
        });

        //On ajoute les 4 panels au content pane de la JFrame
        // Au centre
        this.getContentPane().add(center, BorderLayout.CENTER);
        // En haut
        this.getContentPane().add(topPanel, BorderLayout.NORTH);
        // À droite
        this.getContentPane().add(rightPanel, BorderLayout.WEST);
        // En bas
        this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        ReferentPedagogiqueVue mylayout = new ReferentPedagogiqueVue("Accueil");
        mylayout.setVisible(true);
    }

}          