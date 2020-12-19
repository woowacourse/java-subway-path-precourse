package subway.domain;

public class Distance {
    private int distance;
    private int time;

    public Distance(int distance, int time) {
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
