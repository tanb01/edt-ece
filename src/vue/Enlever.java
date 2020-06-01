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

public class Enlever extends JFrame {

    private String titrePage = null;
    private JTabbedPane onglet;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;

    private JScrollPane scroll;
    private DefaultTableModel model;
    List slist = new List(8,false);
    List thelist = new List(10,false);
    private JPanel center;

    public Enlever(String title) {

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
        
        
        JLabel titra = new JLabel("  TRAITEMENTS SUR UNE SEANCE  ");
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

//-----------------------------------------------------------
        JPanel gridPaneld = new JPanel();
        gridPaneld.setLayout(new GridLayout(2,1, 1, 5));
        gridPaneld.setBorder(new LineBorder(Color.BLACK, 3));
        gridPaneld.setBackground(new java.awt.Color(145, 200, 100));

        

        JLabel labelFiltre1 = new JLabel(" Groupe    ");
        labelFiltre1.setFont(t);
        String[] selectionFiltre1 = {"Gr01", "Gr02", "Gr03", "Gr04", "Gr05", "Gr06", "Gr07", "Gr08", "Gr09", "Gr10", "Gr11"};
        JComboBox listeSelectionFiltre1 = new JComboBox(selectionFiltre1);
        listeSelectionFiltre1.setFont(y);

        gridPaneld.add(labelFiltre1);
        gridPaneld.add(listeSelectionFiltre1);
 
        center.add(gridPaneld, BorderLayout.NORTH);

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
//---------------------------------------------------------------------------
        JPanel gridPanele = new JPanel();
        gridPanele.setLayout(new GridLayout(2, 1, 1, 5));
        gridPanele.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanele.setBackground(new java.awt.Color(145, 200, 100));
        
        TextField cap = new java.awt.TextField();
        cap.setText("Capacité suffisante");
                
        JLabel ense1 = new JLabel(" Capacité suffisante");
        ense1.setFont(t);
        cap.setFont(y);
        
        gridPanele.add(ense1);
        gridPanele.add(cap);             
       
        
        center.add(gridPanele, BorderLayout.WEST);
  
//---------------------------------------------------------------------------
        JPanel gridPanelf = new JPanel();
        gridPanelf.setLayout(new GridLayout(2, 1, 1, 5));
        gridPanelf.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanelf.setBackground(new java.awt.Color(145, 200, 100));
        
        JLabel etat = new JLabel(" Etat");
        etat.setFont(y);
                
        String[] selectionFiltre4 = {" 8h30 à 10h00", "10h15 à 11h45", "12h00 à 13h30", "13h45 à 15h15", "15h30 à 17h00", "17h15 à 18h45", "19h00 à 20h30" };
        JComboBox listeSelectionFiltre4 = new JComboBox(selectionFiltre4);
        listeSelectionFiltre4.setFont(y);

        gridPanelf.add(etat);  
        gridPanelf.add(listeSelectionFiltre4);
        etat.setFont(y);
        
        center.add(gridPanelf, BorderLayout.WEST);        
        
        
//--------------------------------------------------------------------
         JPanel gridPanela = new JPanel();
        gridPanela.setLayout(new GridLayout(1,9, 10, 5));
        gridPanela.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanela.setBackground(new java.awt.Color(145, 200, 100));

        JButton Montrer = new JButton("Montrer les résults possibles");
        Montrer.setFont(f);       
        
        gridPanela.add(Montrer);          
 
        center.add(gridPanela, BorderLayout.NORTH);
        
        
        
        

//----------------------------------------------------------------------

        JPanel gridPanel6 = new JPanel();
        gridPanel6.setLayout(new GridLayout(1, 5, 10, 5));
        gridPanel6.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel6.setBackground(new java.awt.Color(249, 242, 155));
//        
//        List listeDeProfs = new java.awt.List(30, false);
//        List listeDeSalles = new java.awt.List(30, false);
//        List listeDeCours = new java.awt.List(30, false);
        
//        gridPanel6.add(listeDeProfs);
//        gridPanel6.add(listeDeSalles);
//        gridPanel6.add(listeDeCours);
        
        center.add(gridPanel6, BorderLayout.CENTER);
        
//------------------------------------------------------------------
        


        gridPanel6.add(thelist);
        Font n = new Font("Times New Roman", Font.BOLD, 32);
        UIManager.put("thelist.font", n);
        thelist.setFont(n);
        slist.setFont(n);
        gridPanel6.add(new Button(">>>>"));
        
        gridPanel6.add(slist);
        gridPanel6.add(new Button("Clear"));
        gridPanel6.add(new Label("Select an item"));

//------------------------------------------------------------------
    }  
    public void init()
{
fillthelist();

}
public void fillthelist()
{
thelist.addItem("Coffee");
thelist.addItem("Bananas");
thelist.addItem("Oranges");
thelist.addItem("Pears");
thelist.addItem("Peaches");
thelist.addItem("Tuna");
thelist.addItem("Bread");
thelist.addItem("Milk");
thelist.addItem("Eggs");
thelist.addItem("Butter");
thelist.addItem("Sugar");
thelist.addItem("Cereal");
thelist.addItem("Java Manual");
}

public boolean action(Event evt, 
Object whatAction)
{
if(!(evt.target instanceof Button))
{
return false;
} 
String buttonLabel = (String) whatAction;
if (buttonLabel == ">>>>")
{
slist.addItem(thelist.getSelectedItem());
thelist.delItem(thelist.getSelectedIndex());
return true;
}
else
{
slist.clear();
thelist.clear();
fillthelist();
return true;
}
}
    public static void main(String[] args) {
        Enlever mylayout = new Enlever("Accueil");
        mylayout.setVisible(true);
    }

}          
