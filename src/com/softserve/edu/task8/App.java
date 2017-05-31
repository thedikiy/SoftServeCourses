package com.softserve.edu.task8;

/**
 * Created by TDK on 30.05.2017.
 */
public class App {
    /**
     * Shows USE help
     */

    public static void appHelp() {
        System.out.println("FIBONACCI \n" +
                "Use : \n" +
                "Prints all Fibonacci in range: App [start] [end] \n");
    }

    public static void main(String[] args) {
        if (args.length == 2) {
            try {
                new Fibonacci(args).printFibonacci();
            } catch (NumberFormatException e) {
                System.out.println("Values must be an integer");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            appHelp();
        }
    }
}
