package subway.domain.repositories;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DijkstraGraphRepository {
    private static WeightedMultigraph<String, DefaultWeightedEdge> shortTimeGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static WeightedMultigraph<String, DefaultWeightedEdge> shortDistanceGraph = new WeightedMultigraph(DefaultWeightedEdge.class);

    private static Map<String, Map<String, Integer>> stationDistMap = new HashMap<>();
    private static Map<String, Map<String, Integer>> stationTimeMap = new HashMap<>();

    public static void addVertexByStationName(String stationName) {
        shortTimeGraph.addVertex(stationName);
        shortDistanceGraph.addVertex(stationName);
    }

    public static void graphInit() {
        secondLineSet();
        thirdLineSet();
        sinbundangLineSet();
    }

    private static Map<String, Integer> setMap(String stationName, int value) {
        Map<String, Integer> map = new HashMap<>();
        map.put(stationName, value);
        return map;
    }

    private static void secondLineSet() {
        shortDistanceGraph.setEdgeWeight(shortDistanceGraph.addEdge("교대역", "강남역"), 2);
        stationDistMap.put("교대역", setMap("강남역", 2));

        shortTimeGraph.setEdgeWeight(shortTimeGraph.addEdge("교대역", "강남역"), 3);
        stationTimeMap.put("교대역", setMap("강남역", 3));

        shortDistanceGraph.setEdgeWeight(shortDistanceGraph.addEdge("강남역", "역삼역"), 2);
        stationDistMap.put("강남역", setMap("역삼역", 2));

        shortTimeGraph.setEdgeWeight(shortTimeGraph.addEdge("강남역", "역삼역"), 3);
        stationTimeMap.put("강남역", setMap("역삼역", 3));
    }

    private static void thirdLineSet() {
        shortDistanceGraph.setEdgeWeight(shortDistanceGraph.addEdge("교대역", "남부터미널역"), 3);
        stationDistMap.put("교대역", setMap("남부터미널역", 3));
        shortTimeGraph.setEdgeWeight(shortTimeGraph.addEdge("교대역", "남부터미널역"), 2);
        stationTimeMap.put("교대역", setMap("남부터미널역", 2));
        shortDistanceGraph.setEdgeWeight(shortDistanceGraph.addEdge("남부터미널역", "양재역"), 6);
        stationDistMap.put("남부터미널역", setMap("양재역", 6));
        shortTimeGraph.setEdgeWeight(shortTimeGraph.addEdge("남부터미널역", "양재역"), 5);
        stationTimeMap.put("남부터미널역", setMap("양재역", 5));
        shortDistanceGraph.setEdgeWeight(shortDistanceGraph.addEdge("양재역", "매봉역"), 1);
        stationDistMap.put("양재역", setMap("매봉역", 1));
        shortTimeGraph.setEdgeWeight(shortTimeGraph.addEdge("양재역", "매봉역"), 1);
        stationTimeMap.put("양재역", setMap("매봉역", 1));
    }

    private static void sinbundangLineSet() {
        shortDistanceGraph.setEdgeWeight(shortDistanceGraph.addEdge("강남역", "양재역"), 2);
        stationDistMap.put("강남역", setMap("양재역", 2));
        shortTimeGraph.setEdgeWeight(shortTimeGraph.addEdge("강남역", "양재역"), 8);
        stationTimeMap.put("강남역", setMap("양재역", 8));
        shortDistanceGraph.setEdgeWeight(shortDistanceGraph.addEdge("양재역", "양재시민의숲역"), 10);
        stationDistMap.put("양재역", setMap("양재시민의숲역", 10));
        shortTimeGraph.setEdgeWeight(shortTimeGraph.addEdge("양재역", "양재시민의숲역"), 3);
        stationTimeMap.put("양재역", setMap("양재시민의숲역", 3));
    }

    public static int getShortestDist(String name1, String name2) throws IllegalArgumentException {
        try {
            DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(shortDistanceGraph);
            double weight = 0.0;
            weight = dijkstraShortestPath.getPathWeight(name1, name2);
            return (int) weight;
        } catch (Exception e) {
            throw new IllegalArgumentException("갈수 없는 경로 입니다.");
        }
    }

    public static List<String> getShortestDistPath(String name1, String name2) {
        DijkstraShortestPath dijkstraShortestTimePath = new DijkstraShortestPath(shortDistanceGraph);
        List<String> shortestDistPath = dijkstraShortestTimePath.getPath(name1, name2).getVertexList();
        return shortestDistPath;
    }

    public static int getShortestTime(String name1, String name2) throws IllegalArgumentException {
        try {
            DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(shortTimeGraph);
            double weight = 0.0;
            weight = dijkstraShortestPath.getPathWeight(name1, name2);
            return (int) weight;
        } catch (Exception e) {
            throw new IllegalArgumentException("갈수 없는 경로 입니다.");
        }
    }

    public static List<String> getShortestTimePath(String name1, String name2) {
        DijkstraShortestPath dijkstraShortestTimePath = new DijkstraShortestPath(shortTimeGraph);
        List<String> shortestTimePath = dijkstraShortestTimePath.getPath(name1, name2).getVertexList();
        return shortestTimePath;
    }

    public static Map<String, Map<String, Integer>> getStationDistMap() {
        return stationDistMap;
    }

    public static Map<String, Map<String, Integer>> getStationTimeMap() {
        return stationTimeMap;
    }
}
