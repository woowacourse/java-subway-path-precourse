package subway.domain;

public class DistanceAndTime {
    private int distance;
    private int time;

    public DistanceAndTime(int distance, int time) {
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
