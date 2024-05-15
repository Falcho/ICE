package Views;

import Models.Culture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChooseCultureView extends JPanel {

    private JLabel title;
    private List<JLabel> labels;
    private JTextArea description;
    private List<JTextField[]> field;
    private JComboBox<String> chooseCultureDropdown;
    private Map<String,Culture> cultures;
    private JButton continueButton;
    private JButton previousButton;

    public ChooseCultureView(Map<String, Culture> cultures) {
        this.cultures = cultures;
        /*cultures = new HashMap<>();
        cultures.put("Cosmopolitan", new Culture("Cosmopolitan"));
        cultures.put("Harsh", new Culture("Harsh"));
        cultures.put("Highland", new Culture("Highland"));
        cultures.put("Malta", new Culture("Malta"));*/

        String[] availableCultures = cultures.keySet().toArray(new String[0]);
        String[] columnNames = {"Skill Name", "Skill Points"};
        String[][] data = {
                {"Perception", "2"},
                {"Body Development", "1"},
                {"Unarmed", "1"},
                {"Composition & Perf. Arts", "4"},
                {"Crafting & Vocation", "6"},
                {"Region (Own)", "5"},
                {"Region (Neighbouring)", "2"},
                {"Languages", "19"},
                {"Religion/Philosophy", "2"},
                {"Other Lores", "7"},
                {"Running", "1"},
                {"Influence", "2"},
                {"Social Awareness", "3"},
                {"Trading", "1"}
        };
        //Initialize all components
        title = new JLabel("It's time to choose your Culture");
        Font font = new Font(title.getFont().getName(), Font.PLAIN, 16);
        title.setFont(font);

        chooseCultureDropdown = new JComboBox<>(availableCultures);
        continueButton = new JButton("Continue To Talents");
        previousButton = new JButton("Previous");

        setLayout(new BorderLayout());

        this.add(createTopPanel(), BorderLayout.NORTH);
        this.add(createCenterPanel(data, columnNames), BorderLayout.CENTER);
        this.add(createBottomPanel(), BorderLayout.SOUTH);
    }

    private JPanel createTopPanel() {
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.add(title);
        JPanel dropDownPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        dropDownPanel.add(chooseCultureDropdown);

        JPanel borderPanel = new JPanel(new BorderLayout());
        borderPanel.add(titlePanel, BorderLayout.NORTH);
        borderPanel.add(dropDownPanel, BorderLayout.SOUTH);
        return borderPanel;
    }

    private JSplitPane createCenterPanel(String[][] data, String[] columnNames) {
        JSplitPane centerPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, createDescriptionPane(), createSkillListPane(data, columnNames));
        centerPanel.setResizeWeight(0.5);
        centerPanel.setContinuousLayout(true);
        return centerPanel;
    }

    private JPanel createSkillListPane(String[][] data, String[] columnNames) {
        JPanel panel = new JPanel(new BorderLayout());

        JTable skillTable = new JTable(data, columnNames);
        skillTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        skillTable.setFillsViewportHeight(true);

        panel.add(skillTable);

        return panel;
    }

    private JPanel createDescriptionPane() {
        description = new JTextArea("COSMOPOLITAN:\n" +
                "When a city gets large enough, those who dwell in " +
                "it cease to be merely urban in culture. Large cities " +
                "tend to have very finely specialized craftsmen, and " +
                "the majority of their economy is devoted to trade and " +
                "commerce. The combination of specialization, access " +
                "to resources and cultural experiences you only find in " +
                "large urban areas, and exposure to other people via " +
                "trade and travel create a culture that is cosmopolitan. " +
                "\nCrafts: Large, diverse cities foster specialization and " +
                "support a wide range of crafts. Any craft is appropriate. " +
                "\nVocations: Bookkeeper, guardsman, librarian, manager, " +
                "merchant, officer, scribe, soldier, valet, or " +
                "any type of craftsman.");
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setEditable(false);
        description.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        JPanel panel = new JPanel(new BorderLayout());
        panel.add(description, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createBottomPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(previousButton);
        panel.add(continueButton);
        return panel;
    }

    // Getters

    public Culture getChosenCulture() {
        return cultures.get(chooseCultureDropdown.getSelectedItem());
    }

    //Action Listeners

    public void previousButtonClick (ActionListener actionListener) {
        previousButton.addActionListener(actionListener);
    }

    public void continueButtonClick(ActionListener actionListener) {
        continueButton.addActionListener(actionListener);
    }

    public void reset(){
        for (JTextField[] jTextFields : field) {
            jTextFields[0].setText("");
        }
    }

}