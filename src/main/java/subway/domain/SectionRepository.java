package subway.domain;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.Menu.Menu;
import subway.PathResult;

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

    public static void addSectinonDistanceAndTime(String station1, String station2, int distance, int requiredTime) {
        addVertex(station1, station2);
        setEdgeWeight(station1, station2, distance, requiredTime);
        sections.add(new Section(station1, station2, distance, requiredTime));
    }

    private static void setEdgeWeight(String station1, String station2, int distance, int requiredTime) {
        graphByDistance.setEdgeWeight(graphByDistance.addEdge(station1, station2), distance);
        graphByCost.setEdgeWeight(graphByCost.addEdge(station1, station2), requiredTime);
    }

    public static PathResult findshortestPath(String input, String departure, String destination) {
        validateDepartureAndDestination(departure, destination);

        WeightedMultigraph<String, DefaultWeightedEdge> graph = null;
        if (input.equals(Menu.ROUTE_CRITERIA.SHORTEST_DISTANCE.getCode())) {
            graph = graphByDistance;
        }
        if (input.equals(Menu.ROUTE_CRITERIA.SHORTEST_TIME.getCode())) {
            graph = graphByCost;
        }
        List<String> shortestPath = getShortestPath(graph, departure, destination);

        return new PathResult(shortestPath, calculateDistance(shortestPath), calculateRequiredTime(shortestPath));
    }

    public static List<String> getShortestPath(WeightedMultigraph<String, DefaultWeightedEdge> graph, String departure, String destination) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        GraphPath graphPath = dijkstraShortestPath.getPath(departure, destination);
        return  graphPath.getVertexList();

    }

    private static void validateDepartureAndDestination(String departure, String destination) {
        StationRepository.findStation(departure);
        StationRepository.deleteStation(destination);
        if (departure.equals(destination)) {
            throw new IllegalArgumentException("[ERROR] 출발역과 도착역이 같습니다.");
        }
    }

    private static int calculateRequiredTime(List<String> shortestPath) {
        return sections.stream()
                .filter(section -> section.isInShortestPath(shortestPath))
                .mapToInt(Section::getRequiredTime)
                .sum();
    }

    private static int calculateDistance(List<String> shortestPath) {
        return sections.stream()
                .filter(section -> section.isInShortestPath(shortestPath))
                .mapToInt(Section::getDistance)
                .sum();
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
}
