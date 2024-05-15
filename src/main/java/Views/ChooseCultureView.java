package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ChooseCultureView extends JPanel {

    private JLabel title;
    private List<JLabel> labels;
    private JTextArea description;
    private List<JTextField[]> field;
    private JComboBox<String> chooseCultureDropdown;

    private JButton continueButton;
    private JButton previousButton;

    public ChooseCultureView() {
        //Initialize all components
        title = new JLabel("It's time to choose your Culture");
        Font font = new Font(title.getFont().getName(), Font.PLAIN, 16);
        title.setFont(font);
        labels = new ArrayList<>();
        field = new ArrayList<>();
        labels.add(new JLabel("Animal Handling"));
        labels.add(new JLabel("Riding"));
        labels.add(new JLabel("Unarmed"));
        labels.add(new JLabel("Melee Weapons"));
        labels.add(new JLabel("Ranged Weapons"));
        labels.add(new JLabel("Languages"));
        labels.add(new JLabel("Other Lores"));
        labels.add(new JLabel("Influence"));
        for(int i = 0; i < labels.size(); i++){
            JTextField[] rankField = new JTextField[1];
            rankField[0] = new JTextField(3);
            field.add(rankField);
        }




        chooseCultureDropdown = new JComboBox<>(new String[]{"Cosmopolitan", "Harsh", "Highland", "Mariner"});
        continueButton = new JButton("Continue to Talents");
        previousButton = new JButton("Previous");

        setLayout(new BorderLayout());

        this.add(createTopPanel(), BorderLayout.NORTH);
        this.add(createCenterPanel(), BorderLayout.CENTER);
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

    private JSplitPane createCenterPanel() {
        JSplitPane centerPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, createDescriptionPane(), createSkillListPane());
        centerPanel.setResizeWeight(0.5);
        centerPanel.setContinuousLayout(true);
        return centerPanel;
    }

    private JPanel createSkillListPane() {
        JPanel panel = new JPanel(new BorderLayout());
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
        JTable skillTable = new JTable(data, columnNames);
        skillTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        skillTable.setFillsViewportHeight(true);

        panel.add(skillTable);

        return panel;
    }

    /*private JPanel createSkillListPane() {
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        GroupLayout.ParallelGroup labelGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        GroupLayout.ParallelGroup textFieldGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);

        for (int i = 0; i < labels.size(); i++) {
            labelGroup.addComponent(labels.get(i));
            textFieldGroup.addComponent(field.get(i)[0]);
        }
        hGroup.addGroup(labelGroup).addGroup(textFieldGroup);
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        for(int i = 0; i < labels.size(); i++){
            vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labels.get(i))
                    .addComponent(field.get(i)[0]));
        }
        layout.setVerticalGroup(vGroup);
        return panel;
    }*/

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

    /*public int getAnimalHandling() {
        return getStat(0);
    }
    public int getRiding() {
        return getStat(1);
    }
    public int getUnarmed() {
        return getStat(2);
    }
    public int getMeleeWeapons() {
        return getStat(3);
    }
    public int getRangedWeapons() {
        return getStat(4);
    }
    public int getLanguages() {
        return getStat(5);
    }
    public int getOtherLores() {
        return getStat(6);
    }
    public int getInfluence() {
        return getStat(7);
    }*/

    //Action Listeners

    public void previousButtonClick (ActionListener actionListener) {
        previousButton.addActionListener(actionListener);
    }

    public void goToStatsButtonClick (ActionListener actionListener) {
        continueButton.addActionListener(actionListener);
    }

    public void reset(){
        for (JTextField[] jTextFields : field) {
            jTextFields[0].setText("");
        }
    }

}