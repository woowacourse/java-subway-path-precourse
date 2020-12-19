package subway;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SubwayInitializer {
    private static final String SLASH = "/";
    private static final int LINE_NAME = 0;
    private static final int FIRST = 1;
    private static final String DISTANCE = "거리";
    private static List<String> stations;

    public static void init() {
        stations = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        List<String> lineAndSection = Arrays.asList(
                "2호선/교대역/강남역/역삼역",
                "3호선/교대역/남부터미널역/양재역/매봉역",
                "신분당선/강남역/양재역/양재시민의숲역"
        );

        makeStations(stations);
        separateLineBySlash(lineAndSection);
    }

    private static void makeStations(List<String> stations) {
        stations.stream().map(StationFactory::createStation).forEach(StationRepository::addStation);
    }

    private static void separateLineBySlash(List<String> lineAndSection) {
        lineAndSection.stream().map(o -> Arrays.asList(o.split(SLASH))).forEach(SubwayInitializer::makeLines);
    }

    private static void makeLines(List<String> lineAndSection) {
        String lineName = lineAndSection.get(LINE_NAME);

        LineRepository.addLine(new Line(
                lineName,
                lineAndSection
                        .subList(FIRST, lineAndSection.size())
                        .stream()
                        .map(StationFactory::createStation)
                        .collect(Collectors.toList())
        ));
    }

    public static WeightedMultigraph<String, DefaultWeightedEdge> initGraph(String type) {
        if (type.equals(DISTANCE)) {
            return makeDistanceWeightedGraph();
        }
        return makeTimeWeightedGraph();
    }

    private static WeightedMultigraph<String, DefaultWeightedEdge> makeDistanceWeightedGraph() {
        WeightedMultigraph<String, DefaultWeightedEdge> distanceWeightedGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
        stations.stream().forEach(distanceWeightedGraph::addVertex);

        distanceWeightedGraph.setEdgeWeight(distanceWeightedGraph.addEdge("교대역", "강남역"), 2);
        distanceWeightedGraph.setEdgeWeight(distanceWeightedGraph.addEdge("강남역", "역삼역"), 2);
        distanceWeightedGraph.setEdgeWeight(distanceWeightedGraph.addEdge("교대역", "남부터미널역"), 3);
        distanceWeightedGraph.setEdgeWeight(distanceWeightedGraph.addEdge("남부터미널역", "양재역"), 6);
        distanceWeightedGraph.setEdgeWeight(distanceWeightedGraph.addEdge("양재역", "매봉역"), 1);
        distanceWeightedGraph.setEdgeWeight(distanceWeightedGraph.addEdge("강남역", "양재역"), 2);
        distanceWeightedGraph.setEdgeWeight(distanceWeightedGraph.addEdge("양재역", "양재시민의숲역"), 10);

        return distanceWeightedGraph;
    }

    private static WeightedMultigraph<String, DefaultWeightedEdge> makeTimeWeightedGraph() {
        WeightedMultigraph<String, DefaultWeightedEdge> timeWeightedGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
        stations.stream().forEach(timeWeightedGraph::addVertex);

        timeWeightedGraph.setEdgeWeight(timeWeightedGraph.addEdge("교대역", "강남역"), 3);
        timeWeightedGraph.setEdgeWeight(timeWeightedGraph.addEdge("강남역", "역삼역"), 3);
        timeWeightedGraph.setEdgeWeight(timeWeightedGraph.addEdge("교대역", "남부터미널역"), 2);
        timeWeightedGraph.setEdgeWeight(timeWeightedGraph.addEdge("남부터미널역", "양재역"), 5);
        timeWeightedGraph.setEdgeWeight(timeWeightedGraph.addEdge("양재역", "매봉역"), 1);
        timeWeightedGraph.setEdgeWeight(timeWeightedGraph.addEdge("강남역", "양재역"), 8);
        timeWeightedGraph.setEdgeWeight(timeWeightedGraph.addEdge("양재역", "양재시민의숲역"), 3);

        return timeWeightedGraph;
    }
}
