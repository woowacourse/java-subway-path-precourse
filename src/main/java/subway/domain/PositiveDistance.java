package subway.domain;

public class PositiveDistance {
    private static final int POSITIVE_DISTANCE_LIMIT = 1;

    private int distance;

    public PositiveDistance(int distance) {
        if (distance < POSITIVE_DISTANCE_LIMIT) {
            throw new IllegalArgumentException("[ERROR] 거리는 양수입니다.");
        }
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
}
