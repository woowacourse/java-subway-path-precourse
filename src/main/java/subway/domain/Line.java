package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private String name;

    private List<Station> stations = new ArrayList<Station>();
    private List<Integer> times = new ArrayList<Integer>();
    private List<Integer> distances = new ArrayList<Integer>();

    public Line(String name) {
        this.name = name;
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public void addStation(Station station, int distanceToNextStation, int timeToNextStation) {
        stations.add(station);
        distances.add(distanceToNextStation);
        times.add(timeToNextStation);

    }

    public List<Station> getStations() {
        return stations;
    }

    public List<Integer> getTimes() {
        return times;
    }

    public List<Integer> getDistances() {
        return distances;
    }

    public String getName() {
        return name;
    }


}
