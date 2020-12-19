package subway;

import subway.domain.*;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
    }

    public static void init() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));

        LineRepository.addLine(new Line("2호선", StationRepository.getStationByName("교대역"),
                StationRepository.getStationByName("역삼역"), new Path(2, 3)));
        Line lineSecond = LineRepository.getLineByName("2호선");
        lineSecond.addStation(StationRepository.getStationByName("강남역"), 2);
        lineSecond.addPath(new Path(2,3), 2);

        LineRepository.addLine(new Line("3호선", StationRepository.getStationByName("교대역"),
                StationRepository.getStationByName("매봉역"), new Path(3, 2)));
        Line lineThird = LineRepository.getLineByName("3호선");
        lineThird.addStation(StationRepository.getStationByName("남부터미널역"), 2);
        lineThird.addPath(new Path(6,5), 2);
        lineThird.addStation(StationRepository.getStationByName("양재역"), 3);
        lineThird.addPath(new Path(1,1), 3);

        LineRepository.addLine(new Line("신분당선", StationRepository.getStationByName("강남역"),
                StationRepository.getStationByName("양재시민의숲역"), new Path(2, 8)));
        Line lineNew = LineRepository.getLineByName("신분당선");
        lineNew.addStation(StationRepository.getStationByName("양재역"), 2);
        lineNew.addPath(new Path(2,8), 2);
    }
}
