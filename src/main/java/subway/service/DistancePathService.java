package subway.service;

import subway.view.InputView;

public class DistancePathService {

    public static void serviceStart() {
        String startStationName = inputView.inputStartStation();
        inputView.inputEndStation(startStationName);
        calculateShortestDistancePath(startStationName, endStationName);
    }
}
