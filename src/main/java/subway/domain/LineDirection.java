package subway.domain;

import java.util.List;

public class LineDirection {

    private static final int DIFFERENCE_WITH_REPOSITORY = 1;

    public static final String NOT_MATCH_SIZE_ERROR = "[ERROR] 노선의 역들과 거리, 소요 시간간의 크기가 맞지 않습니다.";

    private final StationRepository stationRepository;

    private final Distances distances;

    private final ElapsedTimes elapsedTimes;

    public LineDirection(StationRepository stationRepository, Distances distances,
                         ElapsedTimes elapsedTimes) {
        this.stationRepository = stationRepository;
        this.distances = distances;
        this.elapsedTimes = elapsedTimes;

        checkSize();
    }

    public StationRepository getStationRepository() {
        return stationRepository;
    }

    public List<String> getStationNames() {
        return stationRepository.getStationNames();
    }

    public List<Integer> getDistances() {
        return distances.getDistances();
    }

    public List<Integer> getElapsedTimes() {
        return elapsedTimes.getTimes();
    }

    private void checkSize() {
        int stationRepositorySize = stationRepository.stations()
                .size();
        int distancesSize = distances.getDistances()
                .size();
        int timesSize = elapsedTimes.getTimes()
                .size();

        boolean matchesWithDistancesSize =
                (stationRepositorySize == distancesSize + DIFFERENCE_WITH_REPOSITORY);

        boolean matchesWithTimesSize =
                (stationRepositorySize == timesSize + DIFFERENCE_WITH_REPOSITORY);

        if (!matchesWithDistancesSize || !matchesWithTimesSize) {
            throw new IllegalArgumentException(NOT_MATCH_SIZE_ERROR);
        }
    }
}
