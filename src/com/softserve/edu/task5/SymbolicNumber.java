package com.softserve.edu.task5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SymbolicNumber {
    private String numberString;
    private int tripletCounter;
    private static final String ZERO = "ноль";
    private static final String[] FIRST_DIGIT = {"", "один", "два", "три",
            "четыре", "пять", "шесть", "семь", "восемь", "девять"};

    private static final String[] TEN_TO_TWENTY = {"десять", "одиннадцать",
            "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать",
            "семнадцать", "восемнадцать", "девятнадцать"};

    private static final String[] TENS = {"", "placeholder", "двадцать",
            "тридцать",
            "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят",
            "девяносто"};

    private static final String[] HUNDREDS = {"", "сто", "двести", "триста",
            "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот",
            "девятьсот"};

    private static final String[] THOUSANDS = {"тысяч", "одна тысяча",
            "две тысячи", "три тысячи", "четыре тысячи", "пять тысяч",
            "шесть тысяч", "семь тысяч", "восемь тысяч", "девять тысяч"};

    private static final String[] TRIPLET_NAME = {"миллионов",
            "миллиардов",
            "триллионов", "квадриллионов", "квинтиллионов", "секситиллионов",
            "септиллионов", "октиллион", "нониллионов", "децилионов"};

    private void validateAndSetNumberString(String number) {
        if (number == null || number.equals(""))
            throw new IllegalArgumentException("String can't be empty or null");
        String tempNumber = number.trim();
        Pattern pattern = Pattern.compile("\\D+");
        Matcher matcher = pattern.matcher(tempNumber);
        if (matcher.find(0))
            throw new IllegalArgumentException("Wrong number: " + tempNumber);
        pattern = Pattern.compile("([1-9][0-9]*)");
        matcher.usePattern(pattern);
        matcher.find(0);
        numberString = tempNumber.substring(matcher.start(), matcher.end());
    }

    private String nextTriplet() {
        String resultString = numberString;
        if (numberString.length() > 3) {
            resultString = numberString.substring(
                    numberString.length() - 3, numberString.length());
            numberString = numberString.substring(0, numberString.length() - 3);
        } else {
            numberString = "";
        }
        return resultString;
    }

    private int[] getDigits(String stringNumber) {
        int length = 3;
        int number = Integer.parseInt(stringNumber);
        int[] digits = new int[length];
        for (int i = 0; i < length; i++) {
            digits[i] = (number / (int) Math.pow(10, (length
                    - 1) - i) % 10);
        }
        return digits;
    }


    private boolean hasNextTriplet() {
        return !numberString.isEmpty();
    }

    public String getSymbolicNumber(String number) {
        validateAndSetNumberString(number);
        tripletCounter = 0;
        String result = "";

        while (hasNextTriplet()) {
            String temp = convertTripletIntoSymbolic(
                    getDigits(nextTriplet())) + " ";
            if (tripletCounter > 1) {
                temp += TRIPLET_NAME[tripletCounter - 2] + " ";
            }
            result = temp + result;
            tripletCounter++;

        }
        System.out.println(result);
        return number;
    }

    private String convertTripletIntoSymbolic(int[] triplet) {
        return getHundredName(triplet).trim();
    }

    private String getHundredName(int[] digits) {
        return HUNDREDS[digits[0]] + " " + getTenName(digits);
    }

    private String getTenName(int[] digits) {
        if (digits[1] == 1) {
            return TEN_TO_TWENTY[digits[2]];
        } else {
            return (TENS[digits[1]] + " " + getFirstDigitName(digits)).trim();
        }
    }

    private String getFirstDigitName(int[] digits) {
        if (tripletCounter == 1) {
            return THOUSANDS[digits[2]];
        }
        return FIRST_DIGIT[digits[2]] + " ";
    }


}
