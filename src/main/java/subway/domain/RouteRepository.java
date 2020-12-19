package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;

import java.util.List;

public class RouteRepository {

    public static void init() {
        RouteResource.init();
    }

    public static double getTotalDistance(String startStation, String endStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(RouteResource.getDistanceGraph());
        return dijkstraShortestPath.getPath(startStation, endStation).getWeight();
    }

    public static double getTotalTime(String startStation, String endStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(RouteResource.getTimeGraph());
        return dijkstraShortestPath.getPath(startStation, endStation).getWeight();
    }


    public static List<String> getRouteMinDistance(String startStation, String endStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(RouteResource.getDistanceGraph());
        List<String> shortestPath = dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
        return shortestPath;
    }

    public static List<String> getRouteMinTime(String startStation, String endStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(RouteResource.getTimeGraph());
        List<String> shortestPath = dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
        return shortestPath;
    }
}
