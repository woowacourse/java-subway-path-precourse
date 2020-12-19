package subway;

import subway.domain.data.Station;
import subway.domain.data.StationRepository;
import subway.menu.MainMenu;
import subway.menu.PathRuleMenu;
import subway.utils.PathFinder;
import subway.utils.Validator;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubwayPath {

    private Scanner scanner;

    public SubwayPath(Scanner scanner) {
        this.scanner = scanner;
        InitData.initData();
        run();
    }

    private void run() {
        while(true) {
            OutputView.printMainView();
            String mainOrder = selectMenu();

            if (mainOrder.equalsIgnoreCase(MainMenu.END.getOrder())) {
                return;
            }

            findPath(mainOrder);
        }
    }

    private void findPath(String mainOrder) {
        try {
            String pathRuleOrder = selectPathRuleMenu();
            String startingStation = getStationName(Station.POINT.STARTING);
            String endingStation = getStationName(Station.POINT.ENDING);
            Validator.checkValidStationPoint(startingStation, endingStation);
            getResult(pathRuleOrder, startingStation, endingStation);
        } catch (IllegalArgumentException e){
            OutputView.printError(e.getMessage());
            findPath(mainOrder);
            return;
        }
    }

    private void getResult(String pathRuleOrder, String startingStation, String endingStation) {
        PathFinder pathFinder = new PathFinder();
        List<String> pathList = new ArrayList<>();
        double pathWeight = 0;
        if(pathRuleOrder.equals(PathRuleMenu.MINIMUM_DISTANCE.getOrder())){
            pathList = pathFinder.getShortestDistanceList(startingStation, endingStation);
            pathWeight = pathFinder.getShortestDistanceWeight(startingStation, endingStation);
            OutputView.printResult(pathList, pathWeight);
        }
        if(pathRuleOrder.equals(PathRuleMenu.MINIMUM_TIME.getOrder())){
            System.out.println("\n코드 작성 중..");
        }


    }

    private String getStationName(Station.POINT point){
        try {
            OutputView.printAskingStation(point);
            return InputView.getStationName(scanner);
        } catch (IllegalArgumentException e){
            OutputView.printError(e.getMessage());
            return getStationName(point);
        }
    }

    private String selectPathRuleMenu() {
        try {
            OutputView.printPathRuleView();
            OutputView.printAskingFunction();
            return InputView.getPathRuleMenu(scanner);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return selectPathRuleMenu();
        }
    }

    private String selectMenu() {
        try {
            OutputView.printAskingFunction();
            return InputView.getMainMenu(scanner);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return selectMenu();
        }
    }

}
