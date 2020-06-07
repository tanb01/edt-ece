package controleur;

import dao.CoursDAO;
import dao.EnseignantDAO;
import dao.EtudiantDAO;
import dao.GroupeDAO;
import dao.PromotionDAO;
import dao.SalleDAO;
import dao.SeanceDAO;
import dao.SiteDAO;
import dao.TypeCoursDAO;
import dao.UserDAO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ArrayList;
import static java.util.Collections.sort;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import modele.Cours;
import modele.Admin;
import modele.Admin;
import modele.Enseignant;
import modele.Groupe;
import modele.Promotion;
import modele.Salle;
import modele.Seance;
import modele.Site;
import modele.TypeCours;
import modele.User;
import vue.AdminVue;
import vue.AdminVue;
import vue.AdminVue;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class AdminEDTControleur implements ActionListener, ItemListener {

    private CoursDAO cours = null;
    private EnseignantDAO enseignant = null;
    private EtudiantDAO etudiant = null;
    private GroupeDAO groupe = null;
    private PromotionDAO promotion = null;
    private SalleDAO salle = null;
    private SeanceDAO seance = null;
    private SiteDAO site = null;
    private TypeCoursDAO typeCours = null;
    private UserDAO user = null;

    private ArrayList<Seance> listSeances = null;
    private ArrayList<Seance> listSeancesSelectionnees = null;
    private int numeroSemaineSelected = 1;

    private AdminVue ve = null;

    private DefaultTableModel dtm = null;

    private ArrayList<Cours> listCours = null;
    private ArrayList<TypeCours> listTypeCours = null;
    private ArrayList<Enseignant> listEnseignants = null;
    private ArrayList<Salle> listSalles = null;
    private ArrayList<Site> listSites = null;
    private ArrayList<Promotion> listPromo = null;

    private Seance seanceSelectionneePourModifier = null;

    /**
     *
     * @param m
     * @param v
     */
    public AdminEDTControleur(User m, AdminVue v) {

        ve = new AdminVue("Admin vue");
        ve = v;

        cours = new CoursDAO();
        enseignant = new EnseignantDAO();
        etudiant = new EtudiantDAO();
        groupe = new GroupeDAO();
        promotion = new PromotionDAO();
        salle = new SalleDAO();
        seance = new SeanceDAO();
        site = new SiteDAO();
        typeCours = new TypeCoursDAO();
        UserDAO user = new UserDAO();

        seance = new SeanceDAO();

        seanceSelectionneePourModifier = new Seance();

        listSeances = new ArrayList<Seance>();
        listSeances = seance.chercherSeancesParGroupeId(31);
        listSeancesSelectionnees = new ArrayList<Seance>();
        listSeancesSelectionnees = getSeancesParGroupeIdEtNumeroSemaine(31, numeroSemaineSelected);
        listCours = new ArrayList<Cours>();
        listCours = cours.chercherTousLesCours();
        listTypeCours = new ArrayList<TypeCours>();
        listTypeCours = typeCours.chercherTousLesTypeCours();
        listEnseignants = new ArrayList<Enseignant>();
        listEnseignants = enseignant.chercherTousLesEnseignants();
        listSites = new ArrayList<Site>();
        listSites = site.chercherTousLesSites();
        listPromo = new ArrayList<Promotion>();
        listPromo = promotion.chercherToutesLesPromos();

        String[][] data = new String[84][100];

        String[] horairesPossibles = new String[]{"08:30-10:00", "10:15-11:45", "12:00-13:30", "13:45-15:15", "15:30-17:00", "17:15-18:45", "19:00-20:30"};
        for (int i = 0; i < 7; i++) {
            data[i][0] = horairesPossibles[i];
        }

        int g = 0;
        int colinc = 1;
        String jour = "Lundi";

        // Vue en grille
        while (g < listSeancesSelectionnees.size()) {
            //System.out.println("id: " + g);
            if (jour == getJourDeLaSemaine(listSeancesSelectionnees.get(g).getDate())) {
                for (int i = 0; i < 7; i++) {
                    if ((listSeancesSelectionnees.get(g).getDebutHeure() + "-" + listSeancesSelectionnees.get(g).getFinHeure()).equals(data[i][0])) {
                        data[i][colinc] = listSeancesSelectionnees.get(g).stringifyHorizontal();
                    }
                }
                g++;
            } else {
                colinc++;
                jour = getJourDeLaSemaine(listSeancesSelectionnees.get(g).getDate());
            }
        }

        DefaultTableModel dtm = new DefaultTableModel(
                data,
                new String[]{
                    " ", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"
                }
        );
        this.dtm = dtm;

    }

    /**
     * Change les jours de la semaine de Anglais à Francais.
     *
     * @param date
     * @return
     */
    public String getJourDeLaSemaine(String date) {
        LocalDate localDate = LocalDate.parse(date);
        DayOfWeek day = localDate.getDayOfWeek();
        String jour = "null";
        switch (day.toString()) {
            case "MONDAY":
                jour = "Lundi";
                break;
            case "TUESDAY":
                jour = "Mardi";
                break;
            case "WEDNESDAY":
                jour = "Mercredi";
                break;
            case "THURSDAY":
                jour = "Jeudi";
                break;
            case "FRIDAY":
                jour = "Vendredi";
                break;
            case "SATURDAY":
                jour = "Samedi";
                break;
            case "SUNDAY":
                jour = "Dimanche";
                break;
        }
        return jour;
    }

    public void control() {
        ve.getBoutonEmploiDuTemps().addActionListener(this);
        for (JButton bouton : ve.getBoutonsSemaine()) {
            bouton.addActionListener(this);
        }
        ve.getBoutonSallesLibres().addActionListener(this);
        ve.getBoutonValiderRechercheSalleLibre().addActionListener(this);

        ve.getBoutonAjouterSeance().addActionListener(this);
        ve.getBoutonReporting().addActionListener(this);

        ve.getBoutonModifier().addActionListener(this);
        ve.getDateFieldToSelectSeance().addActionListener(this);
        for (JComboBox j : ve.getJComboBoxModifierSeance()) {
            j.addItemListener(this);
        }
        ve.getBoutonSelectionnerSeance().addActionListener(this);
        ve.getBoutonValiderModificationSeance().addActionListener(this);

        ve.getJComboBoxSelectionVue().addItemListener(this);

        ve.getJComboBoxFilterSelection().addItemListener(this);

        ve.getJComboBoxlisteSelectionEnseignantAjouterSeance().addItemListener(this);
//        ve.getJComboBoxlisteSelectionCoursAjouterSeance().addItemListener(this);

        //ve.getButtonSearchFiltre().addActionListener(this);
        ve.getBoutonValiderAjoutSeance().addActionListener(this);
        ve.setTableEnGrille(dtm);
        ve.setVisible(true);
        System.out.println("Control");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == ve.getBoutonEmploiDuTemps()) {
            affecterSeancesDeSemaine();
            montrerEDT();
            ve.showEmploiDuTemps();
        }
        if (ae.getSource() == ve.getBoutonSallesLibres()) {
            ve.showSallesLibres();
        }
        if (ae.getSource() == ve.getBoutonValiderRechercheSalleLibre()) {
            //===> Verifier si int
            int capacite = Integer.parseInt(ve.getTextFieldCapaciteMaximaleSalleLibre().getText());
            String heure = ve.getListeSelectionHeureSalleLibre().getSelectedItem().toString();
            StringBuilder builder = new StringBuilder(heure);
            builder.replace(4, 10, "");
            heure = builder.toString().concat(":00");
//            System.out.println(heure);
            String date = ve.getDateFieldSalleLibre().getText().toString();
            String nomSite = ve.getListeSelectionSiteSalleLibre().getSelectedItem().toString();
            ArrayList<Salle> sallesDisponibles = new ArrayList<Salle>();
            sallesDisponibles = getToutesSallesDisponibles(capacite, heure, date, nomSite);
            montrerSallesLibres(sallesDisponibles);
        }
        if (ae.getSource() == ve.getBoutonAjouterSeance()) {
            ve.showMenuAjouterSeance();
            ve.setJComboBoxlisteSelectionEnseignantAjouterSeance(getNomEnseignantsEnArray());
        }
        if (ae.getSource() == ve.getBoutonReporting()) {
            ve.showReporting();
        }
        if (ae.getSource() == ve.getBoutonModifier()) {
            ve.showMenuModifierSeance();
            ve.getJComboBoxModifierSeance().get(0).setModel(new DefaultComboBoxModel(getNomEnseignantsEnArray()));
            ve.getJComboBoxModifierSeance().get(1).setModel(new DefaultComboBoxModel(getNomCoursEnArray()));
            ve.getJComboBoxModifierSeance().get(2).setModel(new DefaultComboBoxModel(getPromoNomEnArray()));

            ve.getJComboBoxModifierSeance().get(5).setModel(new DefaultComboBoxModel(getNomEnseignantsEnArray()));
            ve.getJComboBoxModifierSeance().get(6).setModel(new DefaultComboBoxModel(getNomEnseignantsEnArray()));
            ve.getJComboBoxModifierSeance().get(7).setModel(new DefaultComboBoxModel(getNomEnseignantsEnArray()));
            ve.getJComboBoxModifierSeance().get(11).setModel(new DefaultComboBoxModel(getNomEnseignantsEnArray()));

//groupe
//groupe
//groupe
            //typecours
            //salle
            //sallenom ve.getJComboBoxModifierSeance().get(15).setM
            //ve.getJComboBoxModifierSeance().get(16).setModel(new DefaultComboBoxModel(getNomEnseignantsEnArray()));
            ve.getJComboBoxModifierSeance().get(17).setModel(new DefaultComboBoxModel(getNomEnseignantsEnArray()));

            for (int i = 0; i < ve.getJComboBoxModifierSeance().size(); i++) {
                ve.getJComboBoxModifierSeance().get(i).revalidate();
                ve.getJComboBoxModifierSeance().get(i).repaint();
            }

        }
        if (ae.getSource() == ve.getBoutonSelectionnerSeance()) {
            String nomEnseignant = ve.getJComboBoxModifierSeance().get(0).getSelectedItem().toString();
            String dateSeance = ve.getDateFieldToSelectSeance().getText();
            String nomCours = ve.getJComboBoxModifierSeance().get(1).getSelectedItem().toString();
            String nomPromo = ve.getJComboBoxModifierSeance().get(2).getSelectedItem().toString();
            String heureDebut = ve.getJComboBoxModifierSeance().get(3).getSelectedItem().toString();
            String nomGroupe = ve.getJComboBoxModifierSeance().get(4).getSelectedItem().toString();
            if (verifySeance(nomEnseignant, dateSeance, nomCours, nomPromo, heureDebut, nomGroupe)) {
                seanceSelectionneePourModifier = findSeance(nomEnseignant, dateSeance, nomCours, nomPromo, heureDebut, nomGroupe);
                ve.setSeanceSelectionneeField("Seance Id: " + seanceSelectionneePourModifier.getSeanceId() + ", Prof: " + seanceSelectionneePourModifier.getListeEnseignants().get(0).getNom());
                System.out.println(seanceSelectionneePourModifier.toString());
                showMessageDialog(null, "Seance selectionnee : " + seanceSelectionneePourModifier.stringifyVertical());
            }
        }
        if (ae.getSource() == ve.getBoutonValiderModificationSeance()) {
            if (!ve.getJComboBoxModifierSeance().get(5).getSelectedItem().toString().equals(" ")) {
                //verify if not already added
                int enseignantId = getEnseignantIdParNom(ve.getJComboBoxModifierSeance().get(5).getSelectedItem().toString());
                ajouterEnseignantASeance(seanceSelectionneePourModifier.getSeanceId(), enseignantId);
                System.out.println("Enseignant " + enseignantId + " a ete ajoute a la seance id: " + seanceSelectionneePourModifier.getSeanceId());
                showMessageDialog(null, "Enseignant " + enseignantId + " a ete ajoute a la seance id: " + seanceSelectionneePourModifier.getSeanceId());
            }
        }

        if (ae.getSource() == ve.getBoutonValiderAjoutSeance()) {
            String date = LocalDate.parse(ve.getDateFieldAjouterSeance().getText()).toString();
            String heureDebut = ve.getJComboBoxlisteSelectionHeureDebutAjouterSeance().getSelectedItem().toString();
            heureDebut = heureDebut.concat(":00");
            System.out.println(heureDebut);
            Time myTime = java.sql.Time.valueOf(heureDebut);
            LocalTime localtime = myTime.toLocalTime();
            localtime = localtime.plusMinutes(90);
            String output = localtime.toString();
            output = output.concat(":00");
            System.out.println(output);
            String heureFin = ve.getJComboBoxlisteSelectionHeureFinAjouterSeance().getSelectedItem().toString();
            int etat = 0;
            int coursId = getCoursIdParNom(ve.getJComboBoxlisteSelectionCoursAjouterSeance().getSelectedItem().toString());
            System.out.println(coursId);
            int typeCoursId = getTypeCoursIdParNom(ve.getJComboBoxlisteSelectionTypeCoursAjouterSeance().getSelectedItem().toString());
            System.out.println(typeCoursId);
            int enseignantId = getEnseignantIdParNom(ve.getJComboBoxlisteSelectionEnseignantAjouterSeance().getSelectedItem().toString());
            System.out.println(enseignantId);
            int groupeId = 31;
            int salleId = 1;
            ajouterSeance(date, heureDebut, output, etat, coursId, typeCoursId, enseignantId, groupeId, salleId);
        }

        for (JButton bouton : ve.getBoutonsSemaine()) {
            if (ae.getSource() == bouton) {
                numeroSemaineSelected = (ve.getBoutonsSemaine().indexOf(bouton)) + 1;
                ve.selectSemaine(numeroSemaineSelected);
                affecterSeancesDeSemaine();
                montrerEDT();
            }
        }
        if (ae.getSource() == ve.getButtonSearchFiltre()) {
            System.out.println("yummy");

            if (ve.getJComboBoxFilterSelection().getSelectedItem().toString().equals("Nom Enseignant(e)")) {
                System.out.println("yf");
                ve.selectSemaine(numeroSemaineSelected);
                affecterSeancesDeSemaine();
                String nomEnseignant = ve.getFiltreField();
                listSeancesSelectionnees = filtrerParEnseignant(nomEnseignant);
                montrerEDT();
            }
            if (ve.getJComboBoxFilterSelection().getSelectedItem().toString().equals("Promotion")) {
//                ve.selectSemaine(numeroSemaineSelected);
//                affecterSeancesDeSemaine();
//                String nomCours = ve.getFiltreField();
//                listSeancesSelectionnees = filtrerParMatiere(nomCours);
//                montrerEDT();
            }
            if (ve.getJComboBoxFilterSelection().getSelectedItem().toString().equals("Groupe")) {
//                ve.selectSemaine(numeroSemaineSelected);
//                affecterSeancesDeSemaine();
//                String nomCours = ve.getFiltreField();
//                listSeancesSelectionnees = filtrerParMatiere(nomCours);
//                montrerEDT();
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getStateChange() == ItemEvent.SELECTED) {
            switch (ve.getJComboBoxSelectionVue().getSelectedItem().toString()) {
                case "en grille":
                    montrerVueEnGrille();
                    break;
                case "en liste":
                    System.out.println("liste");
                    montrerVueEnListe();
                    break;
            }
            switch (ve.getJComboBoxFilterSelection().getSelectedItem().toString()) {
                case " ":
                    ve.getFiltre().setText(" ");
                    ve.selectSemaine(numeroSemaineSelected);
                    affecterSeancesDeSemaine();
                    montrerEDT();
                    break;
            }
            //
        }
    }

    public ArrayList<Seance> getSeancesParEnseignantIdEtNumeroSemaine(int enseignantId, int numeroSemaine) {
        ArrayList<Seance> tempArray = new ArrayList<Seance>();
        for (Seance s : listSeances) {
            if (s.getNumeroSemaine() == numeroSemaine) {
                for (Enseignant e : s.getListeEnseignants()) {
                    if (enseignantId == e.getUserId()) {
                        tempArray.add(s);
                    }
                }

            }
        }
        return tempArray;
    }

    public ArrayList<Seance> getSeancesParGroupeIdEtNumeroSemaine(int groupeId, int numeroSemaine) {
        ArrayList<Seance> tempArray = new ArrayList<Seance>();
        for (Seance s : listSeances) {
            if (s.getNumeroSemaine() == numeroSemaine) {
                for (Groupe g : s.getListeGroupes()) {
                    if (groupeId == g.getGroupeId()) {
                        tempArray.add(s);
                    }
                }
            }
        }
        return tempArray;
    }

    public int getCoursIdParNom(String s) {
        int coursId = 0;
        for (Cours c : listCours) {
            if (c.getNomCours().equals(s)) {
                coursId = c.getCoursId();
            }
        }
        return coursId;
    }

    public int getTypeCoursIdParNom(String s) {
        int typeCoursId = 0;
        for (TypeCours tc : listTypeCours) {
            if (tc.getNomTypeCours().equals(s)) {
                typeCoursId = tc.getTypeCoursId();
            }
        }
        return typeCoursId;
    }

    public int getEnseignantIdParNom(String s) {
        int enseignantId = 0;
        for (Enseignant e : listEnseignants) {
            if (e.getNom().equals(s)) {
                enseignantId = e.getUserId();
            }
        }
        return enseignantId;
    }

    public int getNumeroSemaineParDate(String date) {
        LocalDate localDate = LocalDate.parse(date);
        int nombreDuJour = localDate.getDayOfYear();
        nombreDuJour = Math.round((nombreDuJour - 48) / 7) + 1;
        return nombreDuJour;
    }

    public void affecterSeancesDeSemaine() {
        ArrayList<Seance> tempArray = new ArrayList<Seance>();
        listSeancesSelectionnees = new ArrayList<Seance>();
        for (Seance s : listSeances) {
            if (s.getNumeroSemaine() == numeroSemaineSelected) {
                tempArray.add(s);
                System.out.println("hi : " + s.getNumeroSemaine());
            }
        }
        if (!tempArray.isEmpty()) {
            listSeancesSelectionnees = tempArray;
        }
    }

//    public Time convertStringToSQLTime() {
//        
//    }
    public void montrerVueEnGrille() {
        System.out.println("grille");
        String[][] data = new String[84][100];
        String[] horairesPossibles = new String[]{"08:30-10:00", "10:15-11:45", "12:00-13:30", "13:45-15:15", "15:30-17:00", "17:15-18:45", "19:00-20:30"};
        for (int i = 0; i < 7; i++) {
            data[i][0] = horairesPossibles[i];
        }

        int g = 0;
        int colinc = 1;
        String jour = "Lundi";

        // Vue en grille
        while (g < listSeancesSelectionnees.size()) {
            //System.out.println("id: " + g);
            if (jour.equals(getJourDeLaSemaine(listSeancesSelectionnees.get(g).getDate()))) {
                for (int i = 0; i < 7; i++) {
                    if ((listSeancesSelectionnees.get(g).getDebutHeure() + "-" + listSeancesSelectionnees.get(g).getFinHeure()).equals(data[i][0])) {
                        data[i][colinc] = listSeancesSelectionnees.get(g).stringifyHorizontal();
                    }
                }
                g++;
            } else {
                colinc++;
                jour = getJourDeLaSemaine(listSeancesSelectionnees.get(g).getDate());
            }
        }

        DefaultTableModel dtm = new DefaultTableModel(
                data,
                new String[]{
                    " ", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"
                }
        );
        ve.changeAVueEnGrille(dtm);
        ve.setVisible(true);
    }

    public void montrerVueEnListe() {
        String[][] data2 = new String[listSeancesSelectionnees.size()][1];
        for (int i = 0; i < listSeancesSelectionnees.size(); i++) {
            data2[i][0] = getJourDeLaSemaine(listSeancesSelectionnees.get(i).getDate()) + "     " + listSeancesSelectionnees.get(i).stringifyHorizontal();
        }

        DefaultTableModel dtm2 = new DefaultTableModel(
                data2,
                new String[]{
                    " "
                }
        );
        ve.changeAVueEnListe(dtm2);
        ve.setVisible(true);
    }

    public void montrerSallesLibres(ArrayList<Salle> sallesDisponibles) {
        String[][] data3 = new String[sallesDisponibles.size()][1];
        for (int i = 0; i < sallesDisponibles.size(); i++) {
            data3[i][0] = "Nom salle : " + sallesDisponibles.get(i).getNomSalle() + "   - Capacite : " + sallesDisponibles.get(i).getCapacite();
        }

        DefaultTableModel dtm3 = new DefaultTableModel(
                data3,
                new String[]{
                    "Salles Disponibles"
                }
        );
        ve.changeAVueSallesLibres(dtm3);
        ve.setVisible(true);
    }

    public void montrerEDT() {
        if (ve.getJComboBoxSelectionVue().getSelectedItem().toString().equals("en grille")) {
            montrerVueEnGrille();
        } else {
            montrerVueEnListe();
        }
    }

    public ArrayList<Seance> filtrerParEnseignant(String nomEnseignant) {
        ArrayList<Seance> tempArray = new ArrayList<Seance>();
        for (int i = 0; i < listSeancesSelectionnees.size(); i++) {
            for (int j = 0; j < listSeancesSelectionnees.get(i).getListeEnseignants().size(); j++) {
                for (Enseignant e : listSeancesSelectionnees.get(i).getListeEnseignants()) {
                    if (e.getNom().equalsIgnoreCase(nomEnseignant)) {
                        tempArray.add(listSeancesSelectionnees.get(i));
                    }
                }
            }
        }
//        if (!tempArray.isEmpty()) {
//            listSeancesSelectionnees = tempArray;
//        }
        return tempArray;
    }

    public ArrayList<Seance> filtrerParMatiere(String nomMatiere) {
        ArrayList<Seance> tempArray = new ArrayList<Seance>();
        for (int i = 0; i < listSeancesSelectionnees.size(); i++) {
            if (listSeancesSelectionnees.get(i).getCoursSeance().getNomCours().equalsIgnoreCase(nomMatiere)) {
                tempArray.add(listSeancesSelectionnees.get(i));
            }
        }
        return tempArray;
    }

    public ArrayList<Enseignant> getListeEnseignants() {
        ArrayList<Enseignant> tempArray = new ArrayList<Enseignant>();
        for (int i = 0; i < listSeances.size(); i++) {
            for (int j = 0; j < listSeances.get(i).getListeEnseignants().size(); j++) {
                for (Enseignant e : listSeances.get(i).getListeEnseignants()) {
                    tempArray.add(e);
                }
            }
        }
        return tempArray;
    }

    public ArrayList<Cours> getListeCours() {
        ArrayList<Cours> tempArray = new ArrayList<Cours>();
        for (Seance e : listSeances) {
            tempArray.add(e.getCoursSeance());
        }
        return tempArray;
    }

    public ArrayList<String> getNomEnseignants() {
        ArrayList<String> tempArray = new ArrayList<String>();
        getListeEnseignants().forEach(enseignant -> tempArray.add(enseignant.getNom()));
        List<String> tempArray2 = tempArray.stream().distinct().collect(Collectors.toList());
        ArrayList<String> tempArray3 = new ArrayList<String>();
        tempArray2.forEach(s -> tempArray3.add(s));
        return tempArray3;
    }

    public String[] getNomEnseignantsEnArray() {
        ArrayList<String> names = new ArrayList();
        names = getNomEnseignants();

        String[] tempArray = new String[names.size() + 1];
        tempArray[0] = " ";
        for (int i = 1; i < names.size(); i++) {
            tempArray[i] = names.get(i - 1);
        }
        return tempArray;
    }

    public ArrayList<Salle> getDistincteSalles(ArrayList<Salle> tempArray) {
        List<Salle> tempArray2 = tempArray.stream().distinct().collect(Collectors.toList());
        ArrayList<Salle> tempArray3 = new ArrayList<Salle>();
        tempArray2.forEach(s -> tempArray3.add(s));
        return tempArray3;
    }

    public ArrayList<String> getNomCours(ArrayList<Cours> listeCours) {
        ArrayList<String> tempArray = new ArrayList<String>();
        listeCours.forEach(cours -> tempArray.add(cours.getNomCours()));
        List<String> tempArray2 = tempArray.stream().distinct().collect(Collectors.toList());
        ArrayList<String> tempArray3 = new ArrayList<String>();
        tempArray2.forEach(s -> tempArray3.add(s));
        return tempArray3;
    }

    public String[] getNomCoursEnArray() {
        ArrayList<String> names = new ArrayList();
        names = getNomCours(listCours);

        String[] tempArray = new String[names.size() + 1];
        tempArray[0] = " ";
        for (int i = 1; i < names.size() + 1; i++) {
            tempArray[i] = names.get(i - 1);
        }
        return tempArray;
    }

    public String[] getPromoNomEnArray() {
        ArrayList<String> names = new ArrayList();
        for (Promotion p : listPromo) {
            names.add(p.getNomPromo());
            System.out.println(p.getNomPromo());
        }
        String[] tempArray = new String[names.size() + 1];
        tempArray[0] = " ";
        int i = 1;
        for (String s : names) {
            tempArray[i] = s;
            i++;
        }

        return tempArray;
    }

    public void affecterEnseignantASeance(int seanceId, int oldEnseignantId, int newEnseignantId) {
        seance.enleverEnseignantASeance(seanceId, oldEnseignantId);
        seance.ajouterEnseignantASeance(seanceId, newEnseignantId);
    }

    public void affecterGroupeASeance(int seanceId, int oldGroupeId, int newGroupeId) {
        seance.enleverGroupeDeSeance(seanceId, oldGroupeId);
        seance.ajouterGroupeASeance(seanceId, newGroupeId);
    }

    public void modifierCoursSeance(int seanceId, int coursId) {
        seance.modifierCoursSeance(seanceId, coursId);
    }

    public void modifierTypeCoursSeance(int seanceId, int typeCoursId) {
        seance.modifierTypeCoursSeance(seanceId, typeCoursId);
    }

    public void affecterSalleASeance(int seanceId, int oldSalleId, int newSalleId) {
        seance.enleverSalleDeSeance(seanceId, oldSalleId);
        seance.ajouterSalleASeance(seanceId, newSalleId);
    }

    public void ajouterSalleASeance(int seanceId, int salleId) {
        seance.ajouterSalleASeance(seanceId, salleId);
    }

    public void enleverSalleDeSeance(int seanceId, int salleId) {
        seance.enleverSalleDeSeance(seanceId, salleId);
    }

    public void changerHeureSeance(int seanceId, String heure) {
        seance.changerHeureDeSeance(seanceId, heure);
    }

    public void ajouterSeance(String dateSeance, String heureDebut, String heureFin, int etat, int coursId, int typeCoursId, int enseignantId, int groupeId, int salleId) {
        Seance s = new Seance();
        int numeroSemaine = getNumeroSemaineParDate(dateSeance);
        int seanceId = seance.ajouterSeance(numeroSemaine, dateSeance, heureDebut, heureFin, etat, coursId, typeCoursId);
        seance.ajouterEnseignantASeance(seanceId, enseignantId);
        seance.ajouterGroupeASeance(seanceId, groupeId);
        seance.ajouterSalleASeance(seanceId, salleId);
        System.out.println("Id de seance ajoute: " + seanceId);
        s = seance.chercher(seanceId);
        listSeances.add(s);
        sort(listSeances, new SortByDate().thenComparing(new SortByTime()));
//        sort(listSeancesSelectionnees, new SortByDate());
        showMessageDialog(null, "Seance a ete ajoutee : " + s.stringifyVertical());
    }

    public Seance findSeance(String nomEnseignant, String dateSeance, String nomCours, String nomPromo, String heureDebut, String nomGroupe) {
        Seance seance = new Seance();
        int enseignantId = getEnseignantIdParNom(nomEnseignant);
        int coursId = getCoursIdParNom(nomCours);
        int groupeId = getGroupeIdParGroupeNomEtPromoNom(nomPromo, nomGroupe);
        heureDebut = heureDebut.concat(":00");
        seance = this.seance.chercherSeanceParInfo(enseignantId, dateSeance, coursId, heureDebut, groupeId);
        return seance;
    }

    public boolean verifySeance(String nomEnseignant, String dateSeance, String nomCours, String nomPromo, String heureDebut, String nomGroupe) {
        boolean isExiste = false;
        int enseignantId = getEnseignantIdParNom(nomEnseignant);
        int coursId = getCoursIdParNom(nomCours);
        int groupeId = getGroupeIdParGroupeNomEtPromoNom(nomPromo, nomGroupe);
        heureDebut = heureDebut.concat(":00");
        isExiste = this.seance.verifierSiSeanceExiste(enseignantId, dateSeance, coursId, heureDebut, groupeId);
        return isExiste;
    }

    public int getGroupeIdParGroupeNomEtPromoNom(String nomPromo, String nomGroupe) {
        int groupeId = 0;
        for (Promotion p : listPromo) {
            for (Groupe g : p.getGroupes()) {
                if (nomPromo.equalsIgnoreCase(p.getNomPromo()) && g.getNomGroupe().equalsIgnoreCase(nomGroupe)) {
                    groupeId = g.getGroupeId();
                }
            }
        }
        return groupeId;
    }

    public void ajouterEnseignantASeance(int seanceId, int enseignantId) {
        seance.ajouterEnseignantASeance(seanceId, enseignantId);
        listSeances.removeIf(seance -> seance.getSeanceId() == seanceId);
        listSeances.add(seance.chercher(seanceId));
        sort(listSeances, new SortByDate().thenComparing(new SortByTime()));
        //affecterSeancesDeSemaine();
        listSeancesSelectionnees = getSeancesParGroupeIdEtNumeroSemaine(31, numeroSemaineSelected);

//        sort(listSeancesSelectionnees, new SortByDate());
    }

    public void ajouterGroupeASeance(int seanceId, int groupeId) {
        seance.ajouterGroupeASeance(seanceId, groupeId);
    }

    public void changerEtatSeance(int seanceId, int etat) {
        seance.changerEtatSeance(seanceId, etat);
    }

    public void enleverEnseignantASeance(int seanceId, int enseignantId) {
        seance.enleverEnseignantASeance(seanceId, enseignantId);
    }

    public void enleverGroupeDeSeance(int seanceId, int groupeId) {
        seance.enleverGroupeDeSeance(seanceId, groupeId);
    }

    public ArrayList<Salle> getToutesSallesDisponibles(int capacite, String heureDisponible, String date, String nomSite) {
        ArrayList<Salle> sallesDisponibles = new ArrayList<Salle>();
        for (Site site : listSites) {
            if (site.getNomSite().equals(nomSite)) {
                for (Salle salle : site.getSalles()) {
                    if (salle.getCapacite() <= capacite) {
                        for (Seance seance : listSeances) {
                            for (Salle seanceSalle : seance.getListeSalles()) {
                                if (seanceSalle.getSalleId() == salle.getSalleId() && seance.getDate().equals(date) && seance.getDebutHeure().equals(heureDisponible)) {

                                } else {
                                    sallesDisponibles.add(salle);
                                }
                            }
                        }
                    }

                }
            }
        }
        sallesDisponibles = getDistincteSalles(sallesDisponibles);
        return sallesDisponibles;
    }

    public static void main(String[] args) {
        //test admin
        UserDAO dao = new UserDAO();
        User m = new User();
        m = dao.chercher(1);
        AdminVue v = new AdminVue("Admin Vue");
        AdminEDTControleur controler = new AdminEDTControleur(m, v);
        controler.control();
//controler.ajouterGroupeASeance(1, 32);
//controler.enleverGroupeDeSeance(1, 32);
//controler.modifierTypeCoursSeance(12, 2);
//controler.modifierCoursSeance(12, 2);
//controler.affecterEnseignantASeance(2, 31, 27);

//controler.affecterGroupeASeance(2, 31, 27);
//controler.affecterSalleASeance(2, 28, 11);
//        System.out.println(controler.calculerNumeroSemaine("2020-03-10"));
//        System.out.println(Math.round((((7.0 * weekNumberOfDay) / 48.0) - 7)));
//controler.ajouterSeance("2020-02-17", "08:30:00", "10:00:00", 0, 1, 1, 175, 31, 1);
    }
}
