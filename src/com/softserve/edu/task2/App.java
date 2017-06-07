package com.softserve.edu.task2;

/**
 * Task 2.
 */
public class App {
    private static ConsoleHandler handler = new ConsoleHandler(System.in);

    /**
     * Process user input.
     */
    private void process() {
        double width;
        double height;
        handler.print("Enter first envelope's width");
        width = handler.readDouble();
        handler.print("Enter first envelope's height");
        height = handler.readDouble();
        Envelope firstEnv = new Envelope(width, height);
        handler.print("Enter second envelope's width");
        width = handler.readDouble();
        handler.print("Enter second envelope's height");
        height = handler.readDouble();
        Envelope secondEnv = new Envelope(width, height);
        if (firstEnv.compare(secondEnv) != 0) {
            handler.print("Sure you can put one envelope in another");
        } else {
            handler.print("Excuse me, you can't put one envelope in "
                    + "another");
        }


    }

    /**
     * Main Method.
     * Creates new App and handles on exceptions that are produced by it.
     * @param args - Console arguments
     */
    public static void main(String[] args) {
        String answer;
        do {
            try {
                new App().process();
            } catch (NumberFormatException e) {
                handler.print("Value must be double");
            } catch (IllegalArgumentException e) {
                handler.print("Value must be positive");
            }
            handler.print("Do you want to continue?");
            answer = handler.readConsole();
        } while (answer.equalsIgnoreCase("y")
                || answer.equalsIgnoreCase("yes"));
    }
}
