package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.Cours;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class CoursDAO extends DataAccessObject<Cours> {

    /**
     * Constructeur
     */
    public CoursDAO() {
        super();
    }

    /**
     * Fonction pour créer.
     *
     * @param objet
     * @return
     */
    public boolean creer(Cours objet) {
        return false;
    }

    /**
     * Fonction pour effacer.
     *
     * @param objet
     * @return
     */
    public boolean effacer(Cours objet) {
        return false;
    }

    /**
     * Fonction de mise à jour.
     *
     * @param objet
     * @return
     */
    public boolean mettreAJour(Cours objet) {
        return false;
    }

    /**
     * Fonction qui permet de chercher un cours dans la BDD grâce à son Id.
     *
     * @param id
     * @return
     */
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

    public ArrayList<Cours> chercherTousLesCours() {
        ArrayList<Cours> courss = new ArrayList<Cours>();
        Cours cours = new Cours();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT cours_id, nom_cours FROM `cours`  ORDER BY cours_id");
            while (result.next()) {
                cours = new Cours(result.getInt("cours_id"), result.getString("nom_cours"));
                courss.add(cours);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courss;
    }
    
//test
    public static void main(String[] args) {
        CoursDAO sa = new CoursDAO();
        Cours un = sa.chercher(3);
        un.afficher();

//        for (Cours t : listCours) {
//            System.out.println(t.getNomCours());
//        }
    }

}
