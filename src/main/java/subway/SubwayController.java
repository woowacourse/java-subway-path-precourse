package subway;

import subway.exception.SubwayException;
import subway.exception.Validation;
import subway.model.PathFinder;
import subway.model.SubwayInit;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class SubwayController {
    InputView inputView;
    OutputView outputView;
    Validation validation;

    public SubwayController(Scanner scanner) {
        this.inputView = new InputView(scanner);
        this.outputView = new OutputView();
        this.validation = new Validation();
        new SubwayInit();
    }

    public void startManager() {
        outputView.mainView();
        outputView.getUserOption();
        String option = inputView.userInput();
        try {
            validation.mainOptionValidation(option);
            routeMainOption(option);
        } catch (SubwayException e) {
            startManager();
        }
    }

    private void routeMainOption(String option) {
        if (option.equals("1")) {
            startPathFind();
        }
        if (option.equals("Q")) {
            return;
        }
    }

    public void startPathFind() {
        outputView.mapView();
        outputView.getUserOption();
        String option = inputView.userInput();
        try {
            validation.pathFindOptionValidation(option);
            routePathFindOption(option);
        } catch (SubwayException e) {
            startPathFind();
        }
    }

    private void routePathFindOption(String option) {
        if (option.equals("1")) {
            pathFindByDistance();
        }
        if (option.equals("2")) {
            pathFindByTime();
        }
        startManager();
    }

    private void pathFindByDistance() {
        String[] stationInput = getStationInput();
        if (stationInput != null) {
            String start = stationInput[0];
            String arrive = stationInput[1];
            try {
                List<String> result = PathFinder.getShortestPathByDistance(start, arrive);
                int totalDistance = PathFinder.getTotalDistance(result);
                int totalTime = PathFinder.getTotalTime(result);
                showResult(result, totalDistance, totalTime);
            } catch (IllegalArgumentException e) {
                outputView.printError();
            }
        }
    }

    private void pathFindByTime() {
        String[] stationInput = getStationInput();
        if (stationInput != null) {
            String start = stationInput[0];
            String arrive = stationInput[1];
            try {
                List<String> result = PathFinder.getShortestPathByTime(start, arrive);
                int totalDistance = PathFinder.getTotalDistance(result);
                int totalTime = PathFinder.getTotalTime(result);
                showResult(result, totalDistance, totalTime);
            } catch (IllegalArgumentException e) {
                outputView.printError();
            }
        }
    }

    private String[] getStationInput() {
        String start = getStartStation();
        if (start == null) {
            return null;
        }
        String arrive = getArriveStation();
        if (arrive == null) {
            return null;
        }
        try {
            validation.isSameStation(start, arrive);
        } catch (SubwayException e) {
            return null;
        }
        return new String[]{ start, arrive };
    }

    private String getStartStation() {
        try {
            outputView.getUserStart();
            String input = inputView.userInput();
            validation.isExistStation(input);
            return input;
        } catch (SubwayException e) {
            return null;
        }
    }

    private String getArriveStation() {
        try {
            outputView.getUserArrive();
            String input = inputView.userInput();
            validation.isExistStation(input);
            return input;
        } catch (SubwayException e) {
            return null;
        }
    }

    private void showResult(List<String> shortestPath, int totalDistance, int totalTime) {
        outputView.printResult();
        outputView.printDivide();
        outputView.printTotalDistance(totalDistance);
        outputView.printTotalTime(totalTime);
        outputView.printDivide();
        outputView.printShortestPath(shortestPath);
    }
}
