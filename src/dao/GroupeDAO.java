package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import modele.Groupe;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class GroupeDAO extends DataAccessObject<Groupe> {

    public GroupeDAO() {
        super();
    }

    @Override
    public boolean creer(Groupe objet) {
        return false;
    }

    @Override
    public boolean effacer(Groupe objet) {
        return false;
    }

    @Override
    public boolean mettreAJour(Groupe objet) {
        return false;
    }

    @Override
    public Groupe chercher(int id) {
        Groupe groupe = new Groupe();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT nom_groupe, promo_id "
                            + "FROM groupe "
                            + "WHERE groupe_id= " + id);
            if (result.first()) {
                groupe = new Groupe(
                        id,
                        result.getString("nom_groupe"),
                        result.getInt("promo_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupe;
    }
//test

//    public static void main(String[] args) {
//        GroupeDAO gr = new GroupeDAO();
//        Groupe un = gr.chercher(20);
//        un.afficher();
//    }
}
