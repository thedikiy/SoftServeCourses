package com.softserve.edu.task4;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by TDK on 24.05.2017.
 */
public class FileParser implements Parser {
    private File file;

    /**
     * Creates new file parser with input path
     *
     * @param path path to file to parse
     */

    public FileParser(String path) {
        file = new File(path);
    }

    /**
     * Counts how many entries input string has in current file
     *
     * @param findStr string which entries to count
     */

    public void countEntries(String findStr) {
        Pattern pattern = Pattern.compile(findStr);
        Matcher matcher = pattern.matcher(readFile());
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        System.out.println(count + " matches found");
    }

    /**
     * Swaps string in file with another one
     *
     * @param findStr string to find in file
     * @param swapStr string to replace
     */

    public void swapString(String findStr, String swapStr) {
        String text = readFile().replaceAll(findStr, swapStr);
        try {
            PrintWriter fileWriter = new PrintWriter(file.getAbsoluteFile());
            try {
                fileWriter.write(text);
            } finally {
                fileWriter.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Oops. Something is wrong");
        }
    }

    private String readFile() {
        BufferedReader reader = null;
        String text = "";
        try {
            reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file)));
            String temp = "";
            try {
                while ((temp = reader.readLine()) != null) {
                    text += temp + "\r\n";
                }
            } finally {
                reader.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error with reading file");
        }
        return text;
    }
}
