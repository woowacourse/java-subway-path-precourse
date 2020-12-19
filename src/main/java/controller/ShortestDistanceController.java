package controller;

import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;
import java.util.Scanner;

public class ShortestDistanceController {
    private static WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static void run(Scanner scanner) {
        System.out.println("## 출발역을 입력하세요.");
        String departureStation = scanner.nextLine();
        System.out.println();
        System.out.println("## 도착역을 입력하세요.");
        String arrivalStation = scanner.nextLine();
        System.out.println();

        printSearchResult(departureStation, arrivalStation);
    }

    public static void printSearchResult(String departureStation, String arrivalStation) {
        graph.addVertex("교대역");
        graph.addVertex("강남역");
        graph.addVertex("역삼역");
        graph.addVertex("남부터미널역");
        graph.addVertex("양재역");
        graph.addVertex("양재시민의숲역");
        graph.addVertex("매봉역");

        graph.setEdgeWeight(graph.addEdge("교대역", "강남역"), 2);
        graph.setEdgeWeight(graph.addEdge("강남역", "역삼역"), 2);
        graph.setEdgeWeight(graph.addEdge("교대역", "남부터미널역"), 3);
        graph.setEdgeWeight(graph.addEdge("남부터미널역", "양재역"), 6);
        graph.setEdgeWeight(graph.addEdge("양재역", "매봉역"), 1);
        graph.setEdgeWeight(graph.addEdge("강남역", "양재역"), 2);
        graph.setEdgeWeight(graph.addEdge("양재역", "양재시민의숲역"), 10);

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath(departureStation, arrivalStation).getVertexList();
        System.out.println(dijkstraShortestPath.getPathWeight(departureStation, arrivalStation));

        for (int i = 0; i < shortestPath.size(); i++) {
            System.out.println(shortestPath.get(i));
        }
        System.out.println();

        System.out.println("[INFO] ---\n" +
                "[INFO] 총 거리: " + "몇키로" + "\n" +
                "[INFO] 총 소요 시간: " + "몇시간" + "\n" +
                "[INFO] ---");

    }
}
