package com.softserve.edu.task2;

/**
 * Created by TDK on 30.05.2017.
 */
public class App {
    public static ConsoleHandler handler = new ConsoleHandler(System.in);

    /**
     * Process user input
     */
    public static void process() {
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
            handler.print("Excuse me, you can't put one envelope in " +
                    "another");
        }


    }

    public static void main(String[] args) {
        String answer = "";
        do {
            try {
                process();
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
