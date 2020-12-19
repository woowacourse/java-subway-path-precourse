package subway.domain;

import java.util.LinkedList;

import static resource.TextResource.ERROR_NOT_EXISTENCE_STATION;
import static resource.TextResource.ERROR_START_END_STATION_DUPLICATED;

public class Line {

    private String name;
    private StationsInLine stations;

    public Line(String name, Station startStation, Station endStation) {
        this.name = name;
        checkValid(startStation.getName(), endStation.getName());
        createStationInLine(startStation, endStation);
    }

    private void checkValid(String startStation, String endStation) {
        if (startStation.equals(endStation)) {
            throw new IllegalArgumentException(ERROR_START_END_STATION_DUPLICATED);
        }
    }

    private void createStationInLine(Station startStation, Station endStation) {
        LinkedList<Station> stations = new LinkedList<>();
        stations.add(startStation);
        stations.add(endStation);
        this.stations = new StationsInLine(stations);
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station, int order) {
        stations.addStation(station, order);
    }
}
