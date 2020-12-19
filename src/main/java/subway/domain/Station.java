package subway.domain;

import java.util.ArrayList;
import java.util.List;
import subway.ConnectData;

public class Station {

    private String name;
    private List<ConnectData> ConnectDataList = new ArrayList<>();

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isEqualName(String name) {
        return name.equals(this.name);
    }

    public void addConnectData(String stationName, int distance, int time) {
        Station station = StationRepository.getStation(stationName);
        ConnectData connectData = new ConnectData(station, distance, time);
        ConnectDataList.add(connectData);
    }
}
