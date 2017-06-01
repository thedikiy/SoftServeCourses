package com.softserve.edu.task1;

import java.util.Arrays;

/**
 * Created by TDK on 30.05.2017.
 */

public class ChessBoard {
    private int width;
    private int length;

    /**
     * Creates ChessBoard object.
     *
     * @param width
     * @param length
     */
    public ChessBoard(int width, int length) {
        if (width > 0 && length > 0) {
            this.width = width;
            this.length = length;
        } else {
            throw new IllegalArgumentException("Value must be positive");
        }
    }

    /**
     * Setter for width param
     *
     * @param width - width of chessboard
     */
    public void setWidth(int width) {
        if (width > 0) {
            this.width = width;
        } else {
            throw new IllegalArgumentException("Value must be positive");
        }
    }

    /**
     * Setter for length param
     *
     * @param length - length of chessboard
     */
    public void setLength(int length) {
        if (length > 0) {
            this.length = length;
        } else {
            throw new IllegalArgumentException("Value must be positive");
        }
    }

    /**
     * Width getter
     *
     * @return width of board
     */
    public int getWidth() {
        return width;
    }

    /**
     * Length's getter
     *
     * @return length of the board
     */
    public int getLength() {
        return length;
    }


    /**
     *  Creates and draws board
     */
    public void drawBoard() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
