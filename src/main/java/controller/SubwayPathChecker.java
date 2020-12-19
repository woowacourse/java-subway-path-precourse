package controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SubwayPathChecker {
    private static final String LINE_NUMBER_TWO = "2호선";
    private static final String LINE_NUMBER_THREE = "3호선";
    private static final String LINE_NEW_BOONDANG = "신분당선";
    private static final String GYODAE_STATION = "교대역";
    private static final String GANGNAM_STATION = "강남역";
    private static final String YEOKSAM_STATION = "역삼역";
    private static final String NAMBU_TERMINAL_STATION = "남부터미널역";
    private static final String YANGJAE_STATION = "양재역";
    private static final String YANGJAE_CITIZEN_FOREST_STATION = "양재시민의숲역";
    private static final String MAEBONG_STATION = "매봉역";

    public SubwayPathChecker() {
        registerLine();
        registerStation();
        insertStationToLine();
    }

    public void run() {

    }

    private void registerLine() {
        LineRepository.addLine(new Line(LINE_NUMBER_TWO));
        LineRepository.addLine(new Line(LINE_NUMBER_THREE));
        LineRepository.addLine(new Line(LINE_NEW_BOONDANG));
    }

    private void registerStation() {
        StationRepository.addStation(new Station(GYODAE_STATION));
        StationRepository.addStation(new Station(GANGNAM_STATION));
        StationRepository.addStation(new Station(YEOKSAM_STATION));
        StationRepository.addStation(new Station(NAMBU_TERMINAL_STATION));
        StationRepository.addStation(new Station(YANGJAE_STATION));
        StationRepository.addStation(new Station(YANGJAE_CITIZEN_FOREST_STATION));
        StationRepository.addStation(new Station(MAEBONG_STATION));
    }

    private void insertStationToLine() {
        for (Line line : LineRepository.lines()) {
            if (line.getName().equals(LINE_NUMBER_TWO)) {
                setLineNumberTwo(line);
            }
            if (line.getName().equals(LINE_NUMBER_THREE)) {
                setLineNumberThree(line);
            }
            if (line.getName().equals(LINE_NEW_BOONDANG)) {
                setLineNewBoondang(line);
            }

        }
    }

    private void setLineNumberTwo(Line line) {
        line.addStationOnLine(new Station(GYODAE_STATION));
        line.addStationOnLine(new Station(GANGNAM_STATION));
        line.addStationOnLine(new Station(YEOKSAM_STATION));
    }

    private void setLineNumberThree(Line line) {
        line.addStationOnLine(new Station(GYODAE_STATION));
        line.addStationOnLine(new Station(NAMBU_TERMINAL_STATION));
        line.addStationOnLine(new Station(YANGJAE_STATION));
        line.addStationOnLine(new Station(MAEBONG_STATION));
    }

    private void setLineNewBoondang(Line line) {
        line.addStationOnLine(new Station(GANGNAM_STATION));
        line.addStationOnLine(new Station(YANGJAE_STATION));
        line.addStationOnLine(new Station(YANGJAE_CITIZEN_FOREST_STATION));
    }
}
