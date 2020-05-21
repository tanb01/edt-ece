package modele;

import java.util.ArrayList;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class Promotion {

    private int promoId;
    private String nomPromo;
    private ArrayList<Groupe> groupes;

    public Promotion(int id, String nom, ArrayList<Groupe> groupes) {
        this.promoId = id;
        this.nomPromo = nom;
        this.groupes = new ArrayList<Groupe>();
        for (Groupe groupe : groupes) {
            this.groupes.add(groupe);
        }
    }

    public Promotion() {
        this.nomPromo = "null";
        this.groupes = null;
    }

    public int getPromoId() {
        return promoId;
    }

    public String getNomPromo() {
        return nomPromo;
    }

    public ArrayList<Groupe> getGroupes() {
        ArrayList<Groupe> copyGroupes = new ArrayList<Groupe>();
        for (Groupe groupe : groupes) {
            copyGroupes.add(groupe);
        }
        return copyGroupes;
    }
}