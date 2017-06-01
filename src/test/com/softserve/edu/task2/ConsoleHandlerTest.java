package test.com.softserve.edu.task2;

import com.softserve.edu.task2.ConsoleHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created by TDK on 02.06.2017.
 */
public class ConsoleHandlerTest {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void createObject_NullArgument_ExceptionThrown() {
        ConsoleHandler handler = new ConsoleHandler(null);
    }

    @Test
    public void readDouble_DoubleInput_ValueRead() {
        String testString = "19.6";
        ByteArrayInputStream in = new ByteArrayInputStream(testString.getBytes());
        ConsoleHandler handler = new ConsoleHandler(in);

        double expected = 19.6;
        double actual = handler.readDouble();

        Assert.assertEquals(expected, actual);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void readDouble_NotDouble_ExceptionThrown() {
        String testString = "fagfsd";
        ByteArrayInputStream in = new ByteArrayInputStream(testString.getBytes());
        ConsoleHandler handler = new ConsoleHandler(in);

        double actual = handler.readDouble();
    }

    @Test
    public void readConsole_StringInput_ExceptionThrown() {
        String testString = "fagfsd";
        ByteArrayInputStream in = new ByteArrayInputStream(testString.getBytes());
        ConsoleHandler handler = new ConsoleHandler(in);

        String actual = handler.readConsole();

        Assert.assertEquals(actual,testString);
    }

}
