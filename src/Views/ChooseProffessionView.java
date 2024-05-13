package Views;

import Models.Profession;
import Models.SkillCategory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class ChooseProffessionView extends JFrame {

    private JLabel title;
    private JLabel proffessionalBonus;
    private JLabel knack;
    private JList<Profession> proffessionList;
    private List<SkillCategory> skillList;
    private JTextArea proffessionDescription;
    private JCheckBox ProffessionalAndKnack;


    private JButton returnToCharacterName;
    private JButton saveAndContinueToRace;

    public ChooseProffessionView() {
        //Initialize all components
        title = new JLabel("Choose Proffession");
        proffessionalBonus = new JLabel("Bonus");
        knack = new JLabel("Knack");
        proffessionList = new JList<>();
        skillList = new ArrayList<>();
        proffessionDescription = new JTextArea();
        ProffessionalAndKnack = new JCheckBox();

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
        panel.add(proffessionList);
        return panel;
    }

    private JPanel createRightPanel() {
        JPanel panel = new JPanel();
        BorderLayout layout = new BorderLayout();
        panel.setLayout(layout);
        return panel;
    }

    private JPanel createRightTopPanel() {
        JPanel panel = new JPanel();
        return panel;
    }

    private JPanel createRightTopLeftPanel(){
        JPanel panel = new JPanel();
        return panel;
    }
    private JPanel createRightTopRightPanel(){
        JPanel panel = new JPanel();
        return panel;
    }

    private JPanel createRightBottomPanel() {
        JPanel panel = new JPanel();
        return panel;
    }


    private JPanel createBottomPanel() {
        JPanel panel = new JPanel();
        panel.add(returnToCharacterName);
        panel.add(saveAndContinueToRace);
        return panel;
    }

}




