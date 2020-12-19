package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class SectionRepository {

    private static final WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph = new WeightedMultigraph<>(
        DefaultWeightedEdge.class);
    private static final WeightedMultigraph<String, DefaultWeightedEdge> timeGraph = new WeightedMultigraph<>(
        DefaultWeightedEdge.class);


    public SectionRepository() {
        distanceGraph.addVertex("교대역");
        distanceGraph.addVertex("강남역");
        distanceGraph.addVertex("남부터미널역");
        distanceGraph.addVertex("양재역");
        distanceGraph.addVertex("역삼역");
        distanceGraph.addVertex("남부터미널역");
        distanceGraph.addVertex("양재시민의숲역");
        distanceGraph.addVertex("매봉역");
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("교대역", "강남역"), 2);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("강남역", "역삼역"), 2);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("교대역", "남부터미널역"), 3);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("남부터미널역", "양재역"), 6);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("양재역", "매봉역"), 1);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("강남역", "양재역"), 2);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("양재역", "양재시민의숲역"), 10);

        timeGraph.addVertex("교대역");
        timeGraph.addVertex("강남역");
        timeGraph.addVertex("남부터미널역");
        timeGraph.addVertex("양재역");
        timeGraph.addVertex("역삼역");
        timeGraph.addVertex("남부터미널역");
        timeGraph.addVertex("양재시민의숲역");
        timeGraph.addVertex("매봉역");
        timeGraph.setEdgeWeight(timeGraph.addEdge("교대역", "강남역"), 3);
        timeGraph.setEdgeWeight(timeGraph.addEdge("강남역", "역삼역"), 3);
        timeGraph.setEdgeWeight(timeGraph.addEdge("교대역", "남부터미널역"), 2);
        timeGraph.setEdgeWeight(timeGraph.addEdge("남부터미널역", "양재역"), 5);
        timeGraph.setEdgeWeight(timeGraph.addEdge("양재역", "매봉역"), 1);
        timeGraph.setEdgeWeight(timeGraph.addEdge("강남역", "양재역"), 8);
        timeGraph.setEdgeWeight(timeGraph.addEdge("양재역", "양재시민의숲역"), 3);
    }

    public WeightedMultigraph<String, DefaultWeightedEdge> getDistanceGraph() {
        return distanceGraph;
    }

    public WeightedMultigraph<String, DefaultWeightedEdge> getTimeGraph() {
        return timeGraph;
    }
}
