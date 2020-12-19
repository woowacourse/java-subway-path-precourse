package subway;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.Station;
import subway.domain.SubwayGraph;

import java.util.List;

public class DistanceShortestPath {
    DijkstraShortestPath dijkstraShortestPath;

    public DistanceShortestPath(SubwayGraph graph) {
        this.dijkstraShortestPath = new DijkstraShortestPath(graph.getDistanceWeightGraph());
    }

    public List<Station> getRoute(Station start, Station end) {
        return dijkstraShortestPath.getPath(start, end)
                                   .getVertexList();
    }
}
