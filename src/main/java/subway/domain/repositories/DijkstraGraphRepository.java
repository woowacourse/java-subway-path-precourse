package subway.domain.repositories;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

public class DijkstraGraphRepository {
    private static WeightedMultigraph<String, DefaultWeightedEdge> shortTimeGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static WeightedMultigraph<String, DefaultWeightedEdge> shortDistanceGraph = new WeightedMultigraph(DefaultWeightedEdge.class);

    private static Map<String, Map<String, Integer>> stationDistMap = new HashMap<>();
    private static Map<String, Map<String, Integer>> stationTimeMap = new HashMap<>();

    public static void addVertexByStationName(String stationName){
        shortTimeGraph.addVertex(stationName);
        shortDistanceGraph.addVertex(stationName);
    }

    public static void graphInit() {
        secondLineSet();
        thirdLineSet();
        SinbundangLineSet();
    }

    private static Map<String, Integer> setMap(String stationName, int value){
        Map<String, Integer> map = new HashMap<>();
        map.put(stationName, value);
        return map;
    }

    private static void secondLineSet(){
        shortDistanceGraph.setEdgeWeight(shortDistanceGraph.addEdge("교대역", "강남역"), 2);
        //stationDistMap.put("교대역", setMap("강남역", 2));    // 추후 추가
        shortTimeGraph.setEdgeWeight(shortTimeGraph.addEdge("교대역", "강남역"), 3);
        shortDistanceGraph.setEdgeWeight(shortDistanceGraph.addEdge("강남역", "역삼역"), 2);
        shortTimeGraph.setEdgeWeight(shortTimeGraph.addEdge("강남역", "역삼역"), 3);
    }

    private static void thirdLineSet(){
        shortDistanceGraph.setEdgeWeight(shortDistanceGraph.addEdge("교대역", "남부터미널역"), 3);
        shortTimeGraph.setEdgeWeight(shortTimeGraph.addEdge("교대역", "남부터미널역"), 2);
        shortDistanceGraph.setEdgeWeight(shortDistanceGraph.addEdge("남부터미널역", "양재역"), 6);
        shortTimeGraph.setEdgeWeight(shortTimeGraph.addEdge("남부터미널역", "양재역"), 5);
        shortDistanceGraph.setEdgeWeight(shortDistanceGraph.addEdge("양재역", "매봉역"), 1);
        shortTimeGraph.setEdgeWeight(shortTimeGraph.addEdge("양재역", "매봉역"), 1);
    }

    private static void SinbundangLineSet(){
        shortDistanceGraph.setEdgeWeight(shortDistanceGraph.addEdge("강남역", "양재역"), 2);
        shortTimeGraph.setEdgeWeight(shortTimeGraph.addEdge("강남역", "양재역"), 8);
        shortDistanceGraph.setEdgeWeight(shortDistanceGraph.addEdge("양재역", "양재시민의숲역"), 10);
        shortTimeGraph.setEdgeWeight(shortTimeGraph.addEdge("양재역", "양재시민의숲역"), 3);
    }
}
