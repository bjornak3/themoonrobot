public class Moon {
    MarsTime riseTimestamp;
    MarsTime downTimestamp;

    public Moon() {
        riseTimestamp = new MarsTime();
        downTimestamp = new MarsTime();
    }

    int upTime() {
        return riseTimestamp.intervalWithNextDay(downTimestamp);
    }

    int riseDeltaTo(Moon moon) {
        return riseTimestamp.intervalTo(moon.riseTimestamp);
    }

    boolean doesOverlapAtTwilightWith(Moon moon) {
        return upTime() == riseDeltaTo(moon);
    }

    boolean doesNotOverlap(Moon moon) {
        return upTime() < riseDeltaTo(moon);
    }

    boolean doesRiseAtTheSameTime(Moon moon) {
        return riseTimestamp == moon.riseTimestamp;
    }

    boolean doesRiseEarlier(Moon moon) {
        return riseTimestamp.intervalTo(moon.riseTimestamp) > 0;
    }

    boolean doesSetLater(Moon moon) {
        return upTime() > (riseDeltaTo(moon) + moon.upTime());
    }
}
