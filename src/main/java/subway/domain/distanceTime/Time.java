package subway.domain.distanceTime;

import subway.exception.DistanceTimeException;
import subway.exception.ErrorCode;

public class Time {
    private int minute;

    public Time(int minute) {
        this.minute = minute;
        validate(minute);
    }

    private void validate(int minute) {
        if (minute < 1) {
            throw new DistanceTimeException(ErrorCode.INPUT_VALUE_MUST_NATURAL);
        }
    }

    public int getMinute() {
        return minute;
    }
}
