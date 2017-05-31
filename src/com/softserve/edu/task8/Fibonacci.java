package com.softserve.edu.task8;

import java.math.BigInteger;

/**
 * Created by TDK on 30.05.2017.
 */
public class Fibonacci {
    private BigInteger from;
    private BigInteger to;
    private BigInteger F1 = new BigInteger("0");
    private BigInteger F2;
    private boolean isNegative;

    public Fibonacci(String[] args) {
        from = new BigInteger(args[0]);
        to = new BigInteger(args[1]);
        if (from.compareTo(BigInteger.ZERO) >= 0 && to.compareTo(BigInteger
                .ZERO) == 1) {

            F2 = new BigInteger("1");
            isNegative = false;
            if (from.compareTo(to) > 0)
                throw new IllegalArgumentException("Illegal range");

        } else if (from.compareTo(BigInteger.ZERO) <= 0 && to.compareTo(BigInteger
                .ZERO) == -1) {

            if (from.compareTo(to) < 0)
                throw new IllegalArgumentException("Illegal range");
            F2 = new BigInteger("-1");
            isNegative = true;
        }

        throw new IllegalArgumentException("Illegal range");
    }

    public void printFibonacci() {
        while (true) {
            if ((F1.compareTo(from) >= 0 && !isNegative)
                    || (F1.compareTo(from) <= 0 && isNegative)) {
                System.out.println(F1 + " ");
            }
            BigInteger temp = F2;
            F2 = F2.add(F1);
            F1 = temp;
            if ((F1.compareTo(to) == 1 && !isNegative)
                    || (F1.compareTo(to) == -1 && isNegative)) {
                break;
            }
        }
    }
}

