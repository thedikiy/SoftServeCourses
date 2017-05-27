package com.softserve.edu.task6;

/**
 * Created by TDK on 24.05.2017.
 */
public class Piter implements Algorithm {
    /**
     * Checks if input ticket is lucky with Piter algorithm
     *
     * @param digits array of 6-th digits number as ticket
     * @return <code>true</code> if ticket is lucky
     * <code>false</code> if not
     */
    public boolean isLuckyTicket(int[] digits) {
        int even = 0;
        int odd = 0;
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0)
                even += digits[i];
            else
                odd += digits[i];
        }
        return even == odd ? true : false;
    }

}
