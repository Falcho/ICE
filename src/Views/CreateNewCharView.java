package Views;

import javax.swing.*;
import java.awt.*;

public class CreateNewCharView extends JPanel {
    private JLabel title;
    private JTextField nameField;
    private JLabel label;

    private JButton saveAndContinueButton;

    public CreateNewCharView() {
        //initialize all components
        title = new JLabel("Create a new character");
        label = new JLabel("Enter character name: ");
        nameField = new JTextField(10);
        saveAndContinueButton = new JButton("Save and continue to Profession");

        this.setLayout(new BorderLayout());

        this.add(createTopPanel(), BorderLayout.NORTH);
        this.add(createMiddlePanel(), BorderLayout.CENTER);
        this.add(createBottomPanel(), BorderLayout.SOUTH);
    }

    private JPanel createTopPanel() {
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(title);
        return topPanel;
    }
    private JPanel createMiddlePanel() {
        JPanel middlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        middlePanel.add(label);
        middlePanel.add(nameField);
        return middlePanel;
    }
    //Nedenstående kode er et groupLayout
    /*private JPanel createMiddlePanel() {
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        GroupLayout.ParallelGroup labelGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        GroupLayout.ParallelGroup textFieldGroupA = layout.createParallelGroup(GroupLayout.Alignment.LEADING);



            labelGroup.addComponent(label);
            textFieldGroupA.addComponent(nameField);


        hGroup.addGroup(labelGroup).addGroup(textFieldGroupA);
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

            vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(label)
                    .addComponent(nameField));

        layout.setVerticalGroup(vGroup);
        return panel;
    }*/

    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(saveAndContinueButton);
        return bottomPanel;
    }



}
