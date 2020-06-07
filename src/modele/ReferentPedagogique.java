package modele;

/**
 * Classe ReferentPedagogique qui hérite de la classe User car un référent
 * pédagogique est un utilisateur.
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class ReferentPedagogique extends User {

    /**
     * Constructeur
     *
     * @param id
     * @param email
     * @param nom
     * @param prenom
     * @param droit
     */
    public ReferentPedagogique(int id, String email, String nom, String prenom, int droit) {
        super(id, email, nom, prenom, droit);
    }
}
