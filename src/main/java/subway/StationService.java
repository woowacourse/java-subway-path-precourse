package subway;

import subway.domain.Station;
import subway.domain.StationRepository;

public class StationService {

    public static void addStation(String name) {
        StationRepository.addStation(new Station(name));
    }

    public static void stationAddConnectData(String stationName, String connectStationName,
        int distance, int time) {
        Station station = StationRepository.getStation(stationName);
        Station connectStation = StationRepository.getStation(connectStationName);
        station.addConnectData(connectStation, distance, time);
    }

    public static int getDistance(String sourceStationName, String TargetStationName) {
        Station sourceStation = StationRepository.getStation(sourceStationName);
        Station targetStation = StationRepository.getStation(TargetStationName);
        int distance = sourceStation.getDistance(targetStation);
        if (distance == Station.ERROR_NUMBER) {
            distance = targetStation.getDistance(sourceStation);
        }
        return distance;
    }
}
