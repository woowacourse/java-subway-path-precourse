package subway.domain;

import java.util.List;

public class PathResult {

    private double totalDistance;
    private double totalTime;
    private List<Station> stations;

    public PathResult(double totalDistance, double totalTime, List<Station> stations) {
        this.totalDistance = totalDistance;
        this.totalTime = totalTime;
        this.stations = stations;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public List<Station> getStations() {
        return stations;
    }
}
