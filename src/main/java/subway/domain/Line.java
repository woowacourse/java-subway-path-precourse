package subway.domain;

import java.util.LinkedList;

import static resource.TextResource.*;

public class Line {

    private String name;
    private StationsInLine stations;
    private Paths paths;

    public Line(String name, Station startStation, Station endStation, Path path) {
        this.name = name;
        checkValid(startStation.getName(), endStation.getName());
        createStationInLine(startStation, endStation);
        createPaths(path);
    }

    private void checkValid(String startStation, String endStation) {
        if (startStation.equals(endStation)) {
            throw new IllegalArgumentException(ERROR_START_END_STATION_DUPLICATED);
        }
    }

    private void createStationInLine(Station startStation, Station endStation) {
        LinkedList<Station> stations = new LinkedList<>();
        stations.addFirst(startStation);
        stations.addLast(endStation);
        this.stations = new StationsInLine(stations);
    }

    private void createPaths(Path path) {
        LinkedList<Path> paths = new LinkedList<>();
        paths.addFirst(path);
        this.paths = new Paths(paths);
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station, int order) {
        stations.addStation(station, order);
    }

    public void addPath(Path path, int order) {
        int limit = stations.getSize();
        paths.addPath(path, order, limit);
    }

    public StationsInLine getStations() {
        return stations;
    }

    public Paths getPaths() {
        return paths;
    }


}
