package subway.domain;

import subway.view.InputView;

import java.util.Scanner;

public class MainMenu {

    private static boolean isMainRunFlag = true;

    private static void mainStop() {
        isMainRunFlag = false;
    }

    public static boolean isMainRunning() {
        return isMainRunFlag;
    }

    public static void mainRun(Scanner scanner) {
        try {
            InputView.printMainInput();
        } catch (IllegalArgumentException e) {

        }
    }
}
