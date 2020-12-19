package subway.controller;

import java.util.Objects;
import subway.functionList.MainFunction;
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
        while (true) {
            UserView.displayScreen(ControlScreen.ROUTE_MANAGEMENT);
            UserView.guideMessagePrint(CommonMessage.SELECT_FUNCTION);

            try {
                String menuNumber = RouteValidator.validRouteMenu(UserView.scanUserInput());
                if (isBack(menuNumber)) {
                    return;
                }
                MainFunction.runNext(menuNumber);
            } catch (IllegalArgumentException error) {
                UserView.errorDirectPrint(error);
            }
        }
    }

    public static void back() {
        // done
    }

    public static void findShortestDistance() {
    }

    public static void findShortestTime() {
    }
}
