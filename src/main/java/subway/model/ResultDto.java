package subway.model;

import java.util.List;
import subway.domain.Station;

public class ResultDto {

    private final long totalDistance;
    private final long totalTime;
    private final List<Station> path;

    public ResultDto(long totalDistance, long totalTime, List<Station> path) {
        this.totalDistance = totalDistance;
        this.totalTime = totalTime;
        this.path = path;
    }

    public long getTotalDistance() {
        return totalDistance;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public List<Station> getPath() {
        return path;
    }
}
