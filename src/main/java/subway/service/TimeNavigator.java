package subway.service;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.enums.initializer.InitialStations;
import subway.enums.initializer.TimeToStation;

import java.util.List;

public class TimeNavigator {
    static WeightedMultigraph<String, DefaultWeightedEdge> graphLine2Time;

    static {
        graphLine2Time = new WeightedMultigraph(DefaultWeightedEdge.class);
        setLine2Route();
    }

    public static void setLine2Route() {
        graphLine2Time.addVertex(InitialStations.KYODAE.getName());
        graphLine2Time.addVertex(InitialStations.GANGNAM.getName());
        graphLine2Time.addVertex(InitialStations.YEOKSAM.getName());
        graphLine2Time.setEdgeWeight(graphLine2Time.addEdge(
                InitialStations.KYODAE.getName()
                , InitialStations.GANGNAM.getName())
                , TimeToStation.LINE_2.getTimes().get(0));
        graphLine2Time.setEdgeWeight(graphLine2Time.addEdge(
                InitialStations.GANGNAM.getName()
                , InitialStations.YEOKSAM.getName())
                , TimeToStation.LINE_2.getTimes().get(1));
    }

    public static List<String> getShortestPath(String departure, String arrival) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graphLine2Time);
        return dijkstraShortestPath.getPath(departure, arrival).getVertexList();
    }
}
