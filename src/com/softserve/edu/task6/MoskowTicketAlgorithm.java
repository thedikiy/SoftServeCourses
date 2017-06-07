package com.softserve.edu.task6;

/**
 * Represents MoskowTicketAlgorithm algorithm, to check if ticket is lucky.
 */
public class MoskowTicketAlgorithm implements TicketAlgorithm {
    private static final int TICKET_NUMBER_LENGTH = 6;

    /**
     * Checks if input ticket is lucky with MoskowTicketAlgorithm algorithm.
     *
     * @param digits array of 6-th digits number as ticket
     * @return <code>true</code> if ticket is lucky
     * <code>false</code> if not
     */
    public boolean isLuckyTicket(int[] digits) {
        if (digits.length != TICKET_NUMBER_LENGTH) {
            throw new IllegalArgumentException("Ticket must have 6 digits");
        }
        int first = 0;
        int last = 0;
        for (int i = 0; i < TICKET_NUMBER_LENGTH / 2; i++) {
            first += digits[i];
            last += digits[i + TICKET_NUMBER_LENGTH / 2];
        }
        return first == last;
    }

}
