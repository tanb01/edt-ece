package modele;

import java.util.ArrayList;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class Promotion {

    private String nomPromo;
    private ArrayList<Groupe> groupes;

    public Promotion(String nom, ArrayList<Groupe> groupes) {
        this.nomPromo = nom;
        this.groupes = new ArrayList<Groupe>();
        for (Groupe groupe : groupes) {
            this.groupes.add(groupe);
        }
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
