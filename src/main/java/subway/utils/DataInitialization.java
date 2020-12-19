package subway.utils;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class DataInitialization {
    public static WeightedMultigraph<Station, DefaultWeightedEdge> graphByDistance = new WeightedMultigraph(DefaultWeightedEdge.class);
    public static WeightedMultigraph<Station, DefaultWeightedEdge> graphByTime = new WeightedMultigraph(DefaultWeightedEdge.class);


    private static String[] stationNameList = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "매봉역", "양재시민의숲역"};
    private static String[] lineNameList = {"2호선", "3호선", "신분당선"};
    // 모든 역을 역 레포지토리에 입력
    public DataInitialization() {
        addAllStationsToRepository();
        addAllLinesToRepository();
        enrollStationsToLine();
        addAllStationsToGraph();
        addAllEdgesWithWeight();
    }


    private static void addAllStationsToRepository() {
        for (String stationName : stationNameList) {
            StationRepository.addStation(new Station(stationName));
        }
    }

    private static void addAllLinesToRepository() {
        for (String lineName : lineNameList) {
            LineRepository.addLine(new Line(lineName));
        }
    }

    private static void enrollStationsToLine() {

    }

    private static void addAllEdgesWithWeight() {
        addAllEdgesWithWeightByDistance();
        addAllEdgesWithWeightByTime();
    }

    private void addAllStationsToGraph() {
        for (Station station : StationRepository.stations()) {
            graphByDistance.addVertex(station);
            graphByTime.addVertex(station);
        }
    }

    private static void addAllEdgesWithWeightByDistance() {
        graphByDistance.setEdgeWeight(graphByDistance.addEdge(getStation("교대역"), getStation("강남역")), 2);
        graphByDistance.setEdgeWeight(graphByDistance.addEdge(getStation("강남역"), getStation("역삼역")), 2);
        graphByDistance.setEdgeWeight(graphByDistance.addEdge(getStation("교대역"), getStation("남부터미널역")), 3);
        graphByDistance.setEdgeWeight(graphByDistance.addEdge(getStation("남부터미널역"), getStation("양재역")), 6);
        graphByDistance.setEdgeWeight(graphByDistance.addEdge(getStation("양재역"), getStation("매봉역")), 1);
        graphByDistance.setEdgeWeight(graphByDistance.addEdge(getStation("강남역"), getStation("양재역")), 2);
        graphByDistance.setEdgeWeight(graphByDistance.addEdge(getStation("양재역"), getStation("양재시민의숲역")), 10);
    }

    private static void addAllEdgesWithWeightByTime() {
        graphByTime.setEdgeWeight(graphByTime.addEdge(getStation("교대역"), getStation("강남역")), 3);
        graphByTime.setEdgeWeight(graphByTime.addEdge(getStation("강남역"), getStation("역삼역")), 3);
        graphByTime.setEdgeWeight(graphByTime.addEdge(getStation("교대역"), getStation("남부터미널역")), 2);
        graphByTime.setEdgeWeight(graphByTime.addEdge(getStation("남부터미널역"), getStation("양재역")), 5);
        graphByTime.setEdgeWeight(graphByTime.addEdge(getStation("양재역"), getStation("매봉역")), 1);
        graphByTime.setEdgeWeight(graphByTime.addEdge(getStation("강남역"), getStation("양재역")), 8);
        graphByTime.setEdgeWeight(graphByTime.addEdge(getStation("양재역"), getStation("양재시민의숲역")), 3);
    }

    private static Station getStation(String stationName) {
        return StationRepository.getStation(stationName);
    }

}
