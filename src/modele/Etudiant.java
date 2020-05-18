package modele;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class Etudiant extends User {

    private int numeroEtudiant;

    public Etudiant(int id, String email, String nom, String prenom, int droit) {
        super(id, email, nom, prenom, droit);
    }

    public int getNumeroEtudiant() {
        return numeroEtudiant;
    }
}
