import Models.CharacterSheet;
import Views.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}