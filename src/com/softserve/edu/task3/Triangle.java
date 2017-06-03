package com.softserve.edu.task3;

/**
 * Represents triangle with name and 3 sides.
 */
public class Triangle {
    private String name;
    private double side1;
    private double side2;
    private double side3;
    private double square;

    /**
     * Creates Triangle with name and three sides.
     *
     * @param name  name of triangle, given by user
     * @param side1 first side of triangle
     * @param side2 second side of triangle
     * @param side3 third side of triangle
     */
    public Triangle(String name, double side1, double side2, double side3) {
        this.name = name;
        if (Double.compare(side1, 0) <= 0
                || Double.compare(side2, 0) <= 0
                || Double.compare(side3, 0) <= 0) {
            throw new IllegalArgumentException("Value must be positive");
        }
        if (side1 + side2 <= side3 || side1 + side3 <= side2
                || side2 + side3 <= side1) {
            throw new IllegalArgumentException("Sum of two sides must be "
                    + "larger than third one");
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        calculateSquare();
    }

    /**
     * Calculates Square of triangle.
     */
    private void calculateSquare() {
        double p = (side1 + side2 + side3) / 2;
        square = Math.sqrt(
                p * (p - side1) * (p - side2) * (p - side3));
    }

    /**
     * Getter for name field.
     *
     * @return name of triangle
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for side1 field.
     *
     * @return first side of triangle
     */
    public double getSide1() {
        return side1;
    }

    /**
     * Getter for side2 field.
     *
     * @return second side of triangle
     */
    public double getSide2() {
        return side2;
    }

    /**
     * Getter for side3 field.
     *
     * @return third side of triangle
     */
    public double getSide3() {
        return side3;
    }

    /**
     * Getter for square field.
     *
     * @return square of triangle
     */
    public double getSquare() {
        return square;
    }

    /**
     * Overrides toString method.
     * Prints triangle in right format.
     *
     * @return formatted string for triangle.
     */
    @Override
    public String toString() {
        return String.format(
                "[Triangle %s]: %.2f cm^2", name, square);
    }

}
