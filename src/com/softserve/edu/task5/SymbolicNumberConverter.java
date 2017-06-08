package com.softserve.edu.task5;

/**
 * Converts a number into its symbolic representation in Russian language.
 * Triplet is simple unit of number, for example thousands, million etc.
 */
public class SymbolicNumberConverter {
    private String numberString;
    private int tripletCounter;
    private static final int TRIPLET_LENGTH = 3;
    private static final int RADIX = 10;

    /**
     * Validates input stream and then creates a symbolic representation of
     * input <code>number</code>.
     *
     * @param number input number as String
     * @return symbolic representation of number
     */
    public String getSymbolicNumber(String number) {
        if (number == null || number.equals("")) {
            throw new IllegalArgumentException("String can't be empty or null");
        }
        numberString = number.trim();
        SymbolicNumberMatcher matcher = new SymbolicNumberMatcher(numberString);
        if (matcher.isZero()) {
            return ConstantSymbolicNames.ZERO;
        }
        numberString = matcher.validateNumberString();
        if (numberString.length() > 36) {
            throw new IllegalArgumentException("The number is too large");
        }
        String result = convertNumberIntoSymbolic();
        if (matcher.isNegative()) {
            result = ConstantSymbolicNames.MINUS + " " + result;
        }
        return result;
    }

    /**
     * Splits triplet number string into digits.
     * If triplet is not full not existing parts will be marked with 0.
     *
     * @param numberString string which required to be split
     * @return an array of digits.
     */
    private int[] getDigits(String numberString) {
        int length = TRIPLET_LENGTH;
        int number = Integer.parseInt(numberString);
        int[] digits = new int[length];
        for (int i = 0; i < length; i++) {
            digits[i] = (number / (int) Math.pow(RADIX, (length
                    - 1) - i) % RADIX);
        }
        return digits;
    }

    /**
     * Converter for current number String. Works with String that was sent
     * into getSymbolicNumber method.
     *
     * @return a Symbolic representation of number
     */
    private String convertNumberIntoSymbolic() {
        tripletCounter = 0;
        StringBuilder result = new StringBuilder();
        StringSplitter splitter
                = new StringSplitter(numberString, TRIPLET_LENGTH);
        while (splitter.hasNextSplit()) {
            String temp = convertTripletIntoSymbolic(
                    getDigits(splitter.nextSplit())) + " ";
            temp += getTripletName();

            result = result.insert(0, temp);
            tripletCounter++;

        }
        return result.toString();
    }

    /**
     * Converts number triplet's digits into their symbolic representation.
     *
     * @param triplet an array, that contains three digits of triplet
     * @return triplet's symbolic representation
     */
    private String convertTripletIntoSymbolic(int[] triplet) {
        return getHundredName(triplet).trim();
    }

    /**
     * Gets name for triplet's digits.
     *
     * @param digits an array, that contains three digits of triplet
     * @return triplet's symbolic name
     */
    private String getHundredName(int[] digits) {
        return ConstantSymbolicNames.HUNDREDS[digits[0]] + " "
                + getTenName(digits);
    }

    /**
     * Gets name for last two digits of triplet.
     *
     * @param digits an array, that contains three digits of triplet
     * @return symbolic representation of two triplet's digits
     */
    private String getTenName(int[] digits) {
        String result = "";
        if (digits[1] == 1) {
            result += ConstantSymbolicNames.TEN_TO_TWENTY[digits[2]];
            if (tripletCounter == 1) {
                result += " " + ConstantSymbolicNames.THOUSANDS[0];
            }
        } else {
            result = (ConstantSymbolicNames.TENS[digits[1]]
                    + " " + getFirstDigitName(digits)).trim();
        }
        return result;
    }

    /**
     * Gets name for last digit of triplet.
     *
     * @param digits an array, that contains three digits of triplet
     * @return symbolic representation of last triplet's digits
     */
    private String getFirstDigitName(int[] digits) {
        if (tripletCounter == 1) {
            return ConstantSymbolicNames.THOUSANDS[digits[2]];
        }
        return ConstantSymbolicNames.FIRST_DIGIT[digits[2]] + " ";
    }

    /**
     * Gets a name of triplet.
     *
     * @return Triplet's name
     */
    private String getTripletName() {
        if (tripletCounter > 1) {
            return ConstantSymbolicNames.TRIPLET_NAME[tripletCounter] + " ";
        } else {
            return "";
        }
    }
}
