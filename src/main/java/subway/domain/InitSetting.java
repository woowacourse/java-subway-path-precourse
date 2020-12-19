package subway.domain;

import java.util.Arrays;
import java.util.List;

public class InitSetting {

    public static void initSetting() {
        List<Line> lines = makeLines();
        List<Station> stations = makeStations();

        addLines(lines);
        addStations(stations);

        addInitSecondLine(stations);
        addInitThirdLine(stations);
        addInitSinLine(stations);
    }

    private static List<Station> makeStations() {
        Station gyoDaeStation = new Station("교대역");
        Station kangnamStation = new Station("강남역");
        Station yeoksamStation = new Station("역삼역");
        Station nambuTerminalStation = new Station("남부터미널역");
        Station yangjaeStation = new Station("양재역");
        Station maebongStation = new Station("매봉역");
        Station yangjaeForestStation = new Station("양재시민의숲역");

        return Arrays.asList(gyoDaeStation, kangnamStation, yeoksamStation, nambuTerminalStation, yangjaeStation, maebongStation, yangjaeForestStation);
    }

    private static List<Line> makeLines() {
        Line secondLine = new Line("2호선");
        Line thirdLine = new Line("3호선");
        Line sinLine = new Line("신분당선");
        return Arrays.asList(secondLine, thirdLine, sinLine);
    }

    private static void addStations(List<Station> stations) {
        for (Station station : stations) {
            StationRepository.addStation(station);
            SubwayLengthRepository.addStation(station);
            SubwayTimeRepository.addStation(station);
        }
    }

    private static void addLines(List<Line> lines) {
        for (Line line : lines) {
            LineRepository.addLine(line);
        }
    }

    private static void addInitSecondLine(List<Station> stations) {

        SubwayLengthRepository.setPathWeightWithTwoStation(stations.get(0), stations.get(1), 2);
        SubwayLengthRepository.setPathWeightWithTwoStation(stations.get(1), stations.get(2), 2);

        SubwayTimeRepository.setPathWeightWithTwoStation(stations.get(0), stations.get(1), 3);
        SubwayTimeRepository.setPathWeightWithTwoStation(stations.get(1), stations.get(2), 3);
    }

    private static void addInitThirdLine(List<Station> stations) {
        SubwayLengthRepository.setPathWeightWithTwoStation(stations.get(0), stations.get(3), 3);
        SubwayLengthRepository.setPathWeightWithTwoStation(stations.get(3), stations.get(4), 6);
        SubwayLengthRepository.setPathWeightWithTwoStation(stations.get(4), stations.get(5), 1);

        SubwayTimeRepository.setPathWeightWithTwoStation(stations.get(0), stations.get(3), 2);
        SubwayTimeRepository.setPathWeightWithTwoStation(stations.get(3), stations.get(4), 5);
        SubwayTimeRepository.setPathWeightWithTwoStation(stations.get(4), stations.get(5), 1);
    }

    private static void addInitSinLine(List<Station> stations) {
        SubwayLengthRepository.setPathWeightWithTwoStation(stations.get(1), stations.get(4), 2);
        SubwayLengthRepository.setPathWeightWithTwoStation(stations.get(4), stations.get(6), 10);

        SubwayTimeRepository.setPathWeightWithTwoStation(stations.get(1), stations.get(4), 8);
        SubwayTimeRepository.setPathWeightWithTwoStation(stations.get(4), stations.get(6), 3);
    }
}
