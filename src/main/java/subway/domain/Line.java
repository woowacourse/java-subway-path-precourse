package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<String> stationNames = new ArrayList<>();
//    private List<Integer> intervalDistances = new ArrayList<>();
//    private List<Integer> intervalTimes = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStation(int index, String name) {
        stationNames.add(index-1, name);
    }

//    public void addDistances(int index, int distance) {
//        intervalDistances.add(index, distance);
//    }
//
//    public void addTimes(int index, int time) {
//        intervalTimes.add(index, time);
//    }

    public void displayLine() {
        for (String station : stationNames)
            System.out.println("[INFO] " + station);
        System.out.println();
    }

    public int getSize() {
        return stationNames.size();
    }
}
