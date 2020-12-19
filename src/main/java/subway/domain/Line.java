package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stations;
    private List<Integer> distance;
    private List<Integer> time;

    public Line(String name, List<Station> stations, List<Integer> distance, List<Integer> time) {
        this.name = name;
        this.stations = stations;
        this.distance = distance;
        this.time = time;
    }

    public Station nextStation(Station station, int upDown) {
        int nextIndex = stations.indexOf(station) + upDown;
        if (stations.size() > nextIndex && nextIndex >= 0) {
            return stations.get(nextIndex);
        }
        return null;
    }

    public int totalDistance(Station station, int upDown) {
        if(!LineRepository.isNotTerminal(station)) {
            return 0;
        }
        int index = stations.indexOf(station);
        if (0 > upDown) {
            return distance.get(index-1);
        }
        return distance.get(index);
    }

    public int takingTime(Station station, int upDown) {
        if(!LineRepository.isNotTerminal(station)) {
            return 0;
        }
        int index = stations.indexOf(station);
        if (0 > upDown) {
            return time.get(index-1);
        }
        return time.get(index);
    }

    public String getName() {
        return name;
    }

    public boolean haveStation(Station station) {
        return stations.contains(station);
    }

    public List<Station> getTerminals() {
        return Arrays.asList(stations.get(0), stations.get(stations.size()-1));
    }
}
