package subway.domain;

import java.util.List;

public class ShortenPathDTO {

    private final int totalDistance;

    private final int totalElapsedTime;

    private final List<String> stationNames;

    public ShortenPathDTO(int totalDistance, int totalElapsedTime,
                          List<String> stationNames) {
        this.totalDistance = totalDistance;
        this.totalElapsedTime = totalElapsedTime;
        this.stationNames = stationNames;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public int getTotalElapsedTime() {
        return totalElapsedTime;
    }

    public List<String> getStationNames() {
        return stationNames;
    }
}
