package com.softserve.edu.task4;

/**
 * Parser interface.
 */
public interface Parser {
    /**
     * Counts entries of findStr.
     *
     * @param findStr String which entries to count
     * @return Number of findStr entries in file
     */
    int countEntries(String findStr);

    /**
     * Swaps findStr with swapStr.
     *
     * @param findStr
     * @param swapStr
     */
    void swapString(String findStr, String swapStr);
}
