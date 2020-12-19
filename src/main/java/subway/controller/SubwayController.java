package subway.controller;

import org.jgrapht.graph.DefaultWeightedEdge;
import subway.domain.SubwayMap;
import subway.domain.SubwayPath;
import subway.repository.SubwayPathRepository;
import subway.service.LineService;
import subway.service.SubwayMapService;
import subway.service.StationService;
import subway.view.SubwayView;

import java.util.*;

public class SubwayController {
    private static final List<String> INITIAL_STATION_NAMES = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    private static final List<String> INITIAL_LINE_NAMES = Arrays.asList("2호선", "3호선", "신분당선");

    private SubwayView subwayView;

    public SubwayController(Scanner scanner) {
        subwayView = new SubwayView(scanner);
    }

    private void initSubwayInformation() {
        INITIAL_STATION_NAMES.stream()
                .forEach(stationName -> StationService.addStation(stationName));
        INITIAL_LINE_NAMES.stream()
                .forEach(lineName -> LineService.addLine(lineName));
        Arrays.stream(InitialPath.values())
                .forEach(path -> SubwayMapService.addMap(path.getLinName(), path.getPaths()));
    }

    public void run() {
        initSubwayInformation();
        redirectToMainScreen();
    }

    private String validateMainScreenFunction(String userInput) {
        while (!UserInputValidator.isValidMainScreenFunction(userInput)) {
            subwayView.printMessage(SubwayMessage.ERROR_SELECT_FUNCTION);
            subwayView.printMessage(SubwayMessage.SELECT_FUNCTION);
            userInput = validateMainScreenFunction(subwayView.userInput());
        }
        return userInput;
    }

    private void callMainScreenFunctionBy(String userInput) {
        if (Objects.equals(MainScreenFunction.PATH_SEARCH.getCode(), userInput)) {
            redirectToPathSearchScreen();
            return;
        }
        if (Objects.equals(MainScreenFunction.QUIT.getCode(), userInput)) {
            return;
        }
    }

    private void redirectToMainScreen() {
        String userInput = "";
        while (!Objects.equals(MainScreenFunction.QUIT.getCode(), userInput)) {
            subwayView.printMessage(SubwayMessage.MAIN_SCREEN);
            subwayView.printMessage(SubwayMessage.SELECT_FUNCTION);
            userInput = validateMainScreenFunction(subwayView.userInput());
            callMainScreenFunctionBy(userInput);
        }
    }

    private String validatePathSearchScreenFunction(String userInput) {
        while (!UserInputValidator.isValidPathSearchScreenFunction(userInput)) {
            subwayView.printMessage(SubwayMessage.ERROR_SELECT_FUNCTION);
            subwayView.printMessage(SubwayMessage.SELECT_FUNCTION);
            userInput = validateMainScreenFunction(subwayView.userInput());
        }
        return userInput;
    }

    private void callPathSearchScreenFunctionBy(String userInput) {
        if (Objects.equals(PathSearchScreenFunction.SHORTEST_PATH.getCode(), userInput)) {
            searchByShortestPath();
            return;
        }
        if (Objects.equals(PathSearchScreenFunction.MINIMUM_TIME.getCode(), userInput)) {
            searchByMinimumTime();
            return;
        }
        if (Objects.equals(PathSearchScreenFunction.BACK.getCode(), userInput)) {
            return;
        }
    }

    private void redirectToPathSearchScreen() {
        subwayView.printMessage(SubwayMessage.PATH_SEARCH_SCREEN);
        subwayView.printMessage(SubwayMessage.SELECT_FUNCTION);
        String userInput = validatePathSearchScreenFunction(subwayView.userInput());
        callPathSearchScreenFunctionBy(userInput);
    }

    private boolean isDuplicateStation(String departureStation, String arrivalStation) {
        return Objects.equals(departureStation, arrivalStation);
    }

    private boolean isDisconnectedPath(List<String> path) {
        return Objects.equals(path, Collections.emptyList());
    }

    private String inputDepartureStation() {
        subwayView.printMessage(SubwayMessage.ENTER_DEPARTURE_STATION);
        String userInput = subwayView.userInput();
        return userInput;
    }

    private String inputArrivalStation() {
        subwayView.printMessage(SubwayMessage.ENTER_ARRIVAL_STATION);
        String userInput = subwayView.userInput();
        return userInput;
    }

    private void validatedDuplicateStationForShortestPath(String departureStation, String arrivalStation) {
        if (isDuplicateStation(departureStation, arrivalStation)) {
            subwayView.printMessage(SubwayMessage.ERROR_DUPLICATE_STATION);
            searchByShortestPath();
        }
    }

    private void validatedDisconnectedPathForShortestPath(List<String> shortestPath) {
        if (isDisconnectedPath(shortestPath)) {
            subwayView.printMessage(SubwayMessage.ERROR_DISCONNECTED_PATH);
            searchByShortestPath();
        }
    }

    private void validatedDuplicateStationForMinimumTime(String departureStation, String arrivalStation) {
        if (isDuplicateStation(departureStation, arrivalStation)) {
            subwayView.printMessage(SubwayMessage.ERROR_DUPLICATE_STATION);
            searchByMinimumTime();
        }
    }

    private void validatedDisconnectedPathForMinimumTime(List<String> minimumTime) {
        if (isDisconnectedPath(minimumTime)) {
            subwayView.printMessage(SubwayMessage.ERROR_DISCONNECTED_PATH);
            searchByMinimumTime();
        }
    }

    private void searchByShortestPath() {
        String departureStation = inputDepartureStation();
        String arrivalStation = inputArrivalStation();
        validatedDuplicateStationForShortestPath(departureStation, arrivalStation);
        List<String> shortestPath = SubwayMap.getShortestPath(departureStation, arrivalStation);
        validatedDisconnectedPathForShortestPath(shortestPath);

//        int sumWeight = 0;
//        for (int i = 1; i < shortestPath.size(); i++) {
//            DefaultWeightedEdge edge = SubwayMap.getShortestPathGraph().getEdge(shortestPath.get(i - 1), shortestPath.get(i));
//            sumWeight += SubwayMap.getShortestPathGraph().getEdgeWeight(edge);
//        }

        subwayView.printResult(shortestPath);
    }

    private void searchByMinimumTime() {
        String departureStation = inputDepartureStation();
        String arrivalStation = inputArrivalStation();
        validatedDuplicateStationForMinimumTime(departureStation, arrivalStation);
        List<String> minimumTime = SubwayMap.getMinimumTime(departureStation, arrivalStation);
        validatedDisconnectedPathForMinimumTime(minimumTime);
        subwayView.printResult(minimumTime);
    }
}
