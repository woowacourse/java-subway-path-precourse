package subway.service;

public class TimePathService {

    public static void serviceStart() {
        String startStationName = inputView.inputStartStation();
        inputView.inputEndStation(startStationName);
        calculateShortestTimePath(startStationName, endStationName);
    }
}
