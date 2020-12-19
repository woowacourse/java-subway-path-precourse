package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Station {
    private static final String NEXT_STATION_NOT_EXIST_ERROR = "[ERROR] 역이 연결되어 있지 않습니다.";
    private List<Edge> edges = new ArrayList<>();
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isSame(String name) {
        return this.name.equals(name);
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public int getNextStationDistance(Station station) {
        for (Edge edge : edges) {
            if (edge.isNextStation(station)) {
                return edge.getDistance();
            }
        }
        throw new IllegalArgumentException(NEXT_STATION_NOT_EXIST_ERROR);
    }

    public int getNextStationTime(Station station) {
        for (Edge edge : edges) {
            if (edge.isNextStation(station)) {
                return edge.getTime();
            }
        }
        throw new IllegalArgumentException(NEXT_STATION_NOT_EXIST_ERROR);
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    // 추가 기능 구현
}
