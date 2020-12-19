package subway;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.Arrays;
import java.util.List;

public class SubwayInitializer {

    // vertex 꼭지점, edge 길
    public static void init() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        graph.addVertex("교대역");
        graph.addVertex("강남역");
        graph.addVertex("역삼역");
        graph.addVertex("남부터미널역");
        graph.addVertex("양재역");
        graph.addVertex("양재시민의숲역");
        graph.addVertex("매봉역");
//        graph.setEdgeWeight(graph.addEdge("교대역", "강남역"), );
        
    }

}
