package subway.domain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Line {
    private String name;
    public List<Station> stations;

    public Line(String name) {
        this.name = name;
    }

    public Line(String name, Station... newStations) {
        this.name = name;
        this.stations = new LinkedList<>(Arrays.asList(newStations));
    }

    public void addDistanceList(List<Distance> distanceList) {
        for (int index = 0; index < stations.size() - 1; index++) {
            Station from = stations.get(index);
            Station to = stations.get(index + 1);
            int distance = distanceList.get(index).getDistance();
            SearchGraph.addEdgeByDistance(from, to, distance);
        }
    }

    public void addTakeTimeList(List<Time> takeTime) {
        for (int index = 0; index < stations.size() - 1; index++) {
            Station from = stations.get(index);
            Station to = stations.get(index + 1);
            int time = takeTime.get(index).getTime();
            SearchGraph.addEdgeByTime(from, to, time);
        }
    }

    public String getName() {
        return name;
    }
}
