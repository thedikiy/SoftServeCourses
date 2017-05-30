package com.softserve.edu.task2;

import java.util.Scanner;

/**
 * Created by TDK on 30.05.2017.
 */
public class ConsoleHandler {
    private Scanner scanner;

    public ConsoleHandler() {
        scanner = new Scanner(System.in);
    }

    public void print(String text) {
        System.out.println(text);
    }

    public double readDouble() {
        return Double.parseDouble(scanner.nextLine());
    }

    public String readConsole() {
        return scanner.nextLine();
    }
}
