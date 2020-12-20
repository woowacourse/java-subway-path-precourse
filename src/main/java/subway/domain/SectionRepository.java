package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class SectionRepository {

    static WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static void addSection(String lineName, String stationName, int sequence) {
        Line line = LineRepository.findLine(lineName);
        Station station = StationRepository.findStation(stationName);
        line.addSection(sequence, station);
    }

//    private static void addWeight(Station departure, Station arrival, int costTime) {
//        if (!graph.containsEdge(graph.addEdge(departure.getName(), arrival.getName()))) {
//            graph.setEdgeWeight(graph.addEdge(departure.getName(), arrival.getName()), costTime);
//        }
//    }
//
//    private static void addVertex(Station departure, Station arrival) {
//        if (!graph.containsVertex(departure.getName())) {
//            graph.addVertex(departure.getName());
//        }
//        if (!graph.containsVertex(arrival.getName())) {
//            graph.addVertex(arrival.getName());
//        }
//    }
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
