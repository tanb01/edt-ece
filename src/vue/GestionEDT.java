package vue;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class GestionEDT extends JPanel {

    private String titrePage = null;
    private JButton retour = null;
    private JButton ajouterSeance = null;
    private JButton supprimerSeance = null;
    private JButton modifierSeance = null;

    public GestionEDT() {
        titrePage = "Gestion de l'emploi du temps";
        retour = new JButton("Retour");
        ajouterSeance = new JButton("Ajouter");
        supprimerSeance = new JButton("Supprimer");
        modifierSeance = new JButton("Modifier");

        modifierSeance.setBackground(new java.awt.Color(255, 204, 204));
        modifierSeance.setFont(new java.awt.Font("Tahoma", 0, 36));
        modifierSeance.setText("Modifier ");
        modifierSeance.setBorder(new javax.swing.border.MatteBorder(null));

        supprimerSeance.setBackground(new java.awt.Color(150, 233, 200));
        supprimerSeance.setFont(new java.awt.Font("Tahoma", 0, 36));
        supprimerSeance.setText("Supprimer ");
        supprimerSeance.setBorder(new javax.swing.border.MatteBorder(null));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setVisible(true);

        this.setBorder(new LineBorder(Color.BLACK, 2));
        this.setBackground(Color.white);
        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setLayout(new GridLayout(2, 1));

        JPanel topPanel = new JPanel();
        topPanel.setBorder(new LineBorder(Color.BLACK, 3));
        topPanel.setSize(50, 50);
        topPanel.setBackground(Color.pink);
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        topPanel.setBorder(new EmptyBorder(10, 1, 1, 1));

        JPanel leftPanel = new JPanel();
        leftPanel.setBorder(new LineBorder(Color.BLACK, 10));
        leftPanel.setBackground(Color.green);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel rightPanel = new JPanel();
        rightPanel.setBorder(new LineBorder(Color.BLACK, 3));
        rightPanel.setBackground(Color.blue);
        rightPanel.setLayout(new GridLayout(10, 1));
        rightPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JSplitPane doublePanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);

        JLabel titre = new JLabel(titrePage);

        topPanel.add(retour);
        topPanel.add(titre);

        this.add(topPanel);

        this.add(doublePanel);

        leftPanel.add(ajouterSeance);
        leftPanel.add(supprimerSeance);
        leftPanel.add(modifierSeance);

    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                JFrame fr = new JFrame();

                GestionEDT vue = new GestionEDT();
                fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fr.add(vue);
                fr.setVisible(true);
            }

        });
    }

}
