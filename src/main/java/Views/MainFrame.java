package Views;

import Controllers.ChooseCultureController;
import Controllers.ChooseProfessionController;
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
        ChooseProfessionView chooseProfessionView = new ChooseProfessionView(Rules.getProfessionList("data/professions/professions.json"));
        //ChooseRaceView chooseRaceView = new ChooseRaceView();
        ChooseCultureView chooseCultureView = new ChooseCultureView(Rules.getCultures());
        TalentsAndFlawsView talentsAndFlawsView = new TalentsAndFlawsView(Rules.getTalentsAndFlaws());
        CreateStatsView generateStatsView = new CreateStatsView();
        //CreateBackgroundView createBackgroundView = new CreateBackgroundView();
        //CharacterSheetView characterSheetView = new CharacterSheetView();
        // sets our layout as a card layout
        setLayout(cardLayout);

        // initialize user controller
        CharacterSheet model = new CharacterSheet();
        CreateNewCharController newCharController = new CreateNewCharController(newCharView, model);
        ChooseProfessionController chooseProfessionController = new ChooseProfessionController(chooseProfessionView, model);
        CreateStatsController createStatsController = new CreateStatsController(generateStatsView, model);
        ChooseCultureController cultureController = new ChooseCultureController(chooseCultureView, model);
        //new CharacterSheetController(generateStatsView);


        // adds view to card layout with unique constraints
        add(newCharView, "chooseName");
        add(chooseProfessionView, "professionView");
        //add(chooseRaceView, "chooseRace");
        add(chooseCultureView, "cultureView");
        add(talentsAndFlawsView, "talentsAndFlaws");
        add(generateStatsView, "generateStats");
        //add(createBackgroundView, "createBackground");
        //add(characterSheetView, "characterSheet");
        cardLayout.show(this.getContentPane(), "chooseName");
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
            //if (chooseProfessionController.validateAndSave()) {
                cardLayout.show(this.getContentPane(), "talentsAndFlaws");
            //}
        });

        /*chooseRaceView.previousButtonClick(e -> {
            cardLayout.show(this.getContentPane(), "professionView");
        });
        chooseRaceView.continueButtonClick(e -> {
            if (chooseRaceController.validateAndSave()) {
                cardLayout.show(this.getContentPane(), "talentsAndFlaws");
            }
        });*/

        talentsAndFlawsView.previousButtonClick(e -> {
            cardLayout.show(this.getContentPane(), "chooseRace");
        });
        talentsAndFlawsView.continueButtonClick(e -> {
            talentsAndFlawsView.saveTalents();
            cardLayout.show(this.getContentPane(), "generateStats");
        });

        generateStatsView.previousButtonClick(e -> {
            cardLayout.show(this.getContentPane(), "talentsAndFlaws");
        });
        generateStatsView.continueButtonClick(e -> {
            cardLayout.show(this.getContentPane(), "createBackground");
        });

        /*generateStatsView.previousButtonClick(e -> {
            cardLayout.show(this.getContentPane(), "generateStats");
        });
        generateStatsView.continueButtonClick(e -> {
            cardLayout.show(this.getContentPane(), "characterSheet");
        });*/



        // icon for our application
        ImageIcon imageIcon = new ImageIcon("data/apple-touch-icon.png");
        setIconImage(imageIcon.getImage());
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
