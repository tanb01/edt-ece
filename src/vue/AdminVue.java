package vue;

/**
 * Classe AdminVue qui permet d'afficher la vue d'un administrateur qui a le
 * droit de modifier tout dans l'emploi du temps.
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
import controleur.Reporting;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.TableColumn;

public class AdminVue extends JFrame {

    private String titrePage = null;
    private JTabbedPane onglet;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private JScrollPane scroll;
    private JTable tableSalles;
    private DefaultTableModel model;
    private JButton button53, button54, button55, button56, button57, button58;
    private JPanel center = null;
    private JPanel centersalleslibres = null;
    private JPanel MyPanel1;
    private JPanel sallesLibresPanel = null;
    private JPanel reportingPanel = null;
    private JPanel centerajoutseance;
    private JScrollPane jscrollPanel;
    private JTable tableEnGrille;
    private JTable tableEnListe;
    private JComboBox listeSelectionVue = null;
    private JComboBox listeSelectionFiltre = null;
    private JComboBox listeSelectionChamp = null;
    private JPanel Modifierseance;
    private final JButton searchFiltre = null;
    private final JTextField searchFilterField = null;
    private JPanel centerReca;
    private JPanel gridPanelb;
    private final JPanel filtrePanel = null;
    private JPanel semainesPanel = null;
    private ArrayList<JButton> boutons = null;

    /**
     *
     * @param title
     */
    public AdminVue(String title) {

        // Affiche le titre en haut de la fenêtre
        super(title);
        // Taille de la fenêtre
        this.setSize(2750, 1600);
        // Localisation de la fenêtre
        this.setLocation(100, 100);
        // Fermeture et arrêt du programme dès qu'on ferme la fenêtre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Déclaration de tous les boutons grâce à JButton
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // Déclaration de tous les boutons grâce à JButton
        boutons = new ArrayList<JButton>();
        for (int i = 1; i < 53; i++) {
            boutons.add(new JButton(String.valueOf(i)));
        }
        button53 = new JButton("<html>Emploi du<br> temps<html>");
        button53.setPreferredSize(new Dimension(130, 100));
        button53.setIcon(new ImageIcon("img/school.png"));

        button54 = new JButton("<html> Salles <br>libres </html>");
        button54.setIcon(new ImageIcon("img/project.png"));

        button55 = new JButton("<html> Ajouter une<br> seance</html>");
        button55.setIcon(new ImageIcon("img/modification.png"));
        button56 = new JButton("<html> Reporting </html>");
        button56.setIcon(new ImageIcon("img/result.png"));
        button57 = new JButton("<html> Modifier une <br> séance </html>");
        button57.setIcon(new ImageIcon("img/notepad.png"));
        button58 = new JButton("<html> Historique de <br> modifications </html>");
        button58.setIcon(new ImageIcon("img/history.png"));

        // Couleur et polices
        Font f = new Font("Times New Roman", Font.BOLD, 16);
        UIManager.put("JButton.font", f);

        // Couleur et polices
        button53.setBackground(new java.awt.Color(255, 255, 0));
        button53.setFont(f);
        button54.setBackground(new java.awt.Color(182, 213, 56));
        button54.setFont(f);
        button55.setBackground(new java.awt.Color(252, 108, 1));
        button55.setFont(f);
        button56.setBackground(new java.awt.Color(243, 151, 150));
        button56.setFont(f);
        button57.setBackground(new java.awt.Color(143, 151, 150));
        button57.setFont(f);
        button58.setBackground(new java.awt.Color(253, 121, 130));
        button58.setFont(f);

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

        // Nouvelle police (autre taille de police)
        Font g = new Font("Times New Roman", Font.BOLD, 18);
        UIManager.put("JMenu.font", g);
        menu.setFont(g);
        menu1.setFont(g);
        menu2.setFont(g);
        menu3.setFont(g);

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
        center = new JPanel();
        center.setOpaque(true);
        center.setBorder(new LineBorder(Color.BLACK, 3));
        center.setLayout(new FlowLayout(5));
        center.setBackground(new java.awt.Color(211, 212, 250));
        mainContainer.add(center, BorderLayout.CENTER);

        semainesPanel = new JPanel();
        semainesPanel.setLayout(new GridLayout(2, 1, 1, 1));
        semainesPanel.setBorder(new LineBorder(Color.BLACK, 2));

        // Grille
        JPanel gridPanel3 = new JPanel();
        gridPanel3.setLayout(new GridLayout(1, 2, 5, 5));
        gridPanel3.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel3.setBackground(new java.awt.Color(145, 200, 100));

        gridPanel3.add(semainesPanel);
        center.add(gridPanel3, BorderLayout.NORTH);

        JPanel topIPanel = new JPanel();
        topIPanel.setBorder(new LineBorder(Color.BLACK, 3));
        topIPanel.setBackground(Color.yellow);
        topIPanel.setFont(new java.awt.Font("Perpetua Titling MT", 0, 48));
        topIPanel.setLayout(new FlowLayout(3));

        JPanel gridPanel5 = new JPanel();
        gridPanel5.setLayout(new GridLayout(1, 1, 5, 5));
        gridPanel5.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel5.setBackground(new java.awt.Color(145, 200, 100));

        JLabel labelVue = new JLabel("  GROUPE ");
        String[] selectionVue = {"Gr01", "Gr02", "Gr03", "Gr04", "Gr05", "Gr06", "Gr07", "Gr08", "Gr09", "Gr10", "Gr11"};

        JComboBox listeSelectionVue = new JComboBox(selectionVue);

        gridPanel5.add(labelVue);
        gridPanel5.add(listeSelectionVue);

        JLabel labelFiltre = new JLabel("  PROMO ");
        String[] selectionFiltre = {" Prepac", "Ing1", "Ing2", "Ing3", "Ing4", "Ing5"};
        JComboBox listeSelectionFiltre = new JComboBox(selectionFiltre);

        JLabel labelFiltre2 = new JLabel(" - PROMO ");
        String[] selectionFiltre2 = {" "};
        JComboBox listeSelectionFiltre2 = new JComboBox(selectionFiltre);

        gridPanel5.add(labelFiltre);
        gridPanel5.add(listeSelectionFiltre);

        center.add(gridPanel5, BorderLayout.NORTH);
        Font fG = new Font("Times New Roman", Font.BOLD, 12);
        UIManager.put("JButton.font", fG);

        for (JButton bouton : boutons) {
            semainesPanel.add(bouton);
            bouton.setPreferredSize(new Dimension(46, 25));
            bouton.setFont(fG);
            bouton.setBackground(new java.awt.Color(254, 254, 254));

        }

        // Ajout de la grille de l'emploi du temps
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
        tableEnGrille.setPreferredScrollableViewportSize(new Dimension(1610, 740));//2500, 1460
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
//-----------------------------------------------------------------------------
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.setBackground(new java.awt.Color(249, 207, 192));
        bottomPanel.setBorder(new LineBorder(Color.BLACK, 3));
        mainContainer.add(bottomPanel, BorderLayout.SOUTH);

        JPanel gridPanel2 = new JPanel();
        gridPanel2.setLayout(new GridLayout(1, 3, 950, 5));
        gridPanel2.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel2.setBackground(new java.awt.Color(249, 207, 192));

        JLabel P1 = new JLabel("Tableau des enseignants");
        JLabel P2 = new JLabel("Tableau des seances");
        JLabel P3 = new JLabel("Tableau des Cours");

        Font r = new Font("Times New Roman", Font.BOLD, 24);
        UIManager.put("JLabel.font", r);
        P1.setFont(r);
        P2.setFont(r);
        P3.setFont(r);

        gridPanel2.add(P1, BorderLayout.PAGE_END);
        gridPanel2.add(P2, BorderLayout.PAGE_END);
        gridPanel2.add(P3, BorderLayout.PAGE_END);

        bottomPanel.add(gridPanel2, BorderLayout.SOUTH);

        JPanel gridPanel6 = new JPanel();
        gridPanel6.setLayout(new GridLayout(1, 3, 1050, 5));
        gridPanel6.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel6.setBackground(new java.awt.Color(249, 242, 155));

        List listeDeProfs = new java.awt.List(30, false);
        List listeDeSalles = new java.awt.List(30, false);
        List listeDeCours = new java.awt.List(30, false);

        gridPanel6.add(listeDeProfs);
        gridPanel6.add(listeDeSalles);
        gridPanel6.add(listeDeCours);

        bottomPanel.add(gridPanel6, BorderLayout.CENTER);

//------------------------------------------------------------------------------
//                           PANEL DE SALLES LIBRES
//------------------------------------------------------------------------------
        this.setLayout(new BorderLayout());
        sallesLibresPanel = new JPanel();
        sallesLibresPanel.setOpaque(true);
        sallesLibresPanel.setBorder(new LineBorder(Color.BLACK, 3));
        sallesLibresPanel.setLayout(new FlowLayout(5));
        sallesLibresPanel.setBackground(Color.blue);
        ajoutDuPanelSallesLibres();
//        center.add(sallesLibresPanel, BorderLayout.CENTER);

//        JLabel label15 = new JLabel();
//        mainContainer.add(label15, BorderLayout.CENTER);
//        sallesLibresPanel.add(label15);
//        label15.setFont(new java.awt.Font("Tahoma", 0, 36));
//        label15.setText("Salles Libres");
        this.setLayout(new BorderLayout());

        reportingPanel = new JPanel();
        reportingPanel.setOpaque(true);
        reportingPanel.setBorder(new LineBorder(Color.BLACK, 3));
        reportingPanel.setLayout(new FlowLayout(5));
        reportingPanel.setBackground(new java.awt.Color(254, 254, 254));
        ajoutDuPanelReporting();
        center.add(reportingPanel);
//        center.add(reportingPanel, BorderLayout.CENTER);
        
        centerajoutseance = new JPanel();
        centerajoutseance.setOpaque(true);
        centerajoutseance.setBorder(new LineBorder(Color.BLACK, 3));
        centerajoutseance.setLayout(new FlowLayout(5));
        centerajoutseance.setBackground(new java.awt.Color(254, 254, 254));
        ajoutDeseances();
        
        
        Modifierseance = new JPanel();
        Modifierseance.setOpaque(true);
        Modifierseance.setBorder(new LineBorder(Color.BLACK, 3));
        Modifierseance.setLayout(new FlowLayout(5));
        Modifierseance.setBackground(new java.awt.Color(254, 254, 254));
        Modifierseance();

        centerReca = new JPanel();
        centerReca.setOpaque(true);
        centerReca.setBorder(new LineBorder(Color.BLACK, 3));
        centerReca.setLayout(new FlowLayout(5));
       centerReca.setBackground(new java.awt.Color(254, 254, 254));
        ModifierRecapitulatif();
        
        // On ajoute les 4 panels au content pane de la JFrame
        // Au centre
        this.getContentPane().add(center, BorderLayout.CENTER);
        // En haut
        this.getContentPane().add(topPanel, BorderLayout.NORTH);
        // À droite
        this.getContentPane().add(rightPanel, BorderLayout.WEST);
        // En bas

    }

    /**
     * Mise à jour de la vue (en Liste ou en Grille)
     *
     * @param index
     */
