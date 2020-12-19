package controller;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;
import java.util.Scanner;

public class MinimumTimeController {
    private static WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static List<String> shortestPath;
    private static DijkstraShortestPath dijkstraShortestPath;

    public static void run(Scanner scanner) {
        System.out.println("## 출발역을 입력하세요.");
        String departureStation = scanner.nextLine();
        System.out.println();
        System.out.println("## 도착역을 입력하세요.");
        String arrivalStation = scanner.nextLine();
        System.out.println();

        boolean checkFlag = checkValidateInput(departureStation, arrivalStation);
        if (checkFlag == true)
            printSearchResult(scanner, departureStation, arrivalStation);
        if (checkFlag == false) run(scanner);
    }

    public static boolean checkValidateInput(String departureStation, String arrivalStation) {
        if ((departureStation.charAt(departureStation.length() - 1) != '역')
                || (arrivalStation.charAt(arrivalStation.length() - 1) != '역')) {
            System.out.println("[ERROR] 마지막 글자는 역으로 끝나야 합니다.\n");
            return false;
        }
        if (departureStation.equals(arrivalStation)) {
            System.out.println("[ERROR] 출발역과 도착역을 다르게 입력하세요.\n");
            return false;
        }
        return true;
    }

    public static boolean printSearchResult(Scanner scanner, String departureStation, String arrivalStation) {
        setVertex();
        setEdge();

        try {
            dijkstraShortestPath = new DijkstraShortestPath(graph);
            shortestPath = dijkstraShortestPath.getPath(departureStation, arrivalStation).getVertexList();

        } catch (Exception e) {
            System.out.println("[ERROR] 출발역과 도착역이 연결되어있지 않습니다.\n");
            run(scanner);
            return false;
        }

        int totalDistance = -1;
        int minimumTime = (int) dijkstraShortestPath.getPathWeight(departureStation, arrivalStation);
        System.out.println("## 조회 결과\n" +
                "[INFO] ---\n" +
                "[INFO] 총 거리: " + totalDistance + "km\n" +
                "[INFO] 총 소요 시간: " + minimumTime + "분\n" +
                "[INFO] ---");

        for (int i = 0; i < shortestPath.size(); i++) {
            System.out.println("[INFO] " + shortestPath.get(i));
        }
        System.out.println();
        return true;
    }

    public static void setVertex() {
        for (Station station : StationRepository.stations()) {
            graph.addVertex(station.getName());
        }
    }

    /**
     * 가중치: 소요 시간
     */
    public static void setEdge() {
        graph.setEdgeWeight(graph.addEdge("교대역", "강남역"), 3);
        graph.setEdgeWeight(graph.addEdge("강남역", "역삼역"), 3);
        graph.setEdgeWeight(graph.addEdge("교대역", "남부터미널역"), 2);
        graph.setEdgeWeight(graph.addEdge("남부터미널역", "양재역"), 5);
        graph.setEdgeWeight(graph.addEdge("양재역", "매봉역"), 1);
        graph.setEdgeWeight(graph.addEdge("강남역", "양재역"), 8);
        graph.setEdgeWeight(graph.addEdge("양재역", "양재시민의숲역"), 3);
    }
}
