package com.softserve.edu.task4;


/**
 * File Parser application's Main class.
 */
public class App {
    private static final int FILE_PATH_ARGUMENT_NUMBER = 0;
    private static final int FIND_STRING_ARGUMENT_NUMBER = 1;
    private static final int SWAP_STRING_ARGUMENT_NUMBER = 2;

    /**
     * Shows USE help.
     */
    public static void appHelp() {
        System.out.println("FILE PARSER \n"
                + "Use : \n"
                + "Count string entries: App [path] [string] \n"
                + "Swap string: App [path] [findString] [replaceString]");
    }

    /**
     * Handles on user input.
     *
     * @param args User input parameters
     */
    public void run(String[] args) {
        try {
            Parser parser = new SHParser(new FileStreamHandler(
                    args[FILE_PATH_ARGUMENT_NUMBER]));
            switch (args.length) {
                case 2:
                    System.out.println(parser.countEntries(
                            args[FIND_STRING_ARGUMENT_NUMBER])
                            + "matches found");
                    break;
                case 3:
                    parser.swapString(
                            args[FIND_STRING_ARGUMENT_NUMBER],
                            args[SWAP_STRING_ARGUMENT_NUMBER]);
                    break;
                default:
                    appHelp();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Main method.
     * @param args console input
     */
    public static void main(String[] args) {
        if (args.length > 1) {
            new App().run(args);
        }
    }
}
