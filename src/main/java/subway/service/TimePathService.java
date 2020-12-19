package subway.service;

import subway.view.InputView;

import static subway.util.PathCalculator.calculateShortestTimePath;
import static subway.view.InputView.*;

public class TimePathService {

    public static void serviceStart() {
        String startStationName = inputStartStation();
        String endStationName = inputEndStation(startStationName);
        calculateShortestTimePath(startStationName, endStationName);
    }
}
