package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    private List<String> lineList = new ArrayList<>();

    public void addLine(String lineName) {
        lineList.add(lineName);
    }

    public boolean includedLine(String lineName) {
        return lineList.contains(lineName);
    }

    private List<Section> sectionList = new ArrayList<>();

    public Station addSection(String linkedStationName, int distance, int time) {
        sectionList.add(new Section(linkedStationName, distance, time));
        return this;
    }

    public List<Section> sections() {
        return Collections.unmodifiableList(sectionList);
    }

    public int getSectionDistance(String stationName) {
        for (Section section : sectionList) {
            if (section.getLinkedStationName().equals(stationName)) {
                return section.getDistance();
            }
        }
        return 0;
    }

    public int getSectionTime(String stationName) {
        for (Section section : sectionList) {
            if (section.getLinkedStationName().equals(stationName)) {
                return section.getTime();
            }
        }
        return 0;
    }
}
