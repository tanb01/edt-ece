package modele;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class Groupe {

    // Variables locales de Groupe
    private int groupeId;
    private String nomGroupe;
    private int effectifGroupe;

    /**
     * Constructeur
     *
     * @param id
     * @param nomGroupe
     * @param effectif
     */
    public Groupe(int id, String nomGroupe, int effectif) {
        groupeId = id;
        this.nomGroupe = nomGroupe;
        effectifGroupe = effectif;
    }

    /**
     * Constructeur
     */
    public Groupe() {
        groupeId = 0;
        this.nomGroupe = "null";
        effectifGroupe = 0;
    }

    /**
     * Getters Pour l'Id du groupe.
     *
     * @return
     */
    public int getGroupeId() {
        return groupeId;
    }

    /**
     * Pour le nom du groupe.
     *
     * @return
     */
    public String getNomGroupe() {
        return nomGroupe;
    }

    /**
     * Pour l'effectif du groupe.
     *
     * @return
     */
    public int getEffectifGroupe() {
        return effectifGroupe;
    }

    public Groupe copy() {
        Groupe copyGroupe = new Groupe(groupeId, nomGroupe, effectifGroupe);
        return copyGroupe;
    }

    /**
     * Override de toString pour afficher les infos du groupe.
     *
     * @return
     */
    @Override
    public String toString() {
        return "\nGroupe Id : " + this.groupeId
                + "\nNom du groupe : " + this.nomGroupe
                + "\nEffectif : " + this.effectifGroupe;
    }

    /**
     * Affiche les informations du groupe.
     */
    public void afficher() {
        System.out.println("Voici les informations du groupe : ");
        System.out.println(toString());
    }
}
