package com.softserve.edu.task4;

/**
 * StreamHandler interface.
 */
public interface StreamHandler {
    /**
     * Reads data from stream.
     *
     * @return String from stream
     */
    String readStream();

    /**
     * Writes @code text data to Stream.
     *
     * @param text String to write into stream
     */
    void writeToStream(String text);
}
