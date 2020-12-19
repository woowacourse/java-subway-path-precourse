package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private List<Station> stations;
    private int distance;
    private int time;

    public Section(Station station1, Station station2, int distance, int time)
    {
        stations = new ArrayList<>();
        stations.add(station1);
        stations.add(station2);
        this.distance = distance;
        this.time = time;
    }

    public List<Station> getStations() {
        return stations;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
