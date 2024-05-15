package Controllers;

import Models.CharacterSheet;
import Models.Culture;
import Views.ChooseCultureView;

import java.util.Map;

public class ChooseCultureController {
    private final ChooseCultureView view;
    private final CharacterSheet model;

    public ChooseCultureController(ChooseCultureView view, CharacterSheet model) {
        this.view = view;
        this.model = model;

        view.dropDownSelection(e -> {
            Culture choice = view.getChosenCulture();
            view.setDescription(choice.getDescription());
            view.setCrafts(choice.getCrafts().toString());
            view.setVocations(choice.getVocations().toString());
            String [][] skillList = new String[choice.getSkills().size()][2];
            int i = 0;
            for(Map.Entry<String, Integer> entry : choice.getSkills().entrySet()) {
                skillList[i][0] = entry.getKey();
                skillList[i][1] = String.valueOf(entry.getValue());
                i++;
            }

            view.setSkillTable(skillList);
        });
    }

    private boolean validate() {
        return view.getChosenCulture()!=null;

    }

    private void saveDataToModel(Culture culture) {
        model.setCulture(culture);

    }

    public boolean validateAndSave() {
        Culture selectedCulture = view.getChosenCulture();
        if (validate()) {
            saveDataToModel(selectedCulture);
            System.out.println("Selected Culture: " + selectedCulture.getName());
            return true;
        }
        return false;
    }
}
