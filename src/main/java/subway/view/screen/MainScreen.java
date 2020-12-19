package subway.view.screen;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class MainScreen {
    private static final String SCREEN_NAME = "메인 화면";
    private static final String FUNCTION_LIST = "1. 경로 조회\n" +
            "Q. 종료";

    public static String getFunction(Scanner scanner) {
        OutputView.printGuide(SCREEN_NAME);
        OutputView.print(FUNCTION_LIST);
        return InputView.inputFunction(scanner);
    }
}
