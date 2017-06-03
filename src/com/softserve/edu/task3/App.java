package com.softserve.edu.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Task 3.
 */
public class App {

    /**
     * Main method, creates triangle list and then sort and print it.
     * @param args console arguments
     */
    public static void main(String[] args)  {
        TriangleList list = new TriangleList();
        list.fillTriangleList();
        list.sortTriangles();
        list.printTriangles();
    }
}
