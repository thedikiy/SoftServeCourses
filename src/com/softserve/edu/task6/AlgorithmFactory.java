package com.softserve.edu.task6;

/**
 * An TicketAlgorithm factory.
 */
public class AlgorithmFactory {
    /**
     * Returns new TicketAlgorithm object based on input id.
     *
     * @param id tells which algorithm to return
     * @return new TicketAlgorithm object
     */
    public static TicketAlgorithm getAlgorithmById(TicketAlgorithmType id) {
        TicketAlgorithm ticketAlgorithm = null;
        switch (id) {
            case MOSKOW:
                ticketAlgorithm = new MoskowTicketAlgorithm();
                break;
            case PITER:
                ticketAlgorithm = new PiterTicketAlgorithm();
                break;
            case UNKNOWN:
                throw new IllegalArgumentException("Illegal TicketAlgorithm");
        }
        return ticketAlgorithm;
    }
}
