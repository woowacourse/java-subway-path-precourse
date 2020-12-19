package subway.service.initialization;

import subway.domain.Stations;
import subway.repository.DistanceMapRepository;
import subway.repository.StationRepository;
import subway.repository.StationsRepository;
import subway.service.StationService;
import subway.type.DistanceType;

import java.util.ArrayList;
import java.util.List;

public class DistanceMapInitialization {
    public static void initializeDistanceMap() {
        initializeDistanceMapStations();
        initializeStationsConnectionWithDistance();
    }

    public static void initializeDistanceMapStations() {
        List<String> stationNames = StationService.stationNames();

        for (String stationName : stationNames) {
            DistanceMapRepository.addStationForDistanceMap(stationName);
        }
    }

    public static void initializeStationsConnectionWithDistance() {
        List<Stations> upDownStations = StationsRepository.upDownStations();
        List<Integer> distance = initializeDistance();

        for (int i = 0; i < upDownStations.size(); i++) {
            DistanceMapRepository
                    .connectStationsWithDistance(upDownStations.get(i), distance.get(i));
        }
    }

    public static List<Integer> initializeDistance() {
        List<Integer> distance = new ArrayList<>();

        distance.add(DistanceType.EDUCATION_UNIVERSITY_TO_GANGNAM.getDistance());
        distance.add(DistanceType.GANGNAM_TO_YEOKSAM.getDistance());
        distance.add(DistanceType.EDUCATION_UNIVERSITY_TO_NAMBU_TERMINAL.getDistance());
        distance.add(DistanceType.NAMBU_TERMINAL_TO_YANGJAE.getDistance());
        distance.add(DistanceType.YANGJAE_TO_MAEBONG.getDistance());
        distance.add(DistanceType.GANGNAM_TO_YANGJAE.getDistance());
        distance.add(DistanceType.YANGJAE_TO_YANGJAE_FOREST.getDistance());

        return distance;
    }
}
