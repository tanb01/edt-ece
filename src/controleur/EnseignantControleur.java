package controleur;

import dao.EtudiantDAO;
import dao.SeanceDAO;
import java.util.ArrayList;
import modele.Admin;
import modele.Enseignant;
import modele.Etudiant;
import modele.Seance;
import modele.User;
import vue.AdminVue;
import vue.EtudiantVue;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class EnseignantControleur {
    private Enseignant modele;
    private Enseignant vue;

    public EnseignantControleur(Enseignant modele, Enseignant vue) {
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
        //vue.printDetailsEnseignant(modele.getUserId(), modele.getNom(), modele.getPrenom());
    }
    
    public EnseignantControleur(Admin modele, AdminVue v) {
        AdminVue ve = new AdminVue("Admin vue");
        ve = v;

        EtudiantDAO etuddao = new EtudiantDAO();
        e = new Etudiant();
        seance = new SeanceDAO();

        e = etuddao.chercher(m.getUserId());
        listSeances = new ArrayList<Seance>();
        listSeances = seance.chercherSeancesParGroupeId(e.getGroupeId());
        listSeances.toString();
}