////////////////////////////////////////////////////////////////////////////////    
    public void selectSemaine(int index) {
        //boutons.get(index).setText("X");
        center.revalidate();
        center.repaint();
    }

    public JButton getButtonSearchFiltre() {
        return searchFiltre;
    }

    public String getFiltreField() {
        return searchFilterField.getText();
    }

    public JTextField getFiltre() {
        return searchFilterField;
    }

    public ArrayList<JButton> getBoutonsSemaine() {
        return boutons;
    }

    public JButton getBoutonSemaine(int i) {
        JButton boutonRecherche = new JButton();
        for (JButton bouton : boutons) {
            if (bouton.getText().equals(String.valueOf(i))) {
                boutonRecherche = bouton;
            }
        }
        return boutonRecherche;
    }

    public JButton getBoutonEmploiDuTemps() {
        return button53;
    }

    public JButton getBoutonSallesLibres() {
        return button54;
    }

    public JButton getBoutonReporting() {
        return button56;
    }

    public JButton getBoutonModifier() {
        return button57;
    }

    public JButton getBoutonAjouterSeance() {
        return button55;
    }

    public void showEmploiDuTemps() {
        center.removeAll();
        center.add(semainesPanel);
        semainesPanel.setVisible(true);
        center.add(filtrePanel);
        filtrePanel.setVisible(true);
        if (this.listeSelectionVue.getSelectedIndex() == 0) {
            jscrollPanel.setViewportView(tableEnGrille);
        } else {
            jscrollPanel.setViewportView(tableEnListe);
        }
        center.add(jscrollPanel);
        center.revalidate();
        center.repaint();
    }

    public void showSallesLibres() {
        center.removeAll();
        center.add(sallesLibresPanel);

        tableSalles = new JTable();

        tableSalles.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Salles Libres"
                }
        ));
        tableSalles.setPreferredScrollableViewportSize(new Dimension(1590, 720));//2860,1450
        tableSalles.setRowHeight(100);
        Font j = new Font("Times New Roman", Font.BOLD, 30);
        UIManager.put("JTable.font", j);

        TableColumn col2 = tableSalles.getColumnModel().getColumn(0);
        col2.setPreferredWidth(100);
        jscrollPanel.setViewportView(tableSalles);
        center.add(jscrollPanel);
        center.revalidate();
        center.repaint();
    }

    public void showReporting() {
        center.removeAll();
        center.add(reportingPanel);
        center.revalidate();
        center.repaint();
    }
    
     public void showModifierseance() {
        center.removeAll();
        center.add(Modifierseance);
        center.revalidate();
        center.repaint();
    }
    
    public void showRecapitulatif() {
        center.removeAll();
        center.add(centerReca);
        center.revalidate();
        center.repaint();
    }

    public void cleanTableEnGrille() {
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
    }

    public void setTableEnGrille(TableModel m) {
        tableEnGrille.setModel(m);
    }

    public void changeToEDT() {
        center.removeAll();
        //center.add(panNouveaPanel);
        center.revalidate();
        center.repaint();
        center.setVisible(true);
    }

    public void changeAVueSallesLibres(TableModel m) {
        tableSalles.setModel(m);
        jscrollPanel.setViewportView(tableSalles);
        tableSalles.setPreferredScrollableViewportSize(new Dimension(1590, 720));//2860,1450
        tableSalles.setRowHeight(100);
        Font j = new Font("Times New Roman", Font.BOLD, 30);
        UIManager.put("JTable.font", j);
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

    public JComboBox getJComboBoxFilterSelection() {
        return listeSelectionFiltre;
    }

    public JComboBox getJComboBoxFilterSelectionEx() {
        return listeSelectionChamp;
    }

    /**
     *
     * @param j
     */
    public void setJComboBoxSelectionVue(int j) {
        listeSelectionVue.setSelectedIndex(j);
    }

    public void setJComboBoxFilterSelection(int j) {
        listeSelectionFiltre.setSelectedIndex(j);
    }

    public void setJComboBoxFilterSelectionEx(int j) {
        listeSelectionChamp.setSelectedIndex(j);
    }

    public void setJComboBoxFilterSelectionText(String[] j) {
        listeSelectionChamp.removeAllItems();
        filtrePanel.remove(listeSelectionChamp);
        listeSelectionChamp = new JComboBox(j);
        filtrePanel.add(listeSelectionChamp);
//        DefaultComboBoxModel model = new DefaultComboBoxModel(j);
//        listeSelectionChamp.setModel(model);
        listeSelectionChamp.setSelectedIndex(1);
        listeSelectionChamp.revalidate();
        listeSelectionChamp.repaint();
        filtrePanel.revalidate();
        filtrePanel.repaint();
        center.revalidate();
        center.repaint();
    }

    /**
     *
     * @return
     */
    public JTable getJTable() {
        return tableEnGrille;
    }
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////    

    public final void ajoutDuPanelSallesLibres() {
        Font f = new Font("Times New Roman", Font.BOLD, 18);
        //UIManager.put("JButton.font", f);

        JPanel gridPanel3 = new JPanel();
        gridPanel3.setLayout(new GridLayout(1, 1, 1, 5));
        gridPanel3.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel3.setBackground(new java.awt.Color(236, 251, 134));

        Font t = new Font("Times New Roman", Font.BOLD, 18);
        UIManager.put("JLabel.font", t);

        JPanel gridPanel7 = new JPanel();
        gridPanel7.setLayout(new GridLayout(1, 2, 1, 5));
        gridPanel7.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel7.setBackground(new java.awt.Color(236, 251, 134));

        TextField enseignant = new java.awt.TextField();
        enseignant.setText(" ");
        enseignant.setBackground(new java.awt.Color(255, 172, 220));
        Font y = new Font("Times New Roman", Font.BOLD, 16);
        UIManager.put("JLabel.font", y);

        JLabel ense = new JLabel(" Capacité maximal  ");
        ense.setFont(t);
        enseignant.setFont(y);

        gridPanel7.add(ense);
        gridPanel7.add(enseignant);

        //////////////////////////////////////////////////////////
        JPanel gridPanel5 = new JPanel();
        gridPanel5.setLayout(new GridLayout(1, 2, 1, 5));
        gridPanel5.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel5.setBackground(new java.awt.Color(236, 251, 134));

        JLabel labelFiltre = new JLabel("   Heure ");
        labelFiltre.setFont(t);
        String[] selectionFiltre = {"8h30-10h00", "10h15-11h45", "12h00-13h30", "13h45-15h15", "15h30-17h00", "17h15-18h45", "19h00-20h30"};
        JComboBox listeSelectionDuree = new JComboBox(selectionFiltre);
        listeSelectionDuree.setFont(y);
        listeSelectionDuree.setBackground(new java.awt.Color(255, 172, 220));

        gridPanel5.add(labelFiltre);
        gridPanel5.add(listeSelectionDuree);

        JPanel gridPanel5f = new JPanel();
        gridPanel5f.setLayout(new GridLayout(1, 2, 1, 5));
        gridPanel5f.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel5f.setBackground(new java.awt.Color(236, 251, 134));

        JLabel fecha = new JLabel();
        fecha.setText(" Date ");
        Font ygg = new Font("Times New Roman", Font.BOLD, 16);
        UIManager.put("JLabel.font", ygg);
        fecha.setFont(ygg);

        DateFormat dateFormat = DateFormat.getInstance();
        JFormattedTextField field = new JFormattedTextField(dateFormat);
        field.setValue(new Date());
        Font yg = new Font("Times New Roman", Font.BOLD, 16);
        UIManager.put("JFormattedTextField.font", yg);
        field.setFont(yg);
        field.setBackground(new java.awt.Color(255, 172, 220));
        field.setFocusLostBehavior(JFormattedTextField.REVERT);
        gridPanel5f.add(fecha);
        gridPanel5f.add(field);

        //////////////////////////////////////////////////////////////
        JPanel gridPanel8 = new JPanel();
        gridPanel8.setLayout(new GridLayout(1, 2, 1, 5));
        gridPanel8.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel8.setBackground(new java.awt.Color(236, 251, 134));

        JLabel labelFiltre2 = new JLabel(" Site  ");
        labelFiltre2.setFont(t);
        String[] selectionFiltre2 = {"Eiffel 1", "Eiffel 2", "Eiffel 3", "Eiffel 4", "Eiffel 5", "Cnam"};
        JComboBox listeSelectionFiltre2 = new JComboBox(selectionFiltre2);
        listeSelectionFiltre2.setFont(y);
        listeSelectionFiltre2.setBackground(new java.awt.Color(255, 172, 220));

        gridPanel8.add(labelFiltre2);
        gridPanel8.add(listeSelectionFiltre2);

        //////////////////////////////////////////////////////////////
        JPanel gridPanel9 = new JPanel();
        gridPanel9.setLayout(new GridLayout(1, 1, 1, 5));
        gridPanel9.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel9.setBackground(new java.awt.Color(145, 200, 100));

        JCheckBox cb1 = new JCheckBox("Ignorer les salles ayant des demandes de réservation en cours");
        Font w = new Font("Times New Roman", Font.BOLD, 20);
        UIManager.put("JCheckBox.font", w);
        cb1.setFont(w);

        JPanel gridPanela = new JPanel();
        gridPanela.setLayout(new GridLayout(1, 2, 10, 5));
        gridPanela.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanela.setBackground(new java.awt.Color(145, 200, 100));

        JButton Montrer2 = new JButton("Valider l'affectation");
        Montrer2.setFont(f);
        Montrer2.setIcon(new ImageIcon("img/check.png"));
        Montrer2.setBackground(new java.awt.Color(251, 231, 188));

        gridPanel9.add(cb1);

        sallesLibresPanel.add(gridPanel3);
        sallesLibresPanel.add(gridPanel7);
        sallesLibresPanel.add(enseignant);
        sallesLibresPanel.add(gridPanel5);
        sallesLibresPanel.add(gridPanel5f);
        sallesLibresPanel.add(gridPanel8);
        sallesLibresPanel.add(gridPanel9);
        sallesLibresPanel.add(Montrer2);
    }

///////////////////////////////////////////////////////////////////////////////
    public final void ajoutDuPanelReporting() {

        JPanel gridPanela = new JPanel();
        gridPanela.setLayout(new GridLayout(1, 1, 10, 5));
        gridPanela.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanela.setBackground(new java.awt.Color(145, 200, 100));

        JPanel gridPanelb = new JPanel();
        gridPanelb.setLayout(new GridLayout(2, 2, 5, 5));
        gridPanelb.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanelb.setBackground(new java.awt.Color(145, 200, 100));

        Font f = new Font("Times New Roman", Font.BOLD, 30);
        UIManager.put("JButton.font", f);

        JButton Montrer2 = new JButton("<html>Capacité des salles <br> par site</html>");
        Montrer2.setFont(f);
        Montrer2.setIcon(new ImageIcon("img/a4.png"));
        Montrer2.setBackground(new java.awt.Color(163, 255, 0));
        Montrer2.setFont(f);
        gridPanelb.add(Montrer2);
        Montrer2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Montrer2MouseClicked(evt);
            }
        });

        JButton Montrer3 = new JButton("<html>Taux d'occupation <br> des salles sur une <br> période donnée</html>");
        Montrer3.setFont(f);
        Montrer3.setIcon(new ImageIcon("img/a2.png"));
        Montrer3.setBackground(new java.awt.Color(163, 150, 253));
        Montrer3.setFont(f);
        gridPanelb.add(Montrer3);
        Montrer3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Montrer3MouseClicked(evt);
            }
        });

        JButton Montrer4 = new JButton("<html>Nombre d'heures de <br> séances dans l'annee</html>");
        Montrer4.setFont(f);
        Montrer4.setIcon(new ImageIcon("img/a3.png"));
        Montrer4.setBackground(new java.awt.Color(255, 153, 5));
        Montrer4.setFont(f);
        gridPanelb.add(Montrer4);
        Montrer4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Montrer4MouseClicked(evt);
            }
        });

        JButton Montrer5 = new JButton("<html>Nombre d'heures de <br>séances par cours</html>");
        Montrer5.setFont(f);
        Montrer5.setIcon(new ImageIcon("img/a1.png"));
        Montrer5.setBackground(new java.awt.Color(255, 255, 0));
        Montrer5.setFont(f);
        Montrer5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Montrer5MouseClicked(evt);
            }
        });

        Montrer2.setPreferredSize(new Dimension(870, 485));
        Montrer3.setPreferredSize(new Dimension(870, 485));
        Montrer4.setPreferredSize(new Dimension(870, 485));
        Montrer5.setPreferredSize(new Dimension(870, 485));
        gridPanelb.add(Montrer5);

