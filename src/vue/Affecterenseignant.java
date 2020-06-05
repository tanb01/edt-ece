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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.TableColumn;

public class Affecterenseignant extends JFrame {

    private String titrePage = null;
    private JTabbedPane onglet;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;

    private JScrollPane scroll;
    private DefaultTableModel model;
    List slist = new List(10,false);
    List thelist = new List(10,false);
    List dlist = new List(10,false);
    List mlist = new List(10,false);
    private JPanel center;

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
        JPanel Modifierseance = new JPanel();
        Modifierseance.setOpaque(true);        
        Modifierseance.setBorder(new LineBorder(Color.BLACK, 3));
        Modifierseance.setLayout(new FlowLayout(5));
        Modifierseance.setBackground(new java.awt.Color(211, 212, 250));
        mainContainer.add(Modifierseance, BorderLayout.CENTER);
        
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
        
        JButton valider = new JButton("Valider la séance");
        valider.setFont(f);
        valider.setIcon(new ImageIcon("img/check.png"));
        valider.setBackground(new java.awt.Color(251, 231, 188));
        
        
        JButton valider2 = new JButton("Valider la modification");
        valider2.setFont(f);
        valider2.setIcon(new ImageIcon("img/check.png"));
        valider2.setBackground(new java.awt.Color(251, 231, 188));
        
        
        JButton valider3 = new JButton("Valider le changement");
        valider3.setFont(f);
        valider3.setIcon(new ImageIcon("img/check.png"));
        valider3.setBackground(new java.awt.Color(251, 231, 188));
        
        JButton valider4 = new JButton("Enlever");
        valider4.setFont(f);
        valider4.setIcon(new ImageIcon("img/check.png"));
        valider4.setBackground(new java.awt.Color(251, 231, 188));
        
        gridPanel8.add(valider);
        gridPanel8.add(valider2);
        gridPanel8.add(valider3);
        gridPanel8.add(valider4);

////////////////////////////////////////////////////////////////////////////////        
        Modifierseance.add(gridPanel3, BorderLayout.NORTH);
        Modifierseance.add(gridPanel7, BorderLayout.WEST);
        Modifierseance.add(gridPanel8, BorderLayout.SOUTH);
        
        
        
 //----------------------------------------       


////////////////////////////////////////////////////////////////////////////////        
       
////////////////////////////////////////////////////////////////////////////////        

    }  
   



    public static void main(String[] args) {
        Affecterenseignant mylayout = new Affecterenseignant("Accueil");
        mylayout.setVisible(true);
    }

}          
