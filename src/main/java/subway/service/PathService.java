package subway.service;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.PathRepository;
import subway.domain.SearchType;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.dto.ShortestPathDto;

import java.util.Arrays;
import java.util.List;

public class PathService {
    private static final int ZERO = 0;
    private static final int BEFORE_STATION_MINUS_NUMBER = 0;
    private static final int TOTAL_DISTANCE_INDEX = 0;
    private static final int TOTAL_TIME_INDEX = 1;

    public void registerPath(String startStationName, String endStationName, int km, int minute) {
        Station startStation = StationRepository.selectByName(startStationName);
        Station endStation = StationRepository.selectByName(endStationName);
        PathRepository.addPath(startStation, endStation, km, minute);
    }

    public ShortestPathDto calcShortestPath(String startStationName, String endStationName, SearchType searchType) {
        // TODO : 존재하는 역인지, 같은 역인지, 경로가 없는지
        List<String> shortestPath = getShortestPath(startStationName, endStationName, searchType);
        List<Integer> weights = calcTotalWeight(shortestPath);
        int totalDistance = weights.get(TOTAL_DISTANCE_INDEX);
        int totalTime = weights.get(TOTAL_TIME_INDEX);
        return new ShortestPathDto(totalDistance, totalTime, shortestPath);
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
