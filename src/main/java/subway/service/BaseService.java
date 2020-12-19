package subway.service;

import subway.domain.NearbyStation;
import subway.domain.Station;
import subway.service.dto.DistanceAndTimeDto;

import java.util.List;

import static subway.domain.StationRepository.findStationByName;

public class BaseService {

    protected static DistanceAndTimeDto calculateTotalTimeAndDistance(List<String> passByStations) {
        int size = passByStations.size();
        int timeSum = 0;
        int distanceSum = 0;
        for (int i = 0; i < size - 1; i++) {
            Station startStation = findStationByName(passByStations.get(i));
            NearbyStation nearbyStation = startStation.findNearbyStationByName(passByStations.get(i + 1));
            timeSum += nearbyStation.getTime();
            distanceSum += nearbyStation.getDistance();
        }
        return DistanceAndTimeDto.of(distanceSum, timeSum);
    }
}
