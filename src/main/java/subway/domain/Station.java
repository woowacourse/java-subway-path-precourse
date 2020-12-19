package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
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

    public List<ConnectData> ConnectDataList() {
        return Collections.unmodifiableList(ConnectDataList);
    }

    public void addConnectData(Station station, int distance, int time) {
        ConnectData connectData = new ConnectData(station, distance, time);
        ConnectDataList.add(connectData);
    }
}
