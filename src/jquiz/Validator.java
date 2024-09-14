/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jquiz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ratul
 */
public abstract class Validator {

    private static final Pattern ALL_DIGIT_PATTERN = Pattern.compile(
            "^[0-9]*$");

    private static final Pattern ANY_LOWER_CASE_PATTERN = Pattern.compile(
            "[a-z]");
    private static final Pattern ANY_UPPER_CASE_PATTERN = Pattern.compile(
            "[A-Z]");
    private static final Pattern ANY_DIGIT_PATTERN = Pattern.compile(
            "[0-9]");
    private static final Pattern ANY_SYMBOL_PATTERN = Pattern.compile(
            "[^a-zA-Z0-9]");

    private static final Pattern NAME_PATTERN = Pattern.compile(
            "^[a-zA-Z][a-zA-Z0-9_]*$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    public static boolean onlyDigit(String string) {
        Matcher matcher = ALL_DIGIT_PATTERN.matcher(string);
        return matcher.matches();
    }

    public static boolean hasLowerCase(String string) {
        Matcher matcher = ANY_LOWER_CASE_PATTERN.matcher(string);
        return matcher.find();
    }

    public static boolean hasUpperCase(String string) {
        Matcher matcher = ANY_UPPER_CASE_PATTERN.matcher(string);
        return matcher.find();
    }

    public static boolean hasDigit(String string) {
        Matcher matcher = ANY_DIGIT_PATTERN.matcher(string);
        return matcher.find();
    }

    public static boolean hasSymbol(String string) {
        Matcher matcher = ANY_SYMBOL_PATTERN.matcher(string);
        return matcher.find();
    }

    public static boolean isValidName(String string) {
        Matcher matcher = NAME_PATTERN.matcher(string);
        return matcher.matches();
    }

    public static boolean isValidEmail(String string) {
        Matcher matcher = EMAIL_PATTERN.matcher(string);
        return matcher.matches();
    }
}
