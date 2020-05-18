package modele;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class TypeCours {

    private int typeCoursId;
    private String nomTypeCours;

    public TypeCours(int id, String nom) {
        typeCoursId = id;
        nomTypeCours = nom;
    }

    public int getTypeCoursId() {
        return typeCoursId;
    }

    public String getNomSalle() {
        return nomTypeCours;
    }

    public TypeCours copy() {
        TypeCours copyTypeCours = new TypeCours(typeCoursId, nomTypeCours);
        return copyTypeCours;
    }
}
