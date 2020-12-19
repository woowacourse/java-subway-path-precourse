package subway.domain.path;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.entity.Section;
import subway.domain.entity.Station;
import subway.dto.PathResponseDto;
import subway.type.FunctionType;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SubwayGraph {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static SubwayGraph subwayGraph;
    private final WeightedMultigraph<Station, DefaultWeightedEdge> shortestDistanceGraph;
    private final WeightedMultigraph<Station, DefaultWeightedEdge> minimumTimeGraph;

    private SubwayGraph(WeightedMultigraph<Station, DefaultWeightedEdge> shortestDistanceGraph,
                        WeightedMultigraph<Station, DefaultWeightedEdge> minimumTimeGraph) {
        this.shortestDistanceGraph = shortestDistanceGraph;
        this.minimumTimeGraph = minimumTimeGraph;
    }

    public static void initiate() {
        subwayGraph = new SubwayGraph(new WeightedMultigraph(DefaultWeightedEdge.class),
                new WeightedMultigraph(DefaultWeightedEdge.class));
    }

    public static SubwayGraph getInstance() {
        if (Objects.isNull(subwayGraph)) {
            throw new IllegalArgumentException();
        }
        return subwayGraph;
    }

    public void addStationToGraph(Station firstStation, Station lastStation, Section section) {
        int distance = section.getDistance();
        int time = section.getTime();
        addShortestDistanceGraph(firstStation, lastStation, distance);
        addMinimumDistanceGraph(firstStation, lastStation, time);
    }

    private void addShortestDistanceGraph(Station firstStation, Station lastStation, int distance) {
        shortestDistanceGraph.addVertex(firstStation);
        shortestDistanceGraph.addVertex(lastStation);
        shortestDistanceGraph.setEdgeWeight(shortestDistanceGraph.addEdge(firstStation, lastStation), distance);
    }

    private void addMinimumDistanceGraph(Station firstStation, Station lastStation, int time) {
        minimumTimeGraph.addVertex(firstStation);
        minimumTimeGraph.addVertex(lastStation);
        minimumTimeGraph.setEdgeWeight(minimumTimeGraph.addEdge(firstStation, lastStation), time);
    }

    public PathResponseDto findShortestPath(Station firstStation, Station lastStation, FunctionType functionType) {
        if (firstStation.equals(lastStation)) {
            throw new PathStationDuplicationException();
        }
        DijkstraShortestPath dijkstraShortestPath = getShortestPath(functionType);
        List<Station> stations = dijkstraShortestPath.getPath(firstStation, lastStation)
                .getVertexList();
        if (stations.isEmpty()) {
            throw new CannotFindPathException();
        }
        return calculateShortestPath(stations);
    }

    private DijkstraShortestPath getShortestPath(FunctionType functionType) {
        if (functionType == FunctionType.SHORTEST_DISTANCE_PATH) {
            return new DijkstraShortestPath(shortestDistanceGraph);
        }
        return new DijkstraShortestPath(minimumTimeGraph);
    }

    private PathResponseDto calculateShortestPath(List<Station> stations) {
        int distanceTotal = getEdgeWeightTotal(stations, shortestDistanceGraph);
        int timeTotal = getEdgeWeightTotal(stations, minimumTimeGraph);
        List<String> stationNames = stations.stream()
                .map(Station::getName)
                .collect(Collectors.toList());
        return new PathResponseDto(distanceTotal, timeTotal, stationNames);
    }

    private int getEdgeWeightTotal(List<Station> stations, WeightedMultigraph<Station,
            DefaultWeightedEdge> weightedMultigraph) {
        int stationCounts = stations.size();
        int edgeWeightTotal = ZERO;
        for (int i = ZERO; i < stationCounts - ONE; i++) {
            Station firstStation = stations.get(i);
            Station nextStation = stations.get(i + ONE);
            DefaultWeightedEdge defaultWeightedEdge = weightedMultigraph.getEdge(firstStation, nextStation);
            edgeWeightTotal += (int) weightedMultigraph.getEdgeWeight(defaultWeightedEdge);
        }
        return edgeWeightTotal;
    }
}
