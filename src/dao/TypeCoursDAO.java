package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.TypeCours;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class TypeCoursDAO extends DataAccessObject<TypeCours> {

    /**
     * Constructeur
     */
    public TypeCoursDAO() {
        super();
    }

    /**
     * Fonction pour créer.
     *
     * @param objet
     * @return
     */
    public boolean creer(TypeCours objet) {
        return false;
    }

    /**
     * Fonction pour effacer.
     *
     * @param objet
     * @return
     */
    public boolean effacer(TypeCours objet) {
        return false;
    }

    /**
     * Fonction de mise à jour.
     *
     * @param objet
     * @return
     */
    public boolean mettreAJour(TypeCours objet) {
        return false;
    }

    /**
     * Fonction qui permet de chercher un Type de cours dans la BDD grâce à son
     * Id.
     *
     * @param id
     * @return
     */
    public TypeCours chercher(int id) {
        TypeCours typeCours = new TypeCours();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT nom_type_cours FROM `type_cours` WHERE type_cours_id = " + id);
            if (result.first()) {
                typeCours = new TypeCours(id, result.getString("nom_type_cours"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeCours;
    }

    public ArrayList<TypeCours> chercherTousLesTypeCours() {
        ArrayList<TypeCours> typeCourss = new ArrayList<TypeCours>();
        TypeCours typeCours = new TypeCours();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT type_cours_id, nom_type_cours FROM `type_cours`  ORDER BY type_cours_id");
            while (result.next()) {
                typeCours = new TypeCours(result.getInt("type_cours_id"), result.getString("nom_type_cours"));
                typeCourss.add(typeCours);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeCourss;
    }

//test
    public static void main(String[] args) {
        TypeCoursDAO sa = new TypeCoursDAO();
        TypeCours un = sa.chercher(1);
        un.afficher();

//        for (TypeCours t : listTypeCours) {
//            System.out.println(t.getNomTypeCours());
//        }
    }

}
