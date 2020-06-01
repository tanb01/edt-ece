package vue;

/**
 * Classe EtudiantVue qui permet d'afficher la vue d'un étudiant qui a le droit
 * uniquement de voir son emploi du temps. Il peut filtrer selon ses cours,
 * selon ses types de cours, ses professeurs, etc...
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

public class EnseignantVue extends JFrame {

    private String titrePage = null;
    private JTabbedPane onglet;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JTable jTable2;
    private JComboBox listeSelectionVue = null;

    private JScrollPane scroll;
    private DefaultTableModel model;

    /**
     *
     * @param title
     */
    public EnseignantVue(String title) {

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
        button53.setPreferredSize(new Dimension(265, 120));

        JButton button54 = new JButton("<html> Salles <br>"
                + " libres <br> </html>");
        JButton button55 = new JButton("<html> Modifier un<br>"
                + " Cours<br> </html>");
        JButton button56 = new JButton("<html> Modifier une<br>"
                + " seance<br> </html>");
        JButton button57 = new JButton("<html> Modifier un<br>"
                + " groupe<br> </html>");
        JButton button58 = new JButton("<html> Modifier un<br>"
                + " enseignant<br> </html>");
        JButton button59 = new JButton("Comment utiliser l'apllication?");

        // Police Times New Roman
        Font f = new Font("Times New Roman", Font.BOLD, 30);
        UIManager.put("JButton.font", f);

        // Couleur et polices
        button53.setBackground(new java.awt.Color(147, 212, 250));
        button53.setFont(f);
        button54.setBackground(new java.awt.Color(252, 222, 1));
        button54.setFont(f);
        button55.setBackground(new java.awt.Color(252, 108, 1));
        button55.setFont(f);
        button56.setBackground(new java.awt.Color(52, 108, 180));
        button56.setFont(f);
        button57.setBackground(new java.awt.Color(250, 0, 28));
        button57.setFont(f);
        button58.setBackground(new java.awt.Color(250, 0, 28));
        button58.setFont(f);

        button54.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ensemble des actions

            }
        });

        // Conteneur principal
        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout(8, 6));
        mainContainer.setBackground(Color.yellow);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.GREEN));

        // Panel du haut
        JPanel topPanel = new JPanel();
        topPanel.setBorder(new LineBorder(Color.BLACK, 5));
        topPanel.setBackground(new java.awt.Color(147, 212, 250));
        topPanel.setLayout(new FlowLayout(5));
        mainContainer.add(topPanel, BorderLayout.NORTH);

        // Barre de menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("COURS");
        JMenu menu1 = new JMenu("ETUDIANTS");
        JMenu menu2 = new JMenu("PROMOTIONS");
        JMenu menu3 = new JMenu("ENSEIGNANTS");
        JMenu menu4 = new JMenu("SALLES");

        // Nouvelle police (autre taille de police)
        Font g = new Font("Times New Roman", Font.BOLD, 18);
        UIManager.put("JMenu.font", g);
        menu.setFont(g);
        menu1.setFont(g);
        menu2.setFont(g);
        menu3.setFont(g);
        menu4.setFont(g);

        // Déclaration des items du menu
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

        // Nouvelle police (autre taille de police)
        Font h = new Font("Times New Roman", Font.BOLD, 14);
        UIManager.put("JMenuItem.font", h);
        m.setFont(h);
        m1.setFont(h);
        m2.setFont(h);
        mi1.setFont(h);
        mi2.setFont(h);
        mi3.setFont(h);
        mi4.setFont(h);
        ms1.setFont(h);
        ms2.setFont(h);
        ms3.setFont(h);
        ms4.setFont(h);

        // Ajout des items du menu sur la fenêtre déclarés ci-dessus
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

        // Ajout de la barre de menu
        topPanel.add(menuBar);

        // Panel de droite
        JPanel rightPanel = new JPanel();
        rightPanel.setBorder(new LineBorder(Color.BLACK, 5));
        rightPanel.setBackground(new java.awt.Color(211, 212, 250));
        rightPanel.setLayout(new FlowLayout(5));

        // Grille
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(6, 1, 5, 5));
        gridPanel.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel.setBackground(new java.awt.Color(255, 255, 255));

        gridPanel.add(button53);
        gridPanel.add(button54);
        gridPanel.add(button55);
        gridPanel.add(button56);
        gridPanel.add(button57);
        gridPanel.add(button58);

        rightPanel.add(gridPanel);
        mainContainer.add(rightPanel, BorderLayout.WEST);

        // Panel du centre
        JPanel center = new JPanel();
        center.setOpaque(true);
        center.setBorder(new LineBorder(Color.BLACK, 3));
        center.setLayout(new FlowLayout(5));
        center.setBackground(new java.awt.Color(211, 212, 250));
        mainContainer.add(center, BorderLayout.CENTER);

        JPanel MyPanel1 = new JPanel();

        // Grille
        JPanel gridPanel3 = new JPanel();
        gridPanel3.setLayout(new GridLayout(1, 2, 5, 5));
        gridPanel3.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel3.setBackground(new java.awt.Color(145, 200, 100));

        gridPanel3.add(MyPanel1);
        center.add(gridPanel3, BorderLayout.NORTH);

        JPanel gridPanel5 = new JPanel();
        gridPanel5.setLayout(new GridLayout(1, 1, 5, 5));
        gridPanel5.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel5.setBackground(new java.awt.Color(145, 200, 100));

        JLabel labelVue = new JLabel("-  Vue ");
        String[] selectionVue = {"en grille", "en liste"};

        JComboBox listeSelectionVue = new JComboBox(selectionVue);

        gridPanel5.add(labelVue);
        gridPanel5.add(listeSelectionVue);

        JLabel labelFiltre = new JLabel(" - Filtrer par ");
        String[] selectionFiltre = {"Matière", "Groupe"};
        JComboBox listeSelectionFiltre = new JComboBox(selectionFiltre);

        gridPanel5.add(labelFiltre);
        gridPanel5.add(listeSelectionFiltre);

        String[] selectionChamp = {"Segado", "Daachi"};
        JComboBox listeSelectionChamp = new JComboBox(selectionChamp);

        gridPanel5.add(listeSelectionChamp);
        center.add(gridPanel5, BorderLayout.NORTH);

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

        //innerContainer.add(semaineEDT, BorderLayout.WEST);
        jScrollPane1 = new JScrollPane();
