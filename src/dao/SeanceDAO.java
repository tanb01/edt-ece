package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.Cours;
import modele.Enseignant;
import modele.Groupe;
import modele.Salle;
import modele.Seance;
import modele.TypeCours;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class SeanceDAO extends DataAccessObject<Seance> {

    public SeanceDAO() {
        super();
    }

    @Override
    public boolean creer(Seance objet) {
        return false;
    }

    @Override
    public boolean effacer(Seance objet) {
        return false;
    }

    @Override
    public boolean mettreAJour(Seance objet) {
        return false;
    }

    @Override
    public Seance chercher(int id) {
        Seance seance = new Seance();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT numero_semaine, date_seance, heure_debut, heure_fin, etat_seance, cours_id, type_cours_id, enseignant_id, groupe_id, salle_id \n"
                            + "FROM seance\n"
                            + "INNER JOIN seance_enseignants\n"
                            + "      ON seance.seance_id=seance_enseignants.seance_id\n"
                            + "INNER JOIN seance_groupes\n"
                            + "      ON seance.seance_id=seance_groupes.seance_id\n"
                            + "INNER JOIN seance_salles\n"
                            + "      ON seance.seance_id=seance_salles.seance_id\n"
                            + "WHERE seance.seance_id =" + id);
            if (result.first()) {
                int numeroSemaine = result.getInt("numero_semaine");
                String date = result.getString("date_seance");
                String debutHeure = result.getString("heure_debut");
                String finHeure = result.getString("heure_fin");

                CoursDAO c = new CoursDAO();
                Cours cours = c.chercher(result.getInt("cours_id"));

                TypeCoursDAO t = new TypeCoursDAO();
                TypeCours typeCours = t.chercher(result.getInt("type_cours_id"));

                SalleDAO s = new SalleDAO();
                Salle salle = s.chercher(result.getInt("salle_id"));
                ArrayList<Salle> salles = new ArrayList<Salle>();
                salles.add(salle);

                EnseignantDAO e = new EnseignantDAO();
                ArrayList<Enseignant> enseignants = new ArrayList<Enseignant>();
                enseignants.add(e.chercher(result.getInt("enseignant_id")));

                GroupeDAO g = new GroupeDAO();
                ArrayList<Groupe> groupes = new ArrayList<Groupe>();
                groupes.add(g.chercher(result.getInt("type_cours_id")));

                seance = new Seance(id, numeroSemaine, date, debutHeure, finHeure, cours, typeCours, salles, enseignants, groupes);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seance;
    }

    public ArrayList<Seance> chercherSeancesParGroupeId(int groupeId) {
        ArrayList<Seance> seances = new ArrayList<Seance>();
        Seance seance = new Seance();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT seance.seance_id, numero_semaine, date_seance, heure_debut, heure_fin, etat_seance, cours_id, type_cours_id, enseignant_id, groupe_id, salle_id FROM seance INNER JOIN seance_enseignants\n"
                            + "ON seance.seance_id=seance_enseignants.seance_id INNER JOIN seance_groupes ON seance.seance_id=seance_groupes.seance_id INNER JOIN seance_salles ON seance.seance_id=seance_salles.seance_id WHERE groupe_id=" + groupeId);
            while (result.next()) {
                int seanceId = result.getInt("seance.seance_id");
                int numeroSemaine = result.getInt("numero_semaine");
                String date = result.getString("date_seance");
                String debutHeure = result.getString("heure_debut");
                String finHeure = result.getString("heure_fin");

                CoursDAO c = new CoursDAO();
                Cours cours = c.chercher(result.getInt("cours_id"));

                TypeCoursDAO t = new TypeCoursDAO();
                TypeCours typeCours = t.chercher(result.getInt("type_cours_id"));

                SalleDAO s = new SalleDAO();
                Salle salle = s.chercher(result.getInt("salle_id"));
                ArrayList<Salle> salles = new ArrayList<Salle>();
                salles.add(salle);

                EnseignantDAO e = new EnseignantDAO();
                ArrayList<Enseignant> enseignants = new ArrayList<Enseignant>();
                enseignants.add(e.chercher(result.getInt("enseignant_id")));

                GroupeDAO g = new GroupeDAO();
                ArrayList<Groupe> groupes = new ArrayList<Groupe>();
                groupes.add(g.chercher(result.getInt("type_cours_id")));

                seance = new Seance(seanceId, numeroSemaine, date, debutHeure, finHeure, cours, typeCours, salles, enseignants, groupes);
                seances.add(seance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seances;
    }
//test

//    public static void main(String[] args) {
//        SeanceDAO et = new SeanceDAO();
//        Seance un = et.chercher(1);
//        System.out.println("Numero Seance: " + un.getDebutHeure());
//        System.out.println("Prenom Seance: " + un.getFinHeure());
//        System.out.println("Numero Seance: " + un.getNumeroSemaine());
//        System.out.println("Prenom Seance: " + un.getCoursSeance().getNomCours());
//    }
    
//test 2
//    public static void main(String[] args) {
//        SeanceDAO et = new SeanceDAO();
//        ArrayList<Seance> un = et.chercherSeancesParGroupeId(31);
//        for (Seance s : un) {
//            System.out.println("Seance: " + s.getDebutHeure() + "\n");
//        }
//    }
}
