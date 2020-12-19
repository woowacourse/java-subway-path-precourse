package subway.controller;

import java.util.List;
import java.util.Objects;
import subway.functionList.RouteFunction;
import subway.message.CommonMessage;
import subway.message.RouteMessage;
import subway.screen.ControlScreen;
import subway.utils.GetPath;
import subway.validation.RouteValidator;
import subway.view.UserView;

public class RouteController {

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


        List<String> tmp = GetPath.getDijkstraShortestPath(startStation, endStation);
    }

    public static void findShortestTime() {
    }
}
