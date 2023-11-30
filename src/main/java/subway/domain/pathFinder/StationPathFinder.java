package subway.domain.pathFinder;

import java.util.Set;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Line;
import subway.domain.repository.LineRepository;
import subway.domain.Station;
import subway.domain.UnitPath;

public abstract class StationPathFinder {

    private final DijkstraShortestPath<Station, Integer> dijkstraShortestPath;
    public StationPathFinder(){
        WeightedMultigraph<Station, Integer> graph = new WeightedMultigraph<>(Integer.class);
        LineRepository.lines().stream()
                .map(Line::getPaths)
                .flatMap(Set::stream)
                .forEach(path -> addPathToGraph(graph, path));

        this.dijkstraShortestPath = new DijkstraShortestPath<>(graph);
    }

    public GraphPath<Station, Integer> findPath(Station start, Station end){
        return dijkstraShortestPath.getPath(start, end);
    }

    private void addPathToGraph(WeightedMultigraph<Station, Integer> graph, UnitPath path) {
        graph.addVertex(path.getStart());
        graph.addVertex(path.getEnd());
        graph.addEdge(path.getStart(), path.getEnd(), getCost(path));
    }

    abstract protected int getCost(UnitPath path);
}
