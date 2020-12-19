package subway.domain;

import java.util.List;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class PathRepository {
    private static WeightedMultigraph<String, DefaultWeightedEdge> graphByDistance
        = new WeightedMultigraph<>(DefaultWeightedEdge.class);
    private static WeightedMultigraph<String, DefaultWeightedEdge> graphByTime
        = new WeightedMultigraph<>(DefaultWeightedEdge.class);
    private static DijkstraShortestPath dijkstraShortestDistance
        = new DijkstraShortestPath(graphByDistance);
    private static DijkstraShortestPath dijkstraShortestTime
        = new DijkstraShortestPath(graphByTime);

    private PathRepository() {
    }

    public static void addGraphVertex(String vertex) {
        graphByDistance.addVertex(vertex);
        graphByTime.addVertex(vertex);
    }

    public static void setGraphEdgeWeight(String sourceVertex, String targetVertex, int distance,
        int time) {
        setWeightByDistance(sourceVertex, targetVertex, distance);
        setWeightByTime(sourceVertex, targetVertex, time);

    }

    private static void setWeightByDistance(String sourceVertex, String targetVertex, int weight) {
        graphByDistance.setEdgeWeight(graphByDistance.addEdge(sourceVertex, targetVertex), weight);
    }

    private static void setWeightByTime(String sourceVertex, String targetVertex, int weight) {
        graphByTime.setEdgeWeight(graphByTime.addEdge(sourceVertex, targetVertex), weight);
    }

    public static GraphPath<String, String> getShortestDistance(String source, String sink) {
        GraphPath<String, String> path = dijkstraShortestDistance.getPath(source, sink);
        return path;
    }
    public static List<String> getShortestPath(String source, String sink){
        return dijkstraShortestDistance.getPath(source, sink).getVertexList();
    }
    public static int getShortestDistance(GraphPath<String, String> path) {
        double weight = path.getWeight();
        return (int)weight;
    }

    public static GraphPath<String, String> getShortestTime(String source, String sink) {
        GraphPath<String, String> path = dijkstraShortestTime.getPath(source, sink);
        return path;
    }


}
