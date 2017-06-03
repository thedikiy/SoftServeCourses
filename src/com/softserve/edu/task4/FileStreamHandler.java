package com.softserve.edu.task4;

import java.io.*;

/**
 * Handles on file stream operations:
 * Reads from file or writes to file.
 */
public class FileStreamHandler implements StreamHandler {
    private File file;

    /**
     * Creates file stream handler taht can read and write to @code path file.
     *
     * @param path path to file for reading and writing
     */
    public FileStreamHandler(String path) {
        file = new File(path);
    }

    /**
     * Writes data in @code file.
     *
     * @param text string to write
     */
    public void writeToStream(String text) {
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

    /**
     * Reads whole @code file.
     *
     * @return String read from file
     */
    public String readStream() {
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
