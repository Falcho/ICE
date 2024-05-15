package Views;

import Models.Culture;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
    private JTextArea crafts;
    private JTextArea vocations;
    private List<JTextField[]> field;
    private JComboBox<String> chooseCultureDropdown;
    private Map<String, Culture> cultures;
    private JButton continueButton;
    private JButton previousButton;
    private JTable skillTable;
    private String[] columnNames;
    private String[][] data;
    DefaultTableModel tableModel;

    public ChooseCultureView(Map<String, Culture> cultures) {
        this.cultures = cultures;

        String[] availableCultures = cultures.keySet().toArray(new String[0]);
        columnNames = new String[]{"Skill Name", "Skill Points"};

        data = new String[][]{
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
        tableModel = new DefaultTableModel(this.data, this.columnNames);
        skillTable = new JTable(tableModel);
        skillTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        skillTable.setFillsViewportHeight(true);

        panel.add(skillTable);

        return panel;
    }

    private JPanel createDescriptionPane() {
        description = new JTextArea("Choose a Culture from the dropdown");
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setEditable(false);
        description.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        crafts = new JTextArea("Crafts here");
        crafts.setLineWrap(true);
        crafts.setWrapStyleWord(true);
        crafts.setEditable(false);
        crafts.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        vocations = new JTextArea("Vocations here");
        vocations.setLineWrap(true);
        vocations.setWrapStyleWord(true);
        vocations.setEditable(false);
        vocations.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        JPanel panel = new JPanel(new BorderLayout());
        panel.add(description, BorderLayout.NORTH);
        JPanel innerPanel = new JPanel(new BorderLayout());
        innerPanel.add(crafts, BorderLayout.CENTER);
        innerPanel.add(vocations, BorderLayout.SOUTH);
        panel.add(innerPanel, BorderLayout.SOUTH);
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

    public void previousButtonClick(ActionListener actionListener) {
        previousButton.addActionListener(actionListener);
    }

    public void continueButtonClick(ActionListener actionListener) {
        continueButton.addActionListener(actionListener);
    }

    public void dropDownSelection(ActionListener actionListener) {
        chooseCultureDropdown.addActionListener(actionListener);
    }

    public void reset() {
        for (JTextField[] jTextFields : field) {
            jTextFields[0].setText("");
        }
    }

    //Setters
    public void setDescription(String description) {
        this.description.setText(description);
    }

    public void setCrafts(String crafts) {
        this.crafts.setText(crafts);
    }

    public void setVocations(String vocations) {
        this.vocations.setText(vocations);
    }

    public void setSkillTable(String[][] data) {
        this.tableModel.setDataVector(data, columnNames);
    }
}