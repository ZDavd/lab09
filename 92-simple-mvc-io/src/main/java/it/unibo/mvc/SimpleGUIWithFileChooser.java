package it.unibo.mvc;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** 
 * A very simple program using a graphical interface.
 */
public final class SimpleGUIWithFileChooser extends SimpleGUI {

    /**
     * @param controller the application controller
     */
    public SimpleGUIWithFileChooser(final Controller controller) {
        super(controller);

        final JPanel panel2 = new JPanel();
        final JTextField text = new JTextField();
        final JButton button = new JButton("Browse");

        panel2.setLayout(new BorderLayout());
        panel2.add(text, BorderLayout.CENTER);
        panel2.add(button, BorderLayout.LINE_END);

        text.setText(controller.getCurrentPath());
        text.setEditable(false);

        super.getCustomPanel().add(panel2, BorderLayout.NORTH);

        button.addActionListener(l -> {
            final JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(super.getFrame()) == JFileChooser.APPROVE_OPTION) {
                controller.setCurrentFile(fileChooser.getSelectedFile());
                text.setText(controller.getCurrentPath());
            } else {
                JOptionPane.showMessageDialog(super.getFrame(), "Error", "Error occurred", JOptionPane.ERROR_MESSAGE);
            }
        });

        super.getFrame().pack();
    }

    /**
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        new SimpleGUIWithFileChooser(new Controller());
    }
}
