package subway.domain;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.WeightedMultigraph;
import subway.repository.SectionRepository;

import java.util.List;
import java.util.Map;

public class DistanceMap implements SubwayGraph{
    public void addWeight() {
        Map<Section, RequiredResources> sections = SectionRepository.sections();
        sections.forEach((key, value)
            -> subwayGraph.setEdgeWeight(subwayGraph.addEdge(key.getFirstStation(), key.getSecondStation()), value.getDistance().getDistance()));
    }

    public List getShortestDistanceRoute(WeightedMultigraph graph, Station first, Station second) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        isConnectedMap(dijkstraShortestPath.getPath(first, second));
        return dijkstraShortestPath.getPath(first, second).getVertexList();
    }
}
