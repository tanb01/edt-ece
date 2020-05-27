package vue;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import static javafx.scene.paint.Color.color;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class Layout extends JFrame
{
    private String titrePage = null;
    private JTable table;
	private String[] title= {"N° habit", "Image", "Couleur", "Style vestimentaire", "Motif"};
	private ImageIcon icon = new ImageIcon("sablier.png");	
	private Object[][] data= {                               
			{"Habit 1", icon, "Beige", "Bureau", "Carreaux"},
	};
        
	private JScrollPane scroll;
	private DefaultTableModel model;
    
    public Layout(String title){
        
        super(title);
        this.setSize(2750,1600);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton button10 = new JButton("10");
        JButton button11= new JButton("11");
        JButton button12 = new JButton("12");
        JButton button13 = new JButton("13");
        JButton button14 = new JButton("14");
        JButton button15 = new JButton("15");
        JButton button16 = new JButton("16");
        JButton button17 = new JButton("17");
        JButton button18 = new JButton("18");
        JButton button19 = new JButton("19");
        JButton button20 = new JButton("20");
        JButton button21 = new JButton("21");
        JButton button22 = new JButton("22");
        JButton button23 = new JButton("23");
        JButton button24 = new JButton("24");
        JButton button25 = new JButton("25");
        JButton button26 = new JButton("26");
        JButton button27 = new JButton("27");
        JButton button28 = new JButton("28");
        JButton button29 = new JButton("29");
        JButton button30 = new JButton("30");
        JButton button31 = new JButton("31");
        JButton button32 = new JButton("32");
        JButton button33 = new JButton("33");
        JButton button34 = new JButton("34");
        JButton button35 = new JButton("35");
        JButton button36 = new JButton("36");
        JButton button37 = new JButton("37");
        JButton button38 = new JButton("38");
        JButton button39 = new JButton("39");
        JButton button40 = new JButton("40");
        JButton button41 = new JButton("41");
        JButton button42 = new JButton("42");
        JButton button43 = new JButton("43");
        JButton button44 = new JButton("44");
        JButton button45 = new JButton("45");
        JButton button46= new JButton("46");
        JButton button47 = new JButton("47");
        JButton button48 = new JButton("48");
        JButton button49 = new JButton("49");
        JButton button50 = new JButton("50");
        JButton button51 = new JButton("51");
        JButton button52 = new JButton("52");
        JButton button53 = new JButton("Emploi du temps");
        JButton button54 = new JButton("Salles libres");
        JButton button55 = new JButton("Stadistiques");
        JButton button56 = new JButton("Recapitulatif de cours");
        JButton button57 = new JButton("Cours annulés");
        JButton button58 = new JButton("Comment utiliser l'apllication?");
        JButton button59 = new JButton("");
        
        
        
        
        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout(8,6));
        mainContainer.setBackground(Color.yellow);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4, Color.GREEN));
        
        JPanel topPanel = new JPanel();
        topPanel.setBorder(new LineBorder(Color.BLACK,5));
        topPanel.setBackground(new java.awt.Color(150, 233, 200));
        topPanel.setLayout(new FlowLayout(5));
        mainContainer.add(topPanel,BorderLayout.NORTH);
        
        topPanel.add(button1);
        topPanel.add(button2);
        topPanel.add(button3);
        topPanel.add(button4);
        topPanel.add(button5);
        topPanel.add(button6);
        topPanel.add(button7);
        topPanel.add(button8);
        topPanel.add(button9);
        topPanel.add(button10);
        topPanel.add(button11);
        topPanel.add(button12);
        topPanel.add(button13);
        topPanel.add(button14);
        topPanel.add(button15);
        topPanel.add(button16);
        topPanel.add(button17);
        topPanel.add(button18);
        topPanel.add(button19);
        topPanel.add(button20);
        topPanel.add(button21);
        topPanel.add(button22);
        topPanel.add(button23);
        topPanel.add(button24);
        topPanel.add(button25);
        topPanel.add(button26);
        topPanel.add(button27);
        topPanel.add(button28);
        topPanel.add(button29);
        topPanel.add(button30);
        topPanel.add(button31);
        topPanel.add(button32);
        topPanel.add(button33);
        topPanel.add(button34);
        topPanel.add(button35);
        topPanel.add(button36);
        topPanel.add(button37);
        topPanel.add(button38);
        topPanel.add(button39);
        topPanel.add(button40);
        topPanel.add(button41);
        topPanel.add(button42);
        topPanel.add(button43);
        topPanel.add(button44);
        topPanel.add(button45);
        topPanel.add(button46);
        topPanel.add(button47);
        topPanel.add(button48);
        topPanel.add(button49);
        topPanel.add(button50);
        topPanel.add(button51);
        topPanel.add(button52);
        
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
        
        JLabel label = new JLabel ();
        label.setOpaque(true);
        label.setBorder(new LineBorder(Color.BLACK,3));
        label.setBackground(new java.awt.Color(150, 233, 200));
        label.setLayout(new FlowLayout(5));
        JLabel label1 = new JLabel();
        mainContainer.add(label1,BorderLayout.CENTER);        
        Component Component = label.add(label1); /*add*/
        label1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        label1.setText("Voici l'emploie du temps de cette Semaine ");
        JLabel label2 = new JLabel();
        mainContainer.add(label2,BorderLayout.CENTER);        
        Component ComponentS = label.add(label2); /*add*/
        label2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        
        label2.setText("MARDI 02");
        label2.add(button2);
        
        
        
                
        rightPanel.add(gridPanel);
        mainContainer.add(label);
        mainContainer.add(rightPanel, BorderLayout.WEST);
        
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.add(button58);
        bottomPanel.setBackground(new java.awt.Color(200, 100, 200));
        bottomPanel.setBorder(new LineBorder(Color.BLACK,3));
        mainContainer.add(bottomPanel, BorderLayout.SOUTH);
        
        
                
        
    }
    
    
    public static void main(String[] args)
    {
        Layout mylayout = new Layout("Accueil");
        mylayout.setVisible(true);
        
    }
 
    }
           
