package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.List;

public class InitializationService {
    public static final List<String> stationNames = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    public static final List<String> lineNames = Arrays.asList("2호선", "3호선", "신분당선");

    private InitializationService() {
    }

    public static void init() {
        addStations();
        addLineTwo(lineNames.get(0));
        addLineThree(lineNames.get(1));
        addLineSinbundang(lineNames.get(2));
    }

    private static void addStations() {
        stationNames.forEach(stationName -> StationRepository.addStation(new Station(stationName)));
    }

    private static void addLineTwo(String lineName) {
        Line lineTwo = new Line(lineName);
        lineTwo.addStation(StationRepository.findStationByName(stationNames.get(0)));
        lineTwo.addStation(StationRepository.findStationByName(stationNames.get(1)));
        lineTwo.addStation(StationRepository.findStationByName(stationNames.get(2)));

        lineTwo.addPathInformation(StationRepository.findStationByName(stationNames.get(0)), StationRepository.findStationByName(stationNames.get(1)), 2, 3);
        lineTwo.addPathInformation(StationRepository.findStationByName(stationNames.get(1)), StationRepository.findStationByName(stationNames.get(2)), 2, 3);
        LineRepository.addLine(lineTwo);
    }

    private static void addLineThree(String lineName) {
        Line lineThree = new Line(lineName);
        lineThree.addStation(StationRepository.findStationByName(stationNames.get(0)));
        lineThree.addStation(StationRepository.findStationByName(stationNames.get(3)));
        lineThree.addStation(StationRepository.findStationByName(stationNames.get(4)));
        lineThree.addStation(StationRepository.findStationByName(stationNames.get(6)));

        lineThree.addPathInformation(StationRepository.findStationByName(stationNames.get(0)), StationRepository.findStationByName(stationNames.get(3)), 3, 2);
        lineThree.addPathInformation(StationRepository.findStationByName(stationNames.get(3)), StationRepository.findStationByName(stationNames.get(4)), 6, 5);
        lineThree.addPathInformation(StationRepository.findStationByName(stationNames.get(4)), StationRepository.findStationByName(stationNames.get(6)), 1, 1);
        LineRepository.addLine(lineThree);
    }

    private static void addLineSinbundang(String lineName) {
        Line lineFour = new Line(lineName);
        lineFour.addStation(StationRepository.findStationByName(stationNames.get(1)));
        lineFour.addStation(StationRepository.findStationByName(stationNames.get(4)));
        lineFour.addStation(StationRepository.findStationByName(stationNames.get(5)));

        lineFour.addPathInformation(StationRepository.findStationByName(stationNames.get(1)), StationRepository.findStationByName(stationNames.get(4)), 2, 8);
        lineFour.addPathInformation(StationRepository.findStationByName(stationNames.get(4)), StationRepository.findStationByName(stationNames.get(5)), 10, 3);
        LineRepository.addLine(lineFour);
    }
}

