package subway.domain;

import java.util.List;
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
        DijkstraShortestPath<Station, DefaultWeightedEdge> dijikstraShortestPath = new DijkstraShortestPath<>(
                timeGraph);
        List<Station> shortestPath = dijikstraShortestPath.getPath(leftEndStation, rightEndStation).getVertexList();
        
        return shortestPath;
    }
}
