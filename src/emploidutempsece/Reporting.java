package emploidutempsece;

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
import org.jfree.data.category.CategoryDataset;
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
     *
     * @param applicationTitle
     * @param chartTitle
     */
    //heures de cours
    public Reporting(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        // On crée la dataset pour la SALLE
        PieDataset dataset = creationHeuresReportingDataset(); // Pour diagramme
        // On crée la chart grâce à la dataset
        JFreeChart chart = creationDiag3D(dataset, chartTitle); // Pour un diagramme 3D
        // On met la chart dans un panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // Taille par défaut
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // On ajoute à l'application
        setContentPane(chartPanel);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
//capacite salle
//        public Reporting(String applicationTitle, String chartTitle) {
//        super(applicationTitle);
//        // On crée la dataset pour la SALLE
//        DefaultCategoryDataset dataset = creationSallesReportingHistoDataset(); // Pour histogramme
//        // On crée la chart grâce à la dataset
//        JFreeChart chart = creationHisto(dataset, chartTitle); // Pour un histogramme
//        // On met la chart dans un panel
//        ChartPanel chartPanel = new ChartPanel(chart);
//        // Taille par défaut
//        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
//        // On ajoute à l'application
//        setContentPane(chartPanel);
//          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

//    }
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

    /**
     * Dataset du diagramme 2D et 3D pour les SALLES
     *
     * @return
     */
    private PieDataset creationHeuresReportingDataset() {
        DefaultPieDataset result = new DefaultPieDataset();

        SeanceDAO se = new SeanceDAO();
        ArrayList<Seance> seances = new ArrayList<Seance>();
        seances = se.chercherSeancesParGroupeId(31);

        ArrayList<String> tempArray = new ArrayList<String>();
        seances.forEach(seance -> tempArray.add(seance.getCoursSeance().getNomCours()));
        List<String> tempArray2 = tempArray.stream().distinct().collect(Collectors.toList());
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
                if (tempArray3.get(i).equals(seances.get(j).getCoursSeance().getNomCours())) {
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
        Reporting demo = new Reporting("Capacité des salles", "Salles :");
        demo.pack();
        demo.setVisible(true);
    }
}
