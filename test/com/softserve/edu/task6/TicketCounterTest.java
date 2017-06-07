package com.softserve.edu.task6;

import com.softserve.edu.task6.TicketAlgorithm;
import com.softserve.edu.task6.TicketCounter;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by TDK on 01.06.2017.
 */
public class TicketCounterTest {
    @Test
    public void countTickets_MockedAlgorithmRange100to150_Times50Count50() {
        TicketCounter counter = new TicketCounter();
        TicketAlgorithm ticketAlgorithmMocked = Mockito.mock(TicketAlgorithm.class);
        Mockito.when(ticketAlgorithmMocked.isLuckyTicket(Mockito.anyObject()))
                .thenReturn(true);

        int count = counter.count(ticketAlgorithmMocked, 100, 150);
        Mockito.verify(ticketAlgorithmMocked, Mockito.times(
                50)).isLuckyTicket(Mockito.anyObject());
        Assert.assertEquals(count, 50);
    }

    @Test
    public void countTickets_MockedAlgorithmRange100to150_Times50Count0() {
        TicketCounter counter = new TicketCounter();
        TicketAlgorithm ticketAlgorithmMocked = Mockito.mock(TicketAlgorithm.class);
        Mockito.when(ticketAlgorithmMocked.isLuckyTicket(Mockito.anyObject()))
                .thenReturn(false);

        int count = counter.count(ticketAlgorithmMocked, 100, 150);
        Mockito.verify(ticketAlgorithmMocked, Mockito.times(
                50)).isLuckyTicket(Mockito.anyObject());
        Assert.assertEquals(count, 0);
    }
}