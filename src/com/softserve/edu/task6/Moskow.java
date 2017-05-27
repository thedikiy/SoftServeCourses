package com.softserve.edu.task6;

/**
 * Created by TDK on 24.05.2017.
 */
public class Moskow implements Algorithm {
    /**
     * Checks if input ticket is lucky with Moskow algorithm
     *
     * @param digits array of 6-th digits number as ticket
     * @return <code>true</code> if ticket is lucky
     * <code>false</code> if not
     */
    public boolean isLuckyTicket(int[] digits) {
        int first = 0;
        int last = 0;
        for (int i = 0; i < 3; i++) {
            first += digits[i];
            last += digits[i + 3];
        }
        if (first == last) {
            return true;
        }
        return false;
    }

}
