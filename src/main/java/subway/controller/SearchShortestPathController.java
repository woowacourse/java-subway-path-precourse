package subway.controller;

import subway.domain.weight.WeightType;
import subway.view.OutputView;

public class SearchShortestPathController {
    public static void SearchShortestDistancePath() {
        try {
            tryToSearchShortestPath(WeightType.DISTANCE);
        } catch (Exception exception) {
            catchError(exception);
        }
    }

    public static void SearchShortestTimePath() {
        try {
            tryToSearchShortestPath(WeightType.TIME);
        } catch (Exception exception) {
            catchError(exception);
        }
    }

    private static void tryToSearchShortestPath(WeightType type) {

    }
    
    private static void catchError(Exception exception) {
        OutputView.printError(exception);
        MenuController.callMainMenu();
    }
}
