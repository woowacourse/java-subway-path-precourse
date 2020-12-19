package subway.domain;

import static resource.TextResource.ERROR_DISTANCE_TIME_NOT_POSITIVE;

public class Path {

    private int distance;
    private int time;

    public Path(int distance, int time) {
        checkValid(distance, time);
        this.distance = distance;
        this.time = time;
    }

    private void checkValid(int distance, int time) {
        if (distance < 0 || time < 0) {
            throw new IllegalArgumentException(ERROR_DISTANCE_TIME_NOT_POSITIVE);
        }
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
