package com.softserve.edu.task6;

/**
 * The TicketAlgorithm interface.
 * Any algorithm that calculates if ticket is lucky must implement it.
 */
public interface TicketAlgorithm {
    /**
     * Checks if input ticket is lucky with certain algorithm.
     *
     * @param digits array of 6-th digits number as ticket
     * @return <code>true</code> if ticket is lucky
     * <code>false</code> if not
     */
    boolean isLuckyTicket(int[] digits);
}
