package modele;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class TypeCours {

    // Variables locales de TypeCours
    private int typeCoursId;
    private String nomTypeCours;

    /**
     * Constructeur
     * 
     * @param id
     * @param nom 
     */
    public TypeCours(int id, String nom) {
        typeCoursId = id;
        nomTypeCours = nom;
    }

    /**
     * Constructeur
     */
    public TypeCours() {
        typeCoursId = 0;
        nomTypeCours = "null";
    }

    /**
     * Getters
     * Pour l'Id du type de cours.
     * 
     * @return 
     */
    public int getTypeCoursId() {
        return typeCoursId;
    }

    /**
     * Pour le nom du type de cours.
     * 
     * @return 
     */
    public String getNomTypeCours() {
        return nomTypeCours;
    }

    public TypeCours copy() {
        TypeCours copyTypeCours = new TypeCours(typeCoursId, nomTypeCours);
        return copyTypeCours;
    }

    /**
     * Override de toString pour afficher les infos du Type Cours.
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Id : " + this.typeCoursId
                + "\nType de cours : " + this.nomTypeCours;
    }

    /**
     * Affiche les informations du type de cours.
     */
    public void afficher() {
        System.out.println("Voici les informations du type de cours : ");
        System.out.println(toString());
    }
}
