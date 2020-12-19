package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class EdgeRepository {
    private static final List<Edge> edges = new ArrayList<>();
    
    public static void addEdge(Edge edge) {
        edges.add(edge);
        TimeGraph.setEdge(edge.getLeftEndStation(), edge.getRightEndStation(), edge.getTime());
        DistanceGraph.setEdge(edge.getLeftEndStation(), edge.getRightEndStation(), edge.getDistance());
    }

    public static void addEdgeByNamesAndNumbers(String leftEndStationName, String rightEndStationName, int distance,
            int time) {
        addEdge(new Edge(StationRepository.getStationByName(leftEndStationName),
                StationRepository.getStationByName(rightEndStationName), distance, time));
    }
    
    public static Edge getEdgeByStations(Station leftEndStation, Station rightEndStation) {
        for (Edge edge : edges) {
            if (edge.stationsEquals(leftEndStation, rightEndStation)) {
                return edge;
            }
        }
        return null;
    }
}
