package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.Groupe;
import modele.Promotion;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class PromotionDAO extends DataAccessObject<Promotion> {

    public PromotionDAO() {
        super();
    }

    @Override
    public boolean creer(Promotion objet) {
        return false;
    }

    @Override
    public boolean effacer(Promotion objet) {
        return false;
    }

    @Override
    public boolean mettreAJour(Promotion objet) {
        return false;
    }

    @Override
    public Promotion chercher(int id) {
        Promotion promotion = new Promotion();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT nom_promo, groupe_id, nom_groupe "
                            + "FROM groupe INNER JOIN promotion "
                            + "ON promotion.promo_id = groupe.promo_id "
                            + "WHERE promotion.promo_id = " + id
                            + " ORDER BY groupe.groupe_id ASC");
            ArrayList<Groupe> groupes = new ArrayList<Groupe>();
            String nom = "null";
            while (result.next()) {
                Groupe groupe = new Groupe(result.getInt("groupe_id"), result.getString("nom_groupe"), 0);
                groupes.add(groupe);
                nom = result.getString("nom_promo");
            }
            promotion = new Promotion(
                    id,
                    nom,
                    groupes);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promotion;
    }
//test

//    public static void main(String[] args) {
//        PromotionDAO et = new PromotionDAO();
//        Promotion un = et.chercher(2);
//        un.afficher();
//    }
}
