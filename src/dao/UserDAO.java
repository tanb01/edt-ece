package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import modele.User;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class UserDAO extends DataAccessObject<User> {

    public UserDAO() {
        super();
    }

    @Override
    public boolean creer(User objet) {
        return false;
    }

    @Override
    public boolean effacer(User objet) {
        return false;
    }

    @Override
    public boolean mettreAJour(User objet) {
        return false;
    }

    @Override
    public User chercher(int userId) {
        User user = new User();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT user_id "
                            + " FROM user WHERE user_id = " + userId);
            if (result.first()) {
                user = new User(
                        userId,
                        result.getString("email"),
                        result.getString("nom"),
                        result.getString("prenom"),
                        result.getInt("droit"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User chercherUserParEmailMotDePasse(String email, String password) {
        User user = new User();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT user_id, email, nom, prenom, droit FROM user WHERE email ='" + email + "' AND mot_de_passe ='" + password + "'");
            if (result.first()) {
                user = new User(
                        result.getInt("user_id"),
                        result.getString("email"),
                        result.getString("nom"),
                        result.getString("prenom"),
                        result.getInt("droit"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // Pour vérifier si c'est un utilisateur
    public boolean isUser(String email, String password) {
        boolean verifyUser = false;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT user_id FROM user WHERE email ='" + email + "' AND mot_de_passe ='" + password + "'");
            if (result.first()) {
                verifyUser = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return verifyUser;
    }

//test
    public static void main(String[] args) {
        UserDAO us = new UserDAO();
        System.out.println(us.isUser("bt@edu.ece.fr", "bt"));
        //System.out.println("Numero User: " + usBool.getNumeroEtudiant());
        //System.out.println("Prenom Etudiant: " + usBool.getPrenom());
    }
}
