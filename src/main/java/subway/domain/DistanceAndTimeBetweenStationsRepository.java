package subway.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import subway.TimeAndDistance;

public class DistanceAndTimeBetweenStationsRepository {
    private static final Map<ConnectedStation, DistanceAndTimeBetweenStations> connectedStationMap
        = new LinkedHashMap<>();

    public static void addStations(String firstStationName, String secondStationName,
        int distance, int time) {
        Station firstStation = getStation(firstStationName);
        Station secondStation = getStation(secondStationName);
        firstStation.addConnectedStation(secondStation);
        secondStation.addConnectedStation(firstStation);
        StationRepository.addStation(firstStation);
        StationRepository.addStation(secondStation);
        ConnectedStation connectedStation = new ConnectedStation(firstStation, secondStation);
        ConnectedStationRepository.addConnectedStation(connectedStation);
        DistanceAndTimeBetweenStations distanceAndTimeBetweenStations
            = new DistanceAndTimeBetweenStations(distance, time);
        connectedStationMap.put(connectedStation, distanceAndTimeBetweenStations);
    }

    private static Station getStation(String stationName) {
        Station foundStation = StationRepository.findByName(stationName);
        if (foundStation == null) {
            foundStation = new Station(stationName);
        }
        return foundStation;
    }

    public static void calculateMinimumTimePath(Station startStation, Station endStation) {

        ConnectedStation connectedStation = ConnectedStationRepository
            .getConnectedStation(startStation, endStation);
    }

    public static TimeAndDistance getBetweenTimeAndDistance(Station currentStation,
        Station nextConnectedStation) {
        ConnectedStation connectedStation = ConnectedStationRepository
            .getConnectedStation(currentStation, nextConnectedStation);
        DistanceAndTimeBetweenStations distanceAndTimeBetweenStations = connectedStationMap
            .get(connectedStation);
        TimeAndDistance timeAndDistance = new TimeAndDistance(
            distanceAndTimeBetweenStations.getTime(), distanceAndTimeBetweenStations.getDistance());
        return timeAndDistance;
    }
}
