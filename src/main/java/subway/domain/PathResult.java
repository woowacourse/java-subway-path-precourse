package subway.domain;

import java.util.List;

public class PathResult {
    private final List<Station> stations;
    private final int time;
    private final int distance;

    public PathResult(List<Station> stations, int time, int distance) {
        this.stations = stations;
        this.time = time;
        this.distance = distance;
    }

    public List<Station> getStations() {
        return stations;
    }

    public int getTime() {
        return time;
    }

    public int getDistance() {
        return distance;
    }
}
