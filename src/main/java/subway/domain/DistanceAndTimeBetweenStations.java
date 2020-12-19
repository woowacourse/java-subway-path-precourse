package subway.domain;

public class DistanceAndTimeBetweenStations {
    private final int distance;
    private final int time;

    public DistanceAndTimeBetweenStations(int distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
