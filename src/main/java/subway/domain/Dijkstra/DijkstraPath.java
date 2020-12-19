
package subway.domain.Dijkstra;

import java.util.List;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;

public class DijkstraPath {
    DijkstraShortestPath dijkstraShortestPath = null;

    public DijkstraPath(RouteMap routeMap) {
        dijkstraShortestPath = new DijkstraShortestPath(routeMap.getGraph());
    }

    public List<Station> getStationsPassing(Station source, Station destination) {
        return dijkstraShortestPath.getPath(source, destination).getVertexList();
    }

    public List<DefaultWeightedEdge> getIntervalsPassing(Station source, Station destination) {
        return dijkstraShortestPath.getPath(source, destination).getEdgeList();
    }

}
