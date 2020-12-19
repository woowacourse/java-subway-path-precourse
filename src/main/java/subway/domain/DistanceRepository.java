package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class DistanceRepository {
    private static WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph;
    private static DijkstraShortestPath dijkstraShortestPath;
    private static WeightedMultigraph<String, DefaultWeightedEdge> timeGraph;
    private static DijkstraShortestPath dijkstraFastestPath;

    public static void initializePathByDistance() {
        distanceGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
        for (Station station : StationRepository.stations()) {
            distanceGraph.addVertex(station.getName());
        }
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("교대역", "강남역"), 2);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("강남역", "역삼역"), 2);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("교대역", "남부터미널역"), 3);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("남부터미널역", "양재역"), 6);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("양재역", "매봉역"), 1);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("강남역", "양재역"), 2);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("양재역", "양재시민의숲역"), 10);
        dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);
    }


    public static List<String> getShortestPath(String startStation, String endStation) {
        return dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
    }

    public static int getShortestPathLength(String startStation, String endStation) {
        return (int)dijkstraShortestPath.getPathWeight(startStation, endStation);
    }


    public static void initializePathByTime() {
        timeGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
        for (Station station : StationRepository.stations()) {
            timeGraph.addVertex(station.getName());
        }
        timeGraph.setEdgeWeight(timeGraph.addEdge("교대역", "강남역"), 3);
        timeGraph.setEdgeWeight(timeGraph.addEdge("강남역", "역삼역"), 3);
        timeGraph.setEdgeWeight(timeGraph.addEdge("교대역", "남부터미널역"), 2);
        timeGraph.setEdgeWeight(timeGraph.addEdge("남부터미널역", "양재역"), 5);
        timeGraph.setEdgeWeight(timeGraph.addEdge("양재역", "매봉역"), 1);
        timeGraph.setEdgeWeight(timeGraph.addEdge("강남역", "양재역"), 8);
        timeGraph.setEdgeWeight(timeGraph.addEdge("양재역", "양재시민의숲역"), 3);
        dijkstraFastestPath = new DijkstraShortestPath(timeGraph);
    }

    public static List<String> getFastestPath(String startStation, String endStation) {
        return dijkstraFastestPath.getPath(startStation, endStation).getVertexList();
    }

    public static int getFastestPathLength(String startStation, String endStation) {
        return (int)dijkstraFastestPath.getPathWeight(startStation, endStation);
    }

    public static int getLengthByTime(List<String> pathList) {
        int totalTime = 0;
        for (int i = 0; i < pathList.size() - 1; i++) {
            totalTime += dijkstraFastestPath.getPathWeight(pathList.get(i), pathList.get(i + 1));
        }
        return totalTime;
    }
}