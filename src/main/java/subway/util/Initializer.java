package subway.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import subway.domain.Gap;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Initializer {

    private Initializer() {
    }

    private static void initializeStationRepository() {
        final Set<String> stationNameSet = new HashSet<>();
        for (final String[] stationNames : Constants.INITIAL_STATION_NAMES_IN_LINES) {
            stationNameSet.addAll(Arrays.asList(stationNames));
        }
        stationNameSet
            .forEach(stationName -> StationRepository.addStation(new Station(stationName)));
    }

    private static void initializeLineRepository() {
        Arrays.asList(Constants.INITIAL_LINE_NAMES)
            .forEach(lineName -> LineRepository.addLine(new Line(lineName)));
    }


    private static void initializeSectionRepository() {
        for (int i = 0; i < Constants.INITIAL_LINE_NAMES.length; i++) {
            final List<Gap> gaps = new LinkedList<>();
            Arrays.asList(Constants.INITIAL_GAPS_BETWEEN_STATIONS_OF_SECTIONS[i])
                .forEach(gap -> gaps.add(new Gap(gap[0], gap[1])));
            SectionRepository.addSectionByNames(
                Constants.INITIAL_LINE_NAMES[i],
                Constants.INITIAL_STATION_NAMES_IN_LINES[i],
                gaps
            );
        }
    }

    public static void initializeRepositories() {
        initializeStationRepository();
        initializeLineRepository();
        initializeSectionRepository();
    }
}
