package Views;

import Controllers.CharacterSheetController;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    // Card layout for switching view
    private CardLayout cardLayout;

    public MainFrame() {
        super("Java Swing MVC");
        cardLayout = new CardLayout();

        CreateStatsView statsView = new CreateStatsView();
        // sets our layout as a card layout
        setLayout(cardLayout);

        // initialize user controller
        //new CharacterSheetController(statsView);

        // adds view to card layout with unique constraints
        add(statsView, "myView");
        cardLayout.show(this.getContentPane(), "myView");
        // switch view according to its constraints on click

        // icon for our application
        //ImageIcon imageIcon = new ImageIcon("data/appicon.png");
        //setIconImage(imageIcon.getImage());
        // frame width & height
        int FRAME_WIDTH = 1200;
        int FRAME_HEIGHT = 700;
        // size of our application frame
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
