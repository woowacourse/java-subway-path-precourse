package subway;

import java.util.Arrays;
import java.util.List;
import subway.domain.Station;

public class UserInterfaceView {


    private static final int ZERO = 0;
    private static final String STR_ONE = "1";
    private static final String STR_TWO = "2";
    private static final String Q = "Q";
    private static final String B = "B";
    private static final String[] MAIN_CHOICE_LIST = {STR_ONE, Q};
    private static final String[] ROUTE_SEARCH_CHOICE_LIST = {STR_ONE, STR_TWO, B};

    public UserInterfaceView() {
    }

    public void start() {
        while (true) {
            if (printMainViewAndReturnIsEnd()) {
                break;
            }
        }
    }

    private boolean printMainViewAndReturnIsEnd() {
        Output.printMainView();
        String userInput = Input.getUserInput(Output.YOU_CHOICE);
        if (!Arrays.asList(MAIN_CHOICE_LIST).contains((userInput))) {
            Output.printChoiceErrorMessage();
            return false;
        }
        if (Q.equals(userInput)) {
            return true;
        }
        mainToNextFunction(userInput);
        return false;
    }

    private void mainToNextFunction(String userInput) {
        if (STR_ONE.equals(userInput)) {
            routeSearch();
        }
    }

    private void routeSearch() {
        Output.printRouteSearchView();
        String userInput = Input.getUserInput(Output.YOU_CHOICE);
        if (!Arrays.asList(ROUTE_SEARCH_CHOICE_LIST).contains((userInput))) {
            Output.printChoiceErrorMessage();
            return;
        }
        if (B.equals(userInput)) {
            routeSearch();
            return;
        }
        routeSearchToNextFunction(userInput);
    }

    private void routeSearchToNextFunction(String userInput) {
        String startStation = Input.getUserInput(Output.START_STATION);
        String endStation = Input.getUserInput(Output.END_STATION);
        if (startStation.equals(endStation)) {
            Output.printStationEqualsError();
            routeSearch();
            return;
        }
        // TODO - 역이 존재하지 않을때 처리, 역끼리 연결이 안되어있을때 처리
        if (STR_ONE.equals(userInput)) {
            findMinDistance(startStation, endStation);
        }
        if (STR_TWO.equals(userInput)) {
            findShortTime(startStation, endStation);
        }
    }

    private void findMinDistance(String startStation, String endStation) {
        List<String> path = GraphService.getMinDistancePath(startStation, endStation);
        sumDistanceAndTimeAndPrint(path);
    }

    private void sumDistanceAndTimeAndPrint(List<String> path) {
        int distance = ZERO;
        int time = ZERO;
        int findMaxSize = path.size() - 1;
        for (int sourceIndex = ZERO; sourceIndex < findMaxSize; sourceIndex++) {
            int targetIndex = sourceIndex + 1;
            int[] data= StationService.getDistanceAndTime(path.get(sourceIndex), path.get(targetIndex));
            distance += data[Station.DISTANCE_INDEX];
            time += data[Station.TIME_INDEX];
        }
        Output.printInfo(distance, time, path);
    }

    private void findShortTime(String startStation, String endStation) {
        List<String> path = GraphService.getShortTimePath(startStation, endStation);
        sumDistanceAndTimeAndPrint(path);
    }
}
