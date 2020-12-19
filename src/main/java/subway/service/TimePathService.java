package subway.service;

import subway.view.InputView;

import java.util.List;

import static subway.util.PathCalculator.calculateShortestTimePath;
import static subway.view.InputView.*;

public class TimePathService {

    public static void serviceStart() {
        String startStationName = inputStartStation();
        String endStationName = inputEndStation(startStationName);
        List<String> acrossStations = calculateShortestTimePath(startStationName, endStationName);
    }

    public static int calculateTotalTime(List<String> acrossStations) {

    }

    public static int calculateTotalDistance(List<String> acrossStations) {

    }
}
