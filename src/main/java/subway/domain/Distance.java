package subway.domain;

import subway.domain.validator.DistanceValidator;

public class Distance {
    public static final String unit = "km";
    private final int distance;

    private Distance(int distance) {
        DistanceValidator.checkIsPositive(distance);
        this.distance = distance;
    }

    public static Distance of(int distance) {
        return new Distance(distance);
    }

    public int getDistance() {
        return distance;
    }
}
