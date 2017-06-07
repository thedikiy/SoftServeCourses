package com.softserve.edu.task6;

/**
 *  A counter of tickets with certain algorithm.
 */
public class TicketCounter {
    private static final int MAX_TICKET_QUANTITY = 1000000;
    private static final int TICKET_NUMBER_LENGTH = 6;

    /**
     * Split the number to digits.
     *
     * @param number number to split.
     * @return array of digits
     */
    private int[] getDigits(int number) {
        int[] digits = new int[TICKET_NUMBER_LENGTH];
        for (int i = 0; i < TICKET_NUMBER_LENGTH; i++) {
            digits[i] = (number / (int) Math.pow(10, (TICKET_NUMBER_LENGTH
                    - 1) - i) % 10);
        }
        return digits;
    }

    /**
     * Counts the number of lucky ticket with input ticketAlgorithm.
     * The default range is 0 - 999999
     *
     * @param ticketAlgorithm TicketAlgorithm you want to count with
     * @return Number of lucky tickets with current ticketAlgorithm
     */
    public int count(TicketAlgorithm ticketAlgorithm) {
        return count(ticketAlgorithm, 0, MAX_TICKET_QUANTITY);
    }

    /**
     * Counts the number of lucky ticket with input ticketAlgorithm.
     * The default range is 0 - 999999
     *
     * @param ticketAlgorithm TicketAlgorithm you want to count with
     * @param from      the left boundary of range
     * @param to        the right boundary of range
     * @return Number of lucky tickets with current ticketAlgorithm
     */
    public int count(TicketAlgorithm ticketAlgorithm, int from, int to) {
        if (from < 0 || to < 0) {
            throw new IllegalArgumentException("range boundaries can't be "
                    + "negative");
        }

        if (to < from) {
            throw new IllegalArgumentException("incorrect range");
        }
        int count = 0;
        for (int i = from; i < to; i++) {
            if (ticketAlgorithm.isLuckyTicket(getDigits(i))) {
                count++;
            }
        }
        return count;
    }
}
