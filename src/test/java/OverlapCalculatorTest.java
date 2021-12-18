import org.junit.Assert;
import org.junit.Test;

public class OverlapCalculatorTest {

    @Test
    public void testPhobosRisesAndSetdWhileDeimos() throws Exception {
        Moon deimos = new Moon();
        deimos.riseTimestamp = MarsTime.with(14, 0);
        deimos.downTimestamp = MarsTime.with(22, 40);

        Moon phobos = new Moon();
        phobos.riseTimestamp = MarsTime.with(15, 88);
        phobos.downTimestamp = MarsTime.with(22, 7);

        int overlap = OverlapCalculator.calculateOverlap(deimos, phobos);

        Assert.assertEquals(619, overlap);
    }

    @Test
    public void testPhobosRisesAndSetsBeforeDeimos() throws Exception {
        Moon deimos = new Moon();
        deimos.riseTimestamp = MarsTime.with(14, 0);
        deimos.downTimestamp = MarsTime.with(22, 40);

        Moon phobos = new Moon();
        phobos.riseTimestamp = MarsTime.with(10, 20);
        phobos.downTimestamp = MarsTime.with(22, 7);

        int overlap = OverlapCalculator.calculateOverlap(deimos, phobos);

        Assert.assertEquals(807, overlap);
    }

    @Test
    public void testPhobosRisesAndSetsBeforeDeimosNextDay() throws Exception {
        Moon deimos = new Moon();
        deimos.riseTimestamp = MarsTime.with(18, 55);
        deimos.downTimestamp = MarsTime.with(4, 97);

        Moon phobos = new Moon();
        phobos.riseTimestamp = MarsTime.with(10, 39);
        phobos.downTimestamp = MarsTime.with(4, 0);

        int overlap = OverlapCalculator.calculateOverlap(deimos, phobos);

        Assert.assertEquals(1045, overlap);
    }

    @Test
    public void testTwilight() throws Exception {
        Moon deimos = new Moon();
        deimos.riseTimestamp = MarsTime.with(12, 32);
        deimos.downTimestamp = MarsTime.with(17, 6);

        Moon phobos = new Moon();
        phobos.riseTimestamp = MarsTime.with(17, 6);
        phobos.downTimestamp = MarsTime.with(19, 78);

        int overlap = OverlapCalculator.calculateOverlap(deimos, phobos);

        Assert.assertEquals(1, overlap);
    }
}
