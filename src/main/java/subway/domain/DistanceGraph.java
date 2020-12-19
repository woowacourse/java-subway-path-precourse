package subway.domain;

import java.util.List;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class DistanceGraph {
    private static WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph = new WeightedMultigraph<>(
            DefaultWeightedEdge.class);
    
    public static void addVertex(Station station) {
        distanceGraph.addVertex(station);
    }
    
    public static void setEdge(Station leftEndStation, Station rightEndStation, int distance) {
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(leftEndStation, rightEndStation), distance);
    }
    
    public static List<Station> getShortestPath(Station leftEndStation, Station rightEndStation) {
        DijkstraShortestPath<Station, DefaultWeightedEdge> dijikstraShortestPath;
        GraphPath<Station, DefaultWeightedEdge> shortestPath;
        
        if (leftEndStation == rightEndStation) {
            throw new IllegalArgumentException(DomainConstants.ORIGIN_DEST_EQUAL_ERROR_MESSAGE);
        }
        dijikstraShortestPath = new DijkstraShortestPath<>(distanceGraph);
        shortestPath = dijikstraShortestPath.getPath(leftEndStation, rightEndStation);
        if (shortestPath == null) {
            throw new IllegalArgumentException(DomainConstants.NO_PATH_ERROR_MESSAGE);
        }
        
        return shortestPath.getVertexList();
    }
}
