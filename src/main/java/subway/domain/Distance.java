package subway.domain;

public class Distance {

    private final int distance;

    private Distance(int distance) {
        this.distance = distance;
    }

    public static Distance newDistance(int distance) {
        return new Distance(distance);
    }

    public int getDistance() {
        return distance;
    }
}
