package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Station {
    private final String name;

    private final List<Station> connectedStations = new ArrayList<>();

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void addConnectedStation(Station connectedStation) {
        connectedStations.add(connectedStation);
    }

    public List<Station> getConnectedStations() {
        return connectedStations;
    }
}
