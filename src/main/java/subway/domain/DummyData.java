package subway.domain;

import subway.domain.graph.DistanceGraph;
import subway.domain.graph.DistanceGraphRepository;
import subway.domain.graph.TimeGraph;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

import java.util.Arrays;

public class DummyData {
    public static void load() {
        stationLoad();
        lineLoad();
        distanceGraphLoad();
        timeGraphLoad();
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

    private static void distanceGraphLoad() {
        DistanceGraph lineTwo = DistanceGraph.valueOf("2호선", Arrays.asList("교대역", "강남역", "역삼역"));
        lineTwo.setEge("교대역", "강남역", 3);
        lineTwo.setEge("강남역", "역삼역", 3);
        DistanceGraph lineThree = DistanceGraph.valueOf("3호선", Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역"));
        lineThree.setEge("교대역", "남부터미널역", 2);
        lineThree.setEge("남부터미널역", "양재역", 5);
        lineThree.setEge("양재역", "매봉역", 1);
        DistanceGraph BunDangLine = DistanceGraph.valueOf("신분당선", Arrays.asList("강남역", "양재역", "양재시민의숲역"));
        BunDangLine.setEge("강남역", "양재역", 8);
        BunDangLine.setEge("양재역", "양재시민의숲역", 3);
        DistanceGraphRepository.add(lineTwo);
        DistanceGraphRepository.add(lineThree);
        DistanceGraphRepository.add(BunDangLine);
    }

    private static void timeGraphLoad() {
        TimeGraph lineTwo = TimeGraph.valueOf("2호선", Arrays.asList("교대역", "강남역", "역삼역"));
        lineTwo.setEge("교대역", "강남역", 3);
        lineTwo.setEge("강남역", "역삼역", 3);
        TimeGraph lineThree = TimeGraph.valueOf("3호선", Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역"));
        lineThree.setEge("교대역", "남부터미널역", 2);
        lineThree.setEge("남부터미널역", "양재역", 5);
        lineThree.setEge("양재역", "매봉역", 1);
        TimeGraph BunDangLine = TimeGraph.valueOf("신분당선", Arrays.asList("강남역", "양재역", "양재시민의숲역"));
        BunDangLine.setEge("강남역", "양재역", 8);
        BunDangLine.setEge("양재역", "양재시민의숲역", 3);
    }
}
