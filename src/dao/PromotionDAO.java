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

    /**
     * Constructeur
     */
    public PromotionDAO() {
        super();
    }

    /**
     * Fonction pour créer.
     *
     * @param objet
     * @return
     */
    @Override
    public boolean creer(Promotion objet) {
        return false;
    }

    /**
     * Fonction pour effacer.
     *
     * @param objet
     * @return
     */
    @Override
    public boolean effacer(Promotion objet) {
        return false;
    }

    /**
     * Fonction de mise à jour.
     *
     * @param objet
     * @return
     */
    @Override
    public boolean mettreAJour(Promotion objet) {
        return false;
    }

    /**
     * Fonction qui permet de chercher une promotion dans la BDD grâce à son Id.
     *
     * @param id
     * @return
     */
    @Override
    public Promotion chercher(int id) {
        GroupeDAO daoGroupe = new GroupeDAO();
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
                Groupe groupe = new Groupe();
                groupe = daoGroupe.chercher(result.getInt("groupe_id"));
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

    public ArrayList<Promotion> chercherToutesLesPromos() {
        ArrayList<Promotion> promos = new ArrayList<Promotion>();
        Promotion promo = new Promotion();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT promo_id FROM promotion");
            while (result.next()) {
                promo = chercher(result.getInt("promo_id"));
                promos.add(promo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promos;
    }

    public ArrayList<String> chercherTousNomPromos() {
        ArrayList<String> promos = new ArrayList<String>();
        String promo = new String();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT nom_promo FROM promotion");
            while (result.next()) {
                promo = result.getString("nom_promo");
                promos.add(promo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promos;
    }

//test
    public static void main(String[] args) {
        PromotionDAO et = new PromotionDAO();
        Promotion un = et.chercher(2);
        un.afficher();

//        Test ARRAYLIST toutes les promos PromotionDAO et = new PromotionDAO();
//        ArrayList<Promotion> un = et.chercherToutesLesPromos();
//        un.get(2).afficher();
    }
}
