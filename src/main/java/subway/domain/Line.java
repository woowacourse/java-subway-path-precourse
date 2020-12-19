package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private String name;
    private final List<Station> stationInLine = new ArrayList<>();
    private final List<Integer> distanceInterval = new ArrayList<>();
    private final List<Integer> timeInterval = new ArrayList<>();

    public Line(String name, String[] stations, int[] distance, int[] time) {
        this.name = name;
        for (String station : stations) {
            addStationInLine(StationRepository.findStationByName(station));
        }
        for (int i = 0; i < distance.length; i++) {
            addDistanceInterval(distance[i]);
            addTimeInterval(time[i]);
        }
    }

    private void addStationInLine(Station station) {
        stationInLine.add(station);
    }

    private void addDistanceInterval(int distance) {
        distanceInterval.add(distance);
    }

    private void addTimeInterval(int time) {
        timeInterval.add(time);
    }

    public void registerInterval() {
        Interval.registerIntervals(stationInLine, distanceInterval, timeInterval);
    }

    public String getName() {
        return name;
    }

    public List<Station> stationsInLine() {
        return Collections.unmodifiableList(stationInLine);
    }

}
