package subway.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Line {
    private String name;
    private List<Station> stations = new ArrayList<>();
    private Map<Integer, Integer> distanceAndTime = new HashMap<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현

    public List<Station> getStation() {
        return stations;
    }

    public void addStation(Station station) {
        if (getStation().contains(station)) {
            return;
        }
        if (StationRepository.stations().contains(station)) {
            stations.add(station);
        }
    }
}
