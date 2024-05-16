package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateBackgroundView extends JPanel {

    private JLabel titleLabel;
    private JTextArea textArea;
    private JPanel buttonPanel;
    private JButton previousButton;
    private JButton continueButton;


    public CreateBackgroundView(){
        this.setLayout(new BorderLayout());
        titleLabel= new JLabel("Create background",SwingConstants.CENTER);
        this.add(titleLabel,BorderLayout.NORTH);
        textArea = new JTextArea();
        this.add(new JScrollPane(textArea),BorderLayout.CENTER);
        buttonPanel= createButtonPanel();
        this.add(buttonPanel,BorderLayout.SOUTH);
    }
    public JPanel createButtonPanel(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
        previousButton=new JButton("Return to generate stats");
        continueButton=new JButton("Continue to character sheet");
        panel.add(previousButton);
        panel.add(continueButton);
        return panel;
    }

    public void previousButtonClick(ActionListener actionListener){
        previousButton.addActionListener(actionListener);

    }
    public void continueButtonClick(ActionListener actionListener){
        continueButton.addActionListener(actionListener);
    }


    public String getWrittenBackground(){
        return textArea.getText();
    }


}
