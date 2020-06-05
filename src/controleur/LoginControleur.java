package controleur;

import dao.UserDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modele.User;
import vue.EnseignantVue;
import vue.EtudiantVue;
import vue.LoginVue;
import vue.UserVue;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class LoginControleur implements ActionListener {

    // Variables locales de LoginControleur
    private UserDAO udao = new UserDAO();
    private LoginVue vue = new LoginVue();
    private boolean isConnected;
    private boolean alreadyLoggedIn;

    /**
     * Constructeur Personne de connecté
     */
    public LoginControleur() {
        isConnected = false;
        alreadyLoggedIn = false;
    }

    /**
     *
     */
    public void control() {
        vue.getBoutonConnexion().addActionListener(this);
        System.out.println("Control");
    }

    /**
     * Vérifie si l'utilisateur est connecté
     *
     * @return
     */
    public boolean getIsConnected() {
        return isConnected;
    }

    /**
     * Connexion de l'utilisateur
     *
     * @param connection
     */
    public void setIsConnected(boolean connection) {
        isConnected = connection;
    }

    /**
     * Déconnexion
     */
    public void logOut() {
        isConnected = false;
    }

    /**
     * Fonction qui vérifie : - Si l'utilisateur est déjà connecté - Si l'email
     * ou le mot de passe de l'utilisateur est incorrect Si l'utilisateur n'est
     * pas connecté + son email et son mot de passe sont corrects Alors il se
     * connecte.
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (isConnected == true && alreadyLoggedIn == true) {
            System.out.println("Utilisateur " + vue.getEmail() + " est deja connecte");
        }
        if (udao.isUser(vue.getEmail(), vue.getPassword()) && alreadyLoggedIn == false) {
            isConnected = true;
            System.out.println("Utilisateur " + vue.getEmail() + " est connecte");
        } else if (!udao.isUser(vue.getEmail(), vue.getPassword()) && alreadyLoggedIn == false) {
            System.out.println("Votre email ou mot de passe est incorrect");
        }
        if (isConnected == true && alreadyLoggedIn == false) {
            alreadyLoggedIn = true;
            vue.setVisible(false);
            UserDAO userInfo = new UserDAO();
            User user = userInfo.chercherUserParEmailMotDePasse(vue.getEmail(), vue.getPassword());
            switch (user.getDroit()) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    EnseignantVue enseignantVue = new EnseignantVue("Welcome " + user.getPrenom() + " " + user.getNom());
                    EnseignantEDTControleur enseignantControleur = new EnseignantEDTControleur(user, enseignantVue);
                    enseignantControleur.control();
                    break;
                case 4:
                    EtudiantVue etudiantVue = new EtudiantVue("Welcome " + user.getPrenom() + " " + user.getNom());
                    EtudiantEDTControleur etudiantControleur = new EtudiantEDTControleur(user, etudiantVue);
                    etudiantControleur.control();
                    break;
            }
        }
    }
}
