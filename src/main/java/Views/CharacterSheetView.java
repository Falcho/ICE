package Views;

import Models.CharacterSheet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class CharacterSheetView extends JPanel {
    JLabel title;
    JButton levelUp;
    JButton inventory;
    JButton spellBook;
    JButton skills;
    JButton returnButton;
    DefaultTableModel tableModel;
    private CharacterSheet model;
    String[] statBlockColumnNames = new String[]{"Stat", "Potent.", "Temp", "Bonus", "Racial", "Spec", "Total"};

    public CharacterSheetView(CharacterSheet model) {
        this.model = model;
        title = new JLabel("Character Sheet");
        levelUp = new JButton("Level Up");
        inventory = new JButton("Inventory");
        spellBook = new JButton("Spell Book");
        skills = new JButton("Skills");
        returnButton = new JButton("Return");

        this.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(mainPanel());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(buttonsPanel(), BorderLayout.SOUTH);

    }

    private JPanel mainPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(characterInfoPanel(), BorderLayout.NORTH);  // Place character info at the top
        panel.add(sheetPanel(), BorderLayout.CENTER);         // Other info in the center
        return panel;
    }

    private JPanel buttonsPanel() {
        // Create the main panel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Set common properties for buttons
        Dimension buttonSize = new Dimension(100, 25);
        returnButton.setPreferredSize(buttonSize);
        inventory.setPreferredSize(buttonSize);
        spellBook.setPreferredSize(buttonSize);
        skills.setPreferredSize(buttonSize);
        levelUp.setPreferredSize(buttonSize);

        // Add the left button
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(returnButton, gbc);

        // Add a horizontal spacer to push center panel to the middle
        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(Box.createHorizontalGlue(), gbc);

        // Add the center buttons in a separate panel with FlowLayout
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        centerPanel.add(inventory);
        centerPanel.add(spellBook);
        centerPanel.add(skills);

        gbc.gridx = 2;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(centerPanel, gbc);

        // Add a horizontal spacer to push right button to the end
        gbc.gridx = 3;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(Box.createHorizontalGlue(), gbc);

        // Add the right button
        gbc.gridx = 4;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(levelUp, gbc);

        return panel;
    }

    private JPanel sheetPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        // Upper Info Panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        panel.add(upperInfoPanel(), gbc);

        // Defence Panel
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        panel.add(defencePanel(), gbc);

        // Feats of Strength Panel
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(fosPanel(), gbc);

        // Movement Panel
        gbc.gridx = 1;
        panel.add(movementPanel(), gbc);

        return panel;
    }

    private JPanel characterInfoPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Character Information"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JLabel nameLabel = new JLabel("Character Name: " + getCharacterName());
        JLabel playerNameLabel = new JLabel("Player Name: " + getPlayerName());
        JLabel campaignLabel = new JLabel("Campaign: " + getCampaignName());
        JLabel levelLabel = new JLabel("Level: " + getCharacterLevel());
        JLabel xpLabel = new JLabel("Current XP: " + getCurrentXP());
        JLabel xpNextLevelLabel = new JLabel("XP for next level: " + getNextLvlXP());
        JLabel realmsLabel = new JLabel("Realms: " + getRealms());

        // Row 0
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nameLabel, gbc);
        gbc.gridx = 1;
        panel.add(playerNameLabel, gbc);
        gbc.gridx = 2;
        panel.add(campaignLabel, gbc);
        gbc.gridx = 3;
        panel.add(levelLabel, gbc);

        // Row 1
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(xpLabel, gbc);
        gbc.gridx = 1;
        panel.add(xpNextLevelLabel, gbc);
        gbc.gridx = 2;
        panel.add(realmsLabel, gbc);

        // Appearance Panel
        JPanel appearancePanel = new JPanel(new GridBagLayout());
        appearancePanel.setBorder(BorderFactory.createTitledBorder("Appearance"));
        GridBagConstraints appearanceGbc = new GridBagConstraints();
        appearanceGbc.insets = new Insets(5, 5, 5, 5);
        appearanceGbc.fill = GridBagConstraints.HORIZONTAL;
        appearanceGbc.weightx = 1.0;

        JLabel sexLabel = new JLabel("Gender:");
        JLabel ageLabel = new JLabel("Age:");
        JLabel heightLabel = new JLabel("Height:");
        JLabel weightLabel = new JLabel("Weight:");
        JLabel buildLabel = new JLabel("Build:");
        JLabel skinLabel = new JLabel("Skin:");
        JLabel hairLabel = new JLabel("Hair:");
        JLabel eyesLabel = new JLabel("Eyes:");

        // Add appearance fields
        appearanceGbc.gridx = 0;
        appearanceGbc.gridy = 0;
        appearancePanel.add(sexLabel, appearanceGbc);
        appearanceGbc.gridx = 1;
        appearancePanel.add(ageLabel, appearanceGbc);
        appearanceGbc.gridx = 2;
        appearancePanel.add(heightLabel, appearanceGbc);
        appearanceGbc.gridx = 3;
        appearancePanel.add(weightLabel, appearanceGbc);

        appearanceGbc.gridx = 0;
        appearanceGbc.gridy = 1;
        appearancePanel.add(buildLabel, appearanceGbc);
        appearanceGbc.gridx = 1;
        appearancePanel.add(skinLabel, appearanceGbc);
        appearanceGbc.gridx = 2;
        appearancePanel.add(hairLabel, appearanceGbc);
        appearanceGbc.gridx = 3;
        appearancePanel.add(eyesLabel, appearanceGbc);

        // Row 2 - Add Appearance Panel
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        panel.add(appearancePanel, gbc);

        // Background Panel
        JPanel backgroundPanel = new JPanel(new GridBagLayout());
        backgroundPanel.setBorder(BorderFactory.createTitledBorder("Background"));
        GridBagConstraints backgroundGbc = new GridBagConstraints();
        backgroundGbc.insets = new Insets(5, 5, 5, 5);
        backgroundGbc.fill = GridBagConstraints.HORIZONTAL;
        backgroundGbc.weightx = 1.0;

        JLabel raceLabel = new JLabel("Race: " + getRace());
        JLabel cultureLabel = new JLabel("Culture: " + getCulture());
        JLabel professionLabel = new JLabel("Profession: " + getProfession());

        // Add background fields
        backgroundGbc.gridx = 0;
        backgroundGbc.gridy = 0;
        backgroundPanel.add(raceLabel, backgroundGbc);
        backgroundGbc.gridx = 1;
        backgroundPanel.add(cultureLabel, backgroundGbc);
        backgroundGbc.gridx = 2;
        backgroundPanel.add(professionLabel, backgroundGbc);

        // Row 3 - Add Background Panel
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        panel.add(backgroundPanel, gbc);

        return panel;
    }


    private JPanel upperInfoPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2; // Span 2 rows
        panel.add(statsPanel(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        panel.add(encumbrancePanel(), gbc);

        gbc.gridy = 1;
        panel.add(quickInfoPanel(), gbc);

        return panel;
    }

    private JPanel statsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Statistics"));
        tableModel = new DefaultTableModel(model.getStatBlock(), statBlockColumnNames);
        JTable statsTable = new JTable(tableModel);
        /*TableColumn statsColumn;
        for (int i = 1; i < tableModel.getColumnCount(); i++) {
            statsColumn = statsTable.getColumnModel().getColumn(i);
            statsColumn.setPreferredWidth(70);
        }
        statsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);*/
        statsTable.setPreferredScrollableViewportSize(statsTable.getMinimumSize());

        JScrollPane scrollPane = new JScrollPane(statsTable);
        panel.add(scrollPane);
        return panel;
    }

    private JPanel encumbrancePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Encumbrance"));
        return panel;
    }

    private JPanel quickInfoPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Quick Info"));
        return panel;
    }

    private JPanel defencePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Defense"));
        return panel;
    }

    private JPanel fosPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Feats of Strength"));
        return panel;
    }

    private JPanel movementPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Movement"));
        return panel;
    }


    private String getCharacterName() {
        if (this.model!=null) {
            return model.getName();
        }
        return "";
    }
    private String getPlayerName() {
        if (this.model!=null) {
            //return model.getPlayerName();
        }
        return "";
    }
    private String getCampaignName(){
        if (this.model!=null) {
            //return model.getCampaignName();
        }
        return "";
    }
    private String getCharacterLevel() {
        if (this.model!=null) {
            return String.valueOf(model.getLevel());
        }
        return "";
    }
    private String getCurrentXP() {
        if (this.model!=null) {
            return String.valueOf(model.getXp());
        }
        return "";
    }
    private String getNextLvlXP() {
        if (this.model!=null) {
            //return Rules.NextLvlXP(model.getLevel());
        }
        return "";
    }
    private String getRealms() {
        if (this.model!=null) {
            //return model.getRealms();
        }
        return "";
    }
    private String getRace() {
        if (this.model!=null && this.model.getRace()!=null) {
            return model.getRace().getName();
        }
        return "";
    }
    private String getCulture() {
        if (this.model!=null && this.model.getCulture()!=null) {
            return model.getCulture().getName();
        }
        return "";
    }
    private String getProfession() {
        if (this.model!=null && this.model.getProfession()!=null) {
            return model.getProfession().getName();
        }
        return "";
    }
    private void updateStatBlock() {
        tableModel.setDataVector(model.getStatBlock(),statBlockColumnNames);
        tableModel.fireTableDataChanged();
    }



    public void setModel(CharacterSheet model) {
        this.model = model;
    }

}
