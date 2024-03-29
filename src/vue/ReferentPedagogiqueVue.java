package vue;

/**
 * Classe AdminVue qui permet d'afficher la vue d'un administrateur qui a le
 * droit de modifier tout dans l'emploi du temps.
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
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

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private JTable tableSalles;
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

    private JButton buttonCapaciteDesSallesParSite = null;
    private JButton buttonTauxDoccupationDesSalles = null;
    private JButton buttonNombresHeuresSeancesDansAnnee = null;
    private JButton buttonNombresHeuresSeancesParCours = null;

    private JFormattedTextField dateFieldToSelectSeance = null;

    private JTextField seanceSelectionnee = null;

    private ArrayList<JComboBox> comboModifierSeance = null;
    private JButton boutonValiderModificationSeance = null;
    private JButton boutonSelectionnerSeance = null;

    private JButton searchGroupe = null;

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

        button56 = new JButton("<html> Reporting </html>");
        button56.setIcon(new ImageIcon("img/result.png"));
        // Couleur et polices
        Font f = new Font("Times New Roman", Font.BOLD, 16);
        UIManager.put("JButton.font", f);

        // Couleur et polices
        button53.setBackground(new java.awt.Color(255, 255, 0));
        button53.setFont(f);
        button54.setBackground(new java.awt.Color(182, 213, 56));
        button54.setFont(f);

        button56.setBackground(new java.awt.Color(243, 151, 150));
        button56.setFont(f);

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
        String[] selectionFiltre = {" ", "Prepac", "Ing1", "Ing2", "Ing3", "Ing4", "Ing5"};
        listeSelectionFiltre = new JComboBox(selectionFiltre);

        filtrePanel.add(labelFiltre);
        filtrePanel.add(listeSelectionFiltre);

        JLabel labelGroupe = new JLabel("  GROUPE ");
        String[] selectionGroupe = {" ", "Gr01", "Gr02", "Gr03", "Gr04", "Gr05", "Gr06", "Gr07", "Gr08", "Gr09", "Gr10", "Gr11"};

        listeSelectionGroupe = new JComboBox(selectionGroupe);

        filtrePanel.add(labelGroupe);
        filtrePanel.add(listeSelectionGroupe);

        searchGroupe = new JButton("Chercher");
        filtrePanel.add(searchGroupe);

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

        this.setLayout(new BorderLayout());

        reportingPanel = new JPanel();
        reportingPanel.setOpaque(true);
        reportingPanel.setBorder(new LineBorder(Color.BLACK, 3));
        reportingPanel.setLayout(new FlowLayout(5));
        reportingPanel.setBackground(new java.awt.Color(254, 254, 254));
        ajoutDuPanelReporting();

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

    public JButton getButtonSearchGroupe() {
        return searchGroupe;
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

    public JButton getBoutonReportingCapaciteSalles() {
        return buttonCapaciteDesSallesParSite;
    }

    public JButton getBoutonTauxOccupationSalles() {
        return buttonTauxDoccupationDesSalles;
    }

    public JButton getBoutonReportingEffectifGroupe() {
        return buttonNombresHeuresSeancesDansAnnee;
    }

    public JButton getBoutonReportingSeancesParCours() {
        return buttonNombresHeuresSeancesParCours;
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

    public JComboBox getJComboBoxFilterGroupeSelection() {
        return listeSelectionGroupe;
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

        buttonCapaciteDesSallesParSite = new JButton("<html>Capacité des salles <br> par site</html>");
        buttonCapaciteDesSallesParSite.setFont(f);
        buttonCapaciteDesSallesParSite.setIcon(new ImageIcon("img/a4.png"));
        buttonCapaciteDesSallesParSite.setBackground(new java.awt.Color(163, 255, 0));
        buttonCapaciteDesSallesParSite.setFont(f);
        gridPanelb.add(buttonCapaciteDesSallesParSite);

        buttonTauxDoccupationDesSalles = new JButton("<html>Taux d'occupation <br> des salles sur une <br> période donnée</html>");
        buttonTauxDoccupationDesSalles.setFont(f);
        buttonTauxDoccupationDesSalles.setIcon(new ImageIcon("img/a2.png"));
        buttonTauxDoccupationDesSalles.setBackground(new java.awt.Color(163, 150, 253));
        buttonTauxDoccupationDesSalles.setFont(f);
        gridPanelb.add(buttonTauxDoccupationDesSalles);

        buttonNombresHeuresSeancesDansAnnee = new JButton("<html>Effectifs des groupes <br> par Promotion</html>");
        buttonNombresHeuresSeancesDansAnnee.setFont(f);
        buttonNombresHeuresSeancesDansAnnee.setIcon(new ImageIcon("img/a3.png"));
        buttonNombresHeuresSeancesDansAnnee.setBackground(new java.awt.Color(255, 153, 5));
        buttonNombresHeuresSeancesDansAnnee.setFont(f);
        gridPanelb.add(buttonNombresHeuresSeancesDansAnnee);

        buttonNombresHeuresSeancesParCours = new JButton("<html>Nombre d'heures de <br>séances par cours</html>");
        buttonNombresHeuresSeancesParCours.setFont(f);
        buttonNombresHeuresSeancesParCours.setIcon(new ImageIcon("img/a1.png"));
        buttonNombresHeuresSeancesParCours.setBackground(new java.awt.Color(255, 255, 0));
        buttonNombresHeuresSeancesParCours.setFont(f);

        buttonCapaciteDesSallesParSite.setPreferredSize(new Dimension(870, 485));
        buttonTauxDoccupationDesSalles.setPreferredSize(new Dimension(870, 485));
        buttonNombresHeuresSeancesDansAnnee.setPreferredSize(new Dimension(870, 485));
        buttonNombresHeuresSeancesParCours.setPreferredSize(new Dimension(870, 485));
        gridPanelb.add(buttonNombresHeuresSeancesParCours);

        JLabel label16 = new JLabel();
        reportingPanel.add(label16);
        label16.setFont(new java.awt.Font("Tahoma", 0, 36));

        reportingPanel.add(gridPanelb);
    }

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
