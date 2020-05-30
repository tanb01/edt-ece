package modele;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class Etudiant extends User {

    private int numeroEtudiant;
    private int groupeId;

    public Etudiant(int id, String email, String nom, String prenom, int droit, int numeroEtudiant, int groupeId) {
        super(id, email, nom, prenom, droit);
        this.numeroEtudiant = numeroEtudiant;
        this.groupeId = groupeId;
    }

    public Etudiant() {
        super(99, "defaut@edu.ece.fr", "erreur", "erreur", 4);
        this.numeroEtudiant = 99;
        this.groupeId = 99;
    }

    public int getNumeroEtudiant() {
        return numeroEtudiant;
    }

    public int getGroupeId() {
        return groupeId;
    }
    
    @Override
    public String toString() {
        return "Id : " + this.userId
                + "\nEmail : " + this.email
                + "\nNom : " + this.nom
                + "\nPrénom : " + this.prenom
                + "\nDroit : " + this.droit
                + "\nNuméro étudiant : " + this.numeroEtudiant
                + "\nGroupe Id : " + this.groupeId;
    }
    
    @Override
    public void afficher() {
        System.out.println("Voici les informations de l'étudiant : ");
        System.out.println(toString());
    }
}
