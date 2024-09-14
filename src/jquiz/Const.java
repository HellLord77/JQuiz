/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jquiz;

import com.alexandriasoftware.swing.Validation;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

/**
 *
 * @author ratul
 */
public abstract class Const {

    public final static int DEBOUNCED_INPUT_VALIDATOR_DELAY = 500;
    public final static Validation DEBOUNCED_INPUT_VALIDATOR_VALIDATION = new Validation(Validation.Type.UNKNOWN, "Validating...");

    public final static boolean SHUFFLE_QUIZ_QUESTIONS = true;
    public final static boolean SHUFFLE_QUESTION_OPTIONS = true;

    public final static int MIN_NAME_LENGTH = 4;
    public final static int MIN_PASSWORD_LENGTH = 8;

    public final static int MAX_QUESTION_PER_QUIZ = 100;
    public final static int QUIZ_PER_PAGE = 10;

    public final static String DATABASE_URL = "jdbc:mysql://root:root@localhost:3306/jquiz";
    public final static String VAULT_PATH = "vault.txt";

    public final static String DURATION_PATTERN = "HH:mm:ss";
    public final static String PAUSE_DURATION_PATTERN = "HH:mm:ss";
    public final static String DURATION_COUNT_DOWN_PATTERN = "HH:mm:ss.SSS";
    public final static String PAUSE_DURATION_COUNT_DOWN_PATTERN = "mm:ss";

    public final static LocalTime MIN_DURATION = LocalTime.of(0, 5);
    public final static LocalTime MAX_DURATION = LocalTime.of(3, 0, 1);
    public final static LocalTime STEP_DURATION = LocalTime.of(0, 5);
    public final static LocalTime DEFAULT_DURATION = LocalTime.of(0, 15);
    public final static LocalTime MIN_PAUSE_DURATION = LocalTime.of(0, 0);
    public final static LocalTime MAX_PAUSE_DURATION = LocalTime.of(0, 15, 1);
    public final static LocalTime STEP_PAUSE_DURATION = LocalTime.of(0, 0, 30);
    public final static LocalTime DEFAULT_PAUSE_DURATION = LocalTime.of(0, 1);

    public final static SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
}
