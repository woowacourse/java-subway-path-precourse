package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Path {
    private int time;
    private int distance;
    private List<Station> stations;

    public Path(Station departure, int distance, int time) {
        this.stations = new ArrayList<Station>();
        this.stations.addAll(Arrays.asList(departure));
        this.distance = distance;
        this.time = time;
    }

    public Station getStation() {
        return stations.get(stations.size()-1);
    }

    public void addStation(Station nextStation) {
        stations.add(nextStation);
    }

    public void addDistance(int totalDistance) {
        distance += totalDistance;
    }

    public void addTime(int takingTime) {
        time += takingTime;
    }

    public int getDistance() {
        return distance;
    }
}
