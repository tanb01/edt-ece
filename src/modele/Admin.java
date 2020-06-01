package modele;

/**
 * Classe Admin qui hérite de la classe User car un administrateur est un utilisateur.
 * 
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class Admin extends User {

    /**
     * Constructeur
     * 
     * @param id
     * @param email
     * @param nom
     * @param prenom
     * @param droit 
     */
    public Admin(int id, String email, String nom, String prenom, int droit) {
        super(id, email, nom, prenom, droit);
    }
}
