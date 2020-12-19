package subway.service;

import subway.domain.PathRepository;
import subway.domain.ShortestDistanceDto;
import subway.domain.ShortestTimeDto;
import subway.domain.Station;
import subway.service.validation.PathValidation;

public class PathService {

    public static ShortestDistanceDto getShortestDistancePath(String fromStationName,
        String toStationName) {
        if (PathValidation.checkGetShortestPath(fromStationName, toStationName)) {
            Station fromStation = StationService.getStationByName(fromStationName);
            Station toStation = StationService.getStationByName(toStationName);
            if (fromStation == null || toStation == null) {
                return null;
            }
            return PathRepository.getShortestDistancePath(fromStation, toStation);
        }
        return null;
    }

    public static ShortestTimeDto getShortestTimePath(String fromStationName,
        String toStationName) {
        if (PathValidation.checkGetShortestPath(fromStationName, toStationName)) {
            Station fromStation = StationService.getStationByName(fromStationName);
            Station toStation = StationService.getStationByName(toStationName);
            if (fromStation == null || toStation == null) {
                return null;
            }
            return PathRepository.getShortestTimePath(fromStation, toStation);
        }
        return null;
    }

    public static boolean isFromToStationConnected(String fromStationName, String toStationName) {
        Station fromStation = StationService.getStationByName(fromStationName);
        Station toStation = StationService.getStationByName(toStationName);
        return PathRepository.isConnectedStations(fromStation, toStation);
    }
}
