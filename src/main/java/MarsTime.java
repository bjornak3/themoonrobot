import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarsTime {
    static final int maxHours = 25;
    static final int maxMinutes = 100;

    private final int currentHour;
    private final int currentMinute;

    MarsTime() {
        currentHour = 0;
        currentMinute = 0;
    }

    private MarsTime(int hour, int minute) {
        currentHour = hour;
        currentMinute = minute;
    }

    static MarsTime with(int hour, int minute) throws Exception {
        if (hour > maxHours || hour < 0) {
            throw new Exception("Hours out of bound");
        }

        if (minute > maxHours || minute < 0) {
            throw new Exception("Hours out of bound");
        }

        return new MarsTime(hour, minute);
    }

    static MarsTime parseFromString(String string) throws Exception, NumberFormatException {
        final Pattern pattern = Pattern.compile("(?m)^(\\d\\d:\\d\\d)");
        final Matcher matcher = pattern.matcher(string);
        int hours = 0;
        int minutes = 0;

        if (matcher.find()) {
            String group = matcher.group(1);
            String hourString = group.split(":")[0];
            String minuteString = group.split(":")[1];

            hours = Integer.parseInt(hourString);
            minutes = Integer.parseInt(minuteString);
        } else {
            throw new Exception("Hour not found");
        }

        return MarsTime.with(hours, minutes);
    }

    int toMinutes() {
        return currentHour * maxMinutes + currentMinute;
    }

    int intervalTo(MarsTime time) {
        return time.toMinutes() - this.toMinutes();
    }

    int intervalWithNextDay(MarsTime time) {
        int interval = this.intervalTo(time);

        if (interval < 0) {
            interval += maxHours * maxMinutes;
        }

        return interval;
    }
}
