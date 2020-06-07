package vue;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import javax.swing.table.TableColumn;

public class Recapitulatif extends JFrame {

    private String titrePage = null;
    private JTabbedPane onglet;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;

    private JScrollPane scroll;
    private DefaultTableModel model;

    public Recapitulatif(String title) {

        super(title);
        this.setSize(2750, 1600);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

//------------------------------------------------------------------------------
        JPanel centerReca = new JPanel();
        centerReca.setOpaque(true);
        centerReca.setBorder(new LineBorder(Color.BLACK, 3));
        centerReca.setLayout(new FlowLayout(5));
        centerReca.setBackground(new java.awt.Color(211, 212, 250));
        mainContainer.add(centerReca, BorderLayout.CENTER);

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

        String[] selectionensegnat = {" Segado", "Espagnol", "Java", "Web Dynamique", "Probabilites et statistiques", "Thermodynamique", "Reseaux", "Traitement du signal", "Analyse de Fourier", "Analyse Financiere", "Japonais", "Geopolitique", "Electronique fondamentale", "Anthropologie", "Droit du travail"};
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

//------------------------------------------------------------------
//--------------------------------------------------------------------
        JPanel gridPanelare = new JPanel();
        gridPanelare.setLayout(new GridLayout(1, 2, 10, 5));
        gridPanelare.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanelare.setBackground(new java.awt.Color(145, 200, 100));

        JButton Montrerreca = new JButton("Montrer le recapitulatif");
        Montrerreca.setFont(f);

        gridPanelare.add(Montrerreca);

        centerReca.add(gridPanelare, BorderLayout.NORTH);

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
//----------------------------------------------------------------------

//------------------------------------------------------------------
    }

    public static void main(String[] args) {
        Recapitulatif mylayout = new Recapitulatif("Accueil");
        mylayout.setVisible(true);
    }

}
