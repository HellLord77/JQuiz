/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jquiz.swing;

import com.alexandriasoftware.swing.JInputValidator;
import com.alexandriasoftware.swing.JInputValidatorPreferences;
import com.alexandriasoftware.swing.Validation;
import java.awt.event.ActionEvent;
import javax.swing.JComponent;
import javax.swing.Timer;
import jquiz.Const;

/**
 *
 * @author ratul
 */
public abstract class JDebouncedInputValidator extends JInputValidator {

    private Timer timer;

    private boolean debounced = false;

    public JDebouncedInputValidator(JComponent component) {
        super(component);
        timer = new Timer(Const.DEBOUNCED_INPUT_VALIDATOR_DELAY, (ActionEvent evt) -> {
            timer.stop();
            debounced = true;
            verify(getComponent());
            debounced = false;
        });
    }

    @Override
    protected Validation getValidation(JComponent jc, JInputValidatorPreferences jivp) {
        if (debounced) {
            return getDebouncedValidation(jc, jivp);
        } else {
            timer.restart();
            return Const.DEBOUNCED_INPUT_VALIDATOR_VALIDATION;
        }
    }

    protected abstract Validation getDebouncedValidation(JComponent input, JInputValidatorPreferences preferences);
}
