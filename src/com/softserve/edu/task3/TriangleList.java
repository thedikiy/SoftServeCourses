package com.softserve.edu.task3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Represents a list of triangles, based on ArrayList.
 */
public class TriangleList {
    private ArrayList<Triangle> triangles;
    private static final int PARAMETER_COUNT = 4;
    private static final int NAME_PLACE = 0;
    private static final int FIRST_SIDE = 1;
    private static final int SECOND_SIDE = 2;
    private static final int THIRD_SIDE = 3;

    /**
     * Handles on console user input.
     */
    private static class ConsoleHandler {
        private static Scanner reader = new Scanner(System.in);

        /**
         * Gets user input.
         *
         * @return user input
         */
        private static String getUserInput() {
            return reader.nextLine();
        }

        /**
         * Application's help.
         */
        private static void inputHelp() {
            System.out.println("Triangle Square Sort \n"
                    + "Use : \n"
                    + "Sorts triangles by square: \n"
                    + "[input] format: <name>,<side1>,<side2>,<side3> \n");
        }
    }

    /**
     * Creates new Triangle List.
     */
    public TriangleList() {
        this.triangles = new ArrayList<>();
    }

    /**
     * Fills list with triangles according to user input.
     */
    public void fillTriangleList() {
        ConsoleHandler.inputHelp();
        while (true) {
            String[] data = ConsoleHandler.getUserInput().split(",");
            if (data.length != PARAMETER_COUNT) {
                System.out.println("Wrong input...Try again");
            } else {
                try {
                    addTriangle(createTriangle(data));
                } catch (NumberFormatException e) {
                    System.out.println("Value must be double");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage() + "... Try again");
                }
            }
            System.out.println("Do you want to continue?(y/yes) ");
            String input = ConsoleHandler.getUserInput().trim();
            if (!(input.equalsIgnoreCase("y")
                    || input.equalsIgnoreCase("yes"))) {
                break;
            }
        }
    }

    /**
     * Creates new triangle.
     *
     * @param data splitted user input
     * @return Triangle with @code data parameters
     */
    private Triangle createTriangle(String[] data) {
        double a = Double.parseDouble(data[FIRST_SIDE]);
        double b = Double.parseDouble(data[SECOND_SIDE]);
        double c = Double.parseDouble(data[THIRD_SIDE]);
        return new Triangle(data[NAME_PLACE], a, b, c);
    }

    /**
     * Adds triangle into triangle list.
     * @param triangle triangle that has to be added
     */
    public void addTriangle(Triangle triangle) {
        triangles.add(triangle);
    }

    /**
     * Sorts triangles in list.
     */
    public void sortTriangles() {
        triangles.sort(new Comparator<Triangle>() {
            @Override
            public int compare(Triangle o1, Triangle o2) {

                return Double.compare(o1.getSquare(), o2.getSquare());
            }
        });
    }

    /**
     * Prints current list.
     */
    public void printTriangles() {
        for (Triangle triangle : triangles) {
            System.out.println(triangle);
        }
    }
}
