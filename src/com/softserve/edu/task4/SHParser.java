package com.softserve.edu.task4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parser that works with StreamHandler object.
 */
public class SHParser implements Parser {
    private StreamHandler streamHandler;

    /**
     * Creates stream handler parser.
     *
     * @param streamHandler StreamHandler object to read and save data
     */

    public SHParser(StreamHandler streamHandler) {
        if (streamHandler == null) {
            throw new IllegalArgumentException("Stream handler can't be null");
        }
        this.streamHandler = streamHandler;
    }

    /**
     * Counts how many entries input string has.
     *
     * @param findStr string which entries to count
     * @return count of findString entries
     */

    public int countEntries(String findStr) {
        if (findStr == null) {
            throw new IllegalArgumentException("String to find can't be null");
        }
        Pattern pattern = Pattern.compile(findStr);
        Matcher matcher = pattern.matcher(streamHandler.readStream());
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    /**
     * Swaps string with another one.
     *
     * @param findStr string to find in file
     * @param swapStr string to replace
     */

    public void swapString(String findStr, String swapStr) {
        if (findStr == null || swapStr == null) {
            throw new IllegalArgumentException("String to find or swap can't "
                    + "be null");
        }
        String text = streamHandler.readStream().replaceAll(findStr, swapStr);
        streamHandler.writeToStream(text);
    }
}
