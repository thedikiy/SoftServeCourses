package com.softserve.edu.task3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by TDK on 30.05.2017.
 */
public class TriangleList {
    private ArrayList<Triangle> triangles;

    private static class ConsoleHandler {
        private static Scanner reader = new Scanner(System.in);

        private static String getUserInput() {
            return reader.nextLine();
        }

        private static void inputHelp() {
            System.out.println("Triangle Square Sort \n" +
                    "Use : \n" +
                    "Sorts triangles by square: \n" +
                    "[input] format: <name>,<side1>,<side2>,<side3> \n");
        }
    }

    public TriangleList() {
        this.triangles = new ArrayList<>();
    }

    public void fillTriangleList() {
        ConsoleHandler.inputHelp();
        while (true) {
            String[] data = ConsoleHandler.getUserInput().split(",");
            if (data.length != 4) {
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
                    || input.equalsIgnoreCase("yes")))
                break;
        }
    }

    private Triangle createTriangle(String[] data) {
        double a = Double.parseDouble(data[1]);
        double b = Double.parseDouble(data[2]);
        double c = Double.parseDouble(data[3]);
        return new Triangle(data[0], a, b, c);
    }

    public void addTriangle(Triangle triangle) {
        triangles.add(triangle);
    }

    public void sortTriangles() {
        Collections.sort(triangles, new Comparator<Triangle>() {
            @Override
            public int compare(Triangle o1, Triangle o2) {

                return Double.compare(o1.getSquare(), o2.getSquare());
            }
        });
    }

    public void printTriangles() {
        for (Triangle triangle : triangles) {
            System.out.println(triangle);
        }
    }
}
