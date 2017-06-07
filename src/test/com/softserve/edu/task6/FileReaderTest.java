package test.com.softserve.edu.task6;

import com.softserve.edu.task6.FileReader;
import com.softserve.edu.task6.TicketAlgorithmType;
import com.sun.javafx.scene.traversal.Algorithm;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by TDK on 07.06.2017.
 */
public class FileReaderTest {
    @Test
    public void validateType_PiterString_AlgorithmTypePiterReturned() {
        //Arrange
        FileReader reader = new FileReader("123");
        TicketAlgorithmType expected = TicketAlgorithmType.PITER;
        //Act
        TicketAlgorithmType actual = reader.validateType("Piter");
        //Assert
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void validateType_PiterStringCamelCase_AlgorithmTypePiterReturned() {
        //Arrange
        FileReader reader = new FileReader("123");
        TicketAlgorithmType expected = TicketAlgorithmType.PITER;
        //Act
        TicketAlgorithmType actual = reader.validateType("PiTeR");
        //Assert
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void validateType_MoskowString_AlgorithmTypeMoskowReturned() {
        //Arrange
        FileReader reader = new FileReader("123");
        TicketAlgorithmType expected = TicketAlgorithmType.MOSKOW;
        //Act
        TicketAlgorithmType actual = reader.validateType("Moskow");
        //Assert
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void validateType_RandomString_AlgorithmTypeUnknownReturned() {
        //Arrange
        FileReader reader = new FileReader("123");
        TicketAlgorithmType expected = TicketAlgorithmType.UNKNOWN;
        //Act
        TicketAlgorithmType actual = reader.validateType("Mrerew");
        //Assert
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void validateType_StringContainsTwoWords_AlgorithmTypeUnknownReturned() {
        //Arrange
        FileReader reader = new FileReader("23156");
        TicketAlgorithmType expected = TicketAlgorithmType.UNKNOWN;
        //Act
        TicketAlgorithmType actual = reader.validateType("Piter Moskow");
        //Assert
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void validateType_StringContainsNewLine_AlgorithmTypeUnknownReturned() {
        //Arrange
        FileReader reader = new FileReader("123");
        TicketAlgorithmType expected = TicketAlgorithmType.UNKNOWN;
        //Act
        TicketAlgorithmType actual = reader.validateType("Piter\nMoskow");
        //Assert
        Assert.assertEquals(expected,actual);
    }
}
