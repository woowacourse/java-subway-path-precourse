package subway;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.Station;
import subway.domain.SubwayGraph;

import java.util.List;

public class TimeShortestPath {
    DijkstraShortestPath dijkstraShortestPath;

    public TimeShortestPath(SubwayGraph graph) {
        this.dijkstraShortestPath = new DijkstraShortestPath(graph.getTimeWeightGraph());
    }

    public List<Station> getRoute(Station start, Station end) {
        return dijkstraShortestPath.getPath(start, end)
                                   .getVertexList();
    }
}
