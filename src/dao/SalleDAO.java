package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public ArrayList<Salle> chercherToutesLesSalles() {
        ArrayList<Salle> salles = new ArrayList<Salle>();
        Salle salle = new Salle();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT salle_id, capacite_salle, nom_salle, site_id FROM salle");
            while (result.next()) {
                salle = new Salle(result.getInt("salle_id"), result.getString("nom_salle"),
                        result.getInt("capacite_salle"));
                salles.add(salle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salles;
    }

    public ArrayList<Salle> chercherSallesParSeanceId(int seanceId) {
        ArrayList<Salle> salles = new ArrayList<Salle>();
        Salle salle = new Salle();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT salle.salle_id, capacite_salle, nom_salle, site_id FROM salle INNER JOIN seance_salles ON seance_salles.salle_id=salle.salle_id WHERE seance_salles.seance_id=" + seanceId);

            while (result.next()) {
                salle = new Salle(
                        result.getInt("salle.salle_id"),
                        result.getString("nom_salle"),
                        result.getInt("capacite_salle"));
                salles.add(salle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salles;
    }

//test
    public static void main(String[] args) {
        SalleDAO sa = new SalleDAO();
        Salle un = sa.chercher(3);
        un.afficher();
    }
}
