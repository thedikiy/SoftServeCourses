package test.com.softserve.edu.task7;

import com.softserve.edu.task7.NaturalNumberSeries;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by TDK on 07.06.2017.
 */
public class NaturalNumberSeriesTest {
    @Test
    public void fillListWithBoundary_AlgorithmCheck_ListFilled() {
        //Arrange
        List<Integer> expected = new ArrayList<>(Arrays.asList(
                1, 2, 3, 4, 5, 6));
        NaturalNumberSeries series = new NaturalNumberSeries();

        //Act
        series.fillListWithBoundary(49);
        List<Integer> actual = series.getSeries();

        //Arrange
        Assert.assertEquals(expected, actual);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void fillListWithBoundary_ZeroBoundary_ExceptionThrown() {
        //Arrange
        NaturalNumberSeries series = new NaturalNumberSeries();
        //Act
        series.fillListWithBoundary(0);
    }

    @Test
    public void toStringTest() {
        //Arrange
        String expected="1,2,3,4,5,6";
        NaturalNumberSeries series = new NaturalNumberSeries();
        //Act
        series.fillListWithBoundary(49);
        String actual = series.toString();
        //Assert
        Assert.assertEquals(expected,actual);
    }

}
