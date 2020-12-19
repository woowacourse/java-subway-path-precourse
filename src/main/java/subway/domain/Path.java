package subway.domain;

public class Path {
    private StationBetween stationBetween;
    private int distance;
    private int time;

    public Path(StationBetween stationBetween, int distance, int time) {
        this.stationBetween = stationBetween;
        this.distance = distance;
        this.time = time;
    }

    public Station getStartStation() {
        return stationBetween.getStart();
    }

    public Station getEndStation() {
        return stationBetween.getEnd();
    }

    public int getTime() {
        return time;
    }

    public int getDistance() {
        return distance;
    }
}
