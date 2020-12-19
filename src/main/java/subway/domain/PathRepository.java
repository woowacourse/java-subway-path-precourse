package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class PathRepository {
    public static WeightedMultigraph<Station, DefaultWeightedEdge> shortestLengthPath
            = new WeightedMultigraph(DefaultWeightedEdge.class);
    public static WeightedMultigraph<Station, DefaultWeightedEdge> shortestTimePath
            = new WeightedMultigraph(DefaultWeightedEdge.class);

    static {
        for (int i = 0; i < StationRepository.stations().size(); i++) {
            shortestLengthPath.addVertex(StationRepository.stations().get(i));
            shortestTimePath.addVertex(StationRepository.stations().get(i));
        }
        shortestLengthPath.setEdgeWeight(shortestLengthPath.addEdge(StationRepository.getStationByName("교대역"),
                StationRepository.getStationByName("강남역")), 2);
        shortestLengthPath.setEdgeWeight(shortestLengthPath.addEdge(StationRepository.getStationByName("강남역"),
                StationRepository.getStationByName("역삼역")), 2);
        shortestLengthPath.setEdgeWeight(shortestLengthPath.addEdge(StationRepository.getStationByName("교대역"),
                StationRepository.getStationByName("남부터미널역")), 3);
        shortestLengthPath.setEdgeWeight(shortestLengthPath.addEdge(StationRepository.getStationByName("남부터미널역"),
                StationRepository.getStationByName("양재역")), 6);
        shortestLengthPath.setEdgeWeight(shortestLengthPath.addEdge(StationRepository.getStationByName("양재역"),
                StationRepository.getStationByName("매봉역")), 1);
        shortestLengthPath.setEdgeWeight(shortestLengthPath.addEdge(StationRepository.getStationByName("강남역"),
                StationRepository.getStationByName("양재역")), 2);
        shortestLengthPath.setEdgeWeight(shortestLengthPath.addEdge(StationRepository.getStationByName("양재역"),
                StationRepository.getStationByName("양재시민의숲역")), 10);

        shortestTimePath.setEdgeWeight(shortestTimePath.addEdge(StationRepository.getStationByName("교대역"),
                StationRepository.getStationByName("강남역")), 3);
        shortestTimePath.setEdgeWeight(shortestTimePath.addEdge(StationRepository.getStationByName("강남역"),
                StationRepository.getStationByName("역삼역")), 3);
        shortestTimePath.setEdgeWeight(shortestTimePath.addEdge(StationRepository.getStationByName("교대역"),
                StationRepository.getStationByName("남부터미널역")), 2);
        shortestTimePath.setEdgeWeight(shortestTimePath.addEdge(StationRepository.getStationByName("남부터미널역"),
                StationRepository.getStationByName("양재역")), 5);
        shortestTimePath.setEdgeWeight(shortestTimePath.addEdge(StationRepository.getStationByName("양재역"),
                StationRepository.getStationByName("매봉역")), 1);
        shortestTimePath.setEdgeWeight(shortestTimePath.addEdge(StationRepository.getStationByName("강남역"),
                StationRepository.getStationByName("양재역")), 8);
        shortestTimePath.setEdgeWeight(shortestTimePath.addEdge(StationRepository.getStationByName("양재역"),
                StationRepository.getStationByName("양재시민의숲역")), 3);
    }

    public static Path getPath(Station startStation, Station endStation, String command) {
        List<Station> pathList = makePathList(startStation, endStation, command);
        int totalTime = getTotalTime(pathList);
        int totalLength = getTotalLength(pathList);
        Path path = new Path(totalTime, totalLength, pathList);
        return path;
    }

    private static List<Station> makePathList(Station startStation, Station endStation, String command) {
        DijkstraShortestPath dijkstraShortestPath = null;
        if (command.equals(Constant.COMMAND_ONE)) {
            dijkstraShortestPath = new DijkstraShortestPath(shortestLengthPath);
        }
        if (command.equals(Constant.COMMAND_TWO)) {
            dijkstraShortestPath = new DijkstraShortestPath(shortestTimePath);
        }
        try {
            return dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
        } catch (NullPointerException e) {
            throw new NullPointerException("경로가 존재하지 않습니다.");
        }
    }

    private static int getTotalTime(List<Station> pathList) {
        int totalTime = 0;
        for (int i = 0; i < pathList.size() - 1; i++) {
            totalTime += shortestTimePath.getEdgeWeight(shortestTimePath.getEdge(pathList.get(i), pathList.get(i + 1)));
        }
        return totalTime;
    }

    private static int getTotalLength(List<Station> pathList) {
        int totalLength = 0;
        for (int i = 0; i < pathList.size() - 1; i++) {
            totalLength += shortestLengthPath.getEdgeWeight(shortestLengthPath.getEdge(pathList.get(i), pathList.get(i + 1)));
        }
        return totalLength;
    }
}
