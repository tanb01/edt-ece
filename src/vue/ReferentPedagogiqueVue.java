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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.TableColumn;

public class ReferentPedagogiqueVue extends JFrame {

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
    private JScrollPane jscrollPanel;
    private JTable tableEnGrille;
    private JTable tableEnListe;
    private JComboBox listeSelectionVue = null;
    private JComboBox listeSelectionFiltre = null;
    private JComboBox listeSelectionChamp = null;
    private JComboBox listeSelectionGroupe = null;

    private JButton searchFiltre = null;
    private JTextField searchFilterField = null;
//    private JPanel modifierSeancePanel;

    private JPanel centerReca;
    private JPanel gridPanelb;
    private JPanel filtrePanel = null;
    private JPanel semainesPanel = null;
    private ArrayList<JButton> boutons = null;

    private JComboBox listeSelectionEnseignantAjouterSeance = null;
    private JButton validerAjoutSeance = null;
    private JPanel ajouterSeanceSubPanel = null;

    private ArrayList<String> textDeAjouterSeance = null;

    private JFormattedTextField dateFieldAjouterSeance = null;
    private JComboBox listeSelectionCoursAjouterSeance = null;
    private JComboBox listeSelectionPromoAjouterSeance = null;
    private JComboBox listeSelectionHeureDebutAjouterSeance = null;
    private JComboBox listeSelectionHeureFinAjouterSeance = null;
    private JComboBox listeSelectionTypeCoursAjouterSeance = null;
    private JComboBox listeSelectionGroupeAjouterSeance = null;

    private TextField capaciteMaximaleSalleLibre = null;
    private JComboBox listeSelectionHeureSalleLibre = null;
    private JFormattedTextField dateFieldSalleLibre = null;
    private JComboBox listeSelectionSiteSalleLibre = null;
    private JButton boutonValiderRechercheSalleLibre = null;

//    private JComboBox listeSelectionEnseignantToSelectSeance = null;
    private JFormattedTextField dateFieldToSelectSeance = null;
//    private JComboBox listeCoursToSelectSeance = null;
//    private JComboBox listeSelectionPromoToSelectSeance = null;
//    private JComboBox listeSelectionHeureDebutToSelectSeance = null;
//    private JComboBox listeSelectionGroupeToSelectSeance = null;
    private JTextField seanceSelectionnee = null;
//    private JComboBox listeSelectionAjouterEnseignant = null;
//    private JComboBox listeSelectionEnseignantARemplacer = null;
//    private JComboBox listeSelectionNouveauEnseignant = null;
//    private JComboBox listeSelectionAjouterGroupe = null;
//    private JComboBox listeSelectionGroupeARemplacer = null;
//    private JComboBox listeSelectionNouveauGroupe = null;
//    private JComboBox listeSelectionModifierCoursParNom = null;
//    private JComboBox listeSelectionModifierCoursParTypeCours = null;
//    private JComboBox listeSelectionSalleSiteAModifier = null;
//    private JComboBox listeSelectionSalleModifierSeance = null;
//    private JComboBox listeSelectionHeureModifierSeance = null;
//    private JComboBox listeSelectionEtatModifierSeance = null;
//    private JComboBox listeSelectionEnleverEnseigantModifierSeance = null;
    private ArrayList<JComboBox> comboModifierSeance = null;
    private JButton boutonValiderModificationSeance = null;
    private JButton boutonSelectionnerSeance = null;

    /**
     *
     * @param title
     */
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

//        button55 = new JButton("<html> Ajouter une<br> seance</html>");
//        button55.setIcon(new ImageIcon("img/modification.png"));
        button56 = new JButton("<html> Reporting </html>");
        button56.setIcon(new ImageIcon("img/result.png"));
//        button57 = new JButton("<html> Modifier une <br> séance </html>");
//        button57.setIcon(new ImageIcon("img/notepad.png"));
//        button58 = new JButton("<html> Historique de <br> modifications </html>");
//        button58.setIcon(new ImageIcon("img/history.png"));

        // Couleur et polices
        Font f = new Font("Times New Roman", Font.BOLD, 16);
        UIManager.put("JButton.font", f);

        // Couleur et polices
        button53.setBackground(new java.awt.Color(255, 255, 0));
        button53.setFont(f);
        button54.setBackground(new java.awt.Color(182, 213, 56));
        button54.setFont(f);
//        button55.setBackground(new java.awt.Color(252, 108, 1));
//        button55.setFont(f);
        button56.setBackground(new java.awt.Color(243, 151, 150));
        button56.setFont(f);
//        button57.setBackground(new java.awt.Color(143, 151, 150));
////        button57.setFont(f);
//        button58.setBackground(new java.awt.Color(253, 121, 130));
//        button58.setFont(f);

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
//        gridPanel.add(button55);
        gridPanel.add(button56);
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

        filtrePanel = new JPanel();
        filtrePanel.setLayout(new GridLayout(1, 1, 5, 5));
        filtrePanel.setBorder(new LineBorder(Color.BLACK, 3));
        filtrePanel.setBackground(new java.awt.Color(145, 200, 100));

        JLabel labelVue = new JLabel("   Vue ");
        String[] selectionVue = {"en grille", "en liste"};

        listeSelectionVue = new JComboBox(selectionVue);

        filtrePanel.add(labelVue);
        filtrePanel.add(listeSelectionVue);

        JLabel labelFiltre = new JLabel("  PROMO ");
        String[] selectionFiltre = {" Prepac", "Ing1", "Ing2", "Ing3", "Ing4", "Ing5"};
        listeSelectionFiltre = new JComboBox(selectionFiltre);

        filtrePanel.add(labelFiltre);
        filtrePanel.add(listeSelectionFiltre);

        JLabel labelGroupe = new JLabel("  GROUPE ");
        String[] selectionGroupe = {"Gr01", "Gr02", "Gr03", "Gr04", "Gr05", "Gr06", "Gr07", "Gr08", "Gr09", "Gr10", "Gr11"};

