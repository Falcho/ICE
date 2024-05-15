package Views;

import Models.Race;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ChooseRaceView {
    private JPanel chooseNewRaceView;
    private JComboBox chooseRace;
    private JLabel racialTalentFlaw;
    private JTextArea raceTAFText;
    private JTextArea raceSizeText;
    private JTextArea raceStatBonusText;
    private JTextArea raceResistanceText;
    private JTextArea raceHPandDevelopText;
    private JTextArea raceDescription;
    private JLabel title;
    private JButton goToCulture;
    private JButton previous;
    private JPanel titleAndDropdownPanel;
    private JPanel raceDescriptionPanel;
    private JPanel rightPanel;
    private JPanel racialTalentFlawPanel;
    private JPanel raceSizePanel;
    private JPanel raceStatBonusPanel;
    private JPanel raceResistancePanel;
    private JPanel raceHealthAndDevPanel;
    private JPanel buttonPanel;

    public ChooseRaceView() {
        Map<String, Race> availableRaces = new HashMap<>();
        availableRaces.put("High Elf", new Race("High Elf",0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0));
        for(String raceName : availableRaces.keySet()) {
            chooseRace.addItem(raceName);
        }
        chooseRace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseRace.getSelectedItem();
                String raceName = chooseRace.getSelectedItem().toString();
                raceTAFText.setText(raceName);
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new ChooseRaceView().chooseNewRaceView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

    public void setChooseNewRaceView(JPanel chooseNewRaceView) {
        this.chooseNewRaceView = chooseNewRaceView;
    }

    public void setChooseRace(JComboBox chooseRace) {
        this.chooseRace = chooseRace;
    }

    public void setRacialTalentFlaw(JLabel racialTalentFlaw) {
        this.racialTalentFlaw = racialTalentFlaw;
    }

    public void setRaceTAFText(JTextArea raceTAFText) {
        this.raceTAFText = raceTAFText;
    }

    public void setRaceSizeText(JTextArea raceSizeText) {
        this.raceSizeText = raceSizeText;
    }

    public void setRaceStatBonusText(JTextArea raceStatBonusText) {
        this.raceStatBonusText = raceStatBonusText;
    }

    public void setRaceResistanceText(JTextArea raceResistanceText) {
        this.raceResistanceText = raceResistanceText;
    }

    public void setRaceHPandDevelopText(JTextArea raceHPandDevelopText) {
        this.raceHPandDevelopText = raceHPandDevelopText;
    }

    public void setRaceDescription(JTextArea raceDescription) {
        this.raceDescription = raceDescription;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }

    public void setGoToCulture(JButton goToCulture) {
        this.goToCulture = goToCulture;
    }

    public void setPrevious(JButton previous) {
        this.previous = previous;
    }

    public void setTitleAndDropdownPanel(JPanel titleAndDropdownPanel) {
        this.titleAndDropdownPanel = titleAndDropdownPanel;
    }

    public void setRaceDescriptionPanel(JPanel raceDescriptionPanel) {
        this.raceDescriptionPanel = raceDescriptionPanel;
    }

    public void setRightPanel(JPanel rightPanel) {
        this.rightPanel = rightPanel;
    }

    public void setRacialTalentFlawPanel(JPanel racialTalentFlawPanel) {
        this.racialTalentFlawPanel = racialTalentFlawPanel;
    }

    public void setRaceSizePanel(JPanel raceSizePanel) {
        this.raceSizePanel = raceSizePanel;
    }

    public void setRaceStatBonusPanel(JPanel raceStatBonusPanel) {
        this.raceStatBonusPanel = raceStatBonusPanel;
    }

    public void setRaceResistancePanel(JPanel raceResistancePanel) {
        this.raceResistancePanel = raceResistancePanel;
    }

    public void setRaceHealthAndDevPanel(JPanel raceHealthAndDevPanel) {
        this.raceHealthAndDevPanel = raceHealthAndDevPanel;
    }

    public void setButtonPanel(JPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
    }
}
