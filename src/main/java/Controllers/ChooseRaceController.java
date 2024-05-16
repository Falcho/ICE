package Controllers;

import Models.CharacterSheet;
import Models.Race;
import Views.ChooseRaceView;

import java.util.Map;

public class ChooseRaceController {
    private final ChooseRaceView view;
    private final CharacterSheet model;

    public ChooseRaceController(ChooseRaceView view, CharacterSheet model) {
        this.view = view;
        this.model = model;

        view.dropDownSelection(e -> {
            Race choice = view.getChosenRace();
            view.setDescription(choice.getDescription());
            view.setTAndFlawDescription(choice.getTAndFlawDescription());
            String [][] sizeList = choice.sizeTable();
            view.setSizeTable(sizeList);
            String [][] statBonusList = choice.statBonusTable();
            view.setStatsBonusTable(statBonusList);
            String [][] resistancesList = choice.resistanceTable();
            view.setResistanceTable(resistancesList);
            String [][] healthAndDevList = choice.healthAndDevTable();
            view.setHealthAndDevTable(healthAndDevList);

        });

    }

    private boolean validate(){
        return view.getChosenRace()!=null;
    }

    private void saveDataToModel(Race race) {
        model.setRace(race);
    }

    public boolean validateAndSave() {
        Race selectedRace = view.getChosenRace();
        if (validate()) {
            saveDataToModel(selectedRace);
            System.out.println("Selected Race: " + selectedRace.getName());
            return true;
        }
        return false;

    }
}
