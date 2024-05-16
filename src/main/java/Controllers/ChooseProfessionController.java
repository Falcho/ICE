package Controllers;

import Models.CharacterSheet;
import Models.Profession;
import Views.ChooseProfessionView;
import Views.CreateNewCharView;

public class ChooseProfessionController implements RmController{
    private final CharacterSheet model;
    private final ChooseProfessionView view;

    public ChooseProfessionController(ChooseProfessionView view, CharacterSheet model) {
        this.model = model;
        this.view = view;

    }

    private boolean validate() {
        return view.isProfessionSelected();

    }

    private void saveDataToModel(Profession profession) {
        model.setProfession(profession);

    }

    public boolean validateAndSave() {
        Profession profession = view.getSelectedProfession();
        if (validate()) {
            saveDataToModel(profession);
            System.out.println("Selected Profession: " + profession.getName());
            return true;
        }
        return false;
    }
}
