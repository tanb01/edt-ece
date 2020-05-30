package modele;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class Groupe {

    private int groupeId;
    private String nomGroupe;
    private int effectifGroupe;

    public Groupe(int id, String nomGroupe, int effectif) {
        groupeId = id;
        this.nomGroupe = nomGroupe;
        effectifGroupe = effectif;
    }
    
    public Groupe() {
        groupeId = 0;
        this.nomGroupe = "null";
        effectifGroupe = 0;
    }
    
    public int getGroupeId() {
        return groupeId;
    }

    public String getNomGroupe() {
        return nomGroupe;
    }

    public int getEffectifGroupe() {
        return effectifGroupe;
    }

    public Groupe copy() {
        Groupe copyGroupe = new Groupe(groupeId, nomGroupe, effectifGroupe);
        return copyGroupe;
    }
    
    @Override
    public String toString() {
        return "Id : " + this.groupeId
                + "\nNom du groupe : " + this.nomGroupe
                + "\nEffectif : " + this.effectifGroupe;
    }
    
    public void afficher() {
        System.out.println("Voici les informations du groupe : ");
        System.out.println(toString());
    }
}
