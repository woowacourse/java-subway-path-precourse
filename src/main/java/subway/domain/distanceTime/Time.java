package subway.domain.distanceTime;

import java.math.BigDecimal;

public class Time {
    private BigDecimal minute;

    public Time(BigDecimal minute) {
        this.minute = minute;
    }

    public static Time minute(long minute) {
        return new Time(BigDecimal.valueOf(minute));
    }
}
