package com.softserve.edu.task1;

/**
 * Created by TDK on 30.05.2017.
 */
public class ChessBoard {
    private int width;
    private int length;

    public ChessBoard(int width, int length) {
        if (width > 0 && length > 0) {
            this.width = width;
            this.length = length;
        } else {
            throw new IllegalArgumentException("Value must be positive");
        }
    }

    public void drawBoard() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if((i+j)%2==0){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
