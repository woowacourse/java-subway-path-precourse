package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private final int 중간_사이에_삽입_인덱스 = 1;
    private String name;
    private ArrayList<Station> lineStations = new ArrayList<>();
    private ArrayList<DistanceAndTime> lineDistanceAndTimes = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void setLineStations(ArrayList<Station> lineStations) {
        this.lineStations = lineStations;
    }

    public void setTerminal(Station upTerminal, Station downTerninal) {
        this.lineStations.add(upTerminal);
        this.lineStations.add(downTerninal);
    }

    public void addStation(int index, Station station) {
        lineStations.add(index - 중간_사이에_삽입_인덱스, station);
    }

    public void deleteStation(String name) {
        lineStations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public List<Station> showStations() {
        return lineStations;
    }

    public void setLineDistances(ArrayList<DistanceAndTime> lineDistanceAndTimes) {
        this.lineDistanceAndTimes = lineDistanceAndTimes;
    }

    public ArrayList<DistanceAndTime> getLineDistances() {
        return lineDistanceAndTimes;
    }

    public ArrayList<Station> getLineStations() {
        return lineStations;
    }
}
