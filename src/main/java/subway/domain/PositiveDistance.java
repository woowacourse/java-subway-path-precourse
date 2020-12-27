package subway.domain;

import subway.Constants;

public class PositiveDistance {
    private static final int POSITIVE_DISTANCE_LIMIT = 1;

    private int distance;

    public PositiveDistance(int distance) {
        if (distance < POSITIVE_DISTANCE_LIMIT) {
            throw new IllegalArgumentException(Constants.ERROR_DISTANCE_ONLY_POSITIVE);
        }
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
}
