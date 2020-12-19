package subway.service;

import subway.view.InputView;

import static subway.util.PathCalculator.calculateShortestDistancePath;
import static subway.view.InputView.*;

public class DistancePathService {

    public static void serviceStart() {
        String startStationName = inputStartStation();
        String endStationName = inputEndStation(startStationName);
        calculateShortestDistancePath(startStationName, endStationName);
    }
}
