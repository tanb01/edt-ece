package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
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
        this.setTitle(" Page de connexion ");
        this.setSize(new Dimension(600, 300));
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        email = new JLabel("Email : ");
        emailField = new JTextField();

        mdp = new JLabel("Mot de passe : ");
        mdpField = new JPasswordField();

        connexion = new JButton("Se connecter");

        Container contenu = this.getContentPane();
        contenu.setLayout(null);

        contenu.add(email);
        email.setBounds(140, 75, 100, 20);

        contenu.add(emailField);
        emailField.setBounds(268, 75, 150, 20);

        contenu.add(mdp);
        mdp.setBounds(140, 110, 100, 20);

        contenu.add(mdpField);
        mdpField.setBounds(268, 110, 150, 20);

        contenu.add(connexion);
        connexion.setBounds(243, 150, 125, 20);

//        isConnected = false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getPassword() {
        return String.valueOf(mdpField.getPassword());
    }

    public JButton getBoutonConnexion() {
        return connexion;
    }

//    public boolean getIsConnected() {
//        return isConnected;
//    }
//
//    public void setIsConnected(boolean connection) {
//        isConnected = connection;
//    }
//
//    public void logOut() {
//        isConnected = false;
//    }
    public static void main(String[] args) {
        LoginVue login = new LoginVue();
    }
}
