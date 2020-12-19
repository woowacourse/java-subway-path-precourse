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

    public static void init() {
        List<String> stations = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        List<String> lineAndSection = Arrays.asList(
                "2호선/교대역/강남역/역삼역",
                "3호선/교대역/남부터미널역/양재역/매봉역",
                "신분당선/강남역/양재역/양재시민의숲역"
        );


        /**
         *    - 2호선: 교대역 - ( 2km / 3분 ) - 강남역 - ( 2km / 3분 ) - 역삼역
         *    - 3호선: 교대역 - ( 3km / 2분 ) - 남부터미널역 - ( 6km / 5분 ) - 양재역 - ( 1km / 1분 ) - 매봉역
         *    - 신분당선: 강남역 - ( 2km / 8분 ) - 양재역 - ( 10km / 3분 ) - 양재시민의숲역
         */
        makeStations(stations);

//        graph.setEdgeWeight(graph.addEdge("v1", "v2"), 2);
//        graph.setEdgeWeight(graph.addEdge("v2", "v3"), 2);
//        graph.setEdgeWeight(graph.addEdge("v1", "v3"), 100);

//        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
//        List<String> shortestPath = dijkstraShortestPath.getPath("v2", "v1").getVertexList();

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

    private static void makeWeightedGraph(List<String> stations, List<String> sectionInfo) {
        WeightedMultigraph<String, DefaultWeightedEdge> subwayWeightedGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
        stations.stream().forEach(subwayWeightedGraph::addVertex);
    }

}
