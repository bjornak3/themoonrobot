import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarsTimeTest {

    @Test
    public void testOneHourToMinutes() throws Exception {
        MarsTime time = MarsTime.with(1, 0);
        assertEquals(time.toMinutes(), 100);
    }

    @Test
    public void testTwoHoursFiftyMinutesToMinutes() throws Exception {
        MarsTime time = MarsTime.with(2, 50);
        assertEquals(time.toMinutes(), 250);
    }

    @Test
    public void testIntervalToSameTime() throws Exception {
        MarsTime time1 = MarsTime.with(2, 50);
        MarsTime time2 = MarsTime.with(2, 50);

        assertEquals(0, time1.intervalTo(time2));
    }

    @Test
    public void testIntervalToAfterOneHour() throws Exception {
        MarsTime time1 = MarsTime.with(2, 50);
        MarsTime time2 = MarsTime.with(3, 50);

        assertEquals(100, time1.intervalTo(time2));
    }

    @Test
    public void testIntervalToBeforeOneHour() throws Exception {
        MarsTime time1 = MarsTime.with(2, 50);
        MarsTime time2 = MarsTime.with(1, 50);

        assertEquals(-100, time1.intervalTo(time2));
    }

    @Test
    public void intervalWithNextDayAfterOneHour() throws Exception {
        MarsTime time1 = MarsTime.with(2, 50);
        MarsTime time2 = MarsTime.with(3, 50);

        assertEquals(100, time1.intervalWithNextDay(time2));
    }

    @Test
    public void intervalWithNextDayBeforeOneHour() throws Exception {
        MarsTime time1 = MarsTime.with(2, 50);
        MarsTime time2 = MarsTime.with(1, 50);

        assertEquals(2400, time1.intervalWithNextDay(time2));
    }
}
