package test.com.softserve.edu.task1;

import com.softserve.edu.task1.ChessBoard;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.SyncFailedException;

/**
 * Created by TDK on 01.06.2017.
 */
public class ChessBoardTest {

    @Test
    public void createObject_RightConditions_BoardCreated() {
        ChessBoard board = new ChessBoard(10, 5);

        Assert.assertEquals(board.getLength(), 5);
        Assert.assertEquals(board.getWidth(), 10);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void createObject_NegativeLength_ExceptionThrown() {
        ChessBoard board = new ChessBoard(10, -5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void createObject_NegativeWidth_ExceptionThrown() {
        ChessBoard board = new ChessBoard(-10, 5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void setWidth_NegativeLength_ExceptionThrown() {
        ChessBoard board = new ChessBoard(10, 5);

        board.setLength(-10);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void setLength_NegativeWidth_ExceptionThrown() {
        ChessBoard board = new ChessBoard(10, 5);

        board.setWidth(-15);
    }

    @Test
    public void createBoard_BoardCreated() {
        // Arrange
        String expected = "* * * * " + "\r\n"
                + " * * * *" + "\r\n"
                + "* * * * " + "\r\n"
                + " * * * *" + "\r\n";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;
        System.setOut(new PrintStream(baos));


        // Act
        ChessBoard board = new ChessBoard(8, 4);
        board.drawBoard();
        System.setOut(oldOut);
        // Assert
        Assert.assertEquals(baos.toString(), expected);
    }
}
