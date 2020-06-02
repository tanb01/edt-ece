package emploidutempsece;

import javax.swing.JFrame;
import dao.SalleDAO;
import dao.SiteDAO;
import java.util.ArrayList;
import modele.Salle;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class PieChart extends JFrame {

    private static final long serialVersionUID = 1L;

    /**
     * 
     * @param applicationTitle
     * @param chartTitle 
     */
    public PieChart(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        // On crée la dataset
        PieDataset dataset = creationPieDataset();
        // On crée la chart grâce à la dataset
        JFreeChart chart = creationDiag3D(dataset, chartTitle);
        // On met la chart dans un panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // Taille par défaut
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // On ajoute à l'application
        setContentPane(chartPanel);
    }

    /**
     * Créer un exemple de dataset
     */
    private PieDataset creationPieDataset() {
        DefaultPieDataset result = new DefaultPieDataset();
//        SiteDAO si = new SiteDAO();
//        ArrayList<Salle> listeSalles = new ArrayList<Salle>();
//        listeSalles = si.chercher(WIDTH)
        SalleDAO sa = new SalleDAO();
        Salle un = sa.chercher(1);
        Salle deux = sa.chercher(2);
        Salle trois = sa.chercher(3);
        Salle quatre = sa.chercher(4);
        Salle cinq = sa.chercher(5);
        Salle six = sa.chercher(6);
        Salle sept = sa.chercher(7);
        Salle huit = sa.chercher(8);
        Salle neuf = sa.chercher(9);
        Salle dix = sa.chercher(10);
        Salle onze = sa.chercher(11);
        Salle douze = sa.chercher(12);
        Salle treize = sa.chercher(13);
        Salle quatorze = sa.chercher(14);
        Salle quinze = sa.chercher(15);
        Salle seize = sa.chercher(16);
        Salle dixsept = sa.chercher(17);
        Salle dixhuit = sa.chercher(18);
        Salle dixneuf = sa.chercher(19);
        Salle vingt = sa.chercher(20);

        result.setValue(un.getNomSalle(), un.getCapacite());
        result.setValue(deux.getNomSalle(), deux.getCapacite());
        result.setValue(trois.getNomSalle(), trois.getCapacite());
        result.setValue(quatre.getNomSalle(), quatre.getCapacite());
        result.setValue(cinq.getNomSalle(), cinq.getCapacite());
        result.setValue(six.getNomSalle(), six.getCapacite());
        result.setValue(sept.getNomSalle(), sept.getCapacite());
        result.setValue(huit.getNomSalle(), huit.getCapacite());
        result.setValue(neuf.getNomSalle(), neuf.getCapacite());
        result.setValue(dix.getNomSalle(), dix.getCapacite());
        result.setValue(onze.getNomSalle(), onze.getCapacite());
        result.setValue(douze.getNomSalle(), douze.getCapacite());
        result.setValue(treize.getNomSalle(), treize.getCapacite());
        result.setValue(quatorze.getNomSalle(), quatorze.getCapacite());
        result.setValue(quinze.getNomSalle(), quinze.getCapacite());
        result.setValue(seize.getNomSalle(), seize.getCapacite());
        result.setValue(dixsept.getNomSalle(), dixsept.getCapacite());
        result.setValue(dixhuit.getNomSalle(), dixhuit.getCapacite());
        result.setValue(dixneuf.getNomSalle(), dixneuf.getCapacite());
        result.setValue(vingt.getNomSalle(), vingt.getCapacite());
        
        return result;
    }

    /**
     * Crée le diagramme 3D
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
     * Crée le diagramme 2D
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
}