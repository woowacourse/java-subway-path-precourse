package subway.dto;

import java.util.List;

public class PathDTO {
    private final List<String> stations;
    private final double time;
    private final double distance;

    public PathDTO(List<String> stationsName, double time, double distance) {
        this.stations = stationsName;
        this.time = time;
        this.distance = distance;
    }

    public List<String> getStationsNameList() {
        return this.stations;
    }

    public double getTime() {
        return time;
    }

    public double getDistance() {
        return this.distance;
    }
}
