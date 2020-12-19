package subway.domain;

import subway.domain.graph.SubwayMap;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

import java.util.Arrays;

public class DummyData {
    public static void load() {
        stationLoad();
        lineLoad();
        subwayLoad();
    }

    private static void subwayLoad() {
        SubwayMap.setStations(
                Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"));
        SubwayMap.setEdgeDistance(Arrays.asList("교대역", "강남역"), 2, 3);
        SubwayMap.setEdgeDistance(Arrays.asList("강남역", "역삼역"), 2, 3);
        SubwayMap.setEdgeDistance(Arrays.asList("교대역", "남부터미널역"), 3, 2);
        SubwayMap.setEdgeDistance(Arrays.asList("남부터미널역", "양재역"), 6, 5);
        SubwayMap.setEdgeDistance(Arrays.asList("양재역", "매봉역"), 1, 1);
        SubwayMap.setEdgeDistance(Arrays.asList("강남역", "양재역"), 2, 8);
        SubwayMap.setEdgeDistance(Arrays.asList("양재역", "양재시민의숲역"), 10, 3);
    }

    private static void stationLoad() {
        StationRepository.addStation(Station.from("교대역"));
        StationRepository.addStation(Station.from("강남역"));
        StationRepository.addStation(Station.from("역삼역"));
        StationRepository.addStation(Station.from("남부터미널역"));
        StationRepository.addStation(Station.from("양재역"));
        StationRepository.addStation(Station.from("양재시민의숲역"));
        StationRepository.addStation(Station.from("매봉역"));
    }

    private static void lineLoad() {
        LineRepository.addLine(Line.from("2호선", Arrays.asList("교대역", "강남역", "역삼역")));
        LineRepository.addLine(Line.from("3호선", Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역")));
        LineRepository.addLine(Line.from("신분당선", Arrays.asList("강남역", "양재역", "양재시민의숲역")));
    }
}
