package com.softserve.edu.task6;

import com.softserve.edu.task6.PiterTicketAlgorithm;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by TDK on 07.06.2017.
 */
public class PiterTicketAlgorithmTest {
    @Test
    public void isLuckyTicket_LuckyTicket_TrueExpected(){
        //Arrange
        PiterTicketAlgorithm algorithm = new PiterTicketAlgorithm();
        boolean expected = true;
        int[] digits = {1, 3, 3, 1, 5, 5};
        //Act
        boolean actual = algorithm.isLuckyTicket(digits);
        //Assert
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isLuckyTicket_NotLuckyTicket_FalseExpected(){
        //Arrange
        PiterTicketAlgorithm algorithm = new PiterTicketAlgorithm();
        boolean expected = false;
        int[] digits = {1, 3, 9, 1, 5, 5};
        //Act
        boolean actual = algorithm.isLuckyTicket(digits);
        //Assert
        Assert.assertEquals(expected,actual);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void isLuckyTicket_WrongArraySize_ExceptionThrown(){
        //Arrange
        PiterTicketAlgorithm algorithm = new PiterTicketAlgorithm();
        int[] digits = {1, 3, 3, 1, 5 };
        //Act
        boolean actual = algorithm.isLuckyTicket(digits);
        //Assert
    }
}
