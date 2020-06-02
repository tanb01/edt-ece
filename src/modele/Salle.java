package modele;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class Salle {

    // Variables locales de Salle
    private int salleId;
    private String nomSalle;
    private int capacite;

    /**
     * Constructeur
     * 
     * @param id
     * @param nom
     * @param capacite 
     */
    public Salle(int id, String nom, int capacite) {
        this.salleId = id;
        nomSalle = nom;
        this.capacite = capacite;
    }
    
    /**
     * Constructeur
     * 
     * @param id
     * @param capacite 
     */
    public Salle(int id, int capacite) {
        this.salleId = id;
        this.capacite = capacite;
    }

    /**
     * Constructeur
     */
    public Salle() {
        salleId = 0;
        nomSalle = "null";
        capacite = 0;
    }

    /**
     * Getters
     * Pour l'Id de la salle.
     * 
     * @return 
     */
    public int getSalleId() {
        return salleId;
    }

    /**
     * Pour le nom de la salle.
     * 
     * @return 
     */
    public String getNomSalle() {
        return nomSalle;
    }

    /**
     * Pour la capacité de la salle.
     * 
     * @return 
     */
    public int getCapacite() {
        return capacite;
    }

    public Salle copy() {
        Salle copySalle = new Salle(salleId, nomSalle, capacite);
        return copySalle;
    }
    
    /**
     * Override de toString pour afficher les infos de la salle.
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Id : " + this.salleId
                + "\nNom de la salle : " + this.nomSalle
                + "\nCapacité : " + this.capacite;
    }
    
    /**
     * Affiche les informations de la salle.
     */
    public void afficher() {
        System.out.println("Voici les informations de la salle : ");
        System.out.println(toString());
    }
}
