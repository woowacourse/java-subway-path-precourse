package subway.domain;

import java.util.List;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class TimeGraph {
    private static WeightedMultigraph<Station, DefaultWeightedEdge> timeGraph = new WeightedMultigraph<>(
            DefaultWeightedEdge.class);
    
    public static void addVertex(Station station) {
        timeGraph.addVertex(station);
    }
    
    public static void setEdge(Station leftEndStation, Station rightEndStation, int time) {
        timeGraph.setEdgeWeight(timeGraph.addEdge(leftEndStation, rightEndStation), time);
    }
    
    public static List<Station> getShortestPath(Station leftEndStation, Station rightEndStation) {
        DijkstraShortestPath<Station, DefaultWeightedEdge> dijikstraShortestPath;
        GraphPath<Station, DefaultWeightedEdge> shortestPath;
        
        if (leftEndStation == rightEndStation) {
            throw new IllegalArgumentException(DomainConstants.ORIGIN_DEST_EQUAL_ERROR_MESSAGE);
        }
        dijikstraShortestPath = new DijkstraShortestPath<>(timeGraph);
        shortestPath = dijikstraShortestPath.getPath(leftEndStation, rightEndStation);
        if (shortestPath == null) {
            throw new IllegalArgumentException(DomainConstants.NO_PATH_ERROR_MESSAGE);
        }
        
        return shortestPath.getVertexList();
    }
}
