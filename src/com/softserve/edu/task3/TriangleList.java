package com.softserve.edu.task3;

import java.io.InputStream;
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
    private ConsoleHandler handler;

    /**
     * Handles on console user input.
     */
    private class ConsoleHandler {
        private Scanner reader;

        public ConsoleHandler(InputStream in) {
            reader = new Scanner(in);
        }

        /**
         * Gets user input.
         *
         * @return user input
         */
        private String getUserInput() {
            return reader.nextLine();
        }

        /**
         * Application's help.
         */
        private void inputHelp() {
            System.out.println("Triangle Square Sort \n"
                    + "Use : \n"
                    + "Sorts triangles by square: \n"
                    + "[input] format: <name>,<side1>,<side2>,<side3> \n");
        }
    }

    /**
     * Getter for list.
     *
     * @return list of triangles
     */
    public ArrayList<Triangle> getTriangles() {
        return triangles;
    }

    public void setTriangles(ArrayList<Triangle> triangles) {
        this.triangles = triangles;
    }

    /**
     * Creates new Triangle List.
     */
    public TriangleList(InputStream inputStream) {
        this.triangles = new ArrayList<>();
        if (inputStream == null) {
            throw new IllegalArgumentException("Input stream can not be null");
        }

        handler = new ConsoleHandler(inputStream);
    }

    /**
     * Fills list with triangles according to user input.
     */
    public void fillTriangleList() {
        handler.inputHelp();
        while (true) {
            String[] data = handler.getUserInput().split(",");
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
            String input = handler.getUserInput().trim();
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
     *
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
