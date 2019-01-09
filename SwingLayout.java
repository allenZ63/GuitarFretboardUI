package NoteInput;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.util.Arrays;
import javafx.stage.WindowEvent;
import javax.swing.*;

public class SwingLayout {

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JLabel msglabel;

    public SwingLayout() {
        prepareGUI();
    }

    public static void main(String[] args) {
        SwingLayout swingLayoutDemo = new SwingLayout();
        swingLayoutDemo.showGridLayoutDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Guitar Fretboard");
        mainFrame.setSize(5500, 5500);
        mainFrame.setLayout(new GridLayout(1, 1));

        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3, 1));
        controlPanel.setSize(5000,5000);
        controlPanel.setBackground(Color.WHITE);

  //      mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
  //      mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
        mainFrame.setBackground(Color.BLUE);
    }

    private void showGridLayoutDemo() {
        NoteScript c = new NoteScript();
        headerLabel.setText("Notes");

        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        panel.setSize(4000, 4000);
        GridLayout layout = new GridLayout(6, 12);
        layout.setHgap(10);
        layout.setVgap(10);

        panel.setLayout(layout);
        for (int i = 0; i < c.getArray()[i].length; i++) { //runs through columns
            for (int j = 0; j < c.getArray().length; j++) { //runs through rows 
                JLabel label = new JLabel("", JLabel.CENTER); //creates object instance
                for(int k = 0; k < c.getCheck().size(); k++){ //checks key elements with all elements
                    label.setFont(new Font("Arial", Font.PLAIN, 14)); //resets font
                    if(c.getArray()[j][i].equals(c.getCheck().get(k))){ //if current element is in key, bold
                        label.setFont(new Font("Arial", Font.BOLD, 20));
                        label.setText(c.getArray()[j][i]);
                        break;
                      } else { //if current element is not in key, do not bold
                           label.setText(c.getArray()[j][i]);
                        }
                }
                label.setMinimumSize(new Dimension(50, 50));
                label.setOpaque(true);
                label.setBackground(Color.GRAY);
                label.setForeground(Color.WHITE);
                panel.add(label);
            }
        }
        controlPanel.add(new JPanel());
        controlPanel.add(panel);
        mainFrame.setVisible(true);
    }
}
