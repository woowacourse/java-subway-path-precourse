package subway.domain;

import java.util.ArrayList;

public class Line {
    private String name;
    private ArrayList<Station> section = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStation(String name) {
        Station station = StationRepository.searchStationByName(name);
        section.add(station);
    }

    // 추가 기능 구현

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n[INFO] ");
        sb.append(name);
        sb.append("\n[INFO] ");
        sb.append("---");
        for (Station station : section) {
            sb.append("\n[INFO] ");
            sb.append(station.getName());
        }
        return sb.toString();
    }
}
