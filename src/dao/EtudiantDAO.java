package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import modele.Etudiant;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class EtudiantDAO extends DataAccessObject<Etudiant> {

    public EtudiantDAO() {
        super();
    }

    @Override
    public boolean creer(Etudiant objet) {
        return false;
    }

    @Override
    public boolean effacer(Etudiant objet) {
        return false;
    }

    @Override
    public boolean mettreAJour(Etudiant objet) {
        return false;
    }

    @Override
    public Etudiant chercher(int id) {
        Etudiant etudiant = new Etudiant();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT email, "
                            + "nom, prenom, droit, numero_etudiant, groupe_id"
                            + " FROM etudiant JOIN user "
                            + "ON etudiant.user_id = user.user_id "
                            + "WHERE user.user_id = " + id);
            if (result.first()) {
                etudiant = new Etudiant(
                        id,
                        result.getString("email"),
                        result.getString("nom"),
                        result.getString("prenom"),
                        result.getInt("droit"),
                        result.getInt("numero_etudiant"),
                        result.getInt("groupe_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiant;
    }
    
//test
    public static void main(String[] args) {
        EtudiantDAO et = new EtudiantDAO();
        Etudiant un = et.chercher(213);
        System.out.println("Numero Etudiant: " + un.getNumeroEtudiant());
        System.out.println("Prenom Etudiant: " + un.getPrenom());
    }
}
