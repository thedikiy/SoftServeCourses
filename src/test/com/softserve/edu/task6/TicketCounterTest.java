package test.com.softserve.edu.task6;

import com.softserve.edu.task6.Algorithm;
import com.softserve.edu.task6.TicketCounter;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by TDK on 01.06.2017.
 */
public class TicketCounterTest {


    @Test
    public void countTickets_MockedAlgorithm_Counted999999(){
        TicketCounter counter = new TicketCounter();
        Algorithm algorithmMocked = Mockito.mock(Algorithm.class);
        Mockito.when(algorithmMocked.isLuckyTicket(Mockito.anyObject()))
                .thenReturn(true);

        int count = counter.count(algorithmMocked);
        Mockito.verify(algorithmMocked, Mockito.times(
                1000000)).isLuckyTicket(Mockito.anyObject());
        Assert.assertEquals(count,1000000);
    }
}
