package com.softserve.edu.task6;


/**
 * Task 6.
 */

public class App {
    /**
     * Shows USE help.
     */
    public static void appHelp() {
        System.out.println("Lucky Tickets \n"
                + "Use : \n"
                + "Enter file with algorithm TicketAlgorithmType: App [path] \n");
    }

    /**
     * Prints to stdout the number of tickets that with algorithm that was
     * specified by user.
     *
     * @param path path to file with algorithm name
     */
    public void run(String path) {
        try {
            TicketAlgorithmType type = new FileReader(path).getAlgorithmID();
            TicketAlgorithm ticketAlgorithm
                    = AlgorithmFactory.getAlgorithmById(type);
            System.out.println(new TicketCounter().count(ticketAlgorithm));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Main method.
     *
     * @param args program args
     */
    public static void main(String[] args) {
        if (args.length == 1) {
            new App().run(args[0]);
        } else {
            appHelp();
        }
    }
}
