package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TalentsAndFlawsView extends JPanel {

    private List<JLabel> labels;
    private List<JLabel> descriptions;
    private List<JTextField> fields;
    private JPanel detailPanel;
    private JSplitPane splitPane;
    private Map<String, Integer> selectedTalents;
    private JLabel pointsLabel;
    private int totalPoints = 10;
    private Map<String, String> talentDescriptionMap;

    public TalentsAndFlawsView(Map<String, String> talentDescriptionMap) {
        labels = new ArrayList<>();
        fields = new ArrayList<>();
        selectedTalents = new HashMap<>();
        this.talentDescriptionMap = talentDescriptionMap;
        addTalents();


        this.setLayout(new BorderLayout());
        this.add(createTopPanel(), BorderLayout.NORTH);

        // Opretter scroll pane for labels og tekstfelter
        JScrollPane scrollPane = createScrollPane();

        // Opretter detail panel
        detailPanel = new JPanel();
        detailPanel.setLayout(new BoxLayout(detailPanel, BoxLayout.Y_AXIS));
        detailPanel.add(new JLabel("Details will be shown here"));

        // Opretter split pane og tilføjer scroll pane og detail panel
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, detailPanel);
        splitPane.setResizeWeight(0.5); // Gør begge paneler lige store som standard

        this.add(splitPane, BorderLayout.CENTER);
        this.add(createBottomPanel(), BorderLayout.SOUTH);
    }

    private void showDetailPanel(String text) {
        detailPanel.removeAll();
        detailPanel.add(new JLabel(text));
        detailPanel.revalidate();
        detailPanel.repaint();
    }

    private JScrollPane createScrollPane() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // BoxLayout for vertikal layout

        for (int i = 0; i < labels.size(); i++) {
            JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            rowPanel.add(labels.get(i));
            rowPanel.add(fields.get(i));
            panel.add(rowPanel);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        return scrollPane;
    }

    private JPanel createTopPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel headerLabel = new JLabel("Choose your Talents");
        headerLabel.setFont(new Font("Serif", Font.BOLD, 24));
        pointsLabel = new JLabel("Points remaining: " + totalPoints);
        pointsLabel.setFont(new Font("Serif", Font.BOLD, 24));
        panel.add(headerLabel);
        panel.add(Box.createRigidArea(new Dimension(20, 0))); // Tilføjer lidt plads mellem overskriften og pointsLabel
        panel.add(pointsLabel);
        return panel;
    }

    private JPanel createBottomPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton saveButton = new JButton("Save Talents");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTalents();
            }
        });
        panel

                .add(saveButton);

        return panel;
    }

    private void updatePoints() {
        int usedPoints = 0;
        boolean overflow = false;

        for (JTextField field : fields) {
            try {
                int value = Integer.parseInt(field.getText());
                usedPoints += value;
            } catch (NumberFormatException e) {
                // Ignorerer fejl hvis tekstfeltet ikke indeholder et tal
            }
        }

        int remainingPoints = totalPoints - usedPoints;
        if (remainingPoints < 0) {
            remainingPoints = 0;
            overflow = true;

            // Fjern det indtastede for meget
            for (JTextField field : fields) {
                try {
                    int value = Integer.parseInt(field.getText());
                    if (usedPoints - value >= totalPoints) {
                        field.setText("");
                        usedPoints -= value;
                        break;
                    }
                } catch (NumberFormatException e) {
                    // Ignorerer fejl hvis tekstfeltet ikke indeholder et tal
                }
            }
        }

        pointsLabel.setText("Points remaining: " + remainingPoints);

        if (overflow) {
            // Viser fejlmeddelelse
            JOptionPane.showMessageDialog(this, "You have used all your Talent points.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    private void saveTalents() {
        selectedTalents.clear();
        for (int i = 0; i < labels.size(); i++) {
            String talentName = labels.get(i).getText();
            try {
                int value = Integer.parseInt(fields.get(i).getText());
                selectedTalents.put(talentName, value);
            } catch (NumberFormatException e) {
                // Ignorerer fejl hvis tekstfeltet ikke indeholder et tal
            }
        }
        // Du kan nu bruge selectedTalents, som indeholder de valgte talenter og deres værdier
        System.out.println("Selected Talents: " + selectedTalents);
    }

    // Metoder til at hente talenter baseret på deres position
    public int[] getSlowOnTheDraw() {
        return getTalents(0);
    }

    public int[] getHeavySleeper() {
        return getTalents(1);
    }

    public int[] getIngloriousFailure() {
        return getTalents(2);
    }

    public int[] getLesserAttack() {
        return getTalents(3);
    }

    public int[] getPoorHearing() {
        return getTalents(4);
    }

    public int[] getPoorSmell() {
        return getTalents(5);
    }

    public int[] getPoorTaste() {
        return getTalents(6);
    }

    public int[] getPoorTouch() {
        return getTalents(7);
    }

    public int[] getPoorVision() {
        return getTalents(8);
    }

    public int[] getRestrictedDiet() {
        return getTalents(9);
    }

    public int[] getLightSleeper() {
        return getTalents(10);
    }

    public int[] getQuickdrawQuickload() {
        return getTalents(11);
    }

    public int[] getDeadeye() {
        return getTalents(12);
    }

    public int[] getPressingTheAdvantage() {
        return getTalents(13);
    }

    public int[] getSharpshooter() {
        return getTalents(14);
    }

    public int[] getSenseWeakness() {
        return getTalents(15);
    }

    public int[] getFastAttack() {
        return getTalents(16);
    }

    public int[] getRiposte() {
        return getTalents(17);
    }

    public int[] getOpportunisticStrike() {
        return getTalents(18);
    }

    public int[] getFrenzy() {
        return getTalents(19);
    }

    public int[] getQuickCaster() {
        return getTalents(20);
    }

    public int[] getScopeSkills() {
        return getTalents(21);
    }

    public int[] getEloquence() {
        return getTalents(22);
    }

    public int[] getSpatialSkills() {
        return getTalents(23);
    }

    public int[] getExtendedReach() {
        return getTalents(24);
    }

    public int[] getSubconsciousDiscipline() {
        return getTalents(25);
    }

    public int[] getGracefulRecovery() {
        return getTalents(26);
    }

    public int[] getTemporalSkills() {
        return getTalents(27);
    }

    public int[] getMumbler() {
        return getTalents(28);
    }

    public int[] getPowerRecycling() {
        return getTalents(29);
    }

    public int[] getAmbidextrous() {
        return getTalents(30);
    }

    public int[] getBeastOfBurden() {
        return getTalents(31);
    }

    public int[] getSlowBleeder() {
        return getTalents(32);
    }

    public int[] getUncoordinated() {
        return getTalents(33);
    }

    public int[] getDarkvision() {
        return getTalents(34);
    }

    public int[] getDefensiveAura() {
        return getTalents(35);
    }

    public int[] getAdditionalLimbPair() {
        return getTalents(36);
    }

    public int[] getEfficientSleeper() {
        return getTalents(37);
    }

    public int[] getRestlessSleeper() {
        return getTalents(38);
    }

    public int[] getBreathHolding() {
        return getTalents(39);
    }

    public int[] getElementalResistance() {
        return getTalents(40);
    }

    public int[] getElementalSusceptibility() {
        return getTalents(41);
    }

    public int[] getHearingHare() {
        return getTalents(42);
    }

    public int[] getHeatsense() {
        return getTalents(43);
    }

    public int[] getEnhancedAttack() {
        return getTalents(44);
    }

    public int[] getFastHealer() {
        return getTalents(45);
    }

    public int[] getSlowHealer() {
        return getTalents(46);
    }

    public int[] getHearingCat() {
        return getTalents(47);
    }

    public int[] getHearingDog() {
        return getTalents(48);
    }

    public int[] getImmuneToDisease() {
        return getTalents(49);
    }

    public int[] getIncreasedSize() {
        return getTalents(50);
    }

    public int[] getDecreasedSize() {
        return getTalents(51);
    }

    public int[] getIncreasedStride() {
        return getTalents(52);
    }

    public int[] getDecreasedStride() {
        return getTalents(53);
    }

    public int[] getLightBoned() {
        return getTalents(54);
    }

    public int[] getLightSensitivity() {
        return getTalents(55);
    }

    public int[] getMagicalResistance() {
        return getTalents(56);
    }

    public int[] getMagicalVulnerability() {
        return getTalents(57);
    }

    public int[] getNaturalArmor() {
        return getTalents(58);
    }

    public int[] getNaturalWeaponry() {
        return getTalents(59);
    }

    public int[] getNightvision() {
        return getTalents(60);
    }

    public int[] getPhysicalResistance() {
        return getTalents(61);
    }

    public int[] getPhysicalVulnerability() {
        return getTalents(62);
    }

    public int[] getPoisonInjection() {
        return getTalents(63);
    }

    public int[] getRecurvedMusculature() {
        return getTalents(64);
    }

    public int[] getSightEagle() {
        return getTalents(65);
    }

    public int[] getSightGecko() {
        return getTalents(66);
    }

    public int[] getSightHawk() {
        return getTalents(67);
    }

    public int[] getStrikeReflex() {
        return getTalents(68);
    }

    public int[] getSuperiorStat() {
        return getTalents(69);
    }

    public int[] getInferiorStat() {
        return getTalents(70);
    }

    public int[] getTetrachromaticVision() {
        return getTalents(71);
    }

    public int[] getThirdEyelid() {
        return getTalents(72);
    }

    public int[] getTough() {
        return getTalents(73);
    }

    public int[] getFragile() {
        return getTalents(74);
    }

    public int[] getVigorous() {
        return getTalents(75);
    }

    public int[] getFeeble() {
        return getTalents(76);
    }

    public int[] getWingsVestigial() {
        return getTalents(77);
    }

    public int[] getAcuteHearing() {
        return getTalents(78);
    }

    public int[] getAcuteSmell() {
        return getTalents(79);
    }

    public int[] getAcuteTaste() {
        return getTalents(80);
    }

    public int[] getAcuteTouch() {
        return getTalents(81);
    }

    public int[] getAcuteVision() {
        return getTalents(82);
    }

    public int[] getAnimalEmpathy() {
        return getTalents(83);
    }

    public int[] getDestinySense() {
        return getTalents(84);
    }

    public int[] getDirectionSense() {
        return getTalents(85);
    }

    public int[] getEmpathy() {
        return getTalents(86);
    }

    public int[] getExtraSense() {
        return getTalents(87);
    }

    public int[] getMissingSense() {
        return getTalents(88);
    }

    public int[] getOneEye() {
        return getTalents(89);
    }

    public int[] getVisions() {
        return getTalents(90);
    }

    public int[] getDistinctOdor() {
        return getTalents(91);
    }

    public int[] getDisturbingVoice() {
        return getTalents(92);
    }

    public int[] getGoldenThroat() {
        return getTalents(93);
    }

    public int[] getIronWill() {
        return getTalents(94);
    }

    public int[] getLookOfEagles() {
        return getTalents(95);
    }

    public int[] getMathIlliterate() {
        return getTalents(96);
    }

    public int[] getMultilingual() {
        return getTalents(97);
    }

    public int[] getMute() {
        return getTalents(98);
    }

    public int[] getNeutralOdor() {
        return getTalents(99);
    }

    public int[] getNonViolent() {
        return getTalents(100);
    }

    public int[] getPerfectPitch() {
        return getTalents(101);
    }

    public int[] getProdigy() {
        return getTalents(102);
    }

    public int[] getInept() {
        return getTalents(103);
    }

    public int[] getRestrictedDiet2() {  // Forskellig navngivning, da Restricted Diet allerede findes
        return getTalents(104);
    }

    public int[] getRevulsion() {
        return getTalents(105);
    }

    private int[] getTalents(int i) {
        int[] output = new int[1]; // Ændret til at returnere én værdi
        try {
            output[0] = Integer.parseInt(fields.get(i).getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }


    public void addTalents() {
        for (String name : talentDescriptionMap.keySet()) {
            //Add the label
            JLabel label = new JLabel(name);
            labels.add(label);
            // Add the description
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    showDetailPanel(talentDescriptionMap.get(name));
                }
            });
            // Add the input field
            JTextField statField = new JTextField(3);
            statField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    updatePoints();
                }
            });
            fields.add(statField);
        }

    }
}