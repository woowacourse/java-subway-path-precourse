package subway.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class DistanceAndTimeBetweenStationsRepository {
    private static final Map<ConnectedStations, DistanceAndTimeBetweenStations> connectedStationsMap
        = new LinkedHashMap<>();

    public static void addStations(String firstStationName, String secondStationName,
        int distance, int time) {
        Station firstStation = new Station(firstStationName);
        Station secondStation = new Station(secondStationName);
        ConnectedStations connectedStations = new ConnectedStations(firstStation, secondStation);
        ConnectedStationsRepository.addConnectedStations(connectedStations);
        DistanceAndTimeBetweenStations distanceAndTimeBetweenStations
            = new DistanceAndTimeBetweenStations(distance, time);
        connectedStationsMap.put(connectedStations, distanceAndTimeBetweenStations);
    }
}
