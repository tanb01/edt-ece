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

public class SallesLibres extends JFrame {

    private String titrePage = null;
    private JTabbedPane onglet;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;

    private JScrollPane scroll;
    private DefaultTableModel model;

    public SallesLibres(String title) {

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
        
        
        JLabel titra = new JLabel("  Salles libres    ");
        gridPanel3.add(titra);
        Font t = new Font("Times New Roman", Font.BOLD, 24);
        UIManager.put("JLabel.font", t);
        titra.setFont(t);
        
        JPanel gridPanel7 = new JPanel();
        gridPanel7.setLayout(new GridLayout(1,2 , 1, 5));
        gridPanel7.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel7.setBackground(new java.awt.Color(145, 200, 100));
        
        TextField enseignant = new java.awt.TextField();
        enseignant.setText("                 ");
        Font y = new Font("Times New Roman", Font.BOLD, 20);
        UIManager.put("JLabel.font", y);
        
        JLabel ense = new JLabel(" Capacité maximal  ");
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
        gridPanel5.setLayout(new GridLayout(1,2, 1, 5));
        gridPanel5.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel5.setBackground(new java.awt.Color(145, 200, 100));

        

        JLabel labelFiltre = new JLabel("   Durée   ");
        labelFiltre.setFont(t);
        String[] selectionFiltre = {"15mn ", "30mn", "45mn", "1h00", "1h15", "1h30","1h45","2h00", "2h15", "2h30","2h45","3h00", "3h15", "3h30","3h45","3h00", "3h15", "3h30","3h45","4h00", "4h15", "4h30","4h45","5h00", "5h15", "5h30","5h45","6h00", "6h15", "6h30","6h45","7h00", "7h15", "7h30","7h45","6h00"};
        JComboBox listeSelectionFiltre = new JComboBox(selectionFiltre);
        listeSelectionFiltre.setFont(y);

        gridPanel5.add(labelFiltre);
        gridPanel5.add(listeSelectionFiltre);
 
        center.add(gridPanel5, BorderLayout.NORTH);

//------------------------------------------------------------------
        JPanel gridPanel8 = new JPanel();
        gridPanel8.setLayout(new GridLayout(1,2, 1, 5));
        gridPanel8.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel8.setBackground(new java.awt.Color(145, 200, 100));

        

        JLabel labelFiltre2 = new JLabel(" Site  ");
        labelFiltre2.setFont(t);
        String[] selectionFiltre2 = {" Eiffel 1", "Eiffel 2", "Eiffel 3", "Eiffel 4", "Eiffel 5", "Cnam"};
        JComboBox listeSelectionFiltre2 = new JComboBox(selectionFiltre2);
        listeSelectionFiltre2.setFont(y);

        gridPanel8.add(labelFiltre2);
        gridPanel8.add(listeSelectionFiltre2);
 
        center.add(gridPanel8, BorderLayout.NORTH);
//------------------------------------------------------------------
 
//------------------------------------------------------------------
        JPanel gridPanel9 = new JPanel();
        gridPanel9.setLayout(new GridLayout(1,1, 1, 5));
        gridPanel9.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel9.setBackground(new java.awt.Color(145, 200, 100));

        JCheckBox cb1 = new JCheckBox("Ignorer les salles ayant des demandes de réservation en cours");  
        Font w = new Font("Times New Roman", Font.BOLD, 20);
        UIManager.put("JCheckBox.font", w);
        cb1.setFont(w);
       
        JPanel gridPanela = new JPanel();
        gridPanela.setLayout(new GridLayout(1,2, 10, 5));
        gridPanela.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanela.setBackground(new java.awt.Color(145, 200, 100));

        JButton Montrer2 = new JButton("Valider l'affectation");
        Montrer2.setFont(f);        
         
        gridPanela.add(Montrer2); 
        gridPanel9.add(cb1);
             
        
        
        center.add(gridPanel9, BorderLayout.NORTH);
        
      
//----------------------------------------------------------------


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
        jTable1.setPreferredScrollableViewportSize(new Dimension(2600, 700));
        jTable1.setRowHeight(100);
        
        Font z = new Font("Times New Roman", Font.BOLD, 20);
        UIManager.put("JTable.font", z);
        jTable1.setFont(z);
        
        TableColumn col = jTable1.getColumnModel().getColumn(0);
        col.setPreferredWidth(100);
        col = jTable1.getColumnModel().getColumn(1);
        col.setPreferredWidth(350);
        col = jTable1.getColumnModel().getColumn(2);
        col.setPreferredWidth(350);
        col = jTable1.getColumnModel().getColumn(3);
        col.setPreferredWidth(350);
        col = jTable1.getColumnModel().getColumn(4);
        col.setPreferredWidth(350);
        col = jTable1.getColumnModel().getColumn(5);
        col.setPreferredWidth(350);
        col = jTable1.getColumnModel().getColumn(6);
        col.setPreferredWidth(300);
        col = jTable1.getColumnModel().getColumn(7);
        col.setPreferredWidth(350);

        center.add(jScrollPane1, BorderLayout.CENTER);
//----------------------------------------------------------------------
        //------------------------------------------------------------------------------       
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());        
        bottomPanel.setBackground(new java.awt.Color(249, 207, 192));
        bottomPanel.setBorder(new LineBorder(Color.BLACK, 3));
        mainContainer.add(bottomPanel, BorderLayout.SOUTH);
        
        JPanel gridPanel2 = new JPanel();
        gridPanel2.setLayout(new GridLayout(1, 3, 950, 5));
        gridPanel2.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel2.setBackground(new java.awt.Color(249, 207, 192));
        
        JLabel P1 = new JLabel("Liste de Salles disponibles");        
        
        Font r = new Font("Times New Roman", Font.BOLD, 24);
        UIManager.put("JMenuItem.font", r);
        P1.setFont(r);
        
                      
        gridPanel2.add(P1, BorderLayout.PAGE_END);    
        
        bottomPanel.add(gridPanel2, BorderLayout.SOUTH);
         
 //------------------------------ 
        JPanel gridPanel6 = new JPanel();
        gridPanel6.setLayout(new GridLayout(1, 3, 1050, 5));
        gridPanel6.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel6.setBackground(new java.awt.Color(249, 242, 155));       
        
        List listeDeSalles = new java.awt.List(50, false); 
        
        
        gridPanel6.add(listeDeSalles);      
        
        bottomPanel.add(gridPanel6, BorderLayout.CENTER);
    }
//------------------------------------------------------------------
        
    public static void main(String[] args) {
        SallesLibres mylayout = new SallesLibres("Accueil");
        mylayout.setVisible(true);
    }

}          
