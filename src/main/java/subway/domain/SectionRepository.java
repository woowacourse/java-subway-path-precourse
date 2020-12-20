package subway.domain;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.ArrayList;
import java.util.List;

public class SectionRepository {

    static WeightedMultigraph<String, DefaultWeightedEdge> graphByDistance = new WeightedMultigraph(DefaultWeightedEdge.class);
    static WeightedMultigraph<String, DefaultWeightedEdge> graphByCost = new WeightedMultigraph(DefaultWeightedEdge.class);
    static List<Section> sections = new ArrayList<>();

    public static void addSection(String lineName, String stationName, int sequence) {
        Line line = LineRepository.findLine(lineName);
        Station station = StationRepository.findStation(stationName);
        line.addSection(sequence, station);
    }

    public static void addSectinonDistanceAndCost(String station1, String station2, int distance, int cost) {
        addVertex(station1, station2);
        setEdgeWeight(station1, station2, distance, cost);
        sections.add(new Section(station1, station2, distance, cost));
    }

    private static void setEdgeWeight(String station1, String station2, int distance, int cost) {
        graphByDistance.setEdgeWeight(graphByDistance.addEdge(station1, station2), distance);
        graphByCost.setEdgeWeight(graphByCost.addEdge(station1, station2), cost);
    }

    public static void findShortestPathByDistance(String departure, String destination) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graphByDistance);
        GraphPath graphPath = dijkstraShortestPath.getPath(departure, destination);

        List<String> path = graphPath.getVertexList();
        double shortestPathDistance = graphPath.getWeight();
        int costTime = calculateCostTime(path);
    }

    private static int calculateCostTime(List<String> path) {
        for(int i=0; i<path.size()-1; i++) {
            // if sections중 하나가 path.get(i) path.get(i+1)둘다 가지고 있음
            // 그 section의 거리만큼 +
        }
        return 1;
    }

    public static void findShortestPathByCost(String departure, String destination) {

    }

    private static void addVertex(String station1, String station2) {
        if (!graphByDistance.containsVertex(station1)) {
            graphByDistance.addVertex(station1);
        }
        if (!graphByDistance.containsVertex(station2)) {
            graphByDistance.addVertex(station2);
        }
        if (!graphByCost.containsVertex(station1)) {
            graphByCost.addVertex(station1);
        }
        if (!graphByCost.containsVertex(station2)) {
            graphByCost.addVertex(station2);
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
