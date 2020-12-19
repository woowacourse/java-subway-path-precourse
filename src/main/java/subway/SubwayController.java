package subway;

import subway.model.PathFinder;
import subway.model.SubwayInit;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class SubwayController {
    InputView inputView;
    OutputView outputView;

    public SubwayController(Scanner scanner) {
        this.inputView = new InputView(scanner);
        this.outputView = new OutputView();
        new SubwayInit();
    }

    public void startManager() {
        outputView.mainView();
        outputView.getUserOption();
        String option = inputView.userInput();
        routeMainOption(option);
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
        routePathFindOption(option);
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
        String start = stationInput[0];
        String arrive = stationInput[1];
        List<String> result = PathFinder.getShortestPathByDistance(start, arrive);
        int totalDistance = PathFinder.getTotalDistance(result);
        int totalTime = PathFinder.getTotalTime(result);
        showResult(result, totalDistance, totalTime);
    }

    private void pathFindByTime() {
        outputView.getUserStart();
        String start = inputView.userInput();
        outputView.getUserArrive();
        String arrive = inputView.userInput();
        List<String> result = PathFinder.getShortestPathByTime(start, arrive);
        int totalDistance = PathFinder.getTotalDistance(result);
        int totalTime = PathFinder.getTotalTime(result);
        showResult(result, totalDistance, totalTime);
    }

    private String[] getStationInput() {
        outputView.getUserStart();
        String start = inputView.userInput();
        outputView.getUserArrive();
        String arrive = inputView.userInput();
        return new String[]{ start, arrive };
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
