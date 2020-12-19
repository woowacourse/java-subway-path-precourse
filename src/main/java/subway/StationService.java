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

    public static int[] getDistanceAndTime(String sourceStationName, String TargetStationName) {
        Station sourceStation = StationRepository.getStation(sourceStationName);
        Station targetStation = StationRepository.getStation(TargetStationName);
        int[] data = sourceStation.getDistanceAndTime(targetStation);
        if (data[Station.DISTANCE_INDEX] == Station.ERROR_NUMBER) {
            data = targetStation.getDistanceAndTime(sourceStation);
        }
        return data;
    }
}
