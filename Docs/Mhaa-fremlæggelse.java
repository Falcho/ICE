package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
// jeg har kodet en klasse, som skal kunne vise stats i vores program
public class CreateStatsView extends JPanel {

    // gui elementer
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
        //køre igennem statsfields
        // har et forloop hvor jeg har statfields, som bliver tilføjet til min fields arrayListe
        for (int i=0; i<10; i++) {
            JTextField[] statFields = new JTextField[3];
            //tilføjer textfields til statfield
            statFields[0] = new JTextField(3);
            statFields[1] = new JTextField(3);
            statFields[2] = new JTextField(3);
            fields.add(statFields);

        }
        previousButton = new JButton("Return to Character Info");
        continueButton = new JButton("Continue to Skills");
        rollStatsForMe = new JButton("Roll Stats For Me");

        this.setLayout(new BorderLayout());
        // laver layouttet, det vil sige placere gui elementer de rigtige steder på skærmen. Det gør de tre metoder også
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
        //Herefter skal det laves fra en String om til integer
        // jeg tager teksten fra mit field, og parser den til en integer, og det gør jeg tre gange
        try {
            int valueA = Integer.parseInt(fields.get(i)[0].getText());
            int valueB = Integer.parseInt(fields.get(i)[1].getText());
            int valueC = Integer.parseInt(fields.get(i)[2].getText());
            //Vi har tre værdier, og skal kun bruge 2 af dem som er den største og den miderste
            output[0] = getMax(valueA, valueB, valueC);
            output[1] = getMiddle(valueA, valueB, valueC);
        } catch (Exception e) {

        }
        return output;
    }
//getStats metoden returnere en liste af integer[]. den bruger en forloop, til at tilføje alle 10 stats
    //til listen ved hjælp af getStat metoden
    public List<int[]> getStats() {
        List<int[]> output = new ArrayList<>();
        for (int i=0; i<10; i++) {
            output.add(getStat(i));
        }
        return output;
    }

    //Setter methods
   // tager argument List<int>...
    public void setStats(List<int[]> stats) {
        for (int i=0; i<10; i++) {
            // jeg tager integer fra [] og laver om til en String, som jeg så sætter, ind i tekfeltet, ved hjælp af
            //settekst metoden
            fields.get(i)[0].setText(String.valueOf(stats.get(i)[0]));
            fields.get(i)[1].setText(String.valueOf(stats.get(i)[1]));
            fields.get(i)[2].setText(String.valueOf(stats.get(i)[2]));
        }
    }

    //STOP HER

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