//        center.add(reportingPanel, BorderLayout.CENTER);
        JLabel label16 = new JLabel();
        reportingPanel.add(label16);
        label16.setFont(new java.awt.Font("Tahoma", 0, 36));

        reportingPanel.add(gridPanelb);

    }

    private void Montrer2MouseClicked(java.awt.event.MouseEvent evt) {
        Reporting demo = new Reporting("Reporting");
        demo.reportingCapaciteSallesParSiteHisto();
        demo.setVisible(true);

    }

    private void Montrer3MouseClicked(java.awt.event.MouseEvent evt) {
        //taux d'occupation des salles
        Reporting demo = new Reporting("Reporting");
        demo.reportingTauxOccupationSallesHisto();
        demo.setVisible(true);

    }

    private void Montrer4MouseClicked(java.awt.event.MouseEvent evt) {
        //nombre de seances dans l'annee
        Reporting demo = new Reporting("Reporting");
//        Reporting g = new Reporting("Effectif des groupes", "Nombres d'élèves par groupes");
//        g.setVisible(true);

    }

    private void Montrer5MouseClicked(java.awt.event.MouseEvent evt) {
        Reporting demo = new Reporting("Reporting");
        demo.reportingHeuresDeSeancesParCours();
        demo.setVisible(true);
    }

