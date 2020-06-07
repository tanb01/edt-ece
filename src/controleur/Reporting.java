package controleur;

import javax.swing.JFrame;
import dao.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import modele.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class Reporting extends JFrame {

    private static final long serialVersionUID = 1L;

    /**
     * Module Reporting pour l'effectif des groupes
     *
     * @param applicationTitle
     * @param chartTitle
     */
    public Reporting(String applicationTitle) {
        super(applicationTitle);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void reportingEffectifGroupesParPromo() {
        // On crée la dataset pour l'effectif
        PieDataset dataset = creationEffectifReportingDataset(); // Pour diagramme
        // On crée la chart grâce à la dataset
        JFreeChart chart = creationDiag3D(dataset, "Effectifs par groupe par promo"); // Pour un diagramme 3D
        // On met la chart dans un panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // Taille par défaut
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // On ajoute à l'application
        setContentPane(chartPanel);
    }

//    /**
//     * Module Reporting pour les heures de cours
//     * 
//     * @param applicationTitle
//     * @param chartTitle
//     */
    public void reportingHeuresDeSeancesParCours() {
        // On crée la dataset pour les heures de cours
        PieDataset dataset = creationHeuresReportingDataset(); // Pour diagramme
        // On crée la chart grâce à la dataset
        JFreeChart chart = creationDiag3D(dataset, "Nombres d'heures de seances par cours"); // Pour un diagramme 3D
        // On met la chart dans un panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // Taille par défaut
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // On ajoute à l'application
        setContentPane(chartPanel);
    }
//    /**
//     * Module Reporting pour la capacité des salles par sites
//     * 
//     * @param applicationTitle
//     * @param chartTitle 
//     */

    public void reportingCapaciteSallesParSiteHisto() {
        // On crée la dataset pour la SALLE
        DefaultCategoryDataset dataset = creationSallesReportingHistoDataset(); // Pour histogramme
        // On crée la chart grâce à la dataset
        JFreeChart chart = creationHisto(dataset, "Capacite"); // Pour un histogramme
        // On met la chart dans un panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // Taille par défaut
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // On ajoute à l'application
        setContentPane(chartPanel);
    }

    public void reportingTauxOccupationSallesHisto() {
        DefaultCategoryDataset dataset = creationTauxOccupationSallesReportingHistoDataset(); // Pour histogramme
        // On crée la chart grâce à la dataset
        JFreeChart chart = creationHisto(dataset, "Taux d'occupation"); // Pour un histogramme
        // On met la chart dans un panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // Taille par défaut
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // On ajoute à l'application
        setContentPane(chartPanel);
    }

    /**
     * Dataset du diagramme 2D et 3D pour les SALLES
     *
     * @return
     */
    private PieDataset creationSallesReportingDataset() {
        DefaultPieDataset result = new DefaultPieDataset();

        SiteDAO si = new SiteDAO();
        ArrayList<Site> sites = new ArrayList<Site>();
        sites = si.chercherTousLesSites();

        for (Salle salle : sites.get(2).getSalles()) {
            result.setValue(salle.getNomSalle(), salle.getCapacite());
        }
        return result;
    }

    /**
     * Dataset de l'histogramme pour les SALLES
     *
     * @return
     */
    private DefaultCategoryDataset creationSallesReportingHistoDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        SiteDAO si = new SiteDAO();
        ArrayList<Site> sites = new ArrayList<Site>();
        sites = si.chercherTousLesSites();

        for (Salle salle : sites.get(2).getSalles()) {
            dataset.addValue(salle.getCapacite(), sites.get(2).getNomSite(), salle.getNomSalle());
        }
        for (Salle salle : sites.get(3).getSalles()) {
            dataset.addValue(salle.getCapacite(), sites.get(3).getNomSite(), salle.getNomSalle());
        }
        return dataset;
    }

    private DefaultCategoryDataset creationTauxOccupationSallesReportingHistoDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        SiteDAO si = new SiteDAO();
        ArrayList<Site> sites = new ArrayList<Site>();
        
        sites = si.chercherTousLesSites();
        for (Site s : sites) {
            for (Salle salle : s.getSalles()) {
                dataset.addValue(salle.getCapacite(), s.getNomSite(), salle.getNomSalle());
            }
        }
//        for (Salle salle : sites.get(3).getSalles()) {
//            dataset.addValue(salle.getCapacite(), sites.get(3).getNomSite(), salle.getNomSalle());
//        }
        return dataset;
    }

    /**
     * Dataset du diagramme 2D et 3D pour les Heures
     *
     * @return
     */
    private PieDataset creationHeuresReportingDataset() {
        DefaultPieDataset result = new DefaultPieDataset();

        SeanceDAO se = new SeanceDAO();
        ArrayList<String> seances = new ArrayList<String>();
        seances = se.chercherNomsDesCoursDesSeancesParGroupeId(31);//Pour le groupe 31 Gr09 Ing3
        List<String> tempArray2 = seances.stream().distinct().collect(Collectors.toList());
        ArrayList<String> tempArray3 = new ArrayList<String>();
        tempArray2.forEach(s -> tempArray3.add(s));

        int timeCounter = 0;
        int nombresSeances = seances.size();
        int nombresMinTotal = (90 * nombresSeances);
        int nombresHeuresSeancesTotal = nombresMinTotal / 60;
        nombresMinTotal %= 60;
        for (int i = 0; i < tempArray3.size(); i++) {
            timeCounter = 0;
            for (int j = 0; j < seances.size(); j++) {
                if (tempArray3.get(i).equals(seances.get(j))) {
                    timeCounter++;
                }
            }
            nombresMinTotal = (90 * timeCounter);
            nombresHeuresSeancesTotal = nombresMinTotal / 60;
            nombresMinTotal %= 60;
            result.setValue(tempArray3.get(i), nombresHeuresSeancesTotal);
        }
        return result;
    }

    /**
     * Dataset du diagramme 2D et 3D pour les Heures
     *
     * @return
     */
    private PieDataset creationEffectifReportingDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();

        PromotionDAO pr = new PromotionDAO();
        ArrayList<Promotion> promos = new ArrayList<Promotion>();
        promos.add(pr.chercher(3));

        for (Groupe groupe : promos.get(0).getGroupes()) {
            dataset.setValue(groupe.getNomGroupe(), groupe.getEffectifGroupe());
        }

        return dataset;
    }

    /**
     * Création du diagramme 3D
     *
     * @param dataset
     * @param title
     * @return
     */
    private JFreeChart creationDiag3D(PieDataset dataset, String title) {

        JFreeChart pieChart3D = ChartFactory.createPieChart3D(
                title, // chart title
                dataset, // data
                true, // include legend
                true,
                false
        );

        PiePlot3D plot = (PiePlot3D) pieChart3D.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return pieChart3D;
    }

    /**
     * Création de diagramme 2D
     *
     * @param dataset
     * @param title
     * @return
     */
    private JFreeChart creationDiag(PieDataset dataset, String title) {
        JFreeChart pieChart = ChartFactory.createPieChart(
                title, // chart title
                dataset, // data
                true, // include legend
                true,
                false
        );
        return pieChart;
    }

    /**
     * Création de l'histogramme
     *
     * @param dataset
     * @param title
     * @return
     */
    private JFreeChart creationHisto(DefaultCategoryDataset dataset, String title) {

        final JFreeChart barChart = ChartFactory.createBarChart(title, "Salles", "Capacité",
                dataset, PlotOrientation.VERTICAL, true, true, false);

        final ChartPanel cPanel = new ChartPanel(barChart);
        return barChart;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
//        // Main pour la capacité des salles par sites
//        Reporting demo = new Reporting("Capacité des salles", "Salles :");
//        demo.pack();
//        demo.setVisible(true);

//        // Main pour les heures de cours
//        Reporting demo = new Reporting("Heures de cours", "Nombres d'heures par cours :");
//        demo.pack();
//        demo.setVisible(true);
        // Main pour les effectifs des groupes
        Reporting demo = new Reporting("Reporting");
        //demo.reportingEffectifGroupesParPromo();
        //demo.reportingCapaciteSallesParSiteHisto();
        demo.reportingHeuresDeSeancesParCours();
        demo.pack();
        demo.setVisible(true);
    }
}
