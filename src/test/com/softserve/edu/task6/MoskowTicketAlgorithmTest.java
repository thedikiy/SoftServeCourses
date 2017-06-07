package test.com.softserve.edu.task6;

import com.softserve.edu.task6.MoskowTicketAlgorithm;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by TDK on 07.06.2017.
 */
public class MoskowTicketAlgorithmTest {
    @Test
    public void isLuckyTicket_LuckyTicket_TrueExpected(){
        //Arrange
        MoskowTicketAlgorithm algorithm = new MoskowTicketAlgorithm();
        boolean expected = true;
        int[] digits = {1, 3, 3, 1, 1, 5};
        //Act
        boolean actual = algorithm.isLuckyTicket(digits);
        //Assert
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isLuckyTicket_NotLuckyTicket_FalseExpected(){
        //Arrange
        MoskowTicketAlgorithm algorithm = new MoskowTicketAlgorithm();
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
        MoskowTicketAlgorithm algorithm = new MoskowTicketAlgorithm();
        int[] digits = {1, 3, 3, 1, 5 };
        //Act
        boolean actual = algorithm.isLuckyTicket(digits);
        //Assert
    }
}
