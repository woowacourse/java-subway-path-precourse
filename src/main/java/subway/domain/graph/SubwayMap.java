package subway.domain.graph;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.station.StationRepository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubwayMap {
    private static WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static WeightedMultigraph<String, DefaultWeightedEdge> timeGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static Map<List<String>, Integer> timeEdge = new HashMap<>();
    private static Map<List<String>, Integer> distanceEdge = new HashMap<>();

    public static void setStations(List<String> stations) {
        stations.stream()
                .forEach(station -> distanceGraph.addVertex(station));

        stations.stream()
                .forEach(station -> timeGraph.addVertex(station));
    }

    public static void setEdgeDistance(List<String> stations, int distance, int time) {
        String firstStation = stations.get(StationRepository.FIRST_STATION_INDEX);
        String lastStation = stations.get(StationRepository.LAST_STATION_INDEX);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(firstStation, lastStation), distance);
        timeGraph.setEdgeWeight(timeGraph.addEdge(firstStation, lastStation), time);
        timeEdge.put(stations, time);
        distanceEdge.put(stations, distance);
    }

    public static int findShortestDistance(List<String> stations) {
        String firstStation = stations.get(StationRepository.FIRST_STATION_INDEX);
        String lastStation = stations.get(StationRepository.LAST_STATION_INDEX);
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);

        int minDistance = (int) dijkstraShortestPath.getPathWeight(firstStation, lastStation);
        return minDistance;
    }

    public static List<String> findShortestDistancePath(List<String> stations) {
        String firstStation = stations.get(StationRepository.FIRST_STATION_INDEX);
        String lastStation = stations.get(StationRepository.LAST_STATION_INDEX);
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);

        List<String> pathList = dijkstraShortestPath.getPath(firstStation, lastStation).getVertexList();
        return pathList;
    }

    public static int findShortestDistanceTime(List<String> paths) {
        int time = 0;
        for (int i=0; i<paths.size()-1; i++) {
            String firstStation = paths.get(i);
            String lastStation = paths.get(i+1);
            time += timeEdge.get(Arrays.asList(firstStation, lastStation));
        }
        return time;
    }

    public static int findShortestTime(List<String> stations) {
        String firstStation = stations.get(StationRepository.FIRST_STATION_INDEX);
        String lastStation = stations.get(StationRepository.LAST_STATION_INDEX);
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeGraph);

        int minTime = (int) dijkstraShortestPath.getPathWeight(firstStation, lastStation);
        return minTime;
    }

    public static List<String> findShortestTimePath(List<String> stations) {
        String firstStation = stations.get(StationRepository.FIRST_STATION_INDEX);
        String lastStation = stations.get(StationRepository.LAST_STATION_INDEX);
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeGraph);

        List<String> pathList = dijkstraShortestPath.getPath(firstStation, lastStation).getVertexList();
        return pathList;
    }

    public static int findShortestTimeDistance(List<String> paths) {
        int distance = 0;
        for (int i=0; i<paths.size()-1; i++) {
            String firstStation = paths.get(i);
            String lastStation = paths.get(i+1);
            distance += timeEdge.get(Arrays.asList(firstStation, lastStation));
        }
        return distance;
    }
}