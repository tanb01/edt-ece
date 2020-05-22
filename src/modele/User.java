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

    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getDroit() {
        return droit;
    }
}
