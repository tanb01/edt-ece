package emploidutempsece;

import javax.swing.JFrame;
import dao.*;
import modele.*;
import java.util.*;
import java.util.stream.Collectors;


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
public class HeuresReporting extends JFrame {
    
    private static final long serialVersionUID = 1L;

    /**
     * Module SallesReporting pour les heures de cours
     * 
     * @param applicationTitle
     * @param chartTitle
     */
    public HeuresReporting(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        // On crée la dataset pour les heures de cours
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

    /**
     * Dataset du diagramme 2D et 3D pour les Heures
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
     *
     * @param args
     */
    public static void main(String[] args) {

        HeuresReporting demo = new HeuresReporting("Heures de cours", "Nombres d'heures par cours :");
        demo.pack();
        demo.setVisible(true);

    }
}
