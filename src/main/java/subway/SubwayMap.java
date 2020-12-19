package subway;

import subway.Initialization.LineInitialization;
import subway.Initialization.SectionInitialization;
import subway.Initialization.StationInitialization;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import java.util.Arrays;

public class SubwayMap {

    public void run() {
        init();
    }

    private void init() {
        initStations();
        initLines();
    }

    private void initStations() {
        Arrays.stream(StationInitialization.values())
                .forEach(station -> StationRepository.addStation(new Station(station.getName())));
    }

    private void initLines() {
        Arrays.stream(LineInitialization.values())
                .forEach(line ->
                        LineRepository.addLine(
                                new Line(line.getName(),
                                        SectionInitialization.getSectionInitialization(line).sections()))
                );
    }


    public static SubwayMap getInstance() {
        return SubwayMap.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final SubwayMap INSTANCE = new SubwayMap();
    }
}