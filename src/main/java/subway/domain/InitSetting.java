package subway.domain;

import java.util.Arrays;
import java.util.List;

public class InitSetting {
    static {

    }
    public static void initSetting() {
        Line secondLine = new Line("2호선");
        Line thirdLine = new Line("3호선");
        Line sinLine = new Line("신분당선");

        Station gyoDaeStation = new Station("교대역");
        Station kangnamStation = new Station("강남역");
        Station yeoksamStation = new Station("역삼역");
        Station nambuTerminalStation = new Station("남부터미널역");
        Station yangjaeStation = new Station("양재역");
        Station maebongStation = new Station("매봉역");
        Station yangjaeForestStation = new Station("양재시민의숲역");

        LineRepository.addLine(secondLine);
        LineRepository.addLine(thirdLine);
        LineRepository.addLine(sinLine);

        StationRepository.addStation(gyoDaeStation);
        StationRepository.addStation(kangnamStation);
        StationRepository.addStation(yeoksamStation);
        StationRepository.addStation(nambuTerminalStation);
        StationRepository.addStation(yangjaeStation);
        StationRepository.addStation(maebongStation);
        StationRepository.addStation(yangjaeForestStation);

        SubwayPathRepository.addStation(gyoDaeStation);
        SubwayPathRepository.addStation(kangnamStation);
        SubwayPathRepository.addStation(yeoksamStation);

        SubwayPathRepository.addStation(gyoDaeStation);
        SubwayPathRepository.addStation(nambuTerminalStation);
        SubwayPathRepository.addStation(yangjaeStation);
        SubwayPathRepository.addStation(maebongStation);

        SubwayPathRepository.addStation(kangnamStation);
        SubwayPathRepository.addStation(yangjaeStation);
        SubwayPathRepository.addStation(yangjaeForestStation);

        addInitSecondLine(gyoDaeStation, kangnamStation, yeoksamStation);
        addInitThirdLine(gyoDaeStation, nambuTerminalStation, yangjaeStation, maebongStation);
        addInitSinLine(kangnamStation, yangjaeStation, yangjaeForestStation);
    }

    private static void addInitSecondLine(Station index0, Station index1, Station index2) {
        SubwayPathRepository.setPathWeight(index0, index1, 2);
        SubwayPathRepository.setPathWeight(index1, index2, 2);

        SubwayTimeRepository.setPathWeight(index0, index1, 3);
        SubwayTimeRepository.setPathWeight(index1, index2, 3);
    }

    private static void addInitThirdLine(Station index0, Station index1, Station index2, Station index3) {
        SubwayPathRepository.setPathWeight(index0, index1, 3);
        SubwayPathRepository.setPathWeight(index1, index2, 6);
        SubwayPathRepository.setPathWeight(index2, index3, 1);

        SubwayTimeRepository.setPathWeight(index0, index1, 2);
        SubwayTimeRepository.setPathWeight(index1, index2, 5);
        SubwayTimeRepository.setPathWeight(index2, index3, 1);
    }

    private static void addInitSinLine(Station index0, Station index1, Station index2) {
        SubwayPathRepository.setPathWeight(index0, index1, 2);
        SubwayPathRepository.setPathWeight(index1, index2, 10);

        SubwayTimeRepository.setPathWeight(index0, index1, 8);
        SubwayTimeRepository.setPathWeight(index1, index2, 3);
    }
}
