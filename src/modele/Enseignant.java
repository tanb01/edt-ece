package modele;

/**
 * Classe Enseignant qui hérite de la classe User car un enseignant est un
 * utilisateur.
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class Enseignant extends User {

    /**
     * Constructeur
     *
     * @param id
     * @param email
     * @param nom
     * @param prenom
     * @param droit
     */
    public Enseignant(int id, String email, String nom, String prenom, int droit) {
        super(id, email, nom, prenom, droit);
    }

    /**
     * Constructeur
     */
    public Enseignant() {
        super(0, "null", "null", null, 0);
    }
}
