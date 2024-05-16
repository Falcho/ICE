package Controllers;

import Models.CharacterSheet;
import Views.CreateStatsView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateStatsController implements RmController {
    CharacterSheet model;
    CreateStatsView view;
    public CreateStatsController(CreateStatsView view, CharacterSheet model) {
        this.model = model;
        this.view = view;

        view.rollStatsForMeButtonClick(e -> view.setStats(generateStats()));
    }

    private boolean validate() {
        List<int[]> data = view.getStats();
        boolean valid = true;
        for (int[] stat : data){
            valid = valid && stat[0] > 10 && stat[1] > 10 && stat[0] < 100 && stat[1] < 100;
        }
        return valid;
    }

    private void saveDataToModel(List<int[]> data) {
        model.setStats(data);
    }

    public boolean validateAndSave() {
        //get data from view
        List<int[]> data = view.getStats();

        if (validate()) {
            saveDataToModel(data);
            System.out.println("Stats saved" + data);
            return true;
        }
        return false;
    }

    private int[] generateStat() {
        int[] stat = new int[3];
        Random random= new Random();
        for(int i = 0; i<stat.length;i++)
            stat[i]=random.nextInt(11,101);
            //Use Random to generate three random numbers between 11 and 100,
            // and insert them into the stat array

        return stat;
    }

    private List<int[]> generateStats() {
        List<int[]> stats = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            stats.add(generateStat());
        }
        return stats;
    }

}
