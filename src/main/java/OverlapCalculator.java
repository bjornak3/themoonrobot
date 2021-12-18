public class OverlapCalculator {
    static int calculateOverlap(Moon lhsMoon, Moon rhsMoon) {
        if (rhsMoon.doesRiseAtTheSameTime(lhsMoon)) {
            return Math.min(rhsMoon.upTime(), lhsMoon.upTime());
        }

        Moon earliestRisingMoon = rhsMoon.doesRiseEarlier(lhsMoon) ? rhsMoon : lhsMoon;
        Moon latestRisingMoon = earliestRisingMoon == rhsMoon ? lhsMoon : rhsMoon;

        if (earliestRisingMoon.doesNotOverlap(latestRisingMoon)) {
            return 0;
        }

        if (earliestRisingMoon.doesOverlapAtTwilightWith(latestRisingMoon)) {
            return 1;
        }

        if (!earliestRisingMoon.doesSetLater(latestRisingMoon)) {
            return earliestRisingMoon.upTime() - earliestRisingMoon.riseDeltaTo(latestRisingMoon);
        }

        if (earliestRisingMoon.doesSetLater(latestRisingMoon)) {
            return latestRisingMoon.upTime();
        }

        return 0;
    }
}
