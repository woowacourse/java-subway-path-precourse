package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private List<Station> stations = new ArrayList<>();
    private int time;
    private int distance;

    public Section(List<Station> stations, int time, int distance) {
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
