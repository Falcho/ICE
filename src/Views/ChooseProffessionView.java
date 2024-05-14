package Views;

import Models.Skill;
import Models.SkillCategory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;


public class ChooseProffessionView extends JPanel {

    private JLabel title;
    private String[] proffessionList;
    private JList<String> proffessionJList;
    private JList<SkillCategory> skillAndCostList;
    private JList<Skill> proffessionalSkill;
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
        skillAndCostList = new JList(proffessionList);
        proffessionalSkill = new JList<>();
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
        JList list = new JList();
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(10);
        JScrollPane scrollPane = new JScrollPane(list);
        list.setPreferredSize(new Dimension(250,250));
        panel.add(scrollPane);
        return panel;
    }

    private JPanel createProffessionalSkillsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        //tilføj kode der henter Professional Skill Listen
        List<Skill> skills = getProffessionalSkill();
        for (Skill skill : skills){
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
        return (List<Skill>) proffessionalSkill;
    }

    public void setProffessionalSkill(List<Skill> proffessionalSkill) {
        this.proffessionalSkill = (JList<Skill>) proffessionalSkill;
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

    public JList<SkillCategory> getSkillAndCostList() {
        return skillAndCostList;
    }

    public void setSkillAndCostList(JList<SkillCategory> skillAndCostList) {
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




