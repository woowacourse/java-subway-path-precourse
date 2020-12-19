package subway.domain;

public class Path {
    private Station start;
    private Station end;
    private int distance;
    private int time;

    public Path(Station start, Station end, int distance, int time) {
        this.start = start;
        this.end = end;
        this.distance = distance;
        this.time = time;
    }

    public Station getStartStation() {
        return start;
    }

    public Station getEndStation() {
        return end;
    }

    public int getTime() {
        return time;
    }

    public int getDistance() {
        return distance;
    }
}
