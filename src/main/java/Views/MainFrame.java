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

        StartMenuView menuView= new StartMenuView();
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
        add(menuView,"menuView");
        add(newCharView, "chooseName");
        add(chooseProfessionView, "professionView");
        //add(chooseRaceView, "chooseRace");
        add(chooseCultureView, "cultureView");
        add(talentsAndFlawsView, "talentsAndFlaws");
        add(generateStatsView, "generateStats");
        //add(createBackgroundView, "createBackground");
        //add(characterSheetView, "characterSheet");
        cardLayout.show(this.getContentPane(), "menuView");
        // switch view according to its constraints on click
        menuView.createNewClick(e -> {
            changeView("chooseName");
        });
        newCharView.continueButtonClick(e -> {
            if (newCharController.validateAndSave()) {
                changeView("professionView");
            }
            else {
                newCharView.reset(true);
            }
        });

        chooseProfessionView.previousButtonClick(e -> {
            changeView("chooseName");
        });
        chooseProfessionView.continueButtonClick(e -> {
            //if (chooseProfessionController.validateAndSave()) {
                changeView("cultureView");
            //}
        });

        /*chooseRaceView.previousButtonClick(e -> {
            changeView("professionView");
        });
        chooseRaceView.continueButtonClick(e -> {
            if (chooseRaceController.validateAndSave()) {
                changeView("cultureView");
            }
        });*/

        chooseCultureView.previousButtonClick(e -> {
            changeView("professionView");
        });
        chooseCultureView.continueButtonClick(e -> {
            if (cultureController.validateAndSave()) {
                changeView("talentsAndFlaws");
            }
        });

        talentsAndFlawsView.previousButtonClick(e -> {
            changeView("cultureView");
        });
        talentsAndFlawsView.continueButtonClick(e -> {
            talentsAndFlawsView.saveTalents();
            changeView("generateStats");
        });

        generateStatsView.previousButtonClick(e -> {
            changeView("talentsAndFlaws");
        });
        generateStatsView.continueButtonClick(e -> {
            if (createStatsController.validateAndSave())
                changeView("createBackground");
        });

        /*createBackgroundView.previousButtonClick(e -> {
            changeView("generateStats");
        });
        createBackgroundView.continueButtonClick(e -> {
            if (createBackgroundController.validateAndSave())
                changeView("characterSheet");
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

    public void changeView(String viewName) {
        cardLayout.show(this.getContentPane(), viewName);
    }
}
