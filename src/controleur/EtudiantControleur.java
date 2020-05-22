package controleur;

import modele.Etudiant;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class EtudiantControleur {
    private Etudiant modele;
    private Etudiant vue;

    public EtudiantControleur(Etudiant modele, EtudiantVue vue) {
        this.modele = modele;
        this.vue = vue;
    }
    
    public int getEtudiantId() {
        return modele.getUserId();
    }
    
    public String getEtudiantNom() {
        return modele.getNom();
    }

    public String getEtudiantPrenom() {
        return modele.getPrenom();
    }
    
    public int getNumeroEtudiant() {
        return modele.getNumeroEtudiant;
    }

    public int getGroupeId() {
        return modele.getGroupeId;
    }

    public void updateVue() {
        vue.printDetailsEtudiant(modele.getUserId(), modele.getNom(), modele.getPrenom(), modele.getNumeroEtudiant(), modele.getGroupeId());
    }
}
