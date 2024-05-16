package Views;

import Models.Race;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Map;

public class ChooseRaceView extends JPanel {
    private final String[] columnNames;
    private final String[][] data;
    private Map<String, Race> races;
    private JLabel title;
    private JLabel sizeLabel;
    private JLabel statBonusLabel;
    private JLabel resistanceLabel;
    private JLabel healthAndDevLabel;
    private JComboBox<String> chooseRaceDropDown;
    private JTextArea description;
    private JLabel tAndFlawTitle;
    private JTextArea tAndFlawDescription;
    private JTable sizeTable;
    private JTable statBonusTable;
    private JTable resistanceTable;
    private JTable healthAndDevTable;
    private JButton previousButton;
    private JButton continueButton;
    DefaultTableModel sizeTableModel;
    DefaultTableModel statBonusTableModel;
    DefaultTableModel resistanceTableModel;
    DefaultTableModel healthAndDevTableModel;
    private String[] defaultColumnNames;

    //Map<String, Race> races ---- skal ind i constructor som argument
    public ChooseRaceView() {
        //this.races = races;

        //String[] availableRaces = races.keySet().toArray(new String[0]);
        columnNames = new String[]{"Name", "Skill Points", "Name", "Skill Points"};
        data = new String [][]{
                {"Skill", "1", "Skill", "1"},
                {"Skill", "1", "Skill", "1"},
                {"Skill", "1", "Skill", "1"},
                {"Skill", "1", "Skill", "1"},
                {"Skill", "1", "Skill", "1"},
                {"NEW TABLE UNDER", "1", "NEW TABLE UNDER", "1"},
        };

        //Initialize all Components
        title = new JLabel("It's time to choose your Race");
        Font font = new Font(title.getFont().getName(), Font.PLAIN, 16);
        title.setFont(font);
        tAndFlawTitle = new JLabel("Racial Talents & Flaws");
        tAndFlawDescription = new JTextArea("DESCRIPTION");
        sizeLabel = new JLabel();
        statBonusLabel = new JLabel();
        resistanceLabel = new JLabel();
        healthAndDevLabel = new JLabel();
        sizeTable = new JTable();
        statBonusTable = new JTable();
        resistanceTable = new JTable();
        healthAndDevTable = new JTable();
        defaultColumnNames = new String[]{"","","",""};

        chooseRaceDropDown = new JComboBox<>();
        previousButton = new JButton("Previous");
        continueButton = new JButton("Continue to Culture");

        setLayout(new BorderLayout());

        this.add(createTopPane(), BorderLayout.NORTH);
        this.add(createCenterSplitPane(), BorderLayout.CENTER);
        this.add(createBottomPane(), BorderLayout.SOUTH);



    }

    private JPanel createTopPane(){
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.add(title);
        JPanel dropDownPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        dropDownPanel.add(chooseRaceDropDown);

        JPanel borderPanel = new JPanel(new BorderLayout());
        borderPanel.add(titlePanel, BorderLayout.NORTH);
        borderPanel.add(dropDownPanel, BorderLayout.SOUTH);

        return borderPanel;
    }

    private JSplitPane createCenterSplitPane(){
        JSplitPane centerPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, createDescriptionPane(), createRightOuterPane());
        centerPanel.setResizeWeight(0.5);
        centerPanel.setContinuousLayout(true);
        return centerPanel;
    }

    private JPanel createDescriptionPane(){
        description = new JTextArea("Choose a race from the dropdown, Choose a race from the dropdown, Choose a race from the dropdown, " +
                "Choose a race from the dropdown, Choose a race from the dropdown, Choose a race from the dropdown, " +
                "Choose a race from the dropdown, Choose a race from the dropdown, Choose a race from the dropdown, " +
                "Choose a race from the dropdown, Choose a race from the dropdown, Choose a race from the dropdown, " +
                "Choose a race from the dropdown, Choose a race from the dropdown, Choose a race from the dropdown, ");
        description.setEditable(false);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));


        JPanel panel = new JPanel(new BorderLayout());
        panel.add(description,BorderLayout.NORTH);

        return panel;
    }

    private JPanel createRightOuterPane(){
        JPanel borderPanel = new JPanel(new BorderLayout());

        JPanel talentAndFlawPanel = new JPanel(new BorderLayout());
        talentAndFlawPanel.add(tAndFlawTitle, BorderLayout.NORTH);
        talentAndFlawPanel.add(tAndFlawDescription, BorderLayout.SOUTH);

        JPanel racialOuterPanel = new JPanel(new BorderLayout());
        JPanel racialTopInner = new JPanel(new BorderLayout());

        sizeTableModel = new DefaultTableModel(this.data, this.columnNames);
        sizeTable = new JTable(sizeTableModel);

        statBonusTableModel = new DefaultTableModel(this.data, this.columnNames);
        statBonusTable = new JTable(statBonusTableModel);

        racialTopInner.add(sizeTable, BorderLayout.WEST);
        racialTopInner.add(statBonusTable, BorderLayout.EAST);

        JPanel racialBottomInner = new JPanel(new BorderLayout());

        resistanceTableModel = new DefaultTableModel(this.data, this.columnNames);
        resistanceTable = new JTable(resistanceTableModel);

        healthAndDevTableModel = new DefaultTableModel(this.data, this.columnNames);
        healthAndDevTable = new JTable(healthAndDevTableModel);

        racialBottomInner.add(resistanceTable, BorderLayout.WEST);
        racialBottomInner.add(healthAndDevTable, BorderLayout.EAST);

        racialOuterPanel.add(racialTopInner, BorderLayout.NORTH);
        racialOuterPanel.add(racialBottomInner, BorderLayout.SOUTH);


        JSplitPane splitTalentAndRacial = new JSplitPane(JSplitPane.VERTICAL_SPLIT, talentAndFlawPanel, racialOuterPanel);
        splitTalentAndRacial.setResizeWeight(0.5);
        splitTalentAndRacial.setContinuousLayout(true);

        borderPanel.add(talentAndFlawPanel, BorderLayout.NORTH);
        borderPanel.add(racialOuterPanel, BorderLayout.SOUTH);

        return borderPanel;

    }

    private JPanel createBottomPane(){
        //Buttons go here
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(previousButton);
        panel.add(continueButton);
        return panel;
    }

    //Getters
    public Race getChosenRace(){
        return races.get(chooseRaceDropDown.getSelectedItem());
    }


    //Setters
    public void setDescription(String description){
        this.description.setText(description);
    }
    public void setTAndFlawDescription(String tAndFlawDescription){
        this.tAndFlawDescription.setText(tAndFlawDescription);
    }
    public void setSizeTable(String[][] sizeData){
        this.sizeTableModel.setDataVector(sizeData, this.defaultColumnNames);
    }
    public void setStatsBonusTable(String[][] statBonusData){
        this.statBonusTableModel.setDataVector(statBonusData, this.defaultColumnNames);
    }
    public void setResistanceTable(String[][] resistanceData){
        this.resistanceTableModel.setDataVector(resistanceData, this.defaultColumnNames);
    }
    public void setHealthAndDevTable(String[][] healthAndDevData){
        this.healthAndDevTableModel.setDataVector(healthAndDevData, this.defaultColumnNames);
    }


    //Action Listeners
    public void previousButtonClick(ActionListener actionListener) {
        previousButton.addActionListener(actionListener);
    }

    public void continueButtonClick(ActionListener actionListener) {
        continueButton.addActionListener(actionListener);
    }

    public void dropDownSelection(ActionListener actionListener) {
        chooseRaceDropDown.addActionListener(actionListener);
    }


}
