package modele;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class Cours {

    private int coursId;
    private String nomCours;

    public Cours(int id, String nom) {
        coursId = id;
        this.nomCours = nom;
    }

    public Cours() {
        coursId = 0;
        this.nomCours = "null";
    }

    public int getCoursId() {
        return coursId;
    }

    public String getNomCours() {
        return nomCours;
    }

    public Cours copy() {
        Cours copyCours = new Cours(coursId, nomCours);
        return copyCours;
    }
}
