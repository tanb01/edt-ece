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

public class EtudiantVue extends JFrame {

    private String titrePage = null;
    private JScrollPane jscrollPanel;
    private JTable tableEnGrille;
    private JTable tableEnListe;
    private JComboBox listeSelectionVue = null;
    private JButton button53 = null;
    private JButton button54 = null;
    private JButton button60 = null;
    private JPanel center = null;
    private JPanel sallesLibresPanel = null;
    private JPanel reportingPanel = null;
    private JPanel filtrePanel = null;
    private JPanel semainesPanel = null;

    /**
     *
     * @param title
     */
    public EtudiantVue(String title) {

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
        button53 = new JButton("Emploi du temps");
        button53.setPreferredSize(new Dimension(265, 120));

        button54 = new JButton("<html> Salles libres <br> </html>");
        button60 = new JButton("<html> Reporting <br> </html>");
//        JButton button55 = new JButton("<html> Modifier un cours<br> </html>");
//        JButton button56 = new JButton("<html> Modifier une seance<br> </html>");
//        JButton button57 = new JButton("<html> Modifier un groupe<br> </html>");
//        JButton button58 = new JButton("<html> Modifier un enseignant<br> </html>");
//        JButton button59 = new JButton("Comment utiliser l'apllication?");

        // Police Times New Roman
        Font f = new Font("Times New Roman", Font.BOLD, 30);
        UIManager.put("JButton.font", f);

        // Couleur et polices
        button53.setBackground(new java.awt.Color(147, 212, 250));
        button53.setFont(f);
        button54.setBackground(new java.awt.Color(252, 222, 1));
        button54.setFont(f);
        button60.setBackground(new java.awt.Color(252, 222, 1));
        button60.setFont(f);
//        button55.setBackground(new java.awt.Color(252, 108, 1));
//        button55.setFont(f);
//        button56.setBackground(new java.awt.Color(52, 108, 180));
//        button56.setFont(f);
//        button57.setBackground(new java.awt.Color(250, 0, 28));
//        button57.setFont(f);
//        button58.setBackground(new java.awt.Color(250, 0, 28));
//        button58.setFont(f);

        button54.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ensemble des actions

            }
        });
        button60.addActionListener(new ActionListener() {
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
        gridPanel.add(button60);
//        gridPanel.add(button55);
//        gridPanel.add(button56);
//        gridPanel.add(button57);
//        gridPanel.add(button58);

        rightPanel.add(gridPanel);
        mainContainer.add(rightPanel, BorderLayout.WEST);

        // Panel du centre
        center = new JPanel();
        center.setOpaque(true);
        center.setBorder(new LineBorder(Color.BLACK, 3));
        center.setLayout(new FlowLayout(5));
        center.setBackground(new java.awt.Color(211, 212, 250));
        mainContainer.add(center, BorderLayout.CENTER);

        semainesPanel = new JPanel();
        semainesPanel.setLayout(new GridLayout(2, 1, 5, 5));
        semainesPanel.setBorder(new LineBorder(Color.BLACK, 3));

        center.add(semainesPanel);

        filtrePanel = new JPanel();
        filtrePanel.setLayout(new GridLayout(1, 1, 5, 5));
        filtrePanel.setBorder(new LineBorder(Color.BLACK, 3));
        filtrePanel.setBackground(new java.awt.Color(145, 200, 100));

        JLabel labelVue = new JLabel("-  Vue ");
        String[] selectionVue = {"en grille", "en liste"};

        listeSelectionVue = new JComboBox(selectionVue);

        filtrePanel.add(labelVue);
        filtrePanel.add(listeSelectionVue);

        JLabel labelFiltre = new JLabel(" - Filtrer par ");
        String[] selectionFiltre = {"Nom enseignant(e)", "Matière"};
        JComboBox listeSelectionFiltre = new JComboBox(selectionFiltre);

        filtrePanel.add(labelFiltre);
        filtrePanel.add(listeSelectionFiltre);

        String[] selectionChamp = {"Segado", "Daachi"};
        JComboBox listeSelectionChamp = new JComboBox(selectionChamp);

        filtrePanel.add(listeSelectionChamp);
        center.add(filtrePanel, BorderLayout.NORTH);

        semainesPanel.add(button1);
        semainesPanel.add(button2);
        semainesPanel.add(button3);
        semainesPanel.add(button4);
        semainesPanel.add(button5);
        semainesPanel.add(button6);
        semainesPanel.add(button7);
        semainesPanel.add(button8);
        semainesPanel.add(button9);
        semainesPanel.add(button10);
        semainesPanel.add(button11);
        semainesPanel.add(button12);
        semainesPanel.add(button13);
        semainesPanel.add(button14);
        semainesPanel.add(button15);
        semainesPanel.add(button16);
        semainesPanel.add(button17);
        semainesPanel.add(button18);
        semainesPanel.add(button19);
        semainesPanel.add(button20);
        semainesPanel.add(button21);
        semainesPanel.add(button22);
        semainesPanel.add(button23);
        semainesPanel.add(button24);
        semainesPanel.add(button25);
        semainesPanel.add(button26);
        semainesPanel.add(button27);
        semainesPanel.add(button28);
        semainesPanel.add(button29);
        semainesPanel.add(button30);
        semainesPanel.add(button31);
        semainesPanel.add(button32);
        semainesPanel.add(button33);
        semainesPanel.add(button34);
        semainesPanel.add(button35);
        semainesPanel.add(button36);
        semainesPanel.add(button37);
        semainesPanel.add(button38);
        semainesPanel.add(button39);
        semainesPanel.add(button40);
        semainesPanel.add(button41);
        semainesPanel.add(button42);
        semainesPanel.add(button43);
        semainesPanel.add(button44);
        semainesPanel.add(button45);
        semainesPanel.add(button46);
        semainesPanel.add(button47);
        semainesPanel.add(button48);
        semainesPanel.add(button49);
        semainesPanel.add(button50);
        semainesPanel.add(button51);
        semainesPanel.add(button52);

        //innerContainer.add(semaineEDT, BorderLayout.WEST);
        jscrollPanel = new JScrollPane();
        tableEnGrille = new JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Ajout de la grille de l'emploi du temps
        tableEnGrille.setModel(new DefaultTableModel(
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
        jscrollPanel.setViewportView(tableEnGrille);
        tableEnGrille.setPreferredScrollableViewportSize(new Dimension(1590, 720));//2500, 1460
        tableEnGrille.setRowHeight(105);
        TableColumn col = tableEnGrille.getColumnModel().getColumn(0);
        col.setPreferredWidth(125);
        col = tableEnGrille.getColumnModel().getColumn(1);
        col.setPreferredWidth(300);
        col = tableEnGrille.getColumnModel().getColumn(2);
        col.setPreferredWidth(300);
        col = tableEnGrille.getColumnModel().getColumn(3);
        col.setPreferredWidth(300);
        col = tableEnGrille.getColumnModel().getColumn(4);
        col.setPreferredWidth(300);
        col = tableEnGrille.getColumnModel().getColumn(5);
        col.setPreferredWidth(300);
        col = tableEnGrille.getColumnModel().getColumn(6);
        col.setPreferredWidth(300);
        col = tableEnGrille.getColumnModel().getColumn(7);
        col.setPreferredWidth(300);

        // Panel
        center.add(jscrollPanel, BorderLayout.SOUTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.setBackground(new java.awt.Color(200, 100, 200));
        bottomPanel.setBorder(new LineBorder(Color.BLACK, 3));
        mainContainer.add(bottomPanel, BorderLayout.SOUTH);

        this.setLayout(new BorderLayout());
        sallesLibresPanel = new JPanel();
        sallesLibresPanel.setOpaque(true);
        sallesLibresPanel.setBorder(new LineBorder(Color.BLACK, 3));
        sallesLibresPanel.setLayout(new FlowLayout(5));
        sallesLibresPanel.setBackground(Color.blue);
        center.add(sallesLibresPanel, BorderLayout.CENTER);

        JLabel label15 = new JLabel();
        mainContainer.add(label15, BorderLayout.CENTER);
        sallesLibresPanel.add(label15);
        label15.setFont(new java.awt.Font("Tahoma", 0, 36));
        label15.setText("Salles Libres");

        this.setLayout(new BorderLayout());

        reportingPanel = new JPanel();
        reportingPanel.setOpaque(true);
        reportingPanel.setBorder(new LineBorder(Color.BLACK, 3));
        reportingPanel.setLayout(new FlowLayout(5));
        reportingPanel.setBackground(Color.blue);
        center.add(reportingPanel, BorderLayout.CENTER);

        JLabel label16 = new JLabel();
        reportingPanel.add(label16);
        label16.setFont(new java.awt.Font("Tahoma", 0, 36));
        label16.setText("Reporting");

        // On ajoute les 4 panels au content pane de la JFrame
        // Au centre
        this.getContentPane().add(center, BorderLayout.CENTER);
        // En haut
        this.getContentPane().add(topPanel, BorderLayout.NORTH);
        // À droite
        this.getContentPane().add(rightPanel, BorderLayout.WEST);
        // En bas
        this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        showEmploiDuTemps();

    }

    /**
     * Mise à jour de la vue (en Liste ou en Grille)
     *
     * @param m
     */
    public JButton getBoutonEmploiDuTemps() {
        return button53;
    }

    public JButton getBoutonSallesLibres() {
        return button54;
    }

    public JButton getBoutonReporting() {
        return button60;
    }

    public void showEmploiDuTemps() {
        center.removeAll();
        center.add(semainesPanel);
        semainesPanel.setVisible(true);
        center.add(filtrePanel);
        filtrePanel.setVisible(true);
        center.add(jscrollPanel);
        center.revalidate();
        center.repaint();
    }

    public void showSallesLibres() {
        center.removeAll();
        center.add(sallesLibresPanel);
        center.revalidate();
        center.repaint();
    }

    public void showReporting() {
        center.removeAll();
        center.add(reportingPanel);
        center.revalidate();
        center.repaint();
    }

    public void setTableEnGrille(TableModel m) {
        tableEnGrille.setModel(m);
    }

//    public void updateVue2(TableModel m) {
//        //jTable1.setModel(m);
//        jTable2.setModel(m);
//    }
    public void changeToEDT() {
        center.removeAll();
        //center.add(panNouveaPanel);
        center.revalidate();
        center.repaint();
        center.setVisible(true);
    }

    public void changeAVueEnGrille(TableModel m) {
        tableEnGrille.setModel(m);
        jscrollPanel.setViewportView(tableEnGrille);
        tableEnGrille.setPreferredScrollableViewportSize(new Dimension(1590, 720));//2860,1450
        tableEnGrille.setRowHeight(100);
        Font j = new Font("Times New Roman", Font.BOLD, 30);
        UIManager.put("JTable.font", j);
    }

    public void changeAVueEnListe(TableModel m) {
        /// jTable2 : Vue en liste
        tableEnListe = new JTable();

        tableEnListe.setModel(new DefaultTableModel(
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
        jscrollPanel.setViewportView(tableEnListe);
        tableEnListe.setPreferredScrollableViewportSize(new Dimension(1590, 720));//2860,1450
        tableEnListe.setRowHeight(100);
        Font j = new Font("Times New Roman", Font.BOLD, 30);
        UIManager.put("JTable.font", j);

        TableColumn col2 = tableEnListe.getColumnModel().getColumn(0);
        col2.setPreferredWidth(100);
        tableEnListe.setModel(m);
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
        return tableEnGrille;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        EtudiantVue mylayout = new EtudiantVue("Accueil");
        mylayout.setVisible(true);
    }

}
