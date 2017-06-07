package com.softserve.edu.task2;

import com.softserve.edu.task2.Envelope;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by TDK on 02.06.2017.
 */
public class EnvelopeTest {

    @Test
    public void createObject_RigthConditions_ObjectCreated(){
        Envelope envelope = new Envelope(15.6, 17.5);

        Assert.assertEquals(15.6,envelope.getWidth());
        Assert.assertEquals(17.5,envelope.getHeight());
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void createObject_NegativeWidthPositiveHeight_ExceptionThrown(){
        Envelope envelope = new Envelope(-15.6, 17.5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void createObject_PositiveWidthNegativeHeight_ExceptionThrown(){
        Envelope envelope = new Envelope(15.6, -17.5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void createObject_ZeroWidthPositiveHeight_ExceptionThrown(){
        Envelope envelope = new Envelope(0, -17.5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void createObject_PositiveWidthZeroHeight_ExceptionThrown(){
        Envelope envelope = new Envelope(15.6, -17.5);
    }

    @Test
    public void compareEnvelopes_FirstIsBiggerRightOrientation_ResultGot(){
        Envelope envelope1 = new Envelope(17.6, 19.5);
        Envelope envelope2 = new Envelope(16.6, 18.5);

        int expected = 1;
        int actual = envelope1.compare(envelope2);

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void compareEnvelopes_SecondIsBiggerRightOrientation_ResultGot(){
        Envelope envelope1 = new Envelope(15.6, 17.5);
        Envelope envelope2 = new Envelope(16.6, 18.5);

        int expected = -1;
        int actual = envelope1.compare(envelope2);

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void compareEnvelopes_CantPutOneInAnother_ResultGot(){
        Envelope envelope1 = new Envelope(15.6, 17.5);
        Envelope envelope2 = new Envelope(18.6, 14.5);

        int expected = 0;
        int actual = envelope1.compare(envelope2);

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void compareEnvelopes_EnvelopesAreEqual_ResultGot(){
        Envelope envelope1 = new Envelope(15.6, 17.5);
        Envelope envelope2 = new Envelope(15.6, 17.5);

        int expected = 0;
        int actual = envelope1.compare(envelope2);

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void compareEnvelopes_FirstIsBiggerAnotherOrientation_ResultGot(){
        Envelope envelope1 = new Envelope(15.6, 17.5);
        Envelope envelope2 = new Envelope(16.6, 14.5);

        int expected = 1;
        int actual = envelope1.compare(envelope2);

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void compareEnvelopes_SecondIsBiggerAnotherOrientation_ResultGot(){
        Envelope envelope1 = new Envelope(16.6, 14.5);
        Envelope envelope2 = new Envelope(15.6, 17.5);

        int expected = -1;
        int actual = envelope1.compare(envelope2);

        Assert.assertEquals(actual,expected);
    }

}
