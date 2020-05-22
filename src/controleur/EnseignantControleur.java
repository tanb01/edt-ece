package controleur;

import modele.Enseignant;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class EnseignantControleur {
    private Enseignant modele;
    private Enseignant vue;

    public EnseignantControleur(Enseignant modele, EnseignantVue vue) {
        this.modele = modele;
        this.vue = vue;
    }
    
    public int getEnseignantId() {
        return modele.getUserId();
    }
    
    public String getEnseignantNom() {
        return modele.getNom();
    }

    public String getEnseignantPrenom() {
        return modele.getPrenom();
    }
    
    public void updateVue() {
        vue.printDetailsEnseignant(modele.getUserId(), modele.getNom(), modele.getPrenom());
    }
}
