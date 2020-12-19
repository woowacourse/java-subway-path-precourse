package subway.domain;

public class Line {
    private String name;
    private LineStations stations;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addLineStation(Station station) {
        stations.addLineStation(station);
    }
}
