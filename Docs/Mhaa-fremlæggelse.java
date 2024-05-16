package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CreateStatsView extends JPanel {

    private final JLabel title;
    private final List<JLabel> labels;
    private final List<JTextField[]> fields;

    private final JButton previousButton;
    private final JButton continueButton;
    private final JButton rollStatsForMe;

    public CreateStatsView() {
        //Initialize all components
        title = new JLabel("Generate Stats");
        labels = new ArrayList<>();
        fields = new ArrayList<>();
        labels.add(new JLabel("Agility (Ag)"));
        ...
        labels.add(new JLabel("Strength (St)"));
        for (int i=0; i<10; i++) {
            JTextField[] statFields = new JTextField[3];
            statFields[0] = new JTextField(3);
            statFields[1] = new JTextField(3);
            statFields[2] = new JTextField(3);
            fields.add(statFields);

        }
        previousButton = new JButton("Return to Character Info");
        continueButton = new JButton("Continue to Skills");
        rollStatsForMe = new JButton("Roll Stats For Me");

        this.setLayout(new BorderLayout());

        this.add(createTopPanel(), BorderLayout.NORTH);
        this.add(createMiddlePanel(),BorderLayout.CENTER);
        this.add(createBottomPanel(), BorderLayout.SOUTH);

    }

    private JPanel createMiddlePanel() {
        ...
    }

    private JPanel createTopPanel() {
        ...
    }
    private JPanel createBottomPanel() {
        ...
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
    public void previousButtonClick(ActionListener actionListener) {
        previousButton.addActionListener(actionListener);
    }

    public void continueButtonClick(ActionListener actionListener) {
        continueButton.addActionListener(actionListener);
    }

    public void rollStatsForMeButtonClick (ActionListener actionListener) {
        rollStatsForMe.addActionListener(actionListener);
    }

    //Helper methods

    private int getMax(int a, int b, int c) {
        return Math.max(a,Math.max(b,c));
    }

    private int getMiddle(int a, int b, int c) {
        if ((b <= a && a <= c) || (c <= a && a <= b)) return a;
        if ((a <= b && b <= c) || (c <= b && b<= a)) return b;
        return c;
    }
}
