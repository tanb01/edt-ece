package controleur;

import dao.EtudiantDAO;
import dao.SeanceDAO;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modele.Admin;
import modele.Enseignant;
import modele.Etudiant;
import modele.Seance;
import modele.User;
import vue.AdminVue;
import vue.EtudiantVue;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class EnseignantControleur {
    private Enseignant modele;
    private Enseignant vue;
    private ResultSet rset;
    private final Statement stmt;
    private ResultSetMetaData rsetMeta;

    public EnseignantControleur(Enseignant modele, Enseignant vue) {
        this.modele = modele;
        this.vue = vue;
    }
    
    public int getEnseignantId() {
        return modele.getUserId();
    }
    
    public String getEnseignantNom() {
        return modele.getNom();
    }

    public String getEnseignantPrenom() {
        return modele.getPrenom();
    }
    
    public void updateVue() {
        //vue.printDetailsEnseignant(modele.getUserId(), modele.getNom(), modele.getPrenom());
    }
    
    public ArrayList EnseignantControleur (String table) throws SQLException{
    
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery("nom,  prenom FROM user WHERE droit = 3 AND user_id = " + table);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList de String
        ArrayList<String> liste;
        liste = new ArrayList<>();
        String champs = "";
        // Ajouter tous les champs du resultat dans l'ArrayList
        for (int i = 0; i < nbColonne; i++) {
            champs = champs + " " + rsetMeta.getColumnLabel(i + 1);
        }

        // ajouter un "\n" à la ligne des champs
        champs = champs + "\n";

        // ajouter les champs de la ligne dans l'ArrayList
        liste.add(champs);

        // Retourner l'ArrayList
        return liste;
    }
}
