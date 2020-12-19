package subway.domain;

import java.util.Collections;
import java.util.List;

public class GraphResult {
    private List<Station> stations;
    private int distance;
    private int time;

    public GraphResult(List<Station> stations, int distance, int time) {
        this.stations = stations;
        this.distance = distance;
        this.time = time;
    }

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
