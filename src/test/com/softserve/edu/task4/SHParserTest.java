package test.com.softserve.edu.task4;

import com.softserve.edu.task4.SHParser;
import com.softserve.edu.task4.StreamHandler;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by TDK on 03.06.2017.
 */
public class SHParserTest {
    @Test
    public void countEntries_MockHandler_readStreamOneTime(){
        // Arrange
        StreamHandler handler=Mockito.mock(StreamHandler.class);
        SHParser parser = new SHParser(handler);
        Mockito.when(handler.readStream()).thenReturn("testing");

        //Act
        parser.countEntries("test");

        //Assert
        Mockito.verify(handler, Mockito.times(1)).readStream();
    }

    @Test
    public void countEntries_MockHandler_CountedEntries(){
        // Arrange
        StreamHandler handler=Mockito.mock(StreamHandler.class);
        SHParser parser = new SHParser(handler);
        Mockito.when(handler.readStream()).thenReturn("test test");

        //Act
        int count = parser.countEntries("test");

        //Assert
        Assert.assertEquals(count,2);
    }


    @Test
    public void swapStrings_MockHandler_WriteToStreamOneTime(){
        // Arrange
        StreamHandler handler=Mockito.mock(StreamHandler.class);
        SHParser parser = new SHParser(handler);
        Mockito.when(handler.readStream()).thenReturn("testing");

        //Act
        parser.swapString("test","test2");

        //Assert
        Mockito.verify(handler, Mockito.times(1)).writeToStream(Mockito.anyString());
    }

    @Test
    public void swapStrings_MockHandler_ReadStreamOneTime(){
        // Arrange
        StreamHandler handler=Mockito.mock(StreamHandler.class);
        SHParser parser = new SHParser(handler);
        Mockito.when(handler.readStream()).thenReturn("testing");

        //Act
        parser.swapString("test","test2");

        //Assert
        Mockito.verify(handler, Mockito.times(1)).readStream();
    }

    @Test
    public void swapStrings_MockHandler_StringSwapped(){
        // Arrange
        StreamHandler handler=Mockito.mock(StreamHandler.class);
        SHParser parser = new SHParser(handler);
        Mockito.when(handler.readStream()).thenReturn("test string");

        //Act
        parser.swapString("test","test2");

        //Assert
        Mockito.verify(handler, Mockito.times(1)).writeToStream(
                "test2 string");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void createObject_NullStream_ExceptionThrown(){
        new SHParser(null);
    }


    @Test(expectedExceptions = IllegalArgumentException.class)
    public void countEnries_NullInputString_ExceptionThrown(){
        // Arrange
        StreamHandler handler=Mockito.mock(StreamHandler.class);
        SHParser parser = new SHParser(handler);

        //Act
        parser.countEntries(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void swapString_NullFindString_ExceptionThrown(){
        // Arrange
        StreamHandler handler=Mockito.mock(StreamHandler.class);
        SHParser parser = new SHParser(handler);

        //Act
        parser.swapString(null,"test");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void swapString_NullSwapString_ExceptionThrown(){
        // Arrange
        StreamHandler handler=Mockito.mock(StreamHandler.class);
        SHParser parser = new SHParser(handler);

        //Act
        parser.swapString("dsa",null);
    }

}
