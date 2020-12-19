package subway.domain.data;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stationList = new ArrayList<>();
    private List<Integer> stationPathDistance = new ArrayList<>();
    private List<Integer> stationPathTime = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Station> getStationList() {
        return stationList;
    }

    public List<Integer> getStationPathDistance() {
        return stationPathDistance;
    }

    public List<Integer> getStationPathTime() {
        return stationPathTime;
    }

    public void addStationListInLine(List<Station> stations){
        for(Station station : stations){
            stationList.add(station);
        }
    }

    public void addStationPathDistanceListInLine(List<Integer> distanceList){
        for(int distance : distanceList){
            stationPathDistance.add(distance);
        }
    }

    public void addStationPathTimeListInLine(List<Integer> timeList){
        for(int time : timeList){
            stationPathTime.add(time);
        }
    }
}
