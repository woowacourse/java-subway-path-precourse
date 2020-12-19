package subway.controller.functioncontroller;

import subway.domain.DistanceGraphRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.validator.RouteFindValidation;
import subway.view.InputView;
import subway.view.routefindoutput.RouteFindInformationView;
import subway.view.routefindoutput.RouteFindOutputView;

import java.util.List;
import java.util.Scanner;

public class RouteFindController extends FunctionController {
    private static final String SHORTEST_DISTANCE = "1";
    private static final String SHORTEST_TIME = "2";
    private static final String BACK = "B";
    private static final String INVALID_INPUT = "";

    public static void start(Scanner scanner) {
        runRouteFindController(scanner);
    }

    private static void runRouteFindController(Scanner scanner) {
        String userChoice = "";
        boolean routeFindControllerDone = false;
        while (!routeFindControllerDone) {
            RouteFindOutputView.printOption();
            userChoice = getUserChoice(scanner);
            routeFindControllerDone = startChosenRouteFindFunction(userChoice, scanner);
        }
    }

    private static String getUserChoice(Scanner scanner) {
        String userChoice = null;
        boolean validChoice = false;
        while (!validChoice) {
            RouteFindOutputView.printOptionInstruction();
            userChoice = InputView.getInput(scanner);
            validChoice = RouteFindValidation.checkControllerInput(userChoice);
        }
        return userChoice;
    }

    private static boolean startChosenRouteFindFunction(String userChoice, Scanner scanner) {
        if (userChoice.equals(SHORTEST_DISTANCE)) {
            return findShortestDistance(scanner);
        }
        if (userChoice.equals(SHORTEST_TIME)) {
            return findShortestTime(scanner);
        }
        if (userChoice.equals(BACK)) {
            return true;
        }
        return false;
    }

    private static boolean findShortestDistance(Scanner scanner) {
        String userInputStartStation = getUserInputStartStation(scanner);
        if(userInputStartStation.equals(INVALID_INPUT)) {
            return false;
        }
        String userInputEndStation = getUserInputEndStation(scanner, userInputStartStation);
        if(userInputEndStation.equals(INVALID_INPUT)) {
            return false;
        }
        if(!findShortestDistancePath(userInputStartStation, userInputEndStation)){
            return false;
        }
        return true;
    }

    private static boolean findShortestTime(Scanner scanner) {

        return true;
    }

    private static String getUserInputStartStation(Scanner scanner) {
        RouteFindOutputView.printStartStationInstruction();
        String userInputStartStation = InputView.getInput(scanner);
        if(!RouteFindValidation.checkValidStartStation(userInputStartStation)) {
            return INVALID_INPUT;
        }
        return userInputStartStation;
    }

    private static String getUserInputEndStation(Scanner scanner, String userInputStartStation) {
        RouteFindOutputView.printEndStationInstruction();
        String userInputEndStation = InputView.getInput(scanner);
        if(!RouteFindValidation.checkValidEndStation(userInputStartStation, userInputEndStation)) {
            return INVALID_INPUT;
        }
        return userInputEndStation;
    }

    private static boolean findShortestDistancePath(String userInputStartStation, String userInputEndStation) {
        Station source = StationRepository.getStationByName(userInputStartStation);
        Station destination = StationRepository.getStationByName(userInputEndStation);
        RouteFindOutputView.printPathResult();
        List<Station> shortestPath = DistanceGraphRepository.findShortestPath(source, destination);
        if(!RouteFindValidation.checkValidPath(shortestPath)) {
            return false;
        }
        RouteFindInformationView.printRouteInformation(shortestPath);
        return true;
    }
}
