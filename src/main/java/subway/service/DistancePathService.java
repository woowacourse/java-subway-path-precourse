package subway.service;

import subway.view.InputView;

import java.util.List;

import static subway.util.PathCalculator.calculateShortestDistancePath;
import static subway.view.InputView.*;

public class DistancePathService {

    public static void serviceStart() {
        String startStationName = inputStartStation();
        String endStationName = inputEndStation(startStationName);
        List<String> acrossStations = calculateShortestDistancePath(startStationName, endStationName);
    }

    public static int calculateTotalTime(List<String> acrossStations) {

    }

    public static int calculateTotalDistance(List<String> acrossStations) {

    }
}
