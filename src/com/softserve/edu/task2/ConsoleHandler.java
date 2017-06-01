package com.softserve.edu.task2;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by TDK on 30.05.2017.
 */
public class ConsoleHandler {
    private Scanner scanner;

    /**
     * Creates an object to work with console.
     */
    public ConsoleHandler(InputStream in) {
        if (in == null)
            throw new IllegalArgumentException("Input Stream can't be null");
        scanner = new Scanner(in);
    }

    /**
     * Prints input text in System.out
     *
     * @param text
     */
    public void print(String text) {
        System.out.println(text);
    }

    /**
     * Parses a line from System.in
     *
     * @return Double value of parsed line
     */
    public double readDouble() {
        return Double.parseDouble(scanner.nextLine());
    }

    /**
     * Reads next console line
     *
     * @return
     */
    public String readConsole() {
        return scanner.nextLine();
    }
}
