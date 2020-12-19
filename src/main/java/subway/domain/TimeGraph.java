package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.Iterator;

public class TimeGraph {
    static WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
    static DijkstraShortestPath dijkstraShortestPath;

    private static void addVertex(Station station) {
        graph.addVertex(station);
    }

    private static void setEdgeWeitght(Station stationFrom, Station stationTo, int weight) {
        graph.setEdgeWeight(graph.addEdge(stationFrom, stationTo), weight);
    }

    private static void updateShortestPath() {
        dijkstraShortestPath = new DijkstraShortestPath(graph);
    }

    public static void addSectionToGraph(Section section) {
        Iterator<Station> iterator = section.stationsSet().iterator();
        Station from = iterator.next();
        Station to = iterator.next();

        addVertex(from);
        addVertex(to);

        setEdgeWeitght(from, to, section.getTime());
    }
}
