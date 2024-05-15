package Controllers;

import Models.CharacterSheet;
import Models.Culture;
import Views.ChooseCultureView;

public class ChooseCultureController {
    private final ChooseCultureView view;
    private final CharacterSheet model;

    public ChooseCultureController(ChooseCultureView view, CharacterSheet model) {
        this.view = view;
        this.model = model;

        view.dropDownSelection(e -> {
            Culture choice = view.getChosenCulture();
            view.setDescription(choice.getDescription());
        });
    }
}
