package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartMenuView extends JPanel {

    private JPanel buttonPanel;

    private JButton createNewButton;

    private JButton loadExistingButton;

    public StartMenuView(){
        GridBagLayout layout= new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.anchor=GridBagConstraints.CENTER;
        this.add(createButtonPanel(),gbc);
    }

    private JPanel createButtonPanel(){
        buttonPanel=new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        createNewButton= new JButton("Create New Character");
        loadExistingButton=new JButton("Load Character");
        buttonPanel.add(createNewButton);
        buttonPanel.add(loadExistingButton);
        return buttonPanel;
    }

    public void createNewClick(ActionListener actionListener){
        createNewButton.addActionListener(actionListener);
    }

    public void loadCharacterClick(ActionListener actionListener){
        loadExistingButton.addActionListener(actionListener);
    }






}
