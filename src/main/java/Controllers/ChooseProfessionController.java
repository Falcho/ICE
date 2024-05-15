package Controllers;

import Models.CharacterSheet;
import Models.Profession;
import Views.ChooseProfessionView;
import Views.CreateNewCharView;

public class ChooseProfessionController {
    private final CharacterSheet model;
    private final ChooseProfessionView view;

    public ChooseProfessionController(CharacterSheet model, ChooseProfessionView view) {
        this.model = model;
        this.view = view;

        view.returnToCharacterName(e -> {

        });
    }
    private boolean validate(ChooseProfessionView view) {
        if(view.isProfessionSelected());
        return true;
    }
    private void saveDataToModel(Profession profession) {
        model.setProfession(profession);
    }
}
