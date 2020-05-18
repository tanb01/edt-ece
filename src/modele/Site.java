package modele;

import java.util.ArrayList;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class Site {

    private int siteId;
    private String nomSite;
    private ArrayList<Salle> salles;

    public Site(int id, String nom, ArrayList<Salle> salles) {
        siteId = id;
        nomSite = nom;
        this.salles = new ArrayList<Salle>();
        for (Salle salle : salles) {
            this.salles.add(salle);
        }
    }

    public int getSiteId() {
        return siteId;
    }

    public String getNomSite() {
        return nomSite;
    }

    public ArrayList<Salle> getGroupes() {
        ArrayList<Salle> copySalles = new ArrayList<Salle>();
        for (Salle salle : salles) {
            copySalles.add(salle);
        }
        return copySalles;
    }
}
