package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.Salle;
import modele.Site;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class SiteDAO extends DataAccessObject<Site> {

    /**
     * Constructeur
     */
    public SiteDAO() {
        super();
    }

    /**
     * Fonction pour créer.
     *
     * @param objet
     * @return
     */
    public boolean creer(Site objet) {
        return false;
    }

    /**
     * Fonction pour effacer.
     *
     * @param objet
     * @return
     */
    public boolean effacer(Site objet) {
        return false;
    }

    /**
     * Fonction de mise à jour.
     *
     * @param objet
     * @return
     */
    public boolean mettreAJour(Site objet) {
        return false;
    }

    /**
     * Fonction qui permet de chercher un site dans la BDD grâce à son Id.
     *
     * @param id
     * @return
     */
    public Site chercher(int id) {
        Site site = new Site();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT nom_site, salle_id, capacite_salle, nom_salle FROM salle INNER JOIN site ON salle.site_id = site.site_id WHERE site.site_id = " + id);
            ArrayList<Salle> salles = new ArrayList<Salle>();

            while (result.next()) {
                Salle salle = new Salle(result.getInt("salle_id"), result.getString("nom_salle"), result.getInt("capacite_salle"));
                salles.add(salle);
            }
            result.first();
            site = new Site(id, result.getString("nom_site"), salles);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return site;
    }

    public ArrayList<Site> chercherTousLesSites() {
        ArrayList<Site> sites = new ArrayList<Site>();
        Site site = new Site();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT site_id FROM site;");
            while (result.next()) {
                site = chercher(result.getInt("site_id"));
                sites.add(site);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sites;
    }
//test

    public static void main(String[] args) {

//        SiteDAO sa = new SiteDAO();
//        Site un = sa.chercher(3);
//        System.out.println("00 Site : " + un.getNomSite());
//        System.out.println("Id : " + un.getSiteId());
//        for (Salle g : un.getSalles()) {
//            System.out.println("Salle Id: " + g.getSalleId());
//            System.out.println("Salle Nom: " + g.getNomSalle() + "\n");
//        }
        // Fonctionnel
//        SiteDAO sa = new SiteDAO();
//        Site un = sa.chercher(3);
//        un.afficher();
    }
}
