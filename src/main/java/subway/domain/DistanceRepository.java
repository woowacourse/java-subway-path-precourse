package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class DistanceRepository {
    private static WeightedMultigraph<String, DefaultWeightedEdge> graph;

    public static void initializePathByDistance() {
        graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        for (Station station : StationRepository.stations()) {
            graph.addVertex(station.getName());
        }
        graph.setEdgeWeight(graph.addEdge("교대역", "강남역"), 2);
        graph.setEdgeWeight(graph.addEdge("강남역", "역삼역"), 2);
        graph.setEdgeWeight(graph.addEdge("교대역", "남부터미널역"), 3);
        graph.setEdgeWeight(graph.addEdge("남부터미널역", "양재역"), 6);
        graph.setEdgeWeight(graph.addEdge("양재역", "매봉역"), 1);
        graph.setEdgeWeight(graph.addEdge("강남역", "양재역"), 2);
        graph.setEdgeWeight(graph.addEdge("양재역", "양재시민의숲역"), 10);
    }


    public static void getShortestPath() {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath("교대역", "양재역").getVertexList();
        System.out.println("거리" + dijkstraShortestPath.getPathWeight("교대역", "양재역"));

        for (String s : shortestPath) {
            System.out.println(s);
        }
        System.out.println("테스트 결과 " + shortestPath.size());
    }
}