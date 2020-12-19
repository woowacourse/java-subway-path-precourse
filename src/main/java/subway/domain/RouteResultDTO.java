package subway.domain;

import java.util.List;

public class RouteResultDTO {

    private final List<String> path;
    private final Double DistanceWeight;
    private final Double timeWeight;

    public RouteResultDTO(List<String> path, Double DistanceWeight, Double timeWeight) {
        this.path = path;
        this.DistanceWeight = DistanceWeight;
        this.timeWeight = timeWeight;
    }

    public List<String> getPath() {
        return path;
    }

    public Integer getTimeWeight() {
        return timeWeight.intValue();
    }

    public Integer getDistanceWeight() {
        return DistanceWeight.intValue();
    }
}
