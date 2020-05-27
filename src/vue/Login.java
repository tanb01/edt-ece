package vue;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class Login extends JFrame {

    JLabel email, mdp;
    JTextField emailField;
    JPasswordField mdpField;
    JButton connexion;

    public Login() {

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
        connexion.setBounds(243, 150, 100, 20);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        Login login = new Login();
    }
}
