package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import modele.Enseignant;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class EnseignantDAO extends DataAccessObject<Enseignant> {

    public EnseignantDAO() {
        super();
    }

    public boolean creer(Enseignant objet) {
        return false;
    }

    public boolean effacer(Enseignant objet) {
        return false;
    }

    public boolean mettreAJour(Enseignant objet) {
        return false;
    }

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
//test

//    public static void main(String[] args) {
//        EnseignantDAO sa = new EnseignantDAO();
//        Enseignant un = sa.chercher(43);
//        un.afficher();
//    }
    
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
}
