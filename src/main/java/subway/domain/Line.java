package subway.domain;

import java.util.LinkedList;
import java.util.List;
import subway.repository.StationRepository;

public class Line {
    private String name;
    private final List<Station> stations = new LinkedList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStationByName(String stationName) {
        Station station = StationRepository.findByName(stationName);
        stations.add(station);
    }
}
