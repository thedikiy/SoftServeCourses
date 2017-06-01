package com.softserve.edu.task1;

/**
 * Created by TDK on 30.05.2017.
 */

public class App {
    /**
     *  Shows use help.
     */
    private static void appHelp() {
        System.out.println("Chess Board \n"
                + "Use : \n"
                + "Enter board's width and length: App [width] [length] \n"
                + "Values must be a positive integer");
    }

    /**
     * Runs program main program
     * @param args args for Board's width and length
     */
    private void run(String[] args){
        if (args.length == 2) {
            try {
                int width = Integer.parseInt(args[0]);
                int length = Integer.parseInt(args[1]);
                new ChessBoard(width, length).drawBoard();
            } catch (NumberFormatException e) {
                System.out.println("Value must be an integer");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            appHelp();
        }
    }

    /**
     * Main method
     * @param args input parameters
     */
    public static void main(String[] args) {
        new App().run(args);
    }
}
