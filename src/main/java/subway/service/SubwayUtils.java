package subway.service;

import java.util.List;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import subway.domain.Distances;
import subway.domain.ElapsedTimes;
import subway.domain.Line;
import subway.domain.LineDirection;
import subway.domain.LineRepository;
import subway.domain.ShortenPathDTO;
import subway.domain.StationRepository;

public class SubwayUtils {

    public static final String SECOND_LINE = "2호선";
    public static final String THIRD_LINE = "3호선";
    public static final String SINBUNDANG_LINE = "신분당선";
    public static final String KYODAE_STATION = "교대역";
    public static final String KANGNAME_STATION = "강남역";
    public static final String YEOKSAM_STATION = "역삼역";
    public static final String NAMBU_TERMINAL_STATION = "남부터미널역";
    public static final String YANGJAE_STATION = "양재역";
    public static final String MAEBONG_STATION = "매봉역";
    public static final String YANGJAE_CITIZEN_STATION = "양재시민의숲역";

    private static final WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph =
            new WeightedMultigraph(DefaultWeightedEdge.class);

    private static final WeightedMultigraph<String, DefaultWeightedEdge> timeGraph =
            new WeightedMultigraph(DefaultWeightedEdge.class);

    private SubwayUtils() {}

    public static void initGraph() {
        initDistanceGraph();
        initTimeGraph();
    }

    private static void initDistanceGraph() {
        distanceGraph.addVertex(KYODAE_STATION);
        distanceGraph.addVertex(KANGNAME_STATION);
        distanceGraph.addVertex(YEOKSAM_STATION);
        distanceGraph.addVertex(NAMBU_TERMINAL_STATION);
        distanceGraph.addVertex(YANGJAE_STATION);
        distanceGraph.addVertex(MAEBONG_STATION);
        distanceGraph.addVertex(YANGJAE_CITIZEN_STATION);

        distanceGraph.setEdgeWeight(distanceGraph.addEdge(KYODAE_STATION, KANGNAME_STATION), 2);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(KANGNAME_STATION, YEOKSAM_STATION), 2);

        distanceGraph.setEdgeWeight(distanceGraph.addEdge(KYODAE_STATION, NAMBU_TERMINAL_STATION), 3);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(NAMBU_TERMINAL_STATION, YANGJAE_STATION), 6);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(YANGJAE_STATION, MAEBONG_STATION), 1);

        distanceGraph.setEdgeWeight(distanceGraph.addEdge(KANGNAME_STATION, YANGJAE_STATION), 2);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(YANGJAE_STATION, YANGJAE_CITIZEN_STATION), 10);
    }

    private static void initTimeGraph() {
        timeGraph.addVertex(KYODAE_STATION);
        timeGraph.addVertex(KANGNAME_STATION);
        timeGraph.addVertex(YEOKSAM_STATION);
        timeGraph.addVertex(NAMBU_TERMINAL_STATION);
        timeGraph.addVertex(YANGJAE_STATION);
        timeGraph.addVertex(MAEBONG_STATION);
        timeGraph.addVertex(YANGJAE_CITIZEN_STATION);

        timeGraph.setEdgeWeight(timeGraph.addEdge(KYODAE_STATION, KANGNAME_STATION), 3);
        timeGraph.setEdgeWeight(timeGraph.addEdge(KANGNAME_STATION, YEOKSAM_STATION), 3);
        timeGraph.setEdgeWeight(timeGraph.addEdge(KYODAE_STATION, NAMBU_TERMINAL_STATION), 2);
        timeGraph.setEdgeWeight(timeGraph.addEdge(NAMBU_TERMINAL_STATION, YANGJAE_STATION), 5);
        timeGraph.setEdgeWeight(timeGraph.addEdge(YANGJAE_STATION, MAEBONG_STATION), 1);
        timeGraph.setEdgeWeight(timeGraph.addEdge(KANGNAME_STATION, YANGJAE_STATION), 8);
        timeGraph.setEdgeWeight(timeGraph.addEdge(YANGJAE_STATION, YANGJAE_CITIZEN_STATION), 3);
    }

    public static LineRepository initialize() {
        initGraph();

        StationRepository secondLineRepository = new StationRepository().addStations(KYODAE_STATION,
                KANGNAME_STATION, YEOKSAM_STATION);
        StationRepository thirdLineRepository = new StationRepository().addStations(KYODAE_STATION,
                NAMBU_TERMINAL_STATION, YANGJAE_STATION, MAEBONG_STATION);
        StationRepository sinbundangLineRepository =
                new StationRepository().addStations(KANGNAME_STATION,
                        YANGJAE_STATION, YANGJAE_CITIZEN_STATION);

        Distances secondLineDistances = new Distances(2, 2);
        Distances thirdLineDistances = new Distances(3, 6, 1);
        Distances sinbundangLineDistances = new Distances(2, 10);

        ElapsedTimes secondLineTimes = new ElapsedTimes(3, 3);
        ElapsedTimes thirdLineTimes = new ElapsedTimes(2, 5, 1);
        ElapsedTimes sinbundangLineTimes = new ElapsedTimes(8, 3);

        LineDirection secondLineDirection =
                new LineDirection(secondLineRepository, secondLineDistances, secondLineTimes);
        LineDirection thirdLineDirection =
                new LineDirection(thirdLineRepository, thirdLineDistances, thirdLineTimes);
        LineDirection sinbundangLineDirection =
                new LineDirection(sinbundangLineRepository, sinbundangLineDistances,
                        sinbundangLineTimes);

        Line secondLine = new Line(SECOND_LINE, secondLineDirection);
        Line thirdLine = new Line(THIRD_LINE, thirdLineDirection);
        Line sinbundangLine = new Line(SINBUNDANG_LINE, sinbundangLineDirection);


        return new LineRepository().addLines(secondLine, thirdLine, sinbundangLine);
    }

    public static ShortenPathDTO findShortenPathByDistance(String startStation, String endStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);

        List<String> stationNames = dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
        int distance = (int) dijkstraShortestPath.getPathWeight(startStation, endStation);

        return new ShortenPathDTO(distance, 0, stationNames);
    }

    public static ShortenPathDTO findShortenPathByTime(String startStation, String endStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeGraph);

        List<String> stationNames = dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
        int times = (int) dijkstraShortestPath.getPathWeight(startStation, endStation);

        return new ShortenPathDTO(0, times, stationNames);
    }
}
