//package controleur;
//
//import dao.CoursDAO;
//import dao.EnseignantDAO;
//import dao.EtudiantDAO;
//import dao.GroupeDAO;
//import dao.PromotionDAO;
//import dao.SalleDAO;
//import dao.SeanceDAO;
//import dao.SiteDAO;
//import dao.TypeCoursDAO;
//import dao.UserDAO;
//import java.awt.Color;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;
//import java.sql.Date;
//import java.text.SimpleDateFormat;
//import java.time.DayOfWeek;
//import java.time.LocalDate;
//import static java.time.temporal.TemporalQueries.localDate;
//import java.util.ArrayList;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Locale;
//import java.util.Set;
//import java.util.stream.Collectors;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.SwingUtilities;
//import javax.swing.table.DefaultTableModel;
//import modele.Cours;
//import modele.Admin;
//import modele.Admin;
//import modele.Enseignant;
//import modele.Groupe;
//import modele.Seance;
//import modele.User;
//import vue.AdminVue;
//import vue.AdminVue;
//import vue.AdminVue;
//
///**
// *
// * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
// */
//public class adEDTControleur implements ActionListener, ItemListener {
//
//    private CoursDAO cours = null;
//    private EnseignantDAO enseignant = null;
//    private EtudiantDAO etudiant = null;
//    private GroupeDAO groupe = null;
//    private PromotionDAO promotion = null;
//    private SalleDAO salle = null;
//    private SeanceDAO seance = null;
//    private SiteDAO site = null;
//    private TypeCoursDAO typeCours = null;
//    private UserDAO user = null;
//
//    private ArrayList<Seance> listSeances = null;
//    private ArrayList<Seance> listSeancesSelectionnees = null;
//    private int numeroSemaineSelected = 1;
//
//    private AdminVue ve = null;
//
//    private DefaultTableModel dtm = null;
//
//    /**
//     *
//     * @param m
//     * @param v
//     */
//    public adEDTControleur(User m, AdminVue v) {
//
//        ve = new AdminVue("Admin vue");
//        ve = v;
//
//        cours = new CoursDAO();
//        enseignant = new EnseignantDAO();
//        etudiant = new EtudiantDAO();
//        groupe = new GroupeDAO();
//        promotion = new PromotionDAO();
//        salle = new SalleDAO();
//        seance = new SeanceDAO();
//        site = new SiteDAO();
//        typeCours = new TypeCoursDAO();
//        UserDAO user = new UserDAO();
//
//        seance = new SeanceDAO();
//
//        listSeances = new ArrayList<Seance>();
//        listSeances = seance.chercherSeancesParGroupeId(31);
//        listSeancesSelectionnees = new ArrayList<Seance>();
//        listSeancesSelectionnees = getSeancesParGroupeIdEtNumeroSemaine(31, numeroSemaineSelected);
//        String[][] data = new String[84][100];
//
//        String[] horairesPossibles = new String[]{"08:30-10:00", "10:15-11:45", "12:00-13:30", "13:45-15:15", "15:30-17:00", "17:15-18:45", "19:00-20:30"};
//        for (int i = 0; i < 7; i++) {
//            data[i][0] = horairesPossibles[i];
//        }
//
//        int g = 0;
//        int colinc = 1;
//        String jour = "Lundi";
//
//        // Vue en grille
//        while (g < listSeancesSelectionnees.size()) {
//            //System.out.println("id: " + g);
//            if (jour == getJourDeLaSemaine(listSeancesSelectionnees.get(g).getDate())) {
//                for (int i = 0; i < 7; i++) {
//                    if ((listSeancesSelectionnees.get(g).getDebutHeure() + "-" + listSeancesSelectionnees.get(g).getFinHeure()).equals(data[i][0])) {
//                        data[i][colinc] = listSeancesSelectionnees.get(g).stringify();
//                    }
//                }
//                g++;
//            } else {
//                colinc++;
//                jour = getJourDeLaSemaine(listSeancesSelectionnees.get(g).getDate());
//            }
//        }
//
//        DefaultTableModel dtm = new DefaultTableModel(
//                data,
//                new String[]{
//                    " ", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"
//                }
//        );
//        this.dtm = dtm;
//
//    }
//
//    /**
//     * Change les jours de la semaine de Anglais à Francais.
//     *
//     * @param date
//     * @return
//     */
//    public String getJourDeLaSemaine(String date) {
//        LocalDate localDate = LocalDate.parse(date);
//        DayOfWeek day = localDate.getDayOfWeek();
//        String jour = "null";
//        switch (day.toString()) {
//            case "MONDAY":
//                jour = "Lundi";
//                break;
//            case "TUESDAY":
//                jour = "Mardi";
//                break;
//            case "WEDNESDAY":
//                jour = "Mercredi";
//                break;
//            case "THURSDAY":
//                jour = "Jeudi";
//                break;
//            case "FRIDAY":
//                jour = "Vendredi";
//                break;
//            case "SATURDAY":
//                jour = "Samedi";
//                break;
//            case "SUNDAY":
//                jour = "Dimanche";
//                break;
//        }
//        return jour;
//    }
//
//    public void control() {
//        ve.getBoutonEmploiDuTemps().addActionListener(this);
//        for (JButton bouton : ve.getBoutonsSemaine()) {
//            bouton.addActionListener(this);
//        }
//        ve.getBoutonSallesLibres().addActionListener(this);
//        ve.getBoutonReporting().addActionListener(this);
//        ve.getJComboBoxSelectionVue().addItemListener(this);
//
//        ve.getJComboBoxFilterSelection().addItemListener(this);
//
//        ve.getButtonSearchFiltre().addActionListener(this);
//
//        ve.setTableEnGrille(dtm);
//        ve.setVisible(true);
//        System.out.println("Control");
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == ve.getBoutonEmploiDuTemps()) {
//            ve.showEmploiDuTemps();
//        }
//        if (ae.getSource() == ve.getBoutonSallesLibres()) {
//            ve.showSallesLibres();
//        }
//        if (ae.getSource() == ve.getBoutonReporting()) {
//            ve.showReporting();
//        }
//        for (JButton bouton : ve.getBoutonsSemaine()) {
//            if (ae.getSource() == bouton) {
//                numeroSemaineSelected = (ve.getBoutonsSemaine().indexOf(bouton)) + 1;
//                ve.selectSemaine(numeroSemaineSelected);
//                affecterSeancesDeSemaine();
//                montrerEDT();
//            }
//        }
//        if (ae.getSource() == ve.getButtonSearchFiltre()) {
//            System.out.println("yummy");
//
//            if (ve.getJComboBoxFilterSelection().getSelectedItem().toString().equals("Nom Enseignant(e)")) {
//                System.out.println("yf");
//                ve.selectSemaine(numeroSemaineSelected);
//                affecterSeancesDeSemaine();
//                String nomEnseignant = ve.getFiltreField();
//                listSeancesSelectionnees = filtrerParEnseignant(nomEnseignant);
//                montrerEDT();
//            }
//            if (ve.getJComboBoxFilterSelection().getSelectedItem().toString().equals("Promotion")) {
////                ve.selectSemaine(numeroSemaineSelected);
////                affecterSeancesDeSemaine();
////                String nomCours = ve.getFiltreField();
////                listSeancesSelectionnees = filtrerParMatiere(nomCours);
////                montrerEDT();
//            }
//            if (ve.getJComboBoxFilterSelection().getSelectedItem().toString().equals("Groupe")) {
////                ve.selectSemaine(numeroSemaineSelected);
////                affecterSeancesDeSemaine();
////                String nomCours = ve.getFiltreField();
////                listSeancesSelectionnees = filtrerParMatiere(nomCours);
////                montrerEDT();
//            }
//        }
//    }
//
//    @Override
//    public void itemStateChanged(ItemEvent ie) {
//        if (ie.getStateChange() == ItemEvent.SELECTED) {
//            switch (ve.getJComboBoxSelectionVue().getSelectedItem().toString()) {
//                case "en grille":
//                    montrerVueEnGrille();
//                    break;
//                case "en liste":
//                    System.out.println("liste");
//                    montrerVueEnListe();
//                    break;
//            }
//            switch (ve.getJComboBoxFilterSelection().getSelectedItem().toString()) {
//                case " ":
//                    ve.getFiltre().setText(" ");
//                    ve.selectSemaine(numeroSemaineSelected);
//                    affecterSeancesDeSemaine();
//                    montrerEDT();
//                    break;
//            }
//        }
//    }
//
//    public ArrayList<Seance> getSeancesParEnseignantIdEtNumeroSemaine(int enseignantId, int numeroSemaine) {
//        ArrayList<Seance> tempArray = new ArrayList<Seance>();
//        for (Seance s : listSeances) {
//            if (s.getNumeroSemaine() == numeroSemaine) {
//                for (Enseignant e : s.getListeEnseignants()) {
//                    if (enseignantId == e.getUserId()) {
//                        tempArray.add(s);
//                    }
//                }
//
//            }
//        }
//        return tempArray;
//    }
//
//    public ArrayList<Seance> getSeancesParGroupeIdEtNumeroSemaine(int groupeId, int numeroSemaine) {
//        ArrayList<Seance> tempArray = new ArrayList<Seance>();
//        for (Seance s : listSeances) {
//            if (s.getNumeroSemaine() == numeroSemaine) {
//                for (Groupe g : s.getListeGroupes()) {
//                    if (groupeId == g.getGroupeId()) {
//                        tempArray.add(s);
//                    }
//                }
//            }
//        }
//        return tempArray;
//    }
//
//    public void affecterSeancesDeSemaine() {
//        ArrayList<Seance> tempArray = new ArrayList<Seance>();
//        listSeancesSelectionnees = new ArrayList<Seance>();
//        for (Seance s : listSeances) {
//            if (s.getNumeroSemaine() == numeroSemaineSelected) {
//                tempArray.add(s);
//                System.out.println("hi : " + s.getNumeroSemaine());
//            }
//        }
//        if (!tempArray.isEmpty()) {
//            listSeancesSelectionnees = tempArray;
//        }
//    }
//
//    public void montrerVueEnGrille() {
//        System.out.println("grille");
//        String[][] data = new String[84][100];
//        String[] horairesPossibles = new String[]{"08:30-10:00", "10:15-11:45", "12:00-13:30", "13:45-15:15", "15:30-17:00", "17:15-18:45", "19:00-20:30"};
//        for (int i = 0; i < 7; i++) {
//            data[i][0] = horairesPossibles[i];
//        }
//
//        int g = 0;
//        int colinc = 1;
//        String jour = "Lundi";
//
//        // Vue en grille
//        while (g < listSeancesSelectionnees.size()) {
//            //System.out.println("id: " + g);
//            if (jour.equals(getJourDeLaSemaine(listSeancesSelectionnees.get(g).getDate()))) {
//                for (int i = 0; i < 7; i++) {
//                    if ((listSeancesSelectionnees.get(g).getDebutHeure() + "-" + listSeancesSelectionnees.get(g).getFinHeure()).equals(data[i][0])) {
//                        data[i][colinc] = listSeancesSelectionnees.get(g).stringify();
//                    }
//                }
//                g++;
//            } else {
//                colinc++;
//                jour = getJourDeLaSemaine(listSeancesSelectionnees.get(g).getDate());
//            }
//        }
//
//        DefaultTableModel dtm = new DefaultTableModel(
//                data,
//                new String[]{
//                    " ", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"
//                }
//        );
//        ve.changeAVueEnGrille(dtm);
//        ve.setVisible(true);
//    }
//
//    public void montrerVueEnListe() {
//        String[][] data2 = new String[listSeancesSelectionnees.size()][1];
//        for (int i = 0; i < listSeancesSelectionnees.size(); i++) {
//            data2[i][0] = getJourDeLaSemaine(listSeancesSelectionnees.get(i).getDate()) + "     " + listSeancesSelectionnees.get(i).stringify();
//        }
//
//        DefaultTableModel dtm2 = new DefaultTableModel(
//                data2,
//                new String[]{
//                    " "
//                }
//        );
//        ve.changeAVueEnListe(dtm2);
//        ve.setVisible(true);
//    }
//
//    public void montrerEDT() {
//        if (ve.getJComboBoxSelectionVue().getSelectedItem().toString().equals("en grille")) {
//            montrerVueEnGrille();
//        } else {
//            montrerVueEnListe();
//        }
//    }
//
//    public ArrayList<Seance> filtrerParEnseignant(String nomEnseignant) {
//        ArrayList<Seance> tempArray = new ArrayList<Seance>();
//        for (int i = 0; i < listSeancesSelectionnees.size(); i++) {
//            for (int j = 0; j < listSeancesSelectionnees.get(i).getListeEnseignants().size(); j++) {
//                for (Enseignant e : listSeancesSelectionnees.get(i).getListeEnseignants()) {
//                    if (e.getNom().equalsIgnoreCase(nomEnseignant)) {
//                        tempArray.add(listSeancesSelectionnees.get(i));
//                    }
//                }
//            }
//        }
////        if (!tempArray.isEmpty()) {
////            listSeancesSelectionnees = tempArray;
////        }
//        return tempArray;
//    }
//
//    public ArrayList<Seance> filtrerParMatiere(String nomMatiere) {
//        ArrayList<Seance> tempArray = new ArrayList<Seance>();
//        for (int i = 0; i < listSeancesSelectionnees.size(); i++) {
//            if (listSeancesSelectionnees.get(i).getCoursSeance().getNomCours().equalsIgnoreCase(nomMatiere)) {
//                tempArray.add(listSeancesSelectionnees.get(i));
//            }
//        }
//        return tempArray;
//    }
//
//    public ArrayList<Enseignant> getListeEnseignants() {
//        ArrayList<Enseignant> tempArray = new ArrayList<Enseignant>();
//        for (int i = 0; i < listSeances.size(); i++) {
//            for (int j = 0; j < listSeances.get(i).getListeEnseignants().size(); j++) {
//                for (Enseignant e : listSeances.get(i).getListeEnseignants()) {
//                    tempArray.add(e);
//                }
//            }
//        }
//        return tempArray;
//    }
//
//    public ArrayList<Cours> getListeCours() {
//        ArrayList<Cours> tempArray = new ArrayList<Cours>();
//        for (Seance e : listSeances) {
//            tempArray.add(e.getCoursSeance());
//        }
//        return tempArray;
//    }
//
//    public ArrayList<String> getNomAdmins() {
//        ArrayList<String> tempArray = new ArrayList<String>();
//        getListeEnseignants().forEach(admin -> tempArray.add(admin.getNom()));
//        List<String> tempArray2 = tempArray.stream().distinct().collect(Collectors.toList());
//        ArrayList<String> tempArray3 = new ArrayList<String>();
//        tempArray2.forEach(s -> tempArray3.add(s));
//        return tempArray3;
//    }
//
//    public ArrayList<String> getNomCours() {
//        ArrayList<String> tempArray = new ArrayList<String>();
//        getListeCours().forEach(cours -> tempArray.add(cours.getNomCours()));
//        List<String> tempArray2 = tempArray.stream().distinct().collect(Collectors.toList());
//        ArrayList<String> tempArray3 = new ArrayList<String>();
//        tempArray2.forEach(s -> tempArray3.add(s));
//        return tempArray3;
//    }
//
//    //    public void affecterEnseignantASeance() {
////
////    }
////
////    public void affecterGroupeASeance() {
////
////    }
////
////    public void modifierNomCoursSeance() {
////
////    }
////
////    public void modifierTypeCoursSeance() {
////
////    }
////
////    affecterSalleASeance() {
////
////    }
////
////    changerHeureSeance() {
////
////    }
//    public void ajouterSeance() {
//
//    }
////
////    ajouterEnseignant() {
////
////    }
////
////    ajouterGroupeASeance{
////
////}
////
////    changerEtatSeance() {
////
////}
////
////    remplacerEnseignantASeance(){
////}
////
////    enleverGroupeDeSeance() {
////
////}
////
//
//    public static void main(String[] args) {
//        //test admin
//        UserDAO dao = new UserDAO();
//        User m = new User();
//        m = dao.chercher(1);
//        AdminVue v = new AdminVue("Admin Vue");
//        adEDTControleur controler = new adEDTControleur(m, v);
//        controler.control();
//    }
//}
