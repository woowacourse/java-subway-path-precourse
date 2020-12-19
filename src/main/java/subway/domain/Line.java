package subway.domain;

import java.util.List;

public class Line {
    private String name;
    private List<Station> stationList;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void addStationAtLine(Station station, int position) {
        stationList.add(position, station);
    }
}
