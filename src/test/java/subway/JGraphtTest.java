package subway;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JGraphtTest {
    @Test
    public void getDijkstraShortestPath() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        graph.addVertex("v1");
        graph.addVertex("v2");
        graph.addVertex("v3");
        graph.setEdgeWeight(graph.addEdge("v1", "v2"), 2);
        graph.setEdgeWeight(graph.addEdge("v2", "v3"), 2);
        graph.setEdgeWeight(graph.addEdge("v1", "v3"), 100);

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath("v3", "v1").getVertexList();

        double weight;
        try{
            weight = dijkstraShortestPath.getPathWeight("v4", "v1");
            System.out.println(weight);
        } catch (Exception e){
            System.out.println("갈수 없는 경로 입니다.");
        }

        for(String string : shortestPath){
            System.out.println(string);
        }


        //assertThat(shortestPath.size()).isEqualTo(3);
    }

    public static void main(String[] args) {
        JGraphtTest jGraphtTest = new JGraphtTest();
        jGraphtTest.getDijkstraShortestPath();
    }
}
