package subway.domain;

import java.util.List;

public class Path {
    private Line line;
    private List<Station> stationList;
    private PathDistanceWeight pathDistanceWeight;
    private PathTimeWeight pathTimeWeight;


    public Path(Line line, List<Station> stations, List<Integer> distances, List<Integer> times) {
        this.line = line;
        registerStation(stations);
        this.pathDistanceWeight = new PathDistanceWeight(stations, distances);
        this.pathTimeWeight = new PathTimeWeight(stations, times);
    }

    private void registerStation(List<Station> stations) {
        for (Station station : stations) {
            stationList.add(station);
        }
    }

    public PathDistanceWeight getPathDistanceWeight() {
        return pathDistanceWeight;
    }

    public PathTimeWeight getPathTimeWeight() {
        return pathTimeWeight;
    }
}
