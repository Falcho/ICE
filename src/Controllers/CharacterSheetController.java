package Controllers;

import javax.swing.*;
import java.io.File;
import java.util.List;

import Views.*;

public class CharacterSheetController {

    private CreateStatsView view;

    public CharacterSheetController(CreateStatsView view) {
        this.view = view;

        this.view.saveAndContinueButtonCLick(e -> {
            List<int[]> stats = this.view.getStats();
            for (int[] stat : stats) {
                System.out.println(stat[0] + " " + stat[1]);
            }
            return;
        });


    }
}

