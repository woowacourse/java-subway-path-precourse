package subway.service.dto;

public class DistanceAndTimeDto {
    private final int distance;
    private final int time;

    private DistanceAndTimeDto(int distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    public static DistanceAndTimeDto of(int distance, int time) {
        return new DistanceAndTimeDto(distance, time);
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
