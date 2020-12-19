package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final String[] LINES = {"2호선", "3호선", "신분당선"};
    private static final String[][] LINE_STATIONS = {{"교대역","강남역","역삼역"},{"교대역","남부터미널역","양재역","매봉역"},
            {"강남역","양재역","양재시민의숲역"}};
    private static final WeightedMultigraph<String, DefaultWeightedEdge> timeWeight
            = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static final WeightedMultigraph<String, DefaultWeightedEdge> lengthWeight
            = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static int INDEX = 0;

    private static final List<Line> lines = new ArrayList<>();

    static{
        for(String lineName : LINES){
            Line line = new Line(lineName);
            for(String stationName : LINE_STATIONS[INDEX]){
                line.addStation(new Station(stationName));
            }
            lines.add(line);
            INDEX++;
        }
    }

    static{
        lengthWeight.addVertex("교대역");
        lengthWeight.addVertex("강남역");
        lengthWeight.addVertex("역삼역");
        lengthWeight.addVertex("남부터미널역");
        lengthWeight.addVertex("양재역");
        lengthWeight.addVertex("매봉역");
        lengthWeight.addVertex("양재시민의숲역");

        lengthWeight.setEdgeWeight(timeWeight.addEdge("교대역","강남역"), 2);
        lengthWeight.setEdgeWeight(timeWeight.addEdge("강남역","역삼역"), 2);
        lengthWeight.setEdgeWeight(timeWeight.addEdge("교대역","남부터미널역"), 3);
        lengthWeight.setEdgeWeight(timeWeight.addEdge("남부터미널역","양재역"), 6);
        lengthWeight.setEdgeWeight(timeWeight.addEdge("양재역","매봉역"), 1);
        lengthWeight.setEdgeWeight(timeWeight.addEdge("강남역","양재역"), 2);
        lengthWeight.setEdgeWeight(timeWeight.addEdge("양재역","양재시민의숲역"), 10);
    }
    static{
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

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }
}
