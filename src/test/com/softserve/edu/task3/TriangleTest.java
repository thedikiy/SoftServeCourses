package test.com.softserve.edu.task3;

import com.softserve.edu.task3.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

/**
 * Created by adminaccount on 5/31/2017.
 */
public class TriangleTest {
    @Test
    public void getSquare_NameAndCorrectThreeSides_SquareCalculated() {
//        Arrange
        Triangle triangle = new Triangle("test", 15.9, 16.8, 17.3);
//        Act
        double square = new BigDecimal(triangle.getSquare()).setScale(
                2, BigDecimal.ROUND_HALF_UP).doubleValue();
//        Assert
        Assert.assertEquals(square, 119.85);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void getSquare_NegativeSide_ExceptionThrown() {
        Triangle triangle = new Triangle("test", -1.5, 15.6, 1.7);
    }


    @Test(expectedExceptions = IllegalArgumentException.class)
    public void getSquare_OneSideIsBiggerThanOthers_ExceptionThrown() {
        Triangle triangle = new Triangle("test", 100.5, 15.6, 1.7);
    }
}
