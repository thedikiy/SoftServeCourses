package com.softserve.edu.task1;

/**
 * Created by TDK on 30.05.2017.
 */

public class App {
    public static void appHelp() {
        System.out.println("Chess Board \n"
                + "Use : \n"
                + "Enter board's width and length: App [width] [length] \n"
                + "Values must be a positive integer");
    }

    public static void main(String[] args) {
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
}
