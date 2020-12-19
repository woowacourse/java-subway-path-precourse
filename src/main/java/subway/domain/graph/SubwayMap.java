package subway.domain.graph;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.station.StationRepository;

import java.util.List;

public class SubwayMap {
    private static WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static WeightedMultigraph<String, DefaultWeightedEdge> timeGraph = new WeightedMultigraph(DefaultWeightedEdge.class);

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
        timeGraph.setEdgeWeight(distanceGraph.addEdge(firstStation, lastStation), time);
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
        for (int i = 0; i < paths.size() - 1; i++) {
            time += timeGraph.getEdgeWeight(distanceGraph.getEdge(paths.get(i), paths.get(i + 1)));
            System.out.println(paths.get(i) + paths.get(i+1) +  time + "\n");
        }
        return time;
    }
}