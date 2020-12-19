package subway.service;

import subway.domain.NearbyStation;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;

import java.util.List;

import static subway.util.PathCalculator.calculateShortestDistancePath;
import static subway.view.InputView.*;

public class DistancePathService {

    public static void serviceStart() {
        String startStationName = inputStartStation();
        String endStationName = inputEndStation(startStationName);
        List<String> acrossStations = calculateShortestDistancePath(startStationName, endStationName);
        int totalDistance = calculateTotalDistance(acrossStations);
        int totalTime = calculateTotalTime(acrossStations);
    }

    public static int calculateTotalTime(List<String> acrossStations) {
        int size = acrossStations.size();
        int sum = 0;
        for (int i = 0; i < size - 1; i++) {
            String startStationName = acrossStations.get(i);
            Station startStation = StationRepository.findStationByName(startStationName);
            String endStationName = acrossStations.get(i + 1);
            NearbyStation nearbyStation = startStation.findNearbyStationByName(endStationName);
            sum += nearbyStation.getTime();
        }
        return sum;
    }

    public static int calculateTotalDistance(List<String> acrossStations) {
        int size = acrossStations.size();
        int sum = 0;
        for (int i = 0; i < size - 1; i++) {
            String startStationName = acrossStations.get(i);
            Station startStation = StationRepository.findStationByName(startStationName);
            String endStationName = acrossStations.get(i + 1);
            NearbyStation nearbyStation = startStation.findNearbyStationByName(endStationName);
            sum += nearbyStation.getDistance();
        }
        return sum;
    }
}
