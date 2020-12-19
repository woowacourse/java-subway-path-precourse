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

    // TODO :: 초기 설정을 위한 생성자, Setter 리펙토링

    public Line(String name, Station... newStations) {
        this.name = name;
        this.stations = new LinkedList<>(Arrays.asList(newStations));
    }

    public void addDistanceList(List<Integer> distanceList) {
        for (int index = 0; index < stations.size() - 1; index++) {
            Station from = stations.get(index);
            Station to = stations.get(index + 1);
            DistanceGraph.addEdgeByDistance(from, to, distanceList.get(index));
        }
    }

    public void addTakeTimeList(List<Integer> takeTime) {
        for (int index = 0; index < stations.size() - 1; index++) {
            Station from = stations.get(index);
            Station to = stations.get(index + 1);
            TakeTimeGraph.addEdgeByTime(from, to, takeTime.get(index));
        }
    }

    public String getName() {
        return name;
    }
}
