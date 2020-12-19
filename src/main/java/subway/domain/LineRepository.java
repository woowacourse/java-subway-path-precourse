package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineRepository {
    private static final String[] LINES = {"2호선", "3호선", "신분당선"};
    private static final String[][] LINE_STATIONS = {{"교대역","강남역","역삼역"},{"교대역","남부터미널역","양재역","매봉역"},
            {"강남역","양재역","양재시민의숲역"}};
    private static final WeightedMultigraph<String, DefaultWeightedEdge> timeWeight
            = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static final WeightedMultigraph<String, DefaultWeightedEdge> lengthWeight
            = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static final int ROUTE_NOT_EXIST = 0;
    private static final String NOT_EXIST_ROUTE = "[ERROR] 경로가 존재하지 않습니다.";
    private static int INDEX = 0;

    public static WeightedMultigraph<String, DefaultWeightedEdge> getTimeWeight() {
        return timeWeight;
    }

    private static final List<Line> lines = new ArrayList<>();

    static{
        for(String lineName : LINES){
            Line line = new Line(lineName);
            for(String stationName : LINE_STATIONS[INDEX]){
                line.addStation(new Station(stationName));
            }
            addLine(line);
            INDEX++;
        }

        lengthWeight.addVertex("교대역");
        lengthWeight.addVertex("강남역");
        lengthWeight.addVertex("역삼역");
        lengthWeight.addVertex("남부터미널역");
        lengthWeight.addVertex("양재역");
        lengthWeight.addVertex("매봉역");
        lengthWeight.addVertex("양재시민의숲역");

        lengthWeight.setEdgeWeight(lengthWeight.addEdge("교대역","강남역"), 2);
        lengthWeight.setEdgeWeight(lengthWeight.addEdge("강남역","역삼역"), 2);
        lengthWeight.setEdgeWeight(lengthWeight.addEdge("교대역","남부터미널역"), 3);
        lengthWeight.setEdgeWeight(lengthWeight.addEdge("남부터미널역","양재역"), 6);
        lengthWeight.setEdgeWeight(lengthWeight.addEdge("양재역","매봉역"), 1);
        lengthWeight.setEdgeWeight(lengthWeight.addEdge("강남역","양재역"), 2);
        lengthWeight.setEdgeWeight(lengthWeight.addEdge("양재역","양재시민의숲역"), 10);

        timeWeight.addVertex("교대역");
        timeWeight.addVertex("강남역");
        timeWeight.addVertex("역삼역");
        timeWeight.addVertex("남부터미널역");
        timeWeight.addVertex("양재역");
        timeWeight.addVertex("매봉역");
        timeWeight.addVertex("양재시민의숲역");

        timeWeight.setEdgeWeight(timeWeight.addEdge("교대역","강남역"), 3);
        timeWeight.setEdgeWeight(timeWeight.addEdge("강남역","역삼역"), 3);
        timeWeight.setEdgeWeight(timeWeight.addEdge("교대역","남부터미널역"), 2);
        timeWeight.setEdgeWeight(timeWeight.addEdge("남부터미널역","양재역"), 5);
        timeWeight.setEdgeWeight(timeWeight.addEdge("양재역","매봉역"), 1);
        timeWeight.setEdgeWeight(timeWeight.addEdge("강남역","양재역"), 8);
        timeWeight.setEdgeWeight(timeWeight.addEdge("양재역","양재시민의숲역"), 3);
    }


    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean findShortestTime(String startStation, String endStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeWeight);
        List<String> shortestPath = dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
        if(shortestPath.size() == 0){
            System.out.println(NOT_EXIST_ROUTE);
            return false;
        }
        showStatusTime(dijkstraShortestPath,shortestPath,startStation,endStation);
        return true;
    }

    private static void showStatusTime(DijkstraShortestPath path, List<String> shortestPath,
                                       String startStation, String endStation) {
        int length = findTotalLength(shortestPath);
        OutputView.totalLength(length);
        int time = (int)path.getPathWeight(startStation,endStation);
        OutputView.totalTime(time);
        OutputView.bar();
        for(String stationName : shortestPath){
            OutputView.status(stationName);
        }
        OutputView.space();
    }

    public static boolean findShortestLength(String startStation, String endStation) {
        DijkstraShortestPath path = new DijkstraShortestPath(lengthWeight);
        List<String> shortestPath = path.getPath(startStation, endStation).getVertexList();
        if(shortestPath.size() == ROUTE_NOT_EXIST){
            System.out.println(NOT_EXIST_ROUTE);
            return false;
        }
        showStatusLength(path,shortestPath,startStation,endStation);
        return true;
    }

    private static void showStatusLength(DijkstraShortestPath path, List<String> shortestPath,
                                         String startStation, String endStation) {
        OutputView.bar();
        int length = (int)path.getPathWeight(startStation, endStation);
        OutputView.totalLength(length);
        int time = findTotalTime(shortestPath);
        OutputView.totalTime(time);
        OutputView.bar();
        for(String stationName : shortestPath){
            OutputView.status(stationName);
        }
        OutputView.space();
    }

    private static int findTotalTime(List<String> shortestPath) {
        int length = shortestPath.size();
        int total = 0;
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeWeight);
        for(int i=0;i<length-1;i++){
            total += (int)dijkstraShortestPath.getPathWeight(shortestPath.get(i), shortestPath.get(i+1));
        }
        return total;
    }

    private static int findTotalLength(List<String> shortestPath) {
        int length = shortestPath.size();
        int total = 0;
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(lengthWeight);
        for(int i=0;i<length-1;i++){
            total += (int)dijkstraShortestPath.getPathWeight(shortestPath.get(i), shortestPath.get(i+1));
        }
        return total;
    }
}
