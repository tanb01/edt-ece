package modele;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class User {

    protected int userId;
    protected String email;
    protected String nom;
    protected String prenom;
    protected int droit;

    public User(int id, String email, String nom, String prenom, int droit) {
        userId = id;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.droit = droit;
    }

    protected int getUserId() {
        return userId;
    }

    protected String getEmail() {
        return email;
    }

    protected String getNom() {
        return nom;
    }

    protected String getPrenom() {
        return prenom;
    }

    protected int getDroit() {
        return droit;
    }
}
