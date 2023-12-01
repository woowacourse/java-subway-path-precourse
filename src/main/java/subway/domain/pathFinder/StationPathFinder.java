package subway.domain.pathFinder;

import java.util.Set;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Line;
import subway.domain.repository.LineRepository;
import subway.domain.Station;
import subway.domain.UnitPath;

public abstract class StationPathFinder {

    private final DijkstraShortestPath<Station, DefaultWeightedEdge> dijkstraShortestPath;
    public StationPathFinder(){
        WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        LineRepository.lines().stream()
                .map(Line::getPaths)
                .flatMap(Set::stream)
                .forEach(path -> addPathToGraph(graph, path));

        this.dijkstraShortestPath = new DijkstraShortestPath<>(graph);
    }

    public GraphPath<Station, DefaultWeightedEdge> findPath(Station start, Station end){
        return dijkstraShortestPath.getPath(start, end);
    }

    private void addPathToGraph(WeightedMultigraph<Station, DefaultWeightedEdge> graph, UnitPath path) {
        graph.addVertex(path.getStart());
        graph.addVertex(path.getEnd());
        int cost = getCost(path);

        graph.setEdgeWeight(graph.addEdge(path.getStart(), path.getEnd()), cost);
        graph.setEdgeWeight(graph.addEdge(path.getEnd(), path.getStart()), cost);

    }

    abstract protected int getCost(UnitPath path);
}
