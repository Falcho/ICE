package Views;

import javax.swing.*;
import java.awt.*;

public class CreateStartMenuView extends JPanel {

    private JButton button1;
    private JButton button2;

    public CreateStartMenuView() {
        button1 = new JButton("Create new Character");
        button2 = new JButton("Choose existing character");

        //this.add(createTopPanel(), BorderLayout.CENTER);
        //this.add(createMiddlePanel(), BorderLayout.CENTER);
        // this.add(createButtomPanel(),BorderLayout.SOUTH);

        setLayout(new BorderLayout()); // Main panel layout
        JPanel topPanel = new JPanel(); // Empty panel for spacing
        add(topPanel, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel(); // Nested panel for buttons
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));// Y_AXIS for vertical stacking

        buttonPanel.add(Box.createVerticalGlue()); // Add glue to push buttons to the top
        buttonPanel.add(button1);
        buttonPanel.add(Box.createVerticalStrut(10)); // Add some spacing between buttons
        buttonPanel.add(button2);
        buttonPanel.add(Box.createVerticalGlue()); // Add glue to push buttons to the bottom

        add(buttonPanel, BorderLayout.CENTER); // Add the button panel to the center

    }





    private JPanel createTopPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(button1);
        panel.add(button2);
        return panel;
    }

    private JPanel createButtonAboveEactOther(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(button1);
        panel.add(Box.createHorizontalStrut(10)); // Add some spacing between buttons
        panel.add(button2);
        return panel;
    }


    private JPanel createMiddlePanel() {

        JPanel buttonPanel = new JPanel(); // Nested panel for buttons
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); // Y_AXIS for vertical stacking
        //buttonPanel.add(Box.createVerticalGlue()); // Add glue to push buttons to the top
        buttonPanel.add(button1);
        buttonPanel.add(Box.createVerticalStrut(10)); // Add some spacing between buttons
        buttonPanel.add(button2);
        buttonPanel.add(Box.createVerticalGlue()); // Add glue to push buttons to the bottom

        return buttonPanel;
    }

}
