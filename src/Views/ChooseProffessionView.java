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
    private List<JList> proffessionSkillCost;
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
        proffessionSkillCost = new ArrayList<>();
        proffessionDescription = new JTextArea();
        ProffessionalAndKnack = new JCheckBox();

        returnToCharacterName = new JButton("Return to Character Name");
        saveAndContinueToRace = new JButton("Save and Continue to Race");

        this.setLayout(new BorderLayout());

        }


    }




