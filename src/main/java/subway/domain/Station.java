package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.ConnectData;

public class Station {

    public static final int ERROR_NUMBER = -1;
    public static final int DISTANCE_INDEX = 0;
    public static final int TIME_INDEX = 1;

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

    public int[] getDistanceAndTime(Station station) {
        int[] data = {ERROR_NUMBER, ERROR_NUMBER};
        for (ConnectData connectData : ConnectDataList) {
            if (connectData.getStation().equals(station)) {
                data[DISTANCE_INDEX] = connectData.getDistance();
                data[TIME_INDEX] = connectData.getTime();
            }
        }
        return data;
    }

}
