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

    protected int getGroupeId() {
        return groupeId;
    }

    protected String getNomGroupe() {
        return nomGroupe;
    }

    protected int getEffectifGroupe() {
        return effectifGroupe;
    }

    public Groupe copy() {
        Groupe copyGroupe = new Groupe(groupeId, nomGroupe, effectifGroupe);
        return copyGroupe;
    }
}
