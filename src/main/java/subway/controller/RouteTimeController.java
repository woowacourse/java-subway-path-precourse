package subway.controller;

import java.util.List;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class RouteTimeController {
    WeightedMultigraph<String, DefaultWeightedEdge> subwayMap = new WeightedMultigraph(DefaultWeightedEdge.class);

    public RouteTimeController() {
        setVertex();
        setEdgeWeight();
    }

    private void setVertex() {
        subwayMap.addVertex("교대역");
        subwayMap.addVertex("강남역");
        subwayMap.addVertex("역삼역");
        subwayMap.addVertex("남부터미널역");
        subwayMap.addVertex("양재역");
        subwayMap.addVertex("양재시민의숲역");
        subwayMap.addVertex("매봉역");
    }
    
    private void setEdgeWeight() {
        subwayMap.setEdgeWeight(subwayMap.addEdge("교대역", "강남역"), 3);
        subwayMap.setEdgeWeight(subwayMap.addEdge("강남역", "역삼역"), 3);
        subwayMap.setEdgeWeight(subwayMap.addEdge("교대역", "남부터미널역"), 2);
        subwayMap.setEdgeWeight(subwayMap.addEdge("남부터미널역", "양재역"), 5);
        subwayMap.setEdgeWeight(subwayMap.addEdge("양재역", "매봉역"), 1);
        subwayMap.setEdgeWeight(subwayMap.addEdge("강남역", "양재역"), 8);
        subwayMap.setEdgeWeight(subwayMap.addEdge("양재역", "양재시민의숲역"), 3);
    }
    
    public List<String> findMinTime(String startStation, String endStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(subwayMap);
        List<String> shortestPath = dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
        return shortestPath;
    }
}
