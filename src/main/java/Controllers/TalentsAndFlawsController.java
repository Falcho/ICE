package Controllers;

import Models.CharacterSheet;
import Models.Rules;
import Models.TalentsAndFlaws;
import Views.TalentsAndFlawsView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TalentsAndFlawsController implements RmController {
    private final CharacterSheet model;
    private final TalentsAndFlawsView view;
    private final Rules rules;

    public TalentsAndFlawsController(CharacterSheet model, TalentsAndFlawsView view) {
        this.model = model;
        this.view = view;
        this.rules = new Rules();
    }

    private boolean validate() {
        return true;
    }

    private void saveDataToModel() {}

    @Override
    public boolean validateAndSave() {
        return false;
    }
}
