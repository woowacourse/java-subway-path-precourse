package subway.service;

import static subway.domain.RouteInfo.calculateTotalDistance;
import static subway.domain.RouteInfo.calculateTotalTime;
import static subway.domain.RouteInfo.values;

import java.util.List;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Result;
import subway.domain.RouteInfo;
import subway.domain.Station;

public class MinimumTimeService {
    public Result calculate(Station start, Station end) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = createGraph(values());

        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath =
                new DijkstraShortestPath<>(graph);

        GraphPath<String, DefaultWeightedEdge> shortestPath =
                dijkstraShortestPath.getPath(start.getName(), end.getName());

        List<DefaultWeightedEdge> edges = shortestPath.getEdgeList();

        int totalDistance = calculateTotalDistance(graph, edges);
        int totalTime = calculateTotalTime(graph, edges);

        return Result.createResult(totalDistance, totalTime, shortestPath.getVertexList());
    }

    private WeightedMultigraph<String, DefaultWeightedEdge> createGraph(RouteInfo[] routeInfos) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph =
                new WeightedMultigraph<>(DefaultWeightedEdge.class);

        for (RouteInfo routeInfo : routeInfos) {
            routeInfo.calculateMinimumTime(graph, routeInfo);
        }

        return graph;
    }
}