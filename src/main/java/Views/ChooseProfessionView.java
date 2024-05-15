package Views;

import Models.Skill;
import Models.SkillCategory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ChooseProfessionView extends JPanel {

    private JLabel title;
    private JList<String> professionJList;
    private JTextArea professionDescription;
    private List<Map<String, Object>> professionList;
    private JPanel skillCostTextArea;
    private JPanel panel;
    private JCheckBox professionalBonusButton;
    private JCheckBox knackButton;
    private JButton previousButton;
    private JButton continueButton;

    private List<SkillCategory> skillAndCostList;
    private List<Skill> professionalSkill;

    public ChooseProfessionView(List<Map<String, Object>> professionList) {
        //Initialize all components
        title = new JLabel("Choose Profession");
        this.professionList = professionList;
        skillAndCostList = new ArrayList<>();
        professionalSkill = new ArrayList<>();
        professionDescription = new JTextArea();
        professionalBonusButton = new JCheckBox("Bonus");
        knackButton = new JCheckBox("Knack");


        previousButton = new JButton("Return to Character Name");
        continueButton = new JButton("Continue to Race");


        this.setLayout(new BorderLayout());
        this.add(createTitlePanel(), BorderLayout.NORTH);
        this.add(panelPanel(), BorderLayout.CENTER);
        this.add(createButtonsPanel(), BorderLayout.SOUTH);


    }

    private JPanel createTitlePanel() {
        JPanel panel = new JPanel();
        panel.add(title);
        return panel;
    }
    private JPanel panelPanel(){
        JPanel panel = new JPanel();
        panel.add(createProfessionListPanel(), BorderLayout.NORTH);
        panel.add(createProfessionInfoPanel(), BorderLayout.EAST);
        return panel;
    }

    private JPanel createProfessionListPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel panelTitle = new JLabel("Professions");
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Map<String, Object> profession : professionList) {
            model.addElement((String) profession.get("name"));
        }

        professionJList = new JList<>(model);
        professionJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        professionJList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedIndex = professionJList.getSelectedIndex();
                if (selectedIndex != -1) {
                    Map<String, Object> selectedProfession = professionList.get(selectedIndex);
                    professionDescription.setText((String) selectedProfession.get("description"));
                    updateSkillAndCostList((Map<String, Object>) selectedProfession);
                    updateProfessionalSkills((Map<String, Object>) selectedProfession);
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(professionJList);
        scrollPane.setPreferredSize(new Dimension(500, 500));
        panel.add(panelTitle, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createProfessionInfoPanel() {
        JPanel panel = new JPanel();
        BorderLayout layout = new BorderLayout();
        panel.setLayout(layout);
        panel.add(createProfessionTopInfoPanel(), BorderLayout.WEST);
        panel.add(createProfessionSkillCostPanel(), BorderLayout.EAST);
        return panel;
    }

    private JPanel createProfessionTopInfoPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(createProfessionDescriptionPanel());
        panel.add(Box.createVerticalStrut(10)); // Add space between panels
        panel.add(createProfessionalSkillsPanel());
        return panel;
    }

    private JPanel createProfessionDescriptionPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel panelTitle = new JLabel("Profession description");
        professionDescription = new JTextArea(10, 30);
        professionDescription.setLineWrap(true);
        professionDescription.setWrapStyleWord(true);
        professionDescription.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(professionDescription);
        panel.add(panelTitle, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }


    private JPanel createProfessionSkillCostPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel panelTitle = new JLabel("Profession skill costs");
        JPanel skillCostContainer = new JPanel();
        skillCostContainer.setLayout(new BoxLayout(skillCostContainer, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(skillCostContainer);
        panel.add(panelTitle, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        skillCostTextArea = skillCostContainer;
        return panel;
    }


    private JPanel createProfessionalSkillsPanel() {
        panel = new JPanel();
        JLabel panelTitle = new JLabel("Professional skills and knacks");
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel containerPanel = new JPanel();
        containerPanel.add(panel, BorderLayout.NORTH);
        return containerPanel;
    }

    private JPanel createButtonsPanel() {
        JPanel panel = new JPanel();
        panel.add(previousButton);
        panel.add(continueButton);
        return panel;
    }

    public boolean isProfessionSelected() {
        int selectedIndex = professionJList.getSelectedIndex();
        return selectedIndex != -1;
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



   private void updateSkillAndCostList(Map<String, Object> profession) {
       skillCostTextArea.removeAll(); // Clear existing components

       Map<String, List<Integer>> skillCosts = (Map<String, List<Integer>>) profession.get("professionSkillCost");

       if (skillCosts == null) {
           System.out.println("Warning: professionSkillCost is null for profession " + profession.get("name"));
           JLabel noCostsLabel = new JLabel("No skill costs available.");
           skillCostTextArea.add(noCostsLabel);
       } else {
           for (Map.Entry<String, List<Integer>> entry : skillCosts.entrySet()) {
               JPanel skillPanel = new JPanel(new BorderLayout());
               JLabel skillNameLabel = new JLabel(entry.getKey());
               JLabel skillCostLabel = new JLabel(entry.getValue().get(0) + ", " + entry.getValue().get(1));

               skillNameLabel.setPreferredSize(new Dimension(200,20));
               skillCostLabel.setPreferredSize(new Dimension(100, 20));

               skillPanel.add(skillNameLabel, BorderLayout.WEST);
               skillPanel.add(skillCostLabel, BorderLayout.EAST);

               skillCostTextArea.add(skillPanel);
           }
       }

       skillCostTextArea.revalidate();
       skillCostTextArea.repaint();
   }


    private void updateProfessionalSkills(Map<String, Object> profession) {
        panel.removeAll();
        List<String> skills = (List<String>) profession.get("availableProfessionalSkillList");
        for (String skill : skills) {
            JPanel skillPanel = new JPanel(new BorderLayout());
            JLabel skillLabel = new JLabel(skill);
            JCheckBox professionalBonusButton = new JCheckBox("Bonus"); // Create new instance
            JCheckBox knackButton = new JCheckBox("Knack"); // Create new instance

            skillPanel.add(skillLabel, BorderLayout.WEST);

            // Create a sub-panel for the checkboxes to align them together
            JPanel checkboxPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            checkboxPanel.add(professionalBonusButton);
            checkboxPanel.add(knackButton);

            skillPanel.add(checkboxPanel, BorderLayout.EAST);

            panel.add(skillPanel);
        }
        panel.revalidate();
        panel.repaint();
    }
}





