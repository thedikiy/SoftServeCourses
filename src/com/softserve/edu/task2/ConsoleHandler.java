package com.softserve.edu.task2;

import java.io.InputStream;
import java.util.Scanner;

/**
 * A simple console handler, that give options such as:
 * read line from Input stream;
 * read double from Input Stream
 * Print into System.out.
 */
public class ConsoleHandler {
    private Scanner scanner;

    /**
     * Creates an object to work with console.
     * @param in Stream to read from
     */
    public ConsoleHandler(InputStream in) {
        if (in == null) {
            throw new IllegalArgumentException("Input Stream can't be null");
        }
        scanner = new Scanner(in);
    }

    /**
     * Prints input text in System.out.
     *
     * @param text String to type in System.out
     */
    public void print(String text) {
        System.out.println(text);
    }

    /**
     * Parses a line from System.in.
     *
     * @return Double value of parsed line
     */
    public double readDouble() {
        return Double.parseDouble(scanner.nextLine());
    }

    /**
     * Reads next console line.
     *
     * @return Line read from console.
     */
    public String readConsole() {
        return scanner.nextLine();
    }
}
