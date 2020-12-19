package subway.Controller;

import subway.view.OutputView;

public class MainController {
    private static boolean runFlag;

    public static void run() {
        runFlag = true;
        while (runFlag) {
            OutputView.printMainMenu();
        }
    }

    public static void terminate() {
        runFlag = false;
    }
}
