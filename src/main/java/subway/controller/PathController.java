package subway.controller;

import subway.service.PathService;
import subway.view.OutputView;

public class PathController {

    private static final Boolean BACK_TO_MAIN_SCREEN = false;
    private static final Boolean RETRY = true;

    public static Boolean searchPathByShortestDistance(String departureStationName,
        String arrivalStationName) {
        try{
            PathService.searchShortestDistance(departureStationName,arrivalStationName);
            return BACK_TO_MAIN_SCREEN;
        }catch(Exception e){
            OutputView.print(e.getMessage());
            return RETRY;
        }
    }

    public static Boolean searchPathByMinimumTime(String departureStationName,
        String arrivalStationName) {
        try{
            PathService.searchMinimumTime(departureStationName,arrivalStationName);
            return BACK_TO_MAIN_SCREEN;
        }catch(Exception e){
            OutputView.print(e.getMessage());
            return RETRY;
        }
    }
}
