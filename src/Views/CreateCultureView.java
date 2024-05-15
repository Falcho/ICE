package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CreateCultureView extends JPanel {

    private JLabel title;
    private List<JLabel> labels;
    private JTextArea description;
    private List<JTextField[]> field;
    private JComboBox<String> chooseCultureDropdown;

    private JButton goToStats;
    private JButton previous;

    public CreateCultureView() {
        //Initialize all components
        title = new JLabel("It's time to choose your Culture");
        Font font = new Font(title.getFont().getName(), Font.PLAIN, 16);
        title.setFont(font);
        labels = new ArrayList<>();
        field = new ArrayList<>();
        labels.add(new JLabel("Animal Handling"));
        labels.add(new JLabel("Riding"));
        labels.add(new JLabel("Unarmed"));
        labels.add(new JLabel("Melee Weapons"));
        labels.add(new JLabel("Ranged Weapons"));
        labels.add(new JLabel("Languages"));
        labels.add(new JLabel("Other Lores"));
        labels.add(new JLabel("Influence"));
        for(int i = 0; i < labels.size(); i++){
            JTextField[] rankField = new JTextField[1];
            rankField[0] = new JTextField(3);
            field.add(rankField);
        }


        description = new JTextArea("COSMOPOLITAN:\n" +
                "When a city gets large enough, those who dwell in\n" +
                "it cease to be merely urban in culture. Large cities\n" +
                "tend to have very finely specialized craftsmen, and\n" +
                "the majority of their economy is devoted to trade and\n" +
                "commerce. The combination of specialization, access\n" +
                "to resources and cultural experiences you only find in\n" +
                "large urban areas, and exposure to other people via\n" +
                "trade and travel create a culture that is cosmopolitan.\n" +
                "\nCrafts: Large, diverse cities foster specialization and\n" +
                "support a wide range of crafts. Any craft is appropriate.\n" +
                "\nVocations: Bookkeeper, guardsman, librarian, manager,\n" +
                "merchant, officer, scribe, soldier, valet, or\n" +
                "any type of craftsman.",1,1);

        chooseCultureDropdown = new JComboBox<>(new String[]{"Cosmopolitan", "Harsh", "Highland", "Mariner"});
        goToStats = new JButton("Go To Stats");
        previous = new JButton("Previous");

        setLayout(new BorderLayout());

        this.add(createTopPanel(), BorderLayout.NORTH);
        this.add(createLeftPanel(), BorderLayout.WEST);
        this.add(createRightPanel(), BorderLayout.EAST);
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

    private JPanel createLeftPanel() {
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        GroupLayout.ParallelGroup labelGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        GroupLayout.ParallelGroup textFieldGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);

        for (int i = 0; i < labels.size(); i++) {
            labelGroup.addComponent(labels.get(i));
            textFieldGroup.addComponent(field.get(i)[0]);
        }
        hGroup.addGroup(labelGroup).addGroup(textFieldGroup);
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        for(int i = 0; i < labels.size(); i++){
            vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labels.get(i))
                    .addComponent(field.get(i)[0]));
        }
        layout.setVerticalGroup(vGroup);
        return panel;
    }

    private JPanel createRightPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        panel.add(description);
        return panel;
    }

    private JPanel createBottomPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(previous);
        panel.add(goToStats);
        return panel;
    }

    /*public int getAnimalHandling() {
        return getStat(0);
    }
    public int getRiding() {
        return getStat(1);
    }
    public int getUnarmed() {
        return getStat(2);
    }
    public int getMeleeWeapons() {
        return getStat(3);
    }
    public int getRangedWeapons() {
        return getStat(4);
    }
    public int getLanguages() {
        return getStat(5);
    }
    public int getOtherLores() {
        return getStat(6);
    }
    public int getInfluence() {
        return getStat(7);
    }*/

    //Action Listeners

    public void previousButtonClick (ActionListener actionListener) {
        previous.addActionListener(actionListener);
    }

    public void goToStatsButtonClick (ActionListener actionListener) {
        goToStats.addActionListener(actionListener);
    }

    public void reset(){
        for (JTextField[] jTextFields : field) {
            jTextFields[0].setText("");
        }
    }

}