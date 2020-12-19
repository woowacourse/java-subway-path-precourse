package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class RouteResource {
    private static WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static WeightedMultigraph<String, DefaultWeightedEdge> timeGraph = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static void init() {
        makeDistanceGraph();
        makeTimeGraph();
    }

    public static WeightedMultigraph getDistanceGraph() {
        return distanceGraph;
    }

    public static WeightedMultigraph getTimeGraph() {
        return timeGraph;
    }

    private static  void makeDistanceGraph() {
        for (Station station : StationRepository.stations()) {
            distanceGraph.addVertex(station.getName());
        }

        for (Line line : LineRepository.lines()) {
            connectDistanceGraph(line);
        }
    }

    private static void connectDistanceGraph(Line line) {
        StationsInLine stations = line.getStations();
        Paths paths = line.getPaths();
        for (int i = 0; i < paths.getSize(); i++) {
            Station startStation = stations.getStation(i);
            Station endStation = stations.getStation(i + 1);
            Path path = paths.getPath(i);
            distanceGraph.setEdgeWeight(distanceGraph.addEdge(startStation.getName(), endStation.getName()), path.getDistance());
        }
    }

    private static void makeTimeGraph() {
        for (Station station : StationRepository.stations()) {
            timeGraph.addVertex(station.getName());
        }

        for (Line line : LineRepository.lines()) {
            connectTimeGraph(line);
        }
    }

    private static void connectTimeGraph(Line line) {
        StationsInLine stations = line.getStations();
        Paths paths = line.getPaths();
        for (int i = 0; i < paths.getSize(); i++) {
            Station startStation = stations.getStation(i);
            Station endStation = stations.getStation(i + 1);
            Path path = paths.getPath(0);
            timeGraph.setEdgeWeight(timeGraph.addEdge(startStation.getName(), endStation.getName()), path.getTime());
        }
    }
}
