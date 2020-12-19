package subway.domain;

import java.util.List;

public class ShortestTimeDto {

    private List<Station> stationList;
    private int totalTime;

    public ShortestTimeDto(List<Station> stationList, int totalTime) {
        this.stationList = stationList;
        this.totalTime = totalTime;
    }

    public List<Station> getStationList() {
        return stationList;
    }

    public int getTotalTime() {
        return totalTime;
    }
}
