package subway.domain;

import java.util.ArrayList;
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

    public void addSection(String linkedStationName, int distance, int time) {
        sectionList.add(new Section(linkedStationName, distance, time));
    }
}