///////////////////////////////////////////////////////////////////////////////
//                       AJOUT DU PANEL AJOUT SEANCE
///////////////////////////////////////////////////////////////////////////////
        public final void ajoutDeseances() {
        JPanel centerajoutseance = new JPanel();
        centerajoutseance.setOpaque(true);        
        centerajoutseance.setBorder(new LineBorder(Color.BLACK, 3));
        centerajoutseance.setLayout(new FlowLayout(5));
        centerajoutseance.setBackground(new java.awt.Color(211, 212, 250));
        //mainContainer.add(centerajoutseance, BorderLayout.CENTER);
        
        Font y = new Font("Times New Roman", Font.BOLD, 30);
        UIManager.put("JLabel.font", y);
        

                
        JPanel gridPanel3 = new JPanel();
        gridPanel3.setLayout(new GridLayout(1, 1, 1, 5));
        gridPanel3.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel3.setBackground(new java.awt.Color(145, 200, 100));
        
           //URL de l'image
         String imgUrl="img/depla.png";
         ImageIcon icone = new ImageIcon(imgUrl);
        
        
        JLabel titra = new JLabel("  AJOUTER UNE SEANCE  ",icone, JLabel.CENTER);
        gridPanel3.add(titra);
        Font t = new Font("Times New Roman", Font.BOLD, 30);
        UIManager.put("JLabel.font", t);
        titra.setFont(t);
        
         
        
        JPanel gridPanel7 = new JPanel();
        gridPanel7.setLayout(new GridLayout(8, 1, 1, 5));
        gridPanel7.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel7.setBackground(new java.awt.Color(145, 200, 100));
        
        String[] selectionensegnat = {" Segado", "Espagnol", "Java", "Web Dynamique", "Probabilites et statistiques", "Thermodynamique","Reseaux","Traitement du signal","Analyse de Fourier","Analyse Financiere","Japonais","Geopolitique","Electronique fondamentale","Anthropologie","Droit du travail"};
        JComboBox listeSelectionensegnat = new JComboBox(selectionensegnat);
        listeSelectionensegnat.setFont(y);
//----------------------------------------------------
        JLabel fecha = new JLabel();
        fecha.setText(" Date ");
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        JFormattedTextField field = new JFormattedTextField(dateFormat);
        field.setValue(new Date());
        
        
        JLabel ense = new JLabel("Enseignant");
///////////////////////////////////////////////////////////////
        JLabel labelcours = new JLabel("Cours   ");
        labelcours.setFont(t);
        String[] selectioncours = {" Anglais", "Espagnol", "Java", "Web Dynamique", "Probabilites et statistiques", "Thermodynamique","Reseaux","Traitement du signal","Analyse de Fourier","Analyse Financiere","Japonais","Geopolitique","Electronique fondamentale","Anthropologie","Droit du travail"};
        JComboBox listeSelectioncours = new JComboBox(selectioncours);
        listeSelectioncours.setFont(y);
///////////////////////////////////////////////////////////////////

        JLabel labelpromo = new JLabel("Promo");
        labelpromo.setFont(t);
        String[] selectionpromo = {"Prepac", "Ing1", "Ing2", "Ing3", "Ing4", "Ing5"};
        JComboBox listeSelectionpromo = new JComboBox(selectionpromo);
        listeSelectionpromo.setFont(y);
//////////////////////////////////////////////////////////////////////
        
        JLabel labelheured = new JLabel("Début d'heure ");
        labelheured.setFont(t);
        String[] selectionFiltreheured = {"8h30-10h00", "10h15-11h45", "12h00-13h30", "13h45-15h15", "15h30-17h00", "17h15-18h45", "19h00-20h30"};
        JComboBox listeSelectionDureed = new JComboBox(selectionFiltreheured);
        listeSelectionDureed.setFont(y);
///////////////////////////////////////////////////////////////////////
        JLabel labelheuref = new JLabel("Fin d'heure ");
        labelheuref.setFont(t);
        String[] selectionFiltreheuref = {"8h30-10h00", "10h15-11h45", "12h00-13h30", "13h45-15h15", "15h30-17h00", "17h15-18h45", "19h00-20h30"};
        JComboBox listeSelectionDureef = new JComboBox(selectionFiltreheuref);
        listeSelectionDureef.setFont(y);
///////////////////////////////////////////////////////////////////////
        JLabel labeltypecours = new JLabel(" Type de cours   ");
        labeltypecours.setFont(t);
        String[] selectionFiltretypecours = {" TP", "TD", "Projet", "Soutien", "Magistral", "Interactif"};
        JComboBox listeSelectionFiltretypecours = new JComboBox(selectionFiltretypecours);
        listeSelectionFiltretypecours.setFont(y);
/////////////////////////////////////////////////////////////////////////
        JLabel labelgroupe = new JLabel("Groupe   ");
        labelgroupe.setFont(t);
        String[] selectionFiltregroupe = {"G01","G02","G03","G04","G05","G06","G07","G08","G09","G10","G11"};
        JComboBox listeSelectionFiltregroupe = new JComboBox(selectionFiltregroupe);
        listeSelectionFiltregroupe.setFont(y);
        ense.setFont(t);
        fecha.setFont(t);
        
        field.setFont(y);
        
        gridPanel7.add(ense);
        gridPanel7.add(listeSelectionensegnat);
        gridPanel7.add(fecha);
        gridPanel7.add(field);
        gridPanel7.add(labelcours);
        gridPanel7.add(listeSelectioncours);
        gridPanel7.add(labelpromo);
        gridPanel7.add(listeSelectionpromo);
        gridPanel7.add(labelheured);
        gridPanel7.add(listeSelectionDureed);
        gridPanel7.add(labelheuref);
        gridPanel7.add(listeSelectionDureef);
        gridPanel7.add(labeltypecours);
        gridPanel7.add(listeSelectionFiltretypecours);
        gridPanel7.add(labelgroupe);
        gridPanel7.add(listeSelectionFiltregroupe);
        
       
        centerajoutseance.add(gridPanel3, BorderLayout.NORTH);
        centerajoutseance.add(gridPanel7, BorderLayout.WEST);
        
 
////////////////////////////////////////////////////////////////////////////////        
        JButton valider = new JButton("Valider l'affectation");
        Font h = new Font("Times New Roman", Font.BOLD, 30);
        UIManager.put("JButton.font", h);
        valider.setFont(h);
        valider.setIcon(new ImageIcon("img/check.png"));
        valider.setBackground(new java.awt.Color(251, 231, 188));
        
        centerajoutseance.add(valider);
        }
    /**
     *
     * @return
     */
