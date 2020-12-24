package subway.domain;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class DefaultSubwayGraph {

    private static DefaultStations defaultStations;
    private static DefaultSections defaultSections;
    private static WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph;
    private static WeightedMultigraph<String, DefaultWeightedEdge> timeGraph;

    public DefaultSubwayGraph() {
        defaultStations = new DefaultStations();
        defaultSections = new DefaultSections();
        distanceGraph = createDistanceGraph();
        timeGraph = createTimeGraph();
    }

    private WeightedMultigraph<String, DefaultWeightedEdge> createTimeGraph() {
        timeGraph = new WeightedMultigraph(
            DefaultWeightedEdge.class);
        timeGraph = addDefaultStations(timeGraph);
        addTimeDefaultEdges();
        return timeGraph;
    }

    private void addTimeDefaultEdges() {
        for (Section section : defaultSections.getSections()) {
            timeGraph.setEdgeWeight(
                timeGraph.addEdge(section.getDepartureStation(), section.getArrivalStation()),
                section.getCost().getTimeCost());
        }
    }

    private static WeightedMultigraph<String, DefaultWeightedEdge> createDistanceGraph() {
        distanceGraph = new WeightedMultigraph(
            DefaultWeightedEdge.class);
        distanceGraph = addDefaultStations(distanceGraph);
        addDistanceDefaultEdges();
        return distanceGraph;
    }

    public static WeightedMultigraph addDefaultStations(WeightedMultigraph graph) {
        for (String stationName : defaultStations.getDefaultNames()) {
            graph.addVertex(stationName);
        }
        return graph;
    }

    public static void addDistanceDefaultEdges() {
        for (Section section : defaultSections.getSections()) {
            distanceGraph.setEdgeWeight(
                distanceGraph.addEdge(section.getDepartureStation(), section.getArrivalStation()),
                section.getCost().getDistanceCost());
        }
    }

    public List<String> getDijkstraDistanceShortestPath(String departureStation,
        String arrivalStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);
        List<String> shortestPath = dijkstraShortestPath.getPath(departureStation, arrivalStation)
            .getVertexList();
        return shortestPath;
    }

    public List<String> getDijkstraTimeShortestPath(String departureStation,
        String arrivalStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeGraph);
        List<String> shortestPath = dijkstraShortestPath.getPath(departureStation, arrivalStation)
            .getVertexList();
        return shortestPath;
    }
}
