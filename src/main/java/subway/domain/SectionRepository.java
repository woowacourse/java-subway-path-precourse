package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.ArrayList;
import java.util.List;

public class SectionRepository {

    static WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
    static List<Section> sections = new ArrayList<>();

    public static void addSection(String lineName, String stationName, int sequence) {
        Line line = LineRepository.findLine(lineName);
        Station station = StationRepository.findStation(stationName);
        line.addSection(sequence, station);
    }

    public static void addSectinonDistanceAndCost(String station1, String station2, int distance, int cost) {
        addVertex(station1, station2);
        sections.add(new Section(station1, station2, distance, cost));
    }

    private static void addVertex(String station1, String station2) {
        if (!graph.containsVertex(station1)) {
            graph.addVertex(station1);
        }
        if (!graph.containsVertex(station2)) {
            graph.addVertex(station2);
        }
    }

//    private static void addWeight(Station departure, Station arrival, int costTime) {
//        if (!graph.containsEdge(graph.addEdge(departure.getName(), arrival.getName()))) {
//            graph.setEdgeWeight(graph.addEdge(departure.getName(), arrival.getName()), costTime);
//        }
//    }
//
//
//    public static int findShortestPath(String departure, String destination) {
//
//        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
//        List<String> shortestPath = dijkstraShortestPath.getPath(departure, destination).getVertexList();
//
//        return (int) sections.stream()
//                .filter(section -> section.hasStation(departure, destination))
//                .mapToInt(Section::getDistance)
//                .sum();
//
//    }

}
