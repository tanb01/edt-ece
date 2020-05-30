package vue;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import static java.awt.BorderLayout.CENTER;
import java.util.Random;
import static javafx.scene.paint.Color.color;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.event.*;
import javax.swing.table.TableColumn;



/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */


public class NewClass extends JFrame{
    private String titrePage = null;
    private JTabbedPane onglet;
    
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    
    public NewClass(String title) {
    
        super(title);
        this.setSize(2750,1600);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel  label1= new JLabel();
        JButton  button1 = new JButton("AFFICHER");
        JLabel label2 = new JLabel();
        JButton  button2 = new JButton("MODIFIER");
        JButton  button3 = new JButton("AJOUTER");
        JTextField  textField1= new JTextField();
        JTextField  textField2= new JTextField();
        JTextField  textField3= new JTextField();
        JTextField  textField4= new JTextField();
        JTextField  textField5= new JTextField();
        JTextField  textField6= new JTextField();
        JTextField  textField7= new JTextField();
        JTextField  textField8= new JTextField();
        JTextField  textField9= new JTextField();
        JTextField  textField10= new JTextField();
        JTextField  textField11= new JTextField();
        JButton button53 = new JButton("Emploi du temps");
        button53.setPreferredSize(new Dimension(150, 120));
        JButton button54 = new JButton("Salles libres");
        JButton button55 = new JButton("Modifier un cours");
        JButton button56 = new JButton("Modifier une Seance");
        JButton button57 = new JButton("Modifier un Groupe");
        JButton button58 = new JButton("Modifier un ensegnant");
        JButton button59 = new JButton("Comment utiliser l'apllication?");
        
        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout(8,6));
        mainContainer.setBackground(Color.yellow);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4, Color.GREEN));
        
        JPanel topPanel = new JPanel();
        topPanel.setBorder(new LineBorder(Color.BLACK,5));
        topPanel.setBackground(new java.awt.Color(150, 233, 200));
        topPanel.setLayout(new FlowLayout(5));
        mainContainer.add(topPanel,BorderLayout.NORTH);
        
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("COURS");
        JMenu menu1 = new JMenu("ETUDIANTS");
        JMenu menu2 = new JMenu("PROMOTIONS");
        JMenu menu3 = new JMenu("ENSEIGNANTS");
        JMenu menu4 = new JMenu("SALLES");
        
        
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
        
        JPanel rightPanel = new JPanel();
        rightPanel.setBorder(new LineBorder(Color.BLACK,5));
        rightPanel.setBackground(new java.awt.Color(200, 233, 200));
        rightPanel.setLayout(new FlowLayout(5));
        
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(5,1,5,5));
        gridPanel.setBorder(new LineBorder(Color.BLACK,3));
        gridPanel.setBackground(new java.awt.Color(200, 100, 200));
        
        gridPanel.add(button53);
        gridPanel.add(button54);
        gridPanel.add(button55);
        gridPanel.add(button56);
        gridPanel.add(button57);
        
        rightPanel.add(gridPanel);        
        mainContainer.add(rightPanel, BorderLayout.WEST);
        
        
        
        

        label1.setText("                                                                                                                                  GESTION DE L'EMPLOIE DU TEMPS");
        label1.setFont(new java.awt.Font("Perpetua Titling MT", 0, 28));
        label1.setHorizontalAlignment(JLabel.CENTER);
        
        

        button1.setText("AJOUTER");

        label2.setText("Veuillez chosir une de 3 actions ci dessous pour faire de modifications dans l'emploie du temps des etudiants et des enseignants.");

        button2.setText("AFFECTER");

        button3.setText("MODIFIER");

        textField1.setText("Affecter un enseignant dans une séance");

        textField2.setText("Affecter un groupe dans une séance");
        textField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }

        private void jTextField2ActionPerformed(ActionEvent evt) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        });

        textField3.setText("Affecter une salle à une séance");
        textField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }

        private void jTextField3ActionPerformed(ActionEvent evt) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        });

        textField4.setText("Modifier un cours");
        textField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }

        private void jTextField4ActionPerformed(ActionEvent evt) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        });

        textField5.setText("Déplacer une séance de cours");
        textField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }

        private void jTextField5ActionPerformed(ActionEvent evt) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        });

        textField6.setText("Annuler une séance");
        textField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }

        private void jTextField6ActionPerformed(ActionEvent evt) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        });

        textField7.setText("Valider une séance");
        textField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }

        private void jTextField7ActionPerformed(ActionEvent evt) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        });

        textField8.setText("Enlever une séance");
        textField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }

        private void jTextField8ActionPerformed(ActionEvent evt) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        });

        textField9.setText("Ajouter une séance");
        textField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }

        private void jTextField9ActionPerformed(ActionEvent evt) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        });

        textField10.setText("Ajouter un enseignant à une séance");
        textField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }

        private void jTextField10ActionPerformed(ActionEvent evt) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        });

        textField11.setText("Ajouter un groupe à une séance");
        textField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }

        private void jTextField11ActionPerformed(ActionEvent evt) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        });
    
}

   
    public static void main(String[] args)
    {
        NewClass my;
        my = new NewClass("Accueilg");
        my.setVisible(true);
    
}
}

    
