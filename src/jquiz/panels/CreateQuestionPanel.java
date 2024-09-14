/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package jquiz.panels;

import jquiz.Util;

/**
 *
 * @author ratul
 */
public class CreateQuestionPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateQuestionPanel
     */
    public CreateQuestionPanel() {
        initComponents();
    }

    public boolean[] componentsAreInvalid() {
        boolean textInvalid = textTextField.getText().isBlank();
        boolean hintInvalid = hintTextArea.getText().isBlank();

        String option0 = option0TextField.getText();
        String option1 = option1TextField.getText();
        String option2 = option2TextField.getText();
        String option3 = option3TextField.getText();

        boolean option0Invalid = option0.isBlank();
        boolean option1Invalid = option1.isBlank();
        boolean option2Invalid = option2.isBlank();
        boolean option3Invalid = option3.isBlank();
        boolean optionInvalid = !Util.unique(new String[]{option0.strip(),
            option1.strip(), option2.strip(), option3.strip()});

        boolean optionsInvalid = optionsButtonGroup.getSelection() == null;

        return new boolean[]{textInvalid, hintInvalid, option0Invalid, option1Invalid,
            option2Invalid, option3Invalid, optionInvalid, optionsInvalid};
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        optionsButtonGroup = new javax.swing.ButtonGroup();
        nLabel = new javax.swing.JLabel();
        textLabel = new javax.swing.JLabel();
        textTextField = new javax.swing.JTextField();
        hintLabel = new javax.swing.JLabel();
        hintScrollPane = new javax.swing.JScrollPane();
        hintTextArea = new javax.swing.JTextArea();
        optionsPanel = new javax.swing.JPanel();
        option0Panel = new javax.swing.JPanel();
        option0RadioButton = new javax.swing.JRadioButton();
        option0TextField = new javax.swing.JTextField();
        option1Panel = new javax.swing.JPanel();
        option1RadioButton = new javax.swing.JRadioButton();
        option1TextField = new javax.swing.JTextField();
        option2Panel = new javax.swing.JPanel();
        option2RadioButton = new javax.swing.JRadioButton();
        option2TextField = new javax.swing.JTextField();
        option3Panel = new javax.swing.JPanel();
        option3RadioButton = new javax.swing.JRadioButton();
        option3TextField = new javax.swing.JTextField();

        setBorder(new javax.swing.border.LineBorder(java.awt.Color.gray, 1, true));

        nLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nLabel.setText("%n.");

        textLabel.setText("Text:");

        hintLabel.setText("Hint:");

        hintTextArea.setColumns(20);
        hintTextArea.setLineWrap(true);
        hintTextArea.setRows(3);
        hintTextArea.setWrapStyleWord(true);
        hintScrollPane.setViewportView(hintTextArea);

        optionsPanel.setLayout(new java.awt.GridLayout(2, 2));

        optionsButtonGroup.add(option0RadioButton);
        option0RadioButton.setActionCommand("0");

        javax.swing.GroupLayout option0PanelLayout = new javax.swing.GroupLayout(option0Panel);
        option0Panel.setLayout(option0PanelLayout);
        option0PanelLayout.setHorizontalGroup(
            option0PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(option0PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(option0RadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(option0TextField)
                .addContainerGap())
        );
        option0PanelLayout.setVerticalGroup(
            option0PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(option0PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(option0PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(option0TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(option0RadioButton))
                .addContainerGap())
        );

        optionsPanel.add(option0Panel);

        optionsButtonGroup.add(option1RadioButton);
        option1RadioButton.setActionCommand("1");

        javax.swing.GroupLayout option1PanelLayout = new javax.swing.GroupLayout(option1Panel);
        option1Panel.setLayout(option1PanelLayout);
        option1PanelLayout.setHorizontalGroup(
            option1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(option1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(option1RadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(option1TextField)
                .addContainerGap())
        );
        option1PanelLayout.setVerticalGroup(
            option1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(option1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(option1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(option1TextField)
                    .addComponent(option1RadioButton))
                .addContainerGap())
        );

        optionsPanel.add(option1Panel);

        optionsButtonGroup.add(option2RadioButton);
        option2RadioButton.setActionCommand("2");

        javax.swing.GroupLayout option2PanelLayout = new javax.swing.GroupLayout(option2Panel);
        option2Panel.setLayout(option2PanelLayout);
        option2PanelLayout.setHorizontalGroup(
            option2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(option2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(option2RadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(option2TextField)
                .addContainerGap())
        );
        option2PanelLayout.setVerticalGroup(
            option2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(option2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(option2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(option2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(option2RadioButton))
                .addContainerGap())
        );

        optionsPanel.add(option2Panel);

        optionsButtonGroup.add(option3RadioButton);
        option3RadioButton.setActionCommand("3");

        javax.swing.GroupLayout option3PanelLayout = new javax.swing.GroupLayout(option3Panel);
        option3Panel.setLayout(option3PanelLayout);
        option3PanelLayout.setHorizontalGroup(
            option3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(option3PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(option3RadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(option3TextField)
                .addContainerGap())
        );
        option3PanelLayout.setVerticalGroup(
            option3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(option3PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(option3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(option3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(option3RadioButton))
                .addContainerGap())
        );

        optionsPanel.add(option3Panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(hintLabel)
                            .addComponent(textLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hintScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                            .addComponent(textTextField))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textLabel)
                    .addComponent(nLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hintLabel)
                    .addComponent(hintScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(optionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hintLabel;
    private javax.swing.JScrollPane hintScrollPane;
    public javax.swing.JTextArea hintTextArea;
    public javax.swing.JLabel nLabel;
    private javax.swing.JPanel option0Panel;
    public javax.swing.JRadioButton option0RadioButton;
    public javax.swing.JTextField option0TextField;
    private javax.swing.JPanel option1Panel;
    public javax.swing.JRadioButton option1RadioButton;
    public javax.swing.JTextField option1TextField;
    private javax.swing.JPanel option2Panel;
    public javax.swing.JRadioButton option2RadioButton;
    public javax.swing.JTextField option2TextField;
    private javax.swing.JPanel option3Panel;
    public javax.swing.JRadioButton option3RadioButton;
    public javax.swing.JTextField option3TextField;
    public javax.swing.ButtonGroup optionsButtonGroup;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JLabel textLabel;
    public javax.swing.JTextField textTextField;
    // End of variables declaration//GEN-END:variables
}
