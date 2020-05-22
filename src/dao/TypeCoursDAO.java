package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import modele.TypeCours;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class TypeCoursDAO extends DataAccessObject<TypeCours> {

    public TypeCoursDAO() {
        super();
    }

    public boolean creer(TypeCours objet) {
        return false;
    }

    public boolean effacer(TypeCours objet) {
        return false;
    }

    public boolean mettreAJour(TypeCours objet) {
        return false;
    }

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
//test

    public static void main(String[] args) {
        TypeCoursDAO sa = new TypeCoursDAO();
        TypeCours un = sa.chercher(1);
        System.out.println("TypeCours : " + un.getNomTypeCours());
        System.out.println("Id : " + un.getTypeCoursId());
    }
}
