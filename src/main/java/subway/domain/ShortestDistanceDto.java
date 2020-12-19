package subway.domain;

import java.util.List;

public class ShortestDistanceDto {

    private List<Station> stationList;
    private int totalDistance;

    public ShortestDistanceDto(List<Station> stationList, int totalDistance) {
        this.stationList = stationList;
        this.totalDistance = totalDistance;
    }

    public List<Station> getStationList() {
        return stationList;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

}
