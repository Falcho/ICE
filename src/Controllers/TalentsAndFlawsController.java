package Controllers;

import Models.CharacterSheet;
import Models.Rules;
import Models.TalentsAndFlaws;
import Views.TalentsAndFlawsView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TalentsAndFlawsController {
    private final CharacterSheet model;
    private final TalentsAndFlawsView view;
    private final Rules rules;

    public TalentsAndFlawsController(CharacterSheet model, TalentsAndFlawsView view) {
        this.model = model;
        this.view = view;
        this.rules = new Rules();
    }

    public void addTalentsFromRules() {
        Map<String, String> availableTalents = Rules.getTalentsAndFlaws();
        //view.addTalent(availableTalents);

    }
}
