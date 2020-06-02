package vue;


/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.*;
import javax.swing.table.TableColumn;

public class Affecterenseignant extends JFrame {

    private String titrePage = null;
    private JTabbedPane onglet;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;

    private JScrollPane scroll;
    private DefaultTableModel model;

    public Affecterenseignant(String title) {

        super(title);
        this.setSize(2750, 1600);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button53 = new JButton("Emploi du temps");
        button53.setPreferredSize(new Dimension(265, 120));

        JButton button54 = new JButton("<html> Salles <br>" +
                                            " libres <br> </html>");
        JButton button55 = new JButton("<html> Modifier un<br>" +
                                            " Cours<br> </html>");
        JButton button56 = new JButton("<html> Modifier une<br>" +
                                            " seance<br> </html>");
        JButton button57 = new JButton("<html> Modifier un<br>" +
                                            " groupe<br> </html>");
        JButton button58 = new JButton("<html> Modifier un<br>" +
                                            " enseignant<br> </html>");
        JButton button59 = new JButton("Comment utiliser l'apllication?");

        Font f = new Font("Times New Roman", Font.BOLD, 30);
        UIManager.put("JButton.font", f);
        
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
                //ensemble des action

            }
        });
//------------------------------------------------------------------------------
        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout(8, 6));
        mainContainer.setBackground(Color.yellow);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.GREEN));
//------------------------------------------------------------------------------
        JPanel topPanel = new JPanel();
        topPanel.setBorder(new LineBorder(Color.BLACK, 5));
        topPanel.setBackground(new java.awt.Color(147, 212, 250));
        topPanel.setLayout(new FlowLayout(5));
        mainContainer.add(topPanel, BorderLayout.NORTH);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("COURS");
        JMenu menu1 = new JMenu("ETUDIANTS");
        JMenu menu2 = new JMenu("PROMOTIONS");
        JMenu menu3 = new JMenu("ENSEIGNANTS");
        JMenu menu4 = new JMenu("SALLES");
        
        Font g = new Font("Times New Roman", Font.BOLD, 18);
        UIManager.put("JMenu.font", g);
        menu.setFont(g);
        menu1.setFont(g);
        menu2.setFont(g);
        menu3.setFont(g);
        menu4.setFont(g);

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
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
        JPanel rightPanel = new JPanel();
        rightPanel.setBorder(new LineBorder(Color.BLACK, 5));
        rightPanel.setBackground(new java.awt.Color(211, 212, 250));
        rightPanel.setLayout(new FlowLayout(5));

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
//------------------------------------------------------------------------------
        JPanel center = new JPanel();
        center.setOpaque(true);        
        center.setBorder(new LineBorder(Color.BLACK, 3));
        center.setLayout(new FlowLayout(5));
        center.setBackground(new java.awt.Color(211, 212, 250));
        mainContainer.add(center, BorderLayout.CENTER);

                
        JPanel gridPanel3 = new JPanel();
        gridPanel3.setLayout(new GridLayout(1, 1, 1, 5));
        gridPanel3.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel3.setBackground(new java.awt.Color(145, 200, 100));
        
        
        JLabel titra = new JLabel("  AFFECTER UN ENSEIGNANT  ");
        gridPanel3.add(titra);
        Font t = new Font("Times New Roman", Font.BOLD, 24);
        UIManager.put("JLabel.font", t);
        titra.setFont(t);
        
        JPanel gridPanel7 = new JPanel();
        gridPanel7.setLayout(new GridLayout(2, 1, 1, 5));
        gridPanel7.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel7.setBackground(new java.awt.Color(145, 200, 100));
        
        TextField enseignant = new java.awt.TextField();
        enseignant.setText("Veuillez renseignar un enseignant");
        Font y = new Font("Times New Roman", Font.BOLD, 20);
        UIManager.put("JLabel.font", y);
        
        JLabel ense = new JLabel("Enseignant");
        ense.setFont(t);
        enseignant.setFont(y);
        
        gridPanel7.add(ense);
        gridPanel7.add(enseignant);             
       
        center.add(gridPanel3, BorderLayout.NORTH);
        center.add(gridPanel7, BorderLayout.WEST);
        
        
        
 //----------------------------------------       
        JPanel topIPanel = new JPanel();
        topIPanel.setBorder(new LineBorder(Color.BLACK, 3));
        topIPanel.setBackground(Color.yellow);
        topIPanel.setFont(new java.awt.Font("Perpetua Titling MT", 0, 48));
        topIPanel.setLayout(new FlowLayout(3));
        
        
        
        
        
        
