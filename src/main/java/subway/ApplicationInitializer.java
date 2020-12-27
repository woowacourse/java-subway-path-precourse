package subway;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Station;

public class ApplicationInitializer {

    public static ApplicationContext injectDependencies() {
        WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph
                = new WeightedMultigraph(DefaultWeightedEdge.class);
        WeightedMultigraph<Station, DefaultWeightedEdge> timeGraph
                = new WeightedMultigraph(DefaultWeightedEdge.class);
        initStation(distanceGraph, timeGraph);
        initSection(distanceGraph, timeGraph);
        DistanceController shortestDistance = new DistanceController(distanceGraph, timeGraph);
        TimeController minimumTime = new TimeController(distanceGraph, timeGraph);
        return new ApplicationContext(shortestDistance, minimumTime);
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
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(new Station("교대역"), new Station("강남역")), 2);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(new Station("강남역"), new Station("역삼역")), 2);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(new Station("교대역"), new Station("남부터미널역")), 3);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(new Station("남부터미널역"), new Station("양재역")), 6);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(new Station("양재역"), new Station("매봉역")), 1);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(new Station("강남역"), new Station("양재역")), 2);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(new Station("양재역"), new Station("양재시민의숲역")), 10);

        timeGraph.setEdgeWeight(timeGraph.addEdge(new Station("교대역"), new Station("강남역")), 3);
        timeGraph.setEdgeWeight(timeGraph.addEdge(new Station("강남역"), new Station("역삼역")), 3);
        timeGraph.setEdgeWeight(timeGraph.addEdge(new Station("교대역"), new Station("남부터미널역")), 2);
        timeGraph.setEdgeWeight(timeGraph.addEdge(new Station("남부터미널역"), new Station("양재역")), 5);
        timeGraph.setEdgeWeight(timeGraph.addEdge(new Station("양재역"), new Station("매봉역")), 1);
        timeGraph.setEdgeWeight(timeGraph.addEdge(new Station("강남역"), new Station("양재역")), 8);
        timeGraph.setEdgeWeight(timeGraph.addEdge(new Station("양재역"), new Station("양재시민의숲역")), 3);
    }
}
