package Views;

import Models.Profession;
import Models.Skill;
import Models.SkillCategory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class ChooseProfessionView extends JPanel {

    private JLabel title;
    private Profession profession;
    private List<Profession> professionList;
    private JList<String> professionJList;
    private List<SkillCategory> skillAndCostList;
    private List<Skill> professionalSkill;
    private JTextArea professionDescription;
    private JCheckBox professionalBonusButton;
    private JCheckBox knackButton;
    private JButton previousButton;
    private JButton continueButton;

    public ChooseProfessionView() {
        //Initialize all components
        title = new JLabel("Choose Profession");
        professionList = new ArrayList<>();
        skillAndCostList = new ArrayList<>();
        professionalSkill = new ArrayList<>();
        professionDescription = new JTextArea();
        professionalBonusButton = new JCheckBox("Bonus");
        knackButton = new JCheckBox("Knack");


        previousButton = new JButton("Return to Character Name");
        continueButton = new JButton("Continue to Race");


        this.setLayout(new BorderLayout());
        this.add(createTitlePanel(), BorderLayout.NORTH);
        this.add(createProfessionListPanel(), BorderLayout.WEST);
        this.add(createProfessionInfoPanel(), BorderLayout.EAST);
        this.add(createButtonsPanel(), BorderLayout.SOUTH);

    }

    private JPanel createTitlePanel() {
        JPanel panel = new JPanel();
        panel.add(title);
        return panel;
    }

    private JPanel createProfessionListPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        DefaultListModel<String> model = new DefaultListModel<>();
        for (Profession profession : professionList) {
            model.addElement(profession.getName());
        }

        professionJList = new JList<>(model);
        professionJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        professionJList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedIndex = professionJList.getSelectedIndex();
                if (selectedIndex != -1) {
                    Profession selectedProfession = professionList.get(selectedIndex);
                    professionDescription.setText(selectedProfession.getDescription());
                    updateSkillAndCostList(selectedProfession);
                    updateProfessionalSkills(selectedProfession);
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(professionJList);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createProfessionInfoPanel() {
        JPanel panel = new JPanel();
        BorderLayout layout = new BorderLayout();
        panel.setLayout(layout);
        panel.add(createProfessionTopInfoPanel(), BorderLayout.NORTH);
        panel.add(createProfessionalSkillsPanel(), BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createProfessionTopInfoPanel() {
        JPanel panel = new JPanel();
        BorderLayout layout = new BorderLayout();
        panel.setLayout(layout);
        panel.add(createProfessionDescriptionPanel(), BorderLayout.WEST);
        panel.add(createProfessionSkillCostPanel(), BorderLayout.EAST);
        return panel;
    }

    private JPanel createProfessionDescriptionPanel() {
        JPanel panel = new JPanel();
        panel.add(professionDescription);
        return panel;
    }

    private JPanel createProfessionSkillCostPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < skillAndCostList.size(); i += 2) {
            SkillCategory category1 = skillAndCostList.get(i);
            sb.append(category1.getName()).append(" (").append(category1.getDPCostFirst()).append(", ")
                    .append(category1.getDPCostSecond()).append(")");
            if (i + 1 < skillAndCostList.size()) { // Check if there's a second category
                SkillCategory category2 = skillAndCostList.get(i + 1);
                sb.append("   ");
                sb.append(category2.getName()).append(" (").append(category2.getDPCostFirst()).append(", ")
                        .append(category2.getDPCostSecond()).append(")");
            }
            sb.append("\n");
        }
        textArea.setText(sb.toString());
        return panel;
    }

    private JPanel createProfessionalSkillsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        for (Skill skill : professionalSkill){
            JPanel skillPanel = new JPanel();
            skillPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            skillPanel.add(professionalBonusButton);
            skillPanel.add(knackButton);
            JLabel skillLabel = new JLabel(String.valueOf(skill));
            skillPanel.add(skillLabel);
            panel.add(skillPanel);
        }

        return panel;
    }

    private JPanel createButtonsPanel() {
        JPanel panel = new JPanel();
        panel.add(previousButton);
        panel.add(continueButton);
        return panel;
    }

    public boolean isProfessionSelected(){
        int selectedIndex = professionJList.getSelectedIndex();
        return selectedIndex != -1;
    }

    public void setProfession() {
        this.profession = profession;
    }

    public List<Skill> getProfessionalSkill() {
        return professionalSkill;
    }

    public void setProfessionalSkill(List<Skill> professionalSkill) {
        this.professionalSkill = professionalSkill;
    }

    public JTextArea getProfessionDescription() {
        return professionDescription;
    }

    public void setProfessionDescription(JTextArea professionDescription) {
        this.professionDescription = professionDescription;
    }

    public List<Profession> getProfessionJList() {
        return professionList;
    }

    public void setProfessionJList(List<Profession> professionList) {
        this.professionList = professionList;
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

    public void previousButtonClick(ActionListener actionListener) {
        previousButton.addActionListener(actionListener);
    }

    public void continueButtonClick(ActionListener actionListener) {
        continueButton.addActionListener(actionListener);
    }

    private void updateSkillAndCostList(Profession profession) {
        skillAndCostList.clear();
        //Linje her er muligvis ikke nødvendig?
        //skillAndCostList.addAll(profession.getSkillCategory());
        updateProfessionSkillCostPanel();
    }

    private void updateProfessionalSkills(Profession profession) {
        professionalSkill.clear();
        professionalSkill.addAll(profession.getProfessionalSkill());
        updateProfessionalSkillsPanel();
    }

    private void updateProfessionSkillCostPanel() {
        StringBuilder sb = new StringBuilder();
        for (SkillCategory category : skillAndCostList) {
            sb.append(category.getName()).append(" (").append(category.getDPCostFirst()).append(", ").
                    append(category.getDPCostSecond()).append(")\n");
        }
        professionDescription.setText(sb.toString());
    }

    private void updateProfessionalSkillsPanel() {
        professionDescription.removeAll();
        for (Skill skill : professionalSkill) {
            JPanel skillPanel = new JPanel();
            skillPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            skillPanel.add(professionalBonusButton);
            skillPanel.add(knackButton);
            JLabel skillLabel = new JLabel(skill.getName());
            skillPanel.add(skillLabel);
            professionDescription.add(skillPanel);
        }
        professionDescription.revalidate();
        professionDescription.repaint();
    }
}





