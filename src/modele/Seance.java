package modele;

import dao.SeanceDAO;
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
    private int etatSeance;
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

    public int getEtatSeance() {
        return etatSeance;
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

    @Override
    public String toString() {
        return "Id : " + this.seanceId
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

    public String stringify() {
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
        return "Id : " + this.seanceId
                + " Numéro semaine : " + this.numeroSemaine
                + " Date : " + this.date
                + " Début heure : " + this.debutHeure
                + " Fin heure : " + this.finHeure
                + " État : " + this.etatSeance
                + " Cours : " + this.coursSeance.getNomCours()
                + " Salle(s) : " + salles.toString()
                + " Enseignant(s) : " + enseignants.toString()
                + " Groupe(s) : " + groupes.toString()
                + " Type cours : " + this.typeCoursSeance.getNomTypeCours();
    }

    public void afficher() {
        System.out.println("Voici les informations de la séance : ");
        System.out.println(toString());
    }

//        public static void main(String[] args) {
//        SeanceDAO et = new SeanceDAO();
//        Seance un = new Seance();
//        un = et.chercher(1);
//       System.out.println(un.toString());
//    }
}
