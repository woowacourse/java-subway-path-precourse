package subway.domain;

import static resource.TextResource.ERROR_DISTANCE_TIME_NOT_POSITIVE;

public class Path {
    private static int UNIT_DISTANCE = 1000;
    private static int UNIT_TIME = 60;

    private int distance;
    private int time;

    public Path(int distance, int time) {
        checkValid(distance, time);
        this.distance = distance * UNIT_DISTANCE;
        this.time = time * UNIT_TIME;
    }

    private void checkValid(int distance, int time) {
        if (distance < 0 || time < 0) {
            throw new IllegalArgumentException(ERROR_DISTANCE_TIME_NOT_POSITIVE);
        }
    }
}