        listeSelectionGroupe = new JComboBox(selectionGroupe);

        filtrePanel.add(labelGroupe);
        filtrePanel.add(listeSelectionGroupe);

        center.add(filtrePanel, BorderLayout.NORTH);
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
//        center.add(reportingPanel);
//        center.add(reportingPanel, BorderLayout.CENTER);

//        centerAjoutSeance = new JPanel();
//        centerAjoutSeance.setOpaque(true);
//        centerAjoutSeance.setBorder(new LineBorder(Color.BLACK, 3));
//        centerAjoutSeance.setLayout(new FlowLayout(5));
//        centerAjoutSeance.setBackground(new java.awt.Color(254, 254, 254));
//        ajoutDeSeances();

//        modifierSeancePanel = new JPanel();
//        modifierSeancePanel.setOpaque(true);
//        modifierSeancePanel.setBorder(new LineBorder(Color.BLACK, 3));
//        modifierSeancePanel.setLayout(new FlowLayout(5));
//        modifierSeancePanel.setBackground(new java.awt.Color(254, 254, 254));
//        modifierSeance();

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

//    public void showMenuAjouterSeance() {
//        center.removeAll();
//
//        center.add(centerAjoutSeance);
//        center.revalidate();
//        center.repaint();
//    }

    public void showReporting() {
        center.removeAll();
        center.add(reportingPanel);
        center.revalidate();
        center.repaint();
    }

//    public void showMenuModifierSeance() {
//        center.removeAll();
//        center.add(modifierSeancePanel);
//        center.revalidate();
//        center.repaint();
//    }

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

    public JComboBox getJComboBoxlisteSelectionEnseignantAjouterSeance() {
        return listeSelectionEnseignantAjouterSeance;
    }

    public void setJComboBoxlisteSelectionEnseignantAjouterSeance(String[] s) {
        DefaultComboBoxModel m = new DefaultComboBoxModel(s);
        listeSelectionEnseignantAjouterSeance.setModel(m);
        listeSelectionEnseignantAjouterSeance.revalidate();
        listeSelectionEnseignantAjouterSeance.repaint();
    }

    public JFormattedTextField getDateFieldAjouterSeance() {
        return dateFieldAjouterSeance;

    }

    public JComboBox getJComboBoxlisteSelectionCoursAjouterSeance() {
        return listeSelectionCoursAjouterSeance;
    }

    public JComboBox getJComboBoxlisteSelectionPromoAjouterSeance() {
        return listeSelectionPromoAjouterSeance;
    }

    public JComboBox getJComboBoxlisteSelectionHeureDebutAjouterSeance() {
        return listeSelectionHeureDebutAjouterSeance;
    }

    public JComboBox getJComboBoxlisteSelectionHeureFinAjouterSeance() {
        return listeSelectionHeureFinAjouterSeance;
    }

    public JComboBox getJComboBoxlisteSelectionTypeCoursAjouterSeance() {
        return listeSelectionTypeCoursAjouterSeance;
    }

    public JComboBox getJComboBoxlisteSelectionGroupeAjouterSeance() {
        return listeSelectionGroupeAjouterSeance;
    }

    public JButton getBoutonValiderAjoutSeance() {
        return validerAjoutSeance;
    }

    public TextField getTextFieldCapaciteMaximaleSalleLibre() {
        return capaciteMaximaleSalleLibre;
    }

    public JComboBox getListeSelectionHeureSalleLibre() {
        return listeSelectionHeureSalleLibre;
    }

    public JFormattedTextField getDateFieldSalleLibre() {
        return dateFieldSalleLibre;
    }

    public JComboBox getListeSelectionSiteSalleLibre() {
        return listeSelectionSiteSalleLibre;
    }

    public JButton getBoutonValiderRechercheSalleLibre() {
        return boutonValiderRechercheSalleLibre;
    }

    public ArrayList<JComboBox> getJComboBoxModifierSeance() {
        return comboModifierSeance;
    }

    public JFormattedTextField getDateFieldToSelectSeance() {
        return dateFieldToSelectSeance;
    }

    public JTextField getSeanceSelectionneeField() {
        return seanceSelectionnee;
    }

    public JButton getBoutonValiderModificationSeance() {
        return boutonValiderModificationSeance;
    }

    public JButton getBoutonSelectionnerSeance() {
        return boutonSelectionnerSeance;
    }

    public JComboBox getJComboBoxFilterSelection() {
        return listeSelectionFiltre;
    }

    public JComboBox getJComboBoxFilterSelectionEx() {
        return listeSelectionChamp;
    }

