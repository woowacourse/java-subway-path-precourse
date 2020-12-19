package subway.domain.calculator;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.path.Path;
import subway.domain.path.PathRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

import java.util.List;

public class Calculator {
    private Calculator() {
    }

    public static Result getShortestPathByTime(String source, String dest) {
        CalculationValidator.validateCalculation(source, dest);
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        initVertex(graph);
        initEdgesByTime(graph);

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath(source, dest).getVertexList();
        return new Result(shortestPath);
    }

    private static void initVertex(WeightedMultigraph graph) {
        StationRepository.stations().forEach(station -> graph.addVertex(station.getName()));
    }

    private static void initEdgesByTime(WeightedMultigraph graph) {
        List<Station> stations = StationRepository.stations();
        for (Station station : stations) {
            List<Path> paths = PathRepository.findBySource(station);
            initEdgeWeightByTime(graph, paths);
        }
    }

    private static void initEdgeWeightByTime(WeightedMultigraph graph, List<Path> paths) {
        for (Path path : paths) {
            Station source = path.getSource();
            Station dest = path.getDest();
            graph.setEdgeWeight(source.getName(), dest.getName(), path.getTime());
        }
    }

    public static Result getShortestPathByDistance(String source, String dest) {
        CalculationValidator.validateCalculation(source, dest);
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        initVertex(graph);
        initEdgesByDistance(graph);

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath(source, dest).getVertexList();
        return new Result(shortestPath);
    }

    private static void initEdgesByDistance(WeightedMultigraph graph) {
        List<Station> stations = StationRepository.stations();
        for (Station station : stations) {
            List<Path> paths = PathRepository.findBySource(station);
            initEdgeWeightByDistance(graph, paths);
        }
    }

    private static void initEdgeWeightByDistance(WeightedMultigraph graph, List<Path> paths) {
        for (Path path : paths) {
            Station source = path.getSource();
            Station dest = path.getDest();
            graph.setEdgeWeight(source.getName(), dest.getName(), path.getDistance());
        }
    }
}
