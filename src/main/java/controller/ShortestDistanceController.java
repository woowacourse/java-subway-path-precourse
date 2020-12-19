package controller;

import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

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

        boolean checkFlag = checkValidateInput(departureStation, arrivalStation);
        if (checkFlag == true)
            printSearchResult(departureStation, arrivalStation);
        if (checkFlag == false) run(scanner);
    }

    public static boolean checkValidateInput(String departureStation, String arrivalStation) {
        if (departureStation.equals(arrivalStation)) {
            System.out.println("[ERROR] 출발역과 도착역을 다르게 입력하세요.");
            return false;
        }
        return true;
    }

    public static void printSearchResult(String departureStation, String arrivalStation) {
        setVertex();
        setEdge();
        try {
            DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
            List<String> shortestPath = dijkstraShortestPath.getPath(departureStation, arrivalStation).getVertexList();
            int shortestDistance = (int) dijkstraShortestPath.getPathWeight(departureStation, arrivalStation);
            System.out.println("## 조회 결과\n" +
                    "[INFO] ---\n" +
                    "[INFO] 총 거리: " + shortestDistance + "km\n" +
                    "[INFO] 총 소요 시간: " + "" + "분\n" +
                    "[INFO] ---");

            for (int i = 0; i < shortestPath.size(); i++) {
                System.out.println("[INFO] " + shortestPath.get(i));
            }
        } catch (Exception e) {
            System.out.println("[ERROR] 출발역과 도착역이 연결되어있지 않습니다.");
        }
        System.out.println();
    }

    public static void setVertex() {
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            List<Station> stations = line.getSection();
            for (Station station : stations) {
                graph.addVertex(station.getName());
            }
        }
    }

    public static void setEdge() {
        graph.setEdgeWeight(graph.addEdge("교대역", "강남역"), 2);
        graph.setEdgeWeight(graph.addEdge("강남역", "역삼역"), 2);
        graph.setEdgeWeight(graph.addEdge("교대역", "남부터미널역"), 3);
        graph.setEdgeWeight(graph.addEdge("남부터미널역", "양재역"), 6);
        graph.setEdgeWeight(graph.addEdge("양재역", "매봉역"), 1);
        graph.setEdgeWeight(graph.addEdge("강남역", "양재역"), 2);
        graph.setEdgeWeight(graph.addEdge("양재역", "양재시민의숲역"), 10);
    }
}
