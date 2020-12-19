package subway.controller;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.List;

public class Initializer {

    public static void stationInitialize() {
        for (String stationName : Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "매봉역", "양재시민의숲역")) {
            StationRepository.addStation(new Station(stationName));
        }
    }

    public static void lineInitialize() {
        Line line2 = new Line("2호선");
        for (String stationName : Arrays.asList("강남역", "교대역", "역삼역")) {
            line2.addStation(stationName);
        }
        LineRepository.addLine(line2);
        Line line3 = new Line("3호선");
        for (String stationName : Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역")) {
            line3.addStation(stationName);
        }
        LineRepository.addLine(line3);
        Line lineSinbundang = new Line("신분당선");
        for (String stationName : Arrays.asList("강남역", "양재역", "양재시민의숲역")) {
            lineSinbundang.addStation(stationName);
        }
        LineRepository.addLine(lineSinbundang);
    }



}
