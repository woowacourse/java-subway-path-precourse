package subway.domain;

public class Path {
    private final int distance;
    private final int time;

    public Path(int distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getTime() {
        return this.time;
    }
}
