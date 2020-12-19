package subway;

import subway.domain.EdgeRepository;
import subway.domain.StationRepository;
import subway.domain.SubwayGraph;

public class Application {
    public static void main(String[] args) {
        Settings.init();
        SubwayGraph graph = new SubwayGraph();
        graph.addVertices(StationRepository.stations());
        graph.setEdgeWeight(EdgeRepository.edges());
        DistanceShortestPath distanceShortestPath = new DistanceShortestPath(graph);
        TimeShortestPath timeShortestPath = new TimeShortestPath(graph);
        distanceShortestPath.getRoute();
        MainService.view();
    }
}
