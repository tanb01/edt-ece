package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    /**
     * Constructeur
     */
    public SeanceDAO() {
        super();
    }

    /**
     * Fonction pour créer.
     *
     * @param objet
     * @return
     */
    @Override
    public boolean creer(Seance objet) {
        return false;
    }

    /**
     * Fonction pour effacer.
     *
     * @param objet
     * @return
     */
    @Override
    public boolean effacer(Seance objet) {
        return false;
    }

    /**
     * Fonction de mise à jour.
     *
     * @param objet
     * @return
     */
    @Override
    public boolean mettreAJour(Seance objet) {
        return false;
    }

    /**
     * Fonction qui permet de chercher une séance dans la BDD grâce à son Id.
     *
     * @param id
     * @return
     */
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
                int etat = result.getInt("etat_seance");
                String Newligne = System.getProperty("line.separator");
                String resultat;
                resultat = Newligne + date + debutHeure + finHeure;
                CoursDAO c = new CoursDAO();
                Cours cours = c.chercher(result.getInt("cours_id"));

                TypeCoursDAO t = new TypeCoursDAO();
                TypeCours typeCours = t.chercher(result.getInt("type_cours_id"));

                SalleDAO s = new SalleDAO();
                ArrayList<Salle> salles = new ArrayList<Salle>();
                salles = s.chercherSallesParSeanceId(id);

                EnseignantDAO e = new EnseignantDAO();
                ArrayList<Enseignant> enseignants = new ArrayList<Enseignant>();
                enseignants = e.chercherEnseignantsParSeanceId(id);

                GroupeDAO g = new GroupeDAO();
                ArrayList<Groupe> groupes = new ArrayList<Groupe>();
                groupes = g.chercherGroupesParSeanceId(id);

                seance = new Seance(id, numeroSemaine, date, debutHeure, finHeure, etat, cours, typeCours, salles, enseignants, groupes);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seance;
    }

    public Seance chercherSeanceParInfo(int enseignantId, String dateSeance, int coursId, String heureDebut, int groupeId) {
        Seance seance = new Seance();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT seance.seance_id, numero_semaine, date_seance, heure_debut, heure_fin, etat_seance, cours_id, type_cours_id, enseignant_id, groupe_id, salle_id FROM seance INNER JOIN seance_enseignants ON seance.seance_id=seance_enseignants.seance_id INNER JOIN seance_groupes ON seance.seance_id=seance_groupes.seance_id INNER JOIN seance_salles ON seance.seance_id=seance_salles.seance_id WHERE enseignant_id = " + enseignantId + " AND seance.date_seance= '" + dateSeance
                            + "' AND seance.cours_id= " + coursId + " AND seance.heure_debut= '" + heureDebut + "' AND seance_groupes.groupe_id=" + groupeId);
            if (result.first()) {
                seance = chercher(result.getInt("seance.seance_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seance;
    }

    public boolean verifierSiSeanceExiste(int enseignantId, String dateSeance, int coursId, String heureDebut, int groupeId) {
        boolean isExist = false;
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT seance.seance_id, numero_semaine, date_seance, heure_debut, heure_fin, etat_seance, cours_id, type_cours_id, enseignant_id, groupe_id, salle_id FROM seance INNER JOIN seance_enseignants ON seance.seance_id=seance_enseignants.seance_id INNER JOIN seance_groupes ON seance.seance_id=seance_groupes.seance_id INNER JOIN seance_salles ON seance.seance_id=seance_salles.seance_id WHERE enseignant_id = " + enseignantId + " AND seance.date_seance= '" + dateSeance
                            + "' AND seance.cours_id= " + coursId + " AND seance.heure_debut= '" + heureDebut + "' AND seance_groupes.groupe_id=" + groupeId);
            if (result.next()) {
                isExist = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isExist;
    }

    /**
     * Fonction qui permet de rechercher les séances d'un groupe grâce à l'id de
     * ce groupe.
     *
     * @param groupeId
     * @return
     */
    public ArrayList<Seance> chercherSeancesParGroupeId(int groupeId) {
        ArrayList<Seance> seances = new ArrayList<Seance>();
        Seance seance = new Seance();

        try {
//            ResultSet result = this.connect.createStatement(
//                    ResultSet.TYPE_SCROLL_INSENSITIVE,
//                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT seance.seance_id, numero_semaine, date_seance, heure_debut, heure_fin, etat_seance, cours_id, type_cours_id, enseignant_id, groupe_id, salle_id FROM seance INNER JOIN seance_enseignants\n"
//                            + "ON seance.seance_id=seance_enseignants.seance_id INNER JOIN seance_groupes ON seance.seance_id=seance_groupes.seance_id INNER JOIN seance_salles ON seance.seance_id=seance_salles.seance_id WHERE groupe_id=" + groupeId + " ORDER BY numero_semaine, date_seance, heure_debut");
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT seance.seance_id, numero_semaine, date_seance, heure_debut, heure_fin, etat_seance, cours_id, type_cours_id, groupe_id FROM seance INNER JOIN seance_groupes ON seance.seance_id=seance_groupes.seance_id WHERE groupe_id= " + groupeId + " ORDER BY numero_semaine, date_seance, heure_debut");

            while (result.next()) {
                int seanceId = result.getInt("seance.seance_id");
                int numeroSemaine = result.getInt("numero_semaine");
                String date = result.getString("date_seance");
                String debutHeure = result.getString("heure_debut");
                String finHeure = result.getString("heure_fin");
                int etat = result.getInt("etat_seance");

                CoursDAO c = new CoursDAO();
                Cours cours = c.chercher(result.getInt("cours_id"));

                TypeCoursDAO t = new TypeCoursDAO();
                TypeCours typeCours = t.chercher(result.getInt("type_cours_id"));

                SalleDAO s = new SalleDAO();
                ArrayList<Salle> salles = new ArrayList<Salle>();
                salles = s.chercherSallesParSeanceId(result.getInt("seance.seance_id"));

                EnseignantDAO e = new EnseignantDAO();
                ArrayList<Enseignant> enseignants = new ArrayList<Enseignant>();
                enseignants = e.chercherEnseignantsParSeanceId(result.getInt("seance.seance_id"));

                GroupeDAO g = new GroupeDAO();
                ArrayList<Groupe> groupes = new ArrayList<Groupe>();
                groupes = g.chercherGroupesParSeanceId(result.getInt("seance.seance_id"));

                seance = new Seance(seanceId, numeroSemaine, date, debutHeure, finHeure, etat, cours, typeCours, salles, enseignants, groupes);
                //seance = chercher(result.getInt("seance.seance_id"));
                seances.add(seance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seances;
    }

    public ArrayList<Seance> chercherToutesLesSeances() {
        ArrayList<Seance> seances = new ArrayList<Seance>();
        Seance seance = new Seance();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT seance_id FROM seance ORDER BY numero_semaine, date_seance, heure_debut");
            while (result.next()) {
                seance = chercher(result.getInt("seance_id"));
                seances.add(seance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seances;
    }

    public ArrayList<Seance> chercherSeancesParGroupeIdEtNumeroSemaine(int groupeId, int numeroSemaine) {
        ArrayList<Seance> seances = new ArrayList<Seance>();
        Seance seance = new Seance();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT seance.seance_id, date_seance, heure_debut, heure_fin, etat_seance, cours_id, type_cours_id, enseignant_id, groupe_id, salle_id FROM seance INNER JOIN seance_enseignants\n"
                            + "ON seance.seance_id=seance_enseignants.seance_id INNER JOIN seance_groupes ON seance.seance_id=seance_groupes.seance_id INNER JOIN seance_salles ON seance.seance_id=seance_salles.seance_id WHERE groupe_id=" + groupeId + " AND seance.numero_semaine=" + numeroSemaine + " ORDER BY numero_semaine, date_seance, heure_debut");
            while (result.next()) {
                int seanceId = result.getInt("seance.seance_id");
                String date = result.getString("date_seance");
                String debutHeure = result.getString("heure_debut");
                String finHeure = result.getString("heure_fin");
                int etat = result.getInt("etat_seance");

                CoursDAO c = new CoursDAO();
                Cours cours = c.chercher(result.getInt("cours_id"));

                TypeCoursDAO t = new TypeCoursDAO();
                TypeCours typeCours = t.chercher(result.getInt("type_cours_id"));

                SalleDAO s = new SalleDAO();
                ArrayList<Salle> salles = new ArrayList<Salle>();
                salles = s.chercherSallesParSeanceId(result.getInt("seance.seance_id"));

                EnseignantDAO e = new EnseignantDAO();
                ArrayList<Enseignant> enseignants = new ArrayList<Enseignant>();
                enseignants = e.chercherEnseignantsParSeanceId(result.getInt("seance.seance_id"));

                GroupeDAO g = new GroupeDAO();
                ArrayList<Groupe> groupes = new ArrayList<Groupe>();
                groupes = g.chercherGroupesParSeanceId(result.getInt("seance.seance_id"));

                seance = new Seance(seanceId, numeroSemaine, date, debutHeure, finHeure, etat, cours, typeCours, salles, enseignants, groupes);
                seances.add(seance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seances;
    }

    public ArrayList<Seance> chercherSeancesParEnseignantId(int enseignantId) {
        ArrayList<Seance> seances = new ArrayList<Seance>();
        Seance seance = new Seance();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT seance.seance_id, numero_semaine, date_seance, heure_debut, heure_fin, etat_seance, cours_id, type_cours_id, enseignant_id, groupe_id, salle_id FROM seance INNER JOIN seance_enseignants ON seance.seance_id=seance_enseignants.seance_id INNER JOIN seance_groupes ON seance.seance_id=seance_groupes.seance_id INNER JOIN seance_salles ON seance.seance_id=seance_salles.seance_id WHERE enseignant_id = " + enseignantId + " ORDER BY numero_semaine, date_seance, heure_debut");
            while (result.next()) {
                int seanceId = result.getInt("seance.seance_id");
                int numeroSemaine = result.getInt("numero_semaine");
                String date = result.getString("date_seance");
                String debutHeure = result.getString("heure_debut");
                String finHeure = result.getString("heure_fin");
                int etat = result.getInt("etat_seance");

                CoursDAO c = new CoursDAO();
                Cours cours = c.chercher(result.getInt("cours_id"));

                TypeCoursDAO t = new TypeCoursDAO();
                TypeCours typeCours = t.chercher(result.getInt("type_cours_id"));

                SalleDAO s = new SalleDAO();
                ArrayList<Salle> salles = new ArrayList<Salle>();
                salles = s.chercherSallesParSeanceId(result.getInt("seance.seance_id"));

                EnseignantDAO e = new EnseignantDAO();
                ArrayList<Enseignant> enseignants = new ArrayList<Enseignant>();
                enseignants = e.chercherEnseignantsParSeanceId(result.getInt("seance.seance_id"));

                GroupeDAO g = new GroupeDAO();
                ArrayList<Groupe> groupes = new ArrayList<Groupe>();
                groupes = g.chercherGroupesParSeanceId(result.getInt("seance.seance_id"));

                seance = new Seance(seanceId, numeroSemaine, date, debutHeure, finHeure, etat, cours, typeCours, salles, enseignants, groupes);
                seances.add(seance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seances;
    }

    public ArrayList<Seance> chercherSeancesParEnseignantIdEtNumeroSemaine(int enseignantId, int numeroSemaine) {
        ArrayList<Seance> seances = new ArrayList<Seance>();
        Seance seance = new Seance();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT seance.seance_id, date_seance, heure_debut, heure_fin, etat_seance, cours_id, type_cours_id, enseignant_id, groupe_id, salle_id FROM seance INNER JOIN seance_enseignants\n"
                            + "ON seance.seance_id=seance_enseignants.seance_id INNER JOIN seance_groupes ON seance.seance_id=seance_groupes.seance_id INNER JOIN seance_salles ON seance.seance_id=seance_salles.seance_id WHERE enseignant_id=" + enseignantId + " AND seance.numero_semaine=" + numeroSemaine + " ORDER BY numero_semaine, date_seance, heure_debut");
            while (result.next()) {
                int seanceId = result.getInt("seance.seance_id");
                String date = result.getString("date_seance");
                String debutHeure = result.getString("heure_debut");
                String finHeure = result.getString("heure_fin");
                int etat = result.getInt("etat_seance");

                CoursDAO c = new CoursDAO();
                Cours cours = c.chercher(result.getInt("cours_id"));

                TypeCoursDAO t = new TypeCoursDAO();
                TypeCours typeCours = t.chercher(result.getInt("type_cours_id"));

                SalleDAO s = new SalleDAO();
                ArrayList<Salle> salles = new ArrayList<Salle>();
                salles = s.chercherSallesParSeanceId(result.getInt("seance.seance_id"));

                EnseignantDAO e = new EnseignantDAO();
                ArrayList<Enseignant> enseignants = new ArrayList<Enseignant>();
                enseignants = e.chercherEnseignantsParSeanceId(result.getInt("seance.seance_id"));

                GroupeDAO g = new GroupeDAO();
                ArrayList<Groupe> groupes = new ArrayList<Groupe>();
                groupes = g.chercherGroupesParSeanceId(result.getInt("seance.seance_id"));

                seance = new Seance(seanceId, numeroSemaine, date, debutHeure, finHeure, etat, cours, typeCours, salles, enseignants, groupes);
                seances.add(seance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seances;
    }

    public void changerHeureDeSeance(int seanceId, String heure) {
        try {
            int result = this.connect.createStatement().executeUpdate("UPDATE `seance` SET `heure_debut` = '" + heure + "' WHERE `seance`.`seance_id` =" + seanceId);
            if (result == 1) {
                System.out.println("Succcess");
            } else {
                System.out.println("Failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ajouterEnseignantASeance(int seanceId, int enseignantId) {
        try {
            int result = this.connect.createStatement().executeUpdate("INSERT INTO `seance_enseignants` (`seance_id`, `enseignant_id`) VALUES (" + seanceId + ", " + enseignantId + ")");
            if (result == 1) {
                System.out.println("Succcess");
            } else {
                System.out.println("Failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ajouterGroupeASeance(int seanceId, int groupeId) {
        try {
            int result = this.connect.createStatement().executeUpdate("INSERT INTO `seance_groupes` (`seance_id`, `groupe_id`) VALUES (" + seanceId + ", " + groupeId + ")");
            if (result == 1) {
                System.out.println("Succcess");
            } else {
                System.out.println("Failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changerEtatSeance(int seanceId, int etat) {
        try {
            int result = this.connect.createStatement().executeUpdate("UPDATE `seance` SET `etat_seance` = " + etat + " WHERE `seance`.`seance_id` =" + seanceId);
            if (result == 1) {
                System.out.println("Succcess");
            } else {
                System.out.println("Failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void enleverGroupeDeSeance(int seanceId, int groupeId) {
        try {
            PreparedStatement st = this.connect.prepareStatement("DELETE FROM `seance_groupes` WHERE `seance_groupes`.`seance_id` =  ? AND `seance_groupes`.`groupe_id` = ?");
            st.setInt(1, seanceId);
            st.setInt(2, groupeId);
            if (st.execute()) {
                System.out.println("Success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifierTypeCoursSeance(int seanceId, int typeCoursId) {
        try {
            int result = this.connect.createStatement().executeUpdate("UPDATE `seance` SET `type_cours_id` = " + typeCoursId + " WHERE `seance`.`seance_id` = " + seanceId);
            if (result == 1) {
                System.out.println("Succcess");
            } else {
                System.out.println("Failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifierCoursSeance(int seanceId, int coursId) {
        try {
            int result = this.connect.createStatement().executeUpdate("UPDATE `seance` SET `cours_id` = " + coursId + " WHERE `seance`.`seance_id` = " + seanceId);
            if (result == 1) {
                System.out.println("Succcess");
            } else {
                System.out.println("Failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void enleverEnseignantASeance(int seanceId, int enseignantId) {
        try {
            PreparedStatement st = this.connect.prepareStatement("DELETE FROM `seance_enseignants` WHERE `seance_enseignants`.`seance_id` = ? AND `seance_enseignants`.`enseignant_id` = ?");
            st.setInt(1, seanceId);
            st.setInt(2, enseignantId);
            if (st.execute()) {
                System.out.println("Success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ajouterSalleASeance(int seanceId, int salleId) {
        try {
            int result = this.connect.createStatement().executeUpdate("INSERT INTO `seance_salles` (`seance_id`, `salle_id`) VALUES (" + seanceId + ", " + salleId + ")");
            if (result == 1) {
                System.out.println("Succcess");
            } else {
                System.out.println("Failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void enleverSalleDeSeance(int seanceId, int salleId) {
        try {
            PreparedStatement st = this.connect.prepareStatement("DELETE FROM `seance_salles` WHERE `seance_salles`.`seance_id` = ? AND `seance_salles`.`salle_id` = ?");
            st.setInt(1, seanceId);
            st.setInt(2, salleId);
            if (st.execute()) {
                System.out.println("Success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int ajouterSeance(int numeroSemaine, String dateSeance, String heureDebut, String heureFin, int etat, int coursId, int typeCoursId) {
        int cleGeneree = 0;
        try {
            PreparedStatement st = this.connect.prepareStatement("INSERT INTO `seance` (`seance_id`, `numero_semaine`, `date_seance`, `heure_debut`, `heure_fin`, `etat_seance`, `cours_id`, `type_cours_id`) VALUES (NULL, " + numeroSemaine + ", '" + dateSeance + "', '" + heureDebut + "', '" + heureFin + "', " + etat + ", " + coursId + ", " + typeCoursId + ")", Statement.RETURN_GENERATED_KEYS);
            if (st.execute()) {
                System.out.println("Success");
            }
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                cleGeneree = rs.getInt(1);
            }
            System.out.println("Seance ID: " + cleGeneree + " a ete ajoutee!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cleGeneree;
    }

//test
    public static void main(String[] args) {
        SeanceDAO et = new SeanceDAO();
        Seance un = et.chercher(44);
        un.afficher();

//        ArrayList<Seance> seances = new ArrayList<Seance>();
//        seances = et.chercherSeancesParGroupeId(31);
//        for (Seance s : seances) {
//            System.out.println(s.stringifyVertical());
//        }
    }
}
