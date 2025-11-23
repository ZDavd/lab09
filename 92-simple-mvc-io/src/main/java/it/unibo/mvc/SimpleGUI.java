package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public class SimpleGUI {

    private final JFrame frame = new JFrame();
    /**
     * Main panel.
     */
    private final JPanel customPanel = new JPanel();

    /**
     * @param controller the application controller
     */
    public SimpleGUI(final Controller controller) {
        final JTextArea textArea = new JTextArea();
        final JButton button = new JButton("Save");

        customPanel.setLayout(new BorderLayout());
        customPanel.add(textArea, BorderLayout.CENTER);
        customPanel.add(button, BorderLayout.SOUTH);

        button.addActionListener(l -> {
            try {
                controller.writeString(textArea.getText());
            } catch (final IOException e) {
                JOptionPane.showMessageDialog(frame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.add(customPanel);
        frame.pack();
        frame.setLocationByPlatform(true);

        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int) screen.getWidth() / 2, (int) screen.getHeight() / 2);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * @return the custom panel
     */
    protected final JPanel getCustomPanel() {
        return customPanel;
    }

    /**
     * @return the frame
     */
    protected final JFrame getFrame() {
        return frame;
    }

    /**
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        new SimpleGUI(new Controller());
    }

}
