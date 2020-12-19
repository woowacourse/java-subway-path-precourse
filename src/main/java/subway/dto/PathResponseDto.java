package subway.dto;

import java.util.List;

public class PathResponseDto {

    private final int distanceTotal;
    private final int timeTotal;
    private final List<String> stationNames;

    public PathResponseDto(int distanceTotal, int timeTotal, List<String> stationNames) {
        this.distanceTotal = distanceTotal;
        this.timeTotal = timeTotal;
        this.stationNames = stationNames;
    }

    public int getDistanceTotal() {
        return distanceTotal;
    }

    public int getTimeTotal() {
        return timeTotal;
    }

    public List<String> getStationNames() {
        return stationNames;
    }
}