////////////////////////////////////////////////////////////////////////////////
//                MODIFICATION DE L'EMPLOIE DU TEMPS
////////////////////////////////////////////////////////////////////////////////
        public final void Modifierseance(){
        JPanel Modifierseance = new JPanel();
        Modifierseance.setOpaque(true);        
        Modifierseance.setBorder(new LineBorder(Color.BLACK, 3));
        Modifierseance.setLayout(new FlowLayout(5));
        Modifierseance.setBackground(new java.awt.Color(211, 212, 250));        
        Font y = new Font("Times New Roman", Font.BOLD, 20);
        UIManager.put("JLabel.font", y);
        

                
        JPanel gridPanel3 = new JPanel();
        gridPanel3.setLayout(new GridLayout(5, 1, 30, 10));
        gridPanel3.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel3.setBackground(new java.awt.Color(145, 200, 100));
        
           //URL de l'image
         String imgUrl="img/cali.png";
         ImageIcon icone = new ImageIcon(imgUrl);
        
        
        JLabel titra = new JLabel("MODIFIER UNE SEANCE  ",icone, JLabel.CENTER);
        gridPanel3.add(titra);
        Font t = new Font("Times New Roman", Font.BOLD, 24);
        UIManager.put("JLabel.font", t);
        titra.setFont(t);
        
           //URL de l'image
         String imgUrl2="img/order.png";
         ImageIcon icone2 = new ImageIcon(imgUrl2);
        
        JLabel titra2 = new JLabel("SELECTIONER UNE SEANCE  ",icone2, JLabel.CENTER);
        gridPanel3.add(titra2);        
        titra2.setFont(t);
        
           //URL de l'image
         String imgUrl3="img/order.png";
         ImageIcon icone3 = new ImageIcon(imgUrl3);
        
        JLabel titra3 = new JLabel("AFFECTER  ",icone3, JLabel.CENTER);
        gridPanel3.add(titra3);        
        titra3.setFont(t);
        
         String imgUrl4="img/order.png";
         ImageIcon icone4 = new ImageIcon(imgUrl4);
        
        JLabel titra4 = new JLabel("MODIFIER  ",icone4, JLabel.CENTER);
        gridPanel3.add(titra4);        
        titra4.setFont(t);
        
         String imgUrl5="img/order.png";
         ImageIcon icone5 = new ImageIcon(imgUrl5);
        
        JLabel titra5 = new JLabel("ENLEVER  ",icone5, JLabel.CENTER);
        gridPanel3.add(titra5);        
        titra5.setFont(t);       
        
         
        
        JPanel gridPanel7 = new JPanel();
        gridPanel7.setLayout(new GridLayout(22, 1, 20, 5));
        gridPanel7.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel7.setBackground(new java.awt.Color(145, 200, 100));
        
        String[] selectionensegnat = {" Segado", "Espagnol", "Java", "Web Dynamique", "Probabilites et statistiques", "Thermodynamique","Reseaux","Traitement du signal","Analyse de Fourier","Analyse Financiere","Japonais","Geopolitique","Electronique fondamentale","Anthropologie","Droit du travail"};
        JComboBox listeSelectionensegnat = new JComboBox(selectionensegnat);
        listeSelectionensegnat.setFont(y);
//----------------------------------------------------
        JLabel fecha = new JLabel();
        fecha.setText(" Date ");
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        JFormattedTextField field = new JFormattedTextField(dateFormat);
        field.setValue(new Date());
        
        
        JLabel ense = new JLabel("Enseignant");
///////////////////////////////////////////////////////////////
        JLabel labelcours = new JLabel("Cours   ");
        labelcours.setFont(t);
        String[] selectioncours = {" Anglais", "Espagnol", "Java", "Web Dynamique", "Probabilites et statistiques", "Thermodynamique","Reseaux","Traitement du signal","Analyse de Fourier","Analyse Financiere","Japonais","Geopolitique","Electronique fondamentale","Anthropologie","Droit du travail"};
        JComboBox listeSelectioncours = new JComboBox(selectioncours);
        listeSelectioncours.setFont(y);
///////////////////////////////////////////////////////////////////

        JLabel labelpromo = new JLabel("Promo");
        labelpromo.setFont(t);
        String[] selectionpromo = {"Prepac", "Ing1", "Ing2", "Ing3", "Ing4", "Ing5"};
        JComboBox listeSelectionpromo = new JComboBox(selectionpromo);
        listeSelectionpromo.setFont(y);
//////////////////////////////////////////////////////////////////////
        
        JLabel labelheured = new JLabel("Début d'heure ");
        labelheured.setFont(t);
        String[] selectionFiltreheured = {"8h30-10h00", "10h15-11h45", "12h00-13h30", "13h45-15h15", "15h30-17h00", "17h15-18h45", "19h00-20h30"};
        JComboBox listeSelectionDureed = new JComboBox(selectionFiltreheured);
        listeSelectionDureed.setFont(y);
///////////////////////////////////////////////////////////////////////
        JLabel labelheuref = new JLabel("Fin d'heure ");
        labelheuref.setFont(t);
        String[] selectionFiltreheuref = {"8h30-10h00", "10h15-11h45", "12h00-13h30", "13h45-15h15", "15h30-17h00", "17h15-18h45", "19h00-20h30"};
        JComboBox listeSelectionDureef = new JComboBox(selectionFiltreheuref);
        listeSelectionDureef.setFont(y);
///////////////////////////////////////////////////////////////////////
        JLabel labeltypecours = new JLabel(" Type de cours   ");
        labeltypecours.setFont(t);
        String[] selectionFiltretypecours = {" TP", "TD", "Projet", "Soutien", "Magistral", "Interactif"};
        JComboBox listeSelectionFiltretypecours = new JComboBox(selectionFiltretypecours);
        listeSelectionFiltretypecours.setFont(y);
/////////////////////////////////////////////////////////////////////////
        JLabel labelgroupe = new JLabel("Groupe   ");
        labelgroupe.setFont(t);
        String[] selectionFiltregroupe = {"G01","G02","G03","G04","G05","G06","G07","G08","G09","G10","G11"};
        JComboBox listeSelectionFiltregroupe = new JComboBox(selectionFiltregroupe);
        listeSelectionFiltregroupe.setFont(y);
        ense.setFont(t);
        fecha.setFont(t);
                field.setFont(y);
/////////////////////////////////////////////////////////////////////////////
        JLabel titra6 = new JLabel("Seance selectioné  ");               
        titra6.setFont(t);        
        JTextField seance = new JTextField ();
///////////////////////////////////////////////////////////////////////////////
        JLabel ensevieux1 = new JLabel("Ajouter un enseignant ");
        ensevieux1.setFont(t);
        String[] selectionensegnatv = {" Segado", "Espagnol", "Java", "Web Dynamique", "Probabilites et statistiques", "Thermodynamique","Reseaux","Traitement du signal","Analyse de Fourier","Analyse Financiere","Japonais","Geopolitique","Electronique fondamentale","Anthropologie","Droit du travail"};
        JComboBox listeSelectionensegnatv = new JComboBox(selectionensegnatv);
        listeSelectionensegnatv.setFont(y);
//---------------------------------------        
        JLabel ensevieux = new JLabel("Enseignant à remplacer ");
        ensevieux.setFont(t);
        String[] selectionensegnatr = {" Segado", "Espagnol", "Java", "Web Dynamique", "Probabilites et statistiques", "Thermodynamique","Reseaux","Traitement du signal","Analyse de Fourier","Analyse Financiere","Japonais","Geopolitique","Electronique fondamentale","Anthropologie","Droit du travail"};
        JComboBox listeSelectionensegnatr = new JComboBox(selectionensegnatr);
        listeSelectionensegnatr.setFont(y);
//---------------------------------------        
        JLabel ensenouveau = new JLabel("Nouveau Enseignant");
        ensenouveau.setFont(t);
        String[] selectionensegnatn = {" Segado", "Espagnol", "Java", "Web Dynamique", "Probabilites et statistiques", "Thermodynamique","Reseaux","Traitement du signal","Analyse de Fourier","Analyse Financiere","Japonais","Geopolitique","Electronique fondamentale","Anthropologie","Droit du travail"};
        JComboBox listeSelectionensegnatn = new JComboBox(selectionensegnatn);
        listeSelectionensegnatn.setFont(y);
//--------------------------------------------        
        JLabel groupe = new JLabel("Ajouter un groupe");
        groupe.setFont(t);
        String[] selectionFiltregroupea = {"G01","G02","G03","G04","G05","G06","G07","G08","G09","G10","G11"};
        JComboBox listeSelectionFiltregroupea = new JComboBox(selectionFiltregroupea);
        listeSelectionFiltregroupea.setFont(y);
//---------------------------------------------        
        JLabel groupe2 = new JLabel("Affecter un groupe");
        groupe2.setFont(t);
        String[] selectionFiltregroupeaf = {"G01","G02","G03","G04","G05","G06","G07","G08","G09","G10","G11"};
        JComboBox listeSelectionFiltregroupeaf = new JComboBox(selectionFiltregroupeaf);
        listeSelectionFiltregroupeaf.setFont(y);
//----------------------------------------------- 
        JLabel groupe3 = new JLabel("Groupe à remplacer");
        groupe3.setFont(t);
        String[] selectionFiltregroupeaf3 = {"G01","G02","G03","G04","G05","G06","G07","G08","G09","G10","G11"};
        JComboBox listeSelectionFiltregroupeaf3 = new JComboBox(selectionFiltregroupeaf3);
        listeSelectionFiltregroupeaf3.setFont(y);
//----------------------------------------------- 
        JLabel cours = new JLabel("Modifier un cours par son nom");
        cours.setFont(t);
        String[] selectioncoursn = {" Anglais", "Espagnol", "Java", "Web Dynamique", "Probabilites et statistiques", "Thermodynamique","Reseaux","Traitement du signal","Analyse de Fourier","Analyse Financiere","Japonais","Geopolitique","Electronique fondamentale","Anthropologie","Droit du travail"};
        JComboBox listeSelectioncoursn = new JComboBox(selectioncoursn);
        listeSelectioncoursn.setFont(y);
//----------------------------------------------        
        JLabel cours1 = new JLabel("Modifier un cours par son type");
        cours1.setFont(t);
        String[] selectionFiltretypecoursa = {" TP", "TD", "Projet", "Soutien", "Magistral", "Interactif"};
        JComboBox listeSelectionFiltretypecoursa = new JComboBox(selectionFiltretypecoursa);
        listeSelectionFiltretypecoursa.setFont(y);
//--------------------------------------------------        
        JLabel salle = new JLabel("Modifier un salle par son site");
        salle.setFont(t);
        String[] selectionFiltre2f = {"Eiffel 1", "Eiffel 2", "Eiffel 3", "Eiffel 4", "Eiffel 5", "Cnam"};
        JComboBox listeSelectionFiltre2f = new JComboBox(selectionFiltre2f);
        listeSelectionFiltre2f.setFont(y);
//-------------------------------------------------        
        JLabel salle1 = new JLabel("Modifier une salle par son nom");
        salle1.setFont(t);
        String[] selectionensegnatnom = {" Segado", "Espagnol", "Java", "Web Dynamique", "Probabilites et statistiques", "Thermodynamique","Reseaux","Traitement du signal","Analyse de Fourier","Analyse Financiere","Japonais","Geopolitique","Electronique fondamentale","Anthropologie","Droit du travail"};
        JComboBox listeSelectionensegnatnom = new JComboBox(selectionensegnatnom);
        listeSelectionensegnatnom.setFont(y);
//------------------------------------------------------        
        JLabel heure = new JLabel("Modifier l'heure d'une séance");
        heure.setFont(t);
        String[] selectionFiltreheurede = {"8h30-10h00", "10h15-11h45", "12h00-13h30", "13h45-15h15", "15h30-17h00", "17h15-18h45", "19h00-20h30"};
        JComboBox listeSelectionDureede = new JComboBox(selectionFiltreheurede);
        listeSelectionDureede.setFont(y);
//--------------------------------------------------------        
        JLabel etat = new JLabel("Changer l'état d'une seance");
        etat.setFont(t);
        String[] selectionetat = {"Valide", "En cours de validation","Non, validé"};
        JComboBox listeselectionetat = new JComboBox(selectionetat);
        listeselectionetat.setFont(y);
//--------------------------------------------------------          
        JLabel enleverense = new JLabel("Enlever un enseignant d'une séance");
        enleverense.setFont(t);
        String[] selectionensegnaten = {" Segado", "Espagnol", "Java", "Web Dynamique", "Probabilites et statistiques", "Thermodynamique","Reseaux","Traitement du signal","Analyse de Fourier","Analyse Financiere","Japonais","Geopolitique","Electronique fondamentale","Anthropologie","Droit du travail"};
        JComboBox listeSelectionensegnaten = new JComboBox(selectionensegnaten);
        listeSelectionensegnaten.setFont(y);
//--------------------------------------------------------          
        JLabel etatgroupe = new JLabel("Enlever un groupe d'une séance");
        etatgroupe.setFont(t);
        String[] selectionFiltregroupeaenle = {"G01","G02","G03","G04","G05","G06","G07","G08","G09","G10","G11"};
        JComboBox listeSelectionFiltregroupeaenle  = new JComboBox(selectionFiltregroupeaenle );
        listeSelectionFiltregroupeaenle.setFont(y);
        
        
//--------------------------------------------------------          
        
        gridPanel7.add(ense);
        gridPanel7.add(listeSelectionensegnat);
        gridPanel7.add(fecha);
        gridPanel7.add(field);
        gridPanel7.add(labelcours);
        gridPanel7.add(listeSelectioncours);
        gridPanel7.add(labelpromo);
        gridPanel7.add(listeSelectionpromo);
        gridPanel7.add(labelheured);
        gridPanel7.add(listeSelectionDureed);
        gridPanel7.add(labelheuref);
        gridPanel7.add(listeSelectionDureef);
        gridPanel7.add(labeltypecours);
        gridPanel7.add(listeSelectionFiltretypecours);
        gridPanel7.add(labelgroupe);
        gridPanel7.add(listeSelectionFiltregroupe);
        gridPanel7.add(titra6); 
        gridPanel7.add(seance);
        gridPanel7.add(ensevieux1);
        gridPanel7.add(listeSelectionensegnatv);
        gridPanel7.add(ensevieux);
        gridPanel7.add(listeSelectionensegnatr);
        gridPanel7.add(ensenouveau);
        gridPanel7.add(listeSelectionensegnatn);
        gridPanel7.add(groupe);
        gridPanel7.add(listeSelectionFiltregroupea);
        gridPanel7.add(groupe2);
        gridPanel7.add(listeSelectionFiltregroupeaf);
        gridPanel7.add(groupe3);
        gridPanel7.add(listeSelectionFiltregroupeaf3);
        gridPanel7.add(cours);
        gridPanel7.add(listeSelectioncoursn);
        gridPanel7.add(cours1);
        gridPanel7.add(listeSelectionFiltretypecoursa);
        gridPanel7.add(salle);
        gridPanel7.add(listeSelectionFiltre2f);
        gridPanel7.add(salle1);
        gridPanel7.add(listeSelectionensegnatnom);
        gridPanel7.add(etat);
        gridPanel7.add(listeselectionetat);
        gridPanel7.add(enleverense);
        gridPanel7.add(listeSelectionensegnaten);
        gridPanel7.add(etatgroupe);
        gridPanel7.add(listeSelectionFiltregroupeaenle);
        
        
//-----------------------------------------------------------------------------        
        JPanel gridPanel8 = new JPanel();
        gridPanel8.setLayout(new GridLayout(4, 1, 25, 115));
        gridPanel8.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel8.setBackground(new java.awt.Color(145, 200, 100));
        
        Font f = new Font("Times New Roman", Font.BOLD, 30);
        UIManager.put("JButton.font", f);
        
        JButton validerm = new JButton("Valider la séance");
        validerm.setFont(f);
        validerm.setIcon(new ImageIcon("img/check.png"));
        validerm.setBackground(new java.awt.Color(251, 231, 188));
        
        
        JButton valider2m = new JButton("Valider la modification");
        valider2m.setFont(f);
        valider2m.setIcon(new ImageIcon("img/check.png"));
        valider2m.setBackground(new java.awt.Color(251, 231, 188));
        
        
        JButton valider3m = new JButton("Valider le changement");
        valider3m.setFont(f);
        valider3m.setIcon(new ImageIcon("img/check.png"));
        valider3m.setBackground(new java.awt.Color(251, 231, 188));
        
        JButton valider4m = new JButton("Enlever");
        valider4m.setFont(f);
        valider4m.setIcon(new ImageIcon("img/check.png"));
        valider4m.setBackground(new java.awt.Color(251, 231, 188));
        
        gridPanel8.add(validerm);
        gridPanel8.add(valider2m);
        gridPanel8.add(valider3m);
        gridPanel8.add(valider4m);

////////////////////////////////////////////////////////////////////////////////        
        Modifierseance.add(gridPanel3, BorderLayout.NORTH);
        Modifierseance.add(gridPanel7, BorderLayout.WEST);
        Modifierseance.add(gridPanel8, BorderLayout.SOUTH);
        }
