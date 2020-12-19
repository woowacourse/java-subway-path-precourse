package subway.controller;

import java.util.List;
import java.util.Objects;
import subway.domain.SectionRepository;
import subway.functionList.RouteFunction;
import subway.message.CommonMessage;
import subway.message.RouteMessage;
import subway.screen.ControlScreen;
import subway.utils.GetPath;
import subway.validation.RouteValidator;
import subway.view.UserView;

public class RouteController {
    static final int startIValue = 0;
    private static boolean isBack(String menuNumber) {
        return Objects.equals(RouteFunction.BACK.getCode(), menuNumber);
    }

    public static void run() {
        UserView.displayScreen(ControlScreen.ROUTE_MANAGEMENT);
        UserView.guideMessagePrint(CommonMessage.SELECT_FUNCTION);
        try {
            String menuNumber = RouteValidator.validRouteMenu(UserView.scanUserInput());
            if (isBack(menuNumber)) {
                return;
            }
            RouteFunction.runNext(menuNumber);
        } catch (IllegalArgumentException error) {
            UserView.errorDirectPrint(error);
            RouteController.run();
        }
    }


    public static void back() {
        // done
    }

    public static void findShortestDistance() {
        UserView.guideMessagePrint(RouteMessage.SELECT_START_STATION);
        String startStation = RouteValidator.validStationName(UserView.scanUserInput());

        UserView.guideMessagePrint(RouteMessage.SELECT_END_STATION);
        String endStation = RouteValidator.validStationName(UserView.scanUserInput());

        RouteValidator.validStationsName(startStation, endStation);
        List<String> path = GetPath.getShortestDistance(startStation, endStation);
        int weight = GetPath.getShortestDistanceWeight(startStation, endStation);

        UserView.printDistanceResult(path, weight);
    }

    public static void findShortestTime() {
        UserView.guideMessagePrint(RouteMessage.SELECT_START_STATION);
        String startStation = RouteValidator.validStationName(UserView.scanUserInput());

        UserView.guideMessagePrint(RouteMessage.SELECT_END_STATION);
        String endStation = RouteValidator.validStationName(UserView.scanUserInput());

        RouteValidator.validStationsName(startStation, endStation);
        List<String> path = GetPath.getShortestTime(startStation, endStation);
        int weight = GetPath.getShortestTimeWeight(startStation, endStation);

        UserView.printTimeResult(path, weight);
    }

    public static int sumTime(List<String> pathList){
        int sumValue = startIValue;
        for(int i=startIValue;i<pathList.size()-1;i++){
            String upStation = pathList.get(i);
            String downStation = pathList.get(i+1);
            sumValue += SectionRepository.getSectionValue(upStation,downStation);
        }
        return sumValue;
    }
}
