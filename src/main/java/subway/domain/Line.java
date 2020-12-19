package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int ORDER_CONSTANT = 1;

    private String name;
    private List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void addStation(Station station, int order) {
        int indexOrder = order - ORDER_CONSTANT;
        stations.add(indexOrder,station);
    }

    public void addStationByName(String stationName, int order) {
        for (int i = 0; i < StationRepository.stations().size(); i++) {
            Station station = StationRepository.stations().get(i);
            if (station.getName().equals(stationName)) {
                addStation(station, order);
            }
        }
    }
}
