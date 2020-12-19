package subway.dto;

import subway.domain.Station;
import subway.util.CommonViewUtil;

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

    public int getPhysicalDistance() {
        return physicalDistance;
    }

    public int getTimeDistance() {
        return timeDistance;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CommonViewUtil.getInfoPrefix() + " ---\n");
        stringBuilder.append(CommonViewUtil.getInfoPrefix() + " 총 거리: " + this.physicalDistance + "km\n");
        stringBuilder.append(CommonViewUtil.getInfoPrefix() + " 총 소요 시간: " + this.timeDistance + "분\n");
        stringBuilder.append(CommonViewUtil.getInfoPrefix() + " ---\n");
        for (Station station : stationList) {
            stringBuilder.append(CommonViewUtil.getInfoPrefix() + " " + station.getName() + "\n");
        }
        return stringBuilder.toString();
    }
}
