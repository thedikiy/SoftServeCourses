package com.softserve.edu.task5;


public class App {
    /**
     * Shows USE help.
     */
    public static void appHelp() {
        System.out.println("Get Symbolic Number \n"
                + "Use : \n"
                + "Count string entries: App [number] \n");
    }

    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                System.out.println(new SymbolicNumberConverter()
                                .getSymbolicNumber(args[0]));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            appHelp();
        }
    }
}
