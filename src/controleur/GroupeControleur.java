package controleur;

import modele.Groupe;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class GroupeControleur {
    private Groupe modele;
    private Groupe vue;

    public GroupeControleur(Groupe modele, Groupe vue) {
        this.modele = modele;
        this.vue = vue;
    }
    
    public int getGroupeId() {
        return modele.getGroupeId();
    }

    public String getNomGroupe() {
        return modele.getNomGroupe();
    }

    protected int getEffectifGroupe() {
        return modele.getEffectifGroupe();
    }
    
    public void updateVue() {
        vue.printDetailsGroupe(modele.getGroupeId(), modele.getNomGroupe(), modele.getEffectifGroupe());
    }
}
