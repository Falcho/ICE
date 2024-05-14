package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CreateStatsView extends JPanel {

    private JLabel title;
    private List<JLabel> labels;
    private List<JTextField[]> fields;

    private JButton returnToCharacterInfo;
    private JButton saveAndContinueToSkills;
    private JButton rollStatsForMe;

    public CreateStatsView() {
        //Initialize all components
        title = new JLabel("Generate Stats");
        labels = new ArrayList<>();
        fields = new ArrayList<>();
        labels.add(new JLabel("Agility (Ag)"));
        labels.add(new JLabel("Constitution (Co)"));
        labels.add(new JLabel("Empathy (Em)"));
        labels.add(new JLabel("Intuition (In)"));
        labels.add(new JLabel("Memory (Me)"));
        labels.add(new JLabel("Presence (Pr)"));
        labels.add(new JLabel("Quickness (Qu)"));
        labels.add(new JLabel("Reasoning (Re)"));
        labels.add(new JLabel("Self Discipline (SD)"));
        labels.add(new JLabel("Strength (St)"));
        for (int i=0; i<10; i++) {
            JTextField[] statFields = new JTextField[3];
            statFields[0] = new JTextField(3);
            statFields[1] = new JTextField(3);
            statFields[2] = new JTextField(3);
            fields.add(statFields);

        }
        returnToCharacterInfo = new JButton("Return to Character Info");
        saveAndContinueToSkills = new JButton("Save and Continue to Skills");
        rollStatsForMe = new JButton("Roll Stats For Me");

        this.setLayout(new BorderLayout());

        this.add(createTopPanel(), BorderLayout.NORTH);
        this.add(createMiddlePanel(),BorderLayout.CENTER);
        this.add(createBottomPanel(), BorderLayout.SOUTH);

    }

    private JPanel createMiddlePanel() {
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        GroupLayout.ParallelGroup labelGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        GroupLayout.ParallelGroup textFieldGroupA = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        GroupLayout.ParallelGroup textFieldGroupB = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        GroupLayout.ParallelGroup textFieldGroupC = layout.createParallelGroup(GroupLayout.Alignment.LEADING);

        for (int i = 0; i < 10; i++) {
            labelGroup.addComponent(labels.get(i));
            textFieldGroupA.addComponent(fields.get(i)[0]);
            textFieldGroupB.addComponent(fields.get(i)[1]);
            textFieldGroupC.addComponent(fields.get(i)[2]);
        }

        hGroup.addGroup(labelGroup).addGroup(textFieldGroupA).addGroup(textFieldGroupB).addGroup(textFieldGroupC);
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        for (int i = 0; i < 10; i++) {
            vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labels.get(i))
                    .addComponent(fields.get(i)[0])
                    .addComponent(fields.get(i)[1])
                    .addComponent(fields.get(i)[2]));
        }
        layout.setVerticalGroup(vGroup);
        return panel;
    }

    private JPanel createTopPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(title);
        panel.add(rollStatsForMe);
        return panel;
    }
    private JPanel createBottomPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(returnToCharacterInfo);
        panel.add(saveAndContinueToSkills);
        return panel;
    }

    public int[] getStat(int i) {
        int[] output = new int[2];
        //fields.get(0)[0] er et JTextField object, og vi vil gerne læse teksten som står i det felt med getText()
        //Herefter skal det laves fra en String om til integers
        try {
            int valueA = Integer.parseInt(fields.get(i)[0].getText());
            int valueB = Integer.parseInt(fields.get(i)[1].getText());
            int valueC = Integer.parseInt(fields.get(i)[2].getText());
            output[0] = getMax(valueA, valueB, valueC);
            output[1] = getMiddle(valueA, valueB, valueC);
        } catch (Exception e) {

        }
        return output;
    }
    public int[] getAgility() {
        return getStat(0);
    }
    public int[] getConstitution() {
        return getStat(1);
    }
    public int[] getEmpathy() {
        return getStat(2);
    }
    public int[] getIntuition() {
        return getStat(3);
    }
    public int[] getMemory() {
        return getStat(4);
    }
    public int[] getPresence() {
        return getStat(5);
    }
    public int[] getQuickness() {
        return getStat(6);
    }
    public int[] getReasoning() {
        return getStat(7);
    }
    public int[] getSelfDiscipline() {
        return getStat(8);
    }
    public int[] getStrength() {
        return getStat(9);
    }
    public List<int[]> getStats() {
        List<int[]> output = new ArrayList<>();
        for (int i=0; i<10; i++) {
            output.add(getStat(i));
        }
        return output;
    }

    //Setter methods
    public void setStats(List<int[]> stats) {
        for (int i=0; i<10; i++) {
            fields.get(i)[0].setText(String.valueOf(stats.get(i)[0]));
            fields.get(i)[1].setText(String.valueOf(stats.get(i)[1]));
            fields.get(i)[2].setText(String.valueOf(stats.get(i)[2]));
        }
    }

    //Action Listeners
    public void returnToCharacterButtonClick (ActionListener actionListener) {
        returnToCharacterInfo.addActionListener(actionListener);
    }

    public void saveAndContinueButtonClick(ActionListener actionListener) {
        saveAndContinueToSkills.addActionListener(actionListener);
    }

    public void rollStatsForMeButtonClick (ActionListener actionListener) {
        rollStatsForMe.addActionListener(actionListener);
    }

    //Helper methods
    public void reset() {
        for (int i=0; i<10; i++) {
            fields.get(i)[0].setText("");
            fields.get(i)[1].setText("");
            fields.get(i)[2].setText("");
        }
    }

    private int getMax(int a, int b, int c) {
        return Math.max(a,Math.max(b,c));
    }

    private int getMiddle(int a, int b, int c) {
        if ((b <= a && a <= c) || (c <= a && a <= b)) return a;
        if ((a <= b && b <= c) || (c <= b && b<= a)) return b;
        return c;
    }
}
