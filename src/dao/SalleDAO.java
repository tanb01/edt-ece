package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import modele.Salle;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class SalleDAO extends DataAccessObject<Salle> {

    /**
     * Constructeur
     */
    public SalleDAO() {
        super();
    }

    /**
     * Fonction pour créer.
     *
     * @param objet
     * @return
     */
    public boolean creer(Salle objet) {
        return false;
    }

    /**
     * Fonction pour effacer.
     *
     * @param objet
     * @return
     */
    public boolean effacer(Salle objet) {
        return false;
    }

    /**
     * Fonction de mise à jour.
     *
     * @param objet
     * @return
     */
    public boolean mettreAJour(Salle objet) {
        return false;
    }

    /**
     * Fonction qui permet de chercher une salle dans la BDD grâce à son Id.
     *
     * @param id
     * @return
     */
    public Salle chercher(int id) {
        Salle salle = new Salle();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT capacite_salle, nom_salle, site_id FROM salle WHERE salle_id = " + id);
            if (result.first()) {
                salle = new Salle(id, result.getString("nom_salle"),
                        result.getInt("capacite_salle"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salle;
    }
//test

//    public static void main(String[] args) {
//        SalleDAO sa = new SalleDAO();
//        Salle un = sa.chercher(3);
//        un.afficher();
//    }
}
