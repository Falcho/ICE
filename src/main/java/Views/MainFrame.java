package Views;

import Controllers.CharacterSheetController;
import Controllers.CreateNewCharController;
import Models.CharacterSheet;
import Models.Rules;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    // Card layout for switching view
    private final CardLayout cardLayout;

    public MainFrame() {
        super("Rolemaster Character Generator");
        cardLayout = new CardLayout();

        CreateNewCharView newCharView = new CreateNewCharView();
        CreateStatsView newStatsView = new CreateStatsView();
        ChooseProfessionView chooseProfessionView = new ChooseProfessionView();
        TalentsAndFlawsView talentsAndFlawsView = new TalentsAndFlawsView(Rules.getTalentsAndFlaws());
        // sets our layout as a card layout
        setLayout(cardLayout);

        // initialize user controller
        CharacterSheet model = new CharacterSheet();
        CreateNewCharController newCharController = new CreateNewCharController(newCharView, model);
        //new CharacterSheetController(newStatsView);


        // adds view to card layout with unique constraints
        add(newCharView, "myView");
        add(chooseProfessionView, "professionView");
        add(newStatsView, "newStats");
        add(talentsAndFlawsView, "talentsAndFlaws");
        cardLayout.show(this.getContentPane(), "myView");
        // switch view according to its constraints on click
        newCharView.saveAndContinue(e -> {
            if (newCharController.validateAndSave()) {
                cardLayout.show(this.getContentPane(), "professionView");
            }
            else {
                newCharView.reset(true);
            }
        });
        chooseProfessionView.returnToCharacterName(e -> {
            newCharView.reset(true);
            cardLayout.show(this.getContentPane(), "myView");
        });


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

    //public void changeView();
}