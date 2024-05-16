package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartMenuView extends JPanel {

    private JPanel buttonPanel;

    private JButton createNewButton;

    private JButton loadExistingButton;

    public StartMenuView(){
        this.setLayout(new BorderLayout());
        JLabel logo = new JLabel(new ImageIcon("data/android-chrome-512x512.png"));
        this.add(logo, BorderLayout.NORTH);
        GridBagLayout layout= new GridBagLayout();
        JPanel panel = new JPanel(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.anchor=GridBagConstraints.CENTER;
        panel.add(createButtonPanel(),gbc);
        this.add(panel,BorderLayout.CENTER);
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
