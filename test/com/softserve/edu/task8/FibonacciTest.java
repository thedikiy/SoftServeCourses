package com.softserve.edu.task8;

import com.softserve.edu.task8.Fibonacci;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Created by TDK on 07.06.2017.
 */
public class FibonacciTest {
    @Test
    public void createObject_RightConditionsIntegerConstructor_ObjectCreated(){
        Fibonacci fibonacci = new Fibonacci(25, 100);
    }

    @Test
    public void createObject_RightConditionsStringConstructor_ObjectCreated(){
        Fibonacci fibonacci = new Fibonacci("25", "100");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void createObject_NegativeFromValue_ExceptionThrown(){
        Fibonacci fibonacci = new Fibonacci("-25", "100");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void createObject_NegativeToValue_ExceptionThrown(){
        Fibonacci fibonacci = new Fibonacci("25", "-100");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void createObject_IllegalRange_ExceptionThrown(){
        Fibonacci fibonacci = new Fibonacci("25", "15");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void createObject_NotIntegerValue_ExceptionThrown(){
        Fibonacci fibonacci = new Fibonacci("25fdg", "15");
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void createObject_NullAsArgument_ExceptionThrown(){
        Fibonacci fibonacci = new Fibonacci(null, "15");
    }

    public void printFibonacci_RangePrinted(){
        // Arrange
        String expected="1 1 2 3 5 8 13 ";
        Fibonacci fibonacci = new Fibonacci(1, 20);
        PrintStream oldOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        //Act
        System.setOut(new PrintStream(baos));
        fibonacci.printFibonacci();

        //Assert
        Assert.assertEquals(expected,baos.toString());
    }

}