//        jTable1 = new JTable();
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//
//        // Ajout de la grille de l'emploi du temps
//        jTable1.setModel(new DefaultTableModel(
//                new Object[][]{
//                    {"8h30-10h00", null, null, null, null, null, null, null},
//                    {"10h15-11h45", null, null, null, null, null, null, null},
//                    {"12h00-13h30", null, null, null, null, null, null, null},
//                    {"13h45-15h00", null, null, null, null, null, null, null},
//                    {"15h15-16h45", null, null, null, null, null, null, null},
//                    {"17h00-18h45", null, null, null, null, null, null, null},
//                    {"19h00-20h30", null, null, null, null, null, null, null}
//                },
//                new String[]{
//                    " ", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"
//                }
//        ));
//        jScrollPane1.setViewportView(jTable1);
//        jTable1.setPreferredScrollableViewportSize(new Dimension(2500, 1460));
//        jTable1.setRowHeight(210);
//        TableColumn col = jTable1.getColumnModel().getColumn(0);
//        col.setPreferredWidth(100);
//        col = jTable1.getColumnModel().getColumn(1);
//        col.setPreferredWidth(300);
//        col = jTable1.getColumnModel().getColumn(2);
//        col.setPreferredWidth(300);
//        col = jTable1.getColumnModel().getColumn(3);
//        col.setPreferredWidth(300);
//        col = jTable1.getColumnModel().getColumn(4);
//        col.setPreferredWidth(300);
//        col = jTable1.getColumnModel().getColumn(5);
//        col.setPreferredWidth(300);
//        col = jTable1.getColumnModel().getColumn(6);
//        col.setPreferredWidth(300);
//        col = jTable1.getColumnModel().getColumn(7);
//        col.setPreferredWidth(300);

        /// jTable2 : Vue en liste
        jTable2 = new JTable();

        jTable2.setModel(new DefaultTableModel(
                new Object[][]{
                    {"8h30-10h00", null, null, null, null, null, null},
                    {"10h15-11h45", null, null, null, null, null, null},
                    {"12h00-13h30", null, null, null, null, null, null},
                    {"13h45-15h00", null, null, null, null, null, null},
                    {"15h15-16h45", null, null, null, null, null, null},
                    {"17h00-18h45", null, null, null, null, null, null},
                    {"19h00-20h30", null, null, null, null, null, null}
                },
                new String[]{
                    " "
                }
        ));
        jScrollPane1.setViewportView(jTable2);
        jTable2.setPreferredScrollableViewportSize(new Dimension(1590, 720));//2860,1450
        jTable2.setRowHeight(100);
        Font j = new Font("Times New Roman", Font.BOLD, 30);
        UIManager.put("JTable.font", j);

        TableColumn col2 = jTable2.getColumnModel().getColumn(0);
        col2.setPreferredWidth(100);
//        col2 = jTable2.getColumnModel().getColumn(1);
//        col2.setPreferredWidth(300);
//        col2 = jTable2.getColumnModel().getColumn(2);
//        col2.setPreferredWidth(300);
//        col2 = jTable2.getColumnModel().getColumn(3);
//        col2.setPreferredWidth(300);
//        col2 = jTable2.getColumnModel().getColumn(4);
//        col2.setPreferredWidth(300);
//        col2 = jTable2.getColumnModel().getColumn(5);
//        col2.setPreferredWidth(300);
//        col2 = jTable2.getColumnModel().getColumn(6);
//        col2.setPreferredWidth(300);
//        col2 = jTable2.getColumnModel().getColumn(7);
//        col2.setPreferredWidth(300);

        // Panel
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
        label15.setText("Voici l'emploie du temps de cette Semaine ");

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
        label16.setText("Voici l'emploie du temps cette Semaine ");

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

        // On ajoute les 4 panels au content pane de la JFrame
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
     * Mise à jour de la vue (en Liste ou en Grille)
     *
     * @param m
     */
    public void updateVue(TableModel m) {
        //jTable1.setModel(m);
        jTable2.setModel(m);
    }

    /**
     *
     * @return
     */
    public JComboBox getJComboBoxSelectionVue() {
        return listeSelectionVue;
    }

    /**
     *
     * @param j
     */
    public void setJComboBoxSelectionVue(int j) {
        listeSelectionVue.setSelectedIndex(j);
    }

    /**
     *
     * @return
     */
    public JTable getJTable() {
        return jTable1;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        EnseignantVue mylayout = new EnseignantVue("Accueil");
        mylayout.setVisible(true);

    }

}
