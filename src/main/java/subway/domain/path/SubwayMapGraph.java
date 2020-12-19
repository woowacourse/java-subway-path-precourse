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

public class SubwayMapGraph {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static SubwayMapGraph subwayMapGraph;
    private final WeightedMultigraph<Station, DefaultWeightedEdge> shortestDistanceGraph;
    private final WeightedMultigraph<Station, DefaultWeightedEdge> minimumTimeGraph;

    private SubwayMapGraph(WeightedMultigraph<Station, DefaultWeightedEdge> shortestDistanceGraph,
                           WeightedMultigraph<Station, DefaultWeightedEdge> minimumTimeGraph) {
        this.shortestDistanceGraph = shortestDistanceGraph;
        this.minimumTimeGraph = minimumTimeGraph;
    }

    public static void initiate() {
        subwayMapGraph = new SubwayMapGraph(new WeightedMultigraph(DefaultWeightedEdge.class),
                new WeightedMultigraph(DefaultWeightedEdge.class));
    }

    public static SubwayMapGraph getInstance() {
        if (Objects.isNull(subwayMapGraph)) {
            throw new IllegalArgumentException();
        }
        return subwayMapGraph;
    }

    public void addStationToGraph(Station firstStation, Station lastStation, Section section) {
        System.out.println(firstStation.getName());
        System.out.println(lastStation.getName());
        System.out.println(section.getDistance());
        System.out.println(section.getTime());
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

    public PathResponseDto findPath(Station firstStation, Station lastStation, FunctionType functionType) {
        if (firstStation.equals(lastStation)) {
            throw new IllegalArgumentException();
        }
        DijkstraShortestPath dijkstraShortestPath = getShortestPath(functionType);
        List<Station> stations = dijkstraShortestPath.getPath(firstStation, lastStation)
                .getVertexList();
        return calculatePath(stations);
    }

    private DijkstraShortestPath getShortestPath(FunctionType functionType) {
        if (functionType == FunctionType.SHORTEST_DISTANCE_ROUTE) {
            return new DijkstraShortestPath(shortestDistanceGraph);
        }
        return new DijkstraShortestPath(minimumTimeGraph);
    }

    private PathResponseDto calculatePath(List<Station> stations) {
        int distanceTotal = getEdgeWieghtTotal(stations, shortestDistanceGraph);
        int timeTotal = getEdgeWieghtTotal(stations, minimumTimeGraph);
        List<String> stationNames = stations.stream()
                .map(Station::getName)
                .collect(Collectors.toList());
        return new PathResponseDto(distanceTotal, timeTotal, stationNames);
    }

    private int getEdgeWieghtTotal(List<Station> stations, WeightedMultigraph<Station,
            DefaultWeightedEdge> weightedMultigraph) {
        int stationCounts = stations.size();
        int edgeWeightTotal = ZERO;
        for (int i = ZERO; i < stationCounts - ONE; i++) {
            Station first = stations.get(i);
            Station next = stations.get(i + ONE);
            DefaultWeightedEdge defaultWeightedEdge = weightedMultigraph.getEdge(first, next);
            edgeWeightTotal += (int) weightedMultigraph.getEdgeWeight(defaultWeightedEdge);
        }
        return edgeWeightTotal;
    }
}
