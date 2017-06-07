package com.softserve.edu.task7;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a series of natural numbers.
 */
public class NaturalNumberSeries {
    private List<Integer> series;
    private int curElement;

    /**
     * Creates a new Series.
     */
    public NaturalNumberSeries() {
        series = new ArrayList<>();
        curElement = 0;
    }

    /**
     * A getter for series field.
     *
     * @return a current series of natural numbers
     */
    public List<Integer> getSeries() {
        return series;
    }

    /**
     * Overriding of basic toString method.
     *
     * @return current series in String representation
     */
    @Override
    public String toString() {
        return series.toString().substring(1, series.toString().length() - 1)
                .replaceAll(" ", "");
    }

    /**
     * Fills list with natural numbers, squares of each are less than
     * <code>boundary</code>.
     *
     * @param boundary All squares of natural numbers will be less than this
     *                 parameter
     */
    public void fillListWithBoundary(int boundary) {
        if (boundary <= 0) {
            throw new IllegalArgumentException("Value must be positive");
        }
        if (boundary == 1) {
            System.out.println("No squares are less than one");
        }
        curElement = 0;
        int square = nextSquare();
        while (square < boundary) {
            series.add(curElement);
            square = nextSquare();
        }
    }

    /**
     * Finds square for next value of <code>curElement</code>.
     *
     * @return next square
     */
    private int nextSquare() {
        return (int) Math.pow(++curElement, 2);
    }
}
