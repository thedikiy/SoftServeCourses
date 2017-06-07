package com.softserve.edu.task6;

import java.io.*;

/**
 * Class that works with file object, reads it and find out what algorithm
 * was chosen by user.
 */
public class FileReader {
    private File file;

    /**
     * Creates a new file reader.
     *
     * @param path Path to file to read
     */
    public FileReader(String path) {
        file = new File(path);
    }

    /**
     * A setter method for file file.
     *
     * @param file a file to read
     */
    public void setFile(File file) {
        if (file != null) {
            this.file = file;
        } else {
            throw new IllegalArgumentException("File can't be null");
        }
    }

    /**
     * A setter method for file file.
     *
     * @param path Path to file to read
     */
    public void setFile(String path) {
        this.file = new File(path);
    }

    /**
     * Checks if string corresponds to any TicketAlgorithmType.
     *
     * @param type string which has to represent some id
     * @return TicketAlgorithmType of algorithm that was specified in
     * <code>type</code> parameter
     * TicketAlgorithmType.Unknown if Algorithm Type wasn't found
     */
    public TicketAlgorithmType validateType(String type) {
        if (type != null) {
            type = type.trim();
            if (type.split(" ").length == 1) {
                type = type.split(" ")[0];
                for (TicketAlgorithmType algorithmType
                        : TicketAlgorithmType.values()) {
                    if (algorithmType.name().equals(type.toUpperCase())) {
                        return algorithmType;
                    }
                }
            }
        }
        return TicketAlgorithmType.UNKNOWN;
    }

    /**
     * Reads all data from file.
     *
     * @return String with file's data
     */

    private String readFile() {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(file)))) {
            String temp = "";
            while ((temp = reader.readLine()) != null) {
                text.append(temp);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Something went wrong...");
        }
        return text.toString();
    }

    /**
     * Reads file and returns algorithm TicketAlgorithmType.
     *
     * @return TicketAlgorithm id
     * if not found <code>TicketAlgorithmType.UNKNOWN</code>
     */
    public TicketAlgorithmType getAlgorithmID() {
        String text = readFile();
        return validateType(text);
    }
}
