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
    private List<JTextField> fields;
    private JPanel detailPanel;
    private JSplitPane splitPane;
    private Map<String, Integer> selectedTalents;
    private JLabel pointsLabel;
    private int totalPoints = 10;
    private Map<String, String> talentDescriptionMap;
    private JButton previousButton;
    private JButton continueButton;



    public TalentsAndFlawsView(Map<String, String> talentDescriptionMap) {
        labels = new ArrayList<>();
        fields = new ArrayList<>();
        selectedTalents = new HashMap<>();
        this.talentDescriptionMap = talentDescriptionMap;
        addTalents();

        this.setLayout(new BorderLayout());
        this.add(createTopPanel(), BorderLayout.NORTH);

        JScrollPane scrollPane = createScrollPane();
        detailPanel = new JPanel();
        detailPanel.setLayout(new BoxLayout(detailPanel, BoxLayout.Y_AXIS));
        detailPanel.add(new JLabel("<html><body style='width: 200px'>Details will be shown here</body></html>"));

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, detailPanel);
        splitPane.setResizeWeight(0.5);

        this.add(splitPane, BorderLayout.CENTER);
        this.add(createBottomPanel(), BorderLayout.SOUTH);
    }


// opdatere detaljepanelet baseret på brugerinteraktioner.
    private void showDetailPanel(String text) {
        detailPanel.removeAll();
        JLabel detailLabel = new JLabel("<html><body style='width: 250px'>" + escapeHtml(text) + "</body></html>");
        detailPanel.add(detailLabel);
        detailPanel.revalidate();
        detailPanel.repaint();
    }


// opretter scroll bar.
    private JScrollPane createScrollPane() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//
        for (int i = 0; i < labels.size(); i++) {
            JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            rowPanel.add(labels.get(i));
            rowPanel.add(fields.get(i));
            panel.add(rowPanel);
        }

        return new JScrollPane(panel);
    }



    private JPanel createTopPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel headerLabel = new JLabel("Choose your Talents");
        headerLabel.setFont(new Font("Serif", Font.BOLD, 24));
        pointsLabel = new JLabel("Points remaining: " + totalPoints);
        pointsLabel.setFont(new Font("Serif", Font.BOLD, 24));
        panel.add(headerLabel);
        panel.add(Box.createRigidArea(new Dimension(20, 0)));
        panel.add(pointsLabel);
        return panel;
    }



    private JPanel createBottomPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        previousButton = new JButton("Return to Culture");
        panel.add(previousButton, BorderLayout.WEST);

        continueButton = new JButton("Continue to Stats");
        panel.add(continueButton, BorderLayout.EAST);

        return panel;
    }

    public void continueButtonClick(ActionListener actionListener) {
        continueButton.addActionListener(actionListener);
    }

    public void previousButtonClick(ActionListener actionListener) {
        previousButton.addActionListener(actionListener);
    }




    private void addTalents() {
        for (String name : talentDescriptionMap.keySet()) {
            JLabel label = new JLabel("<html><body style='width: 150px'>" + escapeHtml(name) + "</body></html>");
            labels.add(label);
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    showDetailPanel(talentDescriptionMap.get(name));
                }
            });

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



    private void updatePoints() {
        int usedPoints = 0;
        for (JTextField field : fields) {
            try {
                int value = Integer.parseInt(field.getText());
                usedPoints += value;
            } catch (NumberFormatException e) {

            }
        }



        int remainingPoints = totalPoints - usedPoints;
        if (remainingPoints < 0) {
            remainingPoints = 0;
            // Tilbagestill overskydende pointindtastninger
            for (JTextField field : fields) {
                try {
                    int value = Integer.parseInt(field.getText());
                    if (usedPoints - value >= totalPoints) {
                        field.setText("0");  // Sætter feltet til 0, hvis det bidrager til overskridelse
                        usedPoints -= value;
                    }
                } catch (NumberFormatException e) {

                }
            }
        }


         // Viser en dialogboks, hvis der ikke er flere tilgængelige point
        pointsLabel.setText("Points remaining: " + remainingPoints);
        if (remainingPoints == 0) {

            JOptionPane.showMessageDialog(this, "You have used all your points.", "No Points Remaining", JOptionPane.WARNING_MESSAGE);
        }
    }



    public void saveTalents() {
        selectedTalents.clear();
        for (int i = 0; i < labels.size(); i++) {
            String talentName = labels.get(i).getText().replaceAll("<html><body style='width: 150px'>|</body></html>", "");
            try {
                int value = Integer.parseInt(fields.get(i).getText());
                selectedTalents.put(talentName, value);
            } catch (NumberFormatException e) {

            }
        }
        System.out.println("Selected Talents: " + selectedTalents);
    }



    private String escapeHtml(String text) {
        return text.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}