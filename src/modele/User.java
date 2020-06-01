package modele;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class User {

    // Variables locales de User
    protected int userId;
    protected String email;
    protected String nom;
    protected String prenom;
    protected int droit;

    /**
     * Constructeur
     * 
     * @param id
     * @param email
     * @param nom
     * @param prenom
     * @param droit 
     */
    public User(int id, String email, String nom, String prenom, int droit) {
        userId = id;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.droit = droit;
    }

    /**
     * Constructeur
     */
    public User() {
        userId = 0;
        this.email = null;
        this.nom = null;
        this.prenom = null;
        this.droit = 0;
    }

    /**
     * Getters
     * Pour l'Id de l'utilisateur.
     * 
     * @return 
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Pour l'email de l'utilisateur.
     * 
     * @return 
     */
    public String getEmail() {
        return email;
    }

    /**
     * Pour le nom de l'utilisateur.
     * 
     * @return 
     */
    public String getNom() {
        return nom;
    }

    /**
     * Pour le prénom de l'utilisateur.
     * 
     * @return 
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Pour le droit de l'utilisateur.
     * (1- Admin 
     * 2- Réferent pédagogique
     * 3- Enseignant
     * 4- Étudiant)
     * 
     * @return 
     */
    public int getDroit() {
        return droit;
    }

    /**
     * Vérifie si l'utilisateur est un Administrateur.
     * Droit = 1
     * 
     * @return 
     */
    public boolean isAdmin() {
        boolean verifyUser = false;
        if (this.droit == 1) {
            verifyUser = true;
        }
        return verifyUser;
    }

    /**
     * Vérifie si l'utilisateur est un Réferent Pédagogique.
     * Droit = 2
     * 
     * @return 
     */
    public boolean isReferentPedagogique() {
        boolean verifyUser = false;
        if (this.droit == 2) {
            verifyUser = true;
        }
        return verifyUser;
    }

    /**
     * Vérifie si l'utilisateur est un Enseignant.
     * Droit = 3
     * 
     * @return 
     */
    public boolean isEnseignant() {
        boolean verifyUser = false;
        if (this.droit == 3) {
            verifyUser = true;
        }
        return verifyUser;
    }

    /**
     * Vérifie si l'utilisateur est un Étudiant.
     * Droit = 4
     * 
     * @return 
     */
    public boolean isEtudiant() {
        boolean verifyUser = false;
        if (this.droit == 4) {
            verifyUser = true;
        }
        return verifyUser;
    }

    /**
     * Override de toString pour afficher les infos de l'utilisateur.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Id : " + this.userId
                + "\nEmail : " + this.email
                + "\nNom : " + this.nom
                + "\nPrénom : " + this.prenom
                + "\nDroit : " + this.droit;
    }

    /**
     * Affiche les informations de l'utilisateur.
     */
    public void afficher() {
        System.out.println("Voici les informations de l'utilisateur : ");
        System.out.println(toString());
    }
}
