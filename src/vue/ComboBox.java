package vue;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class ComboBox extends JFrame implements ActionListener {

    private String[] selection = {"null1", "null2"};
    JComboBox listeSelection = new JComboBox(selection);
    JLabel label = new JLabel();

    public ComboBox() {
        setLayout(new FlowLayout());
        setSize(400, 300);
        setTitle("ComboBox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        listeSelection.setSelectedIndex(0);
        listeSelection.addActionListener(this);
        add(listeSelection);
        add(label);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

    public static void main(String[] args) {
        ComboBox fr = new ComboBox();
        fr.setVisible(true);
    }

}
