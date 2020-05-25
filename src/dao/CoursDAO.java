package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import modele.Cours;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class CoursDAO extends DataAccessObject<Cours> {

    public CoursDAO() {
        super();
    }

    public boolean creer(Cours objet) {
        return false;
    }

    public boolean effacer(Cours objet) {
        return false;
    }

    public boolean mettreAJour(Cours objet) {
        return false;
    }

    public Cours chercher(int id) {
        Cours Cours = new Cours();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT nom_cours FROM `cours` WHERE cours_id = " + id);
            if (result.first()) {
                Cours = new Cours(id, result.getString("nom_cours"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Cours;
    }
//test

//    public static void main(String[] args) {
//        CoursDAO sa = new CoursDAO();
//        Cours un = sa.chercher(3);
//        System.out.println("Cours : " + un.getNomCours());
//        System.out.println("Id : " + un.getCoursId());
//    }
}