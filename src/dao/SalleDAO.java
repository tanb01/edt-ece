package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import modele.Salle;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class SalleDAO extends DataAccessObject<Salle> {

    public SalleDAO() {
        super();
    }

    public boolean creer(Salle objet) {
        return false;
    }

    public boolean effacer(Salle objet) {
        return false;
    }

    public boolean mettreAJour(Salle objet) {
        return false;
    }

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
//        System.out.println("Groupe : " + un.getNomSalle());
//        System.out.println("Id : " + un.getSalleId());
//        System.out.println("Capacite : " + un.getCapacite());
//    }
}