//////////////////////////////////////////////////////////////////////////// 
//                          CENTRER RECAPITULATIF        
////////////////////////////////////////////////////////////////////////////
        public final void ModifierRecapitulatif(){    
        JPanel centerReca = new JPanel();
        centerReca.setOpaque(true);        
        centerReca.setBorder(new LineBorder(Color.BLACK, 3));
        centerReca.setLayout(new FlowLayout(5));
        centerReca.setBackground(new java.awt.Color(211, 212, 250));
       

                
        JPanel gridPanel3 = new JPanel();
        gridPanel3.setLayout(new GridLayout(1, 1, 1, 5));
        gridPanel3.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel3.setBackground(new java.awt.Color(145, 200, 100));
        
        
        JLabel titra = new JLabel("  Recapitulatif de cours  entre le 1 septembre et le 30 Juin  ");
        gridPanel3.add(titra);
        Font t = new Font("Times New Roman", Font.BOLD, 24);
        UIManager.put("JLabel.font", t);
        titra.setFont(t);
        
        JPanel gridPanel7 = new JPanel();
        gridPanel7.setLayout(new GridLayout(2, 1, 1, 5));
        gridPanel7.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel7.setBackground(new java.awt.Color(145, 200, 100));
        Font y = new Font("Times New Roman", Font.BOLD, 20);
        UIManager.put("JLabel.font", y);
        
        String[] selectionensegnat = {" Segado", "Espagnol", "Java", "Web Dynamique", "Probabilites et statistiques", "Thermodynamique","Reseaux","Traitement du signal","Analyse de Fourier","Analyse Financiere","Japonais","Geopolitique","Electronique fondamentale","Anthropologie","Droit du travail"};
        JComboBox listeSelectionensegnat = new JComboBox(selectionensegnat);
        listeSelectionensegnat.setFont(y);
        
        
        JLabel ense = new JLabel("     Nom ");
        ense.setFont(t);
        listeSelectionensegnat.setFont(y);
        
        gridPanel7.add(ense);
        gridPanel7.add(listeSelectionensegnat);             
       
        centerReca.add(gridPanel3, BorderLayout.NORTH);
        centerReca.add(gridPanel7, BorderLayout.WEST);
////////////////////////////////////////////////////////////////////////////////
        JPanel gridPanel5 = new JPanel();
        gridPanel5.setLayout(new GridLayout(2,1, 1, 5));
        gridPanel5.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel5.setBackground(new java.awt.Color(145, 200, 100));

        

        JLabel labelFiltre = new JLabel(" Type de cours   ");
        labelFiltre.setFont(t);
        String[] selectionFiltrerecatype = {" Tous", " TP", "TD", "Projet", "Soutien", "Magistral", "Interactif"};
        JComboBox listeselectionFiltrerecatype = new JComboBox(selectionFiltrerecatype);
        listeselectionFiltrerecatype.setFont(y);

        gridPanel5.add(labelFiltre);
        gridPanel5.add(listeselectionFiltrerecatype);
 
        centerReca.add(gridPanel5, BorderLayout.NORTH);
//--------------------------------------------------------------------
          Font f = new Font("Times New Roman", Font.BOLD, 24);
        UIManager.put("JLabel.font", f);
        JButton Montrerreca = new JButton("Montrer le recapitulatif");
        Montrerreca.setFont(f);     
      
        centerReca.add(Montrerreca, BorderLayout.NORTH);
        
//------------------------------------------------------------------
        //innerContainer.add(semaineEDT, BorderLayout.WEST);

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null}
                },
                new String[]{
                    "Matière - Public ", "Première séance", "Dernier séance", "Durée", "Nb de séances"
                }
        ));
        jScrollPane1.setViewportView(jTable1);
        jTable1.setPreferredScrollableViewportSize(new Dimension(1585, 800));
        jTable1.setRowHeight(130);
        TableColumn col = jTable1.getColumnModel().getColumn(0);
        col.setPreferredWidth(490);
        col = jTable1.getColumnModel().getColumn(1);
        col.setPreferredWidth(490);
        col = jTable1.getColumnModel().getColumn(2);
        col.setPreferredWidth(390);
        col = jTable1.getColumnModel().getColumn(3);
        col.setPreferredWidth(50);
        col = jTable1.getColumnModel().getColumn(4);
        col.setPreferredWidth(30);
       

        centerReca.add(jScrollPane1, BorderLayout.CENTER);

        }    
    public static void main(String[] args) {
        AdminVue mylayout = new AdminVue("Accueil");
        mylayout.setVisible(true);
    }

}
