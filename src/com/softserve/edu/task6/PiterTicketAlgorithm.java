package com.softserve.edu.task6;

/**
 * Represents PiterTicketAlgorithm algorithm, to check if ticket is lucky.
 */
public class PiterTicketAlgorithm implements TicketAlgorithm {
    private static final int TICKET_NUMBER_LENGTH = 6;

    /**
     * Checks if input ticket is lucky with PiterTicketAlgorithm algorithm.
     *
     * @param digits array of 6-th digits number as ticket
     * @return <code>true</code> if ticket is lucky
     * <code>false</code> if not
     */
    public boolean isLuckyTicket(int[] digits) {
        if (digits.length != TICKET_NUMBER_LENGTH) {
            throw new IllegalArgumentException("Ticket must have 6 digits");
        }
        int even = 0;
        int odd = 0;
        for (int i = 0; i < TICKET_NUMBER_LENGTH; i++) {
            if (i % 2 == 0) {
                even += digits[i];
            } else {
                odd += digits[i];
            }
        }
        return even == odd;
    }

}
