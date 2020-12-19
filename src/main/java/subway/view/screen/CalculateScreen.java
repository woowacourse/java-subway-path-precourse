package subway.view.screen;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class CalculateScreen {
    private static final String SCREEN_NAME = "경로 기준";
    private static final String FUNCTION_LIST = "1. 최단 거리\n" +
            "2. 최소 시간\n" +
            "B. 돌아가기";

    public static void interact(Scanner scanner) {
        OutputView.printGuide(SCREEN_NAME);
        OutputView.print(FUNCTION_LIST);
        String command = InputView.inputFunction(scanner);

    }
}
