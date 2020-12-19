package subway.domain;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.section.Section;
import subway.domain.station.Station;

public class ShortestPath {

    public static List<String> getShortestDistancePath(
        String startStationName,
        String endStationName
    ) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph
            = new WeightedMultigraph(DefaultWeightedEdge.class);
        setVertexAndEdgeWeightForShortestDistancePath(graph);
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath.getPath(startStationName, endStationName).getVertexList();
    }

    public static int getShortestDistance(String startStationName, String endStationName) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph
            = new WeightedMultigraph(DefaultWeightedEdge.class);
        setVertexAndEdgeWeightForShortestDistancePath(graph);
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return (int) dijkstraShortestPath.getPath(startStationName, endStationName).getWeight();
    }

    private static void setVertexAndEdgeWeightForShortestDistancePath(
        WeightedMultigraph<String, DefaultWeightedEdge> graph
    ) {
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            List<Station> stations = line.getStations();
            List<Section> sections = line.getSections();
            addVertexInGraph(graph, stations);
            setEdgeWeightWithDistanceInGraph(graph, stations, sections);
        }
    }

    private static void addVertexInGraph(
        WeightedMultigraph<String, DefaultWeightedEdge> graph,
        List<Station> stations
    ) {
        for (Station station : stations) {
            graph.addVertex(station.getName());
        }
    }

    private static void setEdgeWeightWithDistanceInGraph(
        WeightedMultigraph<String, DefaultWeightedEdge> graph,
        List<Station> stations,
        List<Section> sections
    ) {
        for (int i = 0; i < sections.size(); i++) {
            String sourceStationName = stations.get(i).getName();
            String targetStationName = stations.get(i + 1).getName();
            int distance = sections.get(i).getDistance();
            graph.setEdgeWeight(graph.addEdge(sourceStationName, targetStationName), distance);
        }
    }


    public static List<String> getShortestTimePath(String startStationName, String endStationName) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph
            = new WeightedMultigraph(DefaultWeightedEdge.class);
        setVertexAndEdgeWeightForShortestTimePath(graph);
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath.getPath(startStationName, endStationName).getVertexList();
    }

    public static int getShortestTime(String startStationName, String endStationName) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph
            = new WeightedMultigraph(DefaultWeightedEdge.class);
        setVertexAndEdgeWeightForShortestTimePath(graph);
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return (int) dijkstraShortestPath.getPath(startStationName, endStationName).getWeight();
    }

    private static void setVertexAndEdgeWeightForShortestTimePath(
        WeightedMultigraph<String, DefaultWeightedEdge> graph
    ) {
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            List<Station> stations = line.getStations();
            List<Section> sections = line.getSections();
            addVertexInGraph(graph, stations);
            setEdgeWeightWithTimeInGraph(graph, stations, sections);
        }
    }

    private static void setEdgeWeightWithTimeInGraph(
        WeightedMultigraph<String, DefaultWeightedEdge> graph,
        List<Station> stations,
        List<Section> sections
    ) {
        for (int i = 0; i < sections.size(); i++) {
            String sourceStationName = stations.get(i).getName();
            String targetStationName = stations.get(i + 1).getName();
            int time = sections.get(i).getTime();
            graph.setEdgeWeight(graph.addEdge(sourceStationName, targetStationName), time);
        }
    }

    public static List<String> getShortestPath(String startStationName, String endStationName) {
        List<Line> lines = LineRepository.lines();
        WeightedMultigraph<String, DefaultWeightedEdge> graph
            = new WeightedMultigraph(DefaultWeightedEdge.class);
        for (Line line : lines) {
            List<Station> stations = line.getStations();
            for (Station station : stations) {
                graph.addVertex(station.getName());
            }
            List<Section> sections = line.getSections();
            for (int i = 0; i < sections.size(); i++) {
                String sourceStationName = stations.get(i).getName();
                String tartgetStationName = stations.get(i + 1).getName();
                int distance = sections.get(i).getDistance();
                graph.setEdgeWeight(graph.addEdge(sourceStationName, tartgetStationName), distance);
            }
        }
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath.getPath(startStationName, endStationName).getVertexList();
    }
}
