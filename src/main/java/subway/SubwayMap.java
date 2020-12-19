package subway;

import subway.Initialization.StationInitialization;
import subway.domain.Station;
import subway.domain.StationRepository;
import java.util.Arrays;

public class SubwayMap {

    public void run() {
        init();
    }

    private void init() {
        initStations();
    }

    private void initStations() {
        Arrays.stream(StationInitialization.values())
                .forEach(station -> StationRepository.addStation(new Station(station.getName())));
    }

    public static SubwayMap getInstance() {
        return SubwayMap.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final SubwayMap INSTANCE = new SubwayMap();
    }
}