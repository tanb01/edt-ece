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
    
    @Override
    public String toString() {
        return "Id : " + this.userId
                + "\nEmail : " + this.email
                + "\nNom : " + this.nom
                + "\nPrénom : " + this.prenom
                + "\nDroit : " + this.droit;
    }
    
    public void afficher() {
        System.out.println("Voici les informations de l'utilisateur : ");
        System.out.println(toString());
    }
}
