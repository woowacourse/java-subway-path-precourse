package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Section {
    private List<Station> stations;
    private Station station1;
    private Station station2;
    private int distance;
    private int time;

    public Section(Station station1, Station station2, int distance, int time) {
        this.station1 = station1;
        this.station2 = station2;
        this.distance = distance;
        this.time = time;
        stations = new ArrayList<>();
        stations.add(station1);
        stations.add(station2);

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

    public Station getAnotherStation(Station station) {
        stations.remove(station);
        return stations.get(0);
    }

    public boolean contains(Station station) {
        if(Objects.equals(station, station1) || Objects.equals(station, station2)) {
            return true;
        }
        return false;
    }
}
