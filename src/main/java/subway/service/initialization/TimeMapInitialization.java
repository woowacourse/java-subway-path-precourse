package subway.service.initialization;

import subway.domain.Stations;
import subway.repository.StationRepository;
import subway.repository.StationsRepository;
import subway.repository.TimeMapRepository;
import subway.service.StationService;
import subway.type.TimeType;

import java.util.ArrayList;
import java.util.List;

public class TimeMapInitialization {
    public static void initializeTimeMap() {
        initializeTimeMapStations();
        initializeStationsConnectionWithTime();
    }

    public static void initializeTimeMapStations() {
        List<String> stationsNames = StationService.stationNames();

        for (String stationName : stationsNames) {
            TimeMapRepository.addStationForTimeMap(stationName);
        }
    }

    public static void initializeStationsConnectionWithTime() {
        List<Stations> upDownStations = StationsRepository.upDownStations();
        List<Integer> time = initializeTime();

        for (int i = 0; i < upDownStations.size(); i++) {
            TimeMapRepository.connectStationsWithTime(upDownStations.get(i), time.get(i));
        }
    }

    public static List<Integer> initializeTime() {
        List<Integer> time = new ArrayList<>();

        time.add(TimeType.EDUCATION_UNIVERSITY_TO_GANGNAM.getTime());
        time.add(TimeType.GANGNAM_TO_YEOKSAM.getTime());
        time.add(TimeType.EDUCATION_UNIVERSITY_TO_NAMBU_TERMINAL.getTime());
        time.add(TimeType.NAMBU_TERMINAL_TO_YANGJAE.getTime());
        time.add(TimeType.YANGJAE_TO_MAEBONG.getTime());
        time.add(TimeType.GANGNAM_TO_YANGJAE.getTime());
        time.add(TimeType.YANGJAE_TO_YANGJAE_FOREST.getTime());

        return time;
    }
}
