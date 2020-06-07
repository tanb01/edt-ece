package controleur;

import dao.EnseignantDAO;
import dao.SeanceDAO;
import dao.SiteDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import modele.Cours;
import modele.Enseignant;
import modele.Groupe;
import modele.Salle;
import modele.Seance;
import modele.Site;
import modele.User;
import vue.EnseignantVue;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class EnseignantEDTControleur implements ActionListener, ItemListener {

    private EnseignantDAO etuddao = null;
    private Enseignant e = null;

    private SeanceDAO seance = null;
    private SiteDAO site = null;

    private ArrayList<Seance> listSeances = null;
    private ArrayList<Seance> listSeancesSelectionnees = null;
    private int numeroSemaineSelected = 1;

    private EnseignantVue ve = null;

    private DefaultTableModel dtm = null;

    private ArrayList<Site> listSites = null;

    /**
     *
     * @param m
     * @param v
     */
    public EnseignantEDTControleur(User m, EnseignantVue v) {
        ve = new EnseignantVue("Enseignant vue");
        ve = v;

        etuddao = new EnseignantDAO();
        e = new Enseignant();
        seance = new SeanceDAO();
        site = new SiteDAO();

        e = etuddao.chercher(m.getUserId());
        listSeances = new ArrayList<Seance>();
        listSeances = seance.chercherSeancesParEnseignantId(e.getUserId());
        listSeancesSelectionnees = new ArrayList<Seance>();
        listSeancesSelectionnees = getSeancesParEnseignantIdEtNumeroSemaine(e.getUserId(), numeroSemaineSelected);
        listSites = new ArrayList<Site>();
        listSites = site.chercherTousLesSites();
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

        ve.getBoutonReporting().addActionListener(this);
        ve.getBoutonReportingCapaciteSalles().addActionListener(this);
        ve.getBoutonTauxOccupationSalles().addActionListener(this);
        ve.getBoutonReportingEffectifGroupe().addActionListener(this);
        ve.getBoutonReportingSeancesParCours().addActionListener(this);

        ve.getJComboBoxSelectionVue().addItemListener(this);

        ve.getJComboBoxFilterSelection().addItemListener(this);

        ve.getButtonSearchFiltre().addActionListener(this);

        ve.setTableEnGrille(dtm);
        ve.setVisible(true);
        System.out.println("Control");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == ve.getBoutonEmploiDuTemps()) {
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
        if (ae.getSource() == ve.getBoutonReporting()) {
            ve.showReporting();
        }
        if (ae.getSource() == ve.getBoutonReportingCapaciteSalles()) {
            //Capacite des salles par site
            ReportingControleur demo = new ReportingControleur("Reporting");
            demo.reportingCapaciteSallesParSiteHisto();
            demo.setVisible(true);

        }
        if (ae.getSource() == ve.getBoutonTauxOccupationSalles()) {
//        //taux d'occupation des salles par site
            ReportingControleur demo = new ReportingControleur("Reporting");
            demo.reportingTauxOccupationSallesHisto();
            demo.setVisible(true);
        }
        if (ae.getSource() == ve.getBoutonReportingEffectifGroupe()) {
            //nombre effectif par groupe dans l'annee
            ReportingControleur demo = new ReportingControleur("Reporting");
            demo.reportingEffectifGroupesParPromo();
            demo.setVisible(true);
        }
        if (ae.getSource() == ve.getBoutonReportingSeancesParCours()) {
            //Nombre d'heures de seances par cours
            ReportingControleur demo = new ReportingControleur("Reporting");
            demo.reportingHeuresDeSeancesParCours();
            demo.setVisible(true);
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

            if (ve.getJComboBoxFilterSelection().getSelectedItem().toString().equals("Nom enseignant(e)")) {
                System.out.println("yf");

                ve.selectSemaine(numeroSemaineSelected);
                affecterSeancesDeSemaine();
                String nomEnseignant = ve.getFiltreField();
                listSeancesSelectionnees = filtrerParEnseignant(nomEnseignant);
                montrerEDT();
            }
            if (ve.getJComboBoxFilterSelection().getSelectedItem().toString().equals("Matière")) {

                ve.selectSemaine(numeroSemaineSelected);
                affecterSeancesDeSemaine();
                String nomCours = ve.getFiltreField();
                listSeancesSelectionnees = filtrerParMatiere(nomCours);
                montrerEDT();
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

    public void montrerVueEnGrille() {
        System.out.println("grille");
        String[][] data = new String[84][100];
        String[] horairesPossibles = new String[]{"08:30-10:00", "10:15-11:45", "12:00-13:30", "13:45-15:15", "15:30-17:00", "17:15-18:45", "19:00-20:30"};
        for (int i = 0; i < 7; i++) {
            data[i][0] = horairesPossibles[i];
        }

        int g = 0;
        int colinc = 1;
        String jour = "null";
        jour = "Lundi";

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

    public void montrerEDT() {
        if (ve.getJComboBoxSelectionVue().getSelectedItem().toString().equals("en grille")) {
            montrerVueEnGrille();
        } else {
            montrerVueEnListe();
        }
    }

    public ArrayList<Seance> filtrerParEnseignant(String nomEnseignant) {
        ArrayList<Seance> tempArray = new ArrayList<Seance>();
        //listSeancesSelectionnees = new ArrayList<Seance>();
        for (int i = 0; i < listSeancesSelectionnees.size(); i++) {
            for (int j = 0; j < listSeancesSelectionnees.get(i).getListeEnseignants().size(); j++) {
                for (Enseignant e : listSeancesSelectionnees.get(i).getListeEnseignants()) {
                    if (e.getNom().equalsIgnoreCase(nomEnseignant)) {
                        tempArray.add(listSeancesSelectionnees.get(i));
                    }
                }
            }
        }
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

    public ArrayList<String> getNomCours() {
        ArrayList<String> tempArray = new ArrayList<String>();
        getListeCours().forEach(cours -> tempArray.add(cours.getNomCours()));
        List<String> tempArray2 = tempArray.stream().distinct().collect(Collectors.toList());
        ArrayList<String> tempArray3 = new ArrayList<String>();
        tempArray2.forEach(s -> tempArray3.add(s));
        return tempArray3;
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

    public ArrayList<Salle> getDistincteSalles(ArrayList<Salle> tempArray) {
        List<Salle> tempArray2 = tempArray.stream().distinct().collect(Collectors.toList());
        ArrayList<Salle> tempArray3 = new ArrayList<Salle>();
        tempArray2.forEach(s -> tempArray3.add(s));
        return tempArray3;
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

    public static void main(String[] args) {
        //test enseignant
        EnseignantDAO dao = new EnseignantDAO();
        Enseignant m = new Enseignant();
        m = dao.chercher(175);
        EnseignantVue v = new EnseignantVue("Enseignant Vue");
        EnseignantEDTControleur controler = new EnseignantEDTControleur(m, v);
        controler.control();
    }
}
