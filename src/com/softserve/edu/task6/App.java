package com.softserve.edu.task6;


/**
 * Created by TDK on 24.05.2017.
 */

public class App {
    /**
     * Shows USE help
     */
    public static void appHelp() {
        System.out.println("Lucky Tickets \n" +
                "Use : \n" +
                "Enter file with algorithm ID: App [path] \n");
    }


    public static void main(String[] args) {
        if (args.length == 1) {
            ID id = new FileReader(args[0]).getAlgorithmID();
            switch (id) {
                case MOSKOW:
                    System.out.println(new TicketCounter().count(new Moskow()));
                    break;
                case PITER:
                    System.out.println(new TicketCounter().count(new Piter()));
                    break;
                case UNKNOWN:
                    System.out.println("Wrong file input");
            }
        } else {
            appHelp();
        }
    }
}
