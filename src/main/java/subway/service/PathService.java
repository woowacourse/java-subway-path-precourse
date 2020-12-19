package subway.service;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.PathRepository;
import subway.domain.SearchType;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.dto.ShortestPathDto;

import java.util.List;

public class PathService {
    public void registerPath(String startStationName, String endStationName, int km, int minute) {
        Station startStation = StationRepository.selectByName(startStationName);
        Station endStation = StationRepository.selectByName(endStationName);
        PathRepository.addPath(startStation, endStation, km, minute);
    }

    public ShortestPathDto calcShortestPath(String startStationName, String endStationName, SearchType searchType) {
        // TODO : 존재하는 역인지, 같은 역인지, 경로가 없는지
        List<String> shortestPath = getShortestPath(startStationName, endStationName, searchType);


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
}
