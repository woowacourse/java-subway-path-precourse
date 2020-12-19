package subway.controller;

import java.util.Objects;
import subway.functionList.MainFunction;
import subway.message.CommonMessage;
import subway.screen.ControlScreen;
import subway.validation.MainValidator;
import subway.view.UserView;

public class MainController {

    private static boolean isQuit(String menuNumber) {
        return Objects.equals(MainFunction.QUIT.getCode(), menuNumber);
    }

    public static void run() {
        UserView.displayScreen(ControlScreen.MAIN);
        UserView.guideMessagePrint(CommonMessage.SELECT_FUNCTION);

        try {
            String menuNumber = MainValidator.validMainMenu(UserView.scanUserInput());
            if (isQuit(menuNumber)) {
                return;
            }
            MainFunction.runNext(menuNumber);
            MainController.run();
        } catch (IllegalArgumentException error) {
            UserView.errorDirectPrint(error);
        }


    }

    public static void back() {
        // done
    }


}
