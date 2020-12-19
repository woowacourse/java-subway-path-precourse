package subway;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class DataLoader {
    private static final String[] STATION_DATA = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
    private static final String[] LINE_DATA = {"2호선", "3호선", "신분당선"};

    public static void load() {
        List<Station> stations = getStationsWithEdge();
        stations.forEach(StationRepository::addStation);
        LineRepository.addLine(new Line(LINE_DATA[0], new LinkedList<>(Arrays.asList(stations.get(0), stations.get(1), stations.get(2)))));
        LineRepository.addLine(new Line(LINE_DATA[1], new LinkedList<>(Arrays.asList(stations.get(0), stations.get(3), stations.get(4), stations.get(6)))));
        LineRepository.addLine(new Line(LINE_DATA[2], new LinkedList<>(Arrays.asList(stations.get(1), stations.get(4), stations.get(5)))));
    }

    public static DijkstraShortestPath getDijkstraShortestPathByDistance() {
        List<Station> stations = getStationsWithEdge();
        WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        for (Station station : stations) {
            graph.addVertex(station);
        }
        graph.setEdgeWeight(graph.addEdge(stations.get(0), stations.get(1)), 2);
        graph.setEdgeWeight(graph.addEdge(stations.get(1), stations.get(2)), 2);
        graph.setEdgeWeight(graph.addEdge(stations.get(0), stations.get(3)), 3);
        graph.setEdgeWeight(graph.addEdge(stations.get(3), stations.get(4)), 6);
        graph.setEdgeWeight(graph.addEdge(stations.get(4), stations.get(6)), 1);
        graph.setEdgeWeight(graph.addEdge(stations.get(1), stations.get(4)), 2);
        graph.setEdgeWeight(graph.addEdge(stations.get(4), stations.get(5)), 10);
        return new DijkstraShortestPath(graph);
    }

    public static DijkstraShortestPath getDijkstraShortestPathByTime() {
        List<Station> stations = getStationsWithEdge();
        WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        for (Station station : stations) {
            graph.addVertex(station);
        }
        graph.setEdgeWeight(graph.addEdge(stations.get(0), stations.get(1)), 3);
        graph.setEdgeWeight(graph.addEdge(stations.get(1), stations.get(2)), 3);
        graph.setEdgeWeight(graph.addEdge(stations.get(0), stations.get(3)), 2);
        graph.setEdgeWeight(graph.addEdge(stations.get(3), stations.get(4)), 5);
        graph.setEdgeWeight(graph.addEdge(stations.get(4), stations.get(6)), 1);
        graph.setEdgeWeight(graph.addEdge(stations.get(1), stations.get(4)), 8);
        graph.setEdgeWeight(graph.addEdge(stations.get(4), stations.get(5)), 3);
        return new DijkstraShortestPath(graph);
    }

    private static List<Station> getStationsWithEdge() {
        List<Station> stations = getStations();
        stations.get(0).addEdge(new Edge(stations.get(1), 2, 3));
        stations.get(0).addEdge(new Edge(stations.get(3), 3, 2));
        stations.get(1).addEdge(new Edge(stations.get(0), 2, 3));
        stations.get(1).addEdge(new Edge(stations.get(2), 2, 3));
        stations.get(1).addEdge(new Edge(stations.get(4), 2, 8));
        stations.get(2).addEdge(new Edge(stations.get(1), 2, 3));
        stations.get(3).addEdge(new Edge(stations.get(0), 3, 2));
        stations.get(3).addEdge(new Edge(stations.get(4), 6, 5));
        stations.get(4).addEdge(new Edge(stations.get(3), 6, 5));
        stations.get(4).addEdge(new Edge(stations.get(6), 1, 1));
        stations.get(4).addEdge(new Edge(stations.get(1), 2, 8));
        stations.get(4).addEdge(new Edge(stations.get(5), 10, 3));
        stations.get(5).addEdge(new Edge(stations.get(4), 10, 3));
        stations.get(6).addEdge(new Edge(stations.get(4), 1, 1));
        return stations;
    }

    private static List<Station> getStations() {
        return Arrays.stream(STATION_DATA)
                .map(Station::new)
                .collect(Collectors.toList());
    }
}
