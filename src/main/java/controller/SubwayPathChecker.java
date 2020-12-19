package controller;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;
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
    private static final String SAME_STATION_NAME_ERROR = "[ERROR] 출발역과 도착역이 동일합니다.";

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
            executeMainMenuFunction(mainMenuType);
        } while (mainMenuType != MainMenuType.QUIT);
    }

    private void executeMainMenuFunction(MainMenuType mainMenuType) {
        if (mainMenuType == MainMenuType.PATH_CHECK) {
            pathCheck();
        }
    }

    private void pathCheck() {
        PathStandardType pathStandardType;

        OutputView.printPathStandardSelectionScreen();
        pathStandardType = InputView.inputPathStandardFunctionNumber(scanner);

        if (pathStandardType == PathStandardType.SHORTEST_DISTANCE) {
            searchShortestDistancePath();
        }

        if (pathStandardType == PathStandardType.SHORTEST_TIME) {
            searchShortestTimePath();
        }
    }

    private void searchShortestDistancePath() {
        Station departureStation = null;
        Station arrivalStation = null;

        try {
            departureStation = InputView.inputDepartureStation(scanner);
            arrivalStation = InputView.inputArrivalStation(scanner);
            hasStationNameDuplication(departureStation, arrivalStation);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            pathCheck();
        }
        getDijkstraShortestDistancePath(departureStation.getName(), arrivalStation.getName());
    }

    private void getDijkstraShortestDistancePath(String departureStationName, String arrivalStationName) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(SectionRepository.distanceWeightedGraph());
        double shortestDistance = dijkstraShortestPath.getPath(departureStationName, arrivalStationName).getWeight();
        List shortestDistancePath = dijkstraShortestPath.getPath(departureStationName, arrivalStationName).getVertexList();
        OutputView.printShortestDistancePathResult(shortestDistance, shortestDistancePath);
    }

    private void searchShortestTimePath() {
        Station departureStation = null;
        Station arrivalStation = null;

        try {
            departureStation = InputView.inputDepartureStation(scanner);
            arrivalStation = InputView.inputArrivalStation(scanner);
            hasStationNameDuplication(departureStation, arrivalStation);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            pathCheck();
        }
        getDijkstraShortestTimePath(departureStation.getName(), arrivalStation.getName());
    }

    private void getDijkstraShortestTimePath(String departureStationName, String arrivalStationName) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(SectionRepository.timeWeightedGraph());
        double shortestTime = dijkstraShortestPath.getPath(departureStationName, arrivalStationName).getWeight();
        List shortestTimePath = dijkstraShortestPath.getPath(departureStationName, arrivalStationName).getVertexList();
        OutputView.printShortestTimePathResult(shortestTime, shortestTimePath);
    }

    private void hasStationNameDuplication(Station departureStation, Station arrivalStation) {
        if (departureStation.equals(arrivalStation)) {
            throw new IllegalArgumentException(SAME_STATION_NAME_ERROR);
        }
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
        SectionRepository.addSection(new Section(new Station(GYODAE_STATION), new Station(GANGNAM_STATION), 2, 3));
        SectionRepository.addSection(new Section(new Station(GANGNAM_STATION), new Station(YEOKSAM_STATION), 2, 3));

        SectionRepository.addSection(new Section(new Station(GYODAE_STATION), new Station(NAMBU_TERMINAL_STATION), 3, 2));
        SectionRepository.addSection(new Section(new Station(NAMBU_TERMINAL_STATION), new Station(YANGJAE_STATION), 6, 5));
        SectionRepository.addSection(new Section(new Station(YANGJAE_STATION), new Station(MAEBONG_STATION), 1, 1));

        SectionRepository.addSection(new Section(new Station(GANGNAM_STATION), new Station(YANGJAE_STATION), 2, 8));
        SectionRepository.addSection(new Section(new Station(YANGJAE_STATION), new Station(YANGJAE_CITIZEN_FOREST_STATION), 10, 3));
    }
}