//-----------------------------------------------------------
        JPanel gridPanel5 = new JPanel();
        gridPanel5.setLayout(new GridLayout(2,1, 1, 5));
        gridPanel5.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel5.setBackground(new java.awt.Color(145, 200, 100));

        

        JLabel labelFiltre = new JLabel(" Type de cours   ");
        labelFiltre.setFont(t);
        String[] selectionFiltre = {" TP", "TD", "Projet", "Soutien", "Magistral", "Interactif"};
        JComboBox listeSelectionFiltre = new JComboBox(selectionFiltre);
        listeSelectionFiltre.setFont(y);

        gridPanel5.add(labelFiltre);
        gridPanel5.add(listeSelectionFiltre);
 
        center.add(gridPanel5, BorderLayout.NORTH);

//------------------------------------------------------------------
        JPanel gridPanel8 = new JPanel();
        gridPanel8.setLayout(new GridLayout(2,1, 1, 5));
        gridPanel8.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel8.setBackground(new java.awt.Color(145, 200, 100));

        

        JLabel labelFiltre2 = new JLabel(" Jour de la semaine  ");
        labelFiltre2.setFont(t);
        String[] selectionFiltre2 = {" Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"};
        JComboBox listeSelectionFiltre2 = new JComboBox(selectionFiltre2);
        listeSelectionFiltre2.setFont(y);

        gridPanel8.add(labelFiltre2);
        gridPanel8.add(listeSelectionFiltre2);
 
        center.add(gridPanel8, BorderLayout.NORTH);
 //------------------------       
        
        JPanel gridPanel9 = new JPanel();
        gridPanel9.setLayout(new GridLayout(2,1, 1, 5));
        gridPanel9.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel9.setBackground(new java.awt.Color(145, 200, 100));

        

        JLabel labelFiltre3 = new JLabel(" Creneau d'affectation ");
        labelFiltre3.setFont(t);
        String[] selectionFiltre3 = {" 8h30 à 10h00", "10h15 à 11h45", "12h00 à 13h30", "13h45 à 15h15", "15h30 à 17h00", "17h15 à 18h45", "19h00 à 20h30" };
        JComboBox listeSelectionFiltre3 = new JComboBox(selectionFiltre3);
        listeSelectionFiltre3.setFont(y);

        gridPanel9.add(labelFiltre3);
        gridPanel9.add(listeSelectionFiltre3);
 
        center.add(gridPanel9, BorderLayout.NORTH);

//--------------------------------------------------------------------
         JPanel gridPanela = new JPanel();
        gridPanela.setLayout(new GridLayout(1,2, 10, 5));
        gridPanela.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanela.setBackground(new java.awt.Color(145, 200, 100));

        JButton Montrer = new JButton("Montrer les résults possibles");
        Montrer.setFont(f);

        JButton Montrer2 = new JButton("Valider l'affectation");
        Montrer2.setFont(f);
        
        gridPanela.add(Montrer);  
        gridPanela.add(Montrer2); 
 
        center.add(gridPanela, BorderLayout.NORTH);
        
        
        
        
//------------------------------------------------------------------
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
        jTable1.setPreferredScrollableViewportSize(new Dimension(2500, 950));
        jTable1.setRowHeight(130);
        TableColumn col = jTable1.getColumnModel().getColumn(0);
        col.setPreferredWidth(100);
        col = jTable1.getColumnModel().getColumn(1);
        col.setPreferredWidth(200);
        col = jTable1.getColumnModel().getColumn(2);
        col.setPreferredWidth(200);
        col = jTable1.getColumnModel().getColumn(3);
        col.setPreferredWidth(200);
        col = jTable1.getColumnModel().getColumn(4);
        col.setPreferredWidth(300);
        col = jTable1.getColumnModel().getColumn(5);
        col.setPreferredWidth(300);
        col = jTable1.getColumnModel().getColumn(6);
        col.setPreferredWidth(300);
        col = jTable1.getColumnModel().getColumn(7);
        col.setPreferredWidth(300);

        center.add(jScrollPane1, BorderLayout.CENTER);
