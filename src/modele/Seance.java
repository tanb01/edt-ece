package modele;

import dao.SeanceDAO;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class Seance {

    // Variables locales de Séance
    private int seanceId;
    private int numeroSemaine;
    private String date;
    private String debutHeure;
    private String finHeure;
    private int etatSeance;
    private Cours coursSeance;
    private TypeCours typeCoursSeance;
    private ArrayList<Salle> listeSalles;
    private ArrayList<Enseignant> listeEnseignants;
    private ArrayList<Groupe> listeGroupes;

    /**
     * Constructeur
     *
     * @param id
     * @param numeroSemaine
     * @param date
     * @param debutHeure
     * @param finHeure
     * @param cours
     * @param typeCours
     * @param salles
     * @param enseignants
     * @param groupes
     */
    public Seance(int id, int numeroSemaine, String date, String debutHeure,
            String finHeure, int etat, Cours cours, TypeCours typeCours,
            ArrayList<Salle> salles, ArrayList<Enseignant> enseignants,
            ArrayList<Groupe> groupes) {
        seanceId = id;
        this.numeroSemaine = numeroSemaine;
        this.date = date;
        this.debutHeure = debutHeure.substring(0, debutHeure.length() - 3);
        this.finHeure = finHeure.substring(0, finHeure.length() - 3);
        this.etatSeance = etat;
        coursSeance = cours.copy();
        typeCoursSeance = typeCours.copy();

        listeSalles = new ArrayList<Salle>();
        listeEnseignants = new ArrayList<Enseignant>();
        listeGroupes = new ArrayList<Groupe>();

        for (Salle salle : salles) {
            listeSalles.add(salle);
        }

        for (Enseignant enseignant : enseignants) {
            listeEnseignants.add(enseignant);
        }

        for (Groupe groupe : groupes) {
            listeGroupes.add(groupe);
        }
    }

    /**
     * Constructeur
     */
    public Seance() {
        seanceId = 0;
        numeroSemaine = 0;
        date = "null";
        debutHeure = "null";
        etatSeance = 0;
        coursSeance = null;
        typeCoursSeance = null;
        listeSalles = null;
        listeEnseignants = null;
        listeGroupes = null;
    }

    /**
     * Getters Pour l'Id de la séance.
     *
     * @return
     */
    public int getSeanceId() {
        return seanceId;
    }

    /**
     * Pour le numéro de la semaine.
     *
     * @return
     */
    public int getNumeroSemaine() {
        return numeroSemaine;
    }

    /**
     * Pour la date de la séance.
     *
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     * Pour l'heure de début de la séance.
     *
     * @return
     */
    public String getDebutHeure() {
        return debutHeure;
    }

    /**
     * Pour l'heure de fin de la séance.
     *
     * @return
     */
    public String getFinHeure() {
        return finHeure;
    }

    /**
     * Pour l'état de la séance (Validée - Annulée).
     *
     * @return
     */
    public int getEtatSeance() {
        return etatSeance;
    }

    /**
     * Pour le cours de la séance.
     *
     * @return
     */
    public Cours getCoursSeance() {
        return coursSeance;
    }

    /**
     * Pour le type de cours de la séance (CI-CM-TD-TP).
     *
     * @return
     */
    public TypeCours getTypeCours() {
        return typeCoursSeance;
    }

    /**
     * Pour la liste des salles de la séance.
     *
     * @return
     */
    public ArrayList<Salle> getListeSalles() {
        ArrayList<Salle> copySalles = new ArrayList<Salle>();
        for (Salle salle : listeSalles) {
            copySalles.add(salle);
        }
        return copySalles;
    }

    /**
     * Pour la liste des enseignants de la séance.
     *
     * @return
     */
    public ArrayList<Enseignant> getListeEnseignants() {
        ArrayList<Enseignant> copyEnseignants = new ArrayList<Enseignant>();
        for (Enseignant enseignant : listeEnseignants) {
            copyEnseignants.add(enseignant);
        }
        return copyEnseignants;
    }

    /**
     * Pour la liste des groupes de la séance.
     *
     * @return
     */
    public ArrayList<Groupe> getListeGroupes() {
        ArrayList<Groupe> copyGroupes = new ArrayList<Groupe>();
        for (Groupe groupe : listeGroupes) {
            copyGroupes.add(groupe);
        }
        return copyGroupes;
    }

    /**
     * Override de toString pour afficher les infos de la séance.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Seance Id : " + this.seanceId
                + "\nNuméro semaine : " + this.numeroSemaine
                + "\nDate : " + this.date
                + "\nDébut heure : " + this.debutHeure
                + "\nFin heure : " + this.finHeure
                + "\nÉtat : " + this.etatSeance
                + "\nCours : " + this.coursSeance
                + "\nType cours : " + this.typeCoursSeance
                + "\nSalle(s) : " + this.listeSalles
                + "\nEnseignant(s) : " + this.listeEnseignants
                + "\nGroupe(s) : " + this.listeGroupes;
    }

    /**
     * Pour afficher les infos de la séance.
     *
     * @return
     */
    public String stringifyHorizontal() {
        String salles = new String();
        for (Salle s : listeSalles) {
            salles = salles.concat(s.getNomSalle() + ", ");
        }

        String enseignants = new String();
        for (Enseignant s : listeEnseignants) {
            enseignants = enseignants.concat(s.getNom() + ", ");
        }

        String groupes = new String();
        for (Groupe s : listeGroupes) {
            groupes = groupes.concat(s.getNomGroupe() + ", ");
        }
        return "Seance Id : " + this.seanceId
                + ", Numéro semaine : " + this.numeroSemaine
                + ", Date : " + this.date
                + ", Début heure : " + this.debutHeure
                + ", Fin heure : " + this.finHeure
                + ", État : " + this.etatSeance
                + ", Cours : " + this.coursSeance.getNomCours()
                + ", Salle(s) : " + salles.toString()
                + " Enseignant(s) : " + enseignants.toString()
                + " Groupe(s) : " + groupes.toString()
                + " Type cours : " + this.typeCoursSeance.getNomTypeCours();
    }

    public String stringifyVertical() {
        String salles = new String();
        salles = listeSalles.stream().map(Object::toString).collect(Collectors.joining(", "));

        String enseignants = new String();
        enseignants = listeEnseignants.stream().map(Object::toString).collect(Collectors.joining(", "));

        String groupes = new String();
        groupes = listeGroupes.stream().map(Object::toString).collect(Collectors.joining(", "));

        return "\nSeance Id : " + this.seanceId
                + ",\nNuméro semaine : " + this.numeroSemaine
                + ",\nDate : " + this.date
                + ",\nDébut heure : " + this.debutHeure
                + ",\nFin heure : " + this.finHeure
                + ",\nÉtat : " + this.etatSeance
                + ",\nCours : " + this.coursSeance.getNomCours()
                + ",\n\nSalle(s) : " + salles
                + ",\n\nEnseignant(s) : " + enseignants
                + ",\n\nGroupe(s) : " + groupes
                + ",\nType cours : " + this.typeCoursSeance.getNomTypeCours();
    }

    public String stringEssentiel() {
        String salles = new String();
        for (Salle s : listeSalles) {
            salles = salles.concat(s.getNomSalle());
        }

        String enseignants = new String();
        for (Enseignant s : listeEnseignants) {
            enseignants = enseignants.concat(s.getNom());
        }

        String groupes = new String();
        for (Groupe s : listeGroupes) {
            groupes = groupes.concat(s.getNomGroupe());
        }
        return "Seance Id : " + this.seanceId
                + " Cours : " + this.coursSeance.getNomCours()
                + " Salle(s) : " + salles.toString()
                + " Enseignant(s) : " + enseignants.toString()
                + " Groupe(s) : " + groupes.toString();
    }

    /**
     * Affiche les informations de la séance.
     */
    public void afficher() {
        System.out.println("Voici les informations de la séance : ");
        System.out.println(toString());
    }

    public static void main(String[] args) {
        SeanceDAO et = new SeanceDAO();
        Seance un = new Seance();
        un = et.chercher(44);
        System.out.println(un.toString());
        System.out.println();
        System.out.println(un.stringifyHorizontal());
        System.out.println();
        System.out.println(un.stringifyVertical());

    }
}
