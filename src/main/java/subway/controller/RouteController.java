package subway.controller;

import java.util.Objects;
import subway.domain.SectionRepository;
import subway.functionList.RouteFunction;
import subway.message.CommonMessage;
import subway.screen.ControlScreen;
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
        String startStation = UserView.scanUserInput();
        String endStation = UserView.scanUserInput();

        SectionRepository.findShortestDistance(startStation,endStation);
    }

    public static void findShortestTime() {
    }
}
