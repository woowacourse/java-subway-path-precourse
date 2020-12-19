package subway.util;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.*;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

import java.util.List;

public class PathCalculator {

    private WeightedMultigraph<Station, DefaultWeightedEdge> graph;
    private Basis basis;

    public void initGraph(Basis basis) {
        graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        this.basis = basis;
        initVertices();
        initLines();
    }

    private void initVertices() {
        List<Station> stations = StationRepository.stations();
        for (Station station : stations)
            graph.addVertex(station);
    }

    private void initLines() {
        List<Line> lines = LineRepository.lines();
        for (Line line : lines)
            initEdges(line.getPaths());
    }

    private void initEdges(List<Path> paths) {
        for (Path path : paths)
            initEdge(path);
    }

    private void initEdge(Path path) {
        if (basis.getBasis().equals(BasisChoice.DISTANCE.getCode()))
            graph.setEdgeWeight(graph.addEdge(path.getSrcStation(), path.getDstStation()), path.getDistance());
        if (basis.getBasis().equals(BasisChoice.TIME.getCode()))
            graph.setEdgeWeight(graph.addEdge(path.getSrcStation(), path.getDstStation()), path.getTime());
    }
}
