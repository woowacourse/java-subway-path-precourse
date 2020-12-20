package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class PathRepository {
    private static final String DUPLICATION_ERROR_MESSAGE = "이미 해당 간선이 존재합니다.";

    private static final Map<Edge, Weight> paths = new HashMap<>();
    private static final WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static final WeightedMultigraph<String, DefaultWeightedEdge> timeGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static final Set<Edge> registeredVertex = new HashSet<>();

    public static void addPath(Station startStation, Station endStation, int km, int minute) {
        Edge forwardEdge = new Edge(startStation, endStation);
        Edge reverseEdge = new Edge(endStation, startStation);
        Weight weight = new Weight(km, minute);

        addVertex(forwardEdge, reverseEdge);
        addEdgeWeightToDistanceGraph(startStation, endStation, km);
        addEdgeWeightToTimeGraph(startStation, endStation, minute);

        // TODO: 치명적 실수-1 한 방향만 등록했다.
        addEdgeWeightToDistanceGraph(endStation, startStation, km);
        addEdgeWeightToTimeGraph(endStation, startStation, minute);

        paths.put(forwardEdge, weight);
        paths.put(reverseEdge, weight);
    }

    private static void addVertex(Edge forwardEdge, Edge reverseEdge) {
        if (registeredVertex.contains(forwardEdge)) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
        registeredVertex.add(forwardEdge);
        registeredVertex.add(reverseEdge);

        addVertexToGraph(forwardEdge.getStartStationName());
        addVertexToGraph(forwardEdge.getEndStationName());
    }

    private static void addVertexToGraph(String vertex) {
        if (!distanceGraph.containsVertex(vertex)) {
            distanceGraph.addVertex(vertex);
        }
        if (!timeGraph.containsVertex(vertex)) {
            timeGraph.addVertex(vertex);
        }
    }

    private static void addEdgeWeightToDistanceGraph(Station startStation, Station endStation, int km) {
        String startStationName = startStation.getName();
        String endStationName = endStation.getName();
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(startStationName, endStationName), km);
    }

    private static void addEdgeWeightToTimeGraph(Station startStation, Station endStation, int minute) {
        String startStationName = startStation.getName();
        String endStationName = endStation.getName();
        timeGraph.setEdgeWeight(timeGraph.addEdge(startStationName, endStationName), minute);
    }

    public static WeightedMultigraph<String, DefaultWeightedEdge> getDistanceGraph() {
        return distanceGraph;
    }

    public static WeightedMultigraph<String, DefaultWeightedEdge> getTimeGraph() {
        return timeGraph;
    }

    public static int getDistanceWeight(Station startStation, Station endStation) {
        Weight weight = getWeightByStations(startStation, endStation);
        System.out.println(startStation.getName() + " " + endStation.getName() + " " + weight.getKm());
        return weight.getKm();
    }

    public static int getTimeWeight(Station startStation, Station endStation) {
        Weight weight = getWeightByStations(startStation, endStation);
        return weight.getMinute();
    }

    private static Weight getWeightByStations(Station startStation, Station endStation) {
        Edge edge = selectByName(startStation.getName(), endStation.getName());
        return paths.get(edge);
    }

    public static Edge selectByName(String startStationName, String endStationName) {
        // TODO: 치명적 실수-3 &&를 ||로 썼다.
        for (Edge edge : paths.keySet()) {
            if (Objects.equals(edge.getStartStationName(), startStationName)
                    && Objects.equals(edge.getEndStationName(), endStationName)) {
                return edge;
            }
        }
        return null;
    }
}
