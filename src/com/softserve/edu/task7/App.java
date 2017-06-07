package com.softserve.edu.task7;

/**
 * Task 7.
 */
public class App {
    /**
     * Shows USE help.
     */
    public static void appHelp() {
        System.out.println("Number series \n"
                + "Use : \n"
                + "Builds series of number's squares that are less "
                + "than [value]: App [value] \n");
    }

    /**
     * Main method.
     *
     * @param args program arguments
     */
    public static void main(String[] args) {
        if (args.length == 1) {
            new App().process(args[0]);
        } else {
            appHelp();
        }
    }

    /**
     * Creates a new series with natural numbers, squares of each are less
     * then <code>value</code>  and prints it.
     *
     * @param value boundary value
     */
    public void process(String value) {
        try {
            int boundary = Integer.parseInt(value);
            NaturalNumberSeries series = new NaturalNumberSeries();
            series.fillListWithBoundary(boundary);
            System.out.println(series);
        } catch (NumberFormatException e) {
            System.out.println("Value must be integer...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
