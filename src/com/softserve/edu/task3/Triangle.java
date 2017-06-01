package com.softserve.edu.task3;

/**
 * Created by TDK on 30.05.2017.
 */
public class Triangle {
    private String name;
    private double side1;
    private double side2;
    private double side3;
    private double square;

    /**
     * Creates Triangle with name and three sides
     *
     * @param name
     * @param side1
     * @param side2
     * @param side3
     */
    public Triangle(String name, double side1, double side2, double side3) {
        this.name = name;
        if (Double.compare(side1, 0) <= 0
                || Double.compare(side2, 0) <= 0
                || Double.compare(side3, 0) <= 0)
            throw new IllegalArgumentException("Value must be positive");
        if (side1 + side2 <= side3 || side1 + side3 <= side2
                || side2 + side3 <= side1)
            throw new IllegalArgumentException("Sum of two sides must be " +
                    "larger than third one");
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        calculateSquare();
    }

    /**
     * Calculates Square of triangle
     */
    private void calculateSquare() {
        double p = (side1 + side2 + side3) / 2;
        square = Math.sqrt(
                p * (p - side1) * (p - side2) * (p - side3));
    }

    /**
     * Getter for name field
     * @return
     */
    public String getName() {
        return name;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public double getSquare() {
        return square;
    }

    @Override
    public String toString() {
        return String.format(
                "[Triangle %s]: %.2f cm^2", name, square);
    }

}
