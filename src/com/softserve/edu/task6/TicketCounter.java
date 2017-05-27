package com.softserve.edu.task6;

/**
 * Created by TDK on 24.05.2017.
 */
public class TicketCounter {
    private int[] getDigits(int n) {
        int[] digits = new int[6];
        for (int i = 0; i < 6; i++) {
            digits[i] = (n / (int) Math.pow(10, 5 - i) % 10);
        }
        return digits;
    }

    /**
     * Counts the number of lucky ticket with input algorithm
     *
     * @param algorithm Algorithm you want to count with
     * @return Number of lucky tickets with current algorithm
     */
    public int count(Algorithm algorithm) {
        int count = 0;
        for (int i = 0; i <= 999999; i++) {
            if (algorithm.isLuckyTicket(getDigits(i)))
                count++;
        }
        return count;
    }
}
