package modele;

import java.util.ArrayList;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class Promotion {

    // Variables locales de Promotion
    private int promoId;
    private String nomPromo;
    private ArrayList<Groupe> groupes;

    /**
     * Constructeur
     *
     * @param id
     * @param nom
     * @param groupes
     */
    public Promotion(int id, String nom, ArrayList<Groupe> groupes) {
        this.promoId = id;
        this.nomPromo = nom;
        this.groupes = new ArrayList<Groupe>();
        for (Groupe groupe : groupes) {
            this.groupes.add(groupe);
        }
    }

    /**
     * Constructeur
     */
    public Promotion() {
        this.nomPromo = "null";
        this.groupes = null;
    }

    /**
     * Getters Pour l'Id de la promotion.
     *
     * @return
     */
    public int getPromoId() {
        return promoId;
    }

    /**
     * Pour le nom de la promo.
     *
     * @return
     */
    public String getNomPromo() {
        return nomPromo;
    }

    /**
     * Pour la liste des groupes appartenant à la promotion
     *
     * @return
     */
    public ArrayList<Groupe> getGroupes() {
        ArrayList<Groupe> copyGroupes = new ArrayList<Groupe>();
        for (Groupe groupe : groupes) {
            copyGroupes.add(groupe);
        }
        return copyGroupes;
    }

    /**
     * Override de toString pour afficher les infos de la promotion.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Id : " + this.promoId
                + "\nNom de la promo : " + this.nomPromo
                + "\nGroupes : " + this.groupes;
    }

    /**
     * Affiche les informations de la promotion.
     */
    public void afficher() {
        System.out.println("Voici les informations de la promo : ");
        System.out.println(toString());
    }
}
