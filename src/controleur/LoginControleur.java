package controleur;

import dao.UserDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modele.User;
import vue.LoginVue;
import vue.UserVue;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class LoginControleur implements ActionListener {

    private UserDAO udao = new UserDAO();
    private LoginVue vue = new LoginVue();
    private boolean isConnected;
    private boolean alreadyLoggedIn;

    public LoginControleur() {
        isConnected = false;
        alreadyLoggedIn = false;
    }

    public void control() {
        vue.getBoutonConnexion().addActionListener(this);
        System.out.println("Control");
    }

    public boolean getIsConnected() {
        return isConnected;
    }

    public void setIsConnected(boolean connection) {
        isConnected = connection;
    }

    public void logOut() {
        isConnected = false;
    }

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
            UserVue userVue = new UserVue();
            UserControleur controleur = new UserControleur(user, userVue);
        }
    }
}
