package modele;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class Enseignant extends User {

    public Enseignant(int id, String email, String nom, String prenom, int droit) {
        super(id, email, nom, prenom, droit);
    }
    
    
    public Enseignant() {
        super(0, "null", "null", null, 0);
    }
}
