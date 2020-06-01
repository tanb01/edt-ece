package modele;

import java.util.ArrayList;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class Site {

    // Variables locales de Site
    private int siteId;
    private String nomSite;
    private ArrayList<Salle> salles;

    /**
     * Constructeur
     * 
     * @param id
     * @param nom
     * @param salles 
     */
    public Site(int id, String nom, ArrayList<Salle> salles) {
        siteId = id;
        nomSite = nom;
        this.salles = new ArrayList<Salle>();
        for (Salle salle : salles) {
            this.salles.add(salle);
        }
    }

    /**
     * Constructeur
     */
    public Site() {
        siteId = 0;
        nomSite = "null";
        salles = null;
    }

    /**
     * Getters
     * Pour l'Id du site.
     * 
     * @return 
     */
    public int getSiteId() {
        return siteId;
    }

    /**
     * Pour le nom du site.
     * 
     * @return 
     */
    public String getNomSite() {
        return nomSite;
    }

    /**
     * Pour la liste des salles présentes dans le site.
     * 
     * @return 
     */
    public ArrayList<Salle> getSalles() {
        ArrayList<Salle> copySalles = new ArrayList<Salle>();
        for (Salle salle : salles) {
            copySalles.add(salle);
        }
        return copySalles;
    }
    
    /**
     * Override de toString pour afficher les infos du site.
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Id : " + this.siteId
                + "\nNom du site : " + this.nomSite
                + "\nSalles : " + this.salles;
    }
    
    /**
     * Affiche les informations du site.
     */
    public void afficher() {
        System.out.println("Voici les informations du site : ");
        System.out.println(toString());
    }
}
