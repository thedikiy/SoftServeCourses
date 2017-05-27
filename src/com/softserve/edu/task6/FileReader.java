package com.softserve.edu.task6;

import java.io.*;

/**
 * Created by TDK on 24.05.2017.
 */
public class FileReader {
    private File file;

    /**
     * Creates a new file reader
     *
     * @param path Path to file to read
     */
    public FileReader(String path) {
        file = new File(path);
    }

    private ID validate(String name) {
        for (ID id : ID.values()) {
            if (id.name().equals(name.toUpperCase()))
                return id;
        }
        return ID.UNKNOWN;
    }

    private String readFile() {
        String text = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(file)))) {
            String temp = "";
            while ((temp = reader.readLine()) != null) {
                text += temp;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Something went wrong...");
        }
        return text;
    }

    /**
     * Reads file and returns algorithm ID
     *
     * @return Algorithm id
     * if not found <code>ID.UNKNOWN</code>
     */
    public ID getAlgorithmID() {
        String text = readFile();
        text = text.trim();
        if (text.split(" ").length == 1) {
            return validate(text.split(" ")[0]);
        }
        return ID.UNKNOWN;
    }
}
