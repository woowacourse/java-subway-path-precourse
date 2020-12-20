package subway.service;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.PathRepository;
import subway.domain.SearchType;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.dto.ShortestPathDto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PathService {
    private static final String DUPLICATION_STATION_NAME_ERROR = "역의 이름이 같으면 안 됩니다.";
    private static final String NON_EXISTENT_STATION__ERROR = "역이 존재하지 않습니다.";
    private static final String NON_EXISTENT_PATH_ERROR = "경로가 존재하지 않습니다.";
    private static final int ZERO = 0;
    // TODO: 치명적 실수-2 ...
    private static final int BEFORE_STATION_MINUS_NUMBER = 1;
    private static final int TOTAL_DISTANCE_INDEX = 0;
    private static final int TOTAL_TIME_INDEX = 1;

    public void addPath(String startStationName, String endStationName, int km, int minute) {
        Station startStation = StationRepository.selectByName(startStationName);
        Station endStation = StationRepository.selectByName(endStationName);
        PathRepository.addPath(startStation, endStation, km, minute);
    }

    public ShortestPathDto calcShortestPath(String startStationName, String endStationName, SearchType searchType) {
        validate(startStationName, endStationName);
        List<String> shortestPath = getShortestPath(startStationName, endStationName, searchType);
        if (shortestPath == null || shortestPath.isEmpty()) {
            throw new IllegalArgumentException(NON_EXISTENT_PATH_ERROR);
        }
        List<Integer> weights = calcTotalWeight(shortestPath);
        int totalDistance = weights.get(TOTAL_DISTANCE_INDEX);
        int totalTime = weights.get(TOTAL_TIME_INDEX);
        return new ShortestPathDto(totalDistance, totalTime, shortestPath);
    }

    private void validate(String startStationName, String endStationName) {
        if (Objects.equals(startStationName, endStationName)) {
            throw new IllegalArgumentException(DUPLICATION_STATION_NAME_ERROR);
        }
        if (!StationRepository.isExistent(startStationName) || !StationRepository.isExistent(endStationName)) {
            throw new IllegalArgumentException(NON_EXISTENT_STATION__ERROR);
        }
    }

    private List<String> getShortestPath(String startStationName, String endStationName, SearchType searchType) {
        if (searchType.isDistance()) {
            return getShortestPathWithDistance(startStationName, endStationName);
        }
        return getShortestPathWithTime(startStationName, endStationName);
    }

    private List<String> getShortestPathWithDistance(String startStationName, String endStationName) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(PathRepository.getDistanceGraph());
        return dijkstraShortestPath.getPath(startStationName, endStationName).getVertexList();
    }

    private List<String> getShortestPathWithTime(String startStationName, String endStationName) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(PathRepository.getTimeGraph());
        return dijkstraShortestPath.getPath(startStationName, endStationName).getVertexList();
    }

    private List<Integer> calcTotalWeight(List<String> stationNames) {
        int totalDistance = ZERO;
        int totalTime = ZERO;
        for (int i = 1; i < stationNames.size(); i++) {
            String startStationName = stationNames.get(i - BEFORE_STATION_MINUS_NUMBER);
            String endStationName = stationNames.get(i);
            Station startStation = StationRepository.selectByName(startStationName);
            Station endStation = StationRepository.selectByName(endStationName);
            totalDistance += PathRepository.getDistanceWeight(startStation, endStation);
            totalTime += PathRepository.getTimeWeight(startStation, endStation);
        }
        return Arrays.asList(totalDistance, totalTime);
    }
}
