package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.Collections;
import java.util.List;


public class TimeGraphRepository {
    private static final WeightedMultigraph<Station, DefaultWeightedEdge> timeGraph = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static void addStation(Station station) {
        timeGraph.addVertex(station);
    }

    public static void addTimeBetweenStations(Station source, Station destination, int time) {
        timeGraph.setEdgeWeight(timeGraph.addEdge(source, destination), time);
    }

    public static List<Station> findShortestPath(Station source, Station destination) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeGraph);
        List<Station> shortestPath = dijkstraShortestPath.getPath(source, destination).getVertexList();
        return Collections.unmodifiableList(shortestPath);
    }

    public static int getEdgeTime(Station source, Station destination) {
        return (int) timeGraph.getEdgeWeight(timeGraph.getEdge(source, destination));
    }
}
