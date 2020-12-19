package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.Collections;
import java.util.List;

public class SubwayMap {
    private String lineName;
    private List<SubwayPath> subwayPaths;
    private final static WeightedMultigraph<String, DefaultWeightedEdge> shortestPathGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
    private final static WeightedMultigraph<String, DefaultWeightedEdge> minimumTimeGraph = new WeightedMultigraph(DefaultWeightedEdge.class);

    public SubwayMap(String lineName, List<SubwayPath> subwayPaths) {
        this.lineName = lineName;
        this.subwayPaths = subwayPaths;
        makeShortestPathGraph();
        makeMinimumTimeGraph();
    }

    public String getLineName() {
        return lineName;
    }

    public List<SubwayPath> getPaths() {
        return subwayPaths;
    }

    public WeightedMultigraph<String, DefaultWeightedEdge> getShortestPathGraph() {
        return shortestPathGraph;
    }

    public WeightedMultigraph<String, DefaultWeightedEdge> getMinimumTimeGraph() {
        return minimumTimeGraph;
    }

    private void makeShortestPathGraph() {
        for (SubwayPath subwayPath : subwayPaths) {
            String departureStation = subwayPath.getDepartureStation();
            String arrivalStation = subwayPath.getArrivalStation();
            int distance = subwayPath.getDistance();
            shortestPathGraph.addVertex(departureStation);
            shortestPathGraph.addVertex(arrivalStation);
            shortestPathGraph.setEdgeWeight(shortestPathGraph.addEdge(departureStation, arrivalStation), distance);
        }
    }

    private void makeMinimumTimeGraph() {
        for (SubwayPath subwayPath : subwayPaths) {
            String departureStation = subwayPath.getDepartureStation();
            String arrivalStation = subwayPath.getArrivalStation();
            int time = subwayPath.getTime();
            minimumTimeGraph.addVertex(departureStation);
            minimumTimeGraph.addVertex(arrivalStation);
            minimumTimeGraph.setEdgeWeight(minimumTimeGraph.addEdge(departureStation, arrivalStation), time);
        }
    }

    public static List<String> getShortestPath(String departureStation, String arrivalStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(shortestPathGraph);
        List<String> shortestPath;
        try {
            shortestPath = dijkstraShortestPath.getPath(departureStation, arrivalStation).getVertexList();
        } catch (IllegalArgumentException illegalArgumentException) {
            shortestPath = Collections.emptyList();
        }
        return shortestPath;
    }

    public static List<String> getMinimumTime(String departureStation, String arrivalStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(minimumTimeGraph);
        List<String> minimumTime;
        try {
            minimumTime = dijkstraShortestPath.getPath(departureStation, arrivalStation).getVertexList();
        } catch (IllegalArgumentException illegalArgumentException) {
            minimumTime = Collections.emptyList();
        }
        return minimumTime;
    }
}
