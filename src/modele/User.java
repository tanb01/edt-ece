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

    public User() {
        userId = 0;
        this.email = null;
        this.nom = null;
        this.prenom = null;
        this.droit = 0;
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

    public boolean isAdmin() {
        boolean verifyUser = false;
        if (this.droit == 1) {
            verifyUser = true;
        }
        return verifyUser;
    }

    public boolean isReferentPedagogique() {
        boolean verifyUser = false;
        if (this.droit == 2) {
            verifyUser = true;
        }
        return verifyUser;
    }

    public boolean isEnseignant() {
        boolean verifyUser = false;
        if (this.droit == 3) {
            verifyUser = true;
        }
        return verifyUser;
    }

    public boolean isEtudiant() {
        boolean verifyUser = false;
        if (this.droit == 4) {
            verifyUser = true;
        }
        return verifyUser;
    }
}
