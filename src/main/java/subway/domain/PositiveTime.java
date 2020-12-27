package subway.domain;

import subway.Constants;

public class PositiveTime {
    private static final int POSITIVE_TIME_LIMIT = 1;

    private int time;

    public PositiveTime(int time) {
        if (time < POSITIVE_TIME_LIMIT) {
            throw new IllegalArgumentException(Constants.ERROR_TIME_ONLY_POSITIVE);
        }
        this.time = time;
    }

    public int getTime() {
        return time;
    }
}
