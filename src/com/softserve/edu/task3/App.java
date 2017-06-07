package com.softserve.edu.task3;

/**
 * Task 3.
 */
public class App {

    /**
     * Main method, creates triangle list and then sort and print it.
     *
     * @param args console arguments
     */
    public static void main(String[] args) {
        try {
            TriangleList list = new TriangleList(System.in);
            list.fillTriangleList();
            list.sortTriangles();
            list.printTriangles();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
