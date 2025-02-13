package subway.application.section.dto;

import java.util.ArrayList;
import java.util.List;

import subway.domain.station.Station;

public class ShortCostResponse {
    private int totalDistance;
    private int totalTime;
    private final List<String> stationNameList;

    public ShortCostResponse(List<Station> stationList) {
        this.stationNameList = new ArrayList<>();
        int length = stationList.size();
        for (int index = 0; index < length; index++) {
            Station source = stationList.get(index);
            if (index + 1 < length) {
                Station sink = stationList.get(index + 1);
                totalDistance += source.findDistanceTo(sink);
                totalTime += source.findTimeTo(sink);
            }
            stationNameList.add(source.getName());
        }
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(int totalDistance) {
        this.totalDistance = totalDistance;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public List<String> getStationNameList() {
        return stationNameList;
    }
}
