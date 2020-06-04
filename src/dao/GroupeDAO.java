package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import modele.Groupe;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class GroupeDAO extends DataAccessObject<Groupe> {

    /**
     * Constructeur
     */
    public GroupeDAO() {
        super();
    }

    /**
     * Fonction pour créer.
     *
     * @param objet
     * @return
     */
    @Override
    public boolean creer(Groupe objet) {
        return false;
    }

    /**
     * Fonction pour effacer.
     *
     * @param objet
     * @return
     */
    @Override
    public boolean effacer(Groupe objet) {
        return false;
    }

    /**
     * Fonction de mise à jour.
     *
     * @param objet
     * @return
     */
    @Override
    public boolean mettreAJour(Groupe objet) {
        return false;
    }

    /**
     * Fonction qui permet de chercher un groupe dans la BDD grâce à son Id.
     *
     * @param id
     * @return
     */
    @Override
    public Groupe chercher(int id) {
        Groupe groupe = new Groupe();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT nom_groupe, promo_id "
                            + "FROM groupe "
                            + "WHERE groupe_id= " + id);
            ResultSet result2 = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(user_id\n"
                            + "            ) as effectif FROM etudiant WHERE groupe_id =" + id);
            if (result2.first()) {
                result2.getInt("effectif");
            }
            if (result.first()) {
                groupe = new Groupe(
                        id,
                        result.getString("nom_groupe"),
                        result2.getInt("effectif"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupe;
    }
//test

//    public static void main(String[] args) {
//        GroupeDAO gr = new GroupeDAO();
//        Groupe un = gr.chercher(31);
//        un.afficher();
//    }
}
