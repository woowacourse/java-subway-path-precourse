package subway.domain;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class PathRepository {

    private static final WeightedMultigraph<Station, DefaultWeightedEdge> timeWeightedGraph = new WeightedMultigraph(
        DefaultWeightedEdge.class);
    private static final WeightedMultigraph<Station, DefaultWeightedEdge> distanceWeightedGraph = new WeightedMultigraph(
        DefaultWeightedEdge.class);

    public static void addStation(Station station) {
        distanceWeightedGraph.addVertex(station);
        timeWeightedGraph.addVertex(station);
    }

    public static void addSection(Section section) {
        distanceWeightedGraph
            .setEdgeWeight(
                distanceWeightedGraph.addEdge(section.getFromStation(), section.getToStation()),
                section.getDistance());
        timeWeightedGraph.setEdgeWeight(
            timeWeightedGraph.addEdge(section.getFromStation(), section.getToStation()),
            section.getTime());
    }

    public static ShortestDistanceDto getShortestDistancePath(Station fromStation,
        Station toStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceWeightedGraph);
        GraphPath path = dijkstraShortestPath.getPath(fromStation, toStation);
        return new ShortestDistanceDto(path.getVertexList(), (int) path.getWeight());
    }

    public static ShortestTimeDto getShortestTimePath(Station fromStation,
        Station toStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeWeightedGraph);
        GraphPath path = dijkstraShortestPath.getPath(fromStation, toStation);
        return new ShortestTimeDto(path.getVertexList(), (int) path.getWeight());
    }

    public static boolean isConnectedStations(Station fromStation, Station toStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeWeightedGraph);
        GraphPath path = dijkstraShortestPath.getPath(fromStation, toStation);

        return path != null;
    }
}
