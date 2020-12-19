package subway.domain;

public class Distance {

    private static final int MINIMUM_DISTANCE = 1;

    public static final String NOT_POSITIVE_ERROR = "[ERROR] 역 사이의 거리는 양의 정수이어야 합니다.";

    private final int distance;

    public Distance(int distance) {
        if (distance < MINIMUM_DISTANCE) {
            throw new IllegalArgumentException(NOT_POSITIVE_ERROR);
        }

        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
}
