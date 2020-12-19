package controller;

import subway.domain.*;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

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

    private final Scanner scanner;

    public SubwayPathChecker(Scanner scanner) {
        this.scanner = scanner;
        registerLine();
        registerStation();
        insertStationToLine();
        registerSection();
    }

    public void run() {
        MainMenuType mainMenuType;

        do {
            OutputView.printMainScreen();
            mainMenuType = InputView.inputFunctionNumber(scanner);
            executeFunction(mainMenuType);
        } while (mainMenuType != MainMenuType.QUIT);
    }

    private void executeFunction(MainMenuType mainMenuType) {
        if (mainMenuType == MainMenuType.PATH_CHECK) {
            pathCheck();
        }
    }

    private void pathCheck() {
        OutputView.printPathStandardSelectionScreen();
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

    private void registerSection() {
        SectionRepository.addSection(new Section(GYODAE_STATION, GANGNAM_STATION, 2, 3));
        SectionRepository.addSection(new Section(GANGNAM_STATION, YEOKSAM_STATION, 2, 3));

        SectionRepository.addSection(new Section(GYODAE_STATION, NAMBU_TERMINAL_STATION, 3, 2));
        SectionRepository.addSection(new Section(NAMBU_TERMINAL_STATION, YANGJAE_STATION, 6, 5));
        SectionRepository.addSection(new Section(YANGJAE_STATION, MAEBONG_STATION, 1, 1));

        SectionRepository.addSection(new Section(GANGNAM_STATION, YANGJAE_STATION, 2, 8));
        SectionRepository.addSection(new Section(YANGJAE_STATION, YANGJAE_CITIZEN_FOREST_STATION, 10, 3));
    }
}
