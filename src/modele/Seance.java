package modele;

import java.util.ArrayList;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class Seance {

    private int seanceId;
    private int numeroSemaine;
    private String date;
    private String debutHeure;
    private String finHeure;
    private Cours coursSeance;
    private TypeCours typeCoursSeance;
    private ArrayList<Salle> listeSalles;
    private ArrayList<Enseignant> listeEnseignants;
    private ArrayList<Groupe> listeGroupes;

    public Seance(int id, int numeroSemaine, String date, String debutHeure,
            String finHeure, Cours cours, TypeCours typeCours,
            ArrayList<Salle> salles, ArrayList<Enseignant> enseignants,
            ArrayList<Groupe> groupes) {
        seanceId = id;
        this.numeroSemaine = numeroSemaine;
        this.date = date;
        this.debutHeure = debutHeure;
        this.finHeure = finHeure;
        coursSeance = cours.copy();
        typeCoursSeance = typeCours.copy();
        
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

    public int getSeanceId() {
        return seanceId;
    }

    public int getNumeroSemaine() {
        return numeroSemaine;
    }

    public String getDate() {
        return date;
    }

    public String getDebutHeure() {
        return debutHeure;
    }

    public String getFinHeure() {
        return finHeure;
    }

    public Cours getCoursSeance() {
        return coursSeance;
    }

    public TypeCours getTypeCours() {
        return typeCoursSeance;
    }

    public ArrayList<Salle> getListeSalles() {
        ArrayList<Salle> copySalles = new ArrayList<Salle>();
        for (Salle salle : listeSalles) {
            copySalles.add(salle);
        }
        return copySalles;
    }

    public ArrayList<Enseignant> getListeEnseignants() {
        ArrayList<Enseignant> copyEnseignants = new ArrayList<Enseignant>();
        for (Enseignant enseignant : listeEnseignants) {
            copyEnseignants.add(enseignant);
        }
        return copyEnseignants;
    }

    public ArrayList<Groupe> getListeGroupes() {
        ArrayList<Groupe> copyGroupes = new ArrayList<Groupe>();
        for (Groupe groupe : listeGroupes) {
            copyGroupes.add(groupe);
        }
        return copyGroupes;
    }
}