//----------------------------------------------------------------------
        //------------------------------------------------------------------------------       
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());        
        bottomPanel.setBackground(new java.awt.Color(249, 207, 192));
        bottomPanel.setBorder(new LineBorder(Color.BLACK, 3));
        mainContainer.add(bottomPanel, BorderLayout.SOUTH);
        
        JPanel gridPanel2 = new JPanel();
        gridPanel2.setLayout(new GridLayout(1, 3,300, 5));
        gridPanel2.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel2.setBackground(new java.awt.Color(249, 207, 192));
        
        JLabel P1 = new JLabel("Seance choisit");
        JLabel P2 = new JLabel("Enseignants disponibles pour la séance choisit");        
        JLabel P3 = new JLabel("Seance mise à jour ");
        JLabel P4 = new JLabel("Commandes");
        
        Font r = new Font("Times New Roman", Font.BOLD, 24);
        UIManager.put("JMenuItem.font", r);
        P1.setFont(r);
        P2.setFont(r);
        P3.setFont(r);
        P4.setFont(r);
                      
        gridPanel2.add(P4, BorderLayout.PAGE_END);
        gridPanel2.add(P1, BorderLayout.PAGE_END);
        gridPanel2.add(P2, BorderLayout.PAGE_END);
        gridPanel2.add(P3, BorderLayout.PAGE_END);
        
        bottomPanel.add(gridPanel2, BorderLayout.SOUTH);
         
 //------------------------------ 
        JPanel gridPanel6 = new JPanel();
        gridPanel6.setLayout(new GridLayout(1, 3, 520, 5));
        gridPanel6.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel6.setBackground(new java.awt.Color(249, 242, 155));
        
        List listeSeance = new java.awt.List(10, false);
        List listeDeProfs = new java.awt.List(10, false);
        List listeSeancemodif = new java.awt.List(10, false);
        
        JButton jButton1 = new JButton("Changer l'enseignant");
        jButton1.setBounds(new Rectangle(218, 21, 129, 33));
        jButton1.setBackground(new java.awt.Color(211, 212, 250));
        jButton1.setIcon(new ImageIcon("img/add.png"));
        jButton1.setBorderPainted(false);
        
        JButton jButton2 = new JButton("Enlever l'enseigant");
        jButton2.setBounds(new Rectangle(218, 21, 129, 33));
        jButton2.setBackground(new java.awt.Color(211, 212, 250));
        jButton2.setIcon(new ImageIcon("img/trash.png"));
        jButton2.setBorderPainted(false);
        
        JButton jButton3 = new JButton("Valider le changement");
        jButton3.setBounds(new Rectangle(218, 21, 129, 33));
        jButton3.setBackground(new java.awt.Color(211, 212, 250));
        jButton3.setIcon(new ImageIcon("img/tick.png"));
        jButton3.setBorderPainted(false);
        
        Font n = new Font("Times New Roman", Font.BOLD, 32);
        UIManager.put("thelist.font", n);
        listeSeance.setFont(n);
        listeDeProfs.setFont(n);
        listeSeancemodif.setFont(n);
        
        
        JPanel gridPanels = new JPanel();
        gridPanels.setLayout(new GridLayout(3,1, 1050, 5));
        gridPanels.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanels.setBackground(new java.awt.Color(249, 242, 155));
        
        gridPanels.add(jButton2);
        gridPanels.add(jButton1);
        gridPanels.add(jButton3);
        
        gridPanel6.add(gridPanels);
        
        gridPanel6.add(listeSeance);
        gridPanel6.add(listeDeProfs);
        gridPanel6.add(listeSeancemodif);
        
        bottomPanel.add(gridPanel6, BorderLayout.CENTER);
    }
//------------------------------------------------------------------
        
    public static void main(String[] args) {
        Affecterenseignant mylayout = new Affecterenseignant("Accueil");
        mylayout.setVisible(true);
    }

}          
