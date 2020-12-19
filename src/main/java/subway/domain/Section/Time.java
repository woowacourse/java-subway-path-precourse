package subway.domain.section;

import java.time.Duration;
import java.util.Objects;
import subway.exception.InvalidTimeException;

public class Time {

    private static final long MINUTE_PER = 60;
    private static final String TIME_UNIT = "분";
    private static final long MIN_TIME_MINUTE = 1;

    private Duration time;

    private Time(Duration time) {
        this.time = time;
    }

    public static Time of(long minute) {

        if (minute < MIN_TIME_MINUTE) {
            throw new InvalidTimeException(minute);
        }
        return new Time(Duration.ofMinutes(minute));
    }

    public Time add(Time time) {
        return Time.of(getMinute() + time.getMinute());
    }

    public long getMinute() {
        return time.getSeconds() / MINUTE_PER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Time time1 = (Time) o;
        return Objects.equals(time, time1.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time);
    }

    @Override
    public String toString() {
        return getMinute() + TIME_UNIT;
    }
}
