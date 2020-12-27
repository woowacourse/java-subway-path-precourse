package subway;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.PositiveDistance;
import subway.domain.PositiveTime;
import subway.domain.Station;
import subway.manager.DistanceRouteManager;
import subway.manager.TimeRouteManager;

public class ApplicationInitializer {

    public static SubwayApplication injectDependencies() {
        WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph
                = new WeightedMultigraph(DefaultWeightedEdge.class);
        WeightedMultigraph<Station, DefaultWeightedEdge> timeGraph
                = new WeightedMultigraph(DefaultWeightedEdge.class);
        initStation(distanceGraph, timeGraph);
        initSection(distanceGraph, timeGraph);
        DistanceRouteManager shortestDistance = new DistanceRouteManager(distanceGraph, timeGraph);
        TimeRouteManager minimumTime = new TimeRouteManager(distanceGraph, timeGraph);
        return new SubwayApplication(shortestDistance, minimumTime);
    }

    private static void initStation(WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph,
                                        WeightedMultigraph<Station, DefaultWeightedEdge> timeGraph) {
        distanceGraph.addVertex(new Station("교대역"));
        distanceGraph.addVertex(new Station("강남역"));
        distanceGraph.addVertex(new Station("역삼역"));
        distanceGraph.addVertex(new Station("남부터미널역"));
        distanceGraph.addVertex(new Station("양재역"));
        distanceGraph.addVertex(new Station("양재시민의숲역"));
        distanceGraph.addVertex(new Station("매봉역"));
        distanceGraph.addVertex(new Station("서울역"));

        timeGraph.addVertex(new Station("교대역"));
        timeGraph.addVertex(new Station("강남역"));
        timeGraph.addVertex(new Station("역삼역"));
        timeGraph.addVertex(new Station("남부터미널역"));
        timeGraph.addVertex(new Station("양재역"));
        timeGraph.addVertex(new Station("양재시민의숲역"));
        timeGraph.addVertex(new Station("매봉역"));
        timeGraph.addVertex(new Station("서울역"));
    }

    public static void initSection(WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph,
                                WeightedMultigraph<Station, DefaultWeightedEdge> timeGraph) {
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(new Station("교대역"),
                            new Station("강남역")), new PositiveDistance(2).getDistance());
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(new Station("강남역"),
                            new Station("역삼역")), new PositiveDistance(2).getDistance());
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(new Station("교대역"),
                            new Station("남부터미널역")), new PositiveDistance(3).getDistance());
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(new Station("남부터미널역"),
                            new Station("양재역")), new PositiveDistance(6).getDistance());
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(new Station("양재역"),
                            new Station("매봉역")), new PositiveDistance(1).getDistance());
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(new Station("강남역"),
                            new Station("양재역")), new PositiveDistance(2).getDistance());
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(new Station("양재역"),
                            new Station("양재시민의숲역")), new PositiveDistance(10).getDistance());

        timeGraph.setEdgeWeight(timeGraph.addEdge(new Station("교대역"),
                            new Station("강남역")), new PositiveTime(3).getTime());
        timeGraph.setEdgeWeight(timeGraph.addEdge(new Station("강남역"),
                            new Station("역삼역")), new PositiveTime(3).getTime());
        timeGraph.setEdgeWeight(timeGraph.addEdge(new Station("교대역"),
                            new Station("남부터미널역")), new PositiveTime(2).getTime());
        timeGraph.setEdgeWeight(timeGraph.addEdge(new Station("남부터미널역"),
                            new Station("양재역")), new PositiveTime(5).getTime());
        timeGraph.setEdgeWeight(timeGraph.addEdge(new Station("양재역"),
                            new Station("매봉역")), new PositiveTime(1).getTime());
        timeGraph.setEdgeWeight(timeGraph.addEdge(new Station("강남역"),
                            new Station("양재역")), new PositiveTime(8).getTime());
        timeGraph.setEdgeWeight(timeGraph.addEdge(new Station("양재역"),
                            new Station("양재시민의숲역")), new PositiveTime(3).getTime());
    }
}