    public void setSeanceSelectionneeField(String s) {
        seanceSelectionnee.setText(s);
        seanceSelectionnee.revalidate();
        seanceSelectionnee.repaint();
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

    public void ajoutDuPanelSallesLibres() {
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

        capaciteMaximaleSalleLibre = new java.awt.TextField();
        capaciteMaximaleSalleLibre.setText("");
        capaciteMaximaleSalleLibre.setBackground(new java.awt.Color(255, 172, 220));
        Font y = new Font("Times New Roman", Font.BOLD, 16);
        UIManager.put("JLabel.font", y);

        JLabel ense = new JLabel(" Capacité maximal  ");
        ense.setFont(t);
        capaciteMaximaleSalleLibre.setFont(y);

        gridPanel7.add(ense);
        gridPanel7.add(capaciteMaximaleSalleLibre);

        //////////////////////////////////////////////////////////
        JPanel gridPanel5 = new JPanel();
        gridPanel5.setLayout(new GridLayout(1, 2, 1, 5));
        gridPanel5.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel5.setBackground(new java.awt.Color(236, 251, 134));

        JLabel labelFiltre = new JLabel("   Heure ");
        labelFiltre.setFont(t);
        String[] selectionFiltre = {"08:30-10:00", "10:15-11:45", "12:00-13:30", "13:45-15:15", "15:30-17:00", "17:15-18:45", "19:00-20:30"};
        listeSelectionHeureSalleLibre = new JComboBox(selectionFiltre);
        listeSelectionHeureSalleLibre.setFont(y);
        listeSelectionHeureSalleLibre.setBackground(new java.awt.Color(255, 172, 220));

        gridPanel5.add(labelFiltre);
        gridPanel5.add(listeSelectionHeureSalleLibre);

        JPanel gridPanel5f = new JPanel();
        gridPanel5f.setLayout(new GridLayout(1, 2, 1, 5));
        gridPanel5f.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel5f.setBackground(new java.awt.Color(236, 251, 134));

        JLabel fecha = new JLabel();
        fecha.setText(" Date ");
        Font ygg = new Font("Times New Roman", Font.BOLD, 16);
        UIManager.put("JLabel.font", ygg);
        fecha.setFont(ygg);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFieldSalleLibre = new JFormattedTextField(dateFormat);
        dateFieldSalleLibre.setValue(new Date());
        Font yg = new Font("Times New Roman", Font.BOLD, 16);
        UIManager.put("JFormattedTextField.font", yg);
        dateFieldSalleLibre.setFont(yg);
        dateFieldSalleLibre.setBackground(new java.awt.Color(255, 172, 220));
        dateFieldSalleLibre.setFocusLostBehavior(JFormattedTextField.REVERT);
        gridPanel5f.add(fecha);
        gridPanel5f.add(dateFieldSalleLibre);

        //////////////////////////////////////////////////////////////
        JPanel gridPanel8 = new JPanel();
        gridPanel8.setLayout(new GridLayout(1, 2, 1, 5));
        gridPanel8.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel8.setBackground(new java.awt.Color(236, 251, 134));

        JLabel labelFiltre2 = new JLabel(" Site  ");
        labelFiltre2.setFont(t);
        String[] selectionFiltre2 = {"Eiffel 1", "Eiffel 2", "Eiffel 3", "Eiffel 4", "Eiffel 5", "Cnam"};
        listeSelectionSiteSalleLibre = new JComboBox(selectionFiltre2);
        listeSelectionSiteSalleLibre.setFont(y);
        listeSelectionSiteSalleLibre.setBackground(new java.awt.Color(255, 172, 220));

        gridPanel8.add(labelFiltre2);
        gridPanel8.add(listeSelectionSiteSalleLibre);

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

        boutonValiderRechercheSalleLibre = new JButton("Valider l'affectation");
        boutonValiderRechercheSalleLibre.setFont(f);
        boutonValiderRechercheSalleLibre.setIcon(new ImageIcon("img/check.png"));
        boutonValiderRechercheSalleLibre.setBackground(new java.awt.Color(251, 231, 188));

        gridPanel9.add(cb1);

        sallesLibresPanel.add(gridPanel3);
        sallesLibresPanel.add(gridPanel7);
        sallesLibresPanel.add(capaciteMaximaleSalleLibre);
        sallesLibresPanel.add(gridPanel5);
        sallesLibresPanel.add(gridPanel5f);
        sallesLibresPanel.add(gridPanel8);
        sallesLibresPanel.add(gridPanel9);
        sallesLibresPanel.add(boutonValiderRechercheSalleLibre);
    }

///////////////////////////////////////////////////////////////////////////////
    public void ajoutDuPanelReporting() {

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
//        Montrer2.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                Montrer2MouseClicked(evt);
//            }
//        });

        JButton Montrer3 = new JButton("<html>Taux d'occupation <br> des salles sur une <br> période donnée</html>");
        Montrer3.setFont(f);
        Montrer3.setIcon(new ImageIcon("img/a2.png"));
        Montrer3.setBackground(new java.awt.Color(163, 150, 253));
        Montrer3.setFont(f);
        gridPanelb.add(Montrer3);
//        Montrer3.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                Montrer3MouseClicked(evt);
//            }
//        });

        JButton Montrer4 = new JButton("<html>Nombre d'heures de <br> séances dans l'annee</html>");
        Montrer4.setFont(f);
        Montrer4.setIcon(new ImageIcon("img/a3.png"));
        Montrer4.setBackground(new java.awt.Color(255, 153, 5));
        Montrer4.setFont(f);
        gridPanelb.add(Montrer4);
//        Montrer4.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                Montrer4MouseClicked(evt);
//            }
//        });

        JButton Montrer5 = new JButton("<html>Nombre d'heures de <br>séances par cours</html>");
        Montrer5.setFont(f);
        Montrer5.setIcon(new ImageIcon("img/a1.png"));
        Montrer5.setBackground(new java.awt.Color(255, 255, 0));
        Montrer5.setFont(f);
//        Montrer5.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                Montrer5MouseClicked(evt);
//            }
//        });

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
//    public void ajoutDeSeances() {
//        centerAjoutSeance = new JPanel();
//        centerAjoutSeance.setOpaque(true);
//        centerAjoutSeance.setBorder(new LineBorder(Color.BLACK, 3));
//        centerAjoutSeance.setLayout(new FlowLayout(5));
//        centerAjoutSeance.setBackground(new java.awt.Color(211, 212, 250));
//        //mainContainer.add(centerajoutseance, BorderLayout.CENTER);
//
//        Font y = new Font("Times New Roman", Font.BOLD, 30);
//        UIManager.put("JLabel.font", y);
//
//        JPanel gridPanel3 = new JPanel();
//        gridPanel3.setLayout(new GridLayout(1, 1, 1, 5));
//        gridPanel3.setBorder(new LineBorder(Color.BLACK, 3));
//        gridPanel3.setBackground(new java.awt.Color(145, 200, 100));
//
//        //URL de l'image
//        String imgUrl = "img/depla.png";
//        ImageIcon icone = new ImageIcon(imgUrl);
//
//        JLabel titra = new JLabel("  AJOUTER UNE SEANCE  ", icone, JLabel.CENTER);
//        gridPanel3.add(titra);
//        Font t = new Font("Times New Roman", Font.BOLD, 30);
//        UIManager.put("JLabel.font", t);
//        titra.setFont(t);
//
//        ajouterSeanceSubPanel = new JPanel();
//        ajouterSeanceSubPanel.setLayout(new GridLayout(8, 1, 1, 5));
//        ajouterSeanceSubPanel.setBorder(new LineBorder(Color.BLACK, 3));
//        ajouterSeanceSubPanel.setBackground(new java.awt.Color(145, 200, 100));
//
//        String[] selectionensegnat = {"Segado", "Espagnol", "Java", "Web Dynamique", "Probabilites et statistiques", "Thermodynamique", "Reseaux", "Traitement du signal", "Analyse de Fourier", "Analyse Financiere", "Japonais", "Geopolitique", "Electronique fondamentale", "Anthropologie", "Droit du travail"};
//        listeSelectionEnseignantAjouterSeance = new JComboBox(selectionensegnat);
//        listeSelectionEnseignantAjouterSeance.setFont(y);
////----------------------------------------------------
//        JLabel fecha = new JLabel();
//        fecha.setText("Date");
//
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        dateFieldAjouterSeance = new JFormattedTextField(dateFormat);
//        dateFieldAjouterSeance.setValue(new Date());
//
//        JLabel ense = new JLabel("Enseignant");
/////////////////////////////////////////////////////////////////
//        JLabel labelcours = new JLabel("Cours   ");
//        labelcours.setFont(t);
//        String[] selectioncours = {"Anglais", "Espagnol", "Java", "Web Dynamique", "Probabilites et statistiques", "Thermodynamique", "Reseaux", "Traitement du signal", "Analyse de Fourier", "Analyse Financiere", "Japonais", "Geopolitique", "Electronique fondamentale", "Anthropologie", "Droit du travail"};
//        listeSelectionCoursAjouterSeance = new JComboBox(selectioncours);
//        listeSelectionCoursAjouterSeance.setFont(y);
/////////////////////////////////////////////////////////////////////
//
//        JLabel labelpromo = new JLabel("Promo");
//        labelpromo.setFont(t);
//        String[] selectionpromo = {"Prepac", "Ing1", "Ing2", "Ing3", "Ing4", "Ing5"};
//        listeSelectionPromoAjouterSeance = new JComboBox(selectionpromo);
//        listeSelectionPromoAjouterSeance.setFont(y);
////////////////////////////////////////////////////////////////////////
//
//        JLabel labelheured = new JLabel("Début d'heure ");
//        labelheured.setFont(t);
//        String[] selectionFiltreheured = {"08:30", "10:15", "12:00", "13:45", "15:30", "17:15", "19:00"};
//        listeSelectionHeureDebutAjouterSeance = new JComboBox(selectionFiltreheured);
//        listeSelectionHeureDebutAjouterSeance.setFont(y);
/////////////////////////////////////////////////////////////////////////
//        JLabel labelheuref = new JLabel("Fin d'heure ");
//        labelheuref.setFont(t);
//        String[] selectionFiltreheuref = {"10:00", "11:45", "13:30", "15:15", "17:00", "18:45", "20:30"};
//        listeSelectionHeureFinAjouterSeance = new JComboBox(selectionFiltreheuref);
//        listeSelectionHeureFinAjouterSeance.setFont(y);
/////////////////////////////////////////////////////////////////////////
//        JLabel labeltypecours = new JLabel("Type de cours   ");
//        labeltypecours.setFont(t);
//        String[] selectionFiltretypecours = {"TP", "TD", "Projet", "Soutien", "Magistral", "Interactif"};
//        listeSelectionTypeCoursAjouterSeance = new JComboBox(selectionFiltretypecours);
//        listeSelectionTypeCoursAjouterSeance.setFont(y);
///////////////////////////////////////////////////////////////////////////
//        JLabel labelgroupe = new JLabel("Groupe   ");
//        labelgroupe.setFont(t);
//        String[] selectionFiltregroupe = {"Gr01", "Gr02", "Gr03", "Gr04", "Gr05", "Gr06", "Gr07", "Gr08", "Gr09", "Gr10", "Gr11"};
//        listeSelectionGroupeAjouterSeance = new JComboBox(selectionFiltregroupe);
//        listeSelectionGroupeAjouterSeance.setFont(y);
//        ense.setFont(t);
//        fecha.setFont(t);
//
//        dateFieldAjouterSeance.setFont(y);
////                textDeAjouterSeance.add(imgUrl)
//
////        textDeAjouterSeance = new ArrayList<String>();
//        ajouterSeanceSubPanel.add(ense);
//        ajouterSeanceSubPanel.add(listeSelectionEnseignantAjouterSeance);
//
//        ajouterSeanceSubPanel.add(fecha);
//        ajouterSeanceSubPanel.add(dateFieldAjouterSeance);
//
//        ajouterSeanceSubPanel.add(labelcours);
//        ajouterSeanceSubPanel.add(listeSelectionCoursAjouterSeance);
//
//        ajouterSeanceSubPanel.add(labelpromo);
//        ajouterSeanceSubPanel.add(listeSelectionPromoAjouterSeance);
//
//        ajouterSeanceSubPanel.add(labelheured);
//        ajouterSeanceSubPanel.add(listeSelectionHeureDebutAjouterSeance);
//
//        ajouterSeanceSubPanel.add(labelheuref);
//        ajouterSeanceSubPanel.add(listeSelectionHeureFinAjouterSeance);
//
//        ajouterSeanceSubPanel.add(labeltypecours);
//        ajouterSeanceSubPanel.add(listeSelectionTypeCoursAjouterSeance);
//
//        ajouterSeanceSubPanel.add(labelgroupe);
//        ajouterSeanceSubPanel.add(listeSelectionGroupeAjouterSeance);
//
//        centerAjoutSeance.add(gridPanel3, BorderLayout.NORTH);
//        centerAjoutSeance.add(ajouterSeanceSubPanel, BorderLayout.WEST);
//
//////////////////////////////////////////////////////////////////////////////////        
//        validerAjoutSeance = new JButton("Valider l'affectation");
//        Font h = new Font("Times New Roman", Font.BOLD, 30);
//        UIManager.put("JButton.font", h);
//        validerAjoutSeance.setFont(h);
//        validerAjoutSeance.setIcon(new ImageIcon("img/check.png"));
//        validerAjoutSeance.setBackground(new java.awt.Color(251, 231, 188));
//
//        centerAjoutSeance.add(validerAjoutSeance);
//        centerAjoutSeance.revalidate();
//        centerAjoutSeance.repaint();
//    }

    /**
     *
     * @return
     */
////////////////////////////////////////////////////////////////////////////////
//                MODIFICATION DE L'EMPLOIE DU TEMPS
////////////////////////////////////////////////////////////////////////////////
//    public void modifierSeance() {
//        modifierSeancePanel = new JPanel();
//        modifierSeancePanel.setOpaque(true);
//        modifierSeancePanel.setBorder(new LineBorder(Color.BLACK, 3));
//        modifierSeancePanel.setLayout(new FlowLayout(5));
//        modifierSeancePanel.setBackground(new java.awt.Color(211, 212, 250));
//        Font y = new Font("Times New Roman", Font.BOLD, 20);
//        UIManager.put("JLabel.font", y);
//
//        JPanel gridPanel3 = new JPanel();
//        gridPanel3.setLayout(new GridLayout(5, 1, 30, 10));
//        gridPanel3.setBorder(new LineBorder(Color.BLACK, 3));
//        gridPanel3.setBackground(new java.awt.Color(145, 200, 100));
//
//        //URL de l'image
//        String imgUrl = "img/cali.png";
//        ImageIcon icone = new ImageIcon(imgUrl);
//
//        JLabel titra = new JLabel("MODIFIER UNE SEANCE  ", icone, JLabel.CENTER);
//        gridPanel3.add(titra);
//        Font t = new Font("Times New Roman", Font.BOLD, 24);
//        UIManager.put("JLabel.font", t);
//        titra.setFont(t);
//
//        //URL de l'image
//        String imgUrl2 = "img/order.png";
//        ImageIcon icone2 = new ImageIcon(imgUrl2);
//
//        JLabel titra2 = new JLabel("SELECTIONER UNE SEANCE  ", icone2, JLabel.CENTER);
//        gridPanel3.add(titra2);
//        titra2.setFont(t);
//
//        //URL de l'image
//        String imgUrl3 = "img/order.png";
//        ImageIcon icone3 = new ImageIcon(imgUrl3);
//
//        JLabel titra3 = new JLabel("AFFECTER  ", icone3, JLabel.CENTER);
//        gridPanel3.add(titra3);
//        titra3.setFont(t);
//
//        String imgUrl4 = "img/order.png";
//        ImageIcon icone4 = new ImageIcon(imgUrl4);
//
//        JLabel titra4 = new JLabel("MODIFIER  ", icone4, JLabel.CENTER);
//        gridPanel3.add(titra4);
//        titra4.setFont(t);
//
//        String imgUrl5 = "img/order.png";
//        ImageIcon icone5 = new ImageIcon(imgUrl5);
//
//        JLabel titra5 = new JLabel("ENLEVER  ", icone5, JLabel.CENTER);
//        gridPanel3.add(titra5);
//        titra5.setFont(t);
//
//        JPanel modifierSeanceSubPanel = new JPanel();
//        modifierSeanceSubPanel.setLayout(new GridLayout(22, 1, 20, 5));
//        modifierSeanceSubPanel.setBorder(new LineBorder(Color.BLACK, 3));
//        modifierSeanceSubPanel.setBackground(new java.awt.Color(145, 200, 100));
//
//        comboModifierSeance = new ArrayList<JComboBox>();
//
//        String[] selectionensegnat = {"Segado", "Espagnol", "Java", "Web Dynamique", "Probabilites et statistiques", "Thermodynamique", "Reseaux", "Traitement du signal", "Analyse de Fourier", "Analyse Financiere", "Japonais", "Geopolitique", "Electronique fondamentale", "Anthropologie", "Droit du travail"};
//        JComboBox listeSelectionEnseignantToSelectSeance = new JComboBox(selectionensegnat);
//        listeSelectionEnseignantToSelectSeance.setFont(y);
//        comboModifierSeance.add(listeSelectionEnseignantToSelectSeance);
////----------------------------------------------------
//        JLabel fecha = new JLabel();
//        fecha.setText("Date ");
//
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        dateFieldToSelectSeance = new JFormattedTextField(dateFormat);
//        dateFieldToSelectSeance.setValue(new Date());
//
//        JLabel ense = new JLabel("Enseignant");
/////////////////////////////////////////////////////////////////
//        JLabel labelcours = new JLabel("Cours   ");
//        labelcours.setFont(t);
//        String[] selectioncours = {"Anglais", "Espagnol", "Java", "Web Dynamique", "Probabilites et statistiques", "Thermodynamique", "Reseaux", "Traitement du signal", "Analyse de Fourier", "Analyse Financiere", "Japonais", "Geopolitique", "Electronique fondamentale", "Anthropologie", "Droit du travail"};
//        JComboBox listeCoursToSelectSeance = new JComboBox(selectioncours);
//        listeCoursToSelectSeance.setFont(y);
//        comboModifierSeance.add(listeCoursToSelectSeance);
/////////////////////////////////////////////////////////////////////
//
//        JLabel labelpromo = new JLabel("Promo");
//        labelpromo.setFont(t);
//        String[] selectionpromo = {"Prepac", "Ing1", "Ing2", "Ing3", "Ing4", "Ing5"};
//        JComboBox listeSelectionPromoToSelectSeance = new JComboBox(selectionpromo);
//        listeSelectionPromoToSelectSeance.setFont(y);
//        comboModifierSeance.add(listeSelectionPromoToSelectSeance);
//
////////////////////////////////////////////////////////////////////////
//        JLabel labelheured = new JLabel("Début d'heure ");
//        labelheured.setFont(t);
//        String[] selectionFiltreheured = {"08:30", "10:15", "12:00", "13:45", "15:30", "17:15", "19:00"};
//        JComboBox listeSelectionHeureDebutToSelectSeance = new JComboBox(selectionFiltreheured);
//        listeSelectionHeureDebutToSelectSeance.setFont(y);
//        comboModifierSeance.add(listeSelectionHeureDebutToSelectSeance);
/////////////////////////////////////////////////////////////////////////
////        JLabel labelheuref = new JLabel("Fin d'heure ");
////        labelheuref.setFont(t);
////        String[] selectionFiltreheuref = {"8h30-10h00", "10h15-11h45", "12h00-13h30", "13h45-15h15", "15h30-17h00", "17h15-18h45", "19h00-20h30"};
////        JComboBox listeSelectionDureef = new JComboBox(selectionFiltreheuref);
////        listeSelectionDureef.setFont(y);
/////////////////////////////////////////////////////////////////////////
////        JLabel labeltypecours = new JLabel(" Type de cours   ");
////        labeltypecours.setFont(t);
////        String[] selectionFiltretypecours = {"TP", "TD", "Projet", "Soutien", "Magistral", "Interactif"};
////        JComboBox listeSelectionFiltretypecours = new JComboBox(selectionFiltretypecours);
////        listeSelectionFiltretypecours.setFont(y);
///////////////////////////////////////////////////////////////////////////
//        JLabel labelgroupe = new JLabel("Groupe   ");
//        labelgroupe.setFont(t);
//        String[] selectionFiltregroupe = {"Gr01", "Gr02", "Gr03", "Gr04", "Gr05", "Gr06", "Gr07", "Gr08", "Gr09", "Gr10", "Gr11"};
//        JComboBox listeSelectionGroupeToSelectSeance = new JComboBox(selectionFiltregroupe);
//        listeSelectionGroupeToSelectSeance.setFont(y);
//        comboModifierSeance.add(listeSelectionGroupeToSelectSeance);
//
//        ense.setFont(t);
//        fecha.setFont(t);
//        dateFieldToSelectSeance.setFont(y);
///////////////////////////////////////////////////////////////////////////////
//        JLabel titra6 = new JLabel("Seance selectioné  ");
//        titra6.setFont(t);
//        seanceSelectionnee = new JTextField();
/////////////////////////////////////////////////////////////////////////////////
//        JLabel ensevieux1 = new JLabel("Ajouter un enseignant ");
//        ensevieux1.setFont(t);
//        String[] selectionensegnatv = {"Segado", "Espagnol", "Java", "Web Dynamique", "Probabilites et statistiques", "Thermodynamique", "Reseaux", "Traitement du signal", "Analyse de Fourier", "Analyse Financiere", "Japonais", "Geopolitique", "Electronique fondamentale", "Anthropologie", "Droit du travail"};
//        JComboBox listeSelectionAjouterEnseignant = new JComboBox(selectionensegnatv);
//        listeSelectionAjouterEnseignant.setFont(y);
//        comboModifierSeance.add(listeSelectionAjouterEnseignant);
//
////---------------------------------------        
//        JLabel ensevieux = new JLabel("Enseignant à remplacer ");
//        ensevieux.setFont(t);
//        String[] selectionensegnatr = {"Segado", "Espagnol", "Java", "Web Dynamique", "Probabilites et statistiques", "Thermodynamique", "Reseaux", "Traitement du signal", "Analyse de Fourier", "Analyse Financiere", "Japonais", "Geopolitique", "Electronique fondamentale", "Anthropologie", "Droit du travail"};
//        JComboBox listeSelectionEnseignantARemplacer = new JComboBox(selectionensegnatr);
//        listeSelectionEnseignantARemplacer.setFont(y);
//        comboModifierSeance.add(listeSelectionEnseignantARemplacer);
////---------------------------------------        
//        JLabel ensenouveau = new JLabel("Nouveau Enseignant");
//        ensenouveau.setFont(t);
//        String[] selectionensegnatn = {"Segado", "Espagnol", "Java", "Web Dynamique", "Probabilites et statistiques", "Thermodynamique", "Reseaux", "Traitement du signal", "Analyse de Fourier", "Analyse Financiere", "Japonais", "Geopolitique", "Electronique fondamentale", "Anthropologie", "Droit du travail"};
//        JComboBox listeSelectionNouveauEnseignant = new JComboBox(selectionensegnatn);
//        listeSelectionNouveauEnseignant.setFont(y);
//        comboModifierSeance.add(listeSelectionNouveauEnseignant);
//
////--------------------------------------------        
//        JLabel groupe = new JLabel("Ajouter un groupe");
//        groupe.setFont(t);
//        String[] selectionFiltregroupea = {"Gr01", "Gr02", "Gr03", "Gr04", "Gr05", "Gr06", "Gr07", "Gr08", "Gr09", "Gr10", "Gr11"};
//        JComboBox listeSelectionAjouterGroupe = new JComboBox(selectionFiltregroupea);
//        listeSelectionAjouterGroupe.setFont(y);
//        comboModifierSeance.add(listeSelectionAjouterGroupe);
//
////---------------------------------------------
//        JLabel groupe3 = new JLabel("Groupe à remplacer");
//        groupe3.setFont(t);
//        String[] selectionFiltregroupeaf3 = {"Gr01", "Gr02", "Gr03", "Gr04", "Gr05", "Gr06", "Gr07", "Gr08", "Gr09", "Gr10", "Gr11"};
//        JComboBox listeSelectionGroupeARemplacer = new JComboBox(selectionFiltregroupeaf3);
//        listeSelectionGroupeARemplacer.setFont(y);
//        comboModifierSeance.add(listeSelectionGroupeARemplacer);
//
////----------------------------------------------- 
//        JLabel groupe2 = new JLabel("Nouveau Groupe");
//        groupe2.setFont(t);
//        String[] selectionFiltregroupeaf = {"Gr01", "Gr02", "Gr03", "Gr04", "Gr05", "Gr06", "Gr07", "Gr08", "Gr09", "Gr10", "Gr11"};
//        JComboBox listeSelectionNouveauGroupe = new JComboBox(selectionFiltregroupeaf);
//        listeSelectionNouveauGroupe.setFont(y);
//        comboModifierSeance.add(listeSelectionNouveauGroupe);
//
////----------------------------------------------- 
//        JLabel cours = new JLabel("Modifier un cours par son nom");
//        cours.setFont(t);
//        String[] selectioncoursn = {"Anglais", "Espagnol", "Java", "Web Dynamique", "Probabilites et statistiques", "Thermodynamique", "Reseaux", "Traitement du signal", "Analyse de Fourier", "Analyse Financiere", "Japonais", "Geopolitique", "Electronique fondamentale", "Anthropologie", "Droit du travail"};
//        JComboBox listeSelectionModifierCoursParNom = new JComboBox(selectioncoursn);
//        listeSelectionModifierCoursParNom.setFont(y);
//        comboModifierSeance.add(listeSelectionModifierCoursParNom);
//
////----------------------------------------------        
//        JLabel cours1 = new JLabel("Modifier un cours par son type");
//        cours1.setFont(t);
//        String[] selectionFiltretypecoursa = {"TP", "TD", "Projet", "Soutien", "Magistral", "Interactif"};
//        JComboBox listeSelectionModifierCoursParTypeCours = new JComboBox(selectionFiltretypecoursa);
//        listeSelectionModifierCoursParTypeCours.setFont(y);
//        comboModifierSeance.add(listeSelectionModifierCoursParTypeCours);
//
////--------------------------------------------------        
//        JLabel salle = new JLabel("Modifier un salle par son site");
//        salle.setFont(t);
//        String[] selectionFiltre2f = {"Eiffel 1", "Eiffel 2", "Eiffel 3", "Eiffel 4", "Eiffel 5", "Cnam"};
//        JComboBox listeSelectionSalleSiteAModifier = new JComboBox(selectionFiltre2f);
//        listeSelectionSalleSiteAModifier.setFont(y);
//        comboModifierSeance.add(listeSelectionSalleSiteAModifier);
//
////-------------------------------------------------        
//        JLabel salle1 = new JLabel("Modifier une salle par son nom");
//        salle1.setFont(t);
//        String[] selectionensegnatnom = {"Segado", "Espagnol", "Java", "Web Dynamique", "Probabilites et statistiques", "Thermodynamique", "Reseaux", "Traitement du signal", "Analyse de Fourier", "Analyse Financiere", "Japonais", "Geopolitique", "Electronique fondamentale", "Anthropologie", "Droit du travail"};
//        JComboBox listeSelectionSalleModifierSeance = new JComboBox(selectionensegnatnom);
//        listeSelectionSalleModifierSeance.setFont(y);
//        comboModifierSeance.add(listeSelectionSalleModifierSeance);
//
////------------------------------------------------------        
//        JLabel heure = new JLabel("Modifier l'heure d'une séance");
//        heure.setFont(t);
//        String[] selectionFiltreheurede = {"8h30-10h00", "10h15-11h45", "12h00-13h30", "13h45-15h15", "15h30-17h00", "17h15-18h45", "19h00-20h30"};
//        JComboBox listeSelectionHeureModifierSeance = new JComboBox(selectionFiltreheurede);
//        listeSelectionHeureModifierSeance.setFont(y);
//        comboModifierSeance.add(listeSelectionHeureModifierSeance);
//
////--------------------------------------------------------        
//        JLabel etat = new JLabel("Changer l'état d'une seance");
//        etat.setFont(t);
//        String[] selectionetat = {"En cours de validation", "Valider", "Annuler"};
//        JComboBox listeSelectionEtatModifierSeance = new JComboBox(selectionetat);
//        listeSelectionEtatModifierSeance.setFont(y);
//        comboModifierSeance.add(listeSelectionEtatModifierSeance);
//
////--------------------------------------------------------          
//        JLabel enleverense = new JLabel("Enlever un enseignant d'une séance");
//        enleverense.setFont(t);
//        String[] selectionensegnaten = {"Segado", "Espagnol", "Java", "Web Dynamique", "Probabilites et statistiques", "Thermodynamique", "Reseaux", "Traitement du signal", "Analyse de Fourier", "Analyse Financiere", "Japonais", "Geopolitique", "Electronique fondamentale", "Anthropologie", "Droit du travail"};
//        JComboBox listeSelectionEnleverEnseigantModifierSeance = new JComboBox(selectionensegnaten);
//        listeSelectionEnleverEnseigantModifierSeance.setFont(y);
//        comboModifierSeance.add(listeSelectionEnleverEnseigantModifierSeance);
//
////--------------------------------------------------------          
//        JLabel etatgroupe = new JLabel("Enlever un groupe d'une séance");
//        etatgroupe.setFont(t);
//        String[] selectionFiltregroupeaenle = {"Gr01", "Gr02", "Gr03", "Gr04", "Gr05", "Gr06", "Gr07", "Gr08", "Gr09", "Gr10", "Gr11"};
//        JComboBox listeSelectionEnleverGroupeModifierSeance = new JComboBox(selectionFiltregroupeaenle);
//        listeSelectionEnleverGroupeModifierSeance.setFont(y);
//        comboModifierSeance.add(listeSelectionEnleverGroupeModifierSeance);
//
////--------------------------------------------------------          
//        modifierSeanceSubPanel.add(ense);
//        modifierSeanceSubPanel.add(listeSelectionEnseignantToSelectSeance);
//        modifierSeanceSubPanel.add(fecha);
//        modifierSeanceSubPanel.add(dateFieldToSelectSeance);
//        modifierSeanceSubPanel.add(labelcours);
//        modifierSeanceSubPanel.add(listeCoursToSelectSeance);
//        modifierSeanceSubPanel.add(labelpromo);
//        modifierSeanceSubPanel.add(listeSelectionPromoToSelectSeance);
//        modifierSeanceSubPanel.add(labelheured);
//        modifierSeanceSubPanel.add(listeSelectionHeureDebutToSelectSeance);
////        gridPanel7.add(labelheuref);
////        gridPanel7.add(listeSelectionDureef);
////        gridPanel7.add(labeltypecours);
////        gridPanel7.add(listeSelectionFiltretypecours);
//        modifierSeanceSubPanel.add(labelgroupe);
//        modifierSeanceSubPanel.add(listeSelectionGroupeToSelectSeance);
//        modifierSeanceSubPanel.add(titra6);
//        modifierSeanceSubPanel.add(seanceSelectionnee);
//        modifierSeanceSubPanel.add(ensevieux1);
//        modifierSeanceSubPanel.add(listeSelectionAjouterEnseignant);
//        modifierSeanceSubPanel.add(ensevieux);
//        modifierSeanceSubPanel.add(listeSelectionEnseignantARemplacer);
//        modifierSeanceSubPanel.add(ensenouveau);
//        modifierSeanceSubPanel.add(listeSelectionNouveauEnseignant);
//        modifierSeanceSubPanel.add(groupe);
//        modifierSeanceSubPanel.add(listeSelectionAjouterGroupe);
//        modifierSeanceSubPanel.add(groupe2);
//        modifierSeanceSubPanel.add(listeSelectionNouveauGroupe);
//        modifierSeanceSubPanel.add(groupe3);
//        modifierSeanceSubPanel.add(listeSelectionGroupeARemplacer);
//        modifierSeanceSubPanel.add(cours);
//        modifierSeanceSubPanel.add(listeSelectionModifierCoursParNom);
//        modifierSeanceSubPanel.add(cours1);
//        modifierSeanceSubPanel.add(listeSelectionModifierCoursParTypeCours);
//        modifierSeanceSubPanel.add(salle);
//        modifierSeanceSubPanel.add(listeSelectionSalleSiteAModifier);
//        modifierSeanceSubPanel.add(salle1);
//        modifierSeanceSubPanel.add(listeSelectionSalleModifierSeance);
//        modifierSeanceSubPanel.add(etat);
//        modifierSeanceSubPanel.add(listeSelectionEtatModifierSeance);
//        modifierSeanceSubPanel.add(enleverense);
//        modifierSeanceSubPanel.add(listeSelectionEnleverEnseigantModifierSeance);
//        modifierSeanceSubPanel.add(etatgroupe);
//        modifierSeanceSubPanel.add(listeSelectionEnleverGroupeModifierSeance);
//
////-----------------------------------------------------------------------------        
//        JPanel gridPanel8 = new JPanel();
//        gridPanel8.setLayout(new GridLayout(4, 1, 25, 115));
//        gridPanel8.setBorder(new LineBorder(Color.BLACK, 3));
//        gridPanel8.setBackground(new java.awt.Color(145, 200, 100));
//
//        Font f = new Font("Times New Roman", Font.BOLD, 30);
//        UIManager.put("JButton.font", f);
//
////        JButton validerm = new JButton("Valider la séance");
////        validerm.setFont(f);
////        validerm.setIcon(new ImageIcon("img/check.png"));
////        validerm.setBackground(new java.awt.Color(251, 231, 188));
//        boutonSelectionnerSeance = new JButton("Sélectionner séance");
//        boutonSelectionnerSeance.setFont(f);
//        boutonSelectionnerSeance.setIcon(new ImageIcon("img/check.png"));
//        boutonSelectionnerSeance.setBackground(new java.awt.Color(251, 231, 188));
//
//        boutonValiderModificationSeance = new JButton("Valider la modification");
//        boutonValiderModificationSeance.setFont(f);
//        boutonValiderModificationSeance.setIcon(new ImageIcon("img/check.png"));
//        boutonValiderModificationSeance.setBackground(new java.awt.Color(251, 231, 188));
//
////        JButton valider3m = new JButton("Valider le changement");
////        valider3m.setFont(f);
////        valider3m.setIcon(new ImageIcon("img/check.png"));
////        valider3m.setBackground(new java.awt.Color(251, 231, 188));
////
////        JButton valider4m = new JButton("Enlever");
////        valider4m.setFont(f);
////        valider4m.setIcon(new ImageIcon("img/check.png"));
////        valider4m.setBackground(new java.awt.Color(251, 231, 188));
//        gridPanel8.add(boutonSelectionnerSeance);
//        //gridPanel8.add(validerm);
//        gridPanel8.add(boutonValiderModificationSeance);
//        //gridPanel8.add(valider3m);
//        //gridPanel8.add(valider4m);
//
//////////////////////////////////////////////////////////////////////////////////        
//        modifierSeancePanel.add(gridPanel3, BorderLayout.NORTH);
//        modifierSeancePanel.add(modifierSeanceSubPanel, BorderLayout.WEST);
//        modifierSeancePanel.add(gridPanel8, BorderLayout.SOUTH);
//    }
//////////////////////////////////////////////////////////////////////////// 
//                          CENTRER RECAPITULATIF        
////////////////////////////////////////////////////////////////////////////

    public final void ModifierRecapitulatif() {
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

        String[] selectionensegnat = {"Segado", "Espagnol", "Java", "Web Dynamique", "Probabilites et statistiques", "Thermodynamique", "Reseaux", "Traitement du signal", "Analyse de Fourier", "Analyse Financiere", "Japonais", "Geopolitique", "Electronique fondamentale", "Anthropologie", "Droit du travail"};
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
        gridPanel5.setLayout(new GridLayout(2, 1, 1, 5));
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
