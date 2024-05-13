package Views;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class ChooseProffessionView extends JFrame {

    private JLabel title;
    private JLabel proffessionalBonus;
    private JLabel knack;
    private List<String> proffessionList;
    private List<JList> skillList;
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
        proffessionList = new ArrayList<String>();
        skillList = new ArrayList<>();
        proffessionSkillCost = new ArrayList<>();
        proffessionDescription = new JTextArea();
        ProffessionalAndKnack = new JCheckBox();

    }



}
