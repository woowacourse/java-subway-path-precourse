package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final String[] LINES = {"2호선", "3호선", "신분당선"};
    private static final String[][] LINE_STATIONS = {{"교대역", "강남역", "역삼역"}, {"교대역", "남부터미널역", "양재역", "매봉역"},
            {"강남역", "양재역", "양재시민의숲역"}};
    private static final String NOT_EXIST_ROUTE = "[ERROR] 경로가 존재하지 않습니다.";
    private static final int ROUTE_NOT_EXIST = 0;
    private static int INDEX = 0;

    private static final WeightedMultigraph<String, DefaultWeightedEdge> timeWeight
            = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static final WeightedMultigraph<String, DefaultWeightedEdge> lengthWeight
            = new WeightedMultigraph(DefaultWeightedEdge.class);

    private static final List<Line> lines = new ArrayList<>();

    static {
        lineInitial();
        lengthWeightInitial();
        timeWeightInitial();
    }

    private static void timeWeightInitial() {
        timeWeight.setEdgeWeight(timeWeight.addEdge("교대역", "강남역"), 3);
        timeWeight.setEdgeWeight(timeWeight.addEdge("강남역", "역삼역"), 3);
        timeWeight.setEdgeWeight(timeWeight.addEdge("교대역", "남부터미널역"), 2);
        timeWeight.setEdgeWeight(timeWeight.addEdge("남부터미널역", "양재역"), 5);
        timeWeight.setEdgeWeight(timeWeight.addEdge("양재역", "매봉역"), 1);
        timeWeight.setEdgeWeight(timeWeight.addEdge("강남역", "양재역"), 8);
        timeWeight.setEdgeWeight(timeWeight.addEdge("양재역", "양재시민의숲역"), 3);
    }

    private static void lengthWeightInitial() {
        lengthWeight.setEdgeWeight(lengthWeight.addEdge("교대역", "강남역"), 2);
        lengthWeight.setEdgeWeight(lengthWeight.addEdge("강남역", "역삼역"), 2);
        lengthWeight.setEdgeWeight(lengthWeight.addEdge("교대역", "남부터미널역"), 3);
        lengthWeight.setEdgeWeight(lengthWeight.addEdge("남부터미널역", "양재역"), 6);
        lengthWeight.setEdgeWeight(lengthWeight.addEdge("양재역", "매봉역"), 1);
        lengthWeight.setEdgeWeight(lengthWeight.addEdge("강남역", "양재역"), 2);
        lengthWeight.setEdgeWeight(lengthWeight.addEdge("양재역", "양재시민의숲역"), 10);
    }

    private static void lineInitial() {
        for (String lineName : LINES) {
            Line line = new Line(lineName);
            for (String stationName : LINE_STATIONS[INDEX]) {
                line.addStation(new Station(stationName));
                lengthWeight.addVertex(stationName);
                timeWeight.addVertex(stationName);
            }
            addLine(line);
            INDEX++;
        }
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }

    public static WeightedMultigraph<String, DefaultWeightedEdge> getTimeWeight() {
        return timeWeight;
    }

    public static boolean findShortestTime(String startStation, String endStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeWeight);
        List<String> shortestPath = dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
        if (shortestPath.size() == ROUTE_NOT_EXIST) {
            System.out.println(NOT_EXIST_ROUTE);
            return false;
        }
        showStatusTime(dijkstraShortestPath, shortestPath, startStation, endStation);
        return true;
    }

    private static void showStatusTime(DijkstraShortestPath path, List<String> shortestPath,
                                       String startStation, String endStation) {
        OutputView.totalLength(findTotalLength(shortestPath));
        OutputView.totalTime((int) path.getPathWeight(startStation, endStation));
        OutputView.bar();
        for (String stationName : shortestPath) {
            OutputView.status(stationName);
        }
        OutputView.space();
    }

    public static boolean findShortestLength(String startStation, String endStation) {
        DijkstraShortestPath path = new DijkstraShortestPath(lengthWeight);
        List<String> shortestPath = path.getPath(startStation, endStation).getVertexList();
        if (shortestPath.size() == ROUTE_NOT_EXIST) {
            System.out.println(NOT_EXIST_ROUTE);
            return false;
        }
        showStatusLength(path, shortestPath, startStation, endStation);
        return true;
    }

    private static void showStatusLength(DijkstraShortestPath path, List<String> shortestPath,
                                         String startStation, String endStation) {
        OutputView.bar();
        OutputView.totalLength((int) path.getPathWeight(startStation, endStation));
        OutputView.totalTime(findTotalTime(shortestPath));
        OutputView.bar();
        for (String stationName : shortestPath) {
            OutputView.status(stationName);
        }
        OutputView.space();
    }

    private static int findTotalTime(List<String> shortestPath) {
        int length = shortestPath.size();
        int total = 0;
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeWeight);
        for (int i = 0; i < length - 1; i++) {
            total += (int) dijkstraShortestPath.getPathWeight(shortestPath.get(i), shortestPath.get(i + 1));
        }
        return total;
    }

    private static int findTotalLength(List<String> shortestPath) {
        int length = shortestPath.size();
        int total = 0;
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(lengthWeight);
        for (int i = 0; i < length - 1; i++) {
            total += (int) dijkstraShortestPath.getPathWeight(shortestPath.get(i), shortestPath.get(i + 1));
        }
        return total;
    }
}
