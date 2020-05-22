package modele;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class Salle {

    private int salleId;
    private String nomSalle;
    private int capacite;

    public Salle(int id, String nom, int capacite) {
        this.salleId = id;
        nomSalle = nom;
        this.capacite = capacite;
    }

    public Salle() {
        salleId = 0;
        nomSalle = "null";
        capacite = 0;
    }

    public int getSalleId() {
        return salleId;
    }

    public String getNomSalle() {
        return nomSalle;
    }

    public int getCapacite() {
        return capacite;
    }

    public Salle copy() {
        Salle copySalle = new Salle(salleId, nomSalle, capacite);
        return copySalle;
    }
}
