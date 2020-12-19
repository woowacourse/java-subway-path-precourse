package subway.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Initializer {

    private Initializer() {
    }

    private static void initializeStationRepository() {
        final Set<String> stationNameSet = new HashSet<>();
        for (String[] stationNames : Constants.INITIAL_STATION_NAMES_IN_LINES) {
            stationNameSet.addAll(Arrays.asList(stationNames));
        }
        stationNameSet
            .forEach(stationName -> StationRepository.addStation(new Station(stationName)));
    }

    private static void initializeLineRepository() {
        Arrays.asList(Constants.INITIAL_LINE_NAMES)
            .forEach(lineName -> LineRepository.addLine(new Line(lineName)));
    }

    public static void initializeRepositories() {
        initializeStationRepository();
        initializeLineRepository();
    }
}
