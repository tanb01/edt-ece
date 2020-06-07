package modele;

/**
 * Classe Etudiant qui hérite de la classe User car un étudiant est un
 * utilisateur.
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class Etudiant extends User {

    // Variables locales de Etudiant
    private int numeroEtudiant;
    private int groupeId;

    /**
     * Constructeur
     *
     * @param id
     * @param email
     * @param nom
     * @param prenom
     * @param droit
     * @param numeroEtudiant
     * @param groupeId
     */
    public Etudiant(int id, String email, String nom, String prenom, int droit, int numeroEtudiant, int groupeId) {
        super(id, email, nom, prenom, droit);
        this.numeroEtudiant = numeroEtudiant;
        this.groupeId = groupeId;
    }

    /**
     * Constructeur
     */
    public Etudiant() {
        super(99, "defaut@edu.ece.fr", "erreur", "erreur", 4);
        this.numeroEtudiant = 99;
        this.groupeId = 99;
    }

    /**
     * Getters Pour le numéro étudiant.
     *
     * @return
     */
    public int getNumeroEtudiant() {
        return numeroEtudiant;
    }

    /**
     * Pour l'Id du groupe.
     *
     * @return
     */
    public int getGroupeId() {
        return groupeId;
    }

    /**
     * Override de toString pour afficher les infos de l'étudiant.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Id : " + this.userId
                + "\nEmail : " + this.email
                + "\nNom : " + this.nom
                + "\nPrénom : " + this.prenom
                + "\nDroit : " + this.droit
                + "\nNuméro étudiant : " + this.numeroEtudiant
                + "\nGroupe Id : " + this.groupeId;
    }

    /**
     * Affiche les informations de l'étudiant.
     */
    @Override
    public void afficher() {
        System.out.println("Voici les informations de l'étudiant : ");
        System.out.println(toString());
    }
}
