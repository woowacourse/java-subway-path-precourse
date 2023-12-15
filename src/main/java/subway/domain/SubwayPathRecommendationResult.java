package subway.domain;

import java.util.List;

public class SubwayPathRecommendationResult {
    private final int totalDistance;
    private final int totalTime;
    private final List<Station> stations;

    public SubwayPathRecommendationResult(int totalDistance, int totalTime, List<Station> stations) {
        this.totalDistance = totalDistance;
        this.totalTime = totalTime;
        this.stations = stations;
    }
}
