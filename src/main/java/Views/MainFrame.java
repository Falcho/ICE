package Views;

import Controllers.CreateNewCharController;
import Controllers.CreateStatsController;
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
        ChooseProfessionView chooseProfessionView = new ChooseProfessionView();
        //JPanel chooseRaceView = new ChooseRaceView();
        ChooseCultureView chooseCultureView = new ChooseCultureView(Rules.getCultures());
        CreateStatsView newStatsView = new CreateStatsView();
        TalentsAndFlawsView talentsAndFlawsView = new TalentsAndFlawsView(Rules.getTalentsAndFlaws());
        // sets our layout as a card layout
        setLayout(cardLayout);

        // initialize user controller
        CharacterSheet model = new CharacterSheet();
        CreateNewCharController newCharController = new CreateNewCharController(newCharView, model);
        CreateStatsController createStatsController = new CreateStatsController(newStatsView, model);
        //new CharacterSheetController(newStatsView);


        // adds view to card layout with unique constraints
        add(newCharView, "chooseName");
        add(chooseProfessionView, "professionView");
        //add(chooseRaceView, "chooseRace");
        add(chooseCultureView, "cultureView");
        add(talentsAndFlawsView, "talentsAndFlaws");
        add(newStatsView, "newStats");
        cardLayout.show(this.getContentPane(), "cultureView");
        // switch view according to its constraints on click
        newCharView.continueButtonClick(e -> {
            if (newCharController.validateAndSave()) {
                cardLayout.show(this.getContentPane(), "professionView");
            }
            else {
                newCharView.reset(true);
            }
        });
        chooseProfessionView.previousButtonClick(e -> {
            cardLayout.show(this.getContentPane(), "chooseName");
        });
        chooseProfessionView.continueButtonClick(e -> {
            //Validate and save
            cardLayout.show(this.getContentPane(), "talentsAndFlaws");
        });
        //talentsAndFlawsView.
        newStatsView.previousButtonClick(e -> {
            cardLayout.show(this.getContentPane(), "talentsAndFlaws");
        });
        newStatsView.continueButtonClick(e -> {
            cardLayout.show(this.getContentPane(), "");
        });
        //talentsAndFlawsView.


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
