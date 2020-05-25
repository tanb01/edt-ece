package vue;

import javax.swing.JFrame;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class Main extends JFrame {

    public Main() {
        GridsCanvas xyz = new GridsCanvas(200, 200, 6, 7);
        add(xyz);
        pack();
    }

    public static void main(String[] a) {
        JFrame frame = new JFrame();
        GridsCanvas xyz = new GridsCanvas(200, 200, 6, 7);
        frame.add(xyz);
        frame.pack();
        frame.setVisible(true);
    }
}
