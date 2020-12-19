package subway.domain;

import subway.domain.validator.TimeValidator;

public class Time {
    public static final String unit = "분";

    private final int time;

    private Time(int time) {
        TimeValidator.checkIsPositive(time);
        this.time = time;
    }

    public static Time of(int time) {
        return new Time(time);
    }

    public int getTime() {
        return time;
    }
}
