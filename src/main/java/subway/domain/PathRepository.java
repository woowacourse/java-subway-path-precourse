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

    public void shortestLengthPath(Station startStation, Station endStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(shortestLengthPath);
        List<Station> pathList = dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
        for (int i = 0; i < pathList.size(); i++) {
            System.out.println(pathList.get(i).getName());
        }
    }

    public static void shortestTimePath(Station startStation, Station endStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(shortestTimePath);
        List<Station> pathList = dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
        int totalTime = 0, totalLength = 0;
        for (int i = 0; i < pathList.size() - 1; i++) {
            totalTime += shortestTimePath.getEdgeWeight(shortestTimePath.getEdge(pathList.get(i), pathList.get(i + 1)));
            totalLength += shortestLengthPath.getEdgeWeight(shortestLengthPath.getEdge(pathList.get(i), pathList.get(i + 1)));
        }
        System.out.println(totalTime + " " + totalLength);
    }
}
