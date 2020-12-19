package subway.controller;

import subway.message.CommonMessage;
import subway.screen.ControlScreen;
import subway.validation.MainValidator;
import subway.view.UserView;

public class MainController {

    public static void run() {
        UserView.displayScreen(ControlScreen.MAIN);
        UserView.guideMessagePrint(CommonMessage.SELECT_FUNCTION); // 원하는 기능을 선택하세요 문구 출력

        String menuNumber = MainValidator.validMainMenu(UserView.scanUserInput());


    }

    public static void back(){
        // done
    }
}
