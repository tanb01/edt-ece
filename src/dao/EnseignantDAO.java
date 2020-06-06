package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.Enseignant;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class EnseignantDAO extends DataAccessObject<Enseignant> {

    /**
     * Constructeur
     */
    public EnseignantDAO() {
        super();
    }

    /**
     * Fonction pour créer.
     *
     * @param objet
     * @return
     */
    public boolean creer(Enseignant objet) {
        return false;
    }

    /**
     * Fonction pour effacer.
     *
     * @param objet
     * @return
     */
    public boolean effacer(Enseignant objet) {
        return false;
    }

    /**
     * Fonction de mise à jour.
     *
     * @param objet
     * @return
     */
    public boolean mettreAJour(Enseignant objet) {
        return false;
    }

    /**
     * Fonction qui permet de chercher un enseignant dans la BDD grâce à son Id.
     *
     * @param id
     * @return
     */
    public Enseignant chercher(int id) {
        Enseignant enseignant = new Enseignant();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT user_id, email, nom,  prenom FROM user WHERE droit = 3 AND user_id = " + id);
            if (result.first()) {
                enseignant = new Enseignant(id, result.getString("email"), result.getString("nom"), result.getString("prenom"), 3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enseignant;
    }

    public ArrayList<Enseignant> chercherTousLesEnseignants() {
        ArrayList<Enseignant> enseignants = new ArrayList<Enseignant>();
        Enseignant enseignant = new Enseignant();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT user.user_id, email, nom, prenom FROM user INNER JOIN enseignant ON user.user_id=enseignant.user_id WHERE user.droit = 3");
            while (result.next()) {
                enseignant = new Enseignant(result.getInt("user.user_id"), result.getString("email"), result.getString("nom"), result.getString("prenom"), 3);
                enseignants.add(enseignant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enseignants;

    }

    /**
     * Fonction qui permet l'affichage du nom d'un enseignant.
     *
     * @param id
     * @return
     */
    public Enseignant Afficher_nom(int id) {
        Enseignant enseignant = new Enseignant();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT user_id, nom,  prenom FROM user WHERE droit = 3 AND user_id = " + id);
            if (result.first()) {
                enseignant = new Enseignant(id, result.getString("email"), result.getString("nom"), result.getString("prenom"), 3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enseignant;
    }
//test

//    public static void main(String[] args) {
//        EnseignantDAO sa = new EnseignantDAO();
//        Enseignant un = sa.chercher(43);
//        un.afficher();
//            for (Enseignant e : listEnseignants) {
//            System.out.println(e.getNom());
//        }
//    }
}
