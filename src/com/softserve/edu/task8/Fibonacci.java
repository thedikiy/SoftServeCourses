package com.softserve.edu.task8;

import java.math.BigInteger;

/**
 * Represents an object that works with Fibonacci numbers.
 */
public class Fibonacci {
    private BigInteger from;
    private BigInteger to;
    private BigInteger fib1;
    private BigInteger fib2;


    /**
     * Overloading of main constructor to let user use integer input values.
     * @param from  a boundary where the range begins
     * @param to    an ending boundary
     */
    public Fibonacci(int from, int to) {
        this(String.valueOf(from), String.valueOf(to));
    }

    /**
     * Creates an object that can print Fibonacci numbers in range.
     * takes two String input parameters.
     * @param from  a boundary where the range begins
     * @param to    an ending boundary
     */
    public Fibonacci(String from, String to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Boundaries can't be null");
        }
        this.from = new BigInteger(from);
        this.to = new BigInteger(to);
        if (this.from.compareTo(BigInteger.ZERO) >= 0 && this.to.compareTo(
                BigInteger.ZERO) == 1 && this.from.compareTo(this.to) <= 0) {
            fib1 = new BigInteger("0");
            fib2 = new BigInteger("1");

        } else {
            throw new IllegalArgumentException("Illegal range");
        }
    }

    /**
     * Prints all Fibonacci in current range.
     */
    public void printFibonacci() {
        while (true) {
            if (fib1.compareTo(from) >= 0) {
                System.out.print(fib1 + " ");
            }
            BigInteger temp = fib2;
            fib2 = fib2.add(fib1);
            fib1 = temp;
            if (fib1.compareTo(to) == 1) {
                break;
            }
        }
    }
}

