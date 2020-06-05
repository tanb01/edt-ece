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
import java.text.DateFormat;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.TableColumn;


///////////////////////////////////////////////////////////////////////////////
//                     PANEL PRINCIPAL VUE ETUDIANT
///////////////////////////////////////////////////////////////////////////////
public class EtudiantVue extends JFrame {

    private String titrePage = null;
    private JScrollPane jscrollPanel;
    private JTable tableEnGrille;
    private JTable tableEnListe;
    private JComboBox listeSelectionVue = null;
    private JComboBox listeSelectionFiltre = null;
    private JComboBox listeSelectionChamp = null;
    private JButton button53 = null;
    private JButton button54 = null;
    private JButton button60 = null;  
    private JButton searchFiltre = null;
    private JTextField searchFilterField = null;
    private JPanel center = null;
    private JPanel sallesLibresPanel = null;
    private JPanel reportingPanel = null;
     private JPanel gridPanelb;
    private JPanel filtrePanel = null;
    private JPanel semainesPanel = null;
    private ArrayList<JButton> boutons = null;

    /**
     *
     * @param title
     */
//-----------------------------------------------------------------------------
//                          Classe etudiant vue
//-----------------------------------------------------------------------------    
    public EtudiantVue(String title) {

        // Affiche le titre en haut de la fenêtre
        super(title);
        // Taille de la fenêtre
        this.setSize(2750, 1600);
        // Localisation de la fenêtre
        this.setLocation(100, 100);
        // Fermeture et arrêt du programme dès qu'on ferme la fenêtre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
//this.setUndecorated(true);
        // Déclaration de tous les boutons grâce à JButton
        boutons = new ArrayList<JButton>();
        for (int i = 1; i < 53; i++) {
            boutons.add(new JButton(String.valueOf(i)));

        }

        button53 = new JButton("<html>Emploi du<br> temps<html>");
        button53.setPreferredSize(new Dimension(130, 100));
        button53.setIcon(new ImageIcon("img/school.png"));

        button54 = new JButton("<html> Salles <br>libres </html>");
        button54.setIcon(new ImageIcon("img/salles.png"));
        button60 = new JButton("<html> Reporting <br> </html>");
        button60.setIcon(new ImageIcon("img/result.png"));

        // Police Times New Roman
        Font f = new Font("Times New Roman", Font.BOLD, 16);
        UIManager.put("JButton.font", f);

        // Couleur et polices
        button53.setBackground(new java.awt.Color(255, 255, 0));
        button53.setFont(f);
        button54.setBackground(new java.awt.Color(182, 213, 56));
        button54.setFont(f);
        button60.setBackground(new java.awt.Color(254, 67, 1));
        button60.setFont(f);

        // Conteneur principal
        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout(8, 6));
        mainContainer.setBackground(Color.yellow);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.GREEN));

        // Panel du haut
        JPanel topPanel = new JPanel();
        topPanel.setBorder(new LineBorder(Color.BLACK, 2));
        topPanel.setBackground(new java.awt.Color(147, 212, 250));
        topPanel.setLayout(new FlowLayout(3));
        mainContainer.add(topPanel, BorderLayout.NORTH);

        // Barre de menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("COURS");
        JMenu menu1 = new JMenu("ETUDIANTS");

        // Nouvelle police (autre taille de police)
        Font g = new Font("Times New Roman", Font.BOLD, 14);
        UIManager.put("JMenu.font", g);
        menu.setFont(g);
        menu1.setFont(g);

        // Déclaration des items du menu
        //JMenuItem m = new JMenuItem("Regarder par promo");
        JMenuItem m1 = new JMenuItem("Regarder par groupe");
        JMenuItem m2 = new JMenuItem("Regarder par enseignant");

        JMenuItem mi2 = new JMenuItem("Récapitulatifs des cours");
        JMenuItem mi3 = new JMenuItem("Cours annulés");

        // Nouvelle police (autre taille de police)
        Font h = new Font("Times New Roman", Font.BOLD, 14);
        UIManager.put("JMenuItem.font", h);
        m1.setFont(h);
        m2.setFont(h);
        mi2.setFont(h);
        mi3.setFont(h);

        // Ajout des items du menu sur la fenêtre déclarés ci-dessus
        menu.add(m1);
        menu.add(m2);

        menu1.add(mi2);
        menu1.add(mi3);

        menuBar.add(menu);
        menuBar.add(menu1);

        // Ajout de la barre de menu
        topPanel.add(menuBar);

        // Panel de droite
        JPanel rightPanel = new JPanel();
        rightPanel.setBorder(new LineBorder(Color.BLACK, 2));
        rightPanel.setBackground(new java.awt.Color(211, 212, 250));
        rightPanel.setLayout(new FlowLayout(2));

        // Grille
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(3, 1, 4, 1));
        gridPanel.setBorder(new LineBorder(Color.BLACK, 2));
        gridPanel.setBackground(new java.awt.Color(255, 255, 255));

        gridPanel.add(button53);
        gridPanel.add(button54);
        gridPanel.add(button60);

        rightPanel.add(gridPanel);
        mainContainer.add(rightPanel, BorderLayout.WEST);

        // Panel du centre
        center = new JPanel();
        center.setOpaque(true);
        center.setBorder(new LineBorder(Color.BLACK, 2));
        center.setLayout(new FlowLayout(5));
        center.setBackground(new java.awt.Color(211, 212, 250));
        mainContainer.add(center, BorderLayout.CENTER);

        semainesPanel = new JPanel();
        semainesPanel.setLayout(new GridLayout(2, 1, 1, 1));
        semainesPanel.setBorder(new LineBorder(Color.BLACK, 2));

        center.add(semainesPanel);

        filtrePanel = new JPanel();
        filtrePanel.setLayout(new GridLayout(1,1, 5, 5));
        filtrePanel.setBorder(new LineBorder(Color.BLACK, 2));
        filtrePanel.setBackground(new java.awt.Color(145, 200, 100));

        JLabel labelVue = new JLabel("   Vue ");
        String[] selectionVue = {"en grille", "en liste"};

        listeSelectionVue = new JComboBox(selectionVue);

        filtrePanel.add(labelVue);
        filtrePanel.add(listeSelectionVue);
        
        Font fk = new Font("Times New Roman", Font.BOLD, 18);
        UIManager.put("JLabel.font", fk);

        JLabel labelFiltre = new JLabel("  Filtrer par ");
        String[] selectionFiltre = {" ", "Nom enseignant(e)", "Matière"};

        listeSelectionFiltre = new JComboBox(selectionFiltre);

        filtrePanel.add(labelFiltre);
        filtrePanel.add(listeSelectionFiltre);

        String[] selectionChamp = {" ", "Segado", "Daachi"};
        listeSelectionChamp = new JComboBox(selectionChamp);

        searchFiltre = new JButton(" Chercher ");
        searchFiltre.setIcon(new ImageIcon("img/lo.png"));
        searchFiltre.setBackground(new java.awt.Color(254, 254, 254));
        searchFiltre.setFont(fk);
        
        labelFiltre.setFont(fk);
        labelVue.setFont(fk);
        
        searchFilterField = new JTextField();
        filtrePanel.add(searchFilterField);
        filtrePanel.add(searchFiltre);
        center.add(filtrePanel, BorderLayout.NORTH);
        
        Font fG = new Font("Times New Roman", Font.BOLD, 12);
        UIManager.put("JButton.font", fG);

        for (JButton bouton : boutons) {
            semainesPanel.add(bouton);
            bouton.setPreferredSize(new Dimension(46, 25));
            bouton.setFont(fG);
            bouton.setBackground(new java.awt.Color(254, 254, 254));
            
                   
        }
        

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

        
//------------------------------------------------------------------------------        
//                      FIN DU PANEAI PRINCIPAL VUE        
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
//        center.add(reportingPanel, BorderLayout.CENTER);

        

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
     * @param m
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
        cleanTableEnGrille();
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
        String[] selectionFiltre = {"8h30-10h00","10h15-11h45","12h00-13h30","13h45-15h15","15h30-17h00","17h15-18h45","19h00-20h30"};
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
        String[] selectionFiltre2 = {" Eiffel 1", "Eiffel 2", "Eiffel 3", "Eiffel 4", "Eiffel 5", "Cnam"};
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
    public void ajoutDuPanelReporting() { 
                
        JPanel gridPanela = new JPanel();
        gridPanela.setLayout(new GridLayout(1, 1, 10, 5));
        gridPanela.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanela.setBackground(new java.awt.Color(145, 200, 100));
        
        JPanel gridPanelb = new JPanel();
        gridPanelb.setLayout(new GridLayout(2,2, 5, 5));
        gridPanelb.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanelb.setBackground(new java.awt.Color(145, 200, 100));
        
        Font f = new Font("Times New Roman", Font.BOLD, 30);
        UIManager.put("JButton.font", f);
        
        
        JButton Montrer2 = new JButton("<html>Capacité des salles <br> pour un site</html>");
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
        
        
        JButton Montrer3 = new JButton("<html>Taux d'occupation <br> dessalles sur une <br> période donnée</html>");
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
        
        JButton Montrer4 = new JButton("<html>Nombre d'heures de <br> séance par an</html>");
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
        
        JButton Montrer5 = new JButton("<html>Nombre d'heures de <br>séance par TD</html>");
        Montrer5.setFont(f);
        Montrer5.setIcon(new ImageIcon("img/a1.png"));
        Montrer5.setBackground(new java.awt.Color(255,255,0));
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
        SallesReporting g=new  SallesReporting("Effectif des groupes", "Nombres d'élèves par groupes");
        g.setVisible(true);
        
    } 
    private void Montrer3MouseClicked(java.awt.event.MouseEvent evt) {                                      
         EffectifGroupeReporting demo = new EffectifGroupeReporting("Effectif des groupes", "Nombres d'élèves par groupes");
         demo.setVisible(true);
        
    } 
    private void Montrer4MouseClicked(java.awt.event.MouseEvent evt) {                                      
        SallesReporting g=new  SallesReporting("Effectif des groupes", "Nombres d'élèves par groupes");
        g.setVisible(true);
        
    } 
    private void Montrer5MouseClicked(java.awt.event.MouseEvent evt) {                                      
        HeuresReporting demo = new HeuresReporting("Heures de cours", "Nombres d'heures par cours :");
        demo.setVisible(true);
        
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
