package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();

    private SimpleGUI(final Controller controller) {
        final JPanel panel = new JPanel();
        final JPanel buttonPanel = new JPanel();
        final JTextField textField = new JTextField();
        final JTextArea textArea = new JTextArea();
        final JButton printButton = new JButton("Print");
        final JButton historyButton = new JButton("Show history");

        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.add(printButton);
        buttonPanel.add(historyButton);

        panel.setLayout(new BorderLayout());
        panel.add(textField, BorderLayout.NORTH);
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        printButton.addActionListener(l -> {
            controller.setNextString(textField.getText());
            controller.printString();
        });
        historyButton.addActionListener(l -> textArea.setText(controller.getHistory().toString()));

        final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int) dimension.getWidth() / 2, (int) dimension.getHeight() / 2);

        frame.add(panel);
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Start the GUI.
     */
    public void start() {
        frame.setVisible(true);
    }

    /**
     * Main method.
     * 
     * @param args unused
     */
    public static void main(final String[] args) {
        final SimpleGUI gui = new SimpleGUI(new SimpleController());
        gui.start();
    }
}
