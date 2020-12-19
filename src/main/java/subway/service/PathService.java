package subway.service;

import subway.domain.Path;
import subway.domain.PathRepository;
import subway.domain.Station;

public class PathService {

    public static void register(String departureStationName, String arrivalStationName,
        int distance, int time) {
        Station departureStation = StationService.searchOneByName(departureStationName);
        Station arrivalStation = StationService.searchOneByName(arrivalStationName);
        Path path = new Path(departureStation,arrivalStation,distance,time);
        PathRepository.addPath(path);
    }
}
