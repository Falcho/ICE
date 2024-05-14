package Controllers;

import Models.CharacterSheet;
import Views.CreateNewCharView;

public class CreateNewCharController {
    private final CreateNewCharView view;
    private final CharacterSheet model;

    public CreateNewCharController(CreateNewCharView view, CharacterSheet model) {
        this.view = view;
        this.model = model;
    }

    private boolean validate(String name) {
        return !name.isEmpty();
    }

    private void saveDataToModel(String name) {
        model.setName(name);
    }

    public boolean validateAndSave() {
        String name = view.getNameField();
        if (validate(name)) {
            saveDataToModel(name);
            System.out.println("Character name: "+ name);
            return true;
        }
        return false;
    }

}
