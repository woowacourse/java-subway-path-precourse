package subway.service;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.enums.initializer.DistanceToStation;
import subway.enums.initializer.InitialStations;

import java.util.List;

public class DistanceNavigator {
    static WeightedMultigraph<String, DefaultWeightedEdge> graphLine2Distance;

    static {
        graphLine2Distance = new WeightedMultigraph(DefaultWeightedEdge.class);
        setLine2Route();
    }

    public static void setLine2Route() {
        graphLine2Distance.addVertex(InitialStations.KYODAE.getName());
        graphLine2Distance.addVertex(InitialStations.GANGNAM.getName());
        graphLine2Distance.addVertex(InitialStations.YEOKSAM.getName());
        graphLine2Distance.setEdgeWeight(graphLine2Distance.addEdge(
                InitialStations.KYODAE.getName()
                , InitialStations.GANGNAM.getName())
                , DistanceToStation.LINE_2.getDistance().get(0));
        graphLine2Distance.setEdgeWeight(graphLine2Distance.addEdge(
                InitialStations.GANGNAM.getName()
                , InitialStations.YEOKSAM.getName())
                , DistanceToStation.LINE_2.getDistance().get(1));
    }

    public static List<String> getShortestPath(String departure, String arrival) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graphLine2Distance);
        return dijkstraShortestPath.getPath(departure, arrival).getVertexList();
    }
}
