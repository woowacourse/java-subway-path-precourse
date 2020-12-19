package subway.domain.section;

import java.util.Objects;
import subway.exception.InvalidDistanceException;

public class Distance {

    private static final long DISTANCE_MIN_LENGTH = 0;
    private static final String DISTANCE_UNIT = "km";

    private long distance;

    private Distance(long distance) {
        this.distance = distance;
    }

    public static Distance of(long distance) {

        if (distance <= DISTANCE_MIN_LENGTH) {
            throw new InvalidDistanceException(distance);
        }
        return new Distance(distance);
    }

    public Distance add(Distance distance) {
        return new Distance(this.distance + distance.distance);
    }

    @Override
    public String toString() {
        return distance + DISTANCE_UNIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Distance distance1 = (Distance) o;
        return distance == distance1.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
