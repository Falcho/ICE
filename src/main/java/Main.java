import Models.CharacterSheet;
import Views.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        CharacterSheet sheet = new CharacterSheet();
        System.out.println(sheet);
        SwingUtilities.invokeLater(MainFrame::new);
    }
}