package subway.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import subway.pathfind.TimeAndDistance;

public class DistanceAndTimeBetweenStationsRepository {
    private static final Map<ConnectedStation, DistanceAndTimeBetweenStations> connectedStationMap
        = new LinkedHashMap<>();

    public static void addStations(String firstStationName, String secondStationName,
        int distance, int time) {
        Station firstStation = getStation(firstStationName);
        Station secondStation = getStation(secondStationName);
        addEachConnectedStation(firstStation, secondStation);
        storeStations(firstStation, secondStation);
        ConnectedStation connectedStation = createAndStoreConnectedStations(firstStation,
            secondStation);
        DistanceAndTimeBetweenStations distanceAndTimeBetweenStations
            = new DistanceAndTimeBetweenStations(distance, time);
        connectedStationMap.put(connectedStation, distanceAndTimeBetweenStations);
    }

    private static ConnectedStation createAndStoreConnectedStations(Station firstStation,
        Station secondStation) {
        ConnectedStation connectedStation = new ConnectedStation(firstStation, secondStation);
        ConnectedStationRepository.addConnectedStation(connectedStation);
        return connectedStation;
    }

    private static void storeStations(Station firstStation, Station secondStation) {
        StationRepository.addStation(firstStation);
        StationRepository.addStation(secondStation);
    }

    private static void addEachConnectedStation(Station firstStation, Station secondStation) {
        firstStation.addConnectedStation(secondStation);
        secondStation.addConnectedStation(firstStation);
    }

    private static Station getStation(String stationName) {
        Station foundStation = StationRepository.findByName(stationName);
        if (foundStation == null) {
            foundStation = new Station(stationName);
        }
        return foundStation;
    }

    public static TimeAndDistance getBetweenTimeAndDistance(Station currentStation,
        Station nextConnectedStation) {
        ConnectedStation connectedStation = ConnectedStationRepository
            .getConnectedStation(currentStation, nextConnectedStation);
        DistanceAndTimeBetweenStations distanceAndTimeBetweenStations = connectedStationMap
            .get(connectedStation);
        return new TimeAndDistance(
            distanceAndTimeBetweenStations.getTime(), distanceAndTimeBetweenStations.getDistance());
    }
}
