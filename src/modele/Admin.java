package modele;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class Admin extends User {

    public Admin(int id, String email, String nom, String prenom, int droit) {
        super(id, email, nom, prenom, droit);
    }
}
