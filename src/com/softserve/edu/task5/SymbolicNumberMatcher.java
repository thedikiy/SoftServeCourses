package com.softserve.edu.task5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The utility class that was made to check if input String is valid.
 * Also matches if current number is negative or zero
 */
public class SymbolicNumberMatcher {
    private String numberString;

    /**
     * Creates a new number matcher object.
     *
     * @param numberString a string with number value
     */
    public SymbolicNumberMatcher(String numberString) {
        if (numberString.equals("") || numberString == null) {
            throw new IllegalArgumentException(
                    "Number String can't be empty or null");
        }
        this.numberString = numberString;
    }

    /**
     * Getts for current number string
     *
     * @return current number string
     */
    public String getNumberString() {
        return numberString;
    }

    /**
     * A setter for number string field.
     *
     * @param numberString new number string to match
     */
    public void setNumberString(String numberString) {
        if (numberString.equals("") || numberString == null) {
            throw new IllegalArgumentException(
                    "Number String can't be empty or null");
        }
        this.numberString = numberString;
    }

    /**
     * Checks if current number string represents a zero.
     *
     * @return  true if current number string represets zero
     *          false if not
     */
    public boolean isZero() {
        Pattern pattern = Pattern.compile("0+");
        Matcher matcher = pattern.matcher(numberString);
        return matcher.matches();
    }

    /**
     * Checks if current number string represents a negative value.
     *
     * @return true if current number string represents negative value,
     * false other case
     */
    public boolean isNegative() {
        return (numberString.charAt(0) == '-');
    }

    /**
     * Validates current number string, makes sure this string represents
     * number value.
     *
     * @return a valid string that represents number value
     */
    public String validateNumberString() {
        String tempNumber = numberString;
        int start = 0;
        Pattern pattern = Pattern.compile("\\D+");
        Matcher matcher = pattern.matcher(tempNumber);
        if (isZero()) {
            return "0";
        }
        if (isNegative()) {
            start++;
        }
        if (matcher.find(start)) {
            throw new IllegalArgumentException("Wrong number: " + tempNumber);
        }
        pattern = Pattern.compile("([1-9][0-9]*)");
        matcher.usePattern(pattern);
        if (!matcher.find(0)) {
            throw new IllegalArgumentException("Wrong number: " + tempNumber);
        }
        return tempNumber.substring(matcher.start(), matcher.end());
    }
}
