package Views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class CharacterSheetView extends JPanel {
    JLabel title;
    JButton levelUp;
    JButton inventory;
    JButton spellBook;
    JButton skills;

    public CharacterSheetView() {
        title = new JLabel("Character Sheet");
        levelUp = new JButton("Level Up");
        inventory = new JButton("Inventory");
        spellBook = new JButton("Spell Book");
        skills = new JButton("Skills");

        this.setLayout(new BorderLayout());
        this.add(mainPanel(), BorderLayout.CENTER);
        this.add(buttonsPanel(), BorderLayout.SOUTH);
    }

    private JPanel mainPanel() {
        JPanel panel = new JPanel();
        panel.add(sheetPanel(), BorderLayout.NORTH);
        panel.add(buttonsPanel(), BorderLayout.SOUTH);
        return panel;
    }

    private JPanel buttonsPanel() {
        JPanel panel = new JPanel();
        panel.add(inventory);
        panel.add(spellBook);
        panel.add(skills);
        return panel;
    }

    private JPanel sheetPanel() {
        JPanel panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane();
        panel.add(characterInfoPanel());
        panel.add(upperInfoPanel());
        panel.add(defencePanel());
        panel.add(underInfoPanel());
        scrollPane.add(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        return panel;
    }

    private JPanel characterInfoPanel() {
        JPanel panel = new JPanel();
        return panel;
    }

    private JPanel upperInfoPanel() {
        JPanel panel = new JPanel();
        panel.add(statsPanel());
        panel.add(encumbrancePanel());
        panel.add(quickInfoPanel());
        return panel;
    }

    private JPanel statsPanel() {
        JPanel panel = new JPanel();
        return panel;
    }

    private JPanel encumbrancePanel() {
        JPanel panel = new JPanel();
        return panel;
    }

    private JPanel quickInfoPanel() {
        JPanel panel = new JPanel();
        return panel;
    }

    private JPanel defencePanel() {
        JPanel panel = new JPanel();
        return panel;
    }

    private JPanel underInfoPanel() {
        JPanel panel = new JPanel();
        panel.add(fosPanel());
        panel.add(movementPanel());
        return panel;
    }

    private JPanel fosPanel() {
        JPanel panel = new JPanel();
        return panel;
    }

    private JPanel movementPanel() {
        JPanel panel = new JPanel();
        return panel;
    }

}
