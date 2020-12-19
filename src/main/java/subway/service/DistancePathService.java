package subway.service;

import subway.view.InputView;

import static subway.view.InputView.*;

public class DistancePathService {

    public static void serviceStart() {
        String startStationName = inputStartStation();
        String arrivedStationName = inputEndStation(startStationName);
        calculateShortestDistancePath(startStationName, endStationName);
    }
}
