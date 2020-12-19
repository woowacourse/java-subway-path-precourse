package subway.domain;

public class Line {
    private final String name;
    private final LineStations stations;

    public Line(String name) {
        this.name = name;
        this.stations = new LineStations();
    }

    public String getName() {
        return name;
    }

    public void addLineStation(Station station) {
        stations.addLineStation(station);
    }

    public Boolean isStationContained(Station station) {
        return stations.isContain(station);
    }
}
