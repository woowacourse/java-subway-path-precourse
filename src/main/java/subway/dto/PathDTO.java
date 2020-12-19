package subway.dto;

import java.util.List;

public class PathDTO {
    private final List<String> stations;
    private final double cost;

    public PathDTO(List<String> stationsName, double cost) {
        this.stations = stationsName;
        this.cost = cost;
    }

    public List<String> getStationsNameList() {
        return this.stations;
    }

    public double getCost() {
        return cost;
    }
}
