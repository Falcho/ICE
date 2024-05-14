package Controllers;

import Models.CharacterSheet;
import Views.CreateNewCharView;
import Views.MainFrame;

public class CreateNewCharController {
    private CreateNewCharView view;
    private CharacterSheet model;

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
            model.setName(name);
            System.out.println("Character name: "+ name);
            return true;
        }
        return false;
    }

}
