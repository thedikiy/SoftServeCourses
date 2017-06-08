package com.softserve.edu.task5;

/**
 * A class made to split a string every N symbols.
 */
public class StringSplitter {
    private String splitString;
    private int splitLength;

    /**
     * Creates a new Splitter object.
     *
     * @param numberString a string that has to be split
     * @param splitLength  will divide string every <code>splitLength</code>
     *                     symbol.
     */
    public StringSplitter(String numberString, int splitLength) {
        if (numberString.equals("") || numberString == null) {
            throw new IllegalArgumentException(
                    "Number String can't be empty or null");
        }
        if (splitLength < 1) {
            throw new IllegalArgumentException("split length must be positive");
        }
        this.splitString = numberString;
        this.splitLength = splitLength;
    }

    /**
     * Getter for a current state of string to split.
     *
     * @return split that was marked as string to split.
     */
    public String getSplitString() {
        return splitString;
    }

    /**
     * Setter to set a new string to split.
     *
     * @param splitString new string to split
     */
    public void setSplitString(String splitString) {
        if (splitString.equals("") || splitString == null) {
            throw new IllegalArgumentException(
                    "Number String can't be empty or null");
        }
        this.splitString = splitString;
    }

    /**
     * Gets next <code>splitLength</code> symbols.
     *
     * @return a next <code>splitLength</code> symbols of string, returns
     * empty string if there is no more splits available.
     */
    public String nextSplit() {
        String resultString = splitString;
        if (splitString.length() > splitLength) {
            resultString = splitString.substring(
                    splitString.length() - splitLength, splitString.length());
            splitString = splitString.substring(
                    0, splitString.length() - splitLength);
        } else {
            splitString = "";
        }
        return resultString;
    }


    /**
     * Tells if there is more splits available.
     *
     * @return <code>true</code> if available
     * <code>false</code> if not available
     */
    public boolean hasNextSplit() {
        return !splitString.isEmpty();
    }

}
