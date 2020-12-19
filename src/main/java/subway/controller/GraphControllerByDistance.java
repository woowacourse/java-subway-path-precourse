package subway.controller;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.Arrays;
import java.util.List;

public class GraphControllerByDistance {
    private static final String KYODAE = "교대역";
    private static final String GANGNAM = "강남역";
    private static final String YUKSAM = "역삼역";
    private static final String NAMBU = "남부터미널역";
    private static final String YANGJAE = "양재역";
    private static final String YANGJAEFOREST = "양재시민의숲역";
    private static final String MAEBONG = "매봉역";

    private List<String> stations = Arrays.asList(KYODAE, GANGNAM, YUKSAM, NAMBU, YANGJAE, YANGJAEFOREST, MAEBONG);
    private WeightedMultigraph<String, DefaultWeightedEdge> graph;

    public GraphControllerByDistance() {
        initDistance();
    }

    private void initDistance() {
        graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        stations.forEach(station -> graph.addVertex(station));
        initLineTwoByDistance(graph);
        initLineThreeByDistance(graph);
        initLineShinByDistance(graph);
    }

    private void initLineTwoByDistance(WeightedMultigraph<String, DefaultWeightedEdge> graph) {
        graph.setEdgeWeight(graph.addEdge(KYODAE, GANGNAM),2);
        graph.setEdgeWeight(graph.addEdge(GANGNAM, YUKSAM),2);
    }

    private void initLineThreeByDistance(WeightedMultigraph<String, DefaultWeightedEdge> graph) {
        graph.setEdgeWeight(graph.addEdge(KYODAE, NAMBU), 3);
        graph.setEdgeWeight(graph.addEdge(NAMBU, YANGJAE),6);
        graph.setEdgeWeight(graph.addEdge(YANGJAE, MAEBONG),1);
    }

    private void initLineShinByDistance(WeightedMultigraph<String, DefaultWeightedEdge> graph) {
        graph.setEdgeWeight(graph.addEdge(GANGNAM, YANGJAE),2);
        graph.setEdgeWeight(graph.addEdge(YANGJAE, YANGJAEFOREST),10);
    }


    public List<String> getMinDistance(String departure, String arrival) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> minDistance = dijkstraShortestPath.getPath(departure, arrival).getVertexList();
        return minDistance;
    }

    public double getTotalDistance(String departure, String arrival) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        double totalDistance = dijkstraShortestPath.getPath(departure, arrival).getWeight();
        return totalDistance;
    }


}
