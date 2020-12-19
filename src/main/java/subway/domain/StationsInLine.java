package subway.domain;

import java.util.LinkedList;

import static resource.TextResource.ERROR_STATION_DUPLICATED_IN_SECTION;
import static resource.TextResource.ERROR_ORDER_NOT_VALID;

public class StationsInLine {
    private LinkedList<Station> stations;

    public StationsInLine(LinkedList<Station> stations) {
        this.stations = stations;
    }

    public void addStation(Station station, int order) {
        if (order < 1 || order > stations.size() + 1) {
            throw new IllegalArgumentException(ERROR_ORDER_NOT_VALID);
        }

        if (stations.contains(station)) {
            throw new IllegalArgumentException(ERROR_STATION_DUPLICATED_IN_SECTION);
        }

        stations.add(order - 1, station);
    }

    public Station getStation(int index) {
        return stations.get(index);
    }
    public int getSize() {
        return stations.size();
    }

}
