package Views;

import Models.Skill;
import Models.SkillCategory;

import javax.swing.*;
import java.awt.*;
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
        proffessionList = new String[]{"Fighter", "Magician"};
        proffessionJList = new JList<>(proffessionList);
        skillAndCostList = new ArrayList<>();
        proffessionalSkill = new ArrayList<>();
        proffessionDescription = new JTextArea("Description Description Description Description \n" +
                "Description Description Description Description \n" +
                "Description Description Description Description \n" +
                "Description Description Description Description \n" +
                "Description Description Description Description \n" +
                "Description Description Description Description \n" +
                "Description Description Description Description \n" +
                "Description Description Description Description \n" +
                "Description Description Description Description \n");
        proffessionalBonusButton = new JCheckBox("Bonus");
        knackButton = new JCheckBox("Knack");


        returnToCharacterName = new JButton("Return to Character Name");
        saveAndContinueToRace = new JButton("Save and Continue to Race");


        this.setLayout(new BorderLayout());
        this.add(createTopPanel(), BorderLayout.NORTH);
        this.add(createLeftPanel(), BorderLayout.WEST);
        this.add(createRightPanel(), BorderLayout.EAST);
        this.add(createBottomPanel(), BorderLayout.SOUTH);

    }

    private JPanel createTopPanel() {
        JPanel panel = new JPanel();
        panel.add(title);
        return panel;
    }

    private JPanel createLeftPanel() {
        JPanel panel = new JPanel();
        panel.add(new JScrollPane(proffessionJList));
        return panel;
    }

    private JPanel createRightPanel() {
        JPanel panel = new JPanel();
        BorderLayout layout = new BorderLayout();
        panel.setLayout(layout);
        panel.add(createRightTopPanel(), BorderLayout.NORTH);
        panel.add(createRightBottomPanel(), BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createRightTopPanel() {
        JPanel panel = new JPanel();
        BorderLayout layout = new BorderLayout();
        panel.setLayout(layout);
        panel.add(createRightTopLeftPanel(), BorderLayout.WEST);
        panel.add(createRightTopRightPanel(), BorderLayout.EAST);
        return panel;
    }

    private JPanel createRightTopLeftPanel() {
        JPanel panel = new JPanel();
        panel.add(proffessionDescription);
        return panel;
    }

    private JPanel createRightTopRightPanel() {
        JPanel panel = new JPanel();
        return panel;
    }

    private JPanel createRightBottomPanel() {
        JPanel panel = new JPanel();
        proffessionalBonusButton.setSelected(false);
        knackButton.setSelected(false);
        panel.add(proffessionalBonusButton);
        panel.add(knackButton);
        return panel;
    }


    private JPanel createBottomPanel() {
        JPanel panel = new JPanel();
        panel.add(returnToCharacterName);
        panel.add(saveAndContinueToRace);
        return panel;
    }


}




