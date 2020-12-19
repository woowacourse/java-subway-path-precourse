package subway.domain;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.dto.PathDTO;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class DistanceGraph {
    public static WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
    public static DijkstraShortestPath dijkstraShortestPath;

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

        setEdgeWeitght(from, to, section.getDistance());
        updateShortestPath();
    }

    public static PathDTO getShortestPath(Station from, Station to) {
        GraphPath<Station, DefaultWeightedEdge> graphPath = dijkstraShortestPath.getPath(from, to);
        List<String> stationsName = graphPath.getVertexList().stream()
                .map(Station::getName)
                .collect(Collectors.toList());
        double cost = graphPath.getWeight();

        return new PathDTO(stationsName, cost);
    }
}
