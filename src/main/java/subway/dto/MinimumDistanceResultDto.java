package subway.dto;

import subway.domain.Station;

import java.util.List;

public class MinimumDistanceResultDto {
    private List<Station> stationList;
    private int physicalDistance;
    private int timeDistance;

    public MinimumDistanceResultDto(List<Station> stationList, int physicalDistance, int timeDistance) {
        this.stationList = stationList;
        this.physicalDistance = physicalDistance;
        this.timeDistance = timeDistance;
    }

    public List<Station> getStationList() {
        return stationList;
    }

    public int getPhysicalDistance(){
        return physicalDistance;
    }

    public int getTimeDistance(){
        return timeDistance;
    }
}
