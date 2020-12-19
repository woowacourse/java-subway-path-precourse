package subway;

import controller.SubwayController;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        WeightedMultigraph<String, DefaultWeightedEdge> graph
                = new WeightedMultigraph(DefaultWeightedEdge.class);
        graph.addVertex("v1");
        graph.addVertex("v2");
        graph.addVertex("v3");
        graph.setEdgeWeight(graph.addEdge("v1", "v2"), 1);
        graph.setEdgeWeight(graph.addEdge("v2", "v3"), 5);
        graph.setEdgeWeight(graph.addEdge("v1", "v3"), 7);

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath("v3", "v1").getVertexList();

        for (int i = 0; i < shortestPath.size(); i++) {
            System.out.println(shortestPath.get(i));
        }

//        final Scanner scanner = new Scanner(System.in);
//        new MakeSubway().initSubway();
//        new SubwayController(scanner);
    }
}
