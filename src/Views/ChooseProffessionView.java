package Views;

import Models.Skill;
import Models.SkillCategory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class ChooseProffessionView extends JPanel {

    private JLabel title;
    private String[] proffessionList;
    private JList<String> proffessionJList;
    private List<SkillCategory> skillAndCostList;
    private List<Skill> proffessionalSkill;
    private JTextArea proffessionDescription;
    private JCheckBox proffessionalBonusButton;
    private JCheckBox knackButton;
    private JButton returnToCharacterName;
    private JButton saveAndContinueToRace;

    public ChooseProffessionView() {
        //Initialize all components
        title = new JLabel("Choose Proffession");
        proffessionList = new String[]{"Fighter", "Magician","Test","Test","Test","Test","Test","Test","Test","Test","Test","Test","Test","Test","Test","Test","Test","Test","Test","Test","Test","Test"};
        proffessionJList = new JList(proffessionList);
        skillAndCostList = new ArrayList<>();
        proffessionalSkill = new ArrayList<>();
        proffessionDescription = new JTextArea("Description Description Description Description \n" +
                "Description Description Description Description \n");
        proffessionalBonusButton = new JCheckBox("Bonus");
        knackButton = new JCheckBox("Knack");


        returnToCharacterName = new JButton("Return to Character Name");
        saveAndContinueToRace = new JButton("Save and Continue to Race");


        this.setLayout(new BorderLayout());
        this.add(createTitlePanel(), BorderLayout.NORTH);
        this.add(createProffessionListPanel(), BorderLayout.WEST);
        this.add(createProffessionInfoPanel(), BorderLayout.EAST);
        this.add(createButtonsPanel(), BorderLayout.SOUTH);

    }

    private JPanel createTitlePanel() {
        JPanel panel = new JPanel();
        panel.add(title);
        return panel;
    }

    private JPanel createProffessionListPanel() {
        JPanel panel = new JPanel();
        JList list = new JList(proffessionList);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(30);
        JScrollPane scrollPane = new JScrollPane(list);
        list.setPreferredSize(new Dimension(300,500));
        panel.add(scrollPane);
        return panel;
    }

    private JPanel createProffessionInfoPanel() {
        JPanel panel = new JPanel();
        BorderLayout layout = new BorderLayout();
        panel.setLayout(layout);
        panel.add(createProffessionTopInfoPanel(), BorderLayout.NORTH);
        panel.add(createProffessionalSkillsPanel(), BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createProffessionTopInfoPanel() {
        JPanel panel = new JPanel();
        BorderLayout layout = new BorderLayout();
        panel.setLayout(layout);
        panel.add(createProffessionDescriptionPanel(), BorderLayout.WEST);
        panel.add(createProffessionSkillCostPanel(), BorderLayout.EAST);
        return panel;
    }

    private JPanel createProffessionDescriptionPanel() {
        JPanel panel = new JPanel();
        panel.add(proffessionDescription);
        return panel;
    }

    private JPanel createProffessionSkillCostPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < skillAndCostList.size(); i += 2) {
            SkillCategory category1 = skillAndCostList.get(i);
            sb.append(category1.getName()).append(" (").append(category1.getDPCostFirst()).append(", ").append(category1.getDPCostSecond()).append(")");
            if (i + 1 < skillAndCostList.size()) { // Check if there's a second category
                SkillCategory category2 = skillAndCostList.get(i + 1);
                sb.append("   ");
                sb.append(category2.getName()).append(" (").append(category2.getDPCostFirst()).append(", ").append(category2.getDPCostSecond()).append(")");
            }
            sb.append("\n");
        }
        textArea.setText(sb.toString());
        return panel;
    }

    private JPanel createProffessionalSkillsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
//        Function<Skill,String>skillNameExtractor = Skill::getName;
//        List<String>skillNames = proffessionalSkill.stream().map(skillNameExtractor).toList();
//        JList<String> skillsList = new JList<>(skillNames.toArray(new String[0]));
        //tilføj kode der henter Professional Skill Listen
        for (Skill skill : proffessionalSkill){
            JPanel skillPanel = new JPanel();
            skillPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            skillPanel.add(proffessionalBonusButton);
            skillPanel.add(knackButton);
            JLabel skillLabel = new JLabel(String.valueOf(skill));
            skillPanel.add(skillLabel);
            panel.add(skillPanel);
        }

        return panel;
    }


    private JPanel createButtonsPanel() {
        JPanel panel = new JPanel();
        panel.add(returnToCharacterName);
        panel.add(saveAndContinueToRace);
        return panel;
    }

    public List<Skill> getProffessionalSkill() {
        return proffessionalSkill;
    }

    public void setProffessionalSkill(List<Skill> proffessionalSkill) {
        this.proffessionalSkill = proffessionalSkill;
    }

    public JTextArea getProffessionDescription() {
        return proffessionDescription;
    }

    public void setProffessionDescription(JTextArea proffessionDescription) {
        this.proffessionDescription = proffessionDescription;
    }

    public JList<String> getProffessionJList() {
        return proffessionJList;
    }

    public void setProffessionJList(JList<String> proffessionJList) {
        this.proffessionJList = proffessionJList;
    }

    public String[] getProffessionList() {
        return proffessionList;
    }

    public void setProffessionList(String[] proffessionList) {
        this.proffessionList = proffessionList;
    }

    public List<SkillCategory> getSkillAndCostList() {
        return skillAndCostList;
    }

    public void setSkillAndCostList(List<SkillCategory> skillAndCostList) {
        this.skillAndCostList = skillAndCostList;
    }

    public JLabel getTitle() {
        return title;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }

    public void returnToCharacterName(ActionListener actionListener) {
        returnToCharacterName.addActionListener(actionListener);
    }

    public void saveAndContinueToRace(ActionListener actionListener) {
        saveAndContinueToRace.addActionListener(actionListener);
    }
}




