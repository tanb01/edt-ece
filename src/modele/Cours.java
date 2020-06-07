package modele;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class Cours {

    // Variables locales de Cours
    private int coursId;
    private String nomCours;

    /**
     * Constructeur
     *
     * @param id
     * @param nom
     */
    public Cours(int id, String nom) {
        coursId = id;
        this.nomCours = nom;
    }

    /**
     * Constructeur
     */
    public Cours() {
        coursId = 0;
        this.nomCours = "null";
    }

    /**
     * Getters Pour l'Id du cours.
     *
     * @return
     */
    public int getCoursId() {
        return coursId;
    }

    /**
     * Pour le nom du cours.
     *
     * @return
     */
    public String getNomCours() {
        return nomCours;
    }

    public Cours copy() {
        Cours copyCours = new Cours(coursId, nomCours);
        return copyCours;
    }

    /**
     * Override de toString pour afficher les infos du cours.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Id : " + this.coursId
                + "\nNom du cours : " + this.nomCours;
    }

    /**
     * Affiche les informations du cours.
     */
    public void afficher() {
        System.out.println("Voici les informations du cours : ");
        System.out.println(toString());
    }
}
