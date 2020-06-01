package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Fenêtre de connexion avec Email + Mot de passe et ensuite validation
 * 
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class LoginVue extends JFrame {

    private JLabel email, mdp;
    private JTextField emailField;
    private JPasswordField mdpField;
    private JButton connexion;
//    private boolean isConnected;

    public LoginVue() {
        super();
        // Titre de la fenêtre
        this.setTitle(" Connexion à l'emploi du temps ");
        // Taille de la fenêtre
        this.setSize(new Dimension(600, 300));
        this.setLocationRelativeTo(null);
        // Taille non-modifiable
        this.setResizable(false);

        // Email
        // Texte "Email : "
        email = new JLabel("Email : ");
        // Champ saisie email
        emailField = new JTextField();

        // Email
        // Texte "Mot de passe :"
        mdp = new JLabel("Mot de passe : ");
        // Champ saisie mot de passe
        mdpField = new JPasswordField();

        // Bouton de validation "Se connecter"
        connexion = new JButton("Se connecter");

        // Conteneur
        Container contenu = this.getContentPane();
        contenu.setLayout(null);

        // Ajout du texte "Email : "
        // Paramètres setBounds : coordonnée x, coordonnée y, taille x, taille y
        contenu.add(email);
        email.setBounds(140, 75, 100, 20);

        // Ajout du champ de saisie de l'email
        // Paramètres setBounds : coordonnée x, coordonnée y, taille x, taille y
        contenu.add(emailField);
        emailField.setBounds(268, 75, 150, 20);

        // Ajout du texte "Mot de passe : "
        // Paramètres setBounds : coordonnée x, coordonnée y, taille x, taille y
        contenu.add(mdp);
        mdp.setBounds(140, 110, 100, 20);

        // Ajout du champ de saisie du mot de passe
        // Paramètres setBounds : coordonnée x, coordonnée y, taille x, taille y
        contenu.add(mdpField);
        mdpField.setBounds(268, 110, 150, 20);

        // Ajout du bouton de connexion
        // Paramètres setBounds : coordonnée x, coordonnée y, taille x, taille y
        contenu.add(connexion);
        connexion.setBounds(243, 150, 125, 20);

//        isConnected = false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Getter
     * Pour l'email saisi
     * 
     * @return 
     */
    public String getEmail() {
        return emailField.getText();
    }

    /**
     * Pour le mot de passe saisi
     * 
     * @return 
     */
    public String getPassword() {
        return String.valueOf(mdpField.getPassword());
    }

    /**
     * Pour la validation de la connexion
     * 
     * @return 
     */
    public JButton getBoutonConnexion() {
        return connexion;
    }

//    /**
//     * Vérifie que l'utilisateur est connecté
//     * 
//     * @return 
//     */
//    public boolean getIsConnected() {
//        return isConnected;
//    }
//
//    /**
//     * Connexion de l'utilisateur
//     * 
//     * @param connection 
//     */
//    public void setIsConnected(boolean connection) {
//        isConnected = connection;
//    }
//
//    /**
//     * Déconnexion
//     */
//    public void logOut() {
//        isConnected = false;
//    }
    
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        LoginVue login = new LoginVue();
    }
}
