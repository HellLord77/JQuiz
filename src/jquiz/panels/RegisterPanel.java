/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package jquiz.panels;

import jquiz.MainFrame;
import jquiz.swing.JDebouncedInputValidator;

/**
 *
 * @author ratul
 */
public class RegisterPanel extends javax.swing.JPanel {

    private MainFrame mainFrame;

    public JDebouncedInputValidator nameTextFieldValidator;
    public JDebouncedInputValidator emailTextFieldValidator;
    public JDebouncedInputValidator passwordPasswordFieldValidator;
    public JDebouncedInputValidator passwordConfirmPasswordFieldValidator;

    /**
     * Creates new form RegisterPanel
     */
    public RegisterPanel() {
        initComponents();
    }

    public RegisterPanel(MainFrame mainFrame) {
        this();
        setVisible(false);
        this.mainFrame = mainFrame;

        nameTextFieldValidator = new JDebouncedInputValidator(nameTextField) {
            @Override
            protected com.alexandriasoftware.swing.Validation getDebouncedValidation(
                    javax.swing.JComponent input, com.alexandriasoftware.swing.JInputValidatorPreferences preferences) {
                return nameTextFieldGetDebouncedValidation(input, preferences);
            }
        };

        emailTextFieldValidator = new JDebouncedInputValidator(emailTextField) {
            @Override
            protected com.alexandriasoftware.swing.Validation getDebouncedValidation(
                    javax.swing.JComponent input, com.alexandriasoftware.swing.JInputValidatorPreferences preferences) {
                return emailTextFieldGetDebouncedValidation(input, preferences);
            }
        };

        passwordPasswordFieldValidator = new JDebouncedInputValidator(passwordPasswordField) {
            @Override
            protected com.alexandriasoftware.swing.Validation getDebouncedValidation(
                    javax.swing.JComponent input, com.alexandriasoftware.swing.JInputValidatorPreferences preferences) {
                return passwordPasswordFieldGetDebouncedValidation(input, preferences);
            }
        };

        passwordConfirmPasswordFieldValidator = new JDebouncedInputValidator(passwordConfirmPasswordField) {
            @Override
            protected com.alexandriasoftware.swing.Validation getDebouncedValidation(
                    javax.swing.JComponent input, com.alexandriasoftware.swing.JInputValidatorPreferences preferences) {
                return passwordConfirmPasswordFieldGetDebouncedValidation(input, preferences);
            }
        };

        javax.swing.event.DocumentListener registerButtonDocumentListener = new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent evt) {
                registerButtonDocumentUpdate(evt);
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent evt) {
                registerButtonDocumentUpdate(evt);
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent evt) {
                registerButtonDocumentUpdate(evt);
            }
        };

        nameTextField.getDocument().addDocumentListener(registerButtonDocumentListener);
        emailTextField.getDocument().addDocumentListener(registerButtonDocumentListener);
        passwordPasswordField.getDocument().addDocumentListener(registerButtonDocumentListener);
        passwordConfirmPasswordField.getDocument().addDocumentListener(registerButtonDocumentListener);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordPasswordField = new javax.swing.JPasswordField();
        passwordConfirmLabel = new javax.swing.JLabel();
        passwordConfirmPasswordField = new javax.swing.JPasswordField();
        actionPanel = new javax.swing.JPanel();
        registerButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        showCheckBox = new javax.swing.JCheckBox();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        nameLabel.setText("Username:");

        emailLabel.setText("E-mail address:");

        passwordLabel.setText("Password:");

        passwordConfirmLabel.setText("Password again:");

        javax.swing.GroupLayout inputPanelLayout = new javax.swing.GroupLayout(inputPanel);
        inputPanel.setLayout(inputPanelLayout);
        inputPanelLayout.setHorizontalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passwordLabel)
                    .addComponent(emailLabel)
                    .addComponent(nameLabel)
                    .addComponent(passwordConfirmLabel))
                .addGap(18, 18, 18)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passwordPasswordField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailTextField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordConfirmPasswordField, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        inputPanelLayout.setVerticalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordConfirmLabel)
                    .addComponent(passwordConfirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        showCheckBox.setText("Show password");
        showCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout actionPanelLayout = new javax.swing.GroupLayout(actionPanel);
        actionPanel.setLayout(actionPanelLayout);
        actionPanelLayout.setHorizontalGroup(
            actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, actionPanelLayout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(registerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(90, Short.MAX_VALUE))
            .addGroup(actionPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(showCheckBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        actionPanelLayout.setVerticalGroup(
            actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, actionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showCheckBox)
                .addGap(18, 18, 18)
                .addGroup(actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerButton)
                    .addComponent(backButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(actionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(inputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(actionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        mainFrame.registerPanelFormComponentHidden(evt);
    }//GEN-LAST:event_formComponentHidden

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        mainFrame.registerPanelFormComponentShown(evt);
    }//GEN-LAST:event_formComponentShown

    private void showCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showCheckBoxActionPerformed
        mainFrame.registerPanelShowCheckBoxActionPerformed(evt);
    }//GEN-LAST:event_showCheckBoxActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        mainFrame.registerPanelRegisterButtonActionPerformed(evt);
    }//GEN-LAST:event_registerButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        mainFrame.registerPanelBackButtonActionPerformed(evt);
    }//GEN-LAST:event_backButtonActionPerformed

    private com.alexandriasoftware.swing.Validation nameTextFieldGetDebouncedValidation(
            javax.swing.JComponent input, com.alexandriasoftware.swing.JInputValidatorPreferences preferences) {
        return mainFrame.registerPanelNameTextFieldGetDebouncedValidation(input, preferences);
    }

    private com.alexandriasoftware.swing.Validation emailTextFieldGetDebouncedValidation(
            javax.swing.JComponent input, com.alexandriasoftware.swing.JInputValidatorPreferences preferences) {
        return mainFrame.registerPanelEmailTextFieldGetDebouncedValidation(input, preferences);
    }

    private com.alexandriasoftware.swing.Validation passwordPasswordFieldGetDebouncedValidation(
            javax.swing.JComponent input, com.alexandriasoftware.swing.JInputValidatorPreferences preferences) {
        return mainFrame.registerPanelPasswordPasswordFieldGetDebouncedValidation(input, preferences);
    }

    private com.alexandriasoftware.swing.Validation passwordConfirmPasswordFieldGetDebouncedValidation(
            javax.swing.JComponent input, com.alexandriasoftware.swing.JInputValidatorPreferences preferences) {
        return mainFrame.registerPanelPasswordConfirmPasswordFieldGetDebouncedValidation(input, preferences);
    }

    private void registerButtonDocumentUpdate(javax.swing.event.DocumentEvent evt) {
        mainFrame.registerPanelRegisterButtonDocumentUpdate(evt);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionPanel;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel emailLabel;
    public javax.swing.JTextField emailTextField;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JLabel nameLabel;
    public javax.swing.JTextField nameTextField;
    private javax.swing.JLabel passwordConfirmLabel;
    public javax.swing.JPasswordField passwordConfirmPasswordField;
    private javax.swing.JLabel passwordLabel;
    public javax.swing.JPasswordField passwordPasswordField;
    public javax.swing.JButton registerButton;
    public javax.swing.JCheckBox showCheckBox;
    // End of variables declaration//GEN-END:variables
}
